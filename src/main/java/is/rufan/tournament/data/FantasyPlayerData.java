package is.rufan.tournament.data;

import is.rufan.tournament.domain.FantasyPlayer;
import is.rufan.tournament.service.FantasyTeamSeriveExeption;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */

/**
 * A class implementing FantasyPlayerDataGateway.
 * Contains functionality for interacting with a SQL database
 */
public class FantasyPlayerData extends RuData implements FantasyPlayerDataGateway {

    /**
     * Adds a real football player to a Users fantasy team
     * @param fantasyPlayer Player containing both fantasy teamid and playerId
     * @throws FantasyTeamSeriveExeption
     */
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

    /**
     * Gets a fantasy player with a specifc Id
     * @param playerid the id the player
     * @param fantasy_teamid
     * @return A fantasy player with a specific Id
     */
    public FantasyPlayer getFantasyPlayer(int playerid, int fantasy_teamid) {
        String sql = "Select * from fantasy_team_players where playerid = ? and fantasy_teamid = ?";
        JdbcTemplate queryFantasyPlayer = new JdbcTemplate(getDataSource());

        try {
            FantasyPlayer fantasyPlayer = queryFantasyPlayer.queryForObject(sql, new Object[]{ playerid, fantasy_teamid },
                    new FantasyPlayerRowMapper());
            return fantasyPlayer;
        } catch (EmptyResultDataAccessException erdaex) {
            return null;
        }
    }

    /**
     * Gets all fantasy players, i.e all players that are in some fantasy team
     * @return A list of fantasy players
     */
    public List<FantasyPlayer> getFantasyPlayers() {
        String sql = "Select * from fantasy_team_players";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        List<FantasyPlayer> fantasyPlayers = query.query(sql, new FantasyPlayerRowMapper());
        return fantasyPlayers;
    }

    /**
     * Gets all players in a specifc fantasy team.
     * @param fantasy_teamid The id of the fantasy team
     * @return A list of fantasy players in a specific team
     */
    public List<FantasyPlayer> getFantasyPlayersByTeamId(int fantasy_teamid) {

        String sql = "Select playerid from fantasy_team_players where fantasy_teamid = ?";
        JdbcTemplate query = new JdbcTemplate(getDataSource());
        List<Integer> fantasyPlayers = query.queryForList(sql, new Object[]{ fantasy_teamid }, Integer.TYPE);
        List<FantasyPlayer> fantasyPlayerList = new ArrayList<FantasyPlayer>();
        for(Integer i : fantasyPlayers) {
            fantasyPlayerList.add(new FantasyPlayer(i, fantasy_teamid));
        }
        return fantasyPlayerList;
    }
}
