/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.taglib;

import cfd.bean.OtherProductBean;
import cfd.db.OtherProduct_DB;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author thymmm
 */
public class ShowAllOtherProduct extends SimpleTagSupport {

    private ArrayList<OtherProductBean> OPBean;
    private OtherProduct_DB db;
    private String id, fname, lname, status;

    public ShowAllOtherProduct() {
        String url = "jdbc:mysql://127.0.0.1:3306/cfd_db";
        String username = "root";
        String password = "";
        db = new OtherProduct_DB(url, username, password);
    }

    public void doTag() {
      
        
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            String result = "";
            String temp = "";

            OPBean = db.showAllOtherProduct();

            int i = 0;
            String color = "";
            for (OtherProductBean bean : OPBean) {
                i++;
                out.println("<tr><td><img src =\"../" + bean.getImg()+ "\" width=100px height=100px \\></td>");
                out.println("<td>" + bean.getPid()+ "</td>");
                out.println("<td>" + bean.getpName() + "</td>");
                out.println("<td>" + bean.getpBrand()+ "</td>");
                out.println("<td>" + bean.getDescription()+ "</td>");
                out.println("<td>" + bean.getPrice()+ "</td>");
                out.println("<td>" + bean.getStock() + "</td>");
                out.println("<td>" + "<form action=\"handleOtherProduct\" method=\"post\"><input type=\"hidden\" name=\"id\" value=\""
                        + bean.getPid() + "\"><input type=\"hidden\" name=\"action\" value=\"edit\"/><input type=\"submit\"value=\"Info\""
                        + " class=\"btn btn-info\"></input></form>");
           

                System.out.println(i);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
