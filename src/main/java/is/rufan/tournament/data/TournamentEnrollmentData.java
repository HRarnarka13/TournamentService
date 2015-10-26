package is.rufan.tournament.data;

import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.domain.TournamentEnrollment;
import is.rufan.tournament.service.TournamentService;
import is.rufan.tournament.service.TournamentServiceException;
import is.ruframework.data.RuData;

import java.util.List;

/**
 * Created by eysteinn on 26/10/15.
 */
public class TournamentEnrollmentData extends RuData implements TournamentEnrollmentDataGateway {

    public void addEnrollment(TournamentEnrollment enrollment) {

    }

    public double getScore(TournamentEnrollment enrollment) {
        return 0;
    }

    public List<TournamentEnrollment> getEnrollments() {
        return null;
    }

    public List<TournamentEnrollment> getEnrollmentsByTournamentId(int tournamentId) {
        return null;
    }

    public List<TournamentEnrollment> getEnrollmentsByTeamId(int teamId) {
        return null;
    }
}
