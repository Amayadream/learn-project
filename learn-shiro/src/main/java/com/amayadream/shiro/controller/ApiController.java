package com.amayadream.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.amayadream.shiro.pojo.User;
import com.amayadream.shiro.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :  Amayadream
 * @date :  2016.03.19 15:09
 */
@Controller
@RequestMapping(value = "api")
public class ApiController {

    @Resource
    private IUserService userService;

    /**
     * 获取所有用户
     * @return
     */
    @RequiresPermissions("user:view")
    @RequestMapping(value = "user/all", method = RequestMethod.GET)
    @ResponseBody
    public String list(Map<String, Object> map){
        List<User> list = userService.selectAllNoPage();
        map.put("data", list);
        return JSON.toJSONString(map);
    }
}
