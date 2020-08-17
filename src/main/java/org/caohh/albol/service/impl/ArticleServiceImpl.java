package org.caohh.albol.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.caohh.albol.mapper.ArticleDynamicSqlSupport;
import org.caohh.albol.mapper.ArticleMapper;
import org.caohh.albol.service.ArticleService;
import org.caohh.albol.vo.Article;
import org.caohh.albol.vo.Result;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.where.WhereApplier;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result save(Article article) {
        Result result;
        try {
            org.caohh.albol.model.Article record = new org.caohh.albol.model.Article();
            BeanUtils.copyProperties(article, record);
            if (Objects.nonNull(article.getId())) {
                result = new Result(Result.Code.SUCCESS, articleMapper.updateByPrimaryKeySelective(record) > 0);
            } else {
                result = new Result(Result.Code.SUCCESS, articleMapper.insertSelective(record) > 0);
            }
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "save fail");
        }
        return result;
    }

    @Override
    public Result search(Article article) {
        Result result;
        try {
            Map<String, Object> map = new HashMap<>(2);
            String search = StringUtils.isEmpty(article.getSearch()) ? null : "%" + article.getSearch() + "%";
            WhereApplier whereApplier = abstractWhereDSL ->
                    abstractWhereDSL.where(ArticleDynamicSqlSupport.name,
                            isLikeCaseInsensitiveWhenPresent(search))
                            .or(ArticleDynamicSqlSupport.category, isLikeCaseInsensitiveWhenPresent(search));
            SelectStatementProvider countProvider =
                    countFrom(ArticleDynamicSqlSupport.article)
                    .applyWhere(whereApplier).build().render(RenderingStrategies.MYBATIS3);
            long total = articleMapper.count(countProvider);
            map.put("total", total);
            SelectStatementProvider provider;
            long offset = article.offset();
            if (offset >= article.getMaxOffset()) {
                provider = select(articleMapper.selectList)
                        .from(ArticleDynamicSqlSupport.article)
                        .where(ArticleDynamicSqlSupport.id, isGreaterThanOrEqualTo(
                                select(ArticleDynamicSqlSupport.id).from(ArticleDynamicSqlSupport.article).applyWhere(whereApplier)
                                        .orderBy(ArticleDynamicSqlSupport.createdTime.descending())
                                        .limit(1).offset(offset)))
                        .limit(article.getPageSize()).build().render(RenderingStrategies.MYBATIS3);
            } else {
                provider = select(articleMapper.selectList)
                        .from(ArticleDynamicSqlSupport.article)
                        .applyWhere(whereApplier)
                        .orderBy(ArticleDynamicSqlSupport.createdTime.descending())
                        .limit(article.getPageSize())
                        .offset(offset).build().render(RenderingStrategies.MYBATIS3);
            }
            map.put("articles", articleMapper.selectMany(provider));
            result = new Result(Result.Code.SUCCESS, map);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "search fail");
        }
        return result;
    }

    @Override
    public Result delete(Long id) {
        Result result;
        try {
            result = new Result(Result.Code.SUCCESS, articleMapper.deleteByPrimaryKey(id) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "delete fail");
        }
        return result;
    }
}
