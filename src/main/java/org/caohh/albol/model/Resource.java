package org.caohh.albol.model;

import java.util.Date;
import javax.annotation.Generated;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table resource
 */
public class Resource {
    /**
     * Database Column Remarks:
     *   ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.id")
    private Long id;

    /**
     * Database Column Remarks:
     *   名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.name")
    private String name;

    /**
     * Database Column Remarks:
     *   链接
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.link")
    private String link;

    /**
     * Database Column Remarks:
     *   父ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.pid")
    private Long pid;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.created_time")
    private Date createdTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.link")
    public String getLink() {
        return link;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.link")
    public void setLink(String link) {
        this.link = link;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.pid")
    public Long getPid() {
        return pid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.pid")
    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.created_time")
    public Date getCreatedTime() {
        return createdTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: resource.created_time")
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}