<%--
  Created by IntelliJ IDEA.
  User: Lesha
  Date: 24.03.2018
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/1FrontController" method="get">
        <input type="hidden" name="command" value="signin">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="text" name="password">

        <input type="submit" value="Sign In">
    </form>

</body>
</html>
