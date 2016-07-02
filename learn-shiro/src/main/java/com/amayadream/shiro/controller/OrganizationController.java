package com.amayadream.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.amayadream.shiro.model.Organization;
import com.amayadream.shiro.service.IOrganizationService;
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
@RequestMapping(value = "organization", produces = "application/json;charset=UTF-8")
public class OrganizationController {

    @Autowired
    private IOrganizationService organizationService;

    @RequestMapping(value = "test")
    @ResponseBody
    public String test(){
        Organization organization = new Organization();
        organization.setOrganId(UUIDHelper.generateUUID());
        organization.setOrganName("总公司");
        organization.setState(1);
        organization.setParentId("0");
        organization.setParentIds("0/");
        return JSON.toJSONString(organizationService.createOrganization(organization));
    }

}
