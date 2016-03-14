package com.amayadream.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.amayadream.shiro.pojo.User;
import com.amayadream.shiro.service.IOrganizationService;
import com.amayadream.shiro.service.IRoleService;
import com.amayadream.shiro.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 19:32
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Resource private IUserService userService;
    @Resource private IRoleService roleService;
    @Resource private IOrganizationService organizationService;

    @RequiresPermissions("user:view")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String list(@RequestParam(value = "page", defaultValue = "1") int page){
        List<User> list = userService.selectAll(page, 5);
        return JSON.toJSONString(list);
    }





}
