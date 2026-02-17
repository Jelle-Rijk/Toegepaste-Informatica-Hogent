USE DRANKEN;
DROP TABLE Producent;

CREATE TABLE Producent (
producentnr INT NOT NULL PRIMARY KEY,
naam VARCHAR(25) NOT NULL,
plaats VARCHAR(25),
land VARCHAR(16));

INSERT INTO Producent(producentnr, naam, plaats, land) 
VALUES 
(103, 'Fiore', 'Ruffiole', 'Italië'),
(135, 'Coutet', 'Barsac', 'Frankrijk'),
(735, 'Le Cecche', 'Barolo', 'Italië'),
(111, 'CaMarcanda', 'Castagneto', 'Italië')
;

ALTER TABLE Soort
	ADD COLUMN Producent INT,
    ADD CONSTRAINT fk_producent FOREIGN KEY (producent) REFERENCES Producent(producentnr);

INSERT INTO Soort(soortnr, productgroepnr, naam, kleur, alcoholperc, producent)
VALUES
(1229, 50, 'Il Carbonaione', 'rood', 12, 103),
(1386, 50, 'La Chartreuse', 'wit', 12, 135),
(2146, 50, 'Le Cecche', 'rood', 13, 735),
(2150, 50, 'Promis', 'rood', 13, 111)
;

UPDATE Soort SET kleur = 'bruin' WHERE soortnr = 3010;
SELECT * FROM Soort WHERE soortnr = 3010;

UPDATE Soort SET alcoholperc=12 WHERE soortnr = 3030;
SELECT * FROM Soort WHERE soortnr = 3030;

DELETE FROM Soort WHERE soortnr = 4009;