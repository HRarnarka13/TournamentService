package is.rufan.tournament.data;


import is.rufan.tournament.domain.FantasyPlayer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class FantasyPlayerRowMapper implements RowMapper<FantasyPlayer> {

    public FantasyPlayer mapRow(ResultSet rs, int rowNum) throws SQLException {
        FantasyPlayer fp = new FantasyPlayer();
        fp.setFantasy_teamid(rs.getInt("fantasy_teamid"));
        fp.setPlayerid(rs.getInt("playerid"));
        return fp;
    }
}
