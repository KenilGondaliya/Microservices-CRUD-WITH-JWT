/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.msaclient2.servlet;

import client.UserClient;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.Response;
import java.util.List;
import model.User;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@WebServlet(name = "MSAServlet", urlPatterns = {"/MSAServlet"})
public class MSAServlet extends HttpServlet {

    @Inject
    @RestClient
    UserClient client;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Response : " + request.getContextPath() + "</h1>");
            Response res = client.getAllUser();

            if (res.hasEntity()) {
                List<User> users = res.readEntity(List.class);
                out.println("<h1>Response : " + users.toString() + "</h1>");

            } else {
                out.println("<h1>Response : " + "No Data" + "</h1>");

            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void getPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String ServletInfo() {
        return "MSA Servelt";
    }
}
