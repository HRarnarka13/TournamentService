package is.rufan.tournament.service.FantasyTeam;

import is.rufan.tournament.data.FantasyPlayer.FantasyPlayerDataGateway;
import is.rufan.tournament.data.FantasyTeam.FantasyTeamDataGateway;
import is.rufan.tournament.domain.FantasyPlayer;
import is.rufan.tournament.domain.FantasyTeam;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnarkari on 27/10/15.
 *
 * @author arnarkari
 */
public class FantasyTeamServiceData implements FantasyTeamService {

    RuDataAccessFactory factory;
    FantasyTeamDataGateway fantasyTeamDataGateway;
    FantasyPlayerDataGateway fantasyPlayerDataGateway;

    public FantasyTeamServiceData() throws RuException  {
        factory = RuDataAccessFactory.getInstance("tournamentData.xml");
        fantasyTeamDataGateway = (FantasyTeamDataGateway) factory.getDataAccess("fantasyTeamData");
        fantasyPlayerDataGateway = (FantasyPlayerDataGateway) factory.getDataAccess("fantasyPlayerData");
    }

    public int getUserId(int fantasy_teamid) {
        FantasyTeam ft = fantasyTeamDataGateway.getFantasyTeam(fantasy_teamid);
        return ft.getUserId();
    }

    public FantasyTeam getFantasyTeam(int fantasy_teamid) {
        FantasyTeam fantasyTeam = fantasyTeamDataGateway.getFantasyTeam(fantasy_teamid);
        List<FantasyPlayer> fplayers = fantasyPlayerDataGateway.getFantasyPlayersByTeamId(fantasy_teamid);
        List<Integer> players = new ArrayList<Integer>();
        for (FantasyPlayer fp : fplayers) {
            players.add(fp.getPlayerid());
        }
        fantasyTeam.setPlayers(players);
        return fantasyTeam;
    }

    public List<FantasyTeam> getFantasyTeamByUserId(int userId) {
        return fantasyTeamDataGateway.getFantasyTeamsByUserId(userId);
    }

    /**
     * Creates a new fantasy team for a given user
     * @param userid user id
     * @param playerids list of player id's
     * @return id of the new fantasy team
     */
    public int addFantasyTeam(int userid, List<Integer> playerids) {
        int fantasy_teamid = fantasyTeamDataGateway.addFantasyTeam(userid);
        for (Integer playerid : playerids) {
            fantasyPlayerDataGateway.addFantasyPlayer(new FantasyPlayer(playerid, fantasy_teamid));
        }
        return fantasy_teamid;
    }
}
