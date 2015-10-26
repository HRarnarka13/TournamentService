drop table fantasy_team;

create table fantasy_team
(
  fantasy_teamid INT IDENTITY (1,1) NOT NULL,
  userid int NOT NULL,
  PRIMARY KEY (fantasy_teamid),
  FOREIGN KEY (userid) REFERENCES users (id)
)