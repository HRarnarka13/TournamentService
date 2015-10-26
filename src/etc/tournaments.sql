drop table tournaments;

create table tournaments
(
  tournamentid int IDENTITY (1,1) NOT NULL PRIMARY KEY,
  name VARCHAR(200),
  entry_fee FLOAT,
  start_time DATETIME,
  end_time DATETIME,
  status bit,
  maxentries int
);


SELECT * FROM tournaments