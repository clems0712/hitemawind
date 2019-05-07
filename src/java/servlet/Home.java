/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employees;
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
        String email = request.getParameter("email");
        Implementation data = new Implementation();
        Employees employe = data.getEmployeesByEmail(email);
        System.out.print(employe);
        if(employe != null){
            request.getRequestDispatcher("/index.html").forward(request, response);
        }else{
            request.getRequestDispatcher("/connexion.html").forward(request, response);
        }
//        switch (button) {
//            case "commande":
//                request.setAttribute("data", data.getListOrders());
//                System.out.println("servlet.Home.doPost()"+ data.getListOrders());
//                request.getRequestDispatcher("/listeCommandes.jsp").forward(request, response);
//            default:
//                doGet(request, response);
//        }
        
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
