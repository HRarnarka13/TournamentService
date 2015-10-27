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
public class TournamentData extends RuData implements  TournamentDataGateway {

    public int addTournament(Tournament tournament) throws TournamentServiceException {
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
            return insertTournament.executeAndReturnKey(tournamentParameters).intValue();
        }
        catch (DataIntegrityViolationException divex)
        {
            String msg = "Duplicate entry";
            log.warning(msg);
            return -1;
        }
    }

    public Tournament getTournament(int tournamentid) {
        String sql = "Select * from tournaments where tournamentId = ?";
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

    public void closeTournament(int tournamentid) {
        String sql = "Update tournaments Set status = 0 WHERE tournamentId = ?";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        query.update(sql, tournamentid);
    }

    public List<Tournament> getTournaments() {
        String sql = "Select * from tournaments";
        JdbcTemplate query = new JdbcTemplate(getDataSource());

        List<Tournament> tournaments = query.query(sql, new TournamentRowMapper());

        return tournaments;

    }

    public List<Tournament> getActiveTournaments() {
        String sql = "SELECT * FROM tournaments WHERE status = 1";
        JdbcTemplate query = new JdbcTemplate(getDataSource());

        List<Tournament> tournaments = query.query(sql, new TournamentRowMapper());
        return tournaments;
    }

}
