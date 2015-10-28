package is.rufan.tournament.service.FantasyPoint;


import is.rufan.tournament.domain.FantasyPoint;

import java.util.List;

/**
 * Created by eysteinn on 25/10/15.
 */
public interface FantasyPointService {
    FantasyPoint getFantasyPointByPlayerId(int playerId);
    FantasyPoint getFantasyPointById(int fantasyPointId);
    List<FantasyPoint> getFantasyPoints();
    void addFantasyPoint(FantasyPoint fantasyPoint) throws FantasyPointException;
}
