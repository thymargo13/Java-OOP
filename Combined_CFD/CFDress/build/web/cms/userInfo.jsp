<%--
    Document   : userInfo
    Created on : Nov 19, 2016, 3:56:27 PM
    Author     : Daniel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/cust_tag.tld" prefix="cfd" %>
<%@ page import="cfd.bean.CustomerBean" %>
<%
    CustomerBean c = (CustomerBean) request.getAttribute("customer");
    String pwd = null;
    System.out.println("Generated Pwd:" + pwd);
    try {
        pwd = (String) request.getAttribute("pwd");
    } catch (Exception e) {
        System.out.println("Generateed Pwd in user Info is null");
    }

%>

<!DOCHTML hyml>
<html>
    <head>
        <%@include file="cms_css.jsp" %>
        <title>User Info</title>
    </head>
    <body>
         <%@include file="header.jsp" %>
        <div class="container">
            <!--   For modification  -->
            <h1><%=c.getFname() + " " + c.getLname()%></h1>
            <hr/>
            <h2>Information</h2>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-12 col-sm-4 text-center">
                            <img src="https://upload.wikimedia.org/wikipedia/commons/d/d3/User_Circle.png" alt="" class="center-block img-circle img-responsive">

                        </div><!--/col-->


                        <div class="col-xs-12 col-sm-4">
                            <h2>Personal Info</h2>
                            <p>Name: <%=c.getFname() + " " + c.getLname()%></p>
                            <p>Email: <%=c.getEmail()%></p>
                            <p>Phone: <%=c.getPhone()%></p>
                            <p>Gender: <%=c.getGender()%></p>
                            <p>Date of Birth: <%=c.getDob()%></p>
                            <p>Register Date: <%=c.getRegDate()%></p>

                        </div><!--/col-->
                        <div class="col-xs-12 col-sm-4">
                            <h2>Account Status</h2>
                            <p>Customer ID: <%=c.getId()%></p>
                            <p>Account Balance: <%=c.getBalance()%></p>
                            <p>Bonus Point: <%=c.getBonusPoint()%></p>
                            <p>Account Status: <%=c.getStatus()%></p>


                        </div><!--/col-->


                    </div><!--/row-->
                </div><!--/panel-body-->
            </div><!--/panel-->
            <%
                if (pwd != null) {
            %>
            <hr/>
            <div class="alert alert-success">
                <strong>Success!</strong> Generated Password is <strong><%=pwd%> </strong>
            </div>
            <%
                }
            %>
            <hr/>
            <div class="row">
                <div class="col-sm-6" >
                    <h2>Account Control</h2>
                </div>
                <div class="col-sm-6" ><h2>
                        <button data-toggle="collapse" data-target="#Point" type="button" class="btn btn-primary" style="float: right;">Edit</button></h2>
                </div>
            </div>

            <div id="Point" class="collapse">
                <form action="UpdateUserBalanceAndBonus" method="Post">
                    <input type="hidden" name="id" value="<%=c.getId()%>">
                    <label for="fName">Balance:</label>
                    <input type="number" value="<%=c.getBalance()%>" class="form-control" id="balance" name="balance" placeholder="Optional" step="0.01">
                    <label for="fName">Bonus:</label>
                    <input type="number" value="<%=c.getBonusPoint()%>" class="form-control" id="bonus" name="bonus" placeholder="Optional" >
                    <br/>
                    <button type="submit" class="btn btn-primary btn-block btn-lg btn-default">Add Account Balance</button>
                </form>
            </div>
            <hr/>
            <div class="row">
                <div class="col-sm-6" >
                    <h2>Modify User Information</h2>
                </div>
                <div class="col-sm-6" ><h2>
                        <button data-toggle="collapse" data-target="#edit" type="button" class="btn btn-primary" style="float: right;">Edit</button></h2>
                </div>
            </div>


            <div id="edit" class="collapse">
                <div class="alert alert-info">
                    <strong>Info!</strong> You may fill in one column to update customer
                </div>
                <form action="UpdateUser" method="Post">
                    <input type="hidden" name="id" value="<%=c.getId()%>">

                    <label for="fName">First Name:</label>
                    <input type="text" class="form-control" value="<%=c.getFname()%>" id="fName" name="fName" placeholder="Enter First Name">

                    <label for="lName">Last Name:</label>
                    <input type="text" class="form-control" value="<%=c.getLname()%>" id="lName" name="lName" placeholder="Enter Last Name">

                    <label for="email">Email:</label>
                    <input type="email" class="form-control" value="<%=c.getEmail()%>" id="email" name="email" placeholder="Enter Email">

                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" id="phone" value="<%=c.getPhone()%>" name="phone" placeholder="Enter Phone Number">

                    <label for="gender">Gender:</label>
                    <select class="form-control" id="gender" name="gender" >
                        <option>Not Change</option>
                        <option>Male</option>
                        <option>Female</option>
                    </select>

                    <label for="dob">Date of Birth:</label>
                    <input type="date" class="form-control" id="dob" name="dob" placeholder="Enter Date" value="<%=c.getDob()%>">
                    <br/>
                    <p><button type="submit" class="btn btn-success" style="float: right;">Update</button></p>
                </form>
            </div>

            <%
                if (c.getStatus().equals("requested")) {
            %>
            <hr/>

            <div class="row">
                <div class="col-sm-6" >
                    <h2>Generate Password</h2>
                </div>
                <div class="col-sm-6" ><h2>
                        <button data-toggle="collapse" data-target="#genPwd" type="button" class="btn btn-primary" style="float: right;">Edit</button></h2>
                </div>
            </div>

            <div id="genPwd" class="collapse">
                <form action="GenPwd" method="Post">
                    <input type="hidden" name="id" value="<%=c.getId()%>">
                    <button type="submit" class="btn btn-primary btn-block btn-lg btn-success">Generate Password for <%=c.getFname() + " " + c.getLname()%>'s Account</button>
                </form>
            </div>
            <%
                }
            %>
            <hr/>
            <%  String title = "Denied", action = "DeniedUser", btn = "danger";
                if (c.getStatus().equals("denieded") || c.getStatus().equals("requested")) {
                    title = "Activate";
                    action = "VerifyUser";
                    btn = "success";

                }


            %>
            <div class="row">
                <div class="col-sm-6" >
                    <h2><%=title%> User</h2>
                </div>
                <div class="col-sm-6" ><h2>
                        <button data-toggle="collapse" data-target="#delete" type="button" class="btn btn-primary" style="float: right;">Edit</button></h2>
                </div>
            </div>

            <div id="delete" class="collapse">
                <form action="<%=action%>" method="Post">
                    <input type="hidden" name="id" value="<%=c.getId()%>">
                    <button type="submit" class="btn btn-primary btn-block btn-lg btn-<%=btn%>"><%=title%> <%=c.getFname() + " " + c.getLname()%>'s Account</button>
                </form>
            </div>

            <!--   For modification  -->
        </div>
    </body>
</html>



