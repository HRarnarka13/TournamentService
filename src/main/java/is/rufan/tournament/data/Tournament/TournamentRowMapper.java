package is.rufan.tournament.data.Tournament;

import is.rufan.tournament.domain.Tournament;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
/**
 * Maps the Tournament entity class to a database table
 */
public class TournamentRowMapper implements RowMapper<Tournament> {
    /**
     * Returns a instance of the Tournament entity class with values from the database
     * @param rs the results from a query
     * @param rowNum number of rows
     * @return a tournament containing information fetched from the database
     * @throws SQLException
     */
    public Tournament mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tournament tournament = new Tournament();
        tournament.setTournamentid(rs.getInt("tournamentid"));
        tournament.setName(rs.getString("name"));
        tournament.setStartTime(rs.getDate("start_time"));
        tournament.setEndTime(rs.getDate("end_time"));
        tournament.setEntryFee(rs.getDouble("entry_fee"));
        tournament.setMaxEntries(rs.getInt("maxentries"));
        tournament.setStatus(rs.getBoolean("status"));
        return tournament;
    }
}
