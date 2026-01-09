SHOW TABLES;

/*Tel het aantal werknemers uit de afdeling D11 en geef het maximum, minimum en gemiddeld salaris voor deze afdeling, 
alsook het aantal verschillende jobcodes uit deze afdeling. 
Geef ook de som van alle lonen betaald in afdeling D11*/
SELECT COUNT(*) AS aantalWerknemers, MIN(salary) AS minimumSalaris, AVG(salary) AS gemiddeldSalaris, COUNT(distinct title)
WHERE afd = 'D11';

/*Geef per afdeling, het afdnr en het aantal werknemers, gesorteerd volgens afdelingsnummer.*/

/*Idem, maar nuaflopendgesorteerd volgens aantal werknemers.*/

/*Idem maar nu wens je het aantal werknemers te kennen per afdeling en per jobcode.*/

/*Tel per afdeling het aantal mannen en vrouwen en sorteer volgens opklimmende afdeling en afdalend geslacht.*/

/*Geef een overzicht van de afdelingen die tenminste 2 werknemers hebben die meer dan 1000 verdienen.*/