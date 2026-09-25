package service;

import ejb.GarmentBeanLocal;
import entity.Garmentmaster;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/garments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GarmentService {

    @EJB
    private GarmentBeanLocal garmentBean;

    // GET ALL
    @GET
    public List<Garmentmaster> getAllGarments() {
        return garmentBean.getAllGarments();
    }

    // GET BY ID
    @GET
    @Path("/{id}")
    public Response getGarmentById(@PathParam("id") Integer id) {

        Garmentmaster garment = garmentBean.getGarmentById(id);

        if (garment == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Garment not found")
                    .build();
        }

        return Response.ok(garment).build();
    }

    // CREATE
    @POST
    public Response addGarment(Garmentmaster garment) {

        garmentBean.addGarment(garment);

        return Response
                .status(Response.Status.CREATED)
                .entity(garment)
                .build();
    }

    // UPDATE
    @PUT
    @Path("/{id}")
    public Response updateGarment(
            @PathParam("id") Integer id,
            Garmentmaster garment) {

        Garmentmaster existing = garmentBean.getGarmentById(id);

        if (existing == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Garment not found")
                    .build();
        }

        garment.setGarmentid(id);
        garmentBean.updateGarment(garment);

        return Response.ok(garment).build();
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    public Response deleteGarment(@PathParam("id") Integer id) {

        Garmentmaster existing = garmentBean.getGarmentById(id);

        if (existing == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Garment not found")
                    .build();
        }

        garmentBean.deleteGarment(id);

        return Response.ok("Garment deleted successfully").build();
    }

    
}