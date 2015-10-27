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
/**
 * A class implementing FantasyTeamGateway.
 * Contains functionality for interacting with a SQL database
 */
public class FantasyTeamData extends RuData implements FantasyTeamDataGateway {

    /**
     * Adds a new fantasyTeam to the database.
     * @param userid userid
     * @throws FantasyTeamSeriveExeption
     */
    public int addFantasyTeam(int userid) throws FantasyTeamSeriveExeption {
        SimpleJdbcInsert insertFantasyTeam  = new SimpleJdbcInsert(getDataSource())
                .withTableName("fantasy_teams")
                .usingGeneratedKeyColumns("fantasy_teamid");

        Map<String, Object> fantasyTeamParameters = new HashMap<String, Object>(3);
        fantasyTeamParameters.put("userid", userid);
        fantasyTeamParameters.put("isopen", true);

        try {
            return insertFantasyTeam.executeAndReturnKey(fantasyTeamParameters).intValue();
        } catch (DataIntegrityViolationException divex) {
            log.warning("Duplicate entry");
            return -1;
        }

    }

    /**
     * Gets a specific fantasy team
     * @param fantasy_teamid the id of the team
     * @return a fantasy team with a specific id
     */
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

    /**
     * Gets all fantasy teams in the system
     * @return a list containing all fantasy teams
     */
    public List<FantasyTeam> getFantasyTeams() {
        String sql = "Select * from fantasy_teams";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        List<FantasyTeam> fantasyTeams = query.query(sql, new FantasyTeamRowMapper());
        return fantasyTeams;
    }

    public List<FantasyTeam> getFantasyTeamsByUserId(int userId) {
        String sql = "Select * from fantasy_teams WHERE userid = ?";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        try
        {
            List<FantasyTeam> teams = query.query(sql, new FantasyTeamRowMapper(), userId);
            return teams;
        }
        catch (EmptyResultDataAccessException ex)
        {
            String msg = "Empty result";
            log.warning(msg);
            return null;
        }
    }
}
