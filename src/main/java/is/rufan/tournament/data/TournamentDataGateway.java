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
public interface TournamentDataGateway extends RuDataAccess {

    public void addTournament(Tournament tournament) throws TournamentServiceException;
    public Tournament getTournament(int tournamentid);
    public void closeTournament(int tournamentid);
    public List<Tournament> getTournaments();
    public List<Tournament> getActiveTournaments();
}
