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
        <title>Product Details</title>
        <%@page import="java.util.Calendar" %>
        <%@include file="w3c.jsp" %>
        <style>
            h1{
                font-family: 'Amatic SC', cursive;
            }
        </style>
        <script>
            //在網頁加載後，對id=doAjaxBtn的Button設定click的function
            $(document).ready(function() {
                $("#addToCart").click(function() {
                    $.ajax({
                        type: "POST",                    //指定http參數傳輸格式為POST
                        url: "addOrder",        //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
                        data: $("#orderDetail").serialize(), //要傳給目標的data為id=formId的Form其序列化(serialize)為的值，之
                        //內含有name的物件value
                        dataType: "text",               //目標url處理完後回傳的值之type，此列為一個JSON Object
                        //Ajax成功後執行的function，response為回傳的值
                        //此範列回傳的JSON Object的內容格式如右所示: {userName:XXX,uswerInterest:[y1,y2,y3,...]}
                        success: function(response) {
                            //在id=ajaxResponse的fieldset中顯示Ajax的回傳值
                            $("#count").html(response);
                        },
                        //Ajax失敗後要執行的function，此例為印出錯誤訊息
                        error: function(xhr, ajaxOptions, thrownError) {
                            alert(xhr.status + "\n" + thrownError);
                        }
                    });
                });
            });  
        </script>
    </head>
    <%        int pid = Integer.parseInt(request.getParameter("pid"));
    %>
    <jsp:useBean id="product" class="java.util.ArrayList" scope="request" />
    <body class="w3-content w3-margin" style="max-width:1200px">
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div class="w3-main" style="margin-left:250px">
            <div class="w3-row-padding w3-section">
                <div class="w3-half">
                    <div class="w3-display-container w3-card-4 w3-col m4 w3-center w3-round-xxlarge" style="width:100%;padding:10px;margin: 12.5px;" align="center">

                        <div class="w3-display-container">
                            <img src=<%= "img/jc" + pid + ".jpg"%> style="width:80%;height:90%">
                        </div>


                    </div>
                </div>
                <div class="w3-half">
                    <div class="w3-display-container w3-center w3-col">
                        <h1><b>Product Name</b></h1>
                    </div>
                    <div class="w3-display-container w3-center w3-col">
                        <h1><b>Brand</b></h1>
                    </div>
                    <div class="w3-display-container w3-center w3-col">
                        <h1><b>HKD$Price</b></h1>
                    </div>
                    <div>
                        <hr>
                    </div>
                    <form id="orderDetail">
                        <div class="w3-display-container w3-center w3-col w3-margin-top">
                            <select name="size">
                                <option>---Size---</option>
                                <option>S</option>
                                <option>M</option>
                                <option>L</option>
                                <option>XL</option>
                            </select>
                            <input type="number" min="1" max="10" name="qty"/>
                            <input type="hidden" name="pid" value="<%=pid%>"/>
                        </div>
                        <div class="w3-display-container w3-center w3-col w3-margin-top">
                            <input type="button" value="Place Order" id="addToCart" class="w3-btn w3-pink"/>
                            <!--a href="<//"AddToCart?pid=" + pid"><button class="w3-btn w3-pink">Place Order</button></a-->
                        </div>
                    </form>
                </div>
                        <!--div id="message"></div-->
            </div>

            <%@include file="footer.jsp" %>
        </div>


    </body>
</html>
