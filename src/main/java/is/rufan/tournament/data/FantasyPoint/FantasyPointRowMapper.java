package is.rufan.tournament.data.FantasyPoint;

import is.rufan.tournament.domain.FantasyPoint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by eysteinn on 25/10/15.
 */
public class FantasyPointRowMapper implements RowMapper<FantasyPoint> {


    public FantasyPoint mapRow(ResultSet rs, int i) throws SQLException {
        FantasyPoint fantasyPoint = new FantasyPoint();
        fantasyPoint.setFantasyPoints(rs.getDouble("fantasyPoints"));
        fantasyPoint.setFantasyPointId(rs.getInt("fantasyPointId"));
        fantasyPoint.setPlayerId(rs.getInt("playerId"));
        return fantasyPoint;
    }
}
