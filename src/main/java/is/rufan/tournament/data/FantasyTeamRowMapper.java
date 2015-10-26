package is.rufan.tournament.data;

import is.rufan.tournament.domain.FantasyTeam;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class FantasyTeamRowMapper implements RowMapper<FantasyTeam> {

    public FantasyTeam mapRow(ResultSet rs, int rowNum) throws SQLException {

        FantasyTeam f = new FantasyTeam();
        f.setFantasyTeamId(rs.getInt("fantasy_teamid"));
        f.setUserId(rs.getInt("userid"));
        return f;
    }
}
