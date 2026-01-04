USE games;

-- GENRES
DELETE FROM Genre;
INSERT INTO genre(description) VALUES('action'), ('action-adventure'), ('adventure'), ('puzzle'), ('role-playing'), ('simulation'), ('strategy'), ('sports'), ('mmo'), ('sandbox'), ('open world'), ('racing');
SELECT * from Genre;

-- PLAYER
DELETE FROM Player;
INSERT INTO Player VALUES('Jelle'), ('Shawnee');
SELECT * FROM Player;

-- COMPANY
DELETE FROM Company;
INSERT INTO Company(name, country) VALUES('Microsoft', 'United States'), ('Insomniac Games', 'United States'), ('Valve Corporation', 'United States'), ('Nintendo', 'Japan'), ('Sony', 'Japan'), ('Apple', 'United States');
SELECT * FROM Company;

-- CONSOLE
DELETE FROM Console;

INSERT INTO Platform VALUE();
INSERT INTO Console(id, name, release_year, manufacturer) VALUE((Select last_insert_id() FROM Platform), 'Xbox One', 2013, (SELECT companyId FROM company WHERE name='Microsoft'));
INSERT INTO Platform VALUE();
INSERT INTO Console(id, name, release_year, manufacturer) VALUE((Select id FROM Platform WHERE id = last_insert_id()), 'Nintendo Switch', 2017, (SELECT companyId FROM company WHERE name='Nintendo'));
INSERT INTO Platform VALUE();
INSERT INTO Console(id, name, release_year, manufacturer) VALUE((Select id FROM Platform WHERE id = last_insert_id()), 'Steam Deck', 2025, (SELECT companyId FROM company WHERE name='Valve Corporation'));
INSERT INTO Platform VALUE();
INSERT INTO Console(id, name, release_year, manufacturer) VALUE((Select id FROM Platform WHERE id = last_insert_id()), 'Playstation 5', 2020, (SELECT companyId FROM company WHERE name='Sony'));
INSERT INTO Platform VALUE();
INSERT INTO Console(id, name, release_year, manufacturer) VALUE((Select id FROM Platform WHERE id = last_insert_id()), 'Nintendo Switch 2', 2025, (SELECT companyId FROM company WHERE name='Nintendo'));
INSERT INTO Platform VALUE();
INSERT INTO Console(id, name, release_year, manufacturer) VALUE((Select id FROM Platform WHERE id = last_insert_id()), 'XBox Series', 2020, (SELECT companyId FROM company WHERE name='Microsoft'));

SELECT * FROM Console;

SELECT console.name as 'Name', release_year as 'Release', company.name as 'Manufacturer'
FROM Console
	JOIN Company ON manufacturer = Company.companyId;
    
-- COMPUTER
INSERT INTO Platform VALUE();
INSERT INTO Computer(id, os, developer) VALUE ((SELECT id FROM Platform WHERE id = last_insert_id()), 'Windows', (SELECT companyId FROM Company WHERE name = 'Microsoft'));
INSERT INTO Platform VALUE();
INSERT INTO Computer(id, os, developer) VALUE ((SELECT id FROM Platform WHERE id = last_insert_id()), 'macOS', (SELECT companyId FROM Company WHERE name = 'Apple'));

SELECT os as 'Operating System', company.name
FROM Computer
	JOIN Company on Computer.developer = Company.companyId;
    
-- GAME
INSERT INTO Game(title, developer) VALUE ('Sunset Overdrive', (SELECT CompanyId FROM Company WHERE name = 'Insomniac Games'));
INSERT INTO Game(title) VALUE ("Baldur's gate 3");
INSERT INTO Game(title, developer) VALUE ('Mario Kart 8 Deluxe', (SELECT CompanyId FROM Company WHERE name = 'Nintendo'));

SELECT title as 'Game', dev.name as 'Developer'
FROM Game g
JOIN Company dev ON dev.companyId = g.developer;

-- GameGenre
INSERT INTO GameGenre(gameId, genreId) VALUE((SELECT id from Game WHERE title = 'Mario Kart 8 Deluxe'), (SELECT id FROM Genre WHERE description = 'racing'));
INSERT INTO GameGenre(gameId, genreId) VALUE((SELECT id from Game WHERE title = 'Sunset Overdrive'), (SELECT id FROM Genre WHERE description = 'action'));
INSERT INTO GameGenre(gameId, genreId) VALUE((SELECT id from Game WHERE title = 'Sunset Overdrive'), (SELECT id FROM Genre WHERE description = 'open world'));
INSERT INTO GameGenre(gameId, genreId) VALUE((SELECT id from Game WHERE title = "Baldur's Gate 3"), (SELECT id FROM Genre WHERE description = 'role-playing'));

SELECT game.title as Game, GROUP_CONCAT(genre.description SEPARATOR ', ') as Genre
FROM GameGenre
	JOIN Game ON game.id = GameGenre.gameId
    JOIN Genre ON genre.id = GameGenre.genreId
GROUP BY gameId;

