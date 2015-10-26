package is.rufan.tournament.data;

import is.rufan.tournament.domain.TournamentGame;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by eysteinn on 26/10/15.
 */
public interface TournamentGameDataGateway extends RuDataAccess{
    public void addGame(TournamentGame game);
    public List<Integer> getGamesByTournamentId(int tournamentId);
}
