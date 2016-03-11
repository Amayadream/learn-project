package com.amayadream.springsession.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.MessageFormat;

/**
 * @author :  Amayadream
 * @date :  2016.03.10 19:57
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session created");
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session destroyed");
    }

    public void attributeAdded(HttpSessionBindingEvent se) {
        String str = MessageFormat.format(
                "HttpSession域对象中添加了属性:{0}，属性值是:{1}"
                ,se.getName()
                ,se.getValue());
        System.out.println(str);
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
        String str =MessageFormat.format(
                "HttpSession域对象中删除属性:{0}，属性值是:{1}"
                ,se.getName()
                ,se.getValue());
        System.out.println(str);
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
        String str =MessageFormat.format(
                "HttpSession域对象中替换了属性:{0}的值"
                ,se.getName());
        System.out.println(str);
    }
}
