package com.reception.service;

import com.reception.entity.User;
import com.reception.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    boolean saveCustomer(User customer) throws ServiceException;

    User findUserByEmailAndPassword(String email , String password) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    void deleteCustomer(String email) throws ServiceException;

}
