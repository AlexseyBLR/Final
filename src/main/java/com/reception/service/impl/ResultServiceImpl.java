package com.reception.service.impl;

import com.reception.dao.ResultDAO;
import com.reception.dao.exception.DAOException;
import com.reception.dao.factory.DAOFactory;
import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import org.apache.log4j.Logger;

import java.util.List;

public class ResultServiceImpl implements ResultService {

    private final DAOFactory factory = DAOFactory.getInstance();
    private final ResultDAO resultDAO = factory.getResultDAO();
    private final static Logger logger = Logger.getLogger(ResultServiceImpl.class);


    @Override
    public List<UserRequest> getAllUsers() {
        try {
            List<UserRequest> lists = resultDAO.getAll();
            return lists;
        } catch (DAOException e) {
            logger.error("Can't get result", e);
        }
        return null;
    }

    @Override
    public List<UserRequest> getResult(String facultySpeciality) {
        try {
            List<UserRequest> lists = resultDAO.getEnlistedUsers(facultySpeciality);
            return lists;
        } catch (DAOException e) {
            logger.error("Can't get result", e);
        }
        return null;
    }

    @Override
    public boolean updateUsers(UserRequest request) {
        try {

            resultDAO.updateUsers(request);
            return true;
        } catch (DAOException e) {
            logger.error("Can't save result", e);
        }
        return false;
    }

    @Override
    public boolean saveResult(UserRequest request) {
        try {
            return resultDAO.addResult(request);
        } catch (DAOException e) {
            logger.error("Can't save result", e);
        }
        return false;
    }
}
