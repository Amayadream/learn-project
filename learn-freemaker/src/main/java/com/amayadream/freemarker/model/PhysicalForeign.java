package com.amayadream.freemarker.model;

/**
 * 外键实体
 * @author :  Amayadream
 * @date :  2016.04.13 16:04
 */
public class PhysicalForeign {
    private String columnName;  //字段名
    private String mapTable;    //对应表
    private String mapColumn;   //对应字段


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getMapTable() {
        return mapTable;
    }

    public void setMapTable(String mapTable) {
        this.mapTable = mapTable;
    }

    public String getMapColumn() {
        return mapColumn;
    }

    public void setMapColumn(String mapColumn) {
        this.mapColumn = mapColumn;
    }
}
