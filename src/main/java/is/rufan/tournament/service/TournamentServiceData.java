package is.rufan.tournament.service;

import is.rufan.tournament.data.TournamentDataGateway;
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
    TournamentDataGateway tournamentDataGateway;
    public void addTournament(Tournament tournament) throws TournamentServiceException {
        tournamentDataGateway.addTournament(tournament);
    }

    public List<Tournament> getTournaments() {
        return tournamentDataGateway.getTournaments();
    }

    public Tournament getTournamentById(int tournamentid) {
        return null;
    }
}
