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
    <link href="<c:url value="/css/category.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/css/cards.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="/components/header.jsp"/>

<h2 style="text-align:center">Каталог</h2>
<h2 style="text-align:center">Category of products</h2>
<select id="dropdownlist" onchange="showProductsByOption(value)" class="select-css"
        style="text-align:center; background-color: pink;width: 500px;height: 30px  " >
</select>
<c:forEach items="${allProducts}" var="product">
    <div class="column" style="width: 200px">
        <div class="select" >
            <img src="${product.photo}" alt="" style="width:100%">
            <p>${product.name} ${product.brand} ${product.madeIn}</p>
            <p> ${product.capacity}ml<p>
            <p class="price">Price: ${product.price} $.</p>
            <p class="small">Description of product: ${product.description}  </p>
            <button onclick="addToCart(${product.id} )">Add to card</button>
        </div>
    </div>
</c:forEach>
<div class="row" id="productsContainer"></div>

<script>
    function addToCart(id) {
        $.ajax({
            type: "POST",
            async: false,
            url: "/basket",
            data: {
                productId: id
            }
        }).done(function () {
            alert("ВАШ ТОВАР УСПІШНО ДОДАНО");
        }).fail(function () {
            alert("ВАШ ТОВАР НЕ ДОДАНО, СПРОБУЙТЕ ЩЕ РАЗ");
        });
    }

    function showProductsByOption(id) {
        $.ajax({
            type: "POST",
            async: false,
            url: "/products",
            data: {
                typeId: id
            },
            success: function (data) {
                document.getElementById("productsContainer").innerHTML = "";
                data.forEach(function (element) {
                    document.getElementById("productsContainer").innerHTML +=
                        '<div class="column">'
                        + '<div class="card mt-5 ml-5 mb-5">'
                        + '<img src= "' + element.photo + '" width="100%" height="30%">'
                        + '<p>' + element.name + ' ' + element.brand + ' ' + element.madeIn + '</p>'
                        + '<p>' + element.capacity + '<p>'
                        + '<p class="price">Price: ' + element.price + ' грн.</p>'
                        + '<p class="small">Description:' + element.description + '</p>'
                        + '<button onclick="addToCart(' + element.id + ')">Добавити в корзину' + '</button>'
                        + '</div>'
                        + '</div>';
                });
            }
        });
    }

    /**
     * show categories
     */
    $(document).ready(function () {
        $.ajax({
            url: "/productTypes",
            method: "POST",
            success: function (data) {
                var $select = $("#dropdownlist");
                $select.find("option").remove();
                $.each(data, function (index, category) {
                    $("<option>").val(category.id).text(category.type).appendTo($select);
                });
            }
        })
    })
</script>

<jsp:include page="../components/footer.jsp"/>
</body>
</html>
