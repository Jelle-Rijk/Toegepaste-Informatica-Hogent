-- 1. Tot welke unie behoort Wijnhuis Tinto? Geef de naam van de unie en het oprichtingsjaar.
-- Gentse Wijnunie, 1963
SELECT u.naam AS Naam, u.OprichtingsJaar as OprichtingsJaar
FROM klant
	JOIN unie u ON u.ToelatingsNr = klant.unie
WHERE klant.naam = 'Wijnhuis Tinto';

-- 2. Aan wie is op 29 juni 2017 een factuur verstuurd? Geef naam, adres, postcode en plaats.
-- 3 records
SELECT k.naam AS Naam, k.adres AS adres, k.postcode AS postcode, k.plaats as plaats
FROM klant k
	JOIN factuur f ON f.klantnr = k.klantnr
WHERE f.FactuurDatum = '2017-06-29';


-- 3. Welke whisky’s hebben een alcoholpercentage hoger dan 40? 
-- Geef productnaam, soortnummer en naam.
-- 4 records
SELECT pg.ProductNaam AS Naam, s.soortNr as Soortnummer, s.naam AS Soortnaam
FROM soort s
    JOIN productgroep pg ON s.productgroepnr = pg.productgroepnr
WHERE pg.productnaam = 'Whisky' AND s.alcoholperc > 40;

-- 4. Aan wie werden één of meer flessen Saint Véran gefactureerd? 
-- Toon het factuurnummer, het klantnummer, de naam van de klant en het aantal
-- 2 records
SELECT fr.factuurNr, k.klantnr, k.naam, fr.aantal
FROM factuurregel fr
	JOIN factuur ON factuur.FactuurNr = fr.factuurNr
    JOIN klant k ON factuur.klantnr = k.klantnr
    JOIN artikel ON fr.artikelNr = artikel.artikelnr
    JOIN soort s ON artikel.soortNr = s.soortNr
WHERE s.naam = 'Saint Véran';


-- 5. Welke wijnen uit het jaar 2008 hebben we in het assortiment? 
-- Toon naam, inhoud en adviesverkoopprijs.
-- 4 records
SELECT s.naam AS Naam, a.inhoud AS Inhoud, a.adviesverkoopprijs AS Adviesverkoopprijs
FROM artikel a
	JOIN soort s ON s.soortnr = a.soortnr
WHERE a.jaar = 2008;


-- 6. Toon alle artikelen uit de productgroepen Grappa, Cava, Gin en Sherry.
-- 13 records
SELECT *
FROM artikel a
	JOIN soort s ON a.soortnr = s.soortnr
    JOIN productgroep p ON p.productgroepnr = s.productgroepnr
WHERE p.productnaam IN ('Grappa', 'Cava', 'Gin', 'Sherry');

-- 7. Welke artikelen werden verkocht onder de adviesverkoopprijs? 
-- Geef artikelnummer,soortnummer en productnaam.
-- 5 records
SELECT a.artikelnr, a.soortnr, p.productnaam
FROM artikel a
     JOIN factuurregel fr ON a.ArtikelNr = fr.ArtikelNr
     JOIN soort s ON a.soortNr = s.soortNr
     JOIN productgroep p ON p.productgroepNr = s.productgroepnr
WHERE fr.Verkoopprijs < a.AdviesVerkoopprijs;

-- 8. Geef het artikelnummer en het soortnummer van deze artikelen 
-- die voorkomen op een factuurregel doch geen voorraad hebben.
-- 1 record: artikelnr 10854
SELECT DISTINCT a.artikelnr, a.soortnr
FROM factuurregel fr
	LEFT JOIN artikel a ON a.ArtikelNr = fr.artikelnr
WHERE voorraad = 0;

-- 9. Geef een overzicht van namen van de klanten voor wie op 29 of 30 juni 2017 
-- een factuur werd opgemaakt. Toon factuurnummer, factuurdatum en naam op volgorde van naam.
-- 5 records,factuurnummer 173108 is de eerste
SELECT factuurnr, factuurdatum, naam AS klant
FROM factuur f
JOIN klant k ON f.klantnr = k.klantnr
WHERE f.factuurdatum = '2017-06-29' OR f.FactuurDatum = '2017-06-30'
ORDER BY naam;

