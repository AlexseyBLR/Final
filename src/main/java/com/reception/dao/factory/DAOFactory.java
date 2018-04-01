package com.reception.dao.factory;


import com.reception.dao.UserDAO;
import com.reception.dao.impl.UserDAOImpl;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new UserDAOImpl();

    public UserDAO getCustomerDao(){
        return userDAO;
    }


    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }
}
