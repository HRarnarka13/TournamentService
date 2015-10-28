package is.rufan.tournament.data.FantasyTeam;

import is.rufan.tournament.domain.FantasyTeam;
import is.rufan.tournament.service.FantasyTeam.FantasyTeamSeriveExeption;

import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
/**
 * A interface containing functions that our datalayer has to implement
 */
public interface FantasyTeamDataGateway {

    /**
     * Adds a new fantasyTeam to the database.
     * @param userid userid
     * @throws FantasyTeamSeriveExeption
     */
    public int addFantasyTeam(int userid) throws FantasyTeamSeriveExeption;
    /**
     * Gets a specific fantasy team
     * @param fantasy_teamid the id of the team
     * @return a fantasy team with a specific id
     */
    public FantasyTeam getFantasyTeam(int fantasy_teamid);
    /**
     * Gets all fantasy teams in the system
     * @return a list containing all fantasy teams
     */
    public List<FantasyTeam> getFantasyTeams();

    /**
     * Gets all teams for a given user
     * @param userId
     * @return
     */
    public List<FantasyTeam> getFantasyTeamsByUserId(int userId);
}
