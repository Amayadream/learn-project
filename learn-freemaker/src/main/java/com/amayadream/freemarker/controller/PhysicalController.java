package com.amayadream.freemarker.controller;

import com.amayadream.freemarker.model.PhysicalColumn;
import com.amayadream.freemarker.model.PhysicalForeign;
import com.amayadream.freemarker.model.PhysicalPrimary;
import com.amayadream.freemarker.model.PhysicalTable;
import com.amayadream.freemarker.service.IPhysicalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 物理表信息控制器
 * @author :  Amayadream
 * @date :  2016.04.13 17:16
 */
@Controller
@RequestMapping(value = "physical")
public class PhysicalController {

    @Resource
    private IPhysicalService physicalService;

    @RequestMapping(value = "tables")
    @ResponseBody
    public List<PhysicalTable> allTables(){
        return physicalService.showTables();
    }

    @RequestMapping(value = "columns/{tableName}")
    @ResponseBody
    public List<PhysicalColumn> allColumns(@PathVariable String tableName){
        return physicalService.showColumns(tableName.toUpperCase());
    }

    @RequestMapping(value = "primarys/{tableName}")
    @ResponseBody
    public List<PhysicalPrimary> allPrimarys(@PathVariable String tableName){
        return physicalService.showPrimarys(tableName.toUpperCase());
    }

    @RequestMapping(value = "foreigns/{tableName}")
    @ResponseBody
    public List<PhysicalForeign> allForeigns(@PathVariable String tableName){
        return physicalService.showForeigns(tableName.toUpperCase());
    }
}
