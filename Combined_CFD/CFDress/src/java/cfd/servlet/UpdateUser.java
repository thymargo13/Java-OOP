/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.servlet;

import cfd.bean.CustomerBean;
import cfd.db.Customer_DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "UpdateUser", urlPatterns = {"/cms/UpdateUser"})
public class UpdateUser extends HttpServlet {

    private Customer_DB db;

    @Override
    public void init() throws ServletException {
        String url = this.getServletContext().getInitParameter("dbUrl");
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        db = new Customer_DB(url, username, password);
    }

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
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            String fName = request.getParameter("fName");

            if (!fName.equals("")) {
                db.updateUserFname(id, fName);
            }

            String lName = request.getParameter("lName");
            if (!lName.equals("")) {
                db.updateUserLname(id, lName);
            }

            String email = request.getParameter("email");
            if (!email.equals("")) {
                db.updateUserEmail(id, email);
            }

            String phone = request.getParameter("phone");
            if (!phone.equals("")) {
                db.updateUserPhone(id, phone);
            }

            String gender = request.getParameter("gender");

            if (!gender.equals("Not Change")) {
                db.updateUserGender(id, gender);
            }

            String dob = request.getParameter("dob");
            if (!dob.equals("")) {
                db.updateUserDob(id, Date.valueOf(dob));
            }

            request.setAttribute("id", id);
            request.getRequestDispatcher("ViewUser").forward(request, response);
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
