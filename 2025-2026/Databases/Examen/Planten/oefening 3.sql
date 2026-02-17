-- COMBINEREN
USE planten;

-- TESTS
SELECT * FROM leveranciers;
SELECT * FROM bestellingen;
SELECT * FROM bestellijnen;
SELECT * FROM offertes;
SELECT * FROM planten;
SELECT * FROM soorten;
SELECT * FROM kleuren;

/*Geef een overzicht (naam, soortnaam en hoogte) van alle waterplanten, gesorteerd op hoogte.*/
SELECT p.naam, s.soort, p.hoogte
FROM soorten s 
JOIN planten p ON s.soortID = p.soortID
WHERE s.soort = 'water'
ORDER BY p.hoogte;

-- Modeloplossing (zelfde resultaat)
SELECT naam, soort, hoogte 
FROM planten JOIN soorten ON planten.soortID = soorten.soortID  
WHERE soort='water' 
ORDER BY hoogte;

/*Geef een overzicht van de planten gesorteerd op soort en vervolgens op naam die noch boom, 
noch heester zijn en waarvan de hoogte tussen de 100 en de 200 cm, 
de kleur rood of blauw is en de bloeiperiode begint voor augustus.*/
SELECT soort, naam, hoogte, kleur, bl_b AS 'begin bloeiperiode'
FROM planten 
JOIN soorten ON planten.soortID = soorten.soortID
JOIN kleuren ON planten.kleurID = kleuren.kleurID
WHERE soort NOT IN ('boom', 'heester') AND hoogte BETWEEN 100 AND 200 AND kleur IN ('rood', 'blauw') AND bl_b < 8
ORDER BY soort, naam;

/*Welke is de laagste prijs per plantensoort van de planten die de volledige periode van mei tot en met juni bloeien. 
De bloei mag beginnnen voor mei en eindigen na juni.*/
SELECT soort, MIN(prijs) as 'prijs'
FROM planten
JOIN soorten ON planten.soortID = soorten.soortID
WHERE bl_b <= 5 AND bl_e >= 6
GROUP BY soort;

/*Toon de verschillende plantsoorten waarvoor rode planten beschikbaar zijn.*/
SELECT soort
FROM soorten
	JOIN planten ON soorten.soortID = planten.soortID
    JOIN kleuren ON planten.kleurID = kleuren.kleurID
WHERE kleur='rood'
GROUP BY soort;

/*Geef een overzicht per soort en per kleur van het aantal verschillende planten.*/
SELECT soort, kleur, COUNT(*)
FROM soorten
	JOIN planten ON soorten.soortID = planten.soortID
    JOIN kleuren ON planten.kleurID = kleuren.kleurID
GROUP BY soort, kleur;

/*Toon per leverancier(naam) het aantal artikelen die hij binnen de 18 dagen kan leveren.*/
SELECT naam, COUNT(*) AS 'aantal artikelen'
FROM leveranciers
	JOIN offertes ON leveranciers.levCode = offertes.levCode
WHERE levertermijn <= 18
GROUP by naam;

/*Geef per leverdatum in het formaat dd/mm/yyyy en per bestelbon de naam van de leverancier, 
het totaal aantal artikelen besteld, en de som van het aantal maal de prijs per besteld artikel.*/
SELECT concat(day(leverDatum),'/',month(leverDatum),'/',year(leverDatum)) as leverDatum, 
b.bestelnr, naam as leverancier, SUM(aantal) as 'aantal', SUM(aantal * prijs) as totaalprijs
FROM bestellingen b
	JOIN bestellijnen bl ON bl.bestelnr = b.bestelnr
    JOIN leveranciers l ON b.levCode = l.levCode
GROUP by leverDatum, bestelnr;

/*Selecteer de verschillende woonplaatsen van de leveranciers die een offerte gemaakt hebben voor “vaste” planten.*/
SELECT DISTINCT woonplaats
FROM leveranciers l
	JOIN offertes o ON o.levCode = l.levCode
    JOIN planten p ON p.artCode = o.artCode
    JOIN soorten s ON s.soortID = p.soortID
WHERE soort = 'vast';

/*Geef per artikelcode de naam van de plant, laagste offerteprijs, de hoogste offerteprijs. 
Sorteer op plantnaam.*/
SELECT offertes.artCode, naam, MIN(offertePrijs) AS 'laagste offerteprijs', MAX(offertePrijs) AS 'hoogste offerteprijs'
FROM planten
	JOIN offertes ON planten.artCode = offertes.artCode
GROUP BY offertes.artCode, naam
ORDER BY naam;

/*Geef een overzicht van alle bestellingen: bestelnr, leverdatum in het formaat dd/mm/yyyy, bedrag. 
Voeg een laatste kolom “opmerking” toe. 
Indien de besteldatum > 5 maart 2003 dan moet in de laatste kolom de opmerking “te laat” komen, 
anders komt in de laatste kolom geen opmerking.*/
SELECT bestelnr, DATE_FORMAT(leverDatum, '%d/%m/%Y') AS leverdatum, bedrag, 
	CASE
		WHEN besteldatum > '2003-03-05' THEN 'te laat'
        ELSE ''
	END AS 'opmerking'
FROM bestellingen;

/*Geef per leverancier het aantal verschillende soorten planten waarvoor hij een offerte heeft gemaakt. 
Sorteer op dalende volgorde van aantal.*/
SELECT naam, COUNT(DISTINCT artCode) as 'aantal soorten'
FROM leveranciers l
	JOIN offertes o ON l.levCode = o.levCode
GROUP BY l.levCode, naam
ORDER BY COUNT(DISTINCT artCode) DESC;

/*Geef per leverancier de verschillende soorten planten waarvoor hij een offerte heeft ingediend.*/
SELECT DISTINCT l.naam, s.soort
FROM leveranciers l
	JOIN offertes o ON l.levCode = o.levCode
    JOIN planten p ON o.artCode = p.artCode
    JOIN soorten s ON s.soortID = p.soortID;

/*Toon een lijst van alle vaste planten, 
gevolgd door de namen van de vaste planten die later op het jaar beginnen te bloeien. 
Toon de vaste planten die eerst beginnen bloeien bovenaan.*/
SELECT p1.naam, p1.bl_b, p2.naam, p2.bl_b
FROM planten p1
	JOIN soorten ON p1.soortID = soorten.soortID
    JOIN planten p2 ON p2.bl_b > p1.bl_b AND p1.soortID = p2.soortID
WHERE soort = 'vast'
ORDER BY p1.bl_b;

/*Hoeveel verschillen de gehanteerde bestelprijzen met de huidige offerteprijzen bij dezelfde leverancier. 
Toon telkens bestelnummer, artikelcode en het positieve of negatieve verschil.*/
SELECT b.bestelnr, o.artCode, (prijs - offertePrijs) AS 'verschil'
FROM bestellingen b
	JOIN bestellijnen bl ON b.bestelnr = bl.bestelnr
    JOIN leveranciers lev ON b.levCode = lev.levCode
    JOIN offertes o ON lev.levCode = o.levCode
WHERE o.artCodeLev = bl.artCodeLev;

/*Toon een lijst met bestelnummers, leverancierscode en besteldatum 
en zorg ervoor dat de lijst ook de leveranciers bevat waarvoor nog geen bestelling geplaatst werd.*/
SELECT bestelnr, l.levCode, besteldatum
FROM leveranciers l
	LEFT JOIN bestellingen b ON l.levCode = b.levCode
