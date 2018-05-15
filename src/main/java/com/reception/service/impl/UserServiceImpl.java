package com.reception.service.impl;


import com.reception.dao.UserDAO;
import com.reception.dao.exception.DAOException;
import com.reception.dao.factory.DAOFactory;
import com.reception.entity.User;
import com.reception.service.UserService;
import com.reception.service.exception.ServiceException;
import com.reception.service.exception.ValidatorException;
import com.reception.service.validator.CustomerValidator;
import com.reception.service.validator.impl.UserValidatorImpl;
import org.apache.log4j.Logger;

import java.util.List;


public class UserServiceImpl implements UserService {

    private final DAOFactory factory = DAOFactory.getInstance();
    private final UserDAO customerDAO = factory.getCustomerDao();
    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private final CustomerValidator validator = new UserValidatorImpl();

    @Override
    public boolean saveCustomer(User user) throws ServiceException {
        if (validator.validate(user)) {
            throw new ValidatorException("attempt to save a incorrect customer");
        }
        try {
            return customerDAO.save(user);
        } catch (DAOException e) {
            logger.error("can not save user", e);
            throw new ServiceException("exception from saveCustomer method", e);
        }
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) throws ServiceException {
        try {
            if (!validator.loginValidate(email, password)) {
                throw new ValidatorException("Invalid login date");
            }
            return customerDAO.findCustomerByEmailAndPassword(email, password);
        } catch (DAOException e) {
            logger.error("can not find users", e);
            throw new ServiceException("exception from findUserByEmailAndPassword method", e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        try {
            List<User> list = customerDAO.getAllUsers();
            return list;
        } catch (DAOException e) {
            logger.error("can not get all users", e);
            throw new ServiceException("exception from getAllUsers method", e);
        }
    }

    @Override
    public void deleteCustomer(String email)  throws ServiceException {
        try {
            customerDAO.delete(email);
        } catch (DAOException e) {
            logger.error("can not delete user in Service", e);
            throw new ServiceException("exception from deleteCustomer method", e);
        }
    }
}
