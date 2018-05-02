package com.reception.dao;

import com.reception.dao.exception.DAOException;
import com.reception.entity.UserRequest;

import java.util.List;

public interface ResultDAO {

    boolean addResult(UserRequest resultForRequest) throws DAOException;

    List<UserRequest> getAll() throws DAOException;

    void updateUsers(UserRequest resultForRequest) throws DAOException;

    void delete(String FIO) throws DAOException;

    List<UserRequest> getEnlistedUsers(String facultySpeciality) throws DAOException;

}