package is.rufan.tournament.data;

import is.rufan.tournament.domain.FantasyPlayer;
import is.rufan.tournament.service.FantasyTeamSeriveExeption;

import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public interface FantasyPlayerDataGateway {

    public void addFantasyPlayer(FantasyPlayer fantasyPlayer) throws FantasyTeamSeriveExeption;
    public FantasyPlayer getFantasyPlayer(int playerid, int fantasy_teamid);
    public List<FantasyPlayer> getFantasyPlayers();
    public List<FantasyPlayer> getFantasyPlayerByTeamId(int fantasy_teamid);
}
