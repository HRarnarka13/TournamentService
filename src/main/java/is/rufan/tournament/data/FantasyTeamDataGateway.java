package is.rufan.tournament.data;

import is.rufan.tournament.domain.FantasyTeam;
import is.rufan.tournament.service.FantasyTeamSeriveExeption;

import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public interface FantasyTeamDataGateway {

    public int addFantasyTeam(int userid) throws FantasyTeamSeriveExeption;
    public FantasyTeam getFantasyTeam(int fantasy_teamid);
    public List<FantasyTeam> getFantasyTeams();
}
