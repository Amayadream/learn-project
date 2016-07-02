package com.amayadream.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :  Amayadream
 * @date :  2016.06.29 22:07
 */
@Controller
public class SimpleController {

    @RequestMapping(value = "index")
    public String index(){
        return "view/index";
    }


}
