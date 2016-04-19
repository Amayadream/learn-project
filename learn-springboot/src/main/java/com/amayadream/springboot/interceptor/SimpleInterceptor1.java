package com.amayadream.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :  Amayadream
 * @date :  2016.04.19 21:34
 */
public class SimpleInterceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("SimpleInterceptor1 => 在请求处理之前进行调用,即在Controller之前调用...");
        return true;    //true继续下一步,false中止
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("SimpleInterceptor1 => 在请求之后,但是在视图渲染之前调用...");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("SimpleInterceptor1 => 在整个请求之后调用,主要是做清理工作...");
    }
}
