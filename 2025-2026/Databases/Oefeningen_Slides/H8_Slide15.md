```sql
/*Tel het aantal werknemers uit de afdeling D11 en geef het maximum, minimum en gemiddeld salaris voor deze afdeling, alsook het aantal verschillende jobcodes uit deze afdeling. Geef ook de som van alle lonen betaald in afdeling D11*/

SELECT COUNT(*), MAX(salaris), MIN(salaris), AVG(salaris), SUM(salaris), COUNT(DISTINCT code) FROM werknemer WHERE afd = 'D11';

/* Geef per afdeling, het afdnr en het aantal werknemers, gesorteerd volgens afdelingsnummer*/
SELECT afd, COUNT(*) AS aantalWerknemers FROM werknemer GROUP BY afd ORDER BY afd;

/*Idem, maar nu aflopend gesorteerd volgens aantal werknemers*/
SELECT afd, COUNT(*) AS aantalWerknemers FROM werknemer GROUP BY afd, ORDER BY COUNT(*) DESC;

/*Idem maar nu wens je het aantal werknemers te kennen per afdeling en per jobcode*/
SELECT afd, code, COUNT(*) AS aantalWerknemers FROM werknemer GROUP BY afd, code ORDER BY COUNT(*) DESC;

/*Tel per afdeling het aantal mannen en vrouwen en sorteer volgens opklimmende afdeling en afdalend geslacht*/
SELECT afd, gesl, COUNT(*) FROM werknemer GROUP BY afd, gesl ORDER BY afd, gesl DESC;

/*Geef een overzicht van de afdelingen die tenminste 2 werknemers hebben die meer dan 1000 verdienen*/
SELECT afd FROM werknemer WHERE salaris > 1000 GROUP BY afd HAVING COUNT(*) >= 2;
```
