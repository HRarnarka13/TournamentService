package is.rufan.tournament.data;

import is.rufan.tournament.domain.TournamentGame;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by eysteinn on 26/10/15.
 */
/**
 * A interface containing functions that our datalayer has to implement
 */
public interface TournamentGameDataGateway extends RuDataAccess{
    /**
     * Adds a new tournamentGame to the system
     * @param game the game to be added
     */
    public void addGame(TournamentGame game);
    /**
     * Gets all games in a specifc tournament
     * @param tournamentId the id of the tournament
     * @return games in a specific tournament
     */
    public List<Integer> getGamesByTournamentId(int tournamentId);
}
