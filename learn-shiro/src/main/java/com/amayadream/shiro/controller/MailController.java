package com.amayadream.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 邮件控制器,负责邮件发送,阅读以及管理,视图和逻辑处理
 * @author :  Amayadream
 * @date :  2016.03.22 11:16
 */
@Controller
@RequestMapping(value = "mail")
public class MailController {

    @RequestMapping(value = "")
    public String mail(){
        return "apps/mail/mail";
    }

    @RequestMapping(value = "write")
    public String send(){
        return "apps/mail/write";
    }

    @RequestMapping(value = "read")
    public String read(){
        return "apps/mail/read";
    }

}
