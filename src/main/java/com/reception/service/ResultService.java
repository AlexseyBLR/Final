package com.reception.service;

import com.reception.dao.exception.DAOException;
import com.reception.entity.UserRequest;
import com.reception.service.exception.ServiceException;

import java.util.List;

public interface ResultService {


    boolean saveResult(UserRequest request) throws DAOException;
    boolean updateUsers(UserRequest request);
    List<UserRequest> getAllUsers() throws ServiceException;
    List<UserRequest> getResult(String facultySpeciality) throws DAOException;


}
