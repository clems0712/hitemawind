<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="fr">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title Page-->
    <title>Northwind - Accueil</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>
<body class="animsition">
<form action="Home" method="POST" id="valid">
    <div class="page-wrapper">1
        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a style="text-align:center;">
                    <img src="images/icon/logo.png" alt="Cool Admin" style="height:60%; width:60%; "/>
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li onclick="document.getElementById('button').value = 'home'; document.getElementById('valid').submit();" style="cursor:pointer"> 
                            <a>
                                <i class="fas fa-home"></i>Accueil</a>
                        </li>
                        <li onclick="document.getElementById('button').value = 'client'; document.getElementById('valid').submit();" style="cursor:pointer">
                            <a>
                                <i class="fas fa-address-book"></i>Client</a>
                        </li>
                        <li class="active has-sub" onclick="document.getElementById('button').value = 'employe'; document.getElementById('valid').submit();" style="cursor:pointer">
                            <a>
                                <i class="fas fa-desktop"></i>Employés</a>
                        </li>
                        <li onclick="document.getElementById('button').value = 'facture'; document.getElementById('valid').submit();" style="cursor:pointer">
                            <a>
                                <i class="fas fa-file"></i>Factures</a>
                        </li>
                        <li onclick="document.getElementById('button').value = 'Stocks'; document.getElementById('valid').submit();" style="cursor:pointer">
                            <a>
                                <i class="fas fa-database"></i>Stocks</a>
                        </li>
                        <li onclick="document.getElementById('button').value = 'commande'; document.getElementById('valid').submit();" style="cursor:pointer">
                            <a>
                                <i class="fas fa-box"></i>Commandes</a>
                        </li>
                        <li onclick="document.getElementById('button').value = 'Fournisseurs'; document.getElementById('valid').submit();" style="cursor:pointer">
                            <a  >
                                <i class="fas fa-truck"></i>Fournisseurs</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <h1>Liste des Employés</h1>
                    </div>
                </div>
            </header>
            <!-- HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <input type="hidden" name="button" id="button" value="home">                
                <table class="table table-borderless table-data3">
               <tr>
                   <th>Entreprise</th>
                   <th>Nom</th>
                   <th>Prénom</th>
                   <th>Adresse mail</th>
                   <th>Poste</th>
               </tr>
               <tbody>
           <c:forEach var="invoice" items="${data}">²
               <tr>
                   <td>${invoice.getCompany()}</td>
                   <td>${invoice.getLastName()}</td>
                   <td>${invoice.getFirstName()}</td>
                   <td>${invoice.getEmailAddress()}</td>
                   <td>${invoice.getJobTitle()}</td>
               </tr>
           </c:forEach>
               </tbody>
           </table>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>
</form>
    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- fin document-->
