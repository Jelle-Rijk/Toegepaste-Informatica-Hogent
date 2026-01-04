USE games;

-- Alle actief gespeelde games

SELECT 
p.player AS Player,
GROUP_CONCAT(g.title SEPARATOR ', ') AS 'Active Playthroughs'
FROM Game g
	JOIN Playthrough p ON g.id = p.game
WHERE p.state = 'PLAYING'
GROUP BY p.player;