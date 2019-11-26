package com.company;

import java.sql.*;

class ConstantValues {
    static int iteratorColumn1 = 0, iteratorColumn2 = 0,iterator=0;
    static String jdbcUrlforDatabase = "jdbc:postgresql://localhost:5434/Database_test";
    static String username = "postgres";
    static String password = "toor";
    static Connection getConnection = null;
    static Statement getStatement = null;
    static ResultSet getResultSet = null;
    static String [] year={"2015","2016","2015"};
    static String[] COLUMN_FIRST = {"season", "winner", "bowling_team", "winner", "bowler"};
    static String[] COLUMN_SECOND = {"match_played", "total_wins", "extra_runs", "match_win", "economical_rate"};
    static String[] QUERY = {"select season, count(id) as match_played from matches group by season order by season;",
            "select winner, count(winner) as total_wins from matches  where winner is not null group by winner order by winner;",
            "select bowling_team, sum(cast(extra_runs as int) ) as extra_runs from delivery where match_id in (select matches.id from matches where season = ? ) group by bowling_team;",
            "select matches.winner, sum(cast(matches.win_by_runs as int))as match_win from matches where season = ? group by winner order by winner;",
            "select  delivery.bowler, sum(cast(total_runs as int))/cast((count(delivery.bowler)/6)as float) as economical_rate from delivery inner join matches m on delivery.match_id = m.id and m.season=? group by bowler order by economical_rate;"};

}