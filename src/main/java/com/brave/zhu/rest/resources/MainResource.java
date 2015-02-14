package com.brave.zhu.rest.resources;

import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("main")
public interface MainResource
{
    @POST
    @Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, ?> doPost(@FormParam("taskId") String taskId);
    
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, ?> doGet(@QueryParam("taskId") String taskId);
}
