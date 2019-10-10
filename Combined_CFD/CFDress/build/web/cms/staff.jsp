<%-- 
    Document   : staff
    Created on : Nov 20, 2016, 9:51:40 PM
    Author     : thymmm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/cust_tag.tld" prefix="cfd" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="cms_css.jsp" %>
        <title>Staff</title>
        <script>
            $(document).ready(function() {
    $('#dataTable').DataTable();
} );
            
        </script>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <!--   For modification  -->
        <div class="container">
            <div class="page-header">
                <h1>Staff</h1>
            </div>

            <div class="panel-group">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" href="#collapse1">Add Staff <span class="glyphicon glyphicon-plus-sign"></span></a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">
                        <div class="panel-body">
                            <form class="form-horizontal" action="handleStaff" method="get">
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="fName">First Name:</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" id="fName" name="fName" placeholder="Enter First Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="lName">Last Name:</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" id="lName" name="lName" placeholder="Enter Last Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="post">Post :</label>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input type="radio" name="post" value="staff"> staff
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="post" value="manager"> manager
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="post" value="admin"> admin
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="Shop">Shop :</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" id="shop" name="shop" placeholder="Enter Workplace">
                                    </div>
                                </div>
                                 <input type="hidden" name="action" value="add"/>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="submit" class="btn btn-default">Submit</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table table-hover" id="dataTable">
                    <thead>
                        <tr>
                            <th>Staff ID<span class="glyphicon">&#xe150;</span></th>
                            <th>First Name<span class="glyphicon">&#xe150;</span></th>
                            <th>Last Name<span class="glyphicon">&#xe150;</span></th>
                            <th>Post<span class="glyphicon">&#xe150;</span></th>
                            <th>Workplace<span class="glyphicon">&#xe150;</span></th>
                            <th>Entry Date<span class="glyphicon">&#xe150;</span></th>
                         <!--   <th>Password<span class="glyphicon">&#xe150;</span></th> -->
                            <th>Edit<span class="glyphicon">&#xe150;</span></th>
                        </tr>
                    </thead>
                    <tbody>
                        <cfd:listStaff />
                    </tbody>
                </table>
            </div>
        </div>
        <!--   For modification  -->
    </body>
</html>
