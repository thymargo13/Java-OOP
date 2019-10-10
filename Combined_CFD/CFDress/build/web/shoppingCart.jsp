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
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div class="w3-main" style="margin-left:250px">
            <h2>SHOPPING CART</h2>
            <hr>
            <%for (int i = 1; i < 10; i++) {%>

            <div class="w3-container w3-card-4 w3-accordion">
                <div onclick=<%="myFunc(" + i + ")"%>>
                    <div class="w3-quarter"><img src=<%= "img/jc" + i + ".jpg"%> style="width:20%;height:25%"></div>
                    <div class="w3-quarter">                    
                        <div class="w3-display-container w3-col w3-text-red">
                            <!--pid link back to each product detail -->
                            <a href=<%="productDetail?pid="+i%>><b>Product Name</b> <i>by</i></a>
                        </div>
                        <div class="w3-display-container w3-col">
                            <b>Brand</b>
                        </div>  
                    </div>
                    <div class="w3-quarter">                    
                        <div class="w3-display-container w3-col">
                            <b>HKD$Price</b>
                        </div>
                        <div class="w3-display-container w3-col">
                            <b>QTY</b>
                        </div>
                    </div>
                    <div class="w3-quarter"><a href="#"><button class="w3-btn">Remove from cart</button></a></div>
                </div>
                
            </div>
                    <div class="w3-accordion-content w3-container" id=<%="" + i + ""%>>
                    <div class='w3-container w3-card-4'>
                    <h4>Product details</h4>
                    <p>Some text..</p>
                    </div>
                </div>
            <hr>
            <%}%>
            <div class="w3-bottom" style="">
                <form class="w3-container w3-text-pink">
                    <ul class="w3-navbar w3-left" style="width:45%">
                        <li><button class="w3-btn w3-row w3-text-white w3-pink w3-round-xxlarge" style="margin:10px;">Proceed to check out <i class="w3-large fa fa-arrow-circle-right"></i></button></li>

                    </ul>    
                </form>
            </div>
            <%@include file="footer.jsp" %>     
        </div>


    </body>
    <script>
        function myFunc(id) {
            var x = document.getElementById(id);
            if (x.className.indexOf("w3-show") == -1) {
                x.className += " w3-show";
            } else {
                x.className = x.className.replace(" w3-show", "");
            }
        }
    </script>
</html>
