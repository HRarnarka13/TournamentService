package is.rufan.tournament.data.FantasyTeam;

import is.rufan.tournament.domain.FantasyTeam;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
/**
 * Maps the fantasyTeam entity class to a database table
 */
public class FantasyTeamRowMapper implements RowMapper<FantasyTeam> {

    /**
     * Returns a  instance of the fantasyTeam entity class with values from the database
     * @param rs the results from a query
     * @param rowNum number of rows
     * @return a fantasy team containing information fetched from the database
     * @throws SQLException
     */
    public FantasyTeam mapRow(ResultSet rs, int rowNum) throws SQLException {

        FantasyTeam f = new FantasyTeam();
        f.setFantasyTeamId(rs.getInt("fantasy_teamid"));
        f.setUserId(rs.getInt("userid"));
        f.setIsOpen(rs.getBoolean("isopen"));
        return f;
    }
}
