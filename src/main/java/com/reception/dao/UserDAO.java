package com.reception.dao;

import com.reception.dao.exception.DAOException;
import com.reception.entity.NewUser;

import java.util.List;

public interface UserDAO {

    boolean save(NewUser customer) throws DAOException;

    NewUser findCustomerByEmailAndPassword(String email , String password) throws DAOException;

    NewUser findCustomerByEmailAndPw(String emil, String pw) throws DAOException;

    NewUser get(String email) throws DAOException;

    List<NewUser> getAllUsers() throws DAOException;

<<<<<<< HEAD
    boolean update(User user) throws DAOException;
=======
    void update(NewUser user) throws DAOException;
>>>>>>> parent of 0ef4810... version 20/04/18
}
