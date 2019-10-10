<%-- 
    Document   : register
    Created on : Nov 17, 2016, 1:30:14 PM
    Author     : thymmm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@page import="java.util.Calendar" %>
        <%@include file="w3c.jsp" %>
        <style>
            h1{
                font-family: 'Amatic SC', cursive;
            }
        </style>

    </head>
    <body class="w3-content" style="max-width:1200px">
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div class="w3-main" style="margin-left:250px">
            <form action="Login" class="w3-container w3-card-4 w3-light-grey w3-text-pink w3-margin" method="post">
                <h1 class="w3-center">Login</h1>
                <div class="w3-section">

                    <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-user"></i></div>
                    <div class="w3-rest">
                        <input class="w3-input w3-border" type="text" placeholder="Email" required="required" name="email">
                    </div>


                    <div class="w3-section">    
                        <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-unlock-alt"></i></div>
                        <div class="w3-rest">
                            <input class="w3-input w3-border" type="password" placeholder="Password" required="required" name="pwd">
                        </div>
                    </div>
                </div>

                <p class="w3-center">
                    <input type="submit" class="w3-btn w3-section w3-green w3-ripple" value="Login"/> 
                    <input type="reset" value="Clear" class="w3-btn w3-section w3-red w3-ripple"/>
                </p>
                <div><a href="register.jsp">Do not have an account ???</a></div>    
            </form>
            
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
