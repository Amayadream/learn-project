package com.amayadream.freemarker.test;

import com.alibaba.fastjson.JSON;
import com.amayadream.freemarker.datasource.DataSourceContextHolder;
import com.amayadream.freemarker.model.PhysicalTable;
import com.amayadream.freemarker.service.IPhysicalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.04.13 18:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mvc.xml", "classpath:spring/spring-mybatis.xml"})
public class DateSourceTest {

    @Resource
    private IPhysicalService physicalService;

    @Test
    public void dstest(){
        try{
            DataSourceContextHolder.setDbType("ds_admin");
            List<PhysicalTable> list = physicalService.showTables();
            System.out.println(JSON.toJSONString(list));
        } finally {
            DataSourceContextHolder.clearDbType();
        }

    }

}
