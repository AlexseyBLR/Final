<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="user" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request</title>
</head>
<body>

<jsp:include page="/User/UserBP.jsp"></jsp:include>
<div class="container">
    <h2><fmt:message key="user.request.selection"/></h2>
    <p><fmt:message key="user.request.selection.smal"/></p>
    <form action="FrontController" method="get">
        <select multiple class="form-control" style="width: 250px" name="command">
            <optgroup label=<fmt:message key="user.faculty.mechanical"/>>
                <option value="Exploatation"><fmt:message key="user.faculty.mechanical.exploatation"/></option>
                <option value="CarRepair"><fmt:message key="user.faculty.mechanical.repair"/></option>
            </optgroup>
            <optgroup label=<fmt:message key="user.faculty.architecture"/>>
                <option value="Building"><fmt:message key="user.faculty.architecture.building"/></option>
                <option value="Design"><fmt:message key="user.faculty.architecture.design"/></option>
            </optgroup>
        </select>
        <div style="margin-top: 15px; margin-left: 20px">


            <c:if test="${result1 eq 'Send'}">
                <input type="submit" class="btn btn-primary" value=<fmt:message key="user.request.button"/> disabled/>
            </c:if>
            <c:if test="${result1 ne 'Send'}">
                <input type="submit" class="btn btn-primary" value=<fmt:message key="user.request.button"/>/>
            </c:if>


        </div>
    </form>
</div>


</body>
</html>
