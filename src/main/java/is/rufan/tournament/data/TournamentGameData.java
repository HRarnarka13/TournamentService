package is.rufan.tournament.data;

import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.domain.TournamentGame;
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
/**
 * A class implementing TournamentGameDataGateway.
 * Contains functionality for interacting with a SQL database
 */
public class TournamentGameData extends RuData implements TournamentGameDataGateway {
    /**
     * Adds a new tournamentGame to the system
     * @param game the game to be added
     */
    public void addGame(TournamentGame game) {
        SimpleJdbcInsert insertGame =
                new SimpleJdbcInsert(getDataSource())
                .withTableName("tournament_games");

        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("gameId", game.getGameid());
        parameters.put("tournamentId", game.getTournament());

        try
        {
            insertGame.execute(parameters);
        }
        catch(DataIntegrityViolationException divex)
        {
            String msg = "Duplicate entry";
            log.warning(msg);
        }
    }

    /**
     * Gets all games in a specifc tournament
     * @param tournamentId the id of the tournament
     * @return games in a specific tournament
     */
    public List<Integer> getGamesByTournamentId(int tournamentId) {
        String sql = "Select gameId from tournament_games where tournamentId = ?";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        try
        {
            List<Integer> games = (List<Integer>) query.queryForList(sql, Integer.class, tournamentId);
            return games;
        }
        catch(EmptyResultDataAccessException ex)
        {
            String msg = "Empty result";
            log.warning(msg);
            return null;
        }
    }
}
