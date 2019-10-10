/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.servlet;

import cfd.db.OtherProduct_DB;
import cfd.db.Product_DB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ProductDetails", urlPatterns = "/productDetail")
public class ProductDetails extends HttpServlet {

    private Product_DB product_db;
    private OtherProduct_DB o_db;

    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        product_db = new Product_DB(dbUrl, dbUser, dbPassword);
        o_db = new OtherProduct_DB(dbUrl, dbUser, dbPassword);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pid = request.getParameter("pid");
        String index = request.getParameter("i");

        request.setAttribute("pid", pid);
        request.setAttribute("index", index);
        System.out.println("pid: " + pid + " index:" + index);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/DisplayProductDetails.jsp");
        rd.forward(request, response);

    }
}
