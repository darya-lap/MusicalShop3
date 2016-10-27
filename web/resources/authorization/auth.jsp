<%--
  Created by IntelliJ IDEA.
  User: Дарья
  Date: 22.10.2016
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>I'm autorization page</p>
<form action="j_security_check" method="post" name="loginForm">
    <input type="text" name="j_username" placeholder="имя"
           size="20"/><br>
    <label><fmt:message key="txtPassword" /></label><br>
    <input type="password" name="j_password" size="20"/><br>
    <input type="submit" value="Ввод"/>
</form>
</body>
</html>
