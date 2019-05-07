<%-- 
    Document   : PurchaseOrderDetails
    Created on : 7 mai 2019, 14:36:32
    Author     : @Vkasperski
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PurchaseOrderDetails</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
            <c:forEach var="d" items="${test}">
                <li>${d}</li>
            </c:forEach>
        </ul>
    </body>
</html>