-- 10. Welke rode wijnen kunnen geleverd worden? Toon de naam, de flesinhoud en 
-- de adviesverkoopprijs. De duurste fles moet als eerste getoond worden.
-- 17 records, Rioja Crianza Sierra is de eerste
SELECT s.naam, a.inhoud, a.adviesverkoopprijs
FROM artikel a
	JOIN soort s ON s.soortnr = a.soortnr
    JOIN productgroep p ON p.ProductGroepNr = s.ProductGroepNr
WHERE p.productnaam = 'Wijn' AND s.kleur = 'rood' AND voorraad > 0
ORDER BY AdviesVerkoopprijs DESC;

-- 11. Geef een alfabetisch overzicht van de namen van alle klanten en 
-- de naam van de voorzitter van de unie waarbij ze aangesloten. Ook klanten die nog niet 
-- bij een unie zijn aangesloten moeten in het overzicht voorkomen.
-- 17 records
SELECT k.naam, voorzitter
FROM klant k
	LEFT JOIN unie u ON u.toelatingsnr = k.unie
ORDER BY k.naam;

-- 12. Geef de top 3 goedkoopste wijnen (artikelnummer, jaar en adviesverkoopprijs)
-- Tip: Zoek zelf eens de LIMIT clause voor MySQL op. artikelnummers: 10844, 10859 en 10848
SELECT a.artikelNr, a.jaar, a.adviesverkoopprijs
FROM artikel a
	JOIN soort s ON a.soortnr = s.SoortNr
    JOIN productgroep p ON s.ProductGroepNr = p.ProductGroepNr
ORDER BY AdviesVerkoopprijs
LIMIT 3;

-- 13. Toon de 3 artikelen van het type 'Cava' met de grootste voorraad (artikelnummer en voorraad Dalend gesorteerd).
-- Tip: Zoek zelf eens de LIMIT clause voor MySQL op. 3 records met voorraad tussen 177 en 20 stuks
SELECT a.artikelNr, voorraad
FROM artikel a
	JOIN soort s ON a.soortnr = s.SoortNr
    JOIN productgroep p ON s.ProductGroepNr = p.ProductGroepNr
WHERE p.productnaam = 'Cava'
ORDER BY voorraad DESC
LIMIT 3;

-- 14. Wat is de gemiddelde adviesverkoopprijs van de wijnen uit het jaar 2012? 
-- Geef een duidelijke hoofding.
-- €35,20
SELECT AVG(adviesverkoopprijs) as GemAdviesPrijs
FROM artikel a
		JOIN soort s ON a.soortnr = s.SoortNr
    JOIN productgroep p ON s.ProductGroepNr = p.ProductGroepNr
WHERE p.productnaam = 'Wijn'
GROUP BY jaar
HAVING jaar = 2012;

-- 15. Wat is de prijs van de duurste witte wijn?
-- €90,50
SELECT max(adviesverkoopprijs)
FROM artikel a
	JOIN soort s ON a.soortnr = s.SoortNr
    JOIN productgroep p ON s.ProductGroepNr = p.ProductGroepNr
WHERE p.productnaam = 'wijn' AND kleur = 'wit';

-- 16. Toon het kleinste aantal flessen Whisky op voorraad. Geef hiervan de soortnaam.
-- Avoca, 1
SELECT s.naam, voorraad
FROM artikel a
	JOIN soort s ON a.soortnr = s.SoortNr
    JOIN productgroep p ON s.ProductGroepNr = p.ProductGroepNr
WHERE p.productnaam = 'Whisky'
ORDER BY voorraad
LIMIT 1;


-- 17. Van welke soorten (naam) komen er geen artikelen voor?
-- 19 record
SELECT s.naam
FROM soort s
	LEFT JOIN artikel a ON s.soortnr = a.soortnr
WHERE a.SoortNr IS NULL;

-- 18. Toon het grootste aantal liter Grappa in voorraad.
-- 11,25 liter
SELECT (inhoud * voorraad) AS liter_in_voorraad
FROM artikel a
	JOIN soort s ON a.soortnr = s.SoortNr
    JOIN productgroep p ON s.ProductGroepNr = p.ProductGroepNr
WHERE p.productnaam = 'Grappa'
ORDER BY (inhoud * voorraad) DESC
LIMIT 1;

-- 19. Voor welk bedrag is op 17 oktober 2017 aan klanten die niet uit Gent komen gefactureerd?
-- €347,50
SELECT SUM(fr.verkoopprijs * fr.aantal) AS totaal
FROM factuurregel fr
	JOIN factuur f ON fr.FactuurNr = f.FactuurNr
    JOIN klant k ON k.klantnr = f.klantnr
