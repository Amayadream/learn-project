package com.amayadream.jersey.listener;

import com.amayadream.jersey.session.XdataSessionContext;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :  Amayadream
 * @date :  2016.03.16 21:47
 */
public class SessionListener implements HttpSessionListener {
    public static Map userMap = new HashMap();
    private XdataSessionContext myc = XdataSessionContext.getInstance();

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionCreated");
        myc.AddSession(httpSessionEvent.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionDestroyed");
        HttpSession session = httpSessionEvent.getSession();
        myc.DelSession(session);
    }
}
