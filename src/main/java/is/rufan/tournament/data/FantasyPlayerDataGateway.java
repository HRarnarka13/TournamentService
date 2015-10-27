package is.rufan.tournament.data;

import is.rufan.tournament.domain.FantasyPlayer;
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
public interface FantasyPlayerDataGateway {


    /**
     * Adds a real football player to a Users fantasy team
     * @param fantasyPlayer Player containing both fantasy teamid and playerId
     * @throws FantasyTeamSeriveExeption
     */
    public void addFantasyPlayer(FantasyPlayer fantasyPlayer) throws FantasyTeamSeriveExeption;

    /**
     * Gets all fantasy players, i.e all players that are in some fantasy team
     * @return A list of fantasy players
     */
    public List<FantasyPlayer> getFantasyPlayers();

    /**
     * Gets all players in a specifc fantasy team.
     * @param fantasy_teamid The id of the fantasy team
     * @return  A list of fantasy players in a specific team
     */
    public List<FantasyPlayer> getFantasyPlayerByTeamId(int fantasy_teamid);
}
