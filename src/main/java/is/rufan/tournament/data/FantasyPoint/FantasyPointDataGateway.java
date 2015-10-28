package is.rufan.tournament.data.FantasyPoint;


import is.rufan.tournament.domain.FantasyPoint;

import java.util.List;

/**
 * Created by eysteinn on 25/10/15.
 */
public interface FantasyPointDataGateway {
    public void addFantasyPoint(FantasyPoint fantasyPoint);
    public List<FantasyPoint> getFantasyPoints();
    public FantasyPoint getFantasyPointById(int fantasyPointId);
    public FantasyPoint getFantasyPointByPlayerId(int playerId);
}
