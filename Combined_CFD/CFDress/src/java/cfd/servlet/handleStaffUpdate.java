/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.servlet;

import cfd.db.StaffDB;
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
@WebServlet(name = "handleStaffUpdate", urlPatterns = {"/cms/handleEdit"})
public class handleStaffUpdate extends HttpServlet {
    private StaffDB sb;
    
   @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        sb = new StaffDB(dbUrl, dbUser, dbPassword);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if(action.equalsIgnoreCase("edit")){
                String id = request.getParameter("id");
                String date = request.getParameter("date");
                String pwd = request.getParameter("pwd");
                String fName = request.getParameter("fName");
                String lName = request.getParameter("lName");
                String post = request.getParameter("post");
                String work = request.getParameter("work");
                sb.updateStaff(id,pwd,fName,lName,post,work);
               // request.getRequestDispatcher("CMSLogin?action=logout").forward(request,response);
                response.sendRedirect("CMSLogin?action=logout");
            }
            else if(action.equalsIgnoreCase("delete")){
                String id = request.getParameter("id");
                sb.deleteStaff(id);
                 //request.getRequestDispatcher("CMSLogin?action=logout").forward(request,response);
                response.sendRedirect("CMSLogin?action=logout");
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
