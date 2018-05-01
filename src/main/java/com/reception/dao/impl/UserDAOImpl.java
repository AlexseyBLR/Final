package com.reception.dao.impl;


import com.reception.dao.UserDAO;
import com.reception.dao.exception.DAOException;
import com.reception.dao.impl.connectionPool.ConnectionPool;
import com.reception.dao.impl.connectionPool.ConnectionPoolImpl;
import com.reception.dao.impl.connectionPool.WrappedConnection;
import com.reception.entity.User;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static Logger logger = Logger.getLogger(UserDAOImpl.class);

    private final ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();

    private final static String TABLE_NAME = "user";

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private final static String SQL_SAVE_PREPARED_STATEMENT = "insert into "+TABLE_NAME+" values(?,?,?,?,?,?,?,?,?,?,?)";

    private final static String SQL_GET_PREPARED_STATEMENT = "SELECT * from "+TABLE_NAME+" WHERE email=?";

    private final static String SQL_UPDATE_PREPARED_STATEMENT = "UPDATE user " +
            "SET first_name=? , last_name=? , patronymic=? , Math_result=? , Phys_result=? , Lang_result=?, Sert_result=? "+
            "WHERE email=?";

    private final static String SQL_DELETE_PREPARED_STATEMENT = "DELETE FROM "+TABLE_NAME+"WHERE email=?";

    private final static String SELECT_ALL_SQL = "select * from user";

    private final static String FIND_BY_EMAIL_AND_PW_SQL_STATEMENT = "SELECT * FROM "+TABLE_NAME+" WHERE email=? AND password=?";

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
    public boolean save(User user) throws DAOException {

        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
            PreparedStatement statement = connection.getPreparedStatement(SQL_SAVE_PREPARED_STATEMENT)
        ){
            statement.setString(NAME_COLUMN_INDEX,user.getFirst_name());
            statement.setString(SURE_NAME_COLUMN_INDEX,user.getLast_name());
            statement.setString(PATRONYMIC_COLUMN_INDEX,user.getPatronymic());
            statement.setString(PHONE_COLUMN_INDEX,user.getPhoneNumber());
            statement.setString(EMAIL_COLUMN_INDEX,user.getEmail());
            statement.setString(PASSWORD_COLUMN_INDEX,user.getPassword());
            statement.setInt(MATH_COLUMN_INDEX,user.getMathResult());
            statement.setInt(PHYS_COLUMN_INDEX,user.getPhysResult());
            statement.setInt(LANG_COLUMN_INDEX,user.getLangResult());
            statement.setInt(SERT_COLUMN_INDEX,user.getSertResult());
            statement.setString(ROLE_COLUMN_INDEX,NEW_USER_ROLE);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Exception from DAO, save Customer method ",e);
            throw new DAOException("Save Customer method",e);
        }
    }

    @Override
    public User findCustomerByEmailAndPassword(String email, String password) throws DAOException {
        return null;
    }


    @Override
    public List<User> getAll() throws DAOException {

        List<User> customers = new ArrayList<>();
        User user = null;
        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
            Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(SELECT_ALL_SQL);
            while (rs.next()){
                String firstName = rs.getString(NAME_COLUMN_INDEX);
                String lastName = rs.getString(SURE_NAME_COLUMN_INDEX);
                String patronymic = rs.getString(PATRONYMIC_COLUMN_INDEX);
                String email = rs.getString(EMAIL_COLUMN_INDEX);
                String password = rs.getString(PASSWORD_COLUMN_INDEX);
                String phone = rs.getString(PHONE_COLUMN_INDEX);
                int mathResult = Integer.parseInt(rs.getString(MATH_COLUMN_INDEX));
                int physResult = Integer.parseInt(rs.getString(PHYS_COLUMN_INDEX));
                int langResult = Integer.parseInt(rs.getString(LANG_COLUMN_INDEX));
                int sertResult = Integer.parseInt(rs.getString(SERT_COLUMN_INDEX));
                String role = rs.getString(ROLE_COLUMN_INDEX);
                user = new User(
                        firstName,lastName,patronymic,email,password,
                        phone,mathResult, physResult, langResult, sertResult, role
                );
                customers.add(user);
            }
            return customers;
        } catch (SQLException e) {
            logger.error("Exception from DAO , getAll customers  method",e);
            throw new DAOException("getAll customers  method",e);
        }

    }


    @Override
    public User find(String email, String password) throws DAOException {
        User user = null;
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
    public User get(String email) throws DAOException {

        User user = null;
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


    private User buildNewUser(ResultSet rs) throws DAOException {
        User user = null;
        try {
            while (rs.next()) {
                String firstName = rs.getString(NAME_COLUMN_INDEX);
                String lastName = rs.getString(SURE_NAME_COLUMN_INDEX);
                String patronymic = rs.getString(PATRONYMIC_COLUMN_INDEX);
                String email = rs.getString(EMAIL_COLUMN_INDEX);
                String password = rs.getString(PASSWORD_COLUMN_INDEX);
                String phone = rs.getString(PHONE_COLUMN_INDEX);
                int mathResult = Integer.parseInt(rs.getString(MATH_COLUMN_INDEX));
                int physResult = Integer.parseInt(rs.getString(PHYS_COLUMN_INDEX));
                int langResult = Integer.parseInt(rs.getString(LANG_COLUMN_INDEX));
                int sertResult = Integer.parseInt(rs.getString(SERT_COLUMN_INDEX));
                String role = rs.getString(ROLE_COLUMN_INDEX);
                user = new User(
                        firstName,lastName,patronymic,email,password,
                        phone,mathResult, physResult, langResult, sertResult, role
                );
            }
            return user;
        } catch (SQLException e) {
            logger.error("Exception when Build Customer from buildNewUser method ",e);
            throw new DAOException("From DAO, buildNewUser method",e);
        }
    }



    @Override
    public boolean update(User user) throws DAOException {

        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
            PreparedStatement statement = connection.getPreparedStatement(SQL_UPDATE_PREPARED_STATEMENT)
        ){
            statement.setString(1,user.getFirst_name());
            statement.setString(2,user.getLast_name());
            statement.setString(3,user.getPatronymic());
            statement.setInt(4,user.getMathResult());
            statement.setInt(5,user.getPhysResult());
            statement.setInt(6,user.getLangResult());
            statement.setInt(7,user.getSertResult());
            statement.setString(8, user.getEmail());
            statement.executeUpdate();
        }catch (SQLException e){
            logger.error("Exception in update user  method ",e);
            throw new DAOException("Update user method error",e);
        }
        return false;
    }


    public void delete(User user) throws DAOException {

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
