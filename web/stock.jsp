<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page de stock</title>
    </head>
    <body>
<<<<<<< HEAD
        <h1>Products</h1>
=======
        <h1>Stock des transactions:</h1>
>>>>>>> 0777ab3e34663649854e828611e52e02da7af67a
        <ul>
            <c:forEach var="d" items="${data}">
                <li>- ${d}</li>
            </c:forEach>
        </ul>
    </body>
</html>
