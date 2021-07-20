<%--
  Created by IntelliJ IDEA.
  User: GTR_10
  Date: 16.06.2021
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Товари</title>
    <link href="<c:url value="/css/profile.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="/components/header.jsp"/>

<div class="card" id="profileCard">
    <img src="<c:url value="/images/img.png"/>" width="50%" height="50%">
    <h1>${userInfo.firstname} ${userInfo.lastname}</h1>
    <p class="title">CEO & Founder, Example</p>
    <p>${userInfo.email}</p>
    <ul>
        <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
    </ul>
</div>
<%--<div class="row" id="workerContainer"></div>--%>

<%--<script>--%>

<%--    function showProductsByOption(id) {--%>
<%--        $.ajax({--%>
<%--            type: "GET",--%>
<%--            async: false,--%>
<%--            url: "/workers",--%>
<%--            data: {--%>
<%--                typeId: id--%>
<%--            },--%>
<%--            success: function (data) {--%>
<%--                document.getElementById("workerContainer").innerHTML = "";--%>
<%--                data.forEach(function (element) {--%>
<%--                    document.getElementById("workerContainer").innerHTML +=--%>
<%--                        '<div class="column">'--%>
<%--                        + '<div class="card mt-5 ml-5 mb-5">'--%>
<%--                        + '<img src="/images/gc.png" width="100%" height="30%">' /* + element.photo */--%>
<%--                        + '<p>' + element.firstName + ' ' + element.lastName + '</p>'--%>
<%--                        + '<p>' + element.position + '<p>'--%>
<%--                        + '<p class="price">: ' + element.price + ' грн.</p>'--%>
<%--                        + '<p class="small">Description:' + element.description + '</p>'--%>
<%--                        + '<button onclick="addToCart(' + element.id + ')">Добавити в корзину' + '</button>'--%>
<%--                        + '</div>'--%>
<%--                        + '</div>';--%>
<%--                });--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>

<%--</script>--%>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
