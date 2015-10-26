package is.rufan.tournament.data;

import is.rufan.tournament.domain.TournamentEnrollment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class TournamentEnrollmentRowMapper implements RowMapper<TournamentEnrollment> {

    public TournamentEnrollment mapRow(ResultSet rs, int rowNum) throws SQLException {

        TournamentEnrollment t = new TournamentEnrollment();
        t.setTournamentid(rs.getInt("tournamentid"));
        t.setTeamId(rs.getInt("fantasy_teamid"));
        t.setScore(rs.getDouble("score"));
        return t;
    }
}
