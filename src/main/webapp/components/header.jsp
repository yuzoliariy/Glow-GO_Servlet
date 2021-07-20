<%--
  Created by IntelliJ IDEA.
  User: GTR_10
  Date: 06.06.2021
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>GLOW</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link type="text/css" rel="stylesheets" href="../css/homePage.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>

<div class="w3-top">
    <div class="w3-bar w3-white w3-wide w3-padding w3-card">
        <a href="<c:url value="/home"/>" class="w3-bar-item w3-button"><b>GLOW</b> </a>
        <!-- Float links to the right. Hide them on small screens -->
        <!--<a href="#" class="w3-bar-item w3-button">categories</a>-->
        <div class="w3-right w3-hide-small" style="width:900px;">
            <c:if test="${empty sessionScope.user}">
                <a href="<c:url value="/about"/>" class="w3-bar-item w3-button">about</a>
                <a href="<c:url value="/productTypes"/>" class="w3-bar-item w3-button">category</a>
                <a href="<c:url value="/login"/>" class="w3-bar-item w3-button">log in</a>
            </c:if>
            <c:if test="${empty sessionScope.user == false && sessionScope.user.userType == 'USER'}">
                <a href="<c:url value="/about"/>" class="w3-bar-item w3-button">about</a>
                <a href="<c:url value="/productTypes"/>" class="w3-bar-item w3-button">category</a>
                <a href="<c:url value="/logout"/>" class="w3-bar-item w3-button">log out</a>
                <a href="<c:url value="/basket"/>" class="w3-bar-item w3-button">basket</a>
                <a href="<c:url value="/profile"/>" class="w3-bar-item w3-button">profile</a>
                <a href="<c:url value="/workers"/>" class="w3-bar-item w3-button">our workers</a>
            </c:if>
            <c:if test="${empty sessionScope.user == false && sessionScope.user.userType == 'ADMIN'}">
                <a href="<c:url value="/productTypes"/>" class="w3-bar-item w3-button">category</a>
                <a href="<c:url value="/logout"/>" class="w3-bar-item w3-button">log out</a>
                <a href="<c:url value="/profile"/>" class="w3-bar-item w3-button">profile</a>
                <a href="<c:url value="/workers"/>" class="w3-bar-item w3-button">our workers</a>
                <a href="<c:url value="/addProduct"/>" class="w3-bar-item w3-button">add product</a>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
