<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Locale" %>
<%@ page import="static workWithServletes.arrayFromStringToArray.*" %>
<%@ page import="static JSTL.Utils.StringtoArrayListString" %>
<%@ page import="static JSTL.Utils.StringtoArrayListInteger" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="m" uri="/WEB-INF/tld/m.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Bucket</title>
    <link rel="stylesheet" type="text/css" href="/resources/CSS/style.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/CSS/styleOrder.css"/>
    <script type="text/javascript" src="/resources/JS/JavaScriptic.js"></script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDUybwygBuLPhL9rcuoLBurnOFtK87Y0qk">
    </script>
    <jsp:useBean id="container" scope="session" class="MyContainer.BucketContainer"/>
    <jsp:useBean id="order" scope="session" class="MyContainer.OrderContainer"/>
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

<%/*
    Cookie cookieLang;
    String l;
    if (request.getParameter("lang") != null){
        cookieLang = new Cookie("lang", request.getParameter("lang"));
        l = request.getParameter("lang");
    }
    else{
        Cookie [] cookies = request.getCookies();
        l = "ru";
        if (cookies != null){
            for (Cookie c: cookies){
                if (c.getName().equals("lang")){
                    l = c.getValue();
                    break;
                }
            }
        }
        session.setAttribute("lang",l);
        cookieLang = new Cookie("lang", l);
    }

    Locale locale;
    locale = new Locale(l);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("prop", locale);
    response.addCookie(cookieLang);*/%>
<%

    //String id = session.getAttribute("id_shop").toString();
    //ArrayList<Integer> ids = new ArrayList<>();
    //StringtoArrayListInteger(id,ids);
    //String lng = session.getAttribute("lat").toString();
    //String lat = session.getAttribute("lng").toString();
    //String name = session.getAttribute("name").toString();
    //ArrayList<String> names = new ArrayList<>();
    //StringtoArrayListString(name,names);
    //Integer amountOfShop = Integer.parseInt(session.getAttribute("amountOfShops").toString());
    //StringBuilder secretMessage = new StringBuilder("");
//    for (int i = 0; i < amountOfShop;i++){
//        secretMessage.append(resourceBundle.getString(ids.get(i).toString()));
//        if (i+1 != amountOfShop) secretMessage.append("; ");
//    }
%>
<body onload="initMap('${order.lng}','${order.lat}','${order.names}',${order.amount_of_shops},'${order.secretMessage}')">

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
        <%}%>

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
        <button class="courierOrShop" id="shop" onclick="changeDelivery('shop','courier')"><fmt:message key="pickUp"/></button>
        <button class="courierOrShop" id="courier" onclick="changeDelivery('courier','shop')"><fmt:message key="courier"/></button>
    <div id = "shop1" style="display:block;">
        <div id="map">
        </div>

        <div class = "adressOfShop">
            <p class = "selectText"><fmt:message key="selectShop"/></p>
            <select id = "shop3" class = "selectShop" onchange="changeShop()">

                <c:forEach items="${order.count}" var="i">
                    <option id = "${order.ids.get(i)}" class = "selectShop">${order.names_array.get(i)}</option>
                </c:forEach>

                <%----%>
                <%--<%--%>
                    <%--for (int i = 0; i < amountOfShop;i++){%>--%>
                <%--<option id = "<%=ids.get(i).toString()%>" class = "selectShop"><%=names.get(i)%></option>--%>
                <%--<% }--%>
                <%--%>--%>
            </select>

        </div>

        <div class="yourOrder">
            <p class="textOfAllInstruments"><fmt:message key="yourOrder"/></p><br>
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
            <p class = "textOfAllInstruments" id="shop2" style="display: block"><fmt:message key="pickUp"/>: </p>
            <p class = "textOfAllInstruments" id="usePickUp"></p>
            <button class = "toPay" onclick="goToRecord('${pageContext.request.parameterMap.lang[0]}')"><fmt:message key="toPay"/></button>
        </div>
    </div>

    <div id="courier1" style = "display: none;">
        <p class="enterAdress"><fmt:message key="enterAdress"/> </p>
        <input class = "inputAdress" id = "courier3" type="text" value=""/>
        <input type="button" class="toPay" id="submitAdress" value="<fmt:message key="ready"/>" onclick="changeAdress()"/>
        <div class="yourOrder1">
            <p class="textOfAllInstruments"><fmt:message key="yourOrder"/></p><br>
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
            <p class = "textOfAllInstruments" id="courier2"><fmt:message key="courier"/>: </p>
            <p class = "textOfAllInstruments" id="useCourier"></p>
            <button class = "toPay" onclick="goToRecord('${pageContext.request.parameterMap.lang[0]}')"><fmt:message key="toPay"/></button>
        </div>
    </div>


</div>



    <div id="footer" >

    </div>
</div>
</body>
</html>
