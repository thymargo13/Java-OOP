<%--
    Document   : index
    Created on : Nov 17, 2016, 9:41:20 AM
    Author     : thymmm
--%>
<%
    /*
    List<ProductBean> cartList = new LinkedList<ProductBean>();
    session.setAttribute("cart", cartList);
     */
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>C&F Dress</title>
        <%@include file="w3c.jsp" %>
    </head>
    <body class="w3-content" style="max-width:1200px">
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div class="w3-main" style="margin-left:250px">
            <div class="w3-display-container w3-container">
                <img src="img/jeans.jpg" style="width:100%"/>
                <div class="w3-display-topleft w3-padding-xxlarge w3-text-white">
                    <h1 class="w3-jumbo w3-hide-small">New arrivals</h1>
                    <h1 class="w3-hide-small">COLLECTION 2017</h1>
                    <p><a href="search.jsp" class ="w3-btn w3-padding-large w3-large">SHOP NOW</a></p>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>

    </body>


</html>
