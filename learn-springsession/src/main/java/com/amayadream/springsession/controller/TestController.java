package com.amayadream.springsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author :  Amayadream
 * @date :  2016.03.10 19:05
 */
@Controller
@RequestMapping(value = "session")
public class TestController {

    @RequestMapping(value = "get")
    public ModelAndView get(HttpSession session){
        String userid = (String)session.getAttribute("userid");
        return new ModelAndView("index", "userid", userid);
    }

    @RequestMapping(value = "set")
    public ModelAndView set(HttpSession session){
        session.setAttribute("userid", "Amayadream");
        return new ModelAndView("index", "message", "success to set session");
    }

}
