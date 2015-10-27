package is.rufan.tournament.data;

import is.rufan.tournament.domain.FantasyTeam;
import is.rufan.tournament.service.FantasyTeamSeriveExeption;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class FantasyTeamData extends RuData implements FantasyTeamDataGateway {

    public int addFantasyTeam(int userid) throws FantasyTeamSeriveExeption {
        SimpleJdbcInsert insertFantasyTeam  = new SimpleJdbcInsert(getDataSource())
                .withTableName("fantasy_team")
                .usingGeneratedKeyColumns("fantasy_teamid");

        Map<String, Object> fantasyTeamParameters = new HashMap<String, Object>(2);
        fantasyTeamParameters.put("userid", userid);

        try {
            return insertFantasyTeam.executeAndReturnKey(fantasyTeamParameters).intValue();
        } catch (DataIntegrityViolationException divex) {
            log.warning("Duplicate entry");
            return -1;
        }

    }

    public FantasyTeam getFantasyTeam(int fantasy_teamid) {

        String sql = "Select * from fantasy_teams where fantasy_teamid = ?";
        JdbcTemplate queryFantasyTeam = new JdbcTemplate(getDataSource());

        try {
            FantasyTeam fantasyTeam = queryFantasyTeam.queryForObject(sql, new Object[]{ fantasy_teamid },
                    new FantasyTeamRowMapper());
            return fantasyTeam;
        } catch (EmptyResultDataAccessException erdaex) {
            return null;
        }
    }

    public List<FantasyTeam> getFantasyTeams() {
        String sql = "Select * from fantasy_teams";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        List<FantasyTeam> fantasyTeams = query.query(sql, new FantasyTeamRowMapper());
        return fantasyTeams;
    }
}
