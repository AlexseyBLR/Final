//package com.reception.dao;
//
//import com.reception.dao.connectionPool.ConnectionPool;
//import com.reception.dao.connectionPool.ConnectionPoolImpl;
//import com.reception.dao.connectionPool.WrappedConnection;
//import com.reception.dao.exception.DAOException;
//import com.reception.entity.NewUser;
//import org.apache.log4j.Logger;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class NewUserToDB implements UserDAO {
//    private final ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
//    private final static Logger logger = Logger.getLogger(NewUserToDB.class);
//
//
//    public static void main(String[] args) throws DAOException, SQLException {
//        NewUserToDB user = new NewUserToDB();
//
//        user.getAll();
//    }
//
//
//    @Override
//    public boolean save(NewUser customer) throws DAOException {
//        return false;
//    }
//
//    @Override
//    public NewUser findCustomerByEmailAndPassword(String email, String password) throws DAOException {
//        return null;
//    }
//
//    @Override
//    public NewUser get(String email) throws DAOException {
//        NewUser user = new NewUser();
//        try(WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
//            PreparedStatement statement = connection.getPreparedStatement("SELECT * from user WHERE email=\""+email+"\"")
//        ){
//            statement.setString(1,email);
//            ResultSet resultSet = statement.executeQuery();
//            String s = resultSet.getString(1);
//            user.setEmail(s);
//            System.out.println(user);
//            return user;
//        }catch (SQLException e){
//            logger.error("Exception from get customer  method" ,e);
//            throw new DAOException("From DAO, get customer method",e);
//        }
//    }
//
//    @Override
//    public List<NewUser> getAll() throws DAOException {
//
//        List<NewUser> users = new ArrayList<>();
//        NewUser user = new NewUser();
//        try (WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
//            Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
//            while (resultSet.next()){
//                String name = resultSet.getString(1);
//                System.out.println(name);
//            }
//        } catch (SQLException e) {
//            logger.error("Exception from DAO , getAll customers  method",e);
//            throw new DAOException(e);
//        }
//        return users;
//    }
//
//    @Override
//    public void update(NewUser user) throws DAOException {
//
//    }
//}
//
