/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.taglib;

import cfd.bean.InvoiceBean;
import cfd.db.Invoice_DB;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 *
 * @author thymmm
 */
public class ListInvoice extends SimpleTagSupport{

    private ArrayList<InvoiceBean> invoiceList;
    private Invoice_DB db;
    private String id, fname, lname, status;

    public ListInvoice() {
        String url = "jdbc:mysql://127.0.0.1:3306/cfd_db";
        String username = "root";
        String password = "";
        db = new Invoice_DB(url, username, password);
    }

    public void doTag() {
        System.out.println("doTag");
        System.out.println(this.toString());
        try {
            PageContext pageContext;
            pageContext = (PageContext)getJspContext();
            JspWriter out = pageContext.getOut();
     
            invoiceList = db.showAllInvoice();
            
            int i = 0;
          
            for (InvoiceBean bean : invoiceList) {
                i++;
                
                out.println("<tr><td>" + bean.getInvoiceDate() + "</td>");
                out.println("<td>" + bean.getInvoiceId() + "</td>");
                out.println("<td>" + bean.getCid() + "</td>");
                out.println("<td>" + bean.getDeliveryDate() + "</td>");
                out.println("<td>" + bean.getAddress() + "</td>");
                out.println("<td>" + bean.getSid() + "</td>");
                out.println("<form action=\"InvoiceStatusControl\" method=\"get\"/>");
                out.println("<td><input type=\"text\" name=\"status\"value=\"" + bean.getStatus() + "\"/></td>");
                out.println("<input type=\"hidden\" name=\"inoviceId\" value=\""+bean.getInvoiceId()+"\"/>");
                out.println("<td><input type=\"submit\" value=\"Save\"/></td></tr>");
                out.println("</form>");
               

                System.out.println(i);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
