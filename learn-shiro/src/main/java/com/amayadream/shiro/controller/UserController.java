package com.amayadream.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.amayadream.shiro.pojo.Role;
import com.amayadream.shiro.pojo.User;
import com.amayadream.shiro.service.IOrganizationService;
import com.amayadream.shiro.service.IRoleService;
import com.amayadream.shiro.service.IUserService;
import com.amayadream.shiro.serviceImpl.UserServiceImpl;
import com.amayadream.shiro.utils.SelectEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    /**
     * 无分页获取用户列表
     * @return
     */
    @RequiresPermissions("user:view")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("apps/user/user");
        return view;
    }

    /**
     * 跳转到创建用户页面
     * @return
     */
    @RequiresPermissions("user:create")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(){
        return "apps/user/create";
    }

    /**
     * 创建用户
     * @param user
     * @param attributes
     * @return
     */
    @RequiresPermissions("user:create")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(User user, RedirectAttributes attributes){
        String message = userService.insert(user) ? "["+user.getUserid()+"]创建成功":"创建失败,请重试";
        attributes.addFlashAttribute(message);
        return "redirect:/user";
    }

    /**
     * 根据用户名查询用户(单个用户,返回JSON)
     * @param userid
     * @return
     */
    @RequiresPermissions("user:view")
    @RequestMapping(value = "{userid}", method = RequestMethod.GET)
    public String getOne(@PathVariable String userid, Model model){
        User user = userService.selectByUserid(userid);
        model.addAttribute("user", user);
        return "apps/user/edit";
    }

    /**
     * 更新用户
     * @param userid
     * @return
     */
    @RequiresPermissions("user:update")
    @RequestMapping(value = "{userid}/update", method = RequestMethod.POST)
    public String update(@PathVariable String userid, User user, RedirectAttributes attributes){
        String message = userService.update(user) ? "["+user.getUserid()+"]更新成功" : "["+user.getUserid()+"]更新失败";
        attributes.addFlashAttribute("message", message);
        return "redirect:/user";
    }

    /**
     * 删除用户
     * @param userid
     * @param attributes
     * @return
     */
    @RequiresPermissions("user:delete")
    @RequestMapping(value = "{userid}/delete")
    public String delete(@PathVariable String userid, RedirectAttributes attributes){
        String message = userService.delete(userid) ? "["+userid+"]删除成功" : "["+userid+"]删除失败";
        attributes.addFlashAttribute("message", message);
        return "redirect:/user";
    }

    /**
     * 分页用户列表
     * @param page
     * @return
     */
    @RequiresPermissions("user:view")
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") int page){
        ModelAndView view = new ModelAndView("apps/user/user");
        List<User> list = userService.selectAll(page, 5);
        view.addObject("list", list);
        //待加上角色和组织列表
        return view;
    }

    private List<SelectEntity> getRoles(){
        List<Role> roles = roleService.selectRoles();
        if (roles == null)   return null;
        List<SelectEntity> list = new ArrayList<>();
        for (Role role : roles) {
            SelectEntity entity = new SelectEntity();
            entity.setId(role.getId());
            entity.setText(role.getRoleName());
            list.add(entity);
        }
        return list;
    }


}
