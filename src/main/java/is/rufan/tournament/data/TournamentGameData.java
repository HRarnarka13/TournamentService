package is.rufan.tournament.data;

import is.rufan.tournament.domain.TournamentGame;
import is.ruframework.data.RuData;

import java.util.List;

/**
 * Created by eysteinn on 26/10/15.
 */
public class TournamentGameData extends RuData implements TournamentGameDataGateway {
    public void addGame(TournamentGame game) {
        
    }

    public List<TournamentGame> getGamesByTournamentId(int tournamentId) {
        return null;
    }

    public List<TournamentGame> getTournamentsForGame(int gameid) {
        return null;
    }
}
