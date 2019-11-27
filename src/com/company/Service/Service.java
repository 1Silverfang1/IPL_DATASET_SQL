package com.company.Service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.company.Constant.ConstantValues.*;
import static com.company.Constant.ConstantValues.preparedStatement;

public class Service {


    private PreparedStatement establishConnection(String query) throws SQLException
    {

        getConnection = DriverManager.getConnection(jdbcUrlforDatabase, username, password);
        return getConnection.prepareStatement(query);
    }

    private LinkedHashMap<String,String> mapAdder(String columnFirst, String columnSecond) throws SQLException {
        LinkedHashMap<String,String> solvedQuery= new LinkedHashMap<>();
        while (getResultSet.next())
        {
            String firstColumn = getResultSet.getString(columnFirst);
            String secondColumn = getResultSet.getString(columnSecond);
            solvedQuery.put(firstColumn,secondColumn);
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
    public LinkedHashMap<String,String> querySolver(String query, String columnFirst, String columnSecond) throws SQLException {
        getResultSet= establishConnection(query).executeQuery();
        Service service= new Service();
        return service.mapAdder(columnFirst,columnSecond);
    }
    public LinkedHashMap<String,String> querySolver(String query, String columnFirst, String columnSecond, String year) throws SQLException {
        preparedStatement= establishConnection(query);
        preparedStatement.setString(1,year);
        getResultSet= preparedStatement.executeQuery();
        Service service= new Service();
        return service.mapAdder(columnFirst,columnSecond);
    }
}
