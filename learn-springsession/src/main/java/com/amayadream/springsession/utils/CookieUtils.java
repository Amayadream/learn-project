package com.amayadream.springsession.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author :  Amayadream
 * @date :  2016.03.08 14:34
 */
public class CookieUtils {

    /**
     * 解析单个cookie
     * @param cookie
     */
    public void parseCookie(Cookie cookie){
        if(cookie != null){
            System.out.println("cookieName  = > " + cookie.getName());
            System.out.println("cookieValue = > " + cookie.getValue());
            System.out.println("cookieDomain= > " + cookie.getDomain());
            System.out.println("cookiePath  = > " + cookie.getPath());
            System.out.println("cookieMaxAge= > " + cookie.getMaxAge());
            System.out.println("cookieSecure= > " + cookie.getSecure());
            System.out.println("*************************************");
        }
    }

    /**
     * 解析cookies
     * @param cookies cookies
     */
    public void parseCookies(Cookie[] cookies){
        if (cookies == null) {
            System.out.println("cookies is null");
        } else {
            for (Cookie cookie : cookies) {
                parseCookie(cookie);
            }
        }
    }

    /**
     * 解析cookies
     * @param request request对象
     */
    public void parseCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        parseCookies(cookies);
    }

}
