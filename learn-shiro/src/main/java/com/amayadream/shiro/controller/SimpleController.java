package com.amayadream.shiro.controller;

import com.amayadream.shiro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :  Amayadream
 * @date :  2016.06.29 22:07
 */
@Controller
public class SimpleController {

    @Autowired private MongoTemplate template;

    @RequestMapping(value = "index")
    public String index(){
        return "view/index";
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public String save(){
        User user = new User();
        user.setUserId("Amayadream");
        user.setPassword("123456");
        user.setState(-1);
        template.save(user);
        return "success";
    }

}
