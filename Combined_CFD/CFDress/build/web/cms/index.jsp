<%-- 
    Document   : index
    Created on : Nov 18, 2016, 10:14:34 AM
    Author     : thymmm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="cms_css.jsp" %>
        <title>C & F Dress _ CMS _ Login</title>
        <style>
            label,h2{
                color: pink;
            }
        </style>
    </head>
    <body style="background-color: black">
        <div class="container">
            <center><img src="../img/icont.png"/></center>
            <h2>Staff Login</h2>
            <form action="CMSLogin" method="post">
                <div class="form-group">
                    <label for="staffId">User ID:</label>
                    <input type="text" class="form-control" id="staffId" name="staffId" placeholder="Enter user id">
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            
           
        </div>
    </body>
</html>
