package cfd.taglib;

import cfd.bean.StaffBean;
import cfd.db.StaffDB;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author thymmm
 */
public class ShowAllStaff extends SimpleTagSupport{
    private ArrayList<StaffBean> staffList;
    private StaffDB db;
    private String id, fname, lname, status;

    
    public ShowAllStaff(){
        String url = "jdbc:mysql://127.0.0.1:3306/cfd_db";
        String username = "root";
        String password = "";
        db = new StaffDB(url, username, password);
    }
    
    public void doTag() {
        System.out.println("doTag");
        System.out.println(this.toString());
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            String result = "";
            String temp = "";
            
            staffList = db.showAllStaff();
            
            int i=0;
            String color = "";
            for (StaffBean bean : staffList) {
                i++;
                out.println("<tr><td>" + bean.getId() + "</td>");
                out.println("<td>" + bean.getfName() + "</td>");
                out.println("<td>" + bean.getlName() + "</td>");
                out.println("<td>" + bean.getPosition() + "</td>");
                out.println("<td>" + bean.getShop() + "</td>");
                out.println("<td>" + bean.getEntryTime() + "</td>");
                out.println("<td>"+"<form action=\"handleStaff\" method=\"post\"><input type=\"hidden\" name=\"id\" value=\""
                        +bean.getId()+"\"><input type=\"hidden\" name=\"action\" value=\"edit\"/><input type=\"submit\"value=\"Info\""
                        +" class=\"btn btn-info\"></input></form>" ); 
                /*temp += "<td>"+"<form action=\"../ViewUser\" method=\"post\"><input type=\"hidden\" name=\"id\" value=\""
                        +bean.getId()+"\"><input type=\"submit\"value=\"Info\""
                        +" class=\"btn btn-info\"></input></form>";*/
                
                System.out.println(i);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    
    

    
    
}
