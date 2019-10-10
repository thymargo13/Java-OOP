<%-- 
    Document   : editStaff
    Created on : Nov 21, 2016, 2:34:56 AM
    Author     : thymmm
--%>

<%@page import="cfd.bean.AccessoryBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
        <%@include file="cms_css.jsp" %>

    </head>
    <body>
        <jsp:useBean id="s" scope="request" class="cfd.bean.OtherProductBean"/>


        <%
            // String type = s.getId()!=null?"edit":"add";
            String psid = s.getPid() != null ? s.getPid() : "";
            String name = s.getpName() != null ? s.getpName() : "";
            String brand = s.getpBrand() != null ? s.getpBrand() : "";
            String description = s.getDescription() != null ? s.getDescription() : "";
            Double price = s.getPrice() != 0 ? s.getPrice() : 0;
            int stock = s.getStock() != 0 ? s.getStock() : 0;
            String img = s.getImg() != null ? s.getImg() : "";
        %>
        <%@include file="header.jsp" %>
        <!--   For modification  -->
        <div class="container">

            <h2><%=psid%></h2>
            <hr>

                <form  method=“get" action="updateProduct"> 
                <div class="form-group">
                    <input type="hidden" name="id" value="<%=psid%>"/>
                    <label for="brand">Picture</label><br>
                    <img src="<%=img%>" />
                </div>
                <div class="form-group">
                    <label for="brand">Brand</label>
                    <input name="brand" class="form-control" id="brand" type="text" value="<%=brand%>" />
                </div>
                <div class="form-group">
                    <label for="name">Name :</label>
                    <input name="name" class="form-control" id="name" type="text" value="<%=name%> "/>
                </div>
                <div class="form-group">
                    <label for="description">Description :</label>
                    <input name="description" class="form-control" id="description" type="text" value="<%=description%> "/>
                </div>
                <div class="form-group">
                    <label for="price">Price (HKD):</label>
                    <input name="price" class="form-control" id="price" type="text" value="<%=price%>"/>
                </div>
                <div class="form-group">
                    <label for="stock">Stock :</label>
                    <input name="stock" class="form-control" id="stock" type="text " value="<%=stock%>"/>
                </div>
                <%
                    if (s instanceof AccessoryBean) {
                        AccessoryBean a = (AccessoryBean) s;
                        int redeem = a.getRedeemPoint();
                        String pType = a.getpType();
                        String watches = "";
                        String glasses = "";
                        String hat = "";
                        if (pType.equals("watches")) {
                            watches = "checked";
                        } else if (pType.equals("glasses")) {
                            glasses = "checked";
                        } else {
                            hat = "checked";
                        }
                %>
                <input type="hidden" name="accessory" value="accessory"/>
                <div class="form-group">
                    <label for="redeem">Redeem Point :</label>
                    <input name="redeem" class="form-control" id="redeem" type="text " value="<%=redeem%>"/>
                </div>
                <div class="form-group">
                    <label for="pType">Product Type :</label>
                    <label class="radio-inline">
                        <input type="radio" name="pType" value="watches"<%=watches%>> Watches
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="pType" value="glasses"<%=glasses%>> Glasses
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="pType" value="hat"<%=hat%>> Hat
                    </label>
                </div>
                   
                <%
                    }
                    if (stock <= 0) {
                %>
                <div class="form-group">
                    <label for="status">Validation :</label>
                    <input name="status" class="form-control" id="status" type="text " value="invalid" readonly/>
                </div>

                <%
                } else {
                %>

                <div class="form-group">
                    <label for="status">Validation :</label>
                    <input name="status" class="form-control" id="status" type="text " value="valid" readonly/>
                </div>

                <%
                    }
                %>
                 <input type="submit" value="Edit" name="action" class="btn btn-success btn-block"/> <br>
            </form>

        </div>
    </body>
</html>
