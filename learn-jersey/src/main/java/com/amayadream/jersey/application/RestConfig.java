package com.amayadream.jersey.application;

import com.amayadream.jersey.controller.TestController;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author :  Amayadream
 * @date :  2016.03.09 23:13
 */
public class RestConfig extends ResourceConfig {
    public RestConfig() {
        // 加载resources
        register(TestController.class);
//        register(UserResource.class);
        // 注册数据转换器
//        register(JacksonJsonProvider.class);
        // 注册日志
        register(LoggingFilter.class);
    }
}
