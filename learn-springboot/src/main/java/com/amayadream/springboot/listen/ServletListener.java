package com.amayadream.springboot.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author :  Amayadream
 * @date :  2016.04.19 21:19
 */
@WebListener
public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Servlet Context Initialized...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Servlet Context Destroyed...");
    }
}
