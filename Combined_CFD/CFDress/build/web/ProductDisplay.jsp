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
        <title>Category</title>
        <%@page import="java.util.Calendar" %>
        <%@include file="w3c.jsp" %>
        <style>
            h1{
                font-family: 'Amatic SC', cursive;
            }
        </style>

    </head>
    <%
        int checkboxSize = 2;
        String[] checkboxName = new String[3];
        boolean hvSize = true;
        String imgname;
        String type = request.getParameter("type");
        if (type.equalsIgnoreCase("hs")) {
            imgname = "hoodie";
        } else if (type.equalsIgnoreCase("jc")) {
            imgname = "jc";
        } else if (type.equalsIgnoreCase("shorts")) {
        } else if (type.equalsIgnoreCase("pants")) {
        } else if (type.equalsIgnoreCase("hats")) {
            hvSize = false;
        } else if (type.equalsIgnoreCase("glasses")) {
            hvSize = false;
        } else if (type.equalsIgnoreCase("watches")) {
            hvSize = false;
        } else if (type.equalsIgnoreCase("bags")) {
            hvSize = false;
        }

    %>
    <body class="w3-content w3-margin" style="max-width:1200px">
        <jsp:useBean id="product" class="java.util.ArrayList" scope="request" />
        <%session.setAttribute("ProductList", product);%>
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>

        <div class="w3-main" style="margin-left:250px">
            <form action="form.asp" class="w3-container w3-card-4 w3-light-grey w3-text-pink w3-margin">
                <div class="w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-search"></i></div>
                    <div class="w3-rest">
                        <input class="w3-input w3-border" type="text" placeholder="Enter key words to search . . .">
                    </div>
                </div>

                <div class="w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-filter"></i></div>
                        <%if (hvSize) {%>
                    <select>
                        <option>---Size---</option>
                        <option>S</option>
                        <option>M</option>
                        <option>L</option>
                        <option>XL</option>
                    </select>
                    <%}%>
                    <select>
                        <option>---Price Range---</option>
                        <option><$100</option>
                        <option>$100-$200</option>
                        <option>$201-$300</option>
                        <option>$301-$400</option>
                        <option>>$400</option>
                    </select>
                    <select>
                        <option>---Brand---</option>
                        <option>Adidas</option>
                        <option>Champion</option>
                        <option>Nike</option>
                        <option>Supreme</option>
                        <option>Superdry</option>
                        <option>Uniqlo</option>
                        <option>New Balance</option>
                        <option>Boss</option>
                        <option>Ice</option>
                        <option>Other . . .</option>
                    </select>
                    <div>
                        <button class="w3-btn w3-section w3-green w3-ripple"> --> </button>
                    </div>
                </div>

            </form>

            <div class="w3-container w3-card-4 w3-light-grey w3-text-pink w3-margin">
                <div class="" style="">
                    <div class="w3-row" style="">
                        <% for (int i = 0; i < product.size(); i++) {
                                if (product.get(i) instanceof ProductBean) {
                                    ProductBean p = (ProductBean) product.get(i);
                        %>

                        <div class="w3-display-container w3-card-4 w3-col m4 w3-center w3-round-xxlarge" style="width:30%;padding:10px;margin: 12.5px;height:450px" align="center">

                            <div class="w3-display-container">
                                <img src=<%= p.getImg()%> style="width:80%;height:90%">
                            </div>

                            <div class="w3-container w3-display-bottommiddle" style="margin: 10px;">
                                <div>
                                    <p><%= p.getpName()%><br><b><%= p.getPrice()%></b></p>
                                    <a href=<%="productDetail?pid=" + p.getPid()%>><button class="w3-btn w3-pink">View Detail</button></a>
                                </div>
                            </div>
                        </div>

                        <% } else if (product.get(i) instanceof OtherProductBean) {
                            OtherProductBean p = (OtherProductBean) product.get(i);

                        %>
                        <div class="w3-display-container w3-card-4 w3-col m4 w3-center w3-round-xxlarge" style="width:30%;padding:10px;margin: 12.5px;height:450px" align="center">

                            <div class="w3-display-container">
                                <img src=<%= p.getImg()%> style="width:80%;height:90%">
                            </div>

                            <div class="w3-container w3-display-bottommiddle" style="margin: 10px;">
                                <div>
                                    <p><%= p.getpName()%><br><b><%= p.getPrice()%></b></p>
                                    <a href=<%="productDetail?pid=" + p.getPid()%>><button class="w3-btn w3-pink">View Detail</button></a>
                                </div>
                            </div>
                        </div>

                        <% }%>
                        <% }%>
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
