/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.taglib;

import cfd.bean.ProductBean;
import cfd.db.Product_DB;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author thymmm
 */

public class ListProduct extends SimpleTagSupport {

        private ArrayList<ProductBean> _productBean;
    private Product_DB db;
    private String id, fname, lname, status;

    public ListProduct() {
        String url = "jdbc:mysql://127.0.0.1:3306/cfd_db";
        String username = "root";
        String password = "";
        db = new Product_DB(url, username, password);
    }
    
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
           PageContext pageContext = (PageContext) getJspContext();
            String result = "";
            String temp = "";

            _productBean = db.showAllProduct();

            int i = 0;
            String color = "";
            for (ProductBean bean : _productBean) {
                i++;
                out.println("<tr><td><img src =\"../" + bean.getImg()+ "\" width=100px height=100px \\></td>");
                out.println("<td>" + bean.getPid()+ "</td>");
                out.println("<td>" + bean.getpName() + "</td>");
                out.println("<td>" + bean.getpBrand()+ "</td>");
                out.println("<td>" + bean.getDescription()+ "</td>");
                out.println("<td>" + bean.getPrice()+ "</td>");
                //out.println("<td>" + bean.getStock() + "</td>");
                out.println("<td>" + "<form action=\"handleProduct\" method=\"Post\"><input type=\"hidden\" name=\"id\" value=\""
                        + bean.getPid() + "\"><input type=\"hidden\" name=\"action\" value=\"edit\"/><input type=\"submit\"value=\"Info\""
                        + " class=\"btn btn-info\"></input></form>");
           

                System.out.println(i);
            }
            
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
