<%-- 
    Document   : stock
    Created on : 7 mai 2019, 12:06:51
    Author     : max
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Purchase Orders</h1>
        <ul>
            <c:forEach var="d" items="${data}">
                <li>- ${d}</li>
            </c:forEach>
        </ul>
    </body>
</html>