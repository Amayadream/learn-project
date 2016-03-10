package com.amayadream.springsession.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author :  Amayadream
 * @date :  2016.03.05 21:28
 */
@Repository
public class User implements Serializable {
    private String userid;
    private String password;
    private String email;

    public User() {
    }

    public User(String userid, String password, String email) {
        this.userid = userid;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
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
}
