package com.amayadream.springsession.filter;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author :  Amayadream
 * @date :  2016.03.08 15:28
 */
//@WebFilter(filterName = "JudgeFilter", urlPatterns = "/*")
public class JudgeFilter implements Filter {

    private String _cookiename = "SESSION";
    private String _loginflag = "userid";
    private String _auth_judge_url = "http://localhost:8090/learn_shiro/auth/judge";
    private String _auth_login_url = "http://localhost:8090/learn_shiro/auth/login";
    private String _auth_logout_url = "http://localhost:8090/learn_shiro/auth/logout";

    public void destroy() {
    }

    /**
     * 单点登录过滤器,主要功能有:验证登录状态,同步sessionId,注销等
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String result = null;
        String url = request.getRequestURL().toString();
        String query = request.getQueryString();
        if (query != null && !query.equals("")) {   //如果有后缀
            result = parseQuery(query);
            if (result.equals("logout")) {  //登出操作
                response.sendRedirect(_auth_logout_url + "?url=" + url);
            } else if (result != null && !result.equals("")) {  //有_s请求,更新cookie,然后重新发回
                updateCookie(result, request, response);
                response.sendRedirect(url);
            } else {    //参数不对,过滤掉参数再来一次
                response.sendRedirect(url);
            }
        } else{ //如果没后缀
            if (!checkStatus(request)) {    //如果客户机没登录,那么交给服务器验证(注意这里不能通过httpclient直接验证,因为httpclient本身不携带cookie,所以无法验证服务端的登录转态)
                response.sendRedirect(_auth_judge_url + "?url=" + url);
            } else {
                chain.doFilter(req, resp);
            }
        }
    }

    /**
     * 检查登陆状态
     * @param request
     * @return
     */
    public boolean checkStatus(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute(_loginflag) != null && !session.getAttribute(_loginflag).equals("");
    }

    /**
     * 更新保存着sessionId的cookie,更新登陆状态
     * @param cookievalue
     * @return
     */
    public void updateCookie(String cookievalue, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (_cookiename.equals(cookie.getName())) {
                    cookie.setValue(cookievalue);
                    cookie.setPath(request.getContextPath() + "/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    /**
     * 向验证服务器发送注销请求,并清除本地的SESSION cookie
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        clearCookie(request, response);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(_auth_logout_url);
        try {
            HttpResponse httpResp = client.execute(get);
            httpResp.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            get.releaseConnection();
        }
    }

    /**
     * 清除保存在cookie里的sessionId
     * @param request   request对象
     * @param response  response对象
     */
    public void clearCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (_cookiename.equals(cookie.getName())) {
                    cookie.setPath(request.getContextPath() + "/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    /**
     * 解析后缀
     * @param query 查询条件
     * @return
     */
    public String parseQuery(String query){
        String[] arr = query.split("=");
        if (arr==null || (arr != null && arr.length == 0))  return null;
        if ("method".equals(arr[0]) && "logout".equals(arr[1])) {
            return "logout";
        } else if ("_s".equals(arr[0]) && arr[1] != null) {
            return arr[1];
        } else {
            return null;
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
