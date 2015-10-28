package is.rufan.tournament.data.FantasyPlayer;


import is.rufan.tournament.domain.FantasyPlayer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */

/**
 * Maps the fantasyPlayer entity class to a database table
*/
public class FantasyPlayerRowMapper implements RowMapper<FantasyPlayer> {

    /**
     * Returns a instance of the fantasyPlayer entity class with values from the database
     * @param rs the results from a query
     * @param rowNum number of rows
     * @return a fantasy player containing information fetched from the database
     * @throws SQLException
     */
    public FantasyPlayer mapRow(ResultSet rs, int rowNum) throws SQLException {
        FantasyPlayer fp = new FantasyPlayer();
        fp.setFantasy_teamid(rs.getInt("fantasy_teamid"));
        fp.setPlayerid(rs.getInt("playerid"));
        return fp;
    }
}
