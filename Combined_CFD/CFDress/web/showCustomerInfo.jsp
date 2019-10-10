<%--
    Document   : showCustomerInfo
    Created on : Nov 21, 2016, 8:15:58 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="cfd.bean.CustomerBean" %>
<%@ page import="cfd.db.Customer_DB" %>
<%@taglib uri="/WEB-INF/tlds/cust_tag.tld" prefix="cfd" %>
<%
    Customer_DB db = new Customer_DB("jdbc:mysql://localhost:3306/cfd_db", "root", "");
    CustomerBean c;
    String isSuccessfulUpdate = null;

    if (request.getAttribute("isSuccess") != null) {
        isSuccessfulUpdate = (String) request.getAttribute("isSuccess");
    }
    /*
    if ((CustomerBean) request.getAttribute("customer") != null) {
        c = (CustomerBean) request.getAttribute("customer");
    } else {
        c = db.getCustomer("c12");
    }
     */
    c = db.getCustomer((String) session.getAttribute("id"));
    String genderIcon = "male";
    if (c.getGender() != null) {
        if (c.getGender().equals("female")) {
            genderIcon = "female";
        }
    }


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=c.getFname() + " " + c.getLname()%> Information</title>
        <%@include file="w3c.jsp" %>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <style>
            h1{
                font-family: 'Amatic SC', cursive;
            }
        </style>
        <script>
            function myFunction(id) {
                var x = document.getElementById(id);
                if (x.className.indexOf("w3-show") == -1) {
                    x.className += " w3-show";
                } else {
                    x.className = x.className.replace(" w3-show", "");
                }
            }
        </script>
    </head>
    <body class="w3-content" style="max-width:1200px">
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div class="w3-main" style="margin-left:250px">
            <h2>Account</h2>
            <cfd:showCustomerUpdateResult result="<%=isSuccessfulUpdate%>"/>
            <div class="w3-accordion">
                <div class="w3-border w3-hover-border-black">
                    <button onclick="myFunction('info')" class="w3-btn-block w3-left-align w3-pale-red">
                        <div class="w3-row">
                            <div class="w3-half w3-container">
                                <h1>Personal & Account Information</h1>
                            </div>
                            <div class="w3-half w3-container">
                                <h1><div class="fa fa-bars w3-xxlarge w3-right" ></div></h1>
                            </div>
                        </div>


                    </button>
                    <div id="info" class="w3-accordion-content w3-container">
                        <div class=" w3-row w3-container ">
                            <div class="w3-row">
                                <div class="w3-col m4 l1">
                                    <h2><div class="fa fa-<%=genderIcon%> w3-xxlarge"></div></h2>
                                </div>
                                <div class="w3-col m8 l11">
                                    <h2><%=c.getFname() + " " + c.getLname()%></h2>
                                </div>
                            </div>
                            <hr/>
                            <div class="w3-row">
                                <div class="w3-half w3-container ">
                                    Email: <%=c.getEmail()%>
                                </div>
                                <div class="w3-half w3-container">
                                    Balance: $<%=c.getBalance()%>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div class=" w3-row w3-container">

                            <div class="w3-row">
                                <div class="w3-half w3-container">
                                    Gender: <%=c.getGender()%>
                                </div>
                                <div class="w3-half w3-container">
                                    Bonus Points: <%=c.getBonusPoint()%>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div class=" w3-row w3-container">

                            <div class="w3-row">
                                <div class="w3-half w3-container">
                                    Phone Number: <%=c.getPhone()%>
                                </div>
                                <div class="w3-half w3-container">
                                    Account Status: <%=c.getStatus()%>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div class=" w3-row w3-container">

                            <div class="w3-row">
                                <div class="w3-half w3-container ">
                                    Date of Birth: <%=c.getDob()%>
                                </div>
                                <div class="w3-half w3-container">
                                    Register Date: <%=c.getRegDate()%>
                                </div>
                            </div>
                        </div>
                        <hr/>

                    </div>
                </div>
                <div class="w3-border w3-hover-border-black">

                    <button onclick="myFunction('Demo1')" class="w3-btn-block w3-left-align w3-pale-green">
                        <div class="w3-row">
                            <div class="w3-half w3-container">
                                <h1>Modify Information</h1>
                            </div>
                            <div class="w3-half w3-container">

                                <h1><div class="fa fa-bars w3-xxlarge w3-right" ></div></h1>
                            </div>
                        </div>
                    </button>
                    <div id="Demo1" class="w3-accordion-content w3-container">
                        <form action="CustomerUpdate" method="post" class="w3-container">
                            <p>You may insert one information to change the specific item.</p>
                            <input type="hidden" name="id" value="<%=c.getId()%>"/>
                            <input type="hidden" name="oldEmail" value="<%=c.getEmail()%>"/>
                            <input class="w3-input" type="text" id="fname" name="fname" value="<%=c.getFname()%>">
                            <label class="w3-label w3-validate"for="fname">First Name</label>

                            <input class="w3-input" type="text" id="lname" name="lname" value="<%=c.getLname()%>">
                            <label class="w3-label w3-validate" for="lname">Last Name</label>

                            <input class="w3-input" type="email" id="email" name="email" value="<%=c.getEmail()%>">
                            <label class="w3-label w3-validate"for="email">Email</label>

                            <input class="w3-input" type="tel" id="phone" name="phone" value="<%=c.getPhone()%>">
                            <label class="w3-label w3-validate" for="phone">Phone</label>

                            <input class="w3-input" type="date" id="dob" name="dob" value="<%=c.getDob()%>">
                            <label class="w3-label w3-validate" for="dob">Date</label>

                            <hr/>

                            <label class="w3-validate">Gender: </label>

                            <input class="w3-radio" type="radio" id="female" name="gender" value="female" <%if (c.getGender().equals("female")) {
                                    out.println("checked");
                                }%>>
                            <label class="w3-validate" for="female">Female</label>

                            <input class="w3-radio" type="radio" id="male" name="gender" value="male" <%if (c.getGender().equals("male")) {
                                    out.println("checked");
                                }%>>
                            <label class="w3-validate" for="male">Male</label>
                            <hr/>
                            <input type="submit" value="Send" class="w3-teal w3-btn w3-right"/>

                        </form>
                        <hr/>
                    </div>
                </div>
                <div class="w3-border w3-hover-border-black">
                    <button onclick="myFunction('Demo2')" class="w3-btn-block w3-left-align w3-pale-yellow">
                        <div class="w3-row">
                            <div class="w3-half w3-container">
                                <h1>Manage Address</h1>
                            </div>
                            <div class="w3-half w3-container" >
                                <h1><div class="fa fa-bars w3-xxlarge w3-right" ></div></h1>
                            </div>
                        </div>
                    </button>
                    <div id="Demo2" class="w3-accordion-content w3-container">
                        <hr/>
                        <div class="w3-border w3-hover-border-black w3-border w3-round-xlarge">
                            <button onclick="myFunction('addAddress')" class="w3-btn-block w3-white w3-border w3-border-blue w3-round-xlarge ">
                                Add New Address +
                            </button>

                            <div id="addAddress" class="w3-accordion-content w3-container">
                                <form action="AddAddress" method="post" class="w3-container w3-panel w3-padding-4">

                                    <input type="hidden" name="id" value="<%=c.getId()%>"/>
                                    <input class="w3-input" type="text" id="address" name="address">
                                    <label class="w3-label w3-validate"for="address">Address</label>
                                    <input type="submit" value="Send" class="w3-teal w3-btn w3-right"/>
                                    <hr/>
                                </form>

                            </div>
                        </div>

                        <hr/>
                        <cfd:showCustomerAddress id="<%=c.getId()%>" status="valid"/>
                    </div>
                </div>
                <div class="w3-border w3-hover-border-black">
                    <button onclick="myFunction('ChangePwd')" class="w3-btn-block w3-left-align w3-pale-blue">
                        <div class="w3-row">
                            <div class="w3-half w3-container">
                                <h1>Change Password</h1>
                            </div>
                            <div class="w3-half w3-container" >
                                <h1><div class="fa fa-bars w3-xxlarge w3-right" ></div></h1>
                            </div>
                        </div>
                    </button>
                    <div id="ChangePwd" class="w3-accordion-content w3-container">
                        <hr/>
                        <form action="ChangePwd" method="post">
                            <input type="hidden" name="id" value="<%=c.getId()%>"/>
                            <div class="w3-row">
                                <div class="w3-third w3-container">
                                    <input class="w3-input" type="password" required id="newPwd" name="newPwd">
                                    <label class="w3-label w3-validate" for="newPwd">New Password</label>
                                </div>
                                <div class="w3-third w3-container" >
                                    <input class="w3-input" type="password" required id="newPwd2" name="newPwd2">
                                    <label class="w3-label w3-validate" for="newPwd2">Confirm Password</label>
                                </div>
                                <div class="w3-third w3-container" >
                                    <input class="w3-right w3-input w3-btn w3-white w3-border w3-round-large" type="submit" value="Send">

                                </div>
                            </div>
                        </form>

                        <hr/>

                    </div>

                </div>
            </div>

            <hr/>
            <%@include file="footer.jsp" %>
        </div>


    </body>
</html>
