package servlet;

import client.GarmentClient;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import model.Garment;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@WebServlet("/garments")
public class GarmentServlet extends HttpServlet {

    @Inject
    @RestClient
    private GarmentClient garmentClient;

    // =========================
    // READ - GET ALL
    // =========================

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            // Get single garment
            if ("edit".equals(action)) {

                Integer id = Integer.parseInt(
                        request.getParameter("id")
                );

                Garment garment = garmentClient.getGarmentById(id);

                request.setAttribute("garment", garment);

                request.getRequestDispatcher("editGarment.jsp")
                        .forward(request, response);

                return;
            }

            // Get garments by category
            if ("category".equals(action)) {

                String category = request.getParameter("category");

                List<Garment> garments =
                        garmentClient.getByCategory(category);

                request.setAttribute("garments", garments);

                request.getRequestDispatcher("garments.jsp")
                        .forward(request, response);

                return;
            }

            // Default - Get all garments
            List<Garment> garments =
                    garmentClient.getAllGarments();

            request.setAttribute("garments", garments);

            request.getRequestDispatcher("garments.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Error while retrieving garments"
            );
        }
    }

    // =========================
    // CREATE / UPDATE / DELETE
    // =========================

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            // =========================
            // CREATE
            // =========================

            if ("add".equals(action)) {

                Garment garment = new Garment();

                garment.setGarmentid(
                        Integer.parseInt(
                                request.getParameter("garmentid")
                        )
                );

                garment.setGarmentname(
                        request.getParameter("garmentname")
                );

                garment.setSize(
                        request.getParameter("size")
                );

                garment.setCategory(
                        request.getParameter("category")
                );

                garment.setDescription(
                        request.getParameter("description")
                );

                garment.setPrice(
                        new BigDecimal(
                                request.getParameter("price")
                        )
                );

                garment.setStock(
                        Integer.parseInt(
                                request.getParameter("stock")
                        )
                );

                garmentClient.addGarment(garment);

                response.sendRedirect("garments");

                return;
            }

            // =========================
            // UPDATE
            // =========================

            if ("update".equals(action)) {

                Integer id = Integer.parseInt(
                        request.getParameter("garmentid")
                );

                Garment garment = new Garment();

                garment.setGarmentid(id);

                garment.setGarmentname(
                        request.getParameter("garmentname")
                );

                garment.setSize(
                        request.getParameter("size")
                );

                garment.setCategory(
                        request.getParameter("category")
                );

                garment.setDescription(
                        request.getParameter("description")
                );

                garment.setPrice(
                        new BigDecimal(
                                request.getParameter("price")
                        )
                );

                garment.setStock(
                        Integer.parseInt(
                                request.getParameter("stock")
                        )
                );

                garmentClient.updateGarment(id, garment);

                response.sendRedirect("garments");

                return;
            }

            // =========================
            // DELETE
            // =========================

            if ("delete".equals(action)) {

                Integer id = Integer.parseInt(
                        request.getParameter("id")
                );

                garmentClient.deleteGarment(id);

                response.sendRedirect("garments");

                return;
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Error while processing garment"
            );
        }
    }
}