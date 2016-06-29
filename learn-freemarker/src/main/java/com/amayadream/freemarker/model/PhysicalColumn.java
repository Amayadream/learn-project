package com.amayadream.freemarker.model;

/**
 * 表字段实体
 * @author :  Amayadream
 * @date :  2016.04.13 15:32
 */
public class PhysicalColumn {
    private String columnName;        //字段名称
    private String columnType;        //字段类型
    private String columnComments;    //字段注释
    private String dataLength;        //字段长度,列的数据类型的字节长度
    private String dataPrecision;     //字段精度,数字类型的实际长度
    private String dataScale;         //字段范围,数字类型的小数点位数
    private String nullable;          //是否为空


    /**
     * getter&setter
     */
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnComments() {
        return columnComments;
    }

    public void setColumnComments(String columnComments) {
        this.columnComments = columnComments;
    }

    public String getDataLength() {
        return dataLength;
    }

    public void setDataLength(String dataLength) {
        this.dataLength = dataLength;
    }

    public String getDataPrecision() {
        return dataPrecision;
    }

    public void setDataPrecision(String dataPrecision) {
        this.dataPrecision = dataPrecision;
    }

    public String getDataScale() {
        return dataScale;
    }

    public void setDataScale(String dataScale) {
        this.dataScale = dataScale;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }
}
