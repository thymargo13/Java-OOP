/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.servlet;

import cfd.bean.OtherProductBean;
import cfd.db.OtherProduct_DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thymmm
 */
@WebServlet(name = "handleOtherProductUpdate", urlPatterns = {"/cms/updateProduct"})
public class handleOtherProductUpdate extends HttpServlet {

    private OtherProduct_DB _opb;

    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        _opb = new OtherProduct_DB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("edit")) {
                //get request....
                String brand = request.getParameter("brand");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String price = request.getParameter("price");
                String stock = request.getParameter("stock");
                String status = request.getParameter("status");
                String id = request.getParameter("id");
                //String acc = request.getParameter("accessory");
                // check is it bag or accessory
                if (request.getParameter("accessory")!=null) {
                    String redeem = request.getParameter("redeem");
                    String pType = request.getParameter("pType");
                    _opb.updateAccessory(id, brand, name, description, price, stock, status, redeem, pType);
                } else  {
                    _opb.updateBag(id, brand, name, description, price, stock, status);
                }

                response.sendRedirect("other.jsp");
            }
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
        processRequest(request, response);
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
