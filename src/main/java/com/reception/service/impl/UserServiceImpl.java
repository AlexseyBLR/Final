package com.reception.service.impl;


import com.reception.dao.UserDAO;
import com.reception.dao.exception.DAOException;
import com.reception.dao.factory.DAOFactory;
import com.reception.entity.NewUser;
import com.reception.service.CustomerService;
import com.reception.service.exception.ServiceException;
import com.reception.service.exception.ValidatorException;
import com.reception.service.validator.UserValidator;
import com.reception.service.validator.impl.UserValidatorImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements CustomerService {

    private final DAOFactory factory = DAOFactory.getInstance();
    private final UserDAO customerDAO = factory.getCustomerDao();
    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private final UserValidator validator = new UserValidatorImpl();

    @Override
    public boolean saveCustomer(NewUser user) throws ServiceException {
        if (!validator.validate(user)) {
            throw new ValidatorException("attempt to save a incorrect customer");
        }
        try {
            return customerDAO.save(user);
        } catch (DAOException e) {
            throw new ServiceException("exception from saveCustomer method", e);
        }
    }

    @Override
    public NewUser findUserByEmailAndPassword(String email, String password) throws ServiceException {
        try {
            if (!validator.loginValidate(email, password)) {
                throw new ValidatorException("Invalid login date");
            }
            return customerDAO.findCustomerByEmailAndPw(email, password);
        } catch (DAOException e) {
            throw new ServiceException("exception from findUserByEmailAndPassword method", e);
        }
    }

    @Override
    public List<NewUser> getAllUsers() throws ServiceException {
        try {
            List<NewUser> list = customerDAO.getAllUsers();
            return list;
        } catch (DAOException e) {
            throw new ServiceException("exception from getAllUsers method", e);
        }
    }

    @Override
    public String generateHashPassword(String pw) {
        return null;
    }


    @Override
    public boolean update(User user) throws ServiceException {
        try {
            customerDAO.update(user);
            return  true;
        } catch (DAOException e) {
            throw new ServiceException("update user method",e);
        }
    }
}
