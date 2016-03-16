package com.amayadream.jersey.controller;

import com.amayadream.jersey.session.XdataSessionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * @author :  Amayadream
 * @date :  2016.03.16 21:54
 */
@Path("session")
public class SessionController {

    /**
     * 获取sessionId
     * @param request
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getId(@Context HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userid", "Amayadream");
        return session.getId();
    }

    /**
     * 根据sessionid来获取session
     * @param sessionId
     * @return
     */
    @GET
    @Path("{sessionId}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHelloToUTF8(@PathParam("sessionId") String sessionId) {
        XdataSessionContext context = XdataSessionContext.getInstance();
        HttpSession session = context.getSession(sessionId);
        return (String)session.getAttribute("userid");
    }

    @Path("{sessionId}/destroy")
    public void destroy(@PathParam("sessionId") String sessionId){
        XdataSessionContext context = XdataSessionContext.getInstance();
        HttpSession session = context.getSession(sessionId);
        session.invalidate();
    }


}
