package org.caohh.albol.mapper;

import static org.caohh.albol.mapper.RoleResourceDynamicSqlSupport.*;
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
import org.caohh.albol.model.RoleResource;
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
public interface RoleResourceMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    BasicColumn[] selectList = BasicColumn.columnList(id, roleId, resourceId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<RoleResource> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RoleResourceResult")
    Optional<RoleResource> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RoleResourceResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.BIGINT)
    })
    List<RoleResource> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default int insert(RoleResource record) {
        return MyBatis3Utils.insert(this::insert, record, roleResource, c ->
            c.map(roleId).toProperty("roleId")
            .map(resourceId).toProperty("resourceId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default int insertSelective(RoleResource record) {
        return MyBatis3Utils.insert(this::insert, record, roleResource, c ->
            c.map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(resourceId).toPropertyWhenPresent("resourceId", record::getResourceId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default Optional<RoleResource> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default List<RoleResource> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default List<RoleResource> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default Optional<RoleResource> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, roleResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    static UpdateDSL<UpdateModel> updateAllColumns(RoleResource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleId).equalTo(record::getRoleId)
                .set(resourceId).equalTo(record::getResourceId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RoleResource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roleId).equalToWhenPresent(record::getRoleId)
                .set(resourceId).equalToWhenPresent(record::getResourceId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default int updateByPrimaryKey(RoleResource record) {
        return update(c ->
            c.set(roleId).equalTo(record::getRoleId)
            .set(resourceId).equalTo(record::getResourceId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    default int updateByPrimaryKeySelective(RoleResource record) {
        return update(c ->
            c.set(roleId).equalToWhenPresent(record::getRoleId)
            .set(resourceId).equalToWhenPresent(record::getResourceId)
            .where(id, isEqualTo(record::getId))
        );
    }
}