<%-- 
    Document   : register
    Created on : Nov 17, 2016, 1:30:14 PM
    Author     : thymmm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cfd.bean.*,java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <%@page import="java.util.Calendar" %>
        <%@include file="w3c.jsp" %>
        <style>
            h1{
                font-family: 'Amatic SC', cursive;
            }
        </style>

    </head>

    <body class="w3-content w3-margin" style="max-width:1200px">

        
        <jsp:useBean id="allproduct" class="java.util.ArrayList<cfd.bean.ProductBean>" scope="request" />

        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div class="w3-main" style="margin-left:250px">
             <table border="1px">
     
        <%
            for(int i=0;i<allproduct.size();i++){
                ProductBean p =  allproduct.get(i);
                out.print("<tr><td>"+p.getpName()+"</td>");
                    
                
                out.print("<td><img src="+p.getImg()+"></td>");
                    

                out.print("<td>"+p.getPrice()+"</td></tr>");

            }
        %>
     

     
 </table>
            <%@include file="footer.jsp" %>     
        </div>


    </body>
</html>
