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

<form action="FrontController" method="post">
    <input type="hidden" name="command" value="showResult">
    <input type="submit" class="btn btn-primary" value=
    <fmt:message key="admin.button.show"/> style="margin-left: 150px">
    <img src="https://icon-icons.com/icons2/247/PNG/512/REFRESH2_26887.png" width="30px" height="30px"/>

</form>

<div id="ordersBody">
    <table class="table table-striped table-bordered table-condensed" style="margin-left: 30px; width: 1540px">
        <thead class="thead-default">
        <tr>
            <th><fmt:message key="admin.request.FIO"/></th>
            <th><fmt:message key="admin.request.FacSpec"/></th>
            <c:forEach items="${resultME}" var="resultME">
        </tr>
        </thead>
        <tr>

            <td>${resultME.FIO}</td>
            <td>${resultME.facSpec}</td>

        </tr>
        </c:forEach>
        </tbody>


        <thead class="thead-default">
        <tr>
            <th><fmt:message key="admin.request.FIO"/></th>
            <th><fmt:message key="admin.request.FacSpec"/></th>
            <c:forEach items="${resultMR}" var="resultMR">
        </tr>
        </thead>
        <tr>

            <td>${resultMR.FIO}</td>
            <td>${resultMR.facSpec}</td>

        </tr>
        </c:forEach>
        </tbody>


        <thead class="thead-default">
        <tr>
            <th><fmt:message key="admin.request.FIO"/></th>
            <th><fmt:message key="admin.request.FacSpec"/></th>
            <c:forEach items="${resultAB}" var="resultAB">
        </tr>
        </thead>
        <tr>

            <td>${resultAB.FIO}</td>
            <td>${resultAB.facSpec}</td>

        </tr>
        </c:forEach>
        </tbody>


        <thead class="thead-default">
        <tr>
            <th><fmt:message key="admin.request.FIO"/></th>
            <th><fmt:message key="admin.request.FacSpec"/></th>
            <c:forEach items="${resultAD}" var="resultAD">
        </tr>
        </thead>
        <tr>

            <td>${resultAD.FIO}</td>
            <td>${resultAD.facSpec}</td>

        </tr>
        </c:forEach>
        </tbody>
    </table>


</div>


</body>
</html>
