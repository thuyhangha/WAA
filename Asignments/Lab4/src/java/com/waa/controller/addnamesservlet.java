package com.waa.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(urlPatterns = {"/addnamesservlet"})
public class addnamesservlet extends HttpServlet {

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
            out.println("<title>Servlet addnamesservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addnamesservlet at " + request.getContextPath() + "</h1>");
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
  
        Integer key = -1;
        try {
            key = Integer.parseInt(request.getParameter("key"));
        } catch (NumberFormatException ex) {
            out.println("Please input valid number. " + ex.getMessage());
            out.close();
        }

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
  
        if (firstName == null || lastName == null) {
            out.println("The input value cannot blank. ");
            out.close();
        } else {
            HttpSession session = request.getSession();
            List<Person> lstPerson = (List<Person>) session.getAttribute("persons");
            if (lstPerson == null) {
                lstPerson = new ArrayList<>();
                session.setAttribute("persons", lstPerson);
            }
          
            lstPerson.add(new Person(key, firstName, lastName));

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Add names servlet</title>");
            out.println("</head>");
            out.println("<body>");
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
