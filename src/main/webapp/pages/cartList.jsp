<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 04.02.2020
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Корзина</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/cards.css"/>">
</head>
<body>
<jsp:include page="/components/header.jsp"/>

<div style="display: inline-flex; margin-top: 100px" >
    <button type="button" class="btn btn-primary" style="display:block; margin-top: 30px; margin-left: 50px; background-color: pink"
            onclick="clearCart()">Clean card
    </button>
    <button type="button" class="btn btn-primary" style="display:block; margin-top: 30px; margin-left: 50px; background-color: pink"
            onclick="buyProducts('${personInfo.email}')">To order
    </button>
</div>
<hr>

<c:forEach items="${productList}" var="product">
    <div class="row" id="cartRow">
        <div class="column">
            <div class="card mt-5 ml-5 mb-5">
                <p>${product.name} ${product.description} ${product.brand}</p>
                <p class="price">Ціна: ${product.price} грн.</p>
                <p class="small">Capacity: ${product.capacity}</p>
                <button onclick="removeFromCart(${product.id})">Забрати з корзини</button>
            </div>
        </div>
    </div>
</c:forEach>
<script>
    function removeFromCart(id) {
        $.ajax({
            type: "DELETE",
            async: false,
            url: "http://localhost:8080/basket" + '?productId=' + id,
        }).done(function () {
            alert("ВАШ ТОВАР УСПІШНО ВИДАЛЕНО");
        }).fail(function () {
            alert("ВАШ ТОВАР НЕ ВДАЛОСЯ ВИДАЛИТИ, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }

    function clearCart() {
        $.ajax({
            type: "DELETE",
            async: false,
            url: "http://localhost:8080/emptyBasket",
        }).done(function () {
            alert("ВСІ ТОВАРИ УСПІШНО ВИДАЛЕНО");
        }).fail(function () {
            alert("ЩОСЬ ПІШЛО НЕ ТАК, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }

    function buyProducts(email) {
        $.ajax({
            type: "POST",
            async: false,
            url: "/emptyBasket",
            data: {
                email: email
            }
        }).done(function () {
            alert("ВАМ НА ПОЧТУ ВІДПРАВЛЕНО ДЕТАЛІ ОПЛАТИ");
        }).fail(function () {
            alert("ЩОСЬ ПІШЛО НЕ ТАК, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }
</script>

<jsp:include page="../components/footer.jsp"/>
</body>
</html>
