package org.caohh.albol.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    public static final Role role = new Role();

    /**
     * Database Column Remarks:
     *   ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role.id")
    public static final SqlColumn<Long> id = role.id;

    /**
     * Database Column Remarks:
     *   名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role.name")
    public static final SqlColumn<String> name = role.name;

    /**
     * Database Column Remarks:
     *   描述
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role.desc")
    public static final SqlColumn<String> desc = role.desc;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: role.created_time")
    public static final SqlColumn<Date> createdTime = role.createdTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: role")
    public static final class Role extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<String> desc = column("`desc`", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTime = column("created_time", JDBCType.TIMESTAMP);

        public Role() {
            super("role");
        }
    }
}