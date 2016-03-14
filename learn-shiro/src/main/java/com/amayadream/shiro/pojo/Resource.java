package com.amayadream.shiro.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 资源实体
 * @author :  Amayadream
 * @date :  2016.03.14 15:20
 */
@Repository
public class Resource implements Serializable {
    private String id;          ///编号
    private String name;        //资源名称
    private String type;        //资源类型
    private String url;         //资源路径
    private String parent_id;   //父节点
    private String parent_ids;  //父节点集合
    private String permission;  //权限字符串
    private int locked;      //锁定

    public static enum ResourceType {
        menu("菜单"), button("按钮");
        private final String info;
        private ResourceType(String info) {
            this.info = info;
        }
        public String getInfo() {
            return info;
        }
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}
