USE dranken;
-- 1. Welke artikelen hebben een voorraad lager dan de gemiddelde voorraad over alle artikelen heen?
-- Sorteer op artikelnr

-- ArtikelNr	SoortNr	Jaar	Inhoud	AdviesVerkoopprijs	Voorraad
-- 10803	4006		0.75	102.7000	9
-- 10804	2139	2014	1	120.0000	5
-- 10806	1223	2010	0.75	134.0000	17
-- 10807	4002	2012	0.7	75.0000	9
-- 10808	3020		0.7	123.0000	20
-- 10809	1200	2007	50		2
-- 10810	3011		0.7	62.5000	5
-- ...
SELECT *
FROM Artikel
WHERE voorraad < (SELECT AVG(voorraad) FROM Artikel);


-- 2. Welke klanten behoren tot dezelfde Unie als de klant Wijnen Lybaert? 
-- Wijnen Lybaert staat niet in de oplossing

-- KlantNr	Naam	Adres	Postcode	Plaats	Provincie	Unie
-- 1001	Wijnhandel Van den Bussche & Zonen	Vlaanderenstraat 110	9000	Gent	OVL	23
-- 1002	Evin Wine Store	Sint-Margrietstraat 16	9000	Gent	OVL	23
-- 1003	Caves Saint Amand	Gentbruggestraat 169	9040	Sint-Amandsberg	OVL	23
-- 1004	Wijnhuis Tinto	Blauwesteenstraat 75	9070	Heusden	OVL	23
-- 1045	Belgian Wines	Leasestraat 1	2000	Antwerpen	A	23

SELECT *
FROM Klant
WHERE unie = (SELECT unie FROM klant WHERE naam = 'Wijnen Lybaert') AND naam <> 'Wijnen Lybaert';

-- 3. Geef de jaartallen (verschillend van NULL) van artikelen die ooit verkocht zijn
-- Sorteer oplopend
-- 2003 tot en met 2016
SELECT DISTINCT jaar
FROM artikel
WHERE artikelNr in (SELECT DISTINCT artikelNr FROM factuurregel) AND jaar IS NOT NULL
ORDER BY jaar;

-- 4. Onze vertegenwoordiger moet op bezoek bij Wijnhandel Copa Cava.
-- Hij zal van de gelegenheid gebruik maken om ook de andere klanten in de provincie te bezoeken.
-- Geef de lijst van deze klanten. Opgelet Wijnhandel Copa cava komt niet voor in de lijst!

-- KlantNr	Naam	Adres	Postcode	Plaats	Provincie	Unie
-- 1030	Wijnhandel Spoel	Dorpstraat 12	8800	Roeselare	WVL	13
-- 1031	Wijnhandel De Fles	Spechtstraat 56	9990	Maldegem	WVL	13
-- 1044	Wijnhandel Slokop	Thuishof 12	8300	Knokke	WVL	
SELECT *
FROM Klant
WHERE provincie = (SELECT provincie FROM Klant WHERE naam = 'Wijnhandel Copa Cava') and naam <> 'Wijnhandel Copa Cava';

-- 5. Geef de oudste unies

-- ToelatingsNr	Naam	OprichtingsJaar	Voorzitter
-- 23	Gentse Wijnunie	1963	J. Peykens
SELECT * FROM Unie
WHERE oprichtingsjaar = (SELECT min(oprichtingsjaar) FROM unie);

-- Breid de vorige query uit.
-- Welke klanten behoren tot de oudste unie?

-- KlantNr	Naam	Adres	Postcode	Plaats	Provincie	Unie
-- 1001	Wijnhandel Van den Bussche & Zonen	Vlaanderenstraat 110	9000	Gent	OVL	23
-- 1002	Evin Wine Store	Sint-Margrietstraat 16	9000	Gent	OVL	23
-- 1003	Caves Saint Amand	Gentbruggestraat 169	9040	Sint-Amandsberg	OVL	23
-- 1004	Wijnhuis Tinto	Blauwesteenstraat 75	9070	Heusden	OVL	23
-- 1008	Wijnen Lybaert	Olifantstraat 7/A	9000	Gent	OVL	23
-- 1045	Belgian Wines	Leasestraat 1	2000	Antwerpen	A	23
SELECT * FROM Klant
WHERE unie = (SELECT toelatingsnr FROM unie WHERE oprichtingsjaar = (SELECT min(oprichtingsjaar) FROM unie));

