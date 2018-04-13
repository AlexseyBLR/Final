package com.reception.service;

import com.reception.entity.NewUser;
import com.reception.service.exception.ServiceException;

import java.util.List;

public interface CustomerService {

    boolean saveCustomer(NewUser customer) throws ServiceException;

    NewUser findUserByEmailAndPassword(String email , String password) throws ServiceException;

    List<NewUser> getAllUsers() throws ServiceException;

    String generateHashPassword(String pw) throws ServiceException;

}
