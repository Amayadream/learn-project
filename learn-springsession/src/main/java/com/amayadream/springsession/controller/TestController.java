package com.amayadream.springsession.controller;

import com.amayadream.springsession.listener.SessionBindingListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author :  Amayadream
 * @date :  2016.03.10 19:05
 */
@Controller
@RequestMapping(value = "test")
public class TestController{

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

    @RequestMapping(value = "create")
    public void create(HttpSession session) {
        session.setAttribute("listener", "123");
    }

    @RequestMapping(value = "destroy")
    public void destroy(HttpSession session){
        session.removeAttribute("listener");
        session.invalidate();
    }
}
