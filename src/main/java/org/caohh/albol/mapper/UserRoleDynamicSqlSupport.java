package org.caohh.albol.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserRoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_role")
    public static final UserRole userRole = new UserRole();

    /**
     * Database Column Remarks:
     *   ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_role.id")
    public static final SqlColumn<Long> id = userRole.id;

    /**
     * Database Column Remarks:
     *   用户ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_role.user_id")
    public static final SqlColumn<Long> userId = userRole.userId;

    /**
     * Database Column Remarks:
     *   角色ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user_role.role_id")
    public static final SqlColumn<Long> roleId = userRole.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user_role")
    public static final class UserRole extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public UserRole() {
            super("user_role");
        }
    }
}