-- Planten Oefening 5 - Manipuleren
USE planten;
SHOW TABLES;

/*Voeg als kleuren appelblauwzeegroen en zwart toe.*/
SELECT * FROM kleuren;

INSERT INTO kleuren(kleur) VALUE ('appelblauwzeegroen');
INSERT INTO kleuren(kleur) VALUE ('zwart');

/*Voeg als soorten vet en naald toe.*/
SELECT * FROM soorten;

INSERT soorten(soort) VALUE('vet');
INSERT soorten(soort) VALUE('naald');

SELECT * FROM Soorten;

/*Voeg een spar toe aan de tabel planten. (artcode: 163, hoogte 3000, prijs : 12.5, soortID : 2, andere gegevens onbekend)*/
SELECT * FROM planten;
INSERT INTO planten(naam, artCode, hoogte, prijs, soortID) VALUES('Spar', 163, 3000, 12.5, 2);

/*Voeg een sierui toe aan de tabel planten (artcode: 165, hoogte: 75, bl_e :8; bl_b: 6, prijs:3, soort : bol, kleur : blauw)*/
SELECT * FROM planten;
INSERT INTO planten VALUES(165, 'Sierui', 3, 1, 75, 6, 8, 3);

/*Verhoog de prijs van alle planten met 5 procent.*/
UPDATE planten
SET prijs = prijs * 1.05;

SELECT * FROM planten;

/*Verwijder kleur blauw. Werkt dit?*/
DELETE FROM kleuren
WHERE kleur = 'blauw';

SELECT * FROM kleuren;

/*Voeg als soort bloem toe.*/
INSERT INTO soorten(soort) VALUES('bloem');
SELECT * FROM soorten;

/*Pas de tabel planten aan. Vervang de soort van alle planten die de Soort bol hebben naar de soort bloem.*/
UPDATE planten
SET soortID = 15
WHERE soortID = 3;

SELECT * FROM planten;

/*Verwijder alle planten.*/
DELETE FROM planten;
SELECT * FROM planten;
