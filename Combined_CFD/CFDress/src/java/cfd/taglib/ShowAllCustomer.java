package cfd.taglib;

import cfd.bean.CustomerBean;
import cfd.db.Customer_DB;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Daniel
 */
public class ShowAllCustomer extends SimpleTagSupport{
    private List<CustomerBean> customersList;
    private Customer_DB db;
    private String id, fname, lname, status;
    private boolean filling = false;
    public ShowAllCustomer(){
        String url = "jdbc:mysql://127.0.0.1:3306/cfd_db";
        String username = "root";
        String password = "";
        db = new Customer_DB(url, username, password);
        
        
    }
    
    public void doTag() {
        System.out.println("doTag");
        System.out.println(this.toString());
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            String result = "";
            String temp = "";
            
            
            
            customersList = db.getAllCustomers();
            
            
            String color = "";
            for (CustomerBean bean : customersList) {
                temp = "";
                color = "success";
                if(bean.getStatus().equals("requested"))
                    color = "warning";
                else if(bean.getStatus().equals("denieded"))
                    color = "danger";
                temp += "<tr class=\""+color+"\">";
                temp += "<td>" + bean.getId() + "</td>";
                temp += "<td>" + bean.getFname() + "</td>";
                temp += "<td>" + bean.getLname() + "</td>";
                temp += "<td>" + bean.getEmail() + "</td>";
                temp += "<td>" + bean.getRegDate() + "</td>";
                temp += "<td>" + bean.getPhone() + "</td>";
                temp += "<td>" + bean.getStatus() + "</td>";
                temp += "<td>"+"<form action=\"ViewUser\" method=\"post\"><input type=\"hidden\" name=\"id\" value=\""+bean.getId()+"\"><input type=\"submit\" value=\"Info\" class=\"btn btn-info\"></input></form>";
                temp += "</tr>\n";
                System.out.println(temp);
                result += temp;
            }

            out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        filling = true;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
        filling = true;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
        filling = true;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        filling = true;
    }

    
    
    

    @Override
    public String toString() {
        return "ShowAllCustomer{" + "customersList=" + customersList + ", db=" + db + ", id=" + id + ", fname=" + fname + ", lname=" + lname + ", status=" + status + '}';
    }
    
    
}
