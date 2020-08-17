package org.caohh.albol.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ResourceDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    public static final Resource resource = new Resource();

    /**
     * Database Column Remarks:
     *   ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.id")
    public static final SqlColumn<Long> id = resource.id;

    /**
     * Database Column Remarks:
     *   名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.name")
    public static final SqlColumn<String> name = resource.name;

    /**
     * Database Column Remarks:
     *   链接
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.link")
    public static final SqlColumn<String> link = resource.link;

    /**
     * Database Column Remarks:
     *   父ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.pid")
    public static final SqlColumn<Long> pid = resource.pid;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.created_time")
    public static final SqlColumn<Date> createdTime = resource.createdTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: resource")
    public static final class Resource extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<String> link = column("link", JDBCType.VARCHAR);

        public final SqlColumn<Long> pid = column("pid", JDBCType.BIGINT);

        public final SqlColumn<Date> createdTime = column("created_time", JDBCType.TIMESTAMP);

        public Resource() {
            super("resource");
        }
    }
}