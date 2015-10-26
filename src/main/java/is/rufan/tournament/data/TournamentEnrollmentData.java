package is.rufan.tournament.data;

import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.domain.TournamentEnrollment;
import is.rufan.tournament.service.TournamentService;
import is.rufan.tournament.service.TournamentServiceException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eysteinn on 26/10/15.
 */
public class TournamentEnrollmentData extends RuData implements TournamentEnrollmentDataGateway {

    public void addEnrollment(TournamentEnrollment enrollment) {
        SimpleJdbcInsert insertEnrollment = new SimpleJdbcInsert(getDataSource())
                .withTableName("tournament_enrollments");

        Map<String, Object> parameters = new HashMap<String, Object>(4);
        parameters.put("teamId", enrollment.getTeamId());
        parameters.put("tournamentId", enrollment.getTournamentid());
        parameters.put("score", enrollment.getScore());

        try
        {
            insertEnrollment.execute(parameters);
        }
        catch (DataIntegrityViolationException divx)
        {
            String msg = "Duplicate entry";
            log.warning(msg);
        }
    }

    public List<TournamentEnrollment> getEnrollments() {
        String sql = "SELECT * from tournament_enrollments";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        List<TournamentEnrollment> tournamentEnrollments = query.query(sql, new TournamentEnrollmentRowMapper());
        return tournamentEnrollments;
    }

    public List<TournamentEnrollment> getEnrollmentsByTournamentId(int tournamentId) {
        String sql = "SELECT * from tournament_enrollments WHERE tournamentID = ?";
        JdbcTemplate query = new JdbcTemplate(getDataSource());

        try
        {
            List<TournamentEnrollment> enrollments = query.query(sql, new TournamentEnrollmentRowMapper(), tournamentId);
            return enrollments;
        }
        catch (EmptyResultDataAccessException ex)
        {
            String msg = "Empty result";
            log.warning(msg);
            return null;
        }
    }

    /**
     * Returns all tournament enrollments for a specific team.
     * @param teamId
     * @return
     */
    public List<TournamentEnrollment> getEnrollmentsByTeamId(int teamId) {
        String sql = "SELECT * FROM tournament_enrollments WHERE teamId = ?";
        JdbcTemplate query = new JdbcTemplate(getDataSource());

        try
        {
            List<TournamentEnrollment> enrollments = query.query(sql, new TournamentEnrollmentRowMapper(), teamId);
            return enrollments;
        }
        catch (EmptyResultDataAccessException ex)
        {
            String msg = "Empty result";
            log.warning(msg);
            return null;
        }
    }
}
