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

    <body class="w3-content" style="max-width:1200px">
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div class="w3-main" style="margin-left:250px">
            <form action="form.asp" class="w3-container w3-card-4 w3-light-grey w3-text-pink w3-margin">
                <h1 class="w3-center">Search</h1>
                <div class="w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-search"></i></div>
                    <div class="w3-rest">
                        <input class="w3-input w3-border" type="text" placeholder="Enter key words to search . . .">
                    </div>
                </div>
                <div class="w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-filter"></i></div>
                    <input class="w3-check" type="checkbox" id="hs">
                    <label class="w3-validate" for="hs">Hoodies</label>

                    <input class="w3-check" type="checkbox" id="ss">
                    <label class="w3-validate" for="ss">Sweat Shirts</label>

                    <input class="w3-check" type="checkbox" id="jc">
                    <label class="w3-validate" for="jc">Jackets & Coats</label>

                    <input class="w3-check" type="checkbox" id="shorts">
                    <label class="w3-validate" for="shorts">Shorts</label>

                    <input class="w3-check" type="checkbox" id="pants">
                    <label class="w3-validate" for="pants">Pants</label>

                    <input class="w3-check" type="checkbox" id="hats">
                    <label class="w3-validate" for="hats">Hats</label>

                    <input class="w3-check" type="checkbox" id="glasses">
                    <label class="w3-validate" for="glasses">Glasses</label>

                    <input class="w3-check" type="checkbox" id="watches">
                    <label class="w3-validate" for="watches">Watches</label>
                </div>
                <div class="w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-filter"></i></div>
                    <select>
                        <option>---Size---</option>
                        <option>S</option>
                        <option>M</option>
                        <option>L</option>
                        <option>XL</option>
                    </select>
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
                        <option>Other</option>
                    </select>

                </div>
                <p class="w3-right">
                    <button class="w3-btn w3-section w3-green w3-ripple"> Search </button>
                </p>
            </form>
        </div>


        <!-- Product grid -->
        <div class="w3-main w3-center" style="margin-left:250px">
            <div class="w3-bottom" style="">
                <form class="w3-container w3-text-pink w3-margin-top">
                    <ul class="w3-navbar w3-right" style="width:45%">
                        <li><button class="w3-btn w3-row w3-text-white w3-pink w3-round-xxlarge" style="margin:10px;"><i class="w3-large fa fa-sort"></i> Top Sales </button></li>
                        <li><button class="w3-btn w3-row w3-text-white w3-pink w3-round-xxlarge" style="margin:10px;"><i class="w3-large fa fa-sort"></i> Price </button></li>
                    </ul>    
                </form>
            </div>
            <div class="w3-container w3-card-4 w3-light-grey w3-text-pink w3-margin">
                <div class="" style="">
                    <div class="w3-row" style="">
                        <% for (int i = 1; i <= 12; i++) {%>

                        <div class="w3-display-container w3-card-4 w3-col m4 w3-center w3-round-xxlarge" style="width:30%;padding:10px;margin: 12.5px;height:350px" align="center">

                            <div class="w3-display-container"> 
                                <img src=<%= "img/jc" + i + ".jpg"%> style="width:80%;height:90%">
                            </div>
                            <span class="w3-tag w3-display-topleft">Sale</span>
                            <div class="w3-container w3-display-bottommiddle" style="margin: 10px;">
                                <div>
                                    <p>Product Name<br><b>Price</b></p>
                                    <a href=<%="productDetail?pid="+i%>><button class="w3-btn w3-pink">View Detail</button></a>
                                </div>
                            </div>
                        </div>

                        <% }%>
                    </div>  
                </div>
            </div>
            <br>
            <%@include file="footer.jsp" %>     
        </div>


    </body>
</html>
