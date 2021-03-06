package com.reception.service.validator.impl;

import com.reception.controller.constant.Constant;
import com.reception.entity.User;
import com.reception.service.validator.CustomerValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.regex.Pattern;


public class UserValidatorImpl extends AbstractValidator implements CustomerValidator<User> {


    private static final String EMAIL_REG_EXP = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

    private static final String PHONE_NUMBER_REG_EXP = "\\+[1-9]{1}[0-9]{11}";

    private static final String NAME_REG_EXP = "[A-Z]{1}[a-z{1,30}]";

    private static final String RESULT_REG_EXP = "^\\d{1,2}$|^100$";

    private static final String PASSWORD_REG_EXP = "[A-Za-z0-9]{5,}[^!@#$%^&*]";


    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REG_EXP);

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REG_EXP);

    private static final Pattern NAME_PATTER = Pattern.compile(NAME_REG_EXP);

    private static final Pattern RESULT_PATTER = Pattern.compile(RESULT_REG_EXP);

    private static final Pattern PASSWORD_PATTER = Pattern.compile(PASSWORD_REG_EXP);

    private final Map<String, Predicate<User>> dispathcer = new HashMap<>();


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
        dispathcer.put(Constant.RegistrationProperty.SERT_RESULT_PARAMETER, checkSertResult());

    }


    @Override
    public boolean validate(User user) {
        AtomicBoolean result = new AtomicBoolean(true);
        dispathcer.forEach((key, value) -> {
            if (!dispathcer.get(key).test(user)) {
                result.set(false);
                return;
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

    private Predicate<User> checkMathResult() {
        return (user) -> !this.isEmptyOrNull(String.valueOf(user.getMathResult()))
                &&
                this.matchesPattern(RESULT_PATTER, String.valueOf(user.getMathResult()));
    }

    private Predicate<User> checkPhysResult() {
        return (user) -> !this.isEmptyOrNull(String.valueOf(user.getPhysResult()))
                &&
                this.matchesPattern(RESULT_PATTER, String.valueOf(user.getPhysResult()));
    }

    private Predicate<User> checkLangResult() {
        return (user) -> !this.isEmptyOrNull(String.valueOf(user.getLangResult()))
                &&
                this.matchesPattern(RESULT_PATTER, String.valueOf(user.getLangResult()));
    }

    private Predicate<User> checkSertResult() {
        return (user) -> !this.isEmptyOrNull(String.valueOf(user.getSertResult()))
                &&
                this.matchesPattern(RESULT_PATTER, String.valueOf(user.getSertResult()));
    }

    private Predicate<User> checkPatronymicResult() {
        return (user) -> !this.isEmptyOrNull(user.getPatronymic())
                &&
                this.matchesPattern(NAME_PATTER, user.getPatronymic());
    }


    private Predicate<User> checkFirstName() {
        return (user) -> !this.isEmptyOrNull(user.getFirst_name())
                &&
                this.matchesPattern(NAME_PATTER, user.getFirst_name());
    }

    private Predicate<User> checkLastName() {
        return (user) -> !this.isEmptyOrNull(user.getLast_name())
                &&
                this.matchesPattern(NAME_PATTER, user.getLast_name());
    }


    private Predicate<User> checkEmail() {
        return (user) -> !this.isEmptyOrNull(user.getEmail())
                &&
                this.matchesPattern(EMAIL_PATTERN, user.getEmail());
    }

    private Predicate<User> checkPhone() {
        return (user) -> !this.isEmptyOrNull(user.getPhoneNumber())
                &&
                this.matchesPattern(PHONE_NUMBER_PATTERN, user.getPhoneNumber());
    }


    private Predicate<User> checkPassword() {
        return (user) -> !this.isEmptyOrNull(user.getPassword());

    }


}
