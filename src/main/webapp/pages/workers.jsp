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
    <link href="<c:url value="/css/workers.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="/components/header.jsp"/>

<h2 style="text-align:center">Каталог</h2>
<div class="text" >
<h2 style="text-align:center">Our Worker List</h2>
</div>
<div class="row" id="workersRow">
<c:forEach items="${workers}" var="worker">
    <div class="column">
        <div class="card mt-5 mb-5" style="display: inline-block;">
            <img src="${worker.photo}" alt="" style="width:100%">
            <h1>${worker.firstName} ${worker.lastName} </h1>
            <p class="title"> ${worker.position}<p>
            <p class="age">age: ${worker.age} years old</p>
            <p class="experience">experience: ${worker.experience} years </p>
            <p class="rating">rating: ${worker.rating}/5 </p>
        </div>
    </div>
</c:forEach>
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
