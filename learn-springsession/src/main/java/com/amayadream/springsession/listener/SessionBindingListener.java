package com.amayadream.springsession.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author :  Amayadream
 * @date :  2016.03.10 20:17
 */
public class SessionBindingListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(httpSessionBindingEvent.getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(httpSessionBindingEvent.getName());
    }
}
