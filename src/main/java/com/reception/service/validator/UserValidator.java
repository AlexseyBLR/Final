package com.reception.service.validator;

public interface UserValidator<Customer> extends Validator<Customer> {

    boolean loginValidate(String email, String password);



}
