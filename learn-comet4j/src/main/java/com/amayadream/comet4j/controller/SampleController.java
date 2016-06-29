package com.amayadream.comet4j.controller;

import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :  Amayadream
 * @date :  2016.06.29 09:51
 */
@Controller
@RequestMapping(value = "sample")
public class SampleController {

    @RequestMapping(value = "run/{message}")
    @ResponseBody
    public String run(@PathVariable("message") String message){
        CometEngine engine = CometContext.getInstance().getEngine();
        engine.sendToAll("map", message);
        return "send success";
    }

}
