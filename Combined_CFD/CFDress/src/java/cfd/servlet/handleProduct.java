/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.servlet;

import cfd.bean.ClothingSizeBean;
import cfd.bean.ProductBean;
import cfd.db.Product_DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thymmm
 */
@WebServlet(name = "handleProduct", urlPatterns = {"/cms/handleProduct"})
public class handleProduct extends HttpServlet {

    private Product_DB product_db;

    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        product_db = new Product_DB(dbUrl, dbUser, dbPassword);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
           String action = request.getParameter("action");
            
        //out.println(action);
        if (action.equalsIgnoreCase("add")) {
                String type = request.getParameter("type");
                String brand = request.getParameter("brand");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String p = request.getParameter("price");
                
                String xl = request.getParameter("xlargeStock");
                int xlStock; 
                if(xl==null||xl.equals("")){
                   xlStock =  0;
                }else{
                    xlStock =  Integer.parseInt(xl);
                }
                
                int lStock;
                if(request.getParameter("largeStock")==null||request.getParameter("largeStock").equals("")){
                   lStock =  0;
                }else{
                    lStock =  Integer.parseInt(request.getParameter("largeStock"));
                }
                String m = request.getParameter("middleStock");
                int mStock; 
                if(m==null||m.equals("")){
                   mStock =  0;
                }else{
                    mStock =  Integer.parseInt(request.getParameter("middleStock"));
                }
                String s = request.getParameter("smallStock");
                int slStock; 
                if(s==null||s.equals("")){
                   slStock =  0;
                }else{
                    slStock =  Integer.parseInt(s);
                }
              
       
                double price = Double.parseDouble(p);
                
                if (type.equalsIgnoreCase("pant")) {
                    product_db.addPant(brand,  description,  price, name, xlStock,lStock,mStock,slStock);
                }
                if(type.equalsIgnoreCase("short")){
                    product_db.addShort(brand,  description,  price, name, xlStock,lStock,mStock,slStock);
                }
                if(type.equalsIgnoreCase("hoodie")){
                    product_db.addHoody(brand,  description,  price, name, xlStock,lStock,mStock,slStock);
                }
                if(type.equalsIgnoreCase("coat")){
                    product_db.addCoat(brand,  description,  price, name, xlStock,lStock,mStock,slStock);
                }
                response.sendRedirect("clothing.jsp");
        }else if(action.equalsIgnoreCase("edit")){
            String id = request.getParameter("id");
                if (id != null) {
                    //call query to get retrieve or a cust with given id.
                    ProductBean product = new ProductBean();
                    product = product_db.queryProductById(id);
                    product.setCs(product_db.queryProductSizeById(id)); 
                    request.setAttribute("p", product);
                    
                    //request.setAttribute("ps",productSize);
                    request.getRequestDispatcher("editProduct.jsp").forward(request, response);
                   
                }
        
        }
        }catch(Exception e){
            out.println("<h1>Please Enter Product information!!!</h1>");
            out.println("<a href=\"clothing.jsp\"/>Back</a>");
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
