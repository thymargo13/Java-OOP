/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.servlet;

import cfd.bean.*;

import cfd.db.OtherProduct_DB;
import cfd.db.Product_DB;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DetermineProduct", urlPatterns = "/getProduct")
public class DetermineProduct extends HttpServlet {

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
        String type = null;

        type = request.getParameter("type");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //String action = request.getParameter("action");
            ArrayList allproduct = null;

            ArrayList<OtherProductBean> allotherproduct = null;
            if ("hs".equalsIgnoreCase(type)) {
                ArrayList<HoodyBean> hoody = product_db.showHoody();
                request.setAttribute("product", hoody);
            } else if ("jc".equalsIgnoreCase(type)) {
                ArrayList<CoatBean> coat = product_db.showCoat();
                request.setAttribute("product", coat);
            } else if ("shorts".equalsIgnoreCase(type)) {
                ArrayList<ShortBean> shorts = product_db.showShort();
                request.setAttribute("product", shorts);
            } else if ("pants".equalsIgnoreCase(type)) {
                ArrayList<PantBean> pants = product_db.showPant();
                request.setAttribute("product", pants);
            } else if ("bags".equalsIgnoreCase(type)) {
                ArrayList<BagBean> bags = o_db.showBag();
                request.setAttribute("product", bags);
            } else if ("hats".equalsIgnoreCase(type)) {
                ArrayList<AccessoryBean> hats = o_db.showHat();
                request.setAttribute("product", hats);
            } else if ("glasses".equalsIgnoreCase(type)) {
                ArrayList<AccessoryBean> glasses = o_db.showGlasses();
                request.setAttribute("product", glasses);
            } else if ("watches".equalsIgnoreCase(type)) {
                ArrayList<AccessoryBean> watches = o_db.showWatches();
                request.setAttribute("product", watches);
            }

            //out.println(action);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ProductDisplay.jsp");
            rd.forward(request, response);
        }

    }
}
