package com.company;

import com.company.Service.Service;

import java.sql.SQLException;

import static com.company.ConstantAndDatabaseConfig.ConstantValues.*;

public class DatasetSQL {

    public static void main(String[] args) {


        try {
            Service service = new Service();
            service.querySolver(QUERY_SEASON_MATCH, SEASON_COLUMN, MATCH_PLAYED).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");
            service.querySolver(QUERY_WINNER_COUNT, WINNER_COLUMN, TOTAL_WINS).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");
            service.querySolver(QUERY_BOWLING_EXTRA_RUNS, BOWLING_TEAM, EXTRA_RUNS, YEAR).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");
            service.querySolver(QUERY_WINNER_MATCHWIN, WINNER_COLUMN, MATCH_WIN, PRE_YEAR).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");
            service.querySolver(QUERY_BOWLER_ECONOMY, BOWLER, ECONOMICAL_RATE, PRE_YEAR).forEach((k, v) -> System.out.printf("\n %-30s %.5s", k, v));
            System.out.println("\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}