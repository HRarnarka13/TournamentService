drop table fantasy_team_players;

  CREATE TABLE fantasy_team_players
  (
    fantasy_teamid int,
    playerid int,
    PRIMARY KEY (fantasy_teamid, playerid),
    FOREIGN KEY (fantasy_teamid) REFERENCES fantasy_teams (fantasy_teamid),
    FOREIGN KEY (playerid) REFERENCES players (playerid)
  );