package com.reception.service;

import com.reception.dao.exception.DAOException;
import com.reception.entity.ResultForRequest;
import com.reception.service.exception.ServiceException;

import java.util.List;

public interface ResultService {


    boolean saveResult(ResultForRequest resultForRequest) throws DAOException;
    boolean updateUsers(ResultForRequest resultForRequest);
    List<ResultForRequest> getAllUsers() throws ServiceException, DAOException;
    List<ResultForRequest> getResult(String facultySpeciality) throws DAOException;


}
