package org.caohh.albol.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.caohh.albol.mapper.ResourceDynamicSqlSupport;
import org.caohh.albol.mapper.ResourceMapper;
import org.caohh.albol.service.ResourceService;
import org.caohh.albol.vo.Resource;
import org.caohh.albol.vo.Result;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.where.WhereApplier;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.caohh.albol.mapper.ResourceDynamicSqlSupport.*;

@Slf4j
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Result search(Resource resource) {
        Result result;
        try {
            WhereApplier whereApplier = abstractWhereDSL ->
                    abstractWhereDSL.where(name, isEqualToWhenPresent(resource.getName()))
                            .and(link, isEqualToWhenPresent(resource.getLink()))
                            .and(pid, isEqualToWhenPresent(resource.getPid()));
            SelectStatementProvider provider;
            long offset = resource.offset();
            if (offset >= resource.getMaxOffset()) {
                provider = select(resourceMapper.selectList).from(ResourceDynamicSqlSupport.resource)
                        .where(id, isGreaterThanOrEqualTo(
                                select(id).from(ResourceDynamicSqlSupport.resource).applyWhere(whereApplier)
                                        .limit(1).offset(offset)
                        )).limit(resource.getPageSize()).build().render(RenderingStrategies.MYBATIS3);
            } else {
                provider = select(resourceMapper.selectList).from(ResourceDynamicSqlSupport.resource)
                        .applyWhere(whereApplier).limit(resource.getPageSize()).offset(offset)
                        .build().render(RenderingStrategies.MYBATIS3);
            }
            result = new Result(Result.Code.SUCCESS, resourceMapper.selectMany(provider));
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "search fail");
        }
        return result;
    }

    @Override
    public Result save(Resource resource) {
        Result result;
        try {
            org.caohh.albol.model.Resource record = new org.caohh.albol.model.Resource();
            BeanUtils.copyProperties(resource, record);
            result = new Result(Result.Code.SUCCESS, resourceMapper.insertSelective(record) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "save fail");
        }
        return result;
    }

    @Override
    public Result delete(Long id) {
        Result result;
        try {
            result = new Result(Result.Code.SUCCESS, resourceMapper.deleteByPrimaryKey(id) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "delete fail");
        }
        return result;
    }

    @Override
    public Result update(Resource resource) {
        Result result;
        try {
            org.caohh.albol.model.Resource record = new org.caohh.albol.model.Resource();
            BeanUtils.copyProperties(resource, record);
            result = new Result(Result.Code.SUCCESS, resourceMapper.updateByPrimaryKeySelective(record) > 0);
        } catch (Exception e) {
            log.error("", e);
            result = new Result(Result.Code.FAIL, "update fail");
        }
        return result;
    }
}
