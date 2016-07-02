package com.amayadream.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.amayadream.shiro.model.Resource;
import com.amayadream.shiro.service.IResourceService;
import com.amayadream.shiro.utils.UUIDHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :  Amayadream
 * @date :  2016.07.02 16:35
 */
@Controller
@RequestMapping(value = "resource")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @RequestMapping(value = "test", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test(){
        Resource resource = new Resource();
        resource.setResourceId(UUIDHelper.generateUUID());
        resource.setResourceName("资源");
        resource.setParentId("0");
        resource.setParentIds("0/");
        return JSON.toJSONString(resourceService.createResource(resource));
    }

}
