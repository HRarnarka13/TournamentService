package is.rufan.tournament.service;

import is.rufan.tournament.data.*;
import is.rufan.tournament.domain.FantasyTeam;
import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.domain.TournamentEnrollment;
import is.rufan.tournament.domain.TournamentGame;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class TournamentServiceData implements TournamentService {
    RuDataAccessFactory factory;
    TournamentGameDataGateway gameDataGateway;
    TournamentEnrollmentDataGateway tournamentEnrollmentDataGateway;

    TournamentDataGateway tournamentDataGateway;
    FantasyTeamDataGateway fantasyTeamDataGateway;

    public TournamentServiceData() throws RuException {
        factory = RuDataAccessFactory.getInstance("tournamentData.xml");
        tournamentDataGateway = (TournamentDataGateway) factory.getDataAccess("tournamentData");
        gameDataGateway = (TournamentGameDataGateway) factory.getDataAccess("gameData");

        fantasyTeamDataGateway = (FantasyTeamDataGateway) factory.getDataAccess("fantasyTeamData");
    }

    public int addTournament(Tournament tournament) throws TournamentServiceException {
        int tournamentid =  tournamentDataGateway.addTournament(tournament);
        if (tournamentid != -1) {
            for (Integer gameid : tournament.getTournamentGames()) {
                gameDataGateway.addGame(new TournamentGame(gameid, tournamentid));
            }
        }
        return tournamentid;
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

    public List<FantasyTeam> getFantasyTeamsByTournamentId(int tournamentid) {
        // Get the tournament
        Tournament t = tournamentDataGateway.getTournament(tournamentid);
        List<FantasyTeam> fantasyTeams = new ArrayList<FantasyTeam>();
        // For each enrollment get the fantasy team
        for (TournamentEnrollment te : t.getEnrollments()) {
            fantasyTeams.add(fantasyTeamDataGateway.getFantasyTeam(te.getTeamId()));
        }
        return fantasyTeams;
    }

    public void addEnrollment(int userId, int teamId) {
        TournamentEnrollment tm = new TournamentEnrollment(userId, teamId, 0);
        tournamentEnrollmentDataGateway.addEnrollment(tm);
    }
}
