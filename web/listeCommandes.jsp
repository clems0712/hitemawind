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
            <table>
                <tr>
                    <th>Id Commande</th>
                    <th>Employé</th>
                    <th>Client</th>
                    <th>Date Commande</th>
                    <th>Expéditeur</th>
                    <th>Ville expéditeur</th>
                    <th>Date envoi</th>
                    <th>Taxes</th>
                    <th>Type paiement</th>
                    <th>Notes</th> 
                    <th>Statut</th>
                </tr>
                <tbody>
            <c:forEach var="data" items="${data}">
                <tr>
                    <td>${data.getId()}</td>
                    <td>${data.getEmployeeId().getLastName()}</td>
                    <td>${data.getCustomerId().getLastName()}</td>
                    <td>${data.getOrderDate()}</td>
                    <td>${data.getShipName()}</td>
                    <td>${data.getShipCity()}</td>
                    <td>${data.getShippedDate()}</td>
                    <td>${data.getTaxes()}</td>
                    <td>${data.getPaymentType()}</td>
                    <td>${data.getNotes()}</td>
                    <td>${data.getStatusId().getStatusName()}</td>
                </tr>
            </c:forEach>
                </tbody>
            </table>
        </ul>
    </body>
</html>
