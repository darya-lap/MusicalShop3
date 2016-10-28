<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.LinkedHashMap" %><%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 17.10.2016
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="m" uri="/WEB-INF/tld/m.tld"%>
<html>
<head>
    <title>InstrumentMini</title>
</head>
<body>
    <div class = "model">
        <%
            BucketContainer bucketContainer = new BucketContainer();
        %>
            <input type = image class = "imageInMiniPage" src="/resources/images/<jsp:getProperty name="instrumentBean" property="id"/>MainImage.jpg"
            onclick=goToDescription(<jsp:getProperty name="instrumentBean" property="id"/>)>
            <p class = "nameInMiniPage"><jsp:getProperty name="instrumentBean" property="name"/></p>
            <p class = "descriptionInMiniPage"><jsp:getProperty name="instrumentBean" property="description"/></p>
            <button class = "buyInMiniPage" title="<%=resourceBundle.getString("addToBucket")%>" onclick= "addToBucket(<jsp:getProperty name="instrumentBean" property="id"/>);"></button>
            <input type="number" id = "amount<jsp:getProperty name="instrumentBean" property="id"/>" class="amountOfInstrumentsInBucket"
                      value="0"
                      prevval = "0" min = "0">
            <p class = "priceInMiniPage"><jsp:getProperty name="instrumentBean" property="price"/></p>
            <input type = "button" class = "forwardToBucket" value="<%=resourceBundle.getString("buy")%>" onclick=goToBucket()>
    </div>
</body>
</html>
