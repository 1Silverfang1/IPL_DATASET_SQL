package com.company;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.company.ConstantValues.*;

public class Main {

    private LinkedHashMap<String,String> QuerySolver(String query,String columnFirst, String columnSecond) throws SQLException {
        LinkedHashMap<String,String> solvedQuery= new LinkedHashMap<>();
        getResultSet=getStatement.executeQuery(query);
        while (getResultSet.next())
        {
            String firstColumn = getResultSet.getString(columnFirst);
            String secondColumn = getResultSet.getString(columnSecond);
            solvedQuery.put(firstColumn,secondColumn);
        }
        return solvedQuery;
    }
    public static void main(String[] args) {


        try {
            getConnection = DriverManager.getConnection(jdbcUrlforDatabase, username, password);
            getStatement = getConnection.createStatement();
            Main main= new Main();
            for (String query : QUERY)
            {
                main.QuerySolver(query,COLUMN_FIRST[iteratorColumn1++],COLUMN_SECOND[iteratorColumn2++]).forEach((k,v)->System.out.printf("\n %-30s %.5s",k,v));
                System.out.println("\n\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        }

    }


}