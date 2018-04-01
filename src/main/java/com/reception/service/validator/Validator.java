package com.reception.service.validator;

public interface Validator<T> {

    boolean validate(T t);

}
