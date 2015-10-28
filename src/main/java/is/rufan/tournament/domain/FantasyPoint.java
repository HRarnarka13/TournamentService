package is.rufan.tournament.domain;

/**
 * Created by eysteinn on 25/10/15.
 */
public class FantasyPoint {
    private int fantasyPointId;
    private int playerId;
    private double fantasyPoints;

    public FantasyPoint() {
    }
    public FantasyPoint(int fantasyPointId, int playerId, double fantasyPoints) {
        this.fantasyPointId = fantasyPointId;
        this.playerId = playerId;
        this.fantasyPoints = fantasyPoints;
    }
    public FantasyPoint(int playerId, double fantasyPoint) {

        this.playerId = playerId;
        this.fantasyPoints = fantasyPoint;
    }
    public int getFantasyPointId() {
    
        return fantasyPointId;
    }

    public void setFantasyPointId(int fantasyPointId) {
        this.fantasyPointId = fantasyPointId;
    }




    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public double getFantasyPoints() {
        return fantasyPoints;
    }

    public void setFantasyPoints(double fantasyPoints) {
        this.fantasyPoints = fantasyPoints;
    }

}
