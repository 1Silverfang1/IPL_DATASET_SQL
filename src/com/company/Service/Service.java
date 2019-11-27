package com.company.Service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.company.ConstantAndDatabaseConfig.DatabaseConfig.*;


public class Service {


    private PreparedStatement establishConnection(String query) throws SQLException {

        getConnection = DriverManager.getConnection(jdbcUrlforDatabase, username, password);
        return getConnection.prepareStatement(query);
    }

    private LinkedHashMap<String, String> mapAdder() throws SQLException {
        LinkedHashMap<String, String> solvedQuery = new LinkedHashMap<>();
        while (getResultSet.next()) {
            String firstColumn = getResultSet.getString(1);
            String secondColumn = getResultSet.getString(2);
            solvedQuery.put(firstColumn, secondColumn);
        }
        try {
            if (getStatement != null) {
                getStatement.close();
            }
            if (getResultSet != null) {
                getResultSet.close();
            }
            if (getConnection != null) {
                getConnection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return solvedQuery;
    }

    public LinkedHashMap<String, String> querySolver(String query) throws SQLException {
        getResultSet = establishConnection(query).executeQuery();
        Service service = new Service();
        return service.mapAdder();
    }

    public LinkedHashMap<String, String> querySolver(String query, String year) throws SQLException {
        preparedStatement = establishConnection(query);
        preparedStatement.setString(1, year);
        getResultSet = preparedStatement.executeQuery();
        Service service = new Service();
        return service.mapAdder();
    }
}
