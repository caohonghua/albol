package org.caohh.albol.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleResourceDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    public static final RoleResource roleResource = new RoleResource();

    /**
     * Database Column Remarks:
     *   ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role_resource.id")
    public static final SqlColumn<Long> id = roleResource.id;

    /**
     * Database Column Remarks:
     *   角色ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role_resource.role_id")
    public static final SqlColumn<Long> roleId = roleResource.roleId;

    /**
     * Database Column Remarks:
     *   资源ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role_resource.resource_id")
    public static final SqlColumn<Long> resourceId = roleResource.resourceId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role_resource")
    public static final class RoleResource extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> resourceId = column("resource_id", JDBCType.BIGINT);

        public RoleResource() {
            super("role_resource");
        }
    }
}