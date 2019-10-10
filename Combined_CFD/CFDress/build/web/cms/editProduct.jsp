<%-- 
    Document   : editProduct
    Created on : Nov 23, 2016, 5:05:05 PM
    Author     : thymmm
--%>

<%@page import="cfd.bean.PantBean"%>
<%@page import="cfd.bean.ShortBean"%>
<%@page import="cfd.bean.HoodyBean"%>
<%@page import="cfd.bean.CoatBean"%>
<%@page import="cfd.bean.ClothingSizeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
        <%@include file="cms_css.jsp" %>

    </head>
    <body>
        <jsp:useBean id="p" scope="request" class="cfd.bean.ProductBean"/>
        <jsp:useBean id="ps" scope="request" class="cfd.bean.ClothingSizeBean"/>
        <%!
            int xl = 0;
            int l = 0;
            int m = 0;
            int s = 0;
            String type ="";

                                %>
        <%
            // String type = s.getId()!=null?"edit":"add";
            String pid = p.getPid() != null ? p.getPid() : "";
            String name = p.getpName() != null ? p.getpName() : "";
            String brand = p.getpBrand() != null ? p.getpBrand() : "";
            String description = p.getDescription() != null ? p.getDescription() : "";
            Double price = p.getPrice() != 0 ? p.getPrice() : 0;
            String img = p.getImg() != null ? p.getImg() : "";
            ArrayList<ClothingSizeBean> _cs = p.getCs();

            for (ClothingSizeBean cs : _cs) {
                if (cs.getSize().equalsIgnoreCase("XL") && cs.getStock() > 0) {
                    xl = cs.getStock();
                }
                if (cs.getSize().equalsIgnoreCase("L") && cs.getStock() > 0) {
                    l = cs.getStock();
                }
                if (cs.getSize().equalsIgnoreCase("M") && cs.getStock() > 0) {
                    m = cs.getStock();
                }
                if (cs.getSize().equalsIgnoreCase("S") && cs.getStock() > 0) {
                    s = cs.getStock();
                }

            }
            
            if (p instanceof PantBean) {
                type = "pant";
            } else if (p instanceof ShortBean) {
            type = "short";
            } else if (p instanceof HoodyBean) {
            type = "hoody";
            } else if (p instanceof CoatBean) {
            type = "coat";
            }
        %>
        <%@include file="header.jsp" %>
        <!--   For modification  -->
        <div class="container">
            <label>Product Id :</label>
            <h2><%=pid%></h2>
            <hr>

            <form  method=“get" action="updateClothing"> 
                <div class="form-group">
                    <input type="hidden" name="id" value="<%=pid%>"/>
                    <label for="brand">Picture</label><br>
                    <img src="../<%=img%>" />
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
                <div class="form-group" >
                    <label for="qty" class="col-sm-2 control-label">Stock :</label>
                    <div class="col-sm-1" >
                        XL:<input type="number"   placeholder="XL"style="width:100%" name="xlargeStock"value="<%=xl%>"/>
                    </div>
                    <div class="col-sm-1" >
                        L:<input type="number"  placeholder="X"style="width:100%" name="largeStock" value="<%=l%>"/>
                    </div>
                    <div class="col-sm-1" >
                        M:<input type="number"   placeholder="M"style="width:100%" name="middleStock" value="<%=m%>"/>
                    </div>
                    <div class="col-sm-1" >
                        S:<input type="number" placeholder="S"style="width:100%" name="smallStock" value="<%=s%>"/>
                    </div>
                </div>
                    <input type="hidden" name="type"value="<%=type%>"/>
                <div class="form-group "style="margin-top: 30px;" ><input type="submit" value="Edit" name="action" class="btn btn-success  "style="float:right;width:30%"/> <br></div>

            </form>
            <hr>
            </body>
            </html>
