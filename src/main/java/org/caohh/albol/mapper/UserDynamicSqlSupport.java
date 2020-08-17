package org.caohh.albol.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final User user = new User();

    /**
     * Database Column Remarks:
     *   ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.id")
    public static final SqlColumn<Long> id = user.id;

    /**
     * Database Column Remarks:
     *   账号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.name")
    public static final SqlColumn<String> name = user.name;

    /**
     * Database Column Remarks:
     *   密码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.password")
    public static final SqlColumn<String> password = user.password;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.created_time")
    public static final SqlColumn<Date> createdTime = user.createdTime;

    /**
     * Database Column Remarks:
     *   昵称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.username")
    public static final SqlColumn<String> username = user.username;

    /**
     * Database Column Remarks:
     *   头像
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.avatar")
    public static final SqlColumn<String> avatar = user.avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final class User extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("`password`", JDBCType.CHAR);

        public final SqlColumn<Date> createdTime = column("created_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public User() {
            super("user");
        }
    }
}