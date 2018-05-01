<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="user" />
<html>
<head>

    <script src="/js/validator.js" type="text/javascript"></script>
    <title>Update</title>
</head>
<body>

<jsp:include page="/User/UserBP.jsp"></jsp:include>
<div onsubmit="validateForm()" class="registration_container border rounded" style="width: 510px; margin: 0 auto;  padding: 10px;">
    <div class="container">
        <h1><fmt:message key="user.update.message"/> </h1>
        <form class="form-horizontal" role="form" action="/frontControllerReg"
              method="post" name="registration_form">
            <input type="hidden" name="command" value="updateInfo">
            <div class="form-group form-inline">
                <label for="firstName" class="col-sm-3 control-label"><fmt:message key="user.update.Fname"/> </label>
                <div class="col-sm-9">
                    <input type="text" id="firstName" class="form-control" autofocus name="firstName">
                </div>
                <div style="margin-left: 220px">
                    <p id="name_error" style="font-size: 12px; color: red"></p>
                </div>
            </div>

            <div class="form-group form-inline">
                <label for="lastName" class="col-sm-3 control-label"><fmt:message key="user.update.Lname"/></label>
                <div class="col-sm-9">
                    <input type="text" id="lastName" class="form-control" autofocus name="lastName">
                </div>
                <div style="margin-left: 220px">
                    <p id="second_name_error" style="font-size: 12px; color: red"></p>
                </div>
            </div>

            <div class="form-group form-inline">
                <label for="patronymic" class="col-sm-3 control-label"><fmt:message key="user.update.Patr"/></label>
                <div class="col-sm-9">
                    <input type="text" id="patronymic" class="form-control" autofocus name="patronymic">
                </div>
                <div style="margin-left: 220px">
                    <p id="patronymic_error" style="font-size: 12px; color: red"></p>
                </div>
            </div>


            <div class="form-group form-inline">
                <label for="math" class="col-sm-3 control-label"><fmt:message key="user.update.Mresult"/></label>
                <div class="col-sm-9">
                    <input type="text" id="math" class="form-control" autofocus name="math">
                </div>
                <div style="margin-left: 220px">
                    <p id="math_error" style="font-size: 12px; color: red"></p>
                </div>
            </div>

            <div class="form-group form-inline">
                <label for="phys" class="col-sm-3 control-label"><fmt:message key="user.update.Presult"/></label>
                <div class="col-sm-9">
                    <input type="text" id="phys" class="form-control" autofocus name="phys">
                </div>
                <div style="margin-left: 220px">
                    <p id="phys_error" style="font-size: 12px; color: red"></p>
                </div>
            </div>

            <div class="form-group form-inline">
                <label for="lang" class="col-sm-3 control-label"><fmt:message key="user.update.Lresult"/></label>
                <div class="col-sm-9">
                    <input type="text" id="lang" class="form-control" autofocus name="lang">
                </div>
                <div style="margin-left: 220px">
                    <p id="lang_error" style="font-size: 12px; color: red"></p>
                </div>
            </div>

            <div class="form-group form-inline">
                <label for="sert" class="col-sm-3 control-label"><fmt:message key="user.update.Sresult"/></label>
                <div class="col-sm-9">
                    <input type="text" id="sert" class="form-control" autofocus name="sert">
                </div>
                <div style="margin-left: 220px">
                    <p id="sert_error" style="font-size: 12px; color: red"></p>
                </div>
            </div>

            <input class="btn btn-primary" style="margin-top: 30px; margin-left: 100px" type="submit" value=
                    <fmt:message key="user.update.button"/>/>
        </form>
    </div>
</div>


</body>
</html>
