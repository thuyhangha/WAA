/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.waa.model.Person;

/**
 *
 * @author hangha
 */
@WebServlet(name = "allnamesservlet", urlPatterns = {"/allnamesservlet"})
public class allnamesservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet allnamesservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet allnamesservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        List<Person> lstPerson = (List<Person>) session.getAttribute("persons");

        // print the results
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>All Names Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>List of names</p>");
        if (lstPerson != null) {
            for (int i = 0; i < lstPerson.size(); i++) {
                out.println("<div><span>key=" + lstPerson.get(i).getKey() + "</span> <span>First Name=" + lstPerson.get(i).getFirstName() + "</span> <span>Last Name=" + lstPerson.get(i).getLastName() + "</span></div>");
            }
        }
        out.println("</br>");
        out.println("<div>");
        out.println("<form method=\"POST\" action=\"allnamesservlet\">");
        out.println("<input type=\"submit\" value=\"Show all names\"/>");
        out.println("</form>");
        out.println("</div>");
        out.println("</br>");
        out.println("<div>");
        out.println("<form method=\"GET\" action=\"addnamesservlet\">");
        out.println("<span>Key=</span><input type=\"text\" name=\"key\"/>");
        out.println("<span>First Name=</span><input type=\"text\" name=\"firstName\" />");
        out.println("<span>Last Name=</span><input type=\"text\" name=\"lastName\" />");
        out.println("<input type=\"submit\" value=\"Add\" />");
        out.println("</form>");
        out.println("</div>");
        out.println("<div>");
        out.println("<form method=\"GET\" action=\"removenamesservlet\">");
        out.println("<span>Key=</span><input type=\"text\" name=\"key\" />");
        out.println("<input type=\"submit\" value=\"Remove\" />");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
