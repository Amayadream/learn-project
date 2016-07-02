package com.amayadream.shiro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 资源实体
 *
 * @author :  Amayadream
 * @date :  2016.07.02 10:45
 */
@Document(collection = "db_resource")
@Repository(value = "resource")
public class Resource implements Serializable {

    /**
     * 资源编号
     */
    @Id
    private String resourceId;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 资源类型
     */
    private String resourceType;
    /**
     * 资源路径
     */
    private String url;
    /**
     * 权限字符串
     */
    private String permission;
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


    public String makeSelfAsParentIds() {
        return getParentIds() + getResourceId() + "/";
    }

    public boolean isRootNode() {
        return "0".equals(parentId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (resourceId != null ? !resourceId.equals(resource.resourceId) : resource.resourceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return resourceId != null ? resourceId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId='" + resourceId + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentIds='" + parentIds + '\'' +
                ", state=" + state +
                '}';
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
