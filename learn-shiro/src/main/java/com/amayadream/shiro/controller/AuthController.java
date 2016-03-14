package com.amayadream.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.amayadream.shiro.pojo.User;
import com.amayadream.shiro.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 15:42
 */
@Controller
@RequestMapping(value = "auth")
public class AuthController {

    @Resource IUserService userService;

    @RequestMapping(value = "login")
    public String check(User user, RedirectAttributes attributes) {
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUserid(), user.getPassword());
        try{
            subject.login(token);
            Session session=subject.getSession();
            System.out.println("sessionId:"+session.getId());
            System.out.println("sessionHost:"+session.getHost());
            System.out.println("sessionTimeout:"+session.getTimeout());
            attributes.addFlashAttribute("message", "登录成功!");
            attributes.addFlashAttribute("userid", user.getUserid());
            return "redirect:/index";
        }catch(Exception e){
            attributes.addFlashAttribute("message", "用户名或密码错误!");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @RequestMapping(value = "index")
    @ResponseBody
    public String index(){
        User user = userService.selectByUserid("Amayadream");
        return JSON.toJSONString(user);
    }
}
