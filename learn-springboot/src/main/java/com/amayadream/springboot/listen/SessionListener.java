package com.amayadream.springboot.listen;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * SessionListener,负责监听session的创建和销毁
 * @author :  Amayadream
 * @date :  2016.04.19 21:08
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession Created...");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession Destroyed...");
    }
}
