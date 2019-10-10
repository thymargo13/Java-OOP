<%-- 
    Document   : errorPage
    Created on : Nov 23, 2016, 8:08:15 PM
    Author     : thymmm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html> 
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <title>JSP Page</title>   
    </head>    
    <body>
        ErrorPage.jsp reported the following error:         <I><%= exception%></I>.
            <%
                if (exception instanceof NumberFormatException) {
                    out.println("<br/><b>You should input the information of Product!!!</b><br/>");
                }
            %>   
        <a  href="clothing.jsp" >Please try again!!!</a>    
    </body> 
</html> 

