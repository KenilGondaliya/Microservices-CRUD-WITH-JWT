package com.mycompany.msaapp.service;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/example")
public class ExampleService {
    @GET
    @RolesAllowed("chief")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {

        return "Hello, world! of Micro Profile from Trial App";
    }

}
