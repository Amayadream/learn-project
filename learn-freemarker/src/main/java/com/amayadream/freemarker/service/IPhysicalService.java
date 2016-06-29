package com.amayadream.freemarker.service;

import com.amayadream.freemarker.model.PhysicalColumn;
import com.amayadream.freemarker.model.PhysicalForeign;
import com.amayadream.freemarker.model.PhysicalPrimary;
import com.amayadream.freemarker.model.PhysicalTable;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.04.13 17:01
 */
public interface IPhysicalService {
    /**
     * 展示所有物理表信息
     * @return
     */
    List<PhysicalTable> showTables();

    /**
     * 根据表名查询指定表的字段和注释等信息
     * @param tableName
     * @return
     */
    List<PhysicalColumn> showColumns(String tableName);

    /**
     * 根据表名查询指定表的主键信息
     * @param tableName
     * @return
     */
    List<PhysicalPrimary> showPrimarys(String tableName);

    /**
     * 根据表名查询指定表的外键信息
     * @param tableName
     * @return
     */
    List<PhysicalForeign> showForeigns(String tableName);
}
