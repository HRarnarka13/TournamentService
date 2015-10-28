package is.rufan.tournament.service.Tournament;

import is.rufan.tournament.domain.FantasyTeam;
import is.rufan.tournament.domain.Tournament;

import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public interface TournamentService {

    public int addTournament(Tournament tournament) throws  TournamentServiceException;
    public List<Tournament> getTournaments();
    public List<Tournament> getActiveTournaments();
    public List<Integer> getTournamentGames(int tournamentId);
    public Tournament getTournamentById(int tournamentId);
    public List<FantasyTeam> getFantasyTeamsByTournamentId(int tournamentid);
    public void addEnrollment(int tournamentId, int teamId);
<<<<<<< HEAD
    public void setScore(int tournamentId, int teamId, double score);
=======
    public void closeTournament(int tournamentid);
>>>>>>> 9dc364a93b20ea09d5ecabacac04791601d50d6e
}
