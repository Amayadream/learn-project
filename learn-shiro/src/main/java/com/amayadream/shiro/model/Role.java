package com.amayadream.shiro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体
 *
 * @author :  Amayadream
 * @date :  2016.07.02 10:45
 */
@Document(collection = "db_role")
@Repository(value = "role")
public class Role implements Serializable {

    /**
     * 角色编号
     */
    @Id
    private String roleId;
    /**
     * 角色标识,例如admin
     */
    private String roleName;
    /**
     * 状态, 1:正常, -1:停用
     */
    private int state;
    /**
     * 拥有资源集合
     */
    private Set<String> resourceIds;

    public Role() {
    }

    public Role(String roleId, String roleName, int state) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.state = state;
    }

    public String getResourceIdsStr() {
        if (CollectionUtils.isEmpty(resourceIds)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String resourceId : resourceIds) {
            sb.append(resourceId);
            sb.append(",");
        }
        return sb.toString();
    }

    public void setResourceIdsStr(String resourceIdsStr) {
        if (StringUtils.isEmpty(resourceIdsStr)) {
            return;
        }
        String[] list = resourceIdsStr.split(",");
        for (String item : list) {
            if (StringUtils.isEmpty(item)) {
                continue;
            }
            getResourceIds().add(item);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        if (roleId != null ? !roleId.equals(role.roleId) : role.roleId != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return roleId != null ? roleId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", state=" + state +
                ", resourceIds=" + resourceIds +
                '}';
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Set<String> getResourceIds() {
        if (resourceIds == null) {
            resourceIds = new HashSet<String>();
        }
        return resourceIds;
    }

    public void setResourceIds(Set<String> resourceIds) {
        this.resourceIds = resourceIds;
    }

}
