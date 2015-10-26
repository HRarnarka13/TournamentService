package is.rufan.tournament.domain;

/**
 * Created by eysteinn on 26/10/15.
 */
public class TournamentEnrollment {
    private int userId;
    private int teamId;
    private double score;

    public TournamentEnrollment() {

    }

    public TournamentEnrollment(int userId, int teamId, double score) {

        this.userId = userId;
        this.teamId = teamId;
        this.score = score;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
