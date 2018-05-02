package com.reception.service.impl;

import com.reception.dao.ResultDAO;
import com.reception.dao.exception.DAOException;
import com.reception.dao.factory.DAOFactory;
import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import com.reception.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class ResultServiceImpl implements ResultService {

    private final DAOFactory factory = DAOFactory.getInstance();
    private final ResultDAO resultDAO = factory.getResultDAO();
    private final static Logger logger = Logger.getLogger(ResultServiceImpl.class);


    @Override
    public List<UserRequest> getAllUsers() throws ServiceException {
        try {
            List<UserRequest> lists = resultDAO.getAll();
            return lists;
        } catch (DAOException e) {
            logger.error("Can't get result", e);
            throw new ServiceException("can not get all users", e);
        }
    }

    @Override
    public List<UserRequest> getResult(String facultySpeciality) throws ServiceException {
        try {
            List<UserRequest> lists = resultDAO.getEnlistedUsers(facultySpeciality);
            return lists;
        } catch (DAOException e) {
            logger.error("Can't get result", e);
            throw new ServiceException("can not get result", e);
        }

    }

    @Override
    public boolean updateUsers(UserRequest request) throws ServiceException {
        try {

            resultDAO.updateUsers(request);
            return true;
        } catch (DAOException e) {
            logger.error("Can't save result", e);
            throw new ServiceException("can not update user", e);
        }

    }

    @Override
    public boolean saveResult(UserRequest request) throws ServiceException {
        try {
            return resultDAO.addResult(request);
        } catch (DAOException e) {
            logger.error("Can't save result", e);
            throw new ServiceException("can not save result", e);
        }
    }

    @Override
    public void delete(String FIO) throws ServiceException {
        try {
            resultDAO.delete(FIO);
        } catch (DAOException e) {
            logger.error("can not delete request in Service", e);
            throw new ServiceException("exception from deleteRequest method", e);
        }
    }
}
