package com.reception.dao.impl;

import com.reception.dao.ResultDAO;
import com.reception.dao.exception.DAOException;
import com.reception.dao.impl.connectionPool.ConnectionPool;
import com.reception.dao.impl.connectionPool.ConnectionPoolImpl;
import com.reception.dao.impl.connectionPool.WrappedConnection;
import com.reception.entity.ResultForRequest;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestsDAOImpl implements ResultDAO {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private final static Logger logger = Logger.getLogger(RequestsDAOImpl.class);

    private final ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();

    private static final String TABLE_NAME = "requests";

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String SQL_SAVE_PREPARED_STATEMENT = "insert into " + TABLE_NAME + " values(?,?,?,?,?,?,?)";

    private final static String SELECT_ALL_SQL = "select * from requests";

    private final static String APPROVED_STATUS = "applied";

    private final static String SQL_UPDATE_STATUS_PREPARED_STATEMENT = "UPDATE " + TABLE_NAME + " " +
            "Set  status=? " +
            "WHERE status='accepted'";

    private String facultySpeciality;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final String STATUS = "accepted";

    private final static int FIO_COLUMN_INDEX = 1;
    private final static int MATH_COLUMN_INDEX = 2;
    private final static int PHYS_COLUMN_INDEX = 3;
    private final static int LANG_COLUMN_INDEX = 4;
    private final static int SERT_COLUMN_INDEX = 5;
    private final static int STATUS_COLUMN_INDEX = 6;
    private final static int FACSPEC_COLUMN_INDEX = 7;


    @Override
    public boolean addResult(ResultForRequest resultForRequest) throws DAOException {
        try (WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
             PreparedStatement statement = connection.getPreparedStatement(SQL_SAVE_PREPARED_STATEMENT)
        ) {

            statement.setString(FIO_COLUMN_INDEX, resultForRequest.getFIO());
            statement.setInt(MATH_COLUMN_INDEX, resultForRequest.getMathResult());
            statement.setInt(PHYS_COLUMN_INDEX, resultForRequest.getPhysResult());
            statement.setInt(LANG_COLUMN_INDEX, resultForRequest.getLangResult());
            statement.setInt(SERT_COLUMN_INDEX, resultForRequest.getSertResult());
            statement.setString(STATUS_COLUMN_INDEX, STATUS);
            statement.setString(FACSPEC_COLUMN_INDEX, resultForRequest.getFacSpec());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Exception from DAO, save Customer method ", e);
            throw new DAOException("Add request method", e);
        }
    }

    @Override
    public List<ResultForRequest> getAll() throws DAOException {
        List<ResultForRequest> requests = new ArrayList<>();
        ResultForRequest request = null;
        try (WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SELECT_ALL_SQL);
            while (rs.next()) {
                String FIO = rs.getString(FIO_COLUMN_INDEX);
                int mathResult = Integer.parseInt(rs.getString(MATH_COLUMN_INDEX));
                int physResult = Integer.parseInt(rs.getString(PHYS_COLUMN_INDEX));
                int langResult = Integer.parseInt(rs.getString(LANG_COLUMN_INDEX));
                int sertResult = Integer.parseInt(rs.getString(SERT_COLUMN_INDEX));
                String status = rs.getString(STATUS_COLUMN_INDEX);
                String faculty_speciality = rs.getString(FACSPEC_COLUMN_INDEX);
                request = new ResultForRequest(FIO, mathResult, physResult, langResult, sertResult, faculty_speciality);
                request.setStatus(status);
                requests.add(request);
            }
            return requests;
        } catch (SQLException e) {
            logger.error("Exception from DAO , getAllUsers customers  method", e);
            throw new DAOException("getAllUsers customers  method", e);
        }
    }

    @Override
    public void updateUsers(ResultForRequest resultForRequest) throws DAOException {
        try (WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
             PreparedStatement statement = connection.getPreparedStatement(SQL_UPDATE_STATUS_PREPARED_STATEMENT)
        ) {

            statement.setString(1, APPROVED_STATUS);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Exception in update customer  method ", e);
            throw new DAOException("Update customer method error", e);
        }

    }

    @Override
    public List<ResultForRequest> getEnlistedUsers(String facultySpeciality) throws DAOException {
        this.facultySpeciality = facultySpeciality;
        String SQL_ENLISTED_PREPARED_STATEMENT = "select * from requests where status='applied' and faculty_speciality=" + this.facultySpeciality + " order by Mresult+Phresilt+Lresult+Sresult desc limit 3;";
        List<ResultForRequest> requests = new ArrayList<>();
        ResultForRequest request = null;
        try (WrappedConnection connection = new WrappedConnection(connectionPool.getConnection());
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_ENLISTED_PREPARED_STATEMENT);
            while (rs.next()) {
                String FIO = rs.getString(FIO_COLUMN_INDEX);
                int mathResult = Integer.parseInt(rs.getString(MATH_COLUMN_INDEX));
                int physResult = Integer.parseInt(rs.getString(PHYS_COLUMN_INDEX));
                int langResult = Integer.parseInt(rs.getString(LANG_COLUMN_INDEX));
                int sertResult = Integer.parseInt(rs.getString(SERT_COLUMN_INDEX));
                String status = rs.getString(STATUS_COLUMN_INDEX);
                String faculty_speciality = rs.getString(FACSPEC_COLUMN_INDEX);
                request = new ResultForRequest(FIO, mathResult, physResult, langResult, sertResult, faculty_speciality);
                request.setStatus(status);
                requests.add(request);
            }
            return requests;
        } catch (SQLException e) {
            logger.error("Exception from DAO , getAllUsers customers  method", e);
            throw new DAOException("getAllUsers customers  method", e);
        }

    }
}
