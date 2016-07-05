package com.amayadream.shiro.model;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体
 * @author :  Amayadream
 * @date :  2016.07.01 21:11
 */
@Document(collection = "db_user")
@Repository(value = "user")
public class User implements Serializable {

    /** 用户名 */
    @Id
    private String userId;
    /** 密码 */
    private String password;
    /** 组织编号 */
    private String organizationId;
    /** 加盐 */
    private String salt;
    /** 用户状态, 1:正常, -1:停用, 0:待激活 */
    private int state;
    /** 角色列表 */
    private Set<String> roleIds;


    public String getCredentialsSalt() {
        return userId + salt;
    }

    public User() {
    }

    public User(String userId, String password, int state) {
        this.userId = userId;
        this.password = password;
        this.state = state;
    }

    public String getRoleIdsStr(){
        if (CollectionUtils.isEmpty(roleIds)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String roleId : roleIds) {
            sb.append(roleId);
            sb.append(",");
        }
        return sb.toString();
    }

    public void setRoleIdsStr(String roleIdsStr){
        if (StringUtils.isEmpty(roleIdsStr)) {
            return;
        }
        String[] list = roleIdsStr.split(",");
        for (String item : list) {
            if (StringUtils.isEmpty(item)) {
                continue;
            }
            getRoleIds().add(item);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        return true;

    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", roleIds=" + roleIds +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Set<String> getRoleIds() {
        if(roleIds == null){
            roleIds = new HashSet<String>();
        }
        return roleIds;
    }

    public void setRoleIds(Set<String> roleIds) {
        this.roleIds = roleIds;
    }

}
