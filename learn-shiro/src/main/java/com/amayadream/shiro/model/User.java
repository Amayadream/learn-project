package com.amayadream.shiro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

/**
 * @author :  Amayadream
 * @date :  2016.07.01 21:11
 */
@Document(collection = "db_user")
@Repository(value = "user")
public class User {

    /** 用户名 */
    @Id
    private String userId;

    /** 密码 */
    private String password;

    /** 用户状态, 1:正常, -1:停用, 0:待激活 */
    private int state;

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
