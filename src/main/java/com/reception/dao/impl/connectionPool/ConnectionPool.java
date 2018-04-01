package com.reception.dao.connectionPool;

import com.reception.dao.exception.ConnectionPoolException;

import java.sql.Connection;

public interface ConnectionPool {

    void init();

    Connection getConnection() throws ConnectionPoolException;

    boolean returnConnection(Connection connection) throws ConnectionPoolException;

    void closeAll();

}
