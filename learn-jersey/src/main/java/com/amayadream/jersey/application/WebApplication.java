package com.amayadream.jersey.application;

import com.amayadream.jersey.controller.SessionController;
import com.amayadream.jersey.controller.TestController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2016.03.09 23:15
 */
@ApplicationPath(value = "/rest/*")
public class WebApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        return super.getProperties();
    }

    public WebApplication() {
        super();
    }

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(TestController.class);
        classes.add(SessionController.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return super.getSingletons();
    }
}
