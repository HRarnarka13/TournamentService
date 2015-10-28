package is.rufan.tournament.service.FantasyPlayer;

import is.rufan.tournament.domain.FantasyPlayer;

import java.util.List;

/**
 * Created by arnarkari on 27/10/15.
 *
 * @author arnarkari
 */
public interface FantasyPlayerService {

    public List<FantasyPlayer> getFantasyPlayersByTeamId(int fantasy_teamid);
    public void addFantasyPlayer(FantasyPlayer fantasyPlayer);
}
