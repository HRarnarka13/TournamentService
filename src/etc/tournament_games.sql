drop table tournament_games;

create table tournament_games
(
  tournamentid int,
  gameid int,
  PRIMARY KEY (tournamentid, gameid),
  FOREIGN KEY (tournamentid) REFERENCES tournaments (tournamentid),
  FOREIGN KEY (gameid) REFERENCES games (gameid)
);

SELECT * from tournament_games