/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.servlet;

import cfd.bean.StaffBean;
import cfd.db.StaffDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thymmm
 */
@WebServlet(name = "CMSLoginControl", urlPatterns = {"/cms/CMSLogin"})
public class CMSLoginControl extends HttpServlet {

    private StaffDB staff_db;
    
    @Override
    public void init() throws ServletException {
        String url = this.getServletContext().getInitParameter("dbUrl");
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        staff_db = new StaffDB(url, username, password);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String staffId = request.getParameter("staffId");
           String pw = request.getParameter("pwd");
         
           if(staff_db.login(staffId, pw)){
               HttpSession session = request.getSession();
               session.setAttribute("sid", staffId);
               StaffBean staff = staff_db.queryStaffById(staffId);
               String post = staff.getPosition();
               if(post.equalsIgnoreCase("admin")){
                   session.setAttribute("post", "admin");
                   
               }else{
                     session.setAttribute("post", "");
               }               
               request.getRequestDispatcher("custList.jsp").forward(request,response);
           }else{
               request.setAttribute("message", "Incorrect ID or password.");
               response.sendRedirect("index.jsp");
               // request.getRequestDispatcher().forward(request,response);
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
          String action = request.getParameter("action");
          if(action.equalsIgnoreCase("logout")){
              HttpSession session = request.getSession();
              session.removeAttribute("sid");
              request.getRequestDispatcher("index.jsp").forward(request, response);
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
