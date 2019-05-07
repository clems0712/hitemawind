<%-- 
    Document   : listeCommandes
    Created on : 3 mai 2019, 15:18:27
    Author     : phili
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
        <h1>Liste des commandes:</h1>
        <form action="Home" method="POST">
            <input type="hidden" name="button" id="button" value="home">
            <input type="submit" value="< Retour" onclick="document.getElementById('button').value = 'home';">
        </form>
        <ul>
            <c:forEach var="d" items="${data}">
                <li>${d}</li>
            </c:forEach>
        </ul>
    </body>
</html>