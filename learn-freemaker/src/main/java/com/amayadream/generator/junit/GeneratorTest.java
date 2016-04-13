package com.amayadream.generator.junit;

import com.amayadream.freemarker.datasource.DataSourceContextHolder;
import com.amayadream.freemarker.service.IPhysicalService;
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
import java.util.HashMap;
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

    @Resource
    private IPhysicalService physicalService;

    @Before
    public void before(){
        datasource = "ds_admin";
        tableName = "SYSLOG";
        beanName = "syslog";
        path = "D:/";
        config.setClassForTemplateLoading(getClass(), "../template");
        config.setDefaultEncoding("utf-8");
        DataSourceContextHolder.setDbType(datasource);
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
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("xx", "xx");
        try{
            Template template = config.getTemplate("model.ftl");
            File file = new File(path);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
