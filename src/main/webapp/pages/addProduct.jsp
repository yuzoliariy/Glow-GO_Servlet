<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 26.01.2020
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link href="<c:url value="/css/addProduct.css"/>" rel="stylesheet" type="text/css">

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
    </script>
</head>
<body>
<jsp:include page="/components/header.jsp"/>
<form method="post" action="<c:url value="/pages/addProduct.jsp"/>" onsubmit="return validateCredentials()">
    <div class="container mt-3">
        <h1 class="title">
            <div style="position:relative; top:20px;">Add Product
            </div>
        </h1>
        <hr>
        <input type="text" placeholder="name" name="name" id="name" required>
        <input type="text" placeholder="price" name="price" id="price" required>
        <input type="text" placeholder="brand" name="brand" id="brand" required>
        <input type="text" placeholder="description" name="description" id="description" required>
        <input type="text" placeholder="capacity" name="capacity" id="capacity" required>
        <input type="text" placeholder="madeIn" name="madeIn" id="madeIn" required>
        <input type="text" placeholder="productTypeId" name="productTypeId" id="productTypeId" required>
        <input type="file" placeholder="photo"  id="photo" name="photo" accept="image/jpeg, image/png" required>
        <
        <hr>
        <div class="addProduct">
            <button type="submit" class="confirm">add product</button>
            <p>
        </div>
    </div>
</form>
<script type="text/javascript">

    function validateCredentials() {
        var name = document.getElementById("name").value;
        var price = document.getElementById("price").value;
        var brand = document.getElementById("brand").value;
        var description = document.getElementById("description").value;
        var capacity = document.getElementById("capacity").value;
        var madeIn = document.getElementById("madeIn").value;
        var productTypeId = document.getElementById("productTypeId").value;
        var photo = document.getElementById("photo").files[0].name;



        let success = false;
        $.ajax({
            type: "POST",
            async: false,
            url: "/addProduct",
            data: {
                name: name,
                price: price,
                brand: brand,
                description: description,
                capacity: capacity,
                madeIn: madeIn,
                productTypeId: productTypeId,
                photo: photo
            }
        }).done(function (response) {
            console.log(response);
            success = true;
            alert("YOU ADD!");
        }).fail(function (response) {
            success = false;
            if (response.status === 403) {
                alert("YOU CAN`T ADD!");
            }
        });

        return success;
    }
</script>

<jsp:include page="../components/footer.jsp"/>
</body>
</html>
