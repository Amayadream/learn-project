package com.amayadream.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :  Amayadream
 * @date :  2016.07.02 16:38
 */
@Controller
public class RouteController {

    @RequestMapping(value = "index")
    public String index(){
        return "view/index";
    }

}
