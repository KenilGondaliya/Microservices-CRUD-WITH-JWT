package client;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import model.Garment;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/garments")
@RegisterRestClient(configKey = "garmentclient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface GarmentClient {

    // GET ALL
    @GET
    List<Garment> getAllGarments();

    // GET BY ID
    @GET
    @Path("/{id}")
    Garment getGarmentById(@PathParam("id") Integer id);

    // CREATE
    @POST
    Garment addGarment(Garment garment);

    // UPDATE
    @PUT
    @Path("/{id}")
    Garment updateGarment(
            @PathParam("id") Integer id,
            Garment garment
    );

    // DELETE
    @DELETE
    @Path("/{id}")
    String deleteGarment(@PathParam("id") Integer id);

    // GET BY CATEGORY
    @GET
    @Path("/category/{category}")
    List<Garment> getByCategory(
            @PathParam("category") String category
    );
}