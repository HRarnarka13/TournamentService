package is.rufan.tournament.data;

import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.service.TournamentServiceException;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
/**
 * A interface containing functions that our datalayer has to implement
 */
public interface TournamentDataGateway extends RuDataAccess {


    /**
     * Adds a new tournament to the database
     * @param tournament the tournament to be added
     * @throws TournamentServiceException
     */
    public void addTournament(Tournament tournament) throws TournamentServiceException;
    /**
     * Get a tournament by id
     * @param tournamentid the id of the tournament
     * @return a tournament with a specific id
     */
    public Tournament getTournament(int tournamentid);
    /**
     * Close a specific tournament. We dont delete it since it may contain valuable records, so its marked as inactive
     * @param tournamentid the tournament to be closed
     */
    public void closeTournament(int tournamentid);
    /**
     * Gets all tournaments in the system
     * @return a list of tournaments
     */
    public List<Tournament> getTournaments();
    /**
     * Get all tournaments that are active, i.e have not been closed.
     * @return all active tournaments
     */
    public List<Tournament> getActiveTournaments();
}