-- OF
SELECT k.*
FROM unie
	JOIN klant k ON k.unie = unie.toelatingsnr
WHERE oprichtingsjaar = (SELECT min(oprichtingsjaar) FROM unie);


-- 6. Geef alle klanten die ooit Freixenet kochten

-- KlantNr	Naam	Adres	Postcode	Plaats	Provincie	Unie
-- 1008	Wijnen Lybaert	Olifantstraat 7/A	9000	Gent	OVL	23

SELECT *
FROM Klant
WHERE klantnr IN 
	(SELECT DISTINCT klantNr 
    FROM factuur f 
		JOIN factuurregel fr ON f.factuurnr = fr.factuurnr
		JOIN artikel a ON a.artikelnr = fr.artikelNr
        JOIN soort s ON s.soortnr = a.soortNr
	WHERE s.naam = 'Freixenet');

-- 7. Geef de klanten die in minstens 3 verschillende maanden iets bestelden?.

-- KlantNr	Naam	Adres	Postcode	Plaats	Provincie	Unie
-- 1003	Caves Saint Amand	Gentbruggestraat 169	9040	Sint-Amandsberg	OVL	23
-- 1090	Wijnhandel Puerta del Sol	Bootlaan 1	2100	Deurne	A	
SELECT k.*
FROM Klant k
	JOIN factuur f ON k.klantnr = f.klantnr
GROUP BY k.klantnr
HAVING count(distinct month(f.factuurdatum)) >= 3;

-- Breid de vorige query uit
-- Zijn er klanten die in elke maand van 2017, zoals aanwezig in de databank, iets bestelden?
-- Antwoord: Resultset is leeg
SELECT k.*
FROM Klant k
	JOIN factuur f ON k.klantnr = f.klantnr
GROUP BY k.klantnr
HAVING (SELECT count(distinct month(f.factuurdatum)) FROM factuur f WHERE f.klantnr = k.klantnr AND year(f.factuurdatum) = 2017) = (SELECT count(distinct month(factuurdatum)) FROM factuur WHERE year(factuurdatum) = 2017);




-- 8. Zijn er atikelen waarbij de adviesverkoopprijs groter of gelijk is aan de maximum verkoopprijs van het artikel?
-- Sorteer oplopend op artikelnr    

-- ArtikelNr	SoortNr	Jaar	Inhoud	AdviesVerkoopprijs	Voorraad
-- 10802	1224	2014	0.75	29.5000	43
-- 10805	2137	2013	0.75	24.9000	36
-- 10807	4002	2012	0.7	75.0000	9
-- 10813	1205	2014	0.75	15.5000	78
-- 10816	4007		0.75	64.2500	10
-- 10817	4009		0.75	78.7500	4
-- 10819	1216	2005	0.75	72.0000	26
-- ....
SELECT a.*
FROM factuurregel fr
	JOIN artikel a ON fr.artikelNr = a.artikelnr
GROUP BY a.artikelNr
HAVING max(verkoopprijs) <= a.adviesverkoopprijs
ORDER BY a.artikelnr;


-- 9. Welke facturen bevatten artikelen die duurder verkocht zijn 
-- dan de adviesverkoopprijs van diezelfde artikelen?

-- FactuurNr	KlantNr	FactuurDatum
-- 173116	1003	2017-08-01 00:00:00
-- 173117	1050	2017-08-10 00:00:00
-- 173120	1001	2017-09-26 00:00:00
-- 173122	1022	2017-10-10 00:00:00
-- 173124	1008	2017-10-25 00:00:00

SELECT *
FROM factuur f
WHERE f.factuurnr IN 
		(SELECT DISTINCT factuurnr 
        FROM factuurregel fr
			JOIN artikel a ON a.artikelnr = fr.artikelnr
		WHERE verkoopprijs > adviesverkoopprijs);

-- 10. Geef alle artikelen met het hoogste alcolholpercentage.
-- Geef artikelnr, jaar, soortnaam en alcoholpercentage

-- artikelnr	jaar	naam	Alcoholperc
-- 10807	2012	Aultmore RM	50
SELECT a.artikelnr, jaar, s.Naam, Alcoholperc
FROM artikel a
	JOIN soort s ON a.soortnr = s.soortnr
WHERE s.alcoholperc = (SELECT max(alcoholperc) FROM soort);
