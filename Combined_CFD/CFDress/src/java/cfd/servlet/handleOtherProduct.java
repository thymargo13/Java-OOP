package cfd.servlet;

import cfd.bean.OtherProductBean;
import cfd.db.OtherProduct_DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author thymmm
 */
@WebServlet(name = "handleOtherProduct", urlPatterns = {"/cms/handleOtherProduct"})
@MultipartConfig
public class handleOtherProduct extends HttpServlet {

    private OtherProduct_DB o_db;

    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        o_db = new OtherProduct_DB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =   response.getWriter() ;
            String action = request.getParameter("action");
            
        //out.println(action);
        if (action.equalsIgnoreCase("add")) {
                String type = request.getParameter("type");
                
                String brand = request.getParameter("brand");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String p = request.getParameter("price");
                String qty = request.getParameter("qty");
                
                int stock = Integer.parseInt(qty);
                double price = Double.parseDouble(p);
                
                if (type.equalsIgnoreCase("bag")) {
                    o_db.addBag(brand,  description,  price, name,stock);
                }
                if(type.equalsIgnoreCase("accessory")){
                    String redeemPt = request.getParameter("redeem");
                     String pType = request.getParameter("pType");
                    int redeem = Integer.parseInt(redeemPt);
                    o_db.addAccessory(brand,  description,  price, name,redeem,stock,pType);
                }
                response.sendRedirect("other.jsp");
        }else if(action.equalsIgnoreCase("edit")){
            String id = request.getParameter("id");
            System.out.println(id);
                if (id != null) {
                    //call query to get retrieve or a cust with given id.
                    OtherProductBean opb = o_db.queryOtherProductById(id);
                    request.setAttribute("s", opb);
                    //System.out.println(opb);
                    //response.sendRedirect("CMS/editStaff.jsp");
                    request.getRequestDispatcher("editOtherProduct.jsp").forward(request, response);
                    /*request.getDispatcher = getServletContext().getRequestDispatcher("CMS/editStaff.jsp");
                    dispatcher.forward(request, response);*/
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
