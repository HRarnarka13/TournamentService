package is.rufan.tournament.data;

import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.service.TournamentServiceException;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class TournamentData extends RuData implements  TournamentDataGateway {

    public void addTournament(Tournament tournament) throws TournamentServiceException {

    }

    public Tournament getTournament(int tournamentid) {
        return null;
    }
}
