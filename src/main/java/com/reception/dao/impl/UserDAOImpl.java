package com.reception.dao.impl;


import com.reception.dao.UserDAO;
import com.reception.dao.exception.ConnectionPoolException;
import com.reception.dao.exception.DAOException;
import com.reception.dao.impl.connectionPool.ConnectionPool;
import com.reception.dao.impl.connectionPool.ConnectionPoolImpl;
import com.reception.dao.impl.connectionPool.WrappedConnection;
import com.reception.entity.NewUser;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final static Logger logger = Logger.getLogger(UserDAOImpl.class);

    private final ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();

    private final static String TABLE_NAME = "user";


    private final static String SQL_SAVE_PREPARED_STATEMENT = "insert into "+TABLE_NAME+" values(?,?,?,?,?,?,?,?,?,?,?)";

    private final static String SQL_GET_PREPARED_STATEMENT = "SELECT * from "+TABLE_NAME+" WHERE email=?";

    private final static String SQL_UPDATE_PREPARED_STATEMENT = "UPDATE "+TABLE_NAME+" " +
            "SET first_name=? , last_name=? , patronymic=? , phone=? , email=? , password=? " +
            "WHERE email=?";

    private final static String SQL_DELETE_PREPARED_STATEMENT = "DELETE FROM "+TABLE_NAME+"WHERE email=?";

    private final static String SELECT_ALL_SQL = "select * from customer";

    private final static String FIND_BY_EMAIL_AND_PW_SQL_STATEMENT = "SELECT * FROM "+TABLE_NAME+" WHERE email=? AND password=?";

    private final static int NAME_COLUMN_INDEX = 1;
    private final static int SURE_NAME_COLUMN_INDEX = 2;
    private final static int PATRONYMIC_COLUMN_INDEX = 3;
    private final static int PHONE_COLUMN_INDEX = 6;
    private final static int EMAIL_COLUMN_INDEX = 4;
    private final static int PASSWORD_COLUMN_INDEX = 5;
    private final static int MATH_COLUMN_INDEX = 7;
    private final static int PHYS_COLUMN_INDEX = 8;
    private final static int LANG_COLUMN_INDEX = 9;
    private final static int SERT_COLUMN_INDEX = 10;
    private final static int ROLE_COLUMN_INDEX = 11;
    private final static String NEW_USER_ROLE = "user";

    private final static int EMAIL_PARAMETER_INDEX = 1;
    private final static int PASSWORD_PARAMETER_INDEX = 2;



    
    @Override
    public boolean save(NewUser user) throws DAOException {

        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
            PreparedStatement statement = connection.getPreparedStatement(SQL_SAVE_PREPARED_STATEMENT)
        ){
            statement.setString(NAME_COLUMN_INDEX,user.getFirst_name());
            statement.setString(SURE_NAME_COLUMN_INDEX,user.getLast_name());
            statement.setString(PATRONYMIC_COLUMN_INDEX,user.getPatronymic());
            statement.setString(PHONE_COLUMN_INDEX,user.getPhoneNumber());
            statement.setString(EMAIL_COLUMN_INDEX,user.getEmail());
            statement.setString(PASSWORD_COLUMN_INDEX,user.getPassword());
            statement.setString(MATH_COLUMN_INDEX,user.getMathResult());
            statement.setString(PHYS_COLUMN_INDEX,user.getPhysResult());
            statement.setString(LANG_COLUMN_INDEX,user.getLangResult());
            statement.setString(SERT_COLUMN_INDEX,user.getSertResult());
            statement.setString(ROLE_COLUMN_INDEX,NEW_USER_ROLE);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Exception from DAO, save Customer method ",e);
            throw new DAOException("Save Customer method",e);
        }
    }

    @Override
    public NewUser findCustomerByEmailAndPassword(String email, String password) throws DAOException {
        return null;
    }


    @Override
    public List<NewUser> getAll() throws DAOException {

        List<NewUser> customers = new ArrayList<>();
        NewUser user = null;
        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
            Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(SELECT_ALL_SQL);
            while (rs.next()){
//                String firstName = rs.getString(NAME_COLUMN_INDEX);
//                String lastName = rs.getString(SURE_NAME_COLUMN_INDEX);
//                String patronymic = rs.getString("f");
//                String email = rs.getString(EMAIL_COLUMN_INDEX);
//                String password = rs.getString(PASSWORD_COLUMN_INDEX);
//                String phone = rs.getString(PHONE_COLUMN_INDEX);
//                String birthDay = rs.getString(BIRTH_DAY_COLUMN_INDEX);
//                String mathResult = rs.getString(GENDER_COLUMN_INDEX);
//                String physResult = rs.getString(GENDER_COLUMN_INDEX);
//                String langResult = rs.getString(GENDER_COLUMN_INDEX);
//                String sertResult = rs.getString(GENDER_COLUMN_INDEX);
//                user = new NewUser(
//                        firstName,lastName,patronymic,email,password,
//                        phone,birthDay,mathResult, physResult, langResult, sertResult
//                );
//                customers.add(user);
            }
            return customers;
        } catch (SQLException e) {
            logger.error("Exception from DAO , getAll customers  method",e);
            throw new DAOException("getAll customers  method",e);
        }

    }


    @Override
    public NewUser findCustomerByEmailAndPw(String email, String password) throws DAOException {
        NewUser user = null;
        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
            PreparedStatement statement = connection.getPreparedStatement(FIND_BY_EMAIL_AND_PW_SQL_STATEMENT))
        {
            statement.setString(EMAIL_PARAMETER_INDEX,email);
            statement.setString(PASSWORD_PARAMETER_INDEX,password);
            ResultSet rs = statement.executeQuery();
            if(rs != null){
              user = buildNewUser(rs);
            }
            return user;
        } catch (SQLException e) {
            logger.error("Exception from findByEmailAndPassword method" ,e);
            throw new DAOException("From DAO, findByEmailAndPassword method ",e);
        }
    }

    @Override
    public NewUser get(String email) throws DAOException {

        NewUser user = null;
        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
            PreparedStatement statement = connection.getPreparedStatement(SQL_GET_PREPARED_STATEMENT)
        ){
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            user = buildNewUser(resultSet);
            return user;
        }catch (SQLException e){
            logger.error("Exception from get user  method" ,e);
            throw new DAOException("From DAO, get user method",e);
        }

    }


    private NewUser buildNewUser(ResultSet rs) throws DAOException {
        NewUser user = null;
        try {
            while (rs.next()) {
                String firstName = rs.getString(NAME_COLUMN_INDEX);
                String lastName = rs.getString(SURE_NAME_COLUMN_INDEX);
                String patronymic = rs.getString(PATRONYMIC_COLUMN_INDEX);
                String email = rs.getString(EMAIL_COLUMN_INDEX);
                String password = rs.getString(PASSWORD_COLUMN_INDEX);
                String phone = rs.getString(PHONE_COLUMN_INDEX);
                String mathResult = rs.getString(MATH_COLUMN_INDEX);
                String physResult = rs.getString(PHYS_COLUMN_INDEX);
                String langResult = rs.getString(LANG_COLUMN_INDEX);
                String sertResult = rs.getString(SERT_COLUMN_INDEX);
                String role = rs.getString(ROLE_COLUMN_INDEX);
                user = new NewUser(
                        firstName,lastName,patronymic,email,password,
                        phone,mathResult, physResult, langResult, sertResult
                );
            }
            return user;
        } catch (SQLException e) {
            logger.error("Exception when Build Customer from buildNewUser method ",e);
            throw new DAOException("From DAO, buildNewUser method",e);
        }
    }



    @Override
    public void update(NewUser user) throws DAOException {

        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
            PreparedStatement statement = connection.getPreparedStatement(SQL_UPDATE_PREPARED_STATEMENT)
        ){
            statement.setString(1,user.getFirst_name());
            statement.setString(2,user.getLast_name());
            statement.setString(3,user.getPatronymic());
            statement.setString(4,user.getEmail());
            statement.setString(5,user.getPassword());
            statement.setString(6,user.getPhoneNumber());
            statement.setString(8,user.getMathResult());
            statement.setString(9,user.getPhysResult());
            statement.setString(10,user.getLangResult());
            statement.setString(11,user.getSertResult());
            statement.executeUpdate();
        }catch (SQLException e){
            logger.error("Exception in update user  method ",e);
            throw new DAOException("Update user method error",e);
        }
    }


    public void delete(NewUser user) throws DAOException {

        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
            PreparedStatement statement = connection.getPreparedStatement(SQL_DELETE_PREPARED_STATEMENT)
        ){
            statement.setString(1,user.getEmail());
            statement.executeUpdate();
        }catch (SQLException e){
            logger.error("Exception in delete user  method ",e);
            throw new DAOException("Delete user method",e);
        }

    }

}
