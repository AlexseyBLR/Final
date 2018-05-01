package com.reception.service.factory;


import com.reception.service.CustomerService;
import com.reception.service.ResultService;
import com.reception.service.impl.ResultServiceImpl;
import com.reception.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

<<<<<<< HEAD
    private final UserService userService = new UserServiceImpl();
=======

    private final CustomerService customerService = new UserServiceImpl();
>>>>>>> parent of 0ef4810... version 20/04/18

    private final ResultService resultService = new ResultServiceImpl();



    private ServiceFactory() {
    }

<<<<<<< HEAD

    public UserService getUserService() {
        return userService;
=======
    public CustomerService getCustomerService() {
        return customerService;
>>>>>>> parent of 0ef4810... version 20/04/18
    }

    public ResultService getResultService(){
        return resultService;
    }


    public static ServiceFactory getInstance() {
        return instance;
    }
}
