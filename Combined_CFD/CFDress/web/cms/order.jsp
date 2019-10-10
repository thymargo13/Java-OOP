<%-- 
    Document   : order
    Created on : Nov 23, 2016, 9:40:38 PM
    Author     : thymmm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/cust_tag.tld" prefix="cfd" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="cms_css.jsp" %>
        <title>Invoice</title>
        <script>
            $(document).ready(function () {
                $('.dataTable').DataTable();
            });

        </script>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <!--   For modification  -->
        <div class="container">
            <div class="page-header">
                <h1>Invoice</h1>
            </div>

            <div class="table-responsive">
                
                <table class="table table-hover dataTable" >
                    <thead>
                        <tr>
                            <th>Invoice Date<span class="glyphicon">&#xe150;</span></th>
                            <th>Invoice No.<span class="glyphicon">&#xe150;</span></th>
                            <th>Customer Id.<span class="glyphicon">&#xe150;</span></th>
                            <th>Delivery Date<span class="glyphicon">&#xe150;</span></th>
                            <th>Address<span class="glyphicon">&#xe150;</span></th>
                            <th>Staff Id.<span class="glyphicon">&#xe150;</span></th>
                            <th>Status<span class="glyphicon">&#xe150;</span></th>
                            <th>Save<span class="glyphicon">&#xe150;</span></th>
                        </tr>
                    </thead>
                    <tbody>
                        <cfd:listInvoice/>
                    </tbody>
                </table>
                    
            </div>
        </div>
        <!--   For modification  -->
    </body>
</html>
