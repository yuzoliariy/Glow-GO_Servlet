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

    <link href="<c:url value="/css/registration.css"/>" rel="stylesheet" type="text/css">

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
    </script>
</head>
<body>
<form method="post" action="<c:url value="/pages/login.jsp"/>" onsubmit="return validateCredentials()">
    <div class="container mt-3">
        <h1 class="title">Registration</h1>
        <hr>
        <input type="text" placeholder="firstname" name="firstName" id="firstName" required>
        <input type="text" placeholder="lastname" name="lastName" id="lastName" required>
        <input type="text" placeholder="phone" name="phoneNumber" id="phoneNumber" required>
        <input type="text" placeholder="email" name="email" id="email" required>
        <input type="text" placeholder="date of birthday" name="dataOfBirthday" id="dataOfBirthday" required>
        <input type="password" placeholder="password" name="password" id="password" required>
        <input type="password" placeholder="confirm your password" name="passwordConfirm" id="passwordConfirm" required>
        <hr>
        <div class="signin">
            <button type="submit" class="registerbtn">register</button>
            <p>
            <div class="divider"></div>
            Already registered? <a href="<c:url value="/pages/login.jsp"/>">log in</a>.
            </p>
        </div>
    </div>
</form>
<script>
    function validateCredentials() {
        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        var phoneNumber = document.getElementById("phoneNumber").value;
        var password = document.getElementById("password").value;
        var email = document.getElementById("email").value;
        var dataOfBirthday = document.getElementById("dataOfBirthday").value;
        var passwordConfirm = document.getElementById("passwordConfirm").value;

        if (password !== passwordConfirm) {
            alert("Passwords don't match");
            return false;
        }

        let success = false;
        $.ajax({
            type: "POST",
            async: false,
            url: "/register",
            data: {
                firstName: firstName,
                lastName: lastName,
                phoneNumber: phoneNumber,
                password: password,
                email: email,
                dataOfBirthday: dataOfBirthday
            }
        }).done(function (response) {
            console.log(response);
            success = true;
        }).fail(function (response) {
            success = false;

            if (response.status === 403) {
                alert("КОРИСТУВАЧ З ТАКИМ НІКНЕЙМОМ ВЖЕ ІСНУЄ!");
            }
        });

        return success;
    }
</script>
</body>
</html>
