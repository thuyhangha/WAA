<%-- 
    Document   : HelloWorld
    Created on : Nov 12, 2017, 11:51:23 AM
    Author     : hangha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World</h1>
        <% for(int i = 1; i <= 10; i++) {%>
            <h4> <%=i%> </h4>
        <% } %>
    </body>
</html>
