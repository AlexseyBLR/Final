package com.reception.service.impl;


import com.reception.dao.UserDAO;
import com.reception.dao.exception.DAOException;
import com.reception.dao.factory.DAOFactory;
import com.reception.entity.NewUser;
import com.reception.service.CustomerService;
import com.reception.service.exception.ServiceException;
import com.reception.service.exception.ValidatorException;
import com.reception.service.validator.CustomerValidator;
import com.reception.service.validator.impl.UserValidatorImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements CustomerService {

    private final DAOFactory factory = DAOFactory.getInstance();
    private final UserDAO customerDAO = factory.getCustomerDao();
    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private final CustomerValidator validator = new UserValidatorImpl();
//    private final HashGenerator hashGenerator = new HashGenerator();


    @Override
    public boolean saveCustomer(NewUser user) throws ServiceException {

        try {

            if(!validator.validate(user)){
                throw new ValidatorException("attempt to save a incorrect customer");
            }
            return customerDAO.save(user);
        } catch (DAOException e) {
            throw new ServiceException("exception from saveCustomer method",e);
        }
    }

    @Override
    public NewUser findCustomerByEmailAndPassword(String email, String password) throws ServiceException {
        try {
            NewUser user = null;
            if(!validator.loginValidate(email,password)){
                throw new ValidatorException("Invalid login date");
            }
            return customerDAO.findCustomerByEmailAndPw(email,password);
        } catch (DAOException e) {
            throw new ServiceException("exception from findCustomerByEmailAndPassword method",e);
        }
    }

    @Override
    public List<NewUser> getAllCustomers() throws ServiceException {
        try {
            return customerDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException("exception from getAllCustomers method",e);
        }
    }

    @Override
    public String generateHashPassword(String pw) throws ServiceException {
//        return this.hashGenerator.generateHashPassword(pw);
        return null;
    }



}
