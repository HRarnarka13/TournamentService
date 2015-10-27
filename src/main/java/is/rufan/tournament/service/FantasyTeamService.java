package is.rufan.tournament.service;

import is.rufan.tournament.domain.FantasyTeam;

import java.util.List;

/**
 * Created by arnarkari on 27/10/15.
 *
 * @author arnarkari
 */
public interface FantasyTeamService {

    public int getUserId(int fantasy_teamid);
    public FantasyTeam getFantasyTeam(int fantasy_teamid);
    public List<FantasyTeam> getFantasyTeamByUserId(int userId);
    public int addFantasyTeam(int userid, List<Integer> playerids);

}
