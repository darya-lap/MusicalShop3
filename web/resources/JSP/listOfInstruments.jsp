<%@ page import="org.hibernate.HibernateException" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="DB.HibernateUtil" %>
<%@ page import="ConnectToDB.InstrumentBean" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="org.hibernate.sql.ordering.antlr.Factory" %>
<%@ page import="static org.hibernate.sql.ordering.antlr.Factory.*" %>
<%@ page import="DAO.Factory1" %>
<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 16.10.2016
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Musse</title>
    <link rel="stylesheet" type="text/css" href="/resources/CSS/style.css"/>
    <script type="text/javascript" src="/resources/JS/JavaScriptic.js"></script>
    <jsp:useBean id="instrumentBean" class="ConnectToDB.InstrumentBean" scope="session"/>
    <jsp:useBean id="container" class="MyContainer.BucketContainer" scope="session"/>

    <div class = "languages">
        <input type="button" class = "lang" id = 'butEn' onclick="setAttr('lang','en')" value=""/>
        <input type="button" class = "lang" id = 'butRu' onclick="setAttr('lang','ru')" value=""/>
        <input type="button" class = "lang" id = 'butFr' onclick="setAttr('lang','fr')" value=""/>

        <%
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
            response.addCookie(cookieLang);

            Cookie cookieFilter;
            String f = "all";
            if (request.getParameter("filter") != null){
                cookieFilter = new Cookie("filter", request.getParameter("filter"));
                f = request.getParameter("filter");
            }
            else{
                Cookie [] cookies = request.getCookies();
                f = "all";
                if (cookies != null){
                    for (Cookie c: cookies){
                        if (c.getName().equals("filter")){
                            f = c.getValue();
                            break;
                        }
                    }
                }
                session.setAttribute("filter",f);
                cookieFilter = new Cookie("filter", f);
            }
            response.addCookie(cookieFilter);
        %>

    </div>
</head>

<body>
    <div id="container">
        <div id="header">
            <div id = "allshopname">
                <h1>Musse</h1>
                <h2> <%
                    out.println(resourceBundle.getString("shopName"));
                    %>

                </h2>
            </div>
        <button class = "butbucket" id="bucket" onclick="goToBucket('<%=l%>')" value="" title="<%out.println(resourceBundle.getString("goToBucket"));%>"></button>

            <button class = "login" onclick="goToAuth('<%=l%>')" title="

        <%if (session.getAttribute("user") == null){
            out.print(resourceBundle.getString("logInSystem")+"\"></button>");
         }
        else{
        out.print(resourceBundle.getString("logOutSystem"));%>
        "></button>
            <p class="userInfo"><%out.print(resourceBundle.getString("youEnterAs"));%></p>
            <a class="userInfo1" href="myAccount.jsp?lang=<%=l%>" title="<%out.print(resourceBundle.getString("goToAccount"));%>"><%=session.getAttribute("user")%></a>
            <%if (!container.isEmpty()){%>
            <button class="goToOrder" onclick="goToOrder('${pageContext.request.parameterMap.lang[0]}')"><%out.print(resourceBundle.getString("checkOut"));%></button>
            <%}
            }%>

        </div>

        <div id="menu">
            <div id = "catalogue" >
                <input type="button" class="catal" value="<%out.print(resourceBundle.getString("catalog"));%>" onclick="setAttr('filter','all')"/>
            </div>

            <div id = "instruments">
                <ul class="dropdown">
                    <li class="dropdown-top">
                        <input type="button" class="menuType" onclick="setAttr('filter','string')" value="<%
                                    out.println(resourceBundle.getString("string"));
                                %>"/>

                        <ul class="dropdown-inside">
                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','guitar')" value="<%
                                    out.println(resourceBundle.getString("guitars"));
                                %>"/>
                            </li>

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','violin')" value="<%
                                    out.println(resourceBundle.getString("violins"));
                                %>"/>
                            </li>

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','cello')" value="<%
                                    out.println(resourceBundle.getString("cellos"));
                                %>"/>
                            </li>

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','piano')" value="<%
                                    out.println(resourceBundle.getString("pianos"));
                                %>"/>
                            </li>
                        </ul>
                    </li>

                    <li class="dropdown-top">
                        <input type="button" class="menuType" onclick="setAttr('filter','wind')" value="<%
                                    out.println(resourceBundle.getString("wind"));
                                %>"/>

                        <ul class="dropdown-inside">

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','sax')" value="<%
                                    out.println(resourceBundle.getString("sax"));
                                %>"/>
                            </li>

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','flute')" value="<%
                                    out.println(resourceBundle.getString("flutes"));
                                %>"/>
                            </li>

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','pipe')" value="<%
                                    out.println(resourceBundle.getString("pipes"));
                                %>"/>
                            </li>

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','clarinet')" value="<%
                                    out.println(resourceBundle.getString("clarinets"));
                                %>"/>
                            </li>
                        </ul>
                    </li>

                    <li class="dropdown-top">
                        <input type="button" class="menuType" onclick="setAttr('filter','keyboard')" value="<%
                                    out.println(resourceBundle.getString("keyboards"));
                                %>"/>

                        <ul class="dropdown-inside">

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','synthesizer')" value="<%
                                    out.println(resourceBundle.getString("synthesizers"));
                                %>"/>
                            </li>

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','accordion')" value="<%
                                    out.println(resourceBundle.getString("accordions"));
                                %>"/>
                            </li>

                            <li><input type="button" class="menuSubtype" onclick="setAttr('filter','bayan')" value="<%
                                    out.println(resourceBundle.getString("bayans"));
                                %>"/>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>

        <div class = "content"  id = "content1">
            <%
            List list = Factory1.getInstance().getInstrumentDAO().getAllInstruments();
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                InstrumentBean cur = (InstrumentBean) iterator.next();
                String name = cur.getId() + "name";
                String description = cur.getId() + "description";
            %>
                <jsp:setProperty name="instrumentBean" property="id" value="<%=cur.getId()%>"/>
                <jsp:setProperty name="instrumentBean" property="type" value="<%=cur.getType()%>"/>
                <jsp:setProperty name="instrumentBean" property="subtype" value="<%=cur.getSubtype()%>"/>
                <jsp:setProperty name="instrumentBean" property="price" value="<%=cur.getPrice()%>"/>
                <jsp:setProperty name="instrumentBean" property="name" value="<%=resourceBundle.getString(name)%>"/>
                <jsp:setProperty name="instrumentBean" property="description" value="<%=resourceBundle.getString(description)%>"/>

                <%if (f.equals("all")){%>
                    <%@include file="miniInstrumentsPage.jsp"%>
                <%}
                else{
                    if ((cur.getType().equals(f)) || (cur.getSubtype().equals(f))){%>
                         <%@include file="miniInstrumentsPage.jsp"%>
                    <%}
                }
            }
            %>

        </div>

        <div id="footer" >

        </div>
    </div>
<!--<form action="InstrumentDetailsServlet" method="get">
    <input type = image src = "resources/CSS/profilemini.jpg">
</form>-->

</body>
</html>
