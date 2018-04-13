function validateForm() {
    var nameField = document.forms["registration_form"]["firstName"].value;
    var sureNameField = document.forms["registration_form"]["lastName"].value;
    var patronymicField = document.forms["registration_form"]["patronymic"].value;
    var emailField = document.forms["registration_form"]["email"].value;
    var passwordField = document.forms["registration_form"]["password"].value;
    var phoneField = document.forms["registration_form"]["phone"].value;
    var mathField = document.forms["registration_form"]["math"].value;
    var physField = document.forms["registration_form"]["phys"].value;
    var langField = document.forms["registration_form"]["lang"].value;
    var sertField = document.forms["registration_form"]["sert"].value;

    var countOfErrors = 0;

    var resultRegExp = /^^\d{1,2}|100$/;

    var nameRegExp = /^[a-zA-Z ]{2,30}$/;

    var passwordRegExp = /^[A-Za-z0-9]{5,}[^!@#$%^&*]/;

    var emailRegExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    var phoneRegExp = /^\+[1-9]{1}[0-9]{11}/;

    //////////////////////////////////patronymic

    if (patronymicField == "" || patronymicField.length < 5) {
        document.getElementById('patronymic_error').innerHTML = "* this field should have at least one symbol and size not lower then 5 ";
        countOfErrors = countOfErrors + 1;

    } else {
        document.getElementById('patronymic_error').innerHTML = "";
    }

    if (!nameRegExp.test(patronymicField)) {
        document.getElementById('patronymic_error').innerHTML = "* this field should not have start with  '_' symbol and " +
            "include numbers";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('patronymic_error').innerHTML = "";
    }

    //////////////////////////////////first name

    if (nameField == "" || nameField.length < 5) {
        document.getElementById('name_error').innerHTML = "* name should have at least one symbol and size not lower then 5 ";
        countOfErrors = countOfErrors + 1;

    } else {
        document.getElementById('name_error').innerHTML = "";
    }

    if (!nameRegExp.test(nameField)) {
        document.getElementById('name_error').innerHTML = "* name should not have start with  '_' symbol and " +
            "include numbers";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('name_error').innerHTML = "";
    }

    //////////////////////////////////last name

    if (sureNameField == "" || sureNameField.length < 5) {
        document.getElementById('second_name_error').innerHTML = "* Second name should have at least one symbol and size not lower then 5 ";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('second_name_error').innerHTML = "";
    }

    if (!nameRegExp.test(sureNameField)) {
        document.getElementById('second_name_error').innerHTML = "* Second name should not have start with  '_' symbol and " +
            "include numbers";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('second_name_error').innerHTML = "";
    }

    //////////////////////////////////password

    if (!passwordRegExp.test(passwordField) || passwordField.length < 6) {
        document.getElementById('password_error').innerHTML = "* password must have at least six symbols,\n" +
            "at least  one number and at least one special character ";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('password_error').innerHTML = "";
    }

    //////////////////////////////////email

    if (!emailRegExp.test(emailField)) {
        document.getElementById('email_error').innerHTML = "* wrong email";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('email_error').innerHTML = "";
    }

    //////////////////////////////////phone

    if (!phoneRegExp.test(phoneField)) {
        document.getElementById('phone_error').innerHTML = "*incorrect phone number";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('phone_error').innerHTML = "";
    }

    //////////////////////////////////Mathematic result


    if (!resultRegExp.test(mathField)) {
        document.getElementById('math_error').innerHTML = "*incorrect value";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('math_error').innerHTML = "";
    }

    //////////////////////////////////Physic result

    if (!resultRegExp.test(physField)) {
        document.getElementById('phys_error').innerHTML = "*incorrect value";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('phys_error').innerHTML = "";
    }

    //////////////////////////////////Language result

    if (!resultRegExp.test(langField)) {
        document.getElementById('lang_error').innerHTML = "*incorrect value";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('lang_error').innerHTML = "";
    }

    //////////////////////////////////Certificate result

    if (!resultRegExp.test(sertField)) {
        document.getElementById('sert_error').innerHTML = "*incorrect value";
        countOfErrors = countOfErrors + 1;
    } else {
        document.getElementById('sert_error').innerHTML = "";
    }


    return countOfErrors == 0;
}
