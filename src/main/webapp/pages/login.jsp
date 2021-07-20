<%--
  Created by IntelliJ IDEA.
  User: Danylo Bubniy
  Date: 26.01.2020
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Увійти</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link href="<c:url value="/css/login.css"/>" rel="stylesheet" type="text/css">

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
    </script>
</head>
<body>
<h2>Login Page</h2><br>
<div class="login">
    <form method="get" action="<c:url value="/home"/>" onsubmit="return validateCredentials()">
        <label><b>Email
        </b>
        </label>
        <input type="text" name="email" id="email" placeholder="email" required>
        <br><br>
        <label><b>Password
        </b>
        </label>
        <input type="Password" name="password" id="password" placeholder="password" required>
        <div class="signin">
            <button type="submit" class="registerbtn">log in here</button>
            <p>
                It`s your first time?Never mind <a href="<c:url value="/pages/registration.jsp"/>">Registration</a>.
            </p>
        </div>
    </form>
</div>
<%--<form method="get" action="<c:url value="/home"/>" onsubmit="return validateCredentials()">--%>
<%--    <div class="container mt-3">--%>
<%--        <h1 class="title">Вхід</h1>--%>
<%--        <hr>--%>
<%--        <input type="text" placeholder="Your Email" name="email" id="email" required>--%>
<%--        <input type="password" placeholder="Password" name="password" id="password" required>--%>
<%--        <hr>--%>
<%--        <div class="signin">--%>
<%--            <button type="submit" class="registerbtn">Увійти</button>--%>
<%--            <p>--%>
<%--                Вперше на сайті ? <a href="<c:url value="/pages/registration.jsp"/>">Зареєструйтесь</a>.--%>
<%--            </p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</form>--%>
<script>
    function validateCredentials() {

        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;

        let success = false;

        $.ajax({
            type: "POST",
            async: false,
            url: "/login",
            data: {
                email: email,
                password: password
            }
        }).done(function (response) {
            console.log(response);
            success = true;
        }).fail(function (response) {
            success = false;

            if (response.status === 401) {
                alert("НЕВІРНИЙ ПАРОЛЬ");
            } else if (response.status === 403) {
                alert("КОРИСТУВАЧА З ТАКИМ НІКНЕЙМОМ НЕ ІСНУЄ. БУДЬ ЛАСКА, ЗАРЕЄСТРУЙТЕСЬ!")
            }
        });

        return success;
    }
</script>
</body>
</html>
