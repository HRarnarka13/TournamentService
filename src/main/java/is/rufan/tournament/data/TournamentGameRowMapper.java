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
/**
 * Maps the fantasyPlayer entity class to a database table
 */
public class TournamentGameRowMapper implements RowMapper<TournamentGame> {

    /**
     * Returns a instance of the TournamentGame  entity class with values from the database
     * @param rs the results from a query
     * @param rowNum number of rows
     * @return tournamentGame containing information fetched from the database
     * @throws SQLException
     */
    public TournamentGame mapRow(ResultSet rs, int rowNum) throws SQLException {
        TournamentGame tg = new TournamentGame();
        tg.setGameid(rs.getInt("gameid"));
        tg.setTournament(rs.getInt("tournamentid"));
        return tg;
    }
}
