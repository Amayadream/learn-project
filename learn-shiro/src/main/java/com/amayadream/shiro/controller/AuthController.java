package com.amayadream.shiro.controller;

import com.amayadream.shiro.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 验证控制器
 * @author :  Amayadream
 * @date :  2016.07.01 21:47
 */
@Controller
@RequestMapping(value = "auth")
public class AuthController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String check(User user, RedirectAttributes attributes){
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUserId(), user.getPassword()));
            return "redirect:/index";
        } catch (Exception e){
            attributes.addFlashAttribute("message", "账号或密码错误!");
            return "redirect:/auth/login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/auth/login";
    }

}
