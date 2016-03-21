package com.amayadream.shiro.controller;

import com.amayadream.shiro.pojo.User;
import com.amayadream.shiro.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 验证与注册控制器,负责验证用户登录,注销以及注册用户
 * @author :  Amayadream
 * @date :  2016.03.12 15:42
 */
@Controller
public class AuthController {

    @Resource IUserService userService;

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "forward:/user";
    }

    /**
     * 用户登录
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "apps/login";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(){
        return "apps/register";
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, String retype, Model model){
        if (user.getPassword().equals(retype)) {
            User user1 = userService.selectByUserid(user.getUserid());
            if (user1 == null) {
                boolean flag = userService.insert(user);
                if (flag) {
                    model.addAttribute("message", "[" + user.getUserid() + "]注册成功");
                } else {
                    model.addAttribute("error", "注册失败,请重试!");
                }
            } else {
                model.addAttribute("error", "[" + user.getUserid() + "]用户已存在!");
            }
        } else {
            model.addAttribute("error", "两次密码不一致");
        }
        return "apps/register";
    }

    @RequestMapping(value = "logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}
