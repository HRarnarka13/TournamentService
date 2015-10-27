package is.rufan.tournament.data;

import is.rufan.tournament.domain.Tournament;
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
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
/**
 * A class implementing TournamentDataGateway.
 * Contains functionality for interacting with a SQL database
 */
public class TournamentData extends RuData implements  TournamentDataGateway {

    /**
     * Adds a new tournament to the database
     * @param tournament the tournament to be added
     * @throws TournamentServiceException
     */
    public void addTournament(Tournament tournament) throws TournamentServiceException {
        SimpleJdbcInsert insertTournament =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("tournaments")
                        .usingGeneratedKeyColumns("tournamentid");

        Map<String, Object> tournamentParameters = new HashMap<String, Object>(10);
        tournamentParameters.put("name", tournament.getName());
        tournamentParameters.put("entry_fee", tournament.getEntryFee());
        tournamentParameters.put("start_time", tournament.getStartTime());
        tournamentParameters.put("end_time", tournament.getEndTime());
        tournamentParameters.put("status", tournament.isStatus());
        tournamentParameters.put("maxentries", tournament.getMaxEntries());

        try
        {
            insertTournament.execute(tournamentParameters);
        }
        catch (DataIntegrityViolationException divex)
        {
            String msg = "Duplicate entry";
            log.warning(msg);
        }
    }

    /**
     * Get a tournament by id
     * @param tournamentid the id of the tournament
     * @return a tournament with a specific id
     */
    public Tournament getTournament(int tournamentid) {
        String sql = "Select * from tournaments where id = ?";
        JdbcTemplate queryTournament = new JdbcTemplate(getDataSource());

        try
        {
            Tournament tournament = queryTournament.queryForObject(sql, new Object[]{tournamentid},
                    new TournamentRowMapper());
            return tournament;
        }
        catch (EmptyResultDataAccessException erdax)
        {
            return null;
        }
    }

    /**
     * Close a specific tournament. We dont delete it since it may contain valuable records, so its marked as inactive
     * @param tournamentid the tournament to be closed
     */
    public void closeTournament(int tournamentid) {
        String sql = "Update tournaments Set status = 0 WHERE tournamentId = ?";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        query.update(sql, tournamentid);
    }

    /**
     * Gets all tournaments in the system
     * @return a list of tournaments
     */
    public List<Tournament> getTournaments() {
        String sql = "Select * from tournaments";
        JdbcTemplate query = new JdbcTemplate(getDataSource());

        List<Tournament> tournaments = query.query(sql, new TournamentRowMapper());

        return tournaments;

    }

    /**
     * Get all tournaments that are active, i.e have not been closed.
     * @return all active tournaments
     */
    public List<Tournament> getActiveTournaments() {
        String sql = "SELECT * FROM tournaments WHERE status = 1";
        JdbcTemplate query = new JdbcTemplate(getDataSource());

        List<Tournament> tournaments = query.query(sql, new TournamentRowMapper());
        return tournaments;
    }

}
