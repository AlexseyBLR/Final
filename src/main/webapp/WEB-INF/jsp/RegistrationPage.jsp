<%@page contentType='text/html;charset=UTF-8' %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="local" />

<!DOCTYPE html>
<html>
<head>
    <script src="/js/formValidator.js" type="text/javascript"></script>


    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/BasePages/RegBP.jsp"></jsp:include>
<div class="registration_container border rounded" style="width: 510px; margin: 0 auto;  padding: 10px;" >
    <div class="container">
        <form onsubmit="if(validateFormOnRegistration()) return true; else return false;"  class="form-horizontal" role="form" action="/frontControllerReg" method="post" name="registration_form" >
            <input type="hidden" name="command" value="registration">
            <h4><fmt:message key="local.reg.small"/> </h4>
            <h2 style="margin-left: 50px"><fmt:message key="local.button.registration"/> </h2>
            <div class="form-group form-inline">
                <label for="firstName" class="col-sm-3 control-label"><fmt:message key="local.name"/> </label>
                <div class="col-sm-9">
                    <input type="text" id="firstName"  class="form-control" autofocus  name="firstName">
                </div>
                <p id = "name_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="lastName" class="col-sm-3 control-label"><fmt:message key="local.last_name"/></label>
                <div class="col-sm-9">
                    <input type="text" id="lastName"  class="form-control"  autofocus name="lastName">
                </div>
                <p id = "second_name_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="patronymic" class="col-sm-3 control-label"><fmt:message key="local.patronymic"/></label>
                <div class="col-sm-9">
                    <input type="text" id="patronymic"  class="form-control" autofocus  name="patronymic">
                </div>
                <p id = "patronymic_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>


            <div class="form-group form-inline">
                <label for="phone" class="col-sm-3 control-label"><fmt:message key="local.phone"/></label>
                <div class="col-sm-9">
                    <input type="text" id="phone"  class="form-control" autofocus name="phone">
                </div>
                <p id = "phone_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>



            <div class="form-group form-inline">
                <label for="email" class="col-sm-3 control-label">Email</label>
                <div class="col-sm-9">
                    <input type="email" id="email" placeholder="Email" class="form-control" autofocus name="email">
                </div>
                <p id = "email_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>


            <div class="form-group form-inline">
                <label for="password" class="col-sm-3 control-label"><fmt:message key="local.password"/></label>
                <div class="col-sm-9">
                    <input type="password" id="password" placeholder="Password" class="form-control" autofocus name="password">
                </div>
                <p id = "password_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="math" class="col-sm-3 control-label"><fmt:message key="local.mRes"/></label>
                <div class="col-sm-9">
                    <input type="text" id="math"  class="form-control" autofocus name="math">
                </div>
                <p id = "math_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="phys" class="col-sm-3 control-label"><fmt:message key="local.phRes"/></label>
                <div class="col-sm-9">
                    <input type="text" id="phys"  class="form-control" autofocus name="phys">
                </div>
                <p id = "phys_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="lang" class="col-sm-3 control-label"><fmt:message key="local.lRes"/></label>
                <div class="col-sm-9">
                    <input type="text" id="lang"  class="form-control" autofocus name="lang">
                </div>
                <p id = "lang_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="sert" class="col-sm-3 control-label"><fmt:message key="local.sRes"/></label>
                <div class="col-sm-9">
                    <input type="text" id="sert"  class="form-control" autofocus name="sert">
                </div>
                <p id = "sert_error" style="margin-left: 250px; font-size: 13px; color: red"></p>
            </div>


            <input class="btn btn-primary" style="margin-top: 30px; margin-left: 100px" type="submit" value=<fmt:message key="local.toRegister"/> />
        </form>
    </div>

</div>

</body>
</html>