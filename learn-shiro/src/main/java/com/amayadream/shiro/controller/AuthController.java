package com.amayadream.shiro.controller;

import com.amayadream.shiro.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证控制器
 * @author :  Amayadream
 * @date :  2016.07.01 21:47
 */
@Controller
@RequestMapping(value = "auth")
public class AuthController {

    /**
     * 跳转登录页面
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 登录方法
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String check(HttpServletRequest request, RedirectAttributes attributes){
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        String message = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            message = "账号不存在!";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            message = "密码不正确!";
        } else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
            message = "账户被锁定!";
        } else if (exceptionClassName != null) {
            message = "其他错误：" + exceptionClassName;
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/auth/login";
    }

    /**
     * 注销
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/auth/login";
    }

}
