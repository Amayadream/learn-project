package com.amayadream.freemarker.model;

/**
 * 物理表实体
 * @author :  Amayadream
 * @date :  2016.04.13 14:35
 */
public class PhysicalTable {
    private String tableName;       //表名
    private String tableComments;   //表注释


    /**
     * getter&setter
     */
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComments() {
        return tableComments;
    }

    public void setTableComments(String tableComments) {
        this.tableComments = tableComments;
    }
}
