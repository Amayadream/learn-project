package com.amayadream.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 16:06
 */
@Controller
@RequestMapping(value = "")
public class RouteController {

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "login")
    public String login() {
        return "login";
    }
}
