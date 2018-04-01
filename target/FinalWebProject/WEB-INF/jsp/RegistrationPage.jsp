<!DOCTYPE html>
<html>
<head>


    <meta charset="utf-8">
    <title>Bootstrap уроки</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<jsp:include page="BasePages/basePage.jsp"></jsp:include>
<div class="registration_container border rounded" style="width: 510px; margin: 0 auto;  padding: 10px;" >
    <div class="container">
        <form class="form-horizontal" role="form" action="/frontControllerReg" method="get" name="registration_form" >
            <input type="hidden" name="command" value="registration">
            <h2 style="margin-left: 50px">Registration</h2>
            <div class="form-group form-inline">
                <label for="name" class="col-sm-3 control-label">First Name</label>
                <div class="col-sm-9">
                    <input type="text" id="name"  class="form-control"  name="firstName">
                </div>
                <p id = "first_name_error" style="color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="sureName" class="col-sm-3 control-label">Last name</label>
                <div class="col-sm-9">
                    <input type="text" id="sureName"  class="form-control"  name="lastName">
                </div>
                <p id = "last_name_error" style="color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="patronymic" class="col-sm-3 control-label">Patronymic</label>
                <div class="col-sm-9">
                    <input type="text" id="patronymic"  class="form-control"  name="patronymic">
                </div>
                <p id = "patronymic_error" style="color: red"></p>
            </div>


            <div class="form-group form-inline">
                <label for="phone" class="col-sm-3 control-label">Phone number</label>
                <div class="col-sm-9">
                    <input type="text" id="phone"  class="form-control" name="phone">
                </div>
                <p id = "phone_error" style="color: red"></p>
            </div>



            <div class="form-group form-inline">
                <label for="email" class="col-sm-3 control-label">Email</label>
                <div class="col-sm-9">
                    <input type="email" id="email" placeholder="Email" class="form-control" name="email">
                </div>
                <p id = "email_error" style="color: red"></p>
            </div>


            <div class="form-group form-inline">
                <label for="password" class="col-sm-3 control-label">Password</label>
                <div class="col-sm-9">
                    <input type="password" id="password" placeholder="Password" class="form-control" name="password">
                </div>
                <p id = "password_error" style="color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="math" class="col-sm-3 control-label">Math Result</label>
                <div class="col-sm-9">
                    <input type="text" id="math"  class="form-control" autofocus name="mathResult">
                </div>
                <p id = "math_error" style="color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="phys" class="col-sm-3 control-label">Physic Result</label>
                <div class="col-sm-9">
                    <input type="text" id="phys"  class="form-control" autofocus name="physResult">
                </div>
                <p id = "phys_error" style="color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="lang" class="col-sm-3 control-label">Language Result</label>
                <div class="col-sm-9">
                    <input type="text" id="lang"  class="form-control" autofocus name="langResult">
                </div>
                <p id = "lang_error" style="color: red"></p>
            </div>

            <div class="form-group form-inline">
                <label for="sert" class="col-sm-3 control-label">Certificate Result</label>
                <div class="col-sm-9">
                    <input type="text" id="sert"  class="form-control" autofocus name="sertResult">
                </div>
                <p id = "sert_error" style="color: red"></p>
            </div>




            <input class="btn btn-primary" style="margin-top: 30px; margin-left: 100px" type="submit" value="To register">
        </form>
    </div>

</div>

</body>
</html>