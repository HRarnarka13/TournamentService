package is.rufan.tournament.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eysteinn on 26/10/15.
 */
public class FantasyTeam {
    private int fantasyTeamId;
    private int userId;
    private List<Integer> players;

    public FantasyTeam() {
        players = new ArrayList<Integer>();
    }

    public FantasyTeam(int fantasyTeamId, int userId, List<Integer> players) {
        this.fantasyTeamId = fantasyTeamId;
        this.userId = userId;
        this.players = players;
    }

    public FantasyTeam(int userId, List<Integer> players) {
        this.userId = userId;
        this.players = players;
    }

    public int getFantasyTeamId() {
        return fantasyTeamId;
    }

    public void setFantasyTeamId(int fantasyTeamId) {
        this.fantasyTeamId = fantasyTeamId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getPlayers() {
        return players;
    }

    public void setPlayers(List<Integer> players) {
        this.players = players;
    }
}
