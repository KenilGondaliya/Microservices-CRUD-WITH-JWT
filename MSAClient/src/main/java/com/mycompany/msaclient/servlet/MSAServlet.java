/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.msaclient.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import client.ExampleClient;


@WebServlet(name = "MSAServlet", urlPatterns = {"/MSAServlet"})
public class MSAServlet extends HttpServlet {
    
    @Inject
    @RestClient
    ExampleClient ex;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("<h1>Response : " + ex.get() + "</h1>");

        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void getPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    public String ServletInfo(){
        return "MSA Servelt";
    }
}
