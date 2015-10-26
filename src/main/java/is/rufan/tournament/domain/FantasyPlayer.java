package is.rufan.tournament.domain;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class FantasyPlayer {

    private int playerid;
    private int fantasy_teamid;

    public FantasyPlayer() {
    }

    public FantasyPlayer(int playerid, int fantasy_teamid) {
        this.playerid = playerid;
        this.fantasy_teamid = fantasy_teamid;
    }

    public int getFantasy_teamid() {
        return fantasy_teamid;
    }

    public void setFantasy_teamid(int fantasy_teamid) {
        this.fantasy_teamid = fantasy_teamid;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }
}
