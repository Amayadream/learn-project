package com.amayadream.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.amayadream.shiro.model.Role;
import com.amayadream.shiro.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :  Amayadream
 * @date :  2016.07.02 16:35
 */
@Controller
@RequestMapping(value = "role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "test", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test(){
        Role role = new Role();
        role.setRoleId("admin");
        role.setRoleName("炒鸡管理员");
        role.setState(1);
        return JSON.toJSONString(roleService.createRole(role));
    }

}
