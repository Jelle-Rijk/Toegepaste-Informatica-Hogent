DROP DATABASE games;
CREATE DATABASE games;
USE games;

CREATE TABLE Player(
nickname VARCHAR(64) PRIMARY KEY
);

CREATE TABLE Company(
companyId INTEGER AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(64) NOT NULL,
country VARCHAR(64)
);

CREATE TABLE Genre(
id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(64)
);

CREATE TABLE Game(
id integer AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(64) NOT NULL,
developer INTEGER,
CONSTRAINT fk_developer FOREIGN KEY(developer) REFERENCES Company(companyId)
);

CREATE TABLE Platform(
id INTEGER AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Console(
id INTEGER PRIMARY KEY,
name VARCHAR(64) NOT NULL,
release_year INTEGER CONSTRAINT CHECK (release_year >= 1972),
manufacturer INTEGER,
FOREIGN KEY(id) REFERENCES Platform(id),
FOREIGN KEY(manufacturer) REFERENCES Company(companyId)
);

CREATE TABLE Computer(
id INTEGER PRIMARY KEY,
os VARCHAR(64) NOT NULL,
developer INTEGER,
FOREIGN KEY(id) REFERENCES Platform(id),
FOREIGN KEY(developer) REFERENCES Company(companyId)
);


CREATE TABLE GameGenre(
gameId INTEGER,
genreId INTEGER,
PRIMARY KEY(gameId, genreId),
FOREIGN KEY(gameId) REFERENCES Game(id),
FOREIGN KEY(genreId) REFERENCES Genre(id)
);

CREATE TABLE GamePlatform(
game INTEGER,
platform INTEGER,
releaseYear INTEGER CONSTRAINT CHECK (releaseYear >= 1950),
PRIMARY KEY(game, platform),
FOREIGN KEY(game) REFERENCES Game(id),
FOREIGN KEY(platform) REFERENCES Platform(id)
);

CREATE TABLE Playthrough(
game INTEGER,
player VARCHAR(64),
saveNumber INTEGER NOT NULL DEFAULT 1,
platform INTEGER,
state VARCHAR(16),
PRIMARY KEY(game, player, saveNumber),
FOREIGN KEY(game) REFERENCES Game(id),
FOREIGN KEY(player) REFERENCES Player(nickname),
FOREIGN KEY(platform) REFERENCES Platform(id),
CONSTRAINT CHK_state CHECK (state in ("NOT_STARTED", "PLAYING", "FINISHED", "DROPPED"))
);

CREATE TABLE Rating(
game INTEGER,
player VARCHAR(64),
score Decimal(3,1) NOT NULL CONSTRAINT CHECK (score <= 10),
comment VARCHAR(1024),
PRIMARY KEY(game, player),
FOREIGN KEY(game) REFERENCES Game(id),
FOREIGN KEY(player) REFERENCES Player(nickname)
);