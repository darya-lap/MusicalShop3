<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="m" uri="/WEB-INF/tld/m.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="MyContainer.BucketContainer" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<html>
<head>
    <title>Authorization</title>
    <link rel="stylesheet" type="text/css" href="/resources/CSS/style.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/CSS/styleAuth.css"/>
</head>
<body>
<c:if test="${empty pageContext.request.parameterMap.lang[0]}">
    <c:if test="${empty cookie.lang.value}">
        <fmt:setLocale value='ru'/>
    </c:if>
    <c:if test="${cookie.lang.value eq 'ru'}">
        <fmt:setLocale value="ru"/>
    </c:if>
    <c:if test="${cookie.lang.value eq 'en'}">
        <fmt:setLocale value="en"/>
    </c:if>
    <c:if test="${cookie.lang.value eq 'fr'}">
        <fmt:setLocale value="fr"/>
    </c:if>
</c:if>
<c:if test="${pageContext.request.parameterMap.lang[0] eq 'ru'}">
    <fmt:setLocale value="ru"/>
</c:if>
<c:if test="${pageContext.request.parameterMap.lang[0] eq 'en'}">
    <fmt:setLocale value="en"/>
</c:if>
<c:if test="${pageContext.request.parameterMap.lang[0] eq 'fr'}">
    <fmt:setLocale value="fr"/>
</c:if>

<fmt:setBundle basename="prop"/>

<div id="container">
    <div id="header">
        <div id = "allshopname">
            <h1> Musse </h1>
            <fmt:setBundle basename="prop"/>
            <h2><fmt:message key="shopName"/></h2>
        </div>

        <%--<button class = "butbucket">--%>
        <%--</button>--%>


    </div>

    <div class = "contentAuth"  id = "content1">
        <form action="j_security_check" method="post" name="loginForm" class="auth1">
            <label class="loginAndPasswordLabel"><fmt:message key="tryAgain"/></label>
            <label class="loginAndPasswordLabel"><fmt:message key="login"/></label><br>
            <input class="loginAndPasswordInput" type="text" name="j_username" placeholder="имя" size="20"/><br>
            <label class="loginAndPasswordLabel"><fmt:message key="txtPassword"/></label><br>
            <input class="loginAndPasswordInput" type="password" name="j_password" size="20"/><br>
            <input class="submitButton" type="submit" value="<fmt:message key="enter"/>"/>
        </form>
    </div>

    <div id="footer" >

    </div>
</div>

</body>
</html>
