<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.LinkedHashMap" %><%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 17.10.2016
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InstrumentMini</title>
    <%@ taglib prefix="m" uri="/WEB-INF/tld/m.tld"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
    <div class = "model">
        <input type = image class = "imageInMiniPage" src="/resources/images/<jsp:getProperty name="instrumentBean" property="id"/>MainImage.jpg"
        onclick=goToDescription(<jsp:getProperty name="instrumentBean" property="id"/>)>

        <p class = "nameInMiniPage"><jsp:getProperty name="instrumentBean" property="name"/></p>
        <p class = "descriptionInMiniPage"><jsp:getProperty name="instrumentBean" property="description"/></p>

            <p class = "priceInMiniPage">
                <jsp:getProperty name="instrumentBean" property="price"/>
            </p>
            <input type="number"
                   id = "amount<jsp:getProperty name="instrumentBean" property="id"/>"
                   class="amountOfInstrumentsInBucket"
                   name="amountToBucket"
                   title="<%=resourceBundle.getString("goToBucket")%>"
                   value="0"
                   min = "0">
            <input type="button"
                   class = "buyInMiniPage"
                   name="<jsp:getProperty name="instrumentBean" property="id"/>"
                   title="<%=resourceBundle.getString("addToBucket")%>"
                   onclick= "addToBucket(<jsp:getProperty
                       name="instrumentBean"
                       property="id"/>);"/>

        <form action="BucketServlet" method="get">
            <input type = "submit"
                   class = "forwardToBucket"
                   value="<%=resourceBundle.getString("buy")%>">
        </form>


    </div>
</body>
</html>
