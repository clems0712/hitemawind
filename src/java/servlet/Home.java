/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Implementation;

/**
 *
 * @author Darman
 */
public class Home extends HttpServlet {

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
       request.getRequestDispatcher("/home.jsp").forward(request, response);
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
        String button = request.getParameter("button");
        Implementation data = new Implementation();
        request.setAttribute("test", data.getListOrders());
        
        switch (button) {
            case "commande":
                request.setAttribute("data", data.getListOrders());
                request.getRequestDispatcher("/listeCommandes.jsp").forward(request, response);
            case "facture" :
                request.setAttribute("data", data.getListInvoices());
                request.getRequestDispatcher("/listInvoices.jsp").forward(request, response);
            case "employe": 
                request.setAttribute("data", data.getListEmployes());
                request.getRequestDispatcher("/listEmployes.jsp").forward(request, response);
            case "client": 
                request.setAttribute("data", data.getListCustomezs());
                request.getRequestDispatcher("/listClients.jsp").forward(request, response);
            default:
                doGet(request, response);
        }
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
