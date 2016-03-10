package com.amayadream.springsession.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.text.MessageFormat;

/**
 * @author :  Amayadream
 * @date :  2016.03.10 21:43
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String str = MessageFormat.format(
                "HttpSession域对象中添加了属性:{0}，属性值是:{1}"
                ,se.getName()
                ,se.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String str =MessageFormat.format(
                "HttpSession域对象中删除属性:{0}，属性值是:{1}"
                ,se.getName()
                ,se.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        String str =MessageFormat.format(
                "HttpSession域对象中替换了属性:{0}的值"
                ,se.getName());
        System.out.println(str);
    }
}
