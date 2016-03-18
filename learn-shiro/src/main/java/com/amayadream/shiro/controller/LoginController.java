package com.amayadream.shiro.controller;

import com.amayadream.shiro.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 15:42
 */
@Controller
public class LoginController {

    @Resource IUserService userService;

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
        model.addAttribute("message", error);
        return "login";
    }

    @RequestMapping(value = "logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}
