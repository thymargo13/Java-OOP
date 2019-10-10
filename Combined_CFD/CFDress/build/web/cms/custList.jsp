<%--
    Document   : custList
    Created on : Nov 19, 2016, 3:21:40 PM
    Author     : Daniel
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/cust_tag.tld" prefix="cfd" %>

<!DOCHTML>
<html>
    <head>
        <%@include file="cms_css.jsp" %>
        <title>Customer List</title>
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
                <h1>Customers</h1>
            </div>
            <div class="table-responsive">
                <table class="table table-hover" id="dataTable">
                    <thead>
                        <tr>
                            <th>ID<span class="glyphicon">&#xe150;</span></th>
                            <th>Firstname<span class="glyphicon">&#xe150;</span></th>
                            <th>Lastname<span class="glyphicon">&#xe150;</span></th>
                            <th>Email<span class="glyphicon">&#xe150;</span></th>
                            <th>RegDate<span class="glyphicon">&#xe150;</span></th>
                            <th>Phone<span class="glyphicon">&#xe150;</span></th>
                            <th>Status<span class="glyphicon">&#xe150;</span></th>
                            <th>Action<span class="glyphicon">&#xe150;</span></th>
                        </tr>
                    </thead>
                    <tbody>
                        <cfd:listCustomer />
                    </tbody>
                </table>
            </div>
        </div>
        <!--   For modification  -->
    </body>
</html>



