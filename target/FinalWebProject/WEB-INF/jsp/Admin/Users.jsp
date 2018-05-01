<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="admin"/>
<html>
<head>
    <style>
        .thead-default {
            background-color: #323232 !important;
            color: white !important;
        }
    </style>
    <title>Title</title>
</head>
<body>
<jsp:include page="/Admin/adminBP.jsp"></jsp:include>

<form action="/FrontController" method="post">
    <input type="hidden" name="command" value="showUsers">
    <input type="submit" class="btn btn-primary" value=
    <fmt:message key="admin.user.button"/> style="margin-left: 150px">
    <img src="https://icon-icons.com/icons2/247/PNG/512/REFRESH2_26887.png" width="30px" height="30px"/>

</form>

<div id="ordersBody">
    <table class="table table-striped table-bordered table-condensed" style="margin-left: 30px; width: 1540px">
        <thead class="thead-default">
        <tr>
            <th><fmt:message key="admin.user.Fname"/> </th>
            <th><fmt:message key="admin.user.Lname"/></th>
            <th><fmt:message key="admin.user.patr"/></th>
            <th>Email</th>
            <th><fmt:message key="admin.user.phone"/></th>
            <th><fmt:message key="admin.user.result.math"/></th>
            <th><fmt:message key="admin.user.result.phys"/></th>
            <th><fmt:message key="admin.user.result.lang"/></th>
            <th><fmt:message key="admin.user.result.cert"/></th>
            <th><fmt:message key="admin.user.role"/></th>
            <c:forEach items="${userList}" var="user">
        </tr>
        </thead>
        <tr>

            <td>${user.first_name}</td>
            <td>${user.last_name}</td>
            <td>${user.patronymic}</td>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.mathResult}</td>
            <td>${user.physResult}</td>
            <td>${user.langResult}</td>
            <td>${user.sertResult}</td>
            <td>${user.role}</td>


        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>