WHERE k.plaats <> 'Gent' AND f.FactuurDatum = '2017-10-17';

-- 20. Geef per productgroep de productnaam, het aantal artikelen en de gemiddelde, 
-- de hoogste en de laagste adviesverkoopprijs. Sorteer alfabetisch op productnaam.
-- 9 records, voor Cava met respectievelijk 4, €12,37, €5,49, €25,00
SELECT p.productnaam, count(*) AS aantal_artikelen, AVG(adviesverkoopprijs) AS GemAdviesprijs, MIN(adviesverkoopprijs) AS MinAdviesprijs, MAX(adviesverkoopprijs) AS MaxAdviesprijs
FROM productgroep p
	JOIN soort s ON p.productgroepnr = s.productgroepnr
    JOIN artikel a ON s.soortnr = a.soortnr
GROUP BY p.ProductGroepNr
ORDER BY p.productnaam;

-- 21. Geef per factuur de naam van de klant, het factuurnummer en 
-- het totale factuurbedrag. De duurste factuur moet als eerste staan.
-- 23 records, Wijnen Lybaert staat als eerste met factuurnr 173124 en een factuurbedrag van €5100,00
SELECT k.naam, f.factuurNr, SUM(fr.aantal * fr.verkoopprijs)
FROM factuur f
	JOIN klant k ON k.klantnr = f.klantnr
    JOIN factuurregel fr ON fr.FactuurNr = f.factuurnr
GROUP BY f.factuurNr
ORDER BY SUM(fr.aantal * fr.verkoopprijs) DESC;

-- 22. Geef per soort rode wijn het totaal aantal flessen en 
-- het totaal aantal liter op voorraad. Toon eveneens de soortnaam. Sorteer op volgorde van soortnaam.
-- 13 records, voor Léoville Barton is het aantal flessen 25 en het aantal liter 18,75
SELECT s.naam, SUM(voorraad) AS aantalFlessen, SUM(voorraad * inhoud) AS aantalLiter
FROM artikel a
	JOIN soort s ON a.soortnr = s.SoortNr
    JOIN productgroep p ON s.ProductGroepNr = p.ProductGroepNr
WHERE s.kleur = 'rood' AND p.productnaam = 'wijn'
GROUP BY s.naam
ORDER BY s.naam;

-- 23. Welke unie(‘s) hebben geen leden (klanten)?
-- 1 record Antwaarp Wijn
SELECT u.naam
FROM unie u
	LEFT JOIN klant k ON u.ToelatingsNr = k.Unie
WHERE k.unie IS NULL;

-- 24. Van welke producten hebben we meer dan 100 liter in voorraad? Druk alfabetisch af.
-- 3 records: Cava, Champagne en Wijn
SELECT p.productnaam
FROM artikel a
	JOIN soort s ON a.soortnr = s.SoortNr
    JOIN productgroep p ON s.ProductGroepNr = p.ProductGroepNr
GROUP BY p.productnaam
HAVING sum(voorraad * inhoud) > 100
ORDER BY p.productnaam;

-- 25. Van welke soort hebben we in oktober 2017 meer dan 10 flessen verkocht? 
-- Laat de soortnaam en het aantal flessen afdrukken op volgorde van dalend aantal flessen.
-- 1 record: Riesling Auslese met 201 flessen
SELECT s.naam, sum(fr.aantal)
FROM factuurregel fr
	LEFT JOIN factuur f ON fr.factuurnr = f.factuurnr
    JOIN artikel a ON a.artikelnr = fr.artikelnr
    JOIN soort s ON s.soortnr = a.soortnr
WHERE f.factuurDatum BETWEEN '2017-10-01' AND '2017-10-31'
GROUP BY s.naam
HAVING SUM(fr.aantal)>10
ORDER BY SUM(fr.aantal) DESC;

-- 26. Welke vijf artikelen zijn in aantal flessen het best verkocht in 2017? 
-- Toon artikelnummer, soortnaam en aantal flessen.
-- 5 records
SELECT a.artikelnr AS artikelnummer, s.naam AS soortnaam, SUM(fr.aantal) AS aantalFlessen
FROM artikel a
	JOIN soort s ON a.soortnr = s.soortnr
    JOIN factuurregel fr ON fr.ArtikelNr = a.artikelnr
    JOIN factuur f ON fr.factuurnr = f.factuurnr
WHERE YEAR(f.factuurdatum) = 2017
GROUP BY a.artikelnr
ORDER BY SUM(fr.aantal) DESC
LIMIT 5;