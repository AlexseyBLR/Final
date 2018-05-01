<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="user" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap уроки</title>
    <link href="https://fonts.googleapis.com/css?family=Acme" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
    <style>

        .navbar-inverse .navbar-nav > li > a {
            color: white !important;
        }

        .navbar-inverse .navbar-nav > li > a:hover,
        .navbar-inverse .navbar-nav > li > a:focus {
            color: #a09f9f !important;
        }

        body {
            background-color: rgba(165, 163, 255, 0.15) !important;
        }

        .faculty {
            font-family: 'Oswald', Serif;
            font-size: 20px;
            margin-bottom: 10px;
            margin-top: 10px;
        }

        .container-fluid {
            background-image: linear-gradient(#313131, #4b4b4b);
        }

        .navbar-inverse {
            margin-left: -3px;
            width: 1610px;
            height: 70px;
        }

        .navbar-brand {
            font-family: 'Acme', Serif;
            margin: 10px;
            tansition: all .3s linear;
            -webkit-transition: all .3s linear;
            -moz-transition: all .3s linear;
            text-transform: uppercase;
        }

        .dropdown-toggle {
            margin-left: 20px;
            margin-top: 11px;
            font-size: 20px;
            font-family: 'Oswald', Serif;
            tansition: all .3s linear;
            -webkit-transition: all .3s linear;
            -moz-transition: all .3s linear;
            text-transform: uppercase;
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


<form class="navbar navbar-inverse ">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" style="font-size: 30px; margin-right: 50px; margin-left: 1px" href="/home">UNIVERSITY</a>
        </div>
        <div class="collapse navbar-collapse js-navbar">
            <ul class="nav navbar-nav">

                <li class="dropdown-toggle"><a href="/home"><fmt:message key="user.main"/></a></li>


                <li class="dropdown">
                    <a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <fmt:message key="user.faculty"/>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">

                        <!--ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc-->
                        <li><a href="#" class="faculty"><fmt:message key="user.faculty.mechanical"/></a></li>
                        <li><a href="#" class="faculty"><fmt:message key="user.faculty.architecture"/></a></li>
                        <li><a href="#" class="faculty"><fmt:message key="user.faculty.Science"/></a></li>
                    </ul>
                </li>

            </ul>
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a id="language" href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <fmt:message key="user.request"/>
                        <span class="caret"></span>
                    </a>
                        <ul class="dropdown-menu" style="width: 200px">
                            <li><a href="/request" class="faculty"><fmt:message key="user.request.button"/></a></li>
                            <hr size=3px width=500px align="left">
                            <li><a href="/result" class="faculty"><fmt:message key="user.result.button"/></a></li>
                        </ul>
                </li>
            </ul>


            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a id="language" href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <fmt:message key="user.language"/>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <a style="margin-right: 30px;margin-left: 20px; font-size: 20px" class="dropdown-item" href="${requestScope.requestURI}?language=en"><fmt:message key="user.language.en"/></a>
                        <a style="font-size: 20px" class="dropdown-item" href="${requestScope.requestURI}?language=ru"><fmt:message key="user.language.ru"/></a>

                    </ul>
                </li>
                <li class="dropdown">
                    <a id="drop2" href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <fmt:message key="user.signout"/>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" style="width: 150px">
                        <form method="get" action="FrontController">
                            <input type="hidden" name="command" value="logination">
                        </form>
                        <h5 style="margin-left: 20px">${userFIO}</h5>
                        <form action="FrontController" method="post">
                            <input type="hidden" name="command" value="logout">
                            <input type="submit" class="btn btn-primary" style="margin-left: 40px"
                                   value=<fmt:message key="user.signout"/>>
                        </form>
                    </ul>
                </li>
                <\ n>
            </ul>
        </div>

    </div>

</form>






</body>
</html>