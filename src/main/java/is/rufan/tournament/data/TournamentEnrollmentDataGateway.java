package is.rufan.tournament.data;

import is.rufan.tournament.domain.TournamentEnrollment;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by eysteinn on 26/10/15.
 */
public interface TournamentEnrollmentDataGateway extends RuDataAccess {
    public void addEnrollment(TournamentEnrollment enrollment);
    public double getScore(TournamentEnrollment enrollment);
    public List<TournamentEnrollment> getEnrollments();
    public List<TournamentEnrollment> getEnrollmentsByTournamentId(int tournamentId);
    public List<TournamentEnrollment> getEnrollmentsByTeamId(int teamId);

}
