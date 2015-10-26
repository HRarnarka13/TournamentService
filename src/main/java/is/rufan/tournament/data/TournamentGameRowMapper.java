package is.rufan.tournament.data;

import is.rufan.tournament.domain.TournamentGame;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class TournamentGameRowMapper implements RowMapper<TournamentGame> {

    public TournamentGame mapRow(ResultSet rs, int rowNum) throws SQLException {
        TournamentGame tg = new TournamentGame();
        tg.setGameid(rs.getInt("gameid"));
        tg.setTournament(rs.getInt("tournamentid"));
        return tg;
    }
}
