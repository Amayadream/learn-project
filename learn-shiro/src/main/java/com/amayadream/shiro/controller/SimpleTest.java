package com.amayadream.shiro.controller;

import com.mongodb.gridfs.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author :  Amayadream
 * @date :  2016.07.25 17:23
 */
@Controller
@RequestMapping(value = "test")
public class SimpleTest {

    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private MongoDbFactory mongoDbFactory;
    @Autowired
    private MongoConverter mongoConverter;

    @RequestMapping(value = "asd")
    @ResponseBody
    public String test() throws FileNotFoundException {
        GridFsTemplate gridFsTemplate = new GridFsTemplate(mongoDbFactory, mongoConverter, "111");
        File file = new File("D:\\Driver\\chromedriver.exe");
        InputStream is = new FileInputStream(file);
        GridFSFile i = gridFsTemplate.store(is, "chromedriver.exe");
        return i.getFilename();
    }





}
