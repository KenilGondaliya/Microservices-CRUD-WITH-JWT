package com.mycompany.msaclient2.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient(configKey="myclient")
public interface ExampleClient {
    
    @GET
    @ClientHeaderParam(name="Authorization", value="{getToken}")
    @Produces(MediaType.TEXT_PLAIN)
    String get();
    
    default String getToken(){
        Config config = ConfigProvider.getConfig();
        String token = "Bearer " + config.getValue("jwt-string", String.class) ;
        System.out.println("Token = "+token);
        return token;
    }
}