-- GamePlatform
INSERT INTO GamePlatform(game, platform, releaseYear) VALUE ((SELECT id FROM Game WHERE title = 'Sunset Overdrive'), (SELECT platform.id FROM Platform LEFT JOIN Console ON Console.id = Platform.id WHERE console.name = 'Xbox One'), 2014);
INSERT INTO GamePlatform(game, platform, releaseYear) VALUE ((SELECT id FROM Game WHERE title = 'Sunset Overdrive'), (SELECT platform.id FROM Platform LEFT JOIN Computer ON Computer.id = Platform.id WHERE computer.os = 'Windows'), 2018);
INSERT INTO GamePlatform(game, platform, releaseYear) VALUE ((SELECT id FROM Game WHERE title = 'Mario Kart 8 Deluxe'), (SELECT platform.id FROM Platform LEFT JOIN Console ON Console.id = Platform.id WHERE console.name = 'Nintendo Switch'), 2017);
INSERT INTO GamePlatform(game, platform, releaseYear) VALUE ((SELECT id FROM Game WHERE title = "Baldur's Gate 3"), (SELECT platform.id FROM Platform LEFT JOIN Console ON Console.id = Platform.id WHERE console.name = 'Xbox Series'), 2023);
INSERT INTO GamePlatform(game, platform, releaseYear) VALUE ((SELECT id FROM Game WHERE title = "Baldur's Gate 3"), (SELECT platform.id FROM Platform LEFT JOIN Console ON Console.id = Platform.id WHERE console.name = 'PlayStation 5'), 2023);
INSERT INTO GamePlatform(game, platform, releaseYear) VALUE ((SELECT id FROM Game WHERE title = "Baldur's Gate 3"), (SELECT platform.id FROM Platform LEFT JOIN Computer ON Computer.id = Platform.id WHERE computer.os = 'Windows'), 2023);
INSERT INTO GamePlatform(game, platform, releaseYear) VALUE ((SELECT id FROM Game WHERE title = "Baldur's Gate 3"), (SELECT platform.id FROM Platform LEFT JOIN Computer ON Computer.id = Platform.id WHERE computer.os = 'macOS'), 2023);

SELECT 
	g.title AS Game,
    GROUP_CONCAT(CASE WHEN com.os IS NOT NULL THEN com.os ELSE con.name END SEPARATOR ', ') AS Platform,
    gp.releaseYear AS 'Release'
FROM GamePlatform gp
JOIN Game g ON gp.game = g.id
LEFT JOIN Console con ON gp.platform = con.id
LEFT JOIN Computer com ON gp.platform = com.id
GROUP BY g.title, gp.releaseYear;

-- Playthrough
INSERT INTO Playthrough(game, player, platform, state) VALUES ((SELECT id FROM Game WHERE title = 'Mario Kart 8 Deluxe'), 'Jelle', (SELECT platform.id FROM Platform LEFT JOIN Console ON platform.id = console.id LEFT JOIN Computer ON platform.id = computer.id WHERE console.name = 'Nintendo Switch' OR os = 'Nintendo Switch'), 'FINISHED');
INSERT INTO Playthrough(game, player, platform, state, saveNumber) VALUES ((SELECT id FROM Game WHERE title = 'Mario Kart 8 Deluxe'), 'Jelle', (SELECT platform.id FROM Platform LEFT JOIN Console ON platform.id = console.id LEFT JOIN Computer ON platform.id = computer.id WHERE console.name = 'Nintendo Switch' OR os = 'Nintendo Switch'), 'PLAYING', 2);
INSERT INTO Playthrough(game, player, platform, state) VALUES ((SELECT id FROM Game WHERE title = 'Sunset Overdrive'), 'Jelle', (SELECT platform.id FROM Platform LEFT JOIN Console ON platform.id = console.id LEFT JOIN Computer ON platform.id = computer.id WHERE console.name = 'Windows' OR os = 'Windows'), 'PLAYING');
INSERT INTO Playthrough(game, player, platform, state) VALUES ((SELECT id FROM Game WHERE title = "Baldur's Gate 3"), 'Jelle', (SELECT platform.id FROM Platform LEFT JOIN Console ON platform.id = console.id LEFT JOIN Computer ON platform.id = computer.id WHERE console.name = 'Windows' OR os = 'Windows'), 'NOT_STARTED');

SELECT 
	p.player AS Player,
    g.title as Game,
    CASE
		WHEN com.os IS NOT NULL THEN com.os
        ELSE con.name
	END AS Platform,
    saveNumber as 'Save File',
    p.state as State
FROM Playthrough p
JOIN Game g ON g.id = p.game
LEFT JOIN Console con ON p.platform = con.id
LEFT JOIN Computer com ON p.platform = com.id;

-- Rating
INSERT INTO Rating(game, player, score, comment) VALUE ((SELECT id FROM Game where title = 'Sunset Overdrive'), 'Jelle', 7.8, 'Amazing movement options, very fun.');

SELECT
	g.title as Game,
    r.player as Reviewer,
    r.score as Score,
    r.comment as Review
FROM Rating r
JOIN Game g on g.id = r.game
ORDER BY g.title;