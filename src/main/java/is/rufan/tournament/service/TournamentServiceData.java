package is.rufan.tournament.service;

import is.rufan.tournament.domain.Tournament;
import is.ruframework.data.RuDataAccessFactory;

import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class TournamentServiceData implements TournamentService {
    RuDataAccessFactory factory;
    FantasyTeamDataGateway fantasyTeamDataGateway;

    public void addTournament(Tournament tournament) throws TournamentServiceException {

    }

    public List<Tournament> getTournaments() {
        return null;
    }

    public Tournament getTournamentById(int tournamentid) {
        return null;
    }
}
