/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.servlet.customer;

import cfd.bean.CustomerBean;
import cfd.db.Customer_DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "CustomerUpdate", urlPatterns = {"/CustomerUpdate"})
public class CustomerUpdate extends HttpServlet {

    private Customer_DB db;
    //private AddressBook_DB ab;

    @Override
    public void init() throws ServletException {
        String url = this.getServletContext().getInitParameter("dbUrl");
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        db = new Customer_DB(url, username, password);
        //ab = new AddressBook_DB(url, username, password);
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

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
        String id, fname, lname, email, phone, dob_String, gender, oldEmail;
        Date dob;
        String isSuccess = "false"; // i cant pass a boolean value to next page

        id = request.getParameter("id");
        fname = request.getParameter("fname");
        lname = request.getParameter("lname");
        email = request.getParameter("email");
        phone = request.getParameter("phone");
        gender = request.getParameter("gender");
        dob_String = request.getParameter("dob");
        oldEmail = request.getParameter("oldEmail");

        if (!fname.equals("")) {
            db.updateUserFname(id, fname);
            
        }

        if (!lname.equals("")) {
            db.updateUserLname(id, lname);
            
        }

        if (!email.equals("") && !email.equals(oldEmail)) {
            if (!db.hasSameEmail(email)) {
                db.updateUserEmail(id, email);
                isSuccess = "true";
            }
        }

        if (!phone.equals("")) {
            db.updateUserPhone(id, phone);
            
        }

        if (!dob_String.equals("")) {
            dob = Date.valueOf(dob_String);
            db.updateUserDob(id, dob);
            
        }

        db.updateUserGender(id, gender);

        CustomerBean c = db.getCustomer(id);

        request.setAttribute("customer", c);
        request.setAttribute("isSuccess", isSuccess);
        request.getRequestDispatcher("showCustomerInfo.jsp").forward(request, response);
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
