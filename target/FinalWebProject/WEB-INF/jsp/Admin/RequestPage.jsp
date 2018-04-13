<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="admin" />
<html>
<head>
    <title>Title</title>
    <style>

        .thead-default{
            background-color: #323232 !important;
            color: white !important;
        }

    </style>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="/Admin/adminBP.jsp"></jsp:include>

<form action="/FrontController" method="post">
    <input type="hidden" name="command" value="getRequests" >
    <input type="submit" class="btn btn-primary"  style="margin-left: 150px" value=<fmt:message key="admin.button.update"/>>
    <img src="https://icon-icons.com/icons2/247/PNG/512/REFRESH2_26887.png" width="30px" height="30px"/>
</form>
<div id="ordersBody">
    <table class="table table-striped" style="margin-left: 30px; width: 1540px">
        <thead class="thead-default">
        <tr>
            <th><fmt:message key="admin.request.FIO"/></th>
            <th><fmt:message key="admin.M"/></th>
            <th><fmt:message key="admin.Ph"/></th>
            <th><fmt:message key="admin.L"/></th>
            <th><fmt:message key="admin.C"/></th>
            <th><fmt:message key="admin.request.FacSpec"/></th>
            <th><fmt:message key="admin.status"/></th>
            <c:forEach items="${requests}" var="resultME">
        </tr>
        </thead>
        <tr>

            <td>${resultME.FIO}</td>
            <td>${resultME.mathResult}</td>
            <td>${resultME.physResult}</td>
            <td>${resultME.langResult}</td>
            <td>${resultME.sertResult}</td>
            <td>${resultME.facSpec}</td>
            <td>${resultME.status}</td>

        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<form action="FrontController" method="get">
    <input type="hidden" name="command" value="approvedRequests">
    <input type="submit" value=<fmt:message key="admin.button.accept"/> class="btn btn-primary" style="margin-left: 150px">
</form>
</body>
</html>
