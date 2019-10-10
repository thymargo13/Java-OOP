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
        <title>Register</title>
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
            <form action="RegisterUser" class="w3-container w3-card-4 w3-light-grey w3-text-pink w3-margin" method="post">
                <h1 class="w3-center">Registration</h1>
                <fieldset>
                    <legend>Personal information:</legend>
                    <div class="w3-row-padding w3-section">
                        <div class="w3-half">
                            <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-user"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" type="text" placeholder="First Name"required="required" name="fname">
                            </div>
                        </div>
                        <div class="w3-half">
                            <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-user"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" type="text" placeholder="Last Name"required="required" name="lname">
                            </div>
                        </div>
                    </div>

                    <div class="w3-row-padding w3-section">
                        <div class="w3-half">
                            <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-phone"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" type="text" placeholder="Phone" pattern="[0-9]*" title="Only accept number~" name="phone">
                            </div>
                        </div>
                        <div class="w3-half">
                            <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-envelope-o"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="email" type="email" placeholder="Email" required="required">
                            </div>
                        </div>
                    </div>
                    <div class="w3-row-padding w3-section">
                        <div class="w3-half">
                            <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-birthday-cake"></i></div>
                            <select id="days" name="day"><%
                                int day = 31;
                                for (int i = 1; i <= day; i++) {
                                    out.println("<option>" + i + "</option>");
                                }
                                %>

                            </select>
                            <select id="months" name="month">
                                <%
                                    int months = 12;
                                    for (int i = 1; i <= months; i++) {
                                        out.println("<option>" + i + "</option>");
                                    }
                                %>
                            </select>
                            <select id="years" name="year">
                                <%
                                    int thisYear = Calendar.getInstance().get(Calendar.YEAR);
                                    int fYear = thisYear - 10;//2006
                                    int pYear = thisYear - 50;//1916
                                    for (int i = fYear; i >= pYear; i--) {
                                        out.println("<option>" + i + "</option>");
                                    }
                                %>
                            </select>
                            DD-MM-YYYY
                        </div>
                        <div class="w3-half">
                            <div class="w3-padding">
                                <i class="fa fa-female w3-xlarge"></i>
                                <i class="fa fa-male w3-xlarge"></i>
                                <input class="w3-radio" type="radio" name="gender" value="male" >
                                <label class="w3-validate">Male</label>
                                <input class="w3-radio" type="radio" name="gender" value="female" checked>
                                <label class="w3-validate">Female</label>
                            </div>
                        </div>
                    </div>

                </fieldset>
                <br/>
                <fieldset>
                    <legend>Optional Information:</legend>
                    <div class="w3-row w3-section">
                        <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-home"></i></div>
                        <div class="w3-rest">
                            <input class="w3-input w3-border"name="address1" type="text" placeholder="Delivery Address1">
                        </div>
                    </div>
                    <div class="w3-row w3-section">
                        <div class="w3-col" style="width:50px"><i class="w3-xlarge fa fa-home"></i></div>
                        <div class="w3-rest">
                            <input class="w3-input w3-border"name="address2" type="text" placeholder="Delivery Address2">
                        </div>
                    </div>
                </fieldset>
                <p class="w3-center">
                    <button class="w3-btn w3-section w3-green w3-ripple"> Register </button>
                    <input type="reset" value="Clear" class="w3-btn w3-section w3-red w3-ripple"/>
                </p>
            </form>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
