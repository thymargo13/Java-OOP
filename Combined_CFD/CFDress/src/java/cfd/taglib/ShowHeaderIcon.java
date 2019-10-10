package cfd.taglib;

import cfd.bean.StaffBean;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Daniel
 */
public class ShowHeaderIcon extends SimpleTagSupport {

    String isLogined;

    public void setIsLogined(String isLogined) {
        this.isLogined = isLogined.equals("true")?"true":"false";
    }

    public void doTag() {
        System.out.println("doTag");
        System.out.println(this.toString());
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            String icon = "";
            if (isLogined.equals("true")) {
                icon = "<a href=\"Logout\"><i class=\"fa fa-sign-out w3-margin-right\">Logout</i></a>";
            } else {
                icon = "<a href=\"login.jsp\"><i class=\"fa fa-sign-in w3-margin-right\">Login</i></a>\n<a href=\"register.jsp\"><i class=\"fa fa-user-plus w3-margin-right\">Resgiter</i></a>";

            }
            System.out.println("ICON: " + icon);
            out.println(icon);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

