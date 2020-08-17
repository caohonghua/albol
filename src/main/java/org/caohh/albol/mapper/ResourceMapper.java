package org.caohh.albol.mapper;

import static org.caohh.albol.mapper.ResourceDynamicSqlSupport.*;
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
import org.caohh.albol.model.Resource;
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
public interface ResourceMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, link, pid, createdTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Resource> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ResourceResult")
    Optional<Resource> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ResourceResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Resource> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default int insert(Resource record) {
        return MyBatis3Utils.insert(this::insert, record, resource, c ->
            c.map(name).toProperty("name")
            .map(link).toProperty("link")
            .map(pid).toProperty("pid")
            .map(createdTime).toProperty("createdTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default int insertSelective(Resource record) {
        return MyBatis3Utils.insert(this::insert, record, resource, c ->
            c.map(name).toPropertyWhenPresent("name", record::getName)
            .map(link).toPropertyWhenPresent("link", record::getLink)
            .map(pid).toPropertyWhenPresent("pid", record::getPid)
            .map(createdTime).toPropertyWhenPresent("createdTime", record::getCreatedTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default Optional<Resource> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default List<Resource> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default List<Resource> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default Optional<Resource> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, resource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    static UpdateDSL<UpdateModel> updateAllColumns(Resource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(record::getName)
                .set(link).equalTo(record::getLink)
                .set(pid).equalTo(record::getPid)
                .set(createdTime).equalTo(record::getCreatedTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Resource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(record::getName)
                .set(link).equalToWhenPresent(record::getLink)
                .set(pid).equalToWhenPresent(record::getPid)
                .set(createdTime).equalToWhenPresent(record::getCreatedTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default int updateByPrimaryKey(Resource record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(link).equalTo(record::getLink)
            .set(pid).equalTo(record::getPid)
            .set(createdTime).equalTo(record::getCreatedTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    default int updateByPrimaryKeySelective(Resource record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(link).equalToWhenPresent(record::getLink)
            .set(pid).equalToWhenPresent(record::getPid)
            .set(createdTime).equalToWhenPresent(record::getCreatedTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}