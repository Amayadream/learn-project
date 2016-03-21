package com.amayadream.shiro.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 15:37
 */
@Repository
public class User implements Serializable {
    private String userid;          //用户名
    private String password;        //密码
    private String email;           //邮箱
    private String organization_id; //所属组织
    private String role_ids;        //所属角色
    private String salt;            //盐
    private int locked;          //锁定

    public String getCredentialsSalt() {
        return userid + salt;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getRole_ids() {
        return role_ids;
    }

    public void setRole_ids(String role_ids) {
        this.role_ids = role_ids;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

}
