package com.reception.service.validator;

public interface CustomerValidator<Customer> extends Validator<Customer> {

    boolean loginValidate(String email, String password);



}
