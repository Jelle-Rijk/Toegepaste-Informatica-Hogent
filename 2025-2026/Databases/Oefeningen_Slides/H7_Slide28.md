<h1>Oefeningen SELECT WHERE</h1>

```sql
-- Geef voornaam en familienaam van werknemers met code 54, die in een willekeurige afdeling werken met uitsluiting van afdeling D11
SELECT vnaam, fnaam FROM Werknemer WHERE code=54 AND afd <> 'D11';

-- Geef nummer, naam en afdelingsnummer van alle werknemers met salaris tussen 15000 en 24000 en niveau tussen 17 en 20
SELECT nr, vnaam, fnaam, afd FROM Werknemer WHERE salaris BETWEEN 15000 AND 24000 AND niv BETWEEN 17 AND 20;

-- Geef nummer, naam en opleidingsniveau van alle werknemers met niveau 16, 18 of 20
SELECT nr, vnaam, fnaam, niv FROM Werknemer WHERE niv IN (16,18,20);

-- Geef nummer, naam van vrouwelijke werknemers waarvan familienaam start met een ‘S ’ of ‘T ’
SELECT nr, vnaam, fnaam FROM Werknemer WHERE gesl = 'V' AND (fnaam Like 'S%' OR fnaam Like 'T%');

-- Geef nummer, naam van alle werknemers met onbekende jobcode
SELECT nr, vnaam, fnaam FROM Werknemer WHERE code IS NULL;

-- Geef nummer, naam en afdelingsnummer van alle werknemers, waarvan de familienaam start met een P en die in een afdeling werken beginnend met D en als 3e karakter een 1 hebben
SELECT nr, vnaam, fnaam, afd FROM Werknemer WHERE fnaam LIKE 'P%' AND afd LIKE 'D_1';

```
