/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package client;

/**
 *
 * @author KENIL GONDALIYA
 */
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.io.ObjectInputFilter.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "myclient")
public interface ExampleClient {

    @GET
    @ClientHeaderParam(name = "Authorization", value = "{generateJWTToken}")
    @Produces(MediaType.TEXT_PLAIN)
    String get();

    default String generateJWTToken() {
        org.eclipse.microprofile.config.Config config = ConfigProvider.getConfig();
        return "Bearer " + config.getValue("jwt-string", String.class);
    }
}
