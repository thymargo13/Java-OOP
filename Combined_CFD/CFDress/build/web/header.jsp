<!-- Top header -->
<%@taglib uri="/WEB-INF/tlds/cust_tag.tld" prefix="cfd" %>

<header class="w3-container w3-xlarge">
    <!-- Change the topic !!!!!  -->
    <p class="w3-left">Jeans</p>
    <p class="w3-right">
        <%

            String loginStatus = session.getAttribute("isLogined") == null ? "false" : "true";
            System.out.println("debug: " + loginStatus);
             int cartSize =0;
            if(session.getAttribute("cartSize")!=null){
                cartSize = (Integer)session.getAttribute("cartSize");
            }
             
        %>
        <cfd:showHeaderIcon isLogined="<%=loginStatus%>" />
        <a href="search.jsp"><i class="fa fa-search">Search</i></a>
        <a href="displayCart"><i class="fa fa-shopping-cart w3-margin-right">View Cart</i><span class="w3-badge" id="count"><%=cartSize%></span></a>
        
        
    </p>
</header>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-black w3-xlarge w3-padding-24">
    <span class="w3-left w3-wide">C & F Dress</span>
    <a href="javascript:void(0)" class="w3-right w3-opennav" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>
