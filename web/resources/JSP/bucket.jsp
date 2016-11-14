<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="m" uri="/WEB-INF/tld/m.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="MyContainer.BucketContainer" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Bucket</title>
        <link rel="stylesheet" type="text/css" href="/resources/CSS/style.css"/>
        <link rel="stylesheet" type="text/css" href="/resources/CSS/styleBucket.css"/>
        <script type="text/javascript" src="/resources/JS/JavaScriptic.js"></script>
    <jsp:useBean id="container" scope="session" class="MyContainer.BucketContainer"/>

        <div>
            <input type="button" class = "lang" id = 'butEn' onclick=setAttr('lang','en') value=""/>
            <input type="button" class = "lang" id = 'butRu' onclick=setAttr('lang','ru') value=""/>
            <input type="button" class = "lang" id = 'butFr' onclick=setAttr('lang','fr') value=""/>

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

        <%--<button class = "butbucket">--%>
        <%--</button>--%>
        <button class = "butbucket" id="bucket" onclick="goToBucket('${pageContext.request.parameterMap.lang[0]}')" value="" title="<fmt:message key="goToBucket"/>"></button>
        <button class = "login" onclick="goToAuth('${pageContext.request.parameterMap.lang[0]}')" title="

<%if (session.getAttribute("user") == null){%>
    <fmt:message key="logInSystem"/>"></button>
        <%}
        else{%>
        <fmt:message key="logOutSystem"/>"></button>
        <p class="userInfo"><fmt:message key="youEnterAs"/></p>
        <a class="userInfo1" href="myAccount.jsp?lang=${pageContext.request.parameterMap.lang[0]}" title="<fmt:message key="goToAccount"/>"><%=session.getAttribute("user")%></a>
        <%if (!container.isEmpty()){%>
            <button class="goToOrder" onclick="goToOrder('${pageContext.request.parameterMap.lang[0]}')"><fmt:message key="checkOut"/></button>
        <%}
        }%>

    </div>

    <div id="menu">
        <div id = "catalogue" >
            <input type="button" class="catal" value="<fmt:message key="catalog"/>" onclick="setAttr1('filter','all')"/>
        </div>

        <div id = "instruments">
            <ul class="dropdown">
                <li class="dropdown-top">
                    <input type="button" class="menuType" onclick=setAttr1('filter','string') value="<fmt:message key="string"/>"/>

                    <ul class="dropdown-inside">
                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','guitar') value="<fmt:message key="guitars"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','violin') value="<fmt:message key="violins"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','cello') value="<fmt:message key="cellos"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','piano') value="<fmt:message key="pianos"/>"/>
                        </li>
                    </ul>
                </li>

                <li class="dropdown-top">
                    <input type="button" class="menuType" onclick=setAttr1('filter','wind') value="<fmt:message key="wind"/>"/>

                    <ul class="dropdown-inside">

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','sax') value="<fmt:message key="sax"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','flute') value="<fmt:message key="flutes"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','pipe') value="<fmt:message key="pipes"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','clarinet') value="<fmt:message key="clarinets"/>"/>
                        </li>
                    </ul>
                </li>

                <li class="dropdown-top">
                    <input type="button" class="menuType" onclick=setAttr1('filter','keyboard') value="<fmt:message key="keyboards"/>"/>

                    <ul class="dropdown-inside">

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','synthesizer') value="<fmt:message key="synthesizers"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','accordion') value="<fmt:message key="accordions"/>"/>
                        </li>

                        <li><input type="button" class="menuSubtype" onclick=setAttr1('filter','bayan') value="<fmt:message key="bayans"/>"/>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div class = "content"  id = "content1">
                <c:forEach items="${container.ids}" var="id">
                    <div class = "model1">
                        <input type = image class = "imageInMiniPage1" src="/resources/images/${id}MainImage.jpg"
                               onclick="goToDescription(${id},'${pageContext.request.parameterMap.lang[0]}')"/>

                        <p class = "nameInMiniPage1"><fmt:message key="${id}name"/></p>

                        <p class = "inYourBucket"><fmt:message key="inYourBucket"/> ${container.getAmount(id)} <fmt:message key="psc"/></p>
                        <p class = "descriptionInMiniPage1"><fmt:message key="${id}description"/></p>
                    </div>
                </c:forEach>
        <div class = "allInstruments">
            ${container.clearFullCost()}
            <c:forEach items="${container.ids}" var="id">
                <p class = "textOfAllInstruments">
                    <fmt:message key="${id}name"/><br><br>
                    <fmt:message key="${id}price"/> x ${container.getAmount(id)} <fmt:message key = "psc"/> = ${m: multi(container.getAmount(id),container.getPrice((id)))}
                    <hr>
                ${container.addToFullCost(container.getAmount(id),container.getPrice((id)))}
                </p>
            </c:forEach>
            <p class = "textOfAllInstruments"><fmt:message key="fullCost"/>: ${container.fullCost}</p>
            <hr>
            <form action="/BucketServlet" method="post">
                <button type = "submit" class = "cleanBucket" name="del" value="del"><fmt:message key="clear"/></button>
            </form>
            <button class ="cleanBucket" onclick="
                    <%if (session.getAttribute("user") == null){%>
                        goToAuth('${pageContext.request.parameterMap.lang[0]}')
                    <%}
                    else{
                        if (!container.isEmpty()){%>
                            goToOrder('${pageContext.request.parameterMap.lang[0]}')
                       <%}
                        else{

                        }
                     }%>
                    "><fmt:message key="checkOut"/></button>

        </div>

    </div>

    <div id="footer" >

    </div>
</div>
<!--<form action="InstrumentDetailsServlet" method="get">
    <input type = image src = "resources/CSS/">
</form>-->
</body>
</html>