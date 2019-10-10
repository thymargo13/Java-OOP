<%-- 
    Document   : Product
    Created on : Nov 22, 2016, 11:26:04 AM
    Author     : thymmm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/cust_tag.tld" prefix="cfd" %>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <%@include file="cms_css.jsp" %>
          <script>
            $(document).ready(function () {
                 $('#dataTable').DataTable();
              
            });
        </script>
    </head>
    <body>
      <%@include file="header.jsp" %>
        <!--   For modification  -->
            <div class="container">
            <div class="page-header">
                <h1>Clothing Product</h1>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading"><h3>Add Product</h3></div>
                <div class="panel-body">
                    <form class="form-horizontal" action="handleProduct" method="get">
                        <div class="form-group">
                            <label for="Select" class="col-sm-2 control-label">Product Type:</label>
                            <div class="col-sm-8">
                                <select id="Select"  name="type" class="form-control">
                                    <option value="short">Short</option>
                                    <option value="pant">Pant</option>
                                    <option value="hoodie">Hoodies and Sweatshirt</option>
                                    <option value="coat">Jacket and Coat</option>

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
                        <div class="form-group">
                            <label for="price" class="col-sm-2 control-label">Price(HKD) :</label>
                            <div class="col-sm-3" >
                                <input type="number" class=""  id="price"  style="width:100%" name="price"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <label for="qty" class="col-sm-2 control-label">Stock :</label>
                            <div class="col-sm-1" >
                                <input type="number"   placeholder="XL"style="width:100%" name="xlargeStock"/>
                            </div>
                            <div class="col-sm-1" >
                                <input type="number"  placeholder="X"style="width:100%" name="largeStock"/>
                            </div>
                            <div class="col-sm-1" >
                                <input type="number"   placeholder="M"style="width:100%" name="middleStock"/>
                            </div>
                            <div class="col-sm-1" >
                                <input type="number" placeholder="S"style="width:100%" name="smallStock"/>
                            </div>
                        </div>

                        <input type="hidden" value="add" name="action"/>
                        <div><input type="submit" class="btn btn-success " style="float:right"/></div>
                    </form>
                </div>
            </div>

           
            <!--Form-->
            <hr>

            <div class="table-responsive">
                <table class="table table-hover" id="dataTable">
                    <thead>
                        <tr>
                            <th>Picture</th>
                            <th>PID<span class="glyphicon">&#xe150;</span></th>
                            <th>Brand<span class="glyphicon">&#xe150;</span></th>
                            <th>Name<span class="glyphicon">&#xe150;</span></th>
                            <th>Description<span class="glyphicon">&#xe150;</span></th>
                            <th>Price<span class="glyphicon">&#xe150;</span></th>
                        <!--   <th>Stock<span class="glyphicon">&#xe150;</span></th>-->
                            <th>Edit<span class="glyphicon">&#xe150;</span></th>
                        </tr>
                    </thead>
                    <tbody>
                    <cfd:listProduct />
                    </tbody>
                </table>
            </div>
        </div>
        <!--   For modification  -->
    </body>
</html>
