package org.caohh.albol.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ArticleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    public static final Article article = new Article();

    /**
     * Database Column Remarks:
     *   ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.id")
    public static final SqlColumn<Long> id = article.id;

    /**
     * Database Column Remarks:
     *   名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.name")
    public static final SqlColumn<String> name = article.name;

    /**
     * Database Column Remarks:
     *   标签
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.category")
    public static final SqlColumn<String> category = article.category;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.created_time")
    public static final SqlColumn<Date> createdTime = article.createdTime;

    /**
     * Database Column Remarks:
     *   内容
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.content")
    public static final SqlColumn<String> content = article.content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: article")
    public static final class Article extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<String> category = column("category", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTime = column("created_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> content = column("content", JDBCType.LONGVARCHAR);

        public Article() {
            super("article");
        }
    }
}