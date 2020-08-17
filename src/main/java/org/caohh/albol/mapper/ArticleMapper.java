package org.caohh.albol.mapper;

import static org.caohh.albol.mapper.ArticleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.caohh.albol.model.Article;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ArticleMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, category, createdTime, content);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Article> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArticleResult")
    Optional<Article> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArticleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Article> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, article, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, article, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default int insert(Article record) {
        return MyBatis3Utils.insert(this::insert, record, article, c ->
            c.map(name).toProperty("name")
            .map(category).toProperty("category")
            .map(createdTime).toProperty("createdTime")
            .map(content).toProperty("content")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default int insertSelective(Article record) {
        return MyBatis3Utils.insert(this::insert, record, article, c ->
            c.map(name).toPropertyWhenPresent("name", record::getName)
            .map(category).toPropertyWhenPresent("category", record::getCategory)
            .map(createdTime).toPropertyWhenPresent("createdTime", record::getCreatedTime)
            .map(content).toPropertyWhenPresent("content", record::getContent)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default Optional<Article> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, article, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default List<Article> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, article, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default List<Article> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, article, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default Optional<Article> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, article, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    static UpdateDSL<UpdateModel> updateAllColumns(Article record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(record::getName)
                .set(category).equalTo(record::getCategory)
                .set(createdTime).equalTo(record::getCreatedTime)
                .set(content).equalTo(record::getContent);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Article record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(record::getName)
                .set(category).equalToWhenPresent(record::getCategory)
                .set(createdTime).equalToWhenPresent(record::getCreatedTime)
                .set(content).equalToWhenPresent(record::getContent);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default int updateByPrimaryKey(Article record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(category).equalTo(record::getCategory)
            .set(createdTime).equalTo(record::getCreatedTime)
            .set(content).equalTo(record::getContent)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    default int updateByPrimaryKeySelective(Article record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(category).equalToWhenPresent(record::getCategory)
            .set(createdTime).equalToWhenPresent(record::getCreatedTime)
            .set(content).equalToWhenPresent(record::getContent)
            .where(id, isEqualTo(record::getId))
        );
    }
}