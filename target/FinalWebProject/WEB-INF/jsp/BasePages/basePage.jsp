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

        .margin {
            margin-left: 10px;
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
            <a class="navbar-brand" style="font-size: 30px; margin-right: 50px; margin-left: 1px"
               href="index.jsp">UNIVERSITY</a>
        </div>
        <div class="collapse navbar-collapse js-navbar">
            <ul class="nav navbar-nav">

                <li class="dropdown-toggle"><a href="index.html">Main</a></li>


                </li>
                <li class="dropdown">
                    <a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Faculties
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">

                        <!--ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc-->
                        <li><a href="#" class="faculty">Mechanical</a></li>
                        <li><a href="#" class="faculty">Architecture</a></li>
                        <li><a href="#" class="faculty">Computer science</a></li>
                    </ul>
                </li>


            </ul>


            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a id="language" href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Language
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" style="width: 10px">
                        <li><input type="submit" class="btn btn-primary" style="margin: 10px" value="Ru"></li>
                        <li><input type="submit" class="btn btn-primary" style="margin: 10px" value="En"></li>

                    </ul>
                </li>
                <li class="dropdown">
                    <a id="drop2" href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Sign In
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" style="width: 220px">
                        <form method="get" action="/FrontControllerLogIn">
                            <input type="hidden" name="command" value="logination">
                            <div class="form-group">
                                <label for="email" class="margin">Email</label>
                                <input type="text" id="email" name="Username" class="form-control"
                                       style="width: auto; margin-left: 10px"
                                       placeholder="email"/>
                            </div>
                            <div class="form-group">
                                <label for="password" class="margin">Password</label>
                                <input type="password" id="password" name="Username" class="form-control"
                                       style="width: auto; margin-left: 10px"
                                       placeholder="password">
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" style="margin-left: 10px" value="LogIn">
                            </div>
                        </form>
                        <form action="FrontController" method="get">
                            <input type="hidden" name="command" value="goToRegistration">
                            <input type="submit" class="btn btn-primary" style="margin-left: 55px" value="Registration"/>
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