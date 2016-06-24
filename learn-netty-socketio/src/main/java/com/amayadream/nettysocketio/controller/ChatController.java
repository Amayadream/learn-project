package com.amayadream.nettysocketio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :  Amayadream
 * @date :  2016.06.24 16:25
 */
@Controller
public class ChatController {

    @RequestMapping(value = "chat")
    public String test(){
        return "chat";
    }
}
