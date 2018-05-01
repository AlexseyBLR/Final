package com.reception.service.factory;


import com.reception.service.CustomerService;
import com.reception.service.ResultService;
import com.reception.service.impl.ResultServiceImpl;
import com.reception.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();


    private final UserService userService = new UserServiceImpl();

    private final CustomerService customerService = new UserServiceImpl();

    private final ResultService resultService = new ResultServiceImpl();

    private ServiceFactory() {
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> parent of f48f517... version from 01/05/2018
=======
>>>>>>> parent of f48f517... version from 01/05/2018
=======
    private ServiceFactory() {
    }

>>>>>>> parent of f48f517... version from 01/05/2018
=======
    private ServiceFactory() {
    }

>>>>>>> parent of f48f517... version from 01/05/2018
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
