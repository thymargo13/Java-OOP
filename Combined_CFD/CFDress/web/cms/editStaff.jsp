<%-- 
    Document   : editStaff
    Created on : Nov 21, 2016, 2:34:56 AM
    Author     : thymmm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Staff</title>
        <%@include file="cms_css.jsp" %>
    </head>
    <body>
        <jsp:useBean id="s" scope="request" class="cfd.bean.StaffBean"/>

        <%
            // String type = s.getId()!=null?"edit":"add";
            String id = s.getId() != null ? s.getId() : "";
            String fName = s.getfName() != null ? s.getfName() : "";
            String lName = s.getlName() != null ? s.getlName() : "";
            String post = s.getPosition() != null ? s.getPosition() : "";
            String work = s.getShop() != null ? s.getShop() : "";
            String date = s.getEntryTime().toString() != null ? s.getEntryTime().toString() : "";
            String pwd = s.getPwd() != null ? s.getPwd() : "";
        %>
        <%@include file="header.jsp" %>
        <!--   For modification  -->
        <div class="container">

            <h2>Staff Detail :</h2>
            ( logout required for update )
            <hr>
            <form  method=“get" action="handleEdit"> 
                <div class="form-group">
                    <label for="date">Entry Date:</label>
                    <input name="date" class="form-control" id="date" type="text" value="<%=date%>" readonly/>
                </div>
                <div class="form-group">
                    <label for="id">Staff ID:</label>
                    <input name="id" class="form-control" id="id" type="text" value="<%=id%> "readonly/>
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input name="pwd" class="form-control" id="pwd" type="text" value="<%=pwd%> "/>
                </div>
                <div class="form-group">
                    <label for="fName">First Name:</label>
                    <input name="fName" class="form-control" id="fName" type="text" value="<%=fName%> "/>
                </div>
                <div class="form-group">
                    <label for="lName">Last Name:</label>
                    <input name="lName" class="form-control" id="lName" type="text" value="<%=lName%> "/>
                </div>
                <div class="form-group">
                    <label for="post">Post :</label>
                    <div class="">
                        <%
                            String staff = "";
                            String manager = "";
                            String admin = "";
                            if (post.equals("staff")) {
                                staff = "checked";
                            } else if (post.equals("manager")) {
                                manager = "checked";
                            } else {
                                admin = "checked";
                            }
                        %>
                        <label class="radio-inline">
                            <input type="radio" name="post" value="staff"<%=staff%>> Staff
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="post" value="manager"<%=manager%>> Manager
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="post" value="admin"<%=admin%>> Admin
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="work">Workplace:</label>
                    <input name="work" class="form-control" id="work" type="text" value="<%=work%> "/>
                </div>
                <input type="submit" value="edit" name="action" class="btn btn-success btn-block"/> <br>
                <input type="submit" name="action" value="delete" class="btn btn-danger btn-block"/> <br> 
            </form>
                
        </div>
    </body>
</html>
