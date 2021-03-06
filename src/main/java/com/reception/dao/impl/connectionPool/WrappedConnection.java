package com.reception.dao.impl.connectionPool;


import com.reception.dao.exception.CloseConnectionException;
import com.reception.dao.exception.ConnectionPoolException;

import java.io.Closeable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class WrappedConnection implements Closeable {

    private java.sql.Connection connection;

    public WrappedConnection(java.sql.Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() throws CloseConnectionException {
        try {
            ConnectionPoolImpl.getInstance().returnConnection(connection);
        } catch (ConnectionPoolException e) {
            throw new CloseConnectionException(e);

        }

    }

    public PreparedStatement getPreparedStatement(String sqlQuery) throws SQLException {
        return connection.prepareStatement(sqlQuery);
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void setAutoCommit(boolean flag) throws SQLException {
        connection.setAutoCommit(flag);
    }


    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }


}
