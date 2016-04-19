package com.amayadream.springboot.controller;

import com.amayadream.springboot.dao.TabAMapper;
import com.amayadream.springboot.model.TabA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @author :  Amayadream
 * @date :  2016.04.17 20:42
 */
@Controller
public class SimpleController {

    @Resource
    private TabAMapper aDao;

    //读取application.yml参数
    @Value("${hello.name}")
    private String message = "admin";

    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return message;
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public TabA show(){
        return aDao.selectByPrimaryKey("F4D32B806622497A8030E96ED4F86B17");
    }

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }



}
