<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
    <c:set var="language"
    value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
    scope="session"/>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
        <fmt:message  key="login.label.password" var="13"/>
        <fmt:message  key="login.label.username" var="14"/>
        <fmt:message  key="login.button.submit" var="12"/>
    <title>JSP/JSTL i18n demo</title>

</head>
<body>

<form method="post" action="/FrontController">
    <input type="hidden" name="local" value="ru">
    <input type="submit" name="submit" value="${12}"/>
</form>
<form method="post" action="/FrontController">
    <input type="hidden" name="local" value="en">
    <input type="submit" value="${13}"/>
</form>

<c:out value="${14}"/>

</body>
</html>