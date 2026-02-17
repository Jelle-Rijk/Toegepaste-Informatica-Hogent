/*Toon een alfabetische adreslijst van alle leveranciers (naam, leverancierscode, adres en woonplaats). 
Sorteer op woonplaats in dalende volgorde. 
Bij gelijke woonplaats komen de namen van de leveranciers in alfabetische volgorde.*/
SELECT naam, levCode, adres, woonplaats FROM leveranciers order by woonplaats DESC, naam;

/*Toon de unieke leverancierscode van de leveranciers waarbij bestellingen zijn geplaatst.*/
SELECT DISTINCT levCode FROM bestellingen;

/*Geef een alfabetische lijst van alle planten (naam) waarvan de naam eindigt op 'bloem'.*/
SELECT DISTINCT naam FROM planten WHERE naam LIKE '%bloem' ORDER BY 1;

/*Geef een overzicht (alle gegevens) van alle leveranciers die wonen te Antwerpen, Heusden of Leuven.*/
SELECT * FROM leveranciers WHERE woonplaats IN ('Antwerpen', 'Heusden', 'Leuven');

/*Toon de naam, artikelcode en prijs van de planten waarvan de bloei begint in april.*/
SELECT naam, artCode, prijs, bl_b FROM planten WHERE bl_b = 4;

/*Geef een overzicht van alle planten waarvan de bloeiperiode begin en/of bloeiperiode einde niet is ingevuld. 
Toon de naam van de planten en een aanduiding, gebruik hiervoor een case expressie en noem de kolom "bloeiperiode", 
de volgende aanduidingen zijn mogelijk:
	Beginperiode niet opgegeven: indien enkel bl_b niet is ingevuld
	Eindperiode niet opgegeven: indien enkel bl_e niet is ingevuld
	Periodes niet opgegeven: indien beide niet ingevuld*/

SELECT naam,
	CASE
		WHEN bl_e IS NOT NULL AND bl_b IS NULL THEN 'Beginperiode niet opgegeven'
        WHEN bl_b IS NOT NULL AND bl_e IS NULL THEN 'Eindperiode niet opgegeven'
        ELSE 'Periodes niet opgegeven'
    END AS 'bloeiperiode'
FROM planten WHERE bl_e IS NULL or bl_b IS NULL;

/*Geef de namen van de planten waarin het woordje 'boom' voorkomt of waarvan de naam bestaat uit 5 posities.*/
SELECT naam FROM planten WHERE (naam LIKE '%boom' OR naam LIKE '_____');

/*Toon naam en woonplaats van de leveranciers die niet in Lisse wonen.*/
SELECT naam, woonplaats FROM leveranciers WHERE woonplaats <> 'Lisse';

/*Toon naam van de planten waarvan de bloeiperiode begint tussen juni en oktober.*/
SELECT naam FROM planten WHERE bl_b BETWEEN 6 AND 10;

/*Geef artikelcode en naam van de planten waarvan de naam begint met een L en eindigt met een E.*/
SELECT artCode, naam FROM planten WHERE naam LIKE 'L%E';

/*Geef de namen van de planten waarvan de naam een spatie bevat.*/
SELECT naam FROM planten WHERE naam LIKE '% %';

/*Toon de verschillende woonplaatsen (alfabetisch) van de leveranciers.*/
SELECT DISTINCT woonplaats FROM leveranciers ORDER BY 1;

/*Toon de bestelnummers van de bestellingen voor een bedrag van meer dan 250 euro die binnen de 14 dagen werden geleverd.*/
SELECT bestelnr FROM bestellingen WHERE bedrag > 250 AND datediff(leverdatum, besteldatum) < 14;

/*Geef een alfabetisch overzicht van de plantnamen die uit maximaal 5 letters bestaan.*/
SELECT naam FROM planten WHERE LENGTH(naam) <= 5 ORDER BY naam;

/*Toon de naam en de hoogte van de planten die tussen de 10 en de 50 cm of de 100 en 150 cm hoog zijn. Naast de hoogte moet de tekst 'cm' worden weergegeven.*/
SELECT naam, concat(hoogte, "cm") AS planthoogte FROM planten WHERE hoogte BETWEEN 10 and 50 OR hoogte BETWEEN 100 AND 150;