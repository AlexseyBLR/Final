package com.reception.service.factory;


import com.reception.service.CustomerService;
import com.reception.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final CustomerService customerService = new UserServiceImpl();


    private ServiceFactory() {
    }

    public CustomerService getCustomerService() {
        return customerService;
    }


    public static ServiceFactory getInstance() {
        return instance;
    }
}
