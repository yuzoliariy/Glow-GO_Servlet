<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>about company</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/aboutCompany.css"/>">
    <link rel="shortcut icon" href="#">
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<div class="about-section">
    <h1>About Us</h1>
    <p>GLOW&go is a beauty media empire. Reviews, swatches, tests, secrets and expert advice - you will find all this at
        MAKEUP Beauty Club! More than 1.5 million Facebook subscribers, more than 500 thousand Instagram followers, a
        Youtube channel, an online digest, a beauty editorial blog and over 2 million product reviews - over the years
        we have built a unique information portal and won a huge army of supporters.

        Join the GLOW&go community and create beauty history with us!.</p>
</div>

<h2 style="text-align:center">Our Team</h2>
<div class="row">
    <div class="column">
        <div class="card">
            <img src="<%=request.getContextPath()%> /images/Danylo.jpg" alt="Danylo" style="width:100%">
            <div class="container">
                <h2>Danylo Bubnii</h2>
                <p class="title">Main Developer</p>
                <p>danylobybnii@gmail.com</p>
                <p>
                    <button class="button">Contact</button>
                </p>
            </div>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <img src="<%=request.getContextPath()%>../images/Yulia...png" alt="gc" style="width:100%">
            <div class="container">
                <h2>Yulia Zoriy</h2>
                <p class="title"> Director and owner of company</p>
                <p>yuliazoriy@gmail.com</p>
                <p>
                    <button class="button">Contact</button>
                </p>
            </div>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <img src="<%=request.getContextPath()%>../images/Denys...jpg" alt="Sandra" style="width:100%">
            <div class="container">
                <h2>Sandra Doe</h2>
                <p class="title">Designer</p>
                <p>sandradoe@gmail.com</p>
                <p>
                    <button class="button">Contact</button>
                </p>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
