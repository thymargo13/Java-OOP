<%
                String _post = (String)session.getAttribute("post");
                String ssid = (String)session.getAttribute("sid");
            %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">C & F</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="#">Home</a></li>
            <li><a href="custList.jsp">Customers</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Product<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="clothing.jsp">Clothing</a></li>
                    <li><a href="other.jsp">Other Product</a></li>
                </ul>
            </li>
            <li><a href="order.jsp">Invoice</a></li>
            <%
                if(_post.equalsIgnoreCase("admin")){
            %>
            <li><a href="staff.jsp">Create Staff</a></li>
            <%
            }
            %>
            <li><a href="handleStaff?action=edit&id=<%=ssid%>">Staff Info</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">

            <li><a href="CMSLogin?action=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>