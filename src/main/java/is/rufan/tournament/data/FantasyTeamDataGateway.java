package is.rufan.tournament.data;

import is.rufan.tournament.domain.FantasyTeam;
import is.rufan.tournament.service.FantasyTeamSeriveExeption;

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
}
