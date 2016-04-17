package com.amayadream.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :  Amayadream
 * @date :  2016.04.17 20:42
 */
@Controller
public class SimpleController {

    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello world";
    }

}
