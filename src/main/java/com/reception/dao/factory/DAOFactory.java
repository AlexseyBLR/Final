package com.reception.dao.factory;


import com.reception.dao.UserDAO;
import com.reception.dao.ResultDAO;
import com.reception.dao.impl.RequestsDAOImpl;
import com.reception.dao.impl.UserDAOImpl;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new UserDAOImpl();

    private final ResultDAO resultDAO = new RequestsDAOImpl();


    public UserDAO getCustomerDao() {
        return userDAO;
    }

    public ResultDAO getResultDAO() {
        return resultDAO;
    }

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

}
