<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GLOW</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link type="text/css" rel="stylesheets" href="css/homePage.css">
</head>
<body>
<jsp:include page="components/header.jsp"/>
<header class="w3-display-container w3-content w3-wide" style="max-width:1500px;" id="home">
    <img src="images/img.png" style="width:100%" alt="">
    <div class="w3-display-middle w3-margin-top w3-center">
        <h1 class="w3-xxlarge w3-text-white"><span class="w3-padding w3-black w3-opacity-min"><b>GLOW</b>
        </span> <span class="w3-hide-small w3-text-light-grey">&go</span></h1>
    </div>
</header>
<jsp:include page="components/footer.jsp"/>
</body>
</html>
