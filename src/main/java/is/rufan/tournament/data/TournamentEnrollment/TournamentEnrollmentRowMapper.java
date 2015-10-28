package is.rufan.tournament.data.TournamentEnrollment;

import is.rufan.tournament.domain.TournamentEnrollment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
/**
 * Maps the TournamentEnrollment entity class to a database table
 */
public class TournamentEnrollmentRowMapper implements RowMapper<TournamentEnrollment> {

    /**
     * Returns a instance of the tournamentEnrollment entity class with values from the database
     * @param rs the results from a query
     * @param rowNum number of rows
     * @return a tournamentEnrollment containing information fetched from the database
     * @throws SQLException
     */
    public TournamentEnrollment mapRow(ResultSet rs, int rowNum) throws SQLException {

        TournamentEnrollment t = new TournamentEnrollment();
        t.setTournamentid(rs.getInt("tournamentid"));
        t.setTeamId(rs.getInt("fantasy_teamid"));
        t.setScore(rs.getDouble("score"));
        return t;
    }
}
