package is.rufan.tournament.data;

import is.rufan.tournament.domain.TournamentEnrollment;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by eysteinn on 26/10/15.
 */
/**
 * A interface containing functions that our datalayer has to implement
 */
public interface TournamentEnrollmentDataGateway extends RuDataAccess {
    /**
     * Add a new TournamentEnrollment to the database
     * @param enrollment the enrollment to be added
     */
    public void addEnrollment(TournamentEnrollment enrollment);
    /**
     * Gets all TournamentEnrollments in the system
     * @return a list of TournamentEnrollments
     */
    public List<TournamentEnrollment> getEnrollments();
    /**
     * Gets all enrollments for a specific tournament
     * @param tournamentId the id of the tournament
     * @return a list of enrollments in the tournament
     */
    public List<TournamentEnrollment> getEnrollmentsByTournamentId(int tournamentId);
    /**
     * Returns all tournament enrollments for a specific team.
     * @param teamId
     * @return a list of enrollments for a specific team
     */
    public List<TournamentEnrollment> getEnrollmentsByTeamId(int teamId);

}
