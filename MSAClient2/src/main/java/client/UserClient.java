/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package client;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.User;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="myclient")
public interface UserClient {
    
    @ClientHeaderParam(name = "Authorization", value="{getToken}")
    @RolesAllowed("cheif")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(@RequestBody User user);
    
    @ClientHeaderParam(name = "Authorization", value="{getToken}")
    @RolesAllowed("cheif")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUser();
    
    default String getToken(){
        Config config = ConfigProvider.getConfig();
        String token = "Bearer " + config.getValue("jwt-string", String.class);
        return token;
    }
}
