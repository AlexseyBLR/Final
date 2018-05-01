package com.reception.dao;

import com.reception.dao.exception.DAOException;
import com.reception.entity.NewUser;
import com.reception.entity.ResultForRequest;

import java.util.List;

public interface ResultDAO {

    boolean addResult(ResultForRequest resultForRequest) throws DAOException;

    List<ResultForRequest> getAll() throws DAOException;

    public void updateUsers(ResultForRequest resultForRequest) throws DAOException;

    List<ResultForRequest> getEnlistedUsers(String facultySpeciality) throws DAOException;

}
