<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 25.10.2016
  Time: 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="m" uri="/WEB-INF/tld/m.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <head>
        <title>Bucket</title>
        <link rel="stylesheet" type="text/css" href="/resources/CSS/style.css"/>
        <script type="text/javascript" src="/resources/JS/JavaScriptic.js"></script>

        <div>
            <input type="button" class = "lang" id = 'butEn' onclick=setAttr('lang','en') value=""/>
            <input type="button" class = "lang" id = 'butRu' onclick=setAttr('lang','ru') value=""/>
            <input type="button" class = "lang" id = 'butFr' onclick=setAttr('lang','fr') value=""/>
            <c:if test="${requestScope.containsValue('lang') eq 'false'}">
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
            <c:if test="${requestScope.lang.value eq 'ru'}">
                <fmt:setLocale value="ru"/>
                ${cookie.put("lang",'ru')}
            </c:if>
            <c:if test="${requestScope.lang.value eq 'en'}">
                <fmt:setLocale value="en"/>
                ${cookie.put("lang",'en')}
            </c:if>
            <c:if test="${requestScope.lang.value eq 'fr'}">
                <fmt:setLocale value="fr"/>
                ${cookie.put("lang",'fr')}
            </c:if>
        </div>
    </head>

<body>
<div id="container">
    <div id="header">
        <div id = "allshopname">
            <h1> Musse </h1>
            <fmt:setBundle basename="prop"/>
            <h2><fmt:message key="shopName"/></h2>
        </div>

        <button class = "butbucket">
        </button>

        <button class = "login">
        </button>

    </div>

    <div id="menu">
        <div id = "catalogue" >
            <input type="button" class="catal" value="<fmt:message key="catalog"/>" onclick="setAttr('filter','all')"/>
        </div>

        <div id = "instruments">
            <ul class="dropdown">
                <li class="dropdown-top">
                    <input type="button" class="menuType" onclick=setAttr('filter','string') value="<fmt:message key="string"/>"/>

                    <ul class="dropdown-inside">
                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','guitar') value="<fmt:message key="guitars"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','violin') value="<fmt:message key="violins"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','cello') value="<fmt:message key="cellos"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','piano') value="<fmt:message key="pianos"/>"/>
                        </li>
                    </ul>
                </li>

                <li class="dropdown-top">
                    <input type="button" class="menuType" onclick=setAttr('filter','wind') value="<fmt:message key="wind"/>"/>

                    <ul class="dropdown-inside">

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','sax') value="<fmt:message key="sax"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','flute') value="<fmt:message key="flutes"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','pipe') value="<fmt:message key="pipes"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','clarinet') value="<fmt:message key="clarinets"/>"/>
                        </li>
                    </ul>
                </li>

                <li class="dropdown-top">
                    <input type="button" class="menuType" onclick=setAttr('filter','keyboard') value="<fmt:message key="keyboards"/>"/>

                    <ul class="dropdown-inside">

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','synthesizer') value="<fmt:message key="synthesizers"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','accordion') value="<fmt:message key="accordions"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr('filter','bayan') value="<fmt:message key="bayans"/>"/>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div class = "content"  id = "content1">

    </div>

    <div id="footer" >

    </div>
</div>
<!--<form action="InstrumentDetailsServlet" method="get">
    <input type = image src = "resources/CSS/">
</form>-->
</body>
</html>