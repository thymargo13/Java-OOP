package cfd.taglib;

import cfd.bean.CustomerBean;
import cfd.db.Customer_DB;
import java.util.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Daniel
 */
public class ShowRegisteredCustomer extends SimpleTagSupport {

    private List<CustomerBean> customersList;
    private Customer_DB db;

    public ShowRegisteredCustomer() {
        String url = "jdbc:mysql://127.0.0.1:3306/cfd_db";
        String username = "root";
        String password = "";
        db = new Customer_DB(url, username, password);
        customersList = db.getRequestedCustomers();
    }

    public void doTag() {
        System.out.println("doTag");
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            String result = "";
            String temp = "";
            /*
            <th>ID</th>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                        <th>RegDate</th>
                        <th>Status</th>
             */
            
            for (CustomerBean bean : customersList) {
                temp = "";
                temp += "<tr>";
                temp += "<td>" + bean.getId() + "</td>";
                temp += "<td>" + bean.getFname() + "</td>";
                temp += "<td>" + bean.getLname() + "</td>";
                temp += "<td>" + bean.getEmail() + "</td>";
                temp += "<td>" + bean.getRegDate() + "</td>";
                temp += "<td>" + bean.getStatus() + "</td>";
                temp += "<td><a href=\"../VerifyUser?id=" + bean.getId() + "\">" + "<button type=\"button\" class=\"btn btn-success\">Confirm</button>"
                        + "</a></td>";
                temp += "</tr>\n";
                System.out.println(temp);
                result += temp;
            }

            out.println(result);
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
}
