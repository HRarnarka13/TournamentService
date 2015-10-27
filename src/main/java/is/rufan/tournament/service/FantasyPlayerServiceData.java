package is.rufan.tournament.service;

import is.rufan.tournament.data.FantasyPlayerDataGateway;
import is.rufan.tournament.domain.FantasyPlayer;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.List;

/**
 * Created by arnarkari on 27/10/15.
 *
 * @author arnarkari
 */
public class FantasyPlayerServiceData implements FantasyPlayerService {

    RuDataAccessFactory factory;
    FantasyPlayerDataGateway fantasyPlayerDataGateway;

    public FantasyPlayerServiceData() throws RuException {
        factory = RuDataAccessFactory.getInstance("tournamentData.xml");
        fantasyPlayerDataGateway = (FantasyPlayerDataGateway) factory.getDataAccess("fantasyPlayerData");
    }

    public List<FantasyPlayer> getFantasyPlayersByTeamId(int fantasy_teamid) {
        return fantasyPlayerDataGateway.getFantasyPlayerByTeamId(fantasy_teamid);
    }

    public void addFantasyPlayer(FantasyPlayer fantasyPlayer) {
        fantasyPlayerDataGateway.addFantasyPlayer(fantasyPlayer);
    }
}
