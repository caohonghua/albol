package org.caohh.albol.model;

import java.util.Date;
import javax.annotation.Generated;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table article
 */
public class Article {
    /**
     * Database Column Remarks:
     *   ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.id")
    private Long id;

    /**
     * Database Column Remarks:
     *   名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.name")
    private String name;

    /**
     * Database Column Remarks:
     *   标签
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.category")
    private String category;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.created_time")
    private Date createdTime;

    /**
     * Database Column Remarks:
     *   内容
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.content")
    private String content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.category")
    public String getCategory() {
        return category;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.category")
    public void setCategory(String category) {
        this.category = category;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.created_time")
    public Date getCreatedTime() {
        return createdTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.created_time")
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.content")
    public String getContent() {
        return content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: article.content")
    public void setContent(String content) {
        this.content = content;
    }
}