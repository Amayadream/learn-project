package com.amayadream.shiro.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 组织机构实体
 * @author :  Amayadream
 * @date :  2016.03.14 15:29
 */
@Repository
public class Organization implements Serializable {
    private String id;          //编号
    private String name;        //组织机构名称
    private String parent_id;   //父节点
    private String parent_ids;  //父节点集合
    private int locked;      //锁定

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_ids() {
        return parent_ids;
    }

    public void setParent_ids(String parent_ids) {
        this.parent_ids = parent_ids;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}
