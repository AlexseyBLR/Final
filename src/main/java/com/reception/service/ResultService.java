package com.reception.service;

import com.reception.entity.UserRequest;
import com.reception.service.exception.ServiceException;

import java.util.List;

public interface ResultService {


    boolean saveResult(UserRequest request) throws ServiceException;
    boolean updateUsers(UserRequest request) throws ServiceException;
    List<UserRequest> getAllUsers() throws ServiceException;
    List<UserRequest> getResult(String facultySpeciality) throws ServiceException;
    void delete(String FIO) throws ServiceException;


}
