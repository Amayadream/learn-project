package com.amayadream.generator.junit;

import com.amayadream.freemarker.datasource.DataSourceContextHolder;
import com.amayadream.freemarker.model.PhysicalColumn;
import com.amayadream.freemarker.service.IPhysicalService;
import com.amayadream.generator.utils.Constants;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :  Amayadream
 * @date :  2016.04.13 19:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mvc.xml", "classpath:spring/spring-mybatis.xml"})
public class GeneratorTest {
    private static String datasource = "";
    private static String tableName = null;
    private static String beanName = null;
    private static String path = "";
    Writer out = null;
    private Configuration config = new Configuration();
    List<PhysicalColumn> columnList = new ArrayList<PhysicalColumn>();

    @Resource
    private IPhysicalService physicalService;

    @Before
    public void before(){
        datasource = "ds_admin";
        tableName = "SYSLOG";
        beanName = "syslog";
        path = "D:/";
        DataSourceContextHolder.setDbType(datasource);
        config.setClassForTemplateLoading(getClass(), "../template");
        config.setDefaultEncoding("utf-8");
        columnList = physicalService.showColumns(tableName);
    }

    @After
    public void after(){
        try{
            out.flush();
            out.close();
            DataSourceContextHolder.clearDbType();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void modelTest(){
        for (PhysicalColumn item : columnList) {
            item.setColumnType(getJavaType(item.getColumnType().toLowerCase()));
        }
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("columnList", columnList);
        root.put("classPath", Constants.CLASSPATH);
        root.put("beanName", beanName);
        root.put("packageModel", Constants.PACKAGE_MODEL);
        try{
            Template template = config.getTemplate(Constants.FTL_MODEL);
            File file = new File(path + beanName+".java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            template.process(root, out);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getJavaType(String dbtype) {
        if (dbtype.equals("varchar") || dbtype.equals("varchar2") || dbtype.equals("nvarchar") || dbtype.equals("clob")) {
            return "String";
        } else if (dbtype.equals("integer") || dbtype.equals("number")) {
            return "Int";
        } else if (dbtype.equals("date")) {
            return "Date";
        } else {
            return null;
        }
    }


}
