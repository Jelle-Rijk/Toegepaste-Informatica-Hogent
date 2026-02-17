-- Vraag 1
SELECT primaryTitle, startYear
FROM titles
WHERE titleType = 'movie' AND startYear = (SELECT max(startyear) FROM titles WHERE titletype = 'movie');

-- Vraag 2
SELECT p.fullName, p.birthYear, p.deathYear, t.primaryTitle
FROM directors d
	LEFT JOIN persons p ON p.nmconst = d.nmconst
    JOIN titles t ON t.tconst = d.tconst
WHERE p.deathYear BETWEEN '1932-01-01' AND '1954-12-31'
ORDER BY p.deathyear DESC, p.fullName, t.primaryTitle;

-- Vraag 3
SELECT t.primaryTitle, t.startYear, a.character_played
FROM titles t
	LEFT JOIN actors a ON a.tconst = t.tconst
WHERE startYear IS NULL AND a.nmconst IS NULL;


-- Vraag 4
SELECT t.tConst AS id, t.primaryTitle AS title, COUNT(*) AS episodes
FROM titles t
	JOIN episodes e ON t.tConst = e.parenttConst
GROUP BY t.tConst
ORDER BY Count(*) DESC
LIMIT 5;

-- Vraag 5a
DROP TABLE criticReview;
CREATE TABLE criticReview (
crID INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(100) NOT NULL,
review VARCHAR(1000) NOT NULL,
rating INT CONSTRAINT CHECK (rating BETWEEN 0 AND 5),
tconst VARCHAR(50),
CONSTRAINT FK_criticreview_tconst FOREIGN KEY (tconst) REFERENCES titles(tconst));

-- Vraag 5b
INSERT INTO criticreview(title, review, rating, tconst) VALUE ('Pretty movie', "By playing a girl on the street, Julia Roberts became America's favorite sweetheart", 4, 'tt0100405');