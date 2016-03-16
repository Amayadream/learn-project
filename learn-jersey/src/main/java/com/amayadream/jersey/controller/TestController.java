package com.amayadream.jersey.controller;

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
 * @date :  2016.03.09 23:16
 */
@Path(value = "test")
public class TestController {

    @Context HttpServletRequest request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World!" ;
    }

    @GET
    @Path("{param}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHelloToUTF8(@PathParam("param") String username) {
        return "Hello " + username;
    }

    @GET
    @Path("set")
    @Produces(MediaType.TEXT_PLAIN)
    public String set() {
        HttpSession session = request.getSession();
        session.setAttribute("userid", "Amayadream");
        return "success to set session, name is Amayadream, value is " +  session.getAttribute("userid");
    }

    @GET
    @Path("get")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        HttpSession session = request.getSession();
        return "Hello, " + session.getAttribute("userid");
    }

}
