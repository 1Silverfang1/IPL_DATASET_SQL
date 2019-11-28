package com.company.ConstantAndDatabaseConfig;

public class ConstantValues {

    public static String YEAR = "2016", PRE_YEAR = "2015",firstColumn = null, secondColumn = null;
    private static String over = "6", limit = "10";
    public static String QUERY_SEASON_MATCH = "select season, count(id) as match_played from matches group by season order by season;";
    public static String QUERY_WINNER_COUNT = "select winner, count(winner) as total_wins from matches  where winner is not null group by winner order by winner;";
    public static String QUERY_BOWLING_EXTRA_RUNS = "select bowling_team, sum(cast(extra_runs as int) ) as extra_runs from delivery where match_id in (select matches.id from matches where season = ? ) group by bowling_team;";
    public static String QUERY_WINNER_MATCH_WIN = "select matches.winner, sum(cast(matches.win_by_runs as int))as match_win from matches where season = ? AND winner is not null group by winner order by winner;";
    public static String QUERY_BOWLER_ECONOMY = "select  delivery.bowler, sum(cast(total_runs as int))/cast((count(delivery.bowler)/" + over + ")as float) as economical_rate from delivery inner join matches m on delivery.match_id = m.id and m.season=? group by bowler order by economical_rate limit " + limit + ";";

}
