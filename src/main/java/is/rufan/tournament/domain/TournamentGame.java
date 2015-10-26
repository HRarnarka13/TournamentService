package is.rufan.tournament.domain;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class TournamentGame {

    private int gameid;
    private int tournament;

    public TournamentGame() {
    }

    public TournamentGame(int gameid, int tournament) {
        this.gameid = gameid;
        this.tournament = tournament;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getTournament() {
        return tournament;
    }

    public void setTournament(int tournament) {
        this.tournament = tournament;
    }
}
