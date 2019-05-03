<%-- 
    Document   : home.jsp
    Created on : 3 mai 2019, 15:35:45
    Author     : phili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intranet</title>
    </head>
    <body>
        <h1>Bienvenue ! </h1>
        <form action="Home" method="POST">
            <input type="hidden" name="button" id="button" value="home">
            <input type="submit" name="commande" id="element" value="Commande" onclick="document.getElementById('button').value = 'commande';">
        </form>
</html>

