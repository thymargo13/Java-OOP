/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.taglib;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Daniel
 */
public class ShowCustomerUpdateResult extends SimpleTagSupport {

    String result;

    public void setResult(String s) {
        this.result = s;
    }

    public void doTag() {
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            if (result.equals("true")) {
                out.println("<div class=\"w3-panel w3-green\">\n"
                        + "    <h3>Success!</h3>\n"
                        + "    <p>Your Information has updated successfilly !</p>\n"
                        + "  </div>");
            } else if (result.equals("false")) {
                out.println("<div class=\"w3-panel w3-red\">\n"
                        + "    <h3>Error!</h3>\n"
                        + "    <p>Email was used, please chack for the correct entry !</p>\n"
                        + "  </div>");
            }
        } catch (Exception e) {

        }
    }
}
