package is.rufan.tournament.service;

import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.domain.TournamentGame;

import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public interface TournamentService {

    public void addTournament(Tournament tournament) throws  TournamentServiceException;
    public List<Tournament> getTournaments();
    public List<Tournament> getActiveTournaments();
    public List<Integer> getTournamentGames(int tournamentId);
    public Tournament getTournamentById(int tournamentId);
}
