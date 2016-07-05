package com.amayadream.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.amayadream.shiro.model.User;
import com.amayadream.shiro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :  Amayadream
 * @date :  2016.07.02 16:35
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String list(){
        return JSON.toJSONString(userService.findAll(null));
    }

    @RequestMapping(value = "create/{userId}/{password}/{state}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String create(@PathVariable String userId, @PathVariable String password, @PathVariable int state){
        return JSON.toJSONString(userService.createUser(new User(userId, password, state)));
    }

    @RequestMapping(value = "password/{userId}/{password}")
    @ResponseBody
    public String password(@PathVariable String userId, @PathVariable String password){
        return JSON.toJSONString(userService.changePassword(userId, password));
    }

    @RequestMapping(value = "test", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test(){
        User user = new User();
        user.setUserId("admin");
        user.setPassword("admin");
        user.setState(1);
        return JSON.toJSONString(userService.createUser(user));
    }

    @RequestMapping(value = "permission", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String permission(){
        return JSON.toJSONString(userService.findPermission("Amayadream"));
    }

    @RequestMapping(value = "role", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String role(){
        return JSON.toJSONString(userService.findRoles("Amayadream"));
    }

}
