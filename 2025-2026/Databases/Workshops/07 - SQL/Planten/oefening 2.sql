-- AGGREGEREN
USE planten;

/*Hoeveel planten telt het assortiment? Geef de kolom de naam ‘aantal planten’.*/
SELECT COUNT(*) AS 'aantal planten' FROM planten;

/*Hoeveel planten die bloeien (waarvoor kleur ingevuld) telt het assortiment?*/
SELECT COUNT(kleurID) AS 'aantal' FROM planten WHERE bl_b IS NOT NULL AND bl_e IS NOT NULL;

/*Hoeveel verschillende bloeikleuren komen er in het assortiment voor?*/
SELECT COUNT(distinct kleurID) AS 'aantal bloeikleuren' FROM planten;

/*Bij hoeveel leveranciers werd er reeds een bestelling geplaatst?*/
SELECT COUNT(distinct levCode) AS aantal FROM bestellingen;

/*Hoeveel verschillende artikelen zijn er reeds besteld geweest.*/
SELECT COUNT(distinct artCodeLev) FROM bestellijnen;

/*Geef een overzicht van het aantal leveranciers per woonplaats.*/
SELECT woonplaats, COUNT(*) FROM leveranciers GROUP BY woonplaats;

/*Toon voor de tabel planten de gemiddelde hoogte en de som van alle hoogtes gedeeld door het aantal planten. 
Zijn deze gelijk? Waarom?*/
SELECT AVG(hoogte) AS gemiddeldeAVG, SUM(hoogte) / COUNT(*) AS gemiddeldeSUMDeling FROM planten;

-- De berekeningen zijn niet gelijk. Dit komt volgens mij doordat COUNT(*) ook NULL-waarden meerekent 
-- terwijl dat bij AVG niet het geval is en er dus door een minder hoog totaal gedeeld wordt.

/*Welke leveranciers bieden minstens 20 planten aan waarvan de levertermijn kleiner is dan 17 dagen. 
Toon code van de leverancier en het aantal verschillende planten. 
De leverancier die het meeste aantal planten aanbiedt staat bovenaan.*/
SELECT levCode AS 'Leverancier', COUNT(artcodelev) AS 'Aantal'
FROM offertes
WHERE levertermijn < 17
GROUP BY levCode
HAVING COUNT(artcodelev) > 20
ORDER BY COUNT(artcodelev) DESC;

/*Geef per bestelling het aantal bestellijnen, gesorteerd op aantal lijnen.*/
SELECT bestelnr AS bestelling, COUNT(*) AS bestellijnen
FROM bestellijnen
GROUP BY bestelnr
ORDER BY COUNT(*);

/*Wat is de laagste offerteprijs voor de plant met artikelcode 123.*/
SELECT MIN(offerteprijs) FROM offertes WHERE artcode = 123;

/*Hoeveel artikels met artcodelev B111 werden reeds besteld?*/
SELECT SUM(aantal) AS artikels FROM bestellijnen WHERE artcodelev = 'B111';

/*Geef per artikel (artcode) de minimale en maximale offerteprijs.*/
SELECT artCode, MIN(offerteprijs) AS minPrijs, MAX(offerteprijs) AS maxPrijs FROM offertes GROUP BY artCode;

/*Geef per levertermijn de gemiddelde offerteprijs*/
SELECT levertermijn, AVG(offertePrijs) AS 'gemiddelde prijs'
FROM offertes
GROUP BY levertermijn;

/*Welke is alfabetisch gezien de eerste naam van de planten uit het assortiment.*/
SELECT min(naam) as Naam FROM planten;

/*Toon de lijst van de woonplaatsen waar 2 of meer leveranciers wonen. Sorteer alfabetisch.*/
SELECT woonplaats, COUNT(*) AS leveranciers FROM leveranciers 
GROUP BY woonplaats HAVING COUNT(levCode) >= 2
ORDER BY woonplaats;
