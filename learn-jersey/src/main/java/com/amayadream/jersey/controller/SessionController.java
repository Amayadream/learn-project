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

    @GET
    @Path("getId")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@Context HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getId();
    }

    @GET
    @Path("setValue/{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public String setValue(@PathParam("value") String value, @Context HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userid", value);
        return "SessionId:" + session.getId() + ", Value:" + value;
    }

    @GET
    @Path("setValue/{sessionId}/{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public String setValue(@PathParam("sessionId") String sessionId, @PathParam("value") String value) {
        XdataSessionContext context = XdataSessionContext.getInstance();
        HttpSession session = context.getSession(sessionId);
        session.setAttribute("userid", value);
        return "SessionId:" + session.getId() + ", Value:" + value;
    }

    @GET
    @Path("getValue")
    @Produces(MediaType.TEXT_PLAIN)
    public String getValue(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        return "SessionId:" + session.getId() + ", Value:" + session.getAttribute("userid");
    }

    @GET
    @Path("getValue/{sessionId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getValue(@PathParam("sessionId") String sessionId){
        XdataSessionContext context = XdataSessionContext.getInstance();
        HttpSession session = context.getSession(sessionId);
        return "SessionId:" + session.getId() + ", Value:" + session.getAttribute("userid");
    }

    @GET
    @Path("destroy")
    @Produces(MediaType.TEXT_PLAIN)
    public String destroy(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "session is destroy!";
    }

    @Path("destroy/{sessionId}")
    public String destroy(@PathParam("sessionId") String sessionId){
        XdataSessionContext context = XdataSessionContext.getInstance();
        HttpSession session = context.getSession(sessionId);
        session.invalidate();
        return "session is destroy!";
    }

}
