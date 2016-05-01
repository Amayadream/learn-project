package com.amayadream.springboot.config;

import com.amayadream.springboot.interceptor.SimpleInterceptor1;
import com.amayadream.springboot.interceptor.SimpleInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author :  Amayadream
 * @date :  2016.04.19 21:39
 */
@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new SimpleInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new SimpleInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将classpath下的photo文件夹里的资源映射到/photos这个路径下
        //访问是通过http://127.0.0.1:[port]/photos/xxx.jpg就能访问
        //addResourceLocations可以添加任意个目录,也可以覆盖系统默认的配置
        registry.addResourceHandler("/photos/**").addResourceLocations("classpath:/photo/", "classpath:/static/");
        super.addResourceHandlers(registry);
    }




}
