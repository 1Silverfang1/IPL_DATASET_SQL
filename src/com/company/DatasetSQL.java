package com.company;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.company.ConstantValues.*;
import static com.company.ConstantValues.getResultSet;
public class DatasetSQL {


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
    private LinkedHashMap<String,String> querySolver(String query, String columnFirst, String columnSecond) throws SQLException {
        getResultSet= establishConnection(query).executeQuery();
      DatasetSQL datasetSQL= new DatasetSQL();
        return datasetSQL.mapAdder(columnFirst,columnSecond);
    }
    private LinkedHashMap<String,String> querySolver(String query, String columnFirst, String columnSecond, String year) throws SQLException {
        preparedStatement= establishConnection(query);
        preparedStatement.setString(1,year);
        getResultSet= preparedStatement.executeQuery();
        DatasetSQL datasetSQL= new DatasetSQL();
        return datasetSQL.mapAdder(columnFirst,columnSecond);
    }
    public static void main(String[] args) {


        try {

            DatasetSQL datasetObject= new DatasetSQL();
            datasetObject.querySolver(QUERY[iterator++],COLUMN_FIRST[iteratorColumn1++],COLUMN_SECOND[iteratorColumn2++]).forEach((k, v)->System.out.printf("\n %-30s %.5s",k,v));
            System.out.println("\n\n");
            datasetObject.querySolver(QUERY[iterator++],COLUMN_FIRST[iteratorColumn1++],COLUMN_SECOND[iteratorColumn2++]).forEach((k, v)->System.out.printf("\n %-30s %.5s",k,v));
            System.out.println("\n\n");
            datasetObject.querySolver(QUERY[iterator++],COLUMN_FIRST[iteratorColumn1++],COLUMN_SECOND[iteratorColumn2++],year[0]).forEach((k, v)->System.out.printf("\n %-30s %.5s",k,v));
            System.out.println("\n\n");
            datasetObject.querySolver(QUERY[iterator++],COLUMN_FIRST[iteratorColumn1++],COLUMN_SECOND[iteratorColumn2++],year[1]).forEach((k, v)->System.out.printf("\n %-30s %.5s",k,v));
            System.out.println("\n\n");
            datasetObject.querySolver(QUERY[iterator++],COLUMN_FIRST[iteratorColumn1++],COLUMN_SECOND[iteratorColumn2++],year[2]).forEach((k, v)->System.out.printf("\n %-30s %.5s",k,v));
            System.out.println("\n\n");



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}