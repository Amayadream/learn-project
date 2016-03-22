package com.amayadream.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.amayadream.shiro.pojo.Role;
import com.amayadream.shiro.pojo.User;
import com.amayadream.shiro.service.IResourceService;
import com.amayadream.shiro.service.IRoleService;
import com.amayadream.shiro.service.IUserService;
import com.amayadream.shiro.utils.SelectEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据接口控制器
 * @author :  Amayadream
 * @date :  2016.03.19 15:09
 */
@Controller
@RequestMapping(value = "api")
public class ApiController {

    /** 用户服务 */
    @Resource private IUserService userService;
    /** 角色服务 */
    @Resource private IRoleService roleService;
    /** 资源服务 */
    @Resource private IResourceService resourceService;

    /**
     * 获取所有用户
     * @return
     */
    @RequiresPermissions("user:view")
    @RequestMapping(value = "user/all", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(Map<String, Object> map){
        List<User> list = userService.selectAllNoPage();
        map.put("data", list);
        return JSON.toJSONString(map);
    }


    @RequiresPermissions("user:view")
    @RequestMapping(value = "user/{userid}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String select(@PathVariable String userid){
        return JSON.toJSONString(userService.selectByUserid(userid));
    }


    @RequiresPermissions("role:view")
    @RequestMapping(value = "role/getRoles", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getRoles(){
        List<Role> roles = roleService.selectRoles();
        if (roles == null)   return null;
        List<SelectEntity> list = new ArrayList<>();
        for (Role role : roles) {
            SelectEntity entity = new SelectEntity();
            entity.setId(role.getId());
            entity.setText(role.getRoleName());
            list.add(entity);
        }
        return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    }

}
