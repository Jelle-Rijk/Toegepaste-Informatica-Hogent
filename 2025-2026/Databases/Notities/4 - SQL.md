<h1>SQL - Standard Query Language</h1>

- [Standaarden en dialecten](#standaarden-en-dialecten)
- [SELECT](#select)
  - [Voorwaarden stellen - WHERE](#voorwaarden-stellen---where)
  - [Resultaten formatteren](#resultaten-formatteren)
    - [Sorteren - ORDER BY](#sorteren---order-by)
    - [Alias - AS](#alias---as)
  - [Functies](#functies)
  - [Groeperen en aggregaatsfuncties](#groeperen-en-aggregaatsfuncties)
    - [GROUP BY en HAVING](#group-by-en-having)
  - [Selecteren uit meerdere tabellen - JOIN / ON](#selecteren-uit-meerdere-tabellen---join--on)
    - [INNER JOIN](#inner-join)
    - [OUTER JOIN](#outer-join)
    - [CROSS JOIN](#cross-join)
  - [Resultaten van queries combineren - UNION](#resultaten-van-queries-combineren---union)

# Standaarden en dialecten

Standaard werd vastgelegd in ANSI/ISO-1992

Bestaat uit:

- Data Definition Language (DDL) -> Je kan databases en definities van objecten creëren, aanpassen en verwijderen. (CREATE, ALTER, DROP)
- Data Manipulation Language (DML) -> Opvragen en manipuleren van gegevens in een database. (SELECT, INSERT, UPDATE, DELETE)
- Data Control Language (DCL) -> Stelt de gegevensbeveiliging en autorisatie in. (GRANT, REVOKE, DENY)
- Verschillende operatoren, functies en flow controls

# SELECT

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

## Voorwaarden stellen - WHERE

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

### Sorteren - ORDER BY

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

### Alias - AS

Je kan een kolom in het resultaat een alias geven.

```sql
-- Toont de kolom medewerkernr als Regisseurnummer
SELECT medewerkernr AS Regisseurnummer FROM employees WHERE role='director';
```

Je kan via aliassen ook berekende resultaten teruggeven. Hiervoor moet je de operatoren `+, -, /, *` gebruiken.

```sql
-- Bereken de waarde van de units in de stock
SELECT ProductName, UnitPrice * UnitsInStock AS InventoryValue FROM Products;
```

## Functies

Je kan in de argumenten verschillende waarden berekenen. Heirvoor gebruik je functies:

- Strings: concat, left, right, length, substring, replace,...
- DateTime: dateAdd, dateDiff, day, month, year, now(), curDate(),...
- Rekenkundig: round, floor, ceil, cos, sin,...
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

## Groeperen en aggregaatsfuncties

Aggregaatsfuncties / Statistische functies returnen één antwoord per kolom en kunnen dus niet op rijniveau gebruikt worden (i.e. bij WHERE)

SQL heeft er standaard 5:

- SUM(expression)
- AVG(expression)
- MIN(expression)
- MAX(expression)
- COUNT([DISTINCT] kolomnaam) -> telt de entries in de kolom, met het keyword DISTINCT tellen enkel de unieke resultaten.

-> NULL-waarden worden niet meegerekend in deze aggregaatfuncties.

Met COUNT(\*) kan je alle rijen in de selectie tellen (onafhankelijk van niet-ingevulde kolommen).

### GROUP BY en HAVING

Groepeert rijen met gemeenschappelijke kenmerken -> Per groep, één rij weergegeven

Op een groep kan je wel aggregaatsfuncties toepassen.

```sql
-- Groepeert alle producten met hetzelfde categoryID, telt ze en returnt het aantal + ID per groep.
SELECT CategoryID, COUNT(productID) AS AANTAL FROM PRODUCTS GROUP BY CategoryID;
```

Als je een "gewoon veld" opgeeft na SELECT in combinatie met één of meerdere aggregatiefuncties, moeten alle gewone velden in GROUP BY geplaatst worden.

HAVING werkt hetzelfde als WHERE, maar dan voor groepen.

```sql
-- Toont het aantal producten voor elke categorie die meer dan 10 producten in voorraad bevat.
SELECT CategoryID, COUNT(productID) AS Aantal -- toon categoryID en het aantal producten per groep
FROM Products
WHERE UnitsInstock > 0 -- selecteer enkel producten die in voorraad zijn
GROUP BY CategoryID -- groepeer de producten per categorie
HAVING COUNT(*) > 10 -- selecteer enkel de categorieën die meer dan 10 producten bevatten
```

## Selecteren uit meerdere tabellen - JOIN / ON

JOIN: kiest de tabellen die je samenvoegt <br>
ON: beschrijft hoe je wil samenvoegen (voorwaarde)

Resultaat = één resultset waarin de rijen uit de tabellen gekoppeld zijn.

```sql
-- Basissyntax
SELECT uitdrukking FROM tabel JOIN andereTabel ON voorwaarde;

-- Meerdere tabellen joinen
SELECT uitdrukking FROM tabel JOIN andereTabel ON voorwaarde JOIN nogEenTabel ON voorwaarde;
```

Als je met meerdere tabllen werkt, kun je ze een alias geven door een spatie + alias na de tabelnaam in FROM of JOIN te zetten.

Kolomnaam komt in meerdere tabellen voor -> altijd tabelnaam of alias meegeven.

### INNER JOIN

Koppelt rijen uit de ene tabel met rijen uit een andere tabel op basis van gemeenschappelijke waarden in beide kolommen. Je kan de relatie tussen de velden uitdrukken met vergelijkingsoperatoren, maar meestal heb je = nodig (EQUI-JOIN).

```sql
-- Selecteer alle orders waarbij Shipcountry niet België, Frankrijk of Duitsland is. Geef van die orders alle details terug (die in een andere tabel worden opgeslagen).

SELECT orders.OrderID, ShipCountry, ProductID, Quantity
FROM orders JOIN order_details -- tabel order_details wordt toegevoegd aan de resultaten
    ON orders.OrderID = order_details.OrderID -- de rijen met dezelfde OrderID uit beide tabellen worden gekoppeld.
WHERE ShipCountry not in ('Belgium', 'France', 'Germany');
```

Inner Joins tonen enkel de rijen die aan de ON-conditie voldoen.

```sql
-- INNER JOIN dus de supervisors (alias sv) die niet bij een werknemer (alias wn) horen, worden niet teruggegeven.
SELECT sv.nr, vnaam, fnaam
FROM supervisors sv JOIN werknemer wn
ON sv.nr = wn.supervisor;
```

### OUTER JOIN

Retourneert alle record van een tabel, ook als niet aan de voorwaarde in ON voldaan wordt.

Drie types:

- LEFT OUTER JOIN: Returnt alle rijen van de tabel voor het keyword JOIN.
- RIGHT OUTER JOIN: Returnt alle rijen van de tabel na het keyword JOIN.
- FULL OUTER JOIN (niet in MySQL): Returnt alle rijen uit beide tabellen.

Als je keyword LEFT of RIGHT voor JOIN gebruikt, mag je OUTER ook weglaten.

```sql
-- OUTER JOIN dus de supervisors (alias sv) die niet bij een werknemer (alias wn) horen, zullen ook in de lijst staan.
SELECT sv.nr, vnaam, fnaam
FROM supervisors sv LEFT JOIN werknemer wn
ON sv.nr = wn.supervisor;
```

### CROSS JOIN

Een cross join returnt elke mogelijke combinatie van rijen in beide tabellen.

Aantal rijen dat gereturnd wordt is: `aantalRijenTabel1 * aantalRijenTabel2`

## Resultaten van queries combineren - UNION

UNION combineert de resultaten, zo lang er even veel kolommen zijn van hetzelfde datatype. De getoonde namen voor de kolommen zijn de kolomnamen van de eerste query.

```sql
SELECT firstname + '' + lastname AS name, city, postalcode FROM Employees
UNION
SELECT companyname, city, postalcode FROM Customers;

-- Returnt drie kolommen: name, city en postalcode waarin de gegevens van de Employees en Customers staan.
```
