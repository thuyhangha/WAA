/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hangha
 */
@WebServlet(name = "GuessNumberServlet", urlPatterns = {"/GuessNumberServlet"})
public class GuessNumberServlet extends HttpServlet {

    private Integer randNumber = -1;

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
            out.println("<title>Servlet GuessNumberServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuessNumberServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        if (randNumber < 0) {
            Random rand = new Random();
            randNumber = rand.nextInt(10 - 1) + 1;
        }

        String guessNumber = request.getParameter("txtNumber");

        if (guessNumber == null) {
            out.println("<html>");
            out.println("<body>");
            out.println("<form method=GET action=GuessNumberServlet>");
            out.println("Guess number <input type=text name=txtNumber> <br>");
            out.println("<input type=submit value='CheckGuessNumber'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } else {
            try {
                Integer inputNumber = Integer.parseInt(guessNumber);
                if (inputNumber.equals(randNumber)) {
                    out.println("Correct, congratulations!");
                } else if (inputNumber.compareTo(randNumber) > 0) {
                    out.println("Too high, try again ");
                } else {
                    out.println("Too low, try again ");
                }
            } catch (NumberFormatException ex) {
                out.println("Please input valid number.");
                out.close();
            }
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
        processRequest(request, response);
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
