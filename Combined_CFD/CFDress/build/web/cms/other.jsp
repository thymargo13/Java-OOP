<%-- 
    Document   : other
    Created on : Nov 22, 2016, 12:17:08 PM
    Author     : thymmm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/cust_tag.tld" prefix="cfd" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Other Product</title>
        <%@include file="cms_css.jsp" %>
        <script>
            $(document).ready(function () {
                 $('#dataTable').DataTable();
                $("#redeem").hide();
                $("#Select").click(function () {
                    if ($("#Select").val() == "bag") {
                        $("#redeem").hide();
                    } else {
                        $("#redeem").appendTo($("#priceDiv")).show();
                    }
                });
            });
        </script>
                
    </head>
    <body>
        <%@include file="header.jsp" %>
        <!--   For modification  -->
        <div class="container">
            <div class="page-header">
                <h1>Other Product</h1>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading"><h3>Add Product</h3></div>
                <div class="panel-body">
                    <form class="form-horizontal" action="handleOtherProduct" method="post" enctype="multipart/form-data" >
                        <div class="form-group">
                            <label for="Select" class="col-sm-2 control-label">Product Type:</label>
                            <div class="col-sm-8">
                                <select id="Select"  name="type" class="form-control">
                                    <option value="bag">Bag</option>
                                    <option value="accessory">Accessory</option>

                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="brand" class="col-sm-2 control-label">Brand:</label>
                            <div class="col-sm-3">
                                <input type="text" class=""  id="brand" style="width:100%"name="brand"/>
                            </div>
                            <label for="name" class="col-sm-1 control-label">Name:</label>
                            <div class="col-sm-4">
                                <input type="text" class=""  id="name"  style="width:100%" name="name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="description" class="col-sm-2 control-label">Description:</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" rows="5" id="description" name="description"></textarea>
                            </div>
                        </div>
                        <div class="form-group" id="priceDiv">
                            <label for="price" class="col-sm-2 control-label">Price(HKD) :</label>
                            <div class="col-sm-1" >
                                <input type="number" class=""  id="price"  style="width:100%" name="price"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <label for="qty" class="col-sm-2 control-label">Stock :</label>
                            <div class="col-sm-2" >
                                <input type="number" class=""  id="qty"  style="width:100%" name="qty"/>
                            </div>
                        </div>

                        <input type="hidden" value="add" name="action"/>
                        <div class="panel-heading"><input type="submit" class="btn btn-success " style="float:right"/></div>
                    </form>
                </div>
            </div>

            <div class="form-group" id="redeem">
                <label for="price" class="col-sm-1 control-label">Redeem Point :</label>
                <div class="col-sm-1">
                    <input type="number" class="" style="width:100%" name="redeem"/>
                </div>
                <label for="price" class="col-sm-1 control-label">Accessory Type :</label>
                <div class="col-sm-4">
                    <label class="radio-inline">
                        <input type="radio" name="pType" value="watches"> Watches
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="pType" value="hat"> Hat
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="pType" value="glasses"> Glasses
                    </label>
                </div>
            </div>
            <!--Form-->
            <hr>

            <div class="table-responsive">
                <table class="table table-hover" id="dataTable">
                    <thead>
                        <tr>
                            <th>Picture</th>
                            <th>PSID<span class="glyphicon">&#xe150;</span></th>
                            <th>Brand<span class="glyphicon">&#xe150;</span></th>
                            <th>Name<span class="glyphicon">&#xe150;</span></th>
                            <th>Description<span class="glyphicon">&#xe150;</span></th>
                            <th>Price<span class="glyphicon">&#xe150;</span></th>
                            <th>Stock<span class="glyphicon">&#xe150;</span></th>
                            <th>Edit<span class="glyphicon">&#xe150;</span></th>
                        </tr>
                    </thead>
                    <tbody>
                    <cfd:listOtherProduct />
                    </tbody>
                </table>
            </div>
        </div>
        <!--   For modification  -->
    </body>
</html>
