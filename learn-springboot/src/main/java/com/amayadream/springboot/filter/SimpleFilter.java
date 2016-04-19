package com.amayadream.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author :  Amayadream
 * @date :  2016.04.19 21:14
 */
@WebFilter(urlPatterns = "/*", filterName = "simpleFilter")
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("simple filter is init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hello, this is filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("simple filter is destroy...");
    }
}
