package com.company;

import com.company.Service.Service;

import java.sql.SQLException;

import static com.company.ConstantAndDatabaseConfig.ConstantValues.*;

public class DatasetSQL {

    public static void main(String[] args) {


        try {
            Service service = new Service();
            service.querySolver(QUERY_SEASON_MATCH).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");
            service.querySolver(QUERY_WINNER_COUNT).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");
            service.querySolver(QUERY_BOWLING_EXTRA_RUNS,YEAR).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");
            service.querySolver(QUERY_WINNER_MATCH_WIN, PRE_YEAR).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");
            service.querySolver(QUERY_BOWLER_ECONOMY, PRE_YEAR).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}