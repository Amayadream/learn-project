package com.amayadream.springsession.controller;

import com.amayadream.springsession.pojo.User;
import com.amayadream.springsession.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author :  Amayadream
 * @date :  2016.03.08 16:41
 */
@Controller
@RequestMapping(value = "auth")
public class AuthController {

    @Resource
    private IUserService userService;

    /**
     * 判断服务器登录了没有,如果没有返回null,登录了返回sessionId
     * @param session
     * @return
     */
    @RequestMapping(value = "judge")
    public void judge(HttpSession session, String url, HttpServletResponse response) throws IOException {
        String userid = (String) session.getAttribute("userid");
        if (userid != null && !userid.equals("")) {
            if (url != null && !url.equals("")) {
                response.sendRedirect(url + "?_s=" + session.getId());
            } else {
                response.sendRedirect("/springsession/index");
            }
        }else{
            response.sendRedirect("/springsession/auth/login?url=" + url);
        }
    }

    /**
     * 登录页面
     * @param url
     * @param session
     * @return
     */
    @RequestMapping(value = "login")
    public String login(String url, HttpSession session) {
        session.setAttribute("url", url);
        return "login";
    }

    /**
     * 登录
     * @param user
     * @param session
     * @param attributes
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "check")
    public void check(User user, HttpSession session, RedirectAttributes attributes, HttpServletResponse response) throws IOException {
        User user1 = userService.selectByUserid(user.getUserid());
        if (user1 != null) {
            if (user1.getPassword().equals(user.getPassword())) {
                String url = (String) session.getAttribute("url");
                session.setAttribute("userid", user1.getUserid());
                session.setAttribute("user", user1);
                url = url == null || url.equals("") ? "/springsession/index" : url;
                response.sendRedirect(url);
            } else {
                attributes.addFlashAttribute("error", "用户名或密码错误");
                response.sendRedirect("/springsession/auth/login");
            }
        } else{
            attributes.addFlashAttribute("error", "没有这个用户");
            response.sendRedirect("/springsession/auth/login");
        }
    }

    /**
     * 登出操作
     * @param session
     * @param url
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "logout")
    public void logout(HttpSession session, String url, HttpServletResponse response) throws IOException {
        session.invalidate();
        if (url != null && !url.equals("")) {
            response.sendRedirect(url);
        } else {
            response.sendRedirect("/springsession/auth/login");
        }
    }
}
