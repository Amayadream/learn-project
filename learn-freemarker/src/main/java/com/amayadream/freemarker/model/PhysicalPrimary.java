package com.amayadream.freemarker.model;

/**
 * 主键实体
 * @author :  Amayadream
 * @date :  2016.04.13 16:10
 */
public class PhysicalPrimary {
    private String columnName;      //主键字段
    private String constraintName;  //主键名


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }
}
