package com.amayadream.springsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author :  Amayadream
 * @date :  2016.03.10 19:05
 */
@Controller
@RequestMapping(value = "test")
public class TestController{

    @RequestMapping(value = "set")
    public String set(HttpSession session){
        session.setAttribute("userid", "Amayadream");
        return "index";
    }

    @RequestMapping(value = "get")
    @ResponseBody
    public String get(HttpSession session){
        return "Hello," + session.getAttribute("userid");
    }
}
