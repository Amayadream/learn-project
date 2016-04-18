package com.amayadream.springboot.model;

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

}
