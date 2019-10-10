/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.servlet;

import cfd.bean.CustomerAddressBean;
import cfd.bean.CustomerBean;
import cfd.db.AddressBook_DB;
import cfd.db.Customer_DB;
import cfd.exception.SameEmailHasFound;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "RegisterUser", urlPatterns = {"/RegisterUser"})
public class RegisterUser extends HttpServlet {

    private Customer_DB db;
    private AddressBook_DB ab;

    @Override
    public void init() throws ServletException {
        String url = this.getServletContext().getInitParameter("dbUrl");
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        db = new Customer_DB(url, username, password);
        ab = new AddressBook_DB(url, username, password);
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterUser at " + request.getContextPath() + "</h1>");
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
        String id, fname, lname, email, gender, phone, day, month, year, address1, address2;
        Date dob;
        
        try {
            fname = request.getParameter("fname");
            lname = request.getParameter("lname");
            email = request.getParameter("email");
            
            id = "c"+(db.getRowsNum()+1);
            
            if(db.hasSameEmail(email))
                throw new SameEmailHasFound();
            
            if(db.addRecordByMinRequirement(id, email, fname, lname))
                System.out.println(fname+" "+lname+" was inserted successfully");

            gender = request.getParameter("gender");
            if(!gender.equals("later")){
                
                db.updateUserGender(id, gender);
            }
            
            phone = request.getParameter("phone");
            if(phone != null || phone != ""){
                
                db.updateUserPhone(id, phone);
            }
            
            day = request.getParameter("day");
            month = request.getParameter("month");
            year = request.getParameter("year");
            
            dob = Date.valueOf(year+"-"+month+"-"+day);
            if(!dob.equals(Date.valueOf("2006-01-01"))){
                db.updateUserDob(id, dob);
            } 
            
            CustomerBean c = db.getCustomer(id);
            System.out.println(c);
            
            address1 = request.getParameter("address1");
            if(address1 != null || !address1.equals(""))
                ab.addUserAddress(id, address1);
            
            address2 = request.getParameter("address2");
            if(address2 != null || !address2.equals(""))
                ab.addUserAddress(id, address2);
            
            List<CustomerAddressBean> list = ab.getAddressesByCustomer(id);
            
            for(int i=0; i< list.size(); i++) // i cant use for(CustomerAddressBean cab : list)
                System.out.println(list.get(i));
            
            request.setAttribute("id", c.getId());
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } catch(SameEmailHasFound e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
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
