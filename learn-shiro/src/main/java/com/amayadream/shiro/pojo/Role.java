package com.amayadream.shiro.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 角色实体
 * @author :  Amayadream
 * @date :  2016.03.14 15:16
 */
@Repository
public class Role implements Serializable {
    private String id;          //编号
    private String roleName;    //名称
    private String description; //描述
    private String resource_ids;//拥有资源
    private int locked;      //是否锁定


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResource_ids() {
        return resource_ids;
    }

    public void setResource_ids(String resource_ids) {
        this.resource_ids = resource_ids;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}
