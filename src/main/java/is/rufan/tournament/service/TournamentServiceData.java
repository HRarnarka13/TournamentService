package is.rufan.tournament.service;

import is.rufan.tournament.data.TournamentDataGateway;
import is.rufan.tournament.data.TournamentGameData;
import is.rufan.tournament.data.TournamentGameDataGateway;
import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.domain.TournamentGame;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class TournamentServiceData implements TournamentService {
    RuDataAccessFactory factory;
    TournamentDataGateway tournamentDataGateway;
    TournamentGameDataGateway gameDataGateway;

    public TournamentServiceData() throws RuException {
        factory = RuDataAccessFactory.getInstance("tournamentData.xml");
        tournamentDataGateway = (TournamentDataGateway) factory.getDataAccess("tournamentData");
        gameDataGateway = (TournamentGameDataGateway) factory.getDataAccess("gameData");
    }

    /*
      public TeamServiceData() throws RuException
  {
    factory = RuDataAccessFactory.getInstance("teamdata.xml");
    teamDataGateway = (TeamDataGateway) factory.getDataAccess("teamData");
    venueDataGateway = (VenueDataGateway) factory.getDataAccess("venueData");

  }

     */

    public void addTournament(Tournament tournament) throws TournamentServiceException {
        tournamentDataGateway.addTournament(tournament);
    }

    public List<Tournament> getTournaments() {
        return tournamentDataGateway.getTournaments();
    }

    public List<Tournament> getActiveTournaments() {
        return tournamentDataGateway.getActiveTournaments();
    }

    public List<Integer> getTournamentGames(int tournamentId) {
        return gameDataGateway.getGamesByTournamentId(tournamentId);
    }

    public Tournament getTournamentById(int tournamentId) {
        return tournamentDataGateway.getTournament(tournamentId);
    }
}
