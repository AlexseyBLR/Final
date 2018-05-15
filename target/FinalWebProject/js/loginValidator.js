function validateLogination() {

    var emailField = document.forms["login_form"]["email"].value;
    var passwordField = document.forms["login_form"]["password"].value;

    var countOfErrors = 0;

    var emailRegExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    var passwordRegExp = /^[A-Za-z0-9]{5,}[^!@#$%^&*]/;


    //////////////////////////////////email

    if (!emailRegExp.test(emailField)) {
        document.getElementById('email_error').innerHTML = "* wrong email";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('email_error').innerHTML = "";
    }

    //////////////////////////////////password

    if (!passwordRegExp.test(passwordField) || passwordField.length < 6) {
        document.getElementById('password_error').innerHTML = "* password must have at least six symbols,\n" +
            "at least  one number and at least one special character ";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('password_error').innerHTML = "";
    }

    return countOfErrors == 0;
}
