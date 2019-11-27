package com.company.ConstantAndDatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConfig {
    public static String jdbcUrlforDatabase = "jdbc:postgresql://localhost:5434/Database_test";
    public   static String username = "postgres";
    public static String password = "toor";
    public  static Connection getConnection = null;
    public static Statement getStatement = null;
    public  static ResultSet getResultSet = null;
    public static PreparedStatement preparedStatement;
}
