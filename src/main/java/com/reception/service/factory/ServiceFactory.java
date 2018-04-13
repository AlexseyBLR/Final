package com.reception.service.factory;


import com.reception.service.CustomerService;
import com.reception.service.ResultService;
import com.reception.service.impl.ResultServiceImpl;
import com.reception.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();


    private final CustomerService customerService = new UserServiceImpl();

    private final ResultService resultService = new ResultServiceImpl();


    private ServiceFactory() {
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public ResultService getResultService(){
        return resultService;
    }


    public static ServiceFactory getInstance() {
        return instance;
    }
}
