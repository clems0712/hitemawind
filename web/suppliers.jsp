<%-- 
    Document   : stock
    Created on : 7 mai 2019, 12:06:51
    Author     : max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Suppliers</h1>
        <ul>
            <c:forEach var="d" items="${data}">
                <li>${d.supplierIds}</li>
            </c:forEach>
        </ul>
    </body>
</html>
