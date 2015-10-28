package is.rufan.tournament.data.FantasyPoint;

import is.rufan.tournament.domain.FantasyPoint;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eysteinn on 25/10/15.
 */
public class FantasyPointData extends RuData implements FantasyPointDataGateway {


    public void addFantasyPoint(FantasyPoint fantasyPoint) {
        SimpleJdbcInsert insertFantasyPoint =
                new SimpleJdbcInsert(getDataSource()).withTableName("fantasypoints")
                .usingGeneratedKeyColumns("fantasyPointId");
        Map<String, Object> fantasyPointParameters = new HashMap<String, Object>(3);
        fantasyPointParameters.put("playerId", fantasyPoint.getPlayerId());
        fantasyPointParameters.put("fantasyPoints", fantasyPoint.getFantasyPoints());

        try
        {
            insertFantasyPoint.execute(fantasyPointParameters);
        }
        catch (DataIntegrityViolationException divex)
        {
            log.warning("Duplicate entry");
        }

    }

    public List<FantasyPoint> getFantasyPoints() {
        String sql = "select * from fantasyPoints";
        JdbcTemplate queryFantasyPoints = new JdbcTemplate(getDataSource());
        List<FantasyPoint> fantasyPoints = queryFantasyPoints.query(sql, new FantasyPointRowMapper());
        return fantasyPoints;
    }

    public FantasyPoint getFantasyPointById(int fantasyPointId) {
        String sql = "Select * from fantasyPoints where fantasyPointId = ?";
        JdbcTemplate queryFantasyPoints = new JdbcTemplate(getDataSource());
        FantasyPoint fantasyPoint = queryFantasyPoints.queryForObject(sql, new Object[]{fantasyPointId}, new FantasyPointRowMapper());

        return fantasyPoint;
    }

    public FantasyPoint getFantasyPointByPlayerId(int playerId) {
        String sql = "Select *  from fantasyPoints where playerId = ?";
        JdbcTemplate queryFantasyPoints = new JdbcTemplate(getDataSource());
        try {
            FantasyPoint fantasyPoint = queryFantasyPoints.queryForObject(sql, new Object[]{ playerId }, new FantasyPointRowMapper());
            return fantasyPoint;
        } catch (EmptyResultDataAccessException ex ){
            return null;
        }
    }


}
