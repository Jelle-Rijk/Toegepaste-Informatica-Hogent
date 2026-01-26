USE dranken;

-- COUNT, SUM, MIN, MAX, AVG
-- 1. Hoeveel klanten zijn er? Geef de kolom de hoofding 'Aantal klanten'.
-- 17 records
SELECT count(*) as 'Aantal klanten' FROM KLANT;

-- 2. Hoeveel facturen werden verstuurd op 29 juni 2017? Geef de kolom een duidelijke hoofding.
-- 3 records
SELECT count(*) AS 'Aantal facturen' FROM factuur WHERE factuurdatum = '2017-06-29';

-- 3. Hoeveel flessen zijn er op dit moment in voorraad? Geef de kolom een duidelijke hoofding.
-- 1258 records
SELECT sum(voorraad) AS 'Totale voorraad' FROM artikel;

-- 4. Geef per plaats het aantal klanten. Druk plaatsnaam en aantal af op 
-- volgorde van oplopend aantal. Bij gelijk aantal sorteren op plaatsnaam. TODO
-- 12 records, Aalst heeft één klant, Gent vier records
SELECT Plaats, COUNT(*) AS 'Aantal klanten'
FROM klant
GROUP BY plaats
ORDER BY COUNT(*), plaats;


-- 5. Geef de unie’s met 4 of meer leden (klanten records 
-- Toon het aantal leden per unie. TODO 
-- 3 records records
SELECT Unie, COUNT(*) AS "Leden"
FROM klant
GROUP BY unie
HAVING COUNT(*) >= 4;


-- 6. Hoeveel klanten behoren tot geen enkele unie?
-- 3 records
SELECT Count(*) AS 'Klanten zonder unie'
FROM klant
WHERE unie IS NULL;

-- 7. Geef het aantal klanten per provincie
-- OVL	10
-- WVL	4
-- A	3
SELECT Provincie, Count(*) AS 'Aantal klanten'
FROM klant
GROUP BY provincie;
 
-- 8. Geef het aantal klanten per plaats, maar geef enkel plaatsen met meer dan 3 klanten
-- Gent	4
SELECT Plaats, Count(*) AS 'Aantal klanten'
FROM klant
GROUP BY plaats
HAVING COUNT(*) > 3;

-- 9. Geef het aantal unieke postcodes per provincie. Sorteer oplopend op aantal. TODO
-- A	2
-- WVL	4
-- OVL	6
SELECT Provincie, COUNT(distinct postcode) AS 'Aantal postcodes'
FROM klant
GROUP BY provincie
ORDER BY COUNT(distinct postcode);


-- 10. Geef het aantal soorten per kleur, waarbij de kleur NOT NULL is.  TODO
-- Sorteer oplopend op aantal.
-- kleur	soort_per_kleur
-- Blauw	1
-- Groen	1
-- Barique	1
-- Kleurloos	3
-- Roze	3
-- Wit	13
-- Rood	21
SELECT kleur, COUNT(*) AS 'soort_per_kleur'
FROM soort
GROUP BY kleur
HAVING kleur IS NOT NULL
ORDER BY COUNT(*);

-- 11. Geef het gemiddelde alcoholpercentage per kleur.
-- Sorteer alfabetisch op kleur.
-- Geef enkel de records waarbij het gemiddelde alcoholpercentage > 15% en de kleur NOT NULL is.
-- 
-- kleur	alcoholperc_per_kleur
-- Barique	40
-- Blauw	40
-- Groen	40
-- Kleurloos	41
SELECT kleur, AVG(alcoholperc) AS alcoholperc_per_kleur
FROM soort
GROUP BY kleur
HAVING AVG(alcoholperc) > 15 AND kleur IS NOT NULL
ORDER BY kleur;

-- 12. Geef per productgroepnummer het aantal soorten
-- Geef enkel groepen met 3 of meer soorten.
-- 20	9
-- 22	3
-- 30	3
-- 31	3
-- 32	3
-- 34	5
-- 50	32
SELECT productgroepnr, count(*) as 'Aantal soorten'
FROM soort
GROUP BY productgroepnr
HAVING count(*) >= 3;

-- 13. Geef het minimum en maximum alcoholpercentage per kleur als de kleur ingevuld is.
-- Geef de kolommen een duidelijke hoofding (zie voorbeelduitvoer).
-- Kleur	MinAlc	MaxAlc
-- Blauw	40	40
-- Groen	40	40
-- Kleurloos	40	43
-- Barique	40	40
-- Rood	6	14
-- Wit	6	13
-- Roze	6	9
SELECT Kleur, MIN(alcoholperc) AS 'MinAlc', MAX(alcoholperc) AS MaxAlc
FROM soort
GROUP BY kleur
HAVING kleur is not null;

-- 14. Geef de gemiddelde adviesverkoopprijs per jaar. Sorteer oplopend op jaar.
-- Geef enkel de waarden waarbij het jaar niet leeg is.
-- Geef de kolommen een duidelijke hoofding (zie voorbeelduitvoer).
-- Jaar	GemAdviesPrijs
-- 2002	32.00000000
-- 2003	31.25000000
-- 2005	72.00000000
-- 2006	192.75000000
-- 2007	39.23333333
--  ...
SELECT Jaar, AVG(adviesverkoopprijs) AS 'GemAdviesPrijs'
FROM artikel
GROUP BY jaar
HAVING jaar is not null
ORDER BY jaar;

-- 15. Geef de totale voorraad per soortnummer
-- Geef de kolommen een duidelijke hoofding (zie voorbeelduitvoer).
-- SoortNr	TotaleVoorraad
-- 1002	7
-- 1003	5
-- 1101	25
-- 1200	11
-- ...
SELECT SoortNr, SUM(voorraad) AS TotaleVoorraad
FROM artikel
GROUP BY soortnr;

-- 16. Geef het aantal artikelen per jaar waarbij het jaar niet null is. Sorteer oplopend op Jaar
-- Geef de kolommen een duidelijke hoofding (zie voorbeelduitvoer).
-- Jaar AantalArtikelen
-- 2002	1
-- 2003	1
-- 2005	1
-- 2006	2
-- 2007	4
-- 2008	4
-- 2009	2
SELECT Jaar, COUNT(*) AS AantalArtikelen
FROM artikel
GROUP BY jaar
HAVING jaar IS NOT NULL
ORDER BY jaar;

-- 17. Geef die soorten waarbij de gemiddelde voorraad > 50
-- Geef de kolommen een duidelijke hoofding (zie voorbeelduitvoer).
-- SoortNr	GemVoorraad
-- 1205	78.0000
-- 1212	70.0000
-- 2140	65.0000
-- 3101	177.0000
SELECT SoortNr, AVG(voorraad) AS GemVoorraad
FROM artikel
GROUP BY soortnr
HAVING AVG(voorraad) > 50;

-- 18. Geef de provincies met 3 of meer klanten die aangesloten zijn bij een unie.  
-- Geef de kolommen een duidelijke hoofding (zie voorbeelduitvoer).
-- provincie 	aantal klanten
-- OVL			9
-- WVL			3
SELECT provincie, COUNT(*) AS 'aantal klanten'
FROM klant
WHERE unie IS NOT NULL
GROUP BY provincie
HAVING COUNT(*) >= 3;