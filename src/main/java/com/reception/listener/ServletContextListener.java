package com.reception.listener;

import com.reception.dao.exception.CloseConnectionException;
import com.reception.dao.exception.ConnectionPoolInitializationException;
import com.reception.dao.impl.connectionPool.ConnectionPoolImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;


public class ServletContextListener implements javax.servlet.ServletContextListener {

    private final static Logger logger = Logger.getLogger(ServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try{
            ConnectionPoolImpl.getInstance().init();
            logger.info("Connections initialized");

        }catch (ConnectionPoolInitializationException e){
            logger.error("Connection pool init error",e);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ConnectionPoolImpl.getInstance().closeAll();
            logger.info("Connections closed");
        } catch (CloseConnectionException e) {
            logger.error("Connection pool connection close error",e);
        }
    }
}
