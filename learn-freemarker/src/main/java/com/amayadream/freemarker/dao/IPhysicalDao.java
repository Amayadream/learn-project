package com.amayadream.freemarker.dao;

import com.amayadream.freemarker.model.PhysicalColumn;
import com.amayadream.freemarker.model.PhysicalForeign;
import com.amayadream.freemarker.model.PhysicalPrimary;
import com.amayadream.freemarker.model.PhysicalTable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物理表查询接口
 * @author :  Amayadream
 * @date :  2016.04.13 16:03
 */
@Service(value = "physicalDao")
public interface IPhysicalDao {

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
