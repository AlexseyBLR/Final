package com.reception.service.impl;

import com.reception.dao.ResultDAO;
import com.reception.dao.exception.DAOException;
import com.reception.dao.factory.DAOFactory;
import com.reception.entity.ResultForRequest;
import com.reception.service.ResultService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ResultServiceImpl implements ResultService {

    private final DAOFactory factory = DAOFactory.getInstance();
    private final ResultDAO resultDAO = factory.getResultDAO();
    private final static Logger logger = Logger.getLogger(ResultServiceImpl.class);


    @Override
    public List<ResultForRequest> getAllUsers() {
        try {
            List<ResultForRequest> lists = resultDAO.getAll();
            return lists;
        } catch (DAOException e) {
            logger.error("Can't get result", e);
        }
        return null;
    }

    @Override
    public List<ResultForRequest> getResult(String facultySpeciality) {
        try {
            List<ResultForRequest> lists = resultDAO.getEnlistedUsers(facultySpeciality);
            return lists;
        } catch (DAOException e) {
            logger.error("Can't get result", e);
        }
        return null;
    }

    @Override
    public boolean updateUsers(ResultForRequest resultForRequest) {
        try {

            resultDAO.updateUsers(resultForRequest);
            return true;
        } catch (DAOException e) {
            logger.error("Can't save result", e);
        }
        return false;
    }

    @Override
    public boolean saveResult(ResultForRequest resultForRequest) {
        try {
            return resultDAO.addResult(resultForRequest);
        } catch (DAOException e) {
            logger.error("Can't save result", e);
        }
        return false;
    }
}
