drop table tournament_enrollments;

create table tournament_enrollments
(
  tournamentid int NOT NULL ,
  fantasy_teamid int NOT NULL,
  score FLOAT,
  PRIMARY KEY (tournamentid, fantasy_teamid),
  FOREIGN KEY (tournamentid) REFERENCES tournaments (tournamentid),
  FOREIGN KEY (fantasy_teamid) REFERENCES fantasy_team (fantasy_teamid)
);