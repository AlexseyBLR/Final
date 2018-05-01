package com.reception.service;

import com.reception.dao.exception.DAOException;
import com.reception.entity.ResultForRequest;
import com.reception.service.exception.ServiceException;

import java.util.List;

public interface ResultService {


<<<<<<< HEAD
    boolean saveResult(UserRequest request) throws DAOException;
    boolean updateUsers(UserRequest request);
    List<UserRequest> getAllUsers() throws ServiceException, DAOException;
    List<UserRequest> getResult(String facultySpeciality) throws DAOException;
=======
    boolean saveResult(ResultForRequest resultForRequest) throws DAOException;
    boolean updateUsers(ResultForRequest resultForRequest);
    List<ResultForRequest> getAllUsers() throws ServiceException, DAOException;
    List<ResultForRequest> getResult(String facultySpeciality) throws DAOException;
>>>>>>> parent of 0ef4810... version 20/04/18


}
