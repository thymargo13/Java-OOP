/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.taglib;

import cfd.bean.CustomerAddressBean;
import cfd.db.AddressBook_DB;
import cfd.db.Customer_DB;
import java.util.List;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Daniel
 */
public class ShowCustomerAddress extends SimpleTagSupport {

    private String status, id;
    private List<CustomerAddressBean> addressList;
    private AddressBook_DB ab;

    public ShowCustomerAddress() {
        String url = "jdbc:mysql://127.0.0.1:3306/cfd_db";
        String username = "root";
        String password = "";
        ab = new AddressBook_DB(url, username, password);

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void doTag() {
        //String email = getServletContext().getInitParameter("AdministratorEmail");
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            if (status.equals("valid")) {
                addressList = ab.getValidAddressesByCustomer(id, status);
            } else if (status.equals("all")) {
                addressList = ab.getAddressesByCustomer(id);
            }
            String result = "<li>" + "<div class=\"w3-display-container\">" + "Address Not Found " + "</div></li>";

            if (addressList.size() > 0) {
                result = "";
                int n = 0;
                for (CustomerAddressBean cab : addressList) {
                    result += "<li><div class=\"w3-row\">"
                            + "<div class=\"w3-col m8 l9\">"
                            + "<p>" + cab.getAddress() + "</p>"
                            + "</div>"
                            + "<div class=\"w3-col m4 l3\">"
                            + "<Button onclick=\"myFunction('ListItem" + n + "')\"class=\"w3-btn w3-white w3-border w3-text-teal w3-right w3-round-large\" />Edit</Button>"
                            + "</div>"
                            + "</div></li>"
                            + "<div id=\"ListItem" + n + "\" class=\"w3-accordion-content w3-container\">"
                            + "<form action=\"EditAddress\" method=\"post\" class=\"w3-container w3-panel w3-padding-4\">"
                            + "<input type=\"hidden\" name=\"id\" value=\"" + id + "\"/>"
                            + "<input type=\"hidden\" name=\"aid\" value=\"" + cab.getAid() + "\"/>"
                            + "<input class=\"w3-input\" type=\"text\" id=\"address\" name=\"address\" value=\""+cab.getAddress()+"\">\n"
                            + "<label class=\"w3-label w3-validate\"for=\"address\">Address</label>"
                            + "<input type=\"submit\" value=\"Send\" class=\"w3-teal w3-btn w3-right\"/>"
                            + "</form><hr/>"
                            +"<form action=\"RemoveAddress\" method=\"post\"><input type=\"hidden\" name=\"aid\" value=\""+cab.getAid()+"\">"
                            + "<input type=\"submit\" value=\"Delete "+cab.getAddress()+"\" class=\"w3-btn-block w3-red w3-border w3-border-red w3-round-xlarge\"></form>"
                            + "</div>";
                    n++;
                }
            }
            String output = "<ul class=\"w3-ul w3-hoverable\">" + result + "</ul>";
            System.out.println(output);
            out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
out.println("<ol class=\"w3-ul w3-hoverable\"><li><div class=\"w3-row\">"
                            + "  <div class=\"w3-col m8 l9\">"
                            + "    <p>Address</p>"
                            + "  </div>"
                            + "  <div class=\"w3-col 4 l3\">"
                            + "    <p><form action=\"EditAddress\" method=\"post\"><input type=\"submit\"/></form></p>"
                            + "  </div>"
                            + "</div></li></ol>");s
 */
 /*
class=\"w3-display-middle\"
 */
 /*
result
                            += "<div class=\"w3-col m8 l9\">"
                            + "<p>" + cab.getAddress() + "</p>"
                            + "  </div>"
                            + "  <div class=\"w3-col 4 l3\">"
                            + "    <p><form action=\"EditAddress\" method=\"post\"><input type=\"submit\"/></form></p>"
                            + "  </div>"
                            + "</div></li>";
 */
//"<p><form action=\"EditAddress\" method=\"post\"><input type=\"submit\" class=\"w3-btn w3-white w3-border w3-text-teal w3-right w3-round-large\" value=\"Edit\"/></form></p>"

/*
<div id="ListItemN" class="w3-accordion-content w3-container">
                                <form action="Daniel" method="post" class="w3-container w3-panel w3-padding-4">

                                    <input type="hidden" name="id" value="<%=c.getId()%>"/>
                                    <input class="w3-input" type="text" id="address" name="address">
                                    <label class="w3-label w3-validate"for="address">Address</label>
                                    <input type="submit" value="Send" class="w3-teal w3-btn w3-right"/>
                                    <hr/>
                                </form>

                            </div>
 */
