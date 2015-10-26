package is.rufan.tournament.data;

import is.rufan.tournament.domain.FantasyPlayer;
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
public class FantasyPlayerData extends RuData implements FantasyPlayerDataGateway {

    public void addFantasyPlayer(FantasyPlayer fantasyPlayer) throws FantasyTeamSeriveExeption {
        SimpleJdbcInsert insertFantasyPlayer  = new SimpleJdbcInsert(getDataSource())
                .withTableName("fantasy_team_players");

        Map<String, Object> fantasyPlayerParameters = new HashMap<String, Object>(2);
        fantasyPlayerParameters.put("fantasy_teamid", fantasyPlayer.getFantasy_teamid());
        fantasyPlayerParameters.put("playerid", fantasyPlayer.getPlayerid());

        try {
            insertFantasyPlayer.execute(fantasyPlayerParameters);
        } catch (DataIntegrityViolationException divex) {
            log.warning("Duplicate entry");
        }
    }

    public FantasyPlayer getFantasyPlayer(int playerid) {
        String sql = "Select * from fantasy_team_players where id = ?";
        JdbcTemplate queryFantasyPlayer = new JdbcTemplate(getDataSource());

        try {
            FantasyPlayer fantasyPlayer = queryFantasyPlayer.queryForObject(sql, new Object[]{ playerid },
                    new FantasyPlayerRowMapper());
            return fantasyPlayer;
        } catch (EmptyResultDataAccessException erdaex) {
            return null;
        }
    }

    public List<FantasyPlayer> getFantasyPlayers() {
        String sql = "Select * from fantasy_team_players";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        List<FantasyPlayer> fantasyPlayers = query.query(sql, new FantasyPlayerRowMapper());
        return fantasyPlayers;
    }

    public List<FantasyPlayer> getFantasyPlayerByTeamId(int fantasy_teamid) {

        String sql = "Select * from fantasy_team_players where id = ?";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        List<FantasyPlayer> fantasyPlayers = query.query(sql, new Object[]{ fantasy_teamid }
                                                            , new FantasyPlayerRowMapper());
        return fantasyPlayers;
    }
}
