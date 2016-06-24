package com.amayadream.nettysocketio.bean;

import java.io.Serializable;

/**
 * @author :  Amayadream
 * @date :  2016.06.24 09:01
 */
public class MessageObject implements Serializable {

    private String username;
    private String message;

    public MessageObject() {

    }

    public MessageObject(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
