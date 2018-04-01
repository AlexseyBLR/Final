package com.reception.service.validator.impl;


import com.reception.controller.constant.Constant;
import com.reception.entity.NewUser;
import com.reception.service.exception.ValidatorException;
import com.reception.service.validator.CustomerValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.regex.Pattern;


public class UserValidatorImpl extends AbstractValidator implements CustomerValidator<NewUser> {

    private static final String EMAIL_REG_EXP = "([a-zA-Z0-9]+)(@)([a-zA-Z]+)(\\.)([a-zA-Z]){2,3}";

    private static final String PHONE_NUMBER_REG_EXP = "\\+375-(25|29|44|33)-[1-9][0-9]{2}-[0-9]{2}-[0-9]{2}";

    private static final String NAME_REG_EXP = "([a-zA-Z]+)";

    private static final String RESULT_REG_EXP = "^\\d{1,2}|100$";



//    private static final String EMAIL_REG_EXP = ".";
//
//    private static final String PHONE_NUMBER_REG_EXP = ".";
//
//    private static final String NAME_REG_EXP = ".";
//
//    private static final String RESULT_REG_EXP = ".";

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REG_EXP);

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REG_EXP);

    private static final Pattern NAME_PATTER = Pattern.compile(NAME_REG_EXP);

    private static final Pattern RESULT_PATTER = Pattern.compile(RESULT_REG_EXP);

    private final Map<String, Predicate<NewUser>> dispathcer = new HashMap<>();


    public UserValidatorImpl() {

        dispathcer.put(Constant.RegistrationProperty.FIRST_NAME_PARAMETER, checkFirstName());
        dispathcer.put(Constant.RegistrationProperty.LAST_NAME_PARAMETER, checkLastName());
        dispathcer.put(Constant.RegistrationProperty.PATRONYMIC_PARAMETER, checkPatronymicResult());
        dispathcer.put(Constant.RegistrationProperty.EMAIL_PARAMETER, checkEmail());
        dispathcer.put(Constant.RegistrationProperty.PASSWORD_PARAMETER, checkPassword());
        dispathcer.put(Constant.RegistrationProperty.PHONE_PARAMETER, checkPhone());
        dispathcer.put(Constant.RegistrationProperty.MATH_RESULT_PARAMETER, checkMathResult());
        dispathcer.put(Constant.RegistrationProperty.PHYS_RESULT_PARAMETER, checkPhysResult());
        dispathcer.put(Constant.RegistrationProperty.LANG_RESULT_PARAMETER, checkLangResult());
        dispathcer.put(Constant.RegistrationProperty.SERT_RESULT_PARAMETER, checkSerthResult());

    }


    @Override
    public boolean validate(NewUser user) {
        AtomicBoolean result = new AtomicBoolean(true);
        dispathcer.forEach((key, value) -> {
            if (!dispathcer.get(key).test(user)) {
                result.set(false);
            }
        });
        return result.get();
    }

    @Override
    public boolean loginValidate(String email, String password) {

        if (this.isEmptyOrNull(email) || this.isEmptyOrNull(password)) {
            return false;
        } else {
            return this.matchesPattern(EMAIL_PATTERN, email);
        }
    }

    private Predicate<NewUser> checkMathResult() {
        return (user) -> !this.isEmptyOrNull(user.getMathResult())
                &&
                this.matchesPattern(RESULT_PATTER, user.getMathResult());
    }

    private Predicate<NewUser> checkPhysResult() {
        return (user) -> !this.isEmptyOrNull(user.getPhysResult())
                &&
                this.matchesPattern(RESULT_PATTER, user.getPhysResult());
    }

    private Predicate<NewUser> checkLangResult() {
        return (user) -> !this.isEmptyOrNull(user.getLangResult())
                &&
                this.matchesPattern(RESULT_PATTER, user.getLangResult());
    }

    private Predicate<NewUser> checkSerthResult() {
        return (user) -> !this.isEmptyOrNull(user.getSertResult())
                &&
                this.matchesPattern(RESULT_PATTER, user.getSertResult());
    }

    private Predicate<NewUser> checkPatronymicResult() {
        return (user) -> !this.isEmptyOrNull(user.getPatronymic())
                &&
                this.matchesPattern(RESULT_PATTER, user.getPatronymic());
    }


    private Predicate<NewUser> checkFirstName() {
        return (user) -> !this.isEmptyOrNull(user.getFirst_name())
                &&
                this.matchesPattern(NAME_PATTER, user.getFirst_name());
    }

    private Predicate<NewUser> checkLastName() {
        return (user) -> !this.isEmptyOrNull(user.getLast_name())
                &&
                this.matchesPattern(NAME_PATTER, user.getLast_name());
    }


    private Predicate<NewUser> checkEmail() {
        return (user) -> !this.isEmptyOrNull(user.getEmail())
                &&
                this.matchesPattern(EMAIL_PATTERN, user.getEmail());
    }

    private Predicate<NewUser> checkPhone() {
        return (user) -> !this.isEmptyOrNull(user.getPhoneNumber())
                &&
                this.matchesPattern(PHONE_NUMBER_PATTERN, user.getPhoneNumber());
    }


    private Predicate<NewUser> checkPassword() {
        return (user) -> !this.isEmptyOrNull(user.getPassword());

    }


}
