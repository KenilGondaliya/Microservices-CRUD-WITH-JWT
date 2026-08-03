package com.mycompany.msaapp2.service;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/example")
public class ExampleService {

    @GET
    @RolesAllowed("chief")
    public Response get() {
        return Response.ok("Hello, world! from MSAApp1.....Authorized").build();
    }
}
