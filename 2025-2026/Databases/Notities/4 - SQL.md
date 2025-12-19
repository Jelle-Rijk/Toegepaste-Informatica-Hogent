<h1>SQL - Standard Query Language</h1>

- [Standaarden en dialecten](#standaarden-en-dialecten)
- [Select](#select)
  - [WHERE](#where)
  - [Resultaten formatteren](#resultaten-formatteren)
    - [Sorteren](#sorteren)
  - [Formatteren](#formatteren)
    - [Alias](#alias)
    - [Functies / Berekeningen](#functies--berekeningen)

# Standaarden en dialecten

Standaard werd vastgelegd in ANSI/ISO-1992

Bestaat uit:

- Data Definition Language (DDL) -> Je kan databases en definities van objecten creëren, aanpassen en verwijderen. (CREATE, ALTER, DROP)
- Data Manipulation Language (DML) -> Opvragen en manipuleren van gegevens in een database. (SELECT, INSERT, UPDATE, DELETE)
- Data Control Language (DCL) -> Stelt de gegevensbeveiliging en autorisatie in. (GRANT, REVOKE, DENY)
- Verschillende operatoren, functies en flow controls

# Select

SELECT gebruik je om gegevens op te vragen.

```sql
-- Standaarvorm
SELECT kolommen FROM tabelnaam;

-- DEFAULT - toont alle ook niet-unieke waarden. Is kort voor
SELECT ALL kolommen FROM tabelnaam;

-- Je kan ook enkel de unieke waarden opvragen
SELECT DISTINCT country FROM customers;
-- Dit voorbeeld zou alle verschillende landen waartoe customers behoren teruggeven, zonder duplicaten.
-- NULL-velden worden door DISTINCT als gelijk beschouwd.

-- Extra opties, alles vanaf WHERE is optioneel
SELECT kolommen FROM tabelnaam WHERE voorwaarden GROUP BY kolomnaam HAVING voorwaarde ORDER BY sorteermethode;

```

| Onderdeel         | Uitleg                                            | Speciale symbolen   |
| ----------------- | ------------------------------------------------- | ------------------- |
| Select            | Kolommen die teruggegeven worden specifiëren      | \* => alle kolommen |
| FROM              | Keuze van tabel                                   |
| WHERE             | Voorwaarde waaraan de rij moet voldoen            |
| ORDER BY          | Bepaalt volgorde waarin rijen teruggegeven worden |
| GROUP BY + HAVING | Groepeert de gegevens                             |

Meerdere argumenten worden opgelijst met komma's.

```sql
SELECT firstName, lastName  FROM customers;
```

## WHERE

Voorwaarden kunnen uit verschillende onderdelen bestaan.

Vergelijkingsoperatoren: =, >, >=, <, <=, <> <br>
<> = not equals

Let op! Er wordt enkel vergeleken met non-NULL values. Als je ook de NULL-values terug wil krijgen, moet je de IS NULL operator gebruiken.

```sql
-- Returnt enkel personen waarvan de haarkleur gekend is en niet bruin is.
SELECT firstName, lastName from people WHERE haircolor <> 'brown';

-- Returnt ook de personen waarvan de haarkleur niet gekend is.
SELECT firstName, lastName from people WHERE haircolor <> 'brown' OR IS NULL;
```

Je kan zoeken naar patronen met wildcards in combinatie met de operator LIKE of NOT LIKE.

| Wildcard | Betekenis                         |
| -------- | --------------------------------- |
| %        | 0 of meerdere willekeurige tekens |
| \_       | 1 teken                           |

```sql
-- Retourneert de producten die beginnen met een T (niet-hoofdlettergevoelig).
SELECT productid, productname FROM products WHERE productname LIKE 'T%';

-- Retourneert de producten die geen S (niet-hoofdlettergevoelig) bevatten.
SELECT productid, productname FROM products WHERE productname NOT LIKE '%S%';
```

Als de voorwaarde een interval aangeeft gebruik je BETWEEN / NOT BETWEEN.

```sql
-- Alle producten waarvan de unitprice tussen 10 en 15 ligt.
SELECT productid, unitprice FROM products WHERE unitprice BETWEEN 10 AND 15;
```

Je kan ook rijen opvragen waarbij de gecheckte waarden (niet) in een meegegeven lijst voorkomen. Je gebruikt dan IN / NOT IN

```sql
-- Alle producten van supplier 1, 3, of 5
SELECT productid, productname, supplierid FROM products WHERE supplierid IN (1,3,5);
```

Je kan ook testen of een waarde ingevuld is met IS NULL / IS NOT NULL.

```sql
-- Selecteer leveranciers zonder gekende regio
SELECT companyname, region FROM supplies WHERE region IS NULL;
```

**OPMERKING**: Rekenkundige uitdrukkingen met NULL-values resulteren in NULL.

## Resultaten formatteren

### Sorteren

ORDER BY sorteert de data volgens de opgegeven sorteervelden en operator (DEFAULT = ASC).

De opgegeven kolommen na SELECT krijgen een automatisch toegewezen nummer.

```sql
-- Sorteer op oplopende productnaam (default) -> van minder naar meer verboos.
SELECT productname FROM products;
SELECT productname FROM products ORDER BY productname;
SELECT productname FROM products ORDER BY productname ASC;

-- Sorteer op oplopende productnaam, gebruik kolomnummer
SELECT productname FROM products ORDER BY 1;

-- Sorteer op aflopende productnaam
SELECT productname FORM products ORDER BY productname DESC;

-- Sorteert eerst op oplopende categorie, daarna - binnen de categorie - op aflopende prijs.
SELECT productid, productname, categoryid, unitprice FROM products ORDER BY categoryid, unitprice DESC;
```

## Formatteren

### Alias

Je kan een kolom in het resultaat een alias geven.

```sql
-- Toont de kolom medewerkernr als Regisseurnummer
SELECT medewerkernr AS Regisseurnummer FROM employees WHERE role='director';
```

### Functies / Berekeningen

Je kan via aliassen ook berekende resultaten teruggeven. Hiervoor moet je de operatoren `+, -, /, *` gebruiken.

```sql
-- Bereken de waarde van de units in de stock
SELECT ProductName, UnitPrice * UnitsInStock AS InventoryValue FROM Products;
```

Voor berekeningen kan je ook functies gebruiken:

- Strings: concat, left, right, length, substring, replace,...
- DateTime: dateAdd, dateDiff, day, month, year, now(), curDate(),...
- Rekenkundig: round, floor, ceil, cos, sin,...
- Aggregate: avg, sum, min, max,...
- IFNULL(kolom, x): Vervang gevonden NULL-waardes in kolom door x.

Dataconversies gebeuren voor sommige omzettingen impliciet, maar kan ook expliciet via CAST of CONVERT.

```sql
-- Cast decimal naar integer
CAST(-25.25 AS INTEGER) -- returnt -25
CONVERT(CURDATE(), CHAR) -- returnt de datum van vandaag als 'YYYY-MM-DD'

-- Strings - concat
SELECT CONCAT(productid, ',', productname) as Product FROM Products; -- returnt de kolom Product die bestaat uit id en naam gescheiden door een komma.

-- String literals
SELECT ProductName, '$', UnitPrice FROM Products; -- returnt ook een kolom met de naam $ die overal waarde $ heeft.

```

CASE werkt als een switch-functie in Java.

```sql
-- Een kolom verschepingskost wordt als één van de strings berekend
SELECT OrderId, Freight,
    CASE
        WHEN Freight IS NULL THEN 'Kost onbekend'
        WHEN Freight = 0 THEN 'Gratis verscheping'
        WHEN Freight < 20 THEN 'Lage verschepingskost'
        WHEN FREIGHT < 100 THEN 'Gemiddelde verschepingskost'
        ELSE 'Hoge verschepingskost'
    END AS 'Verschepingskost'
FROM orders;
```
