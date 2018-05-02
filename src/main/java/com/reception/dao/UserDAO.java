package com.reception.dao;

import com.reception.dao.exception.DAOException;
import com.reception.entity.User;

import java.util.List;

public interface UserDAO {

    boolean save(User customer) throws DAOException;

    User findCustomerByEmailAndPassword(String email , String password) throws DAOException;

    User get(String email) throws DAOException;

    List<User> getAllUsers() throws DAOException;

    void update(User user) throws DAOException;

    void delete(String string) throws DAOException;

}
