package com.amayadream.shiro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 组织实体
 *
 * @author :  Amayadream
 * @date :  2016.07.02 10:46
 */
@Document(collection = "db_organization")
@Repository(value = "organization")
public class Organization implements Serializable {

    /**
     * 组织编号
     */
    @Id
    private String organId;
    /**
     * 组织名称
     */
    private String organName;
    /**
     * 父节点
     */
    private String parentId;
    /**
     * 父节点列表
     */
    private String parentIds;
    /**
     * 状态, 1:正常, -1:停用
     */
    private int state;

    /**
     * 将自己设为父节点
     */
    public String makeSelfAsParentIds() {
        return getParentIds() + getOrganId() + "/";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        if (organId != null ? !organId.equals(that.organId) : that.organId != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return organId != null ? organId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organId='" + organId + '\'' +
                ", organName='" + organName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentIds='" + parentIds + '\'' +
                ", state=" + state +
                '}';
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
