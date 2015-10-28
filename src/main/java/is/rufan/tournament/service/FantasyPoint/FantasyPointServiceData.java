package is.rufan.tournament.service.FantasyPoint;


import is.rufan.tournament.data.FantasyPoint.FantasyPointDataGateway;
import is.rufan.tournament.domain.FantasyPoint;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.List;

/**
 * Created by eysteinn on 25/10/15.
 */
public class FantasyPointServiceData implements FantasyPointService {


    RuDataAccessFactory factory;
    FantasyPointDataGateway fantasyPointDataGateway;

    public FantasyPointServiceData() throws RuException {
        factory = RuDataAccessFactory.getInstance("tournamentData.xml");
        fantasyPointDataGateway = (FantasyPointDataGateway) factory.getDataAccess("fantasyPointData");
    }

    public void addFantasyPoint(FantasyPoint fantasyPoint) throws FantasyPointException {
        fantasyPointDataGateway.addFantasyPoint(fantasyPoint);
    }

    public FantasyPoint getFantasyPointByPlayerId(int playerId) {
        return fantasyPointDataGateway.getFantasyPointByPlayerId(playerId);
    }

    public FantasyPoint getFantasyPointById(int fantasyPointId) {
        return fantasyPointDataGateway.getFantasyPointById(fantasyPointId);
    }

    public List<FantasyPoint> getFantasyPoints() {
        return fantasyPointDataGateway.getFantasyPoints();
    }
}
