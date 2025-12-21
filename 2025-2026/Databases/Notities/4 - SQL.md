<h1>SQL - Standard Query Language</h1>

- [Inleiding](#inleiding)
- [Queries - SELECT](#queries---select)
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
  - [Subqueries](#subqueries)
- [Andere DML - Data Manipulation Language](#andere-dml---data-manipulation-language)
  - [Data toevoegen - INSERT](#data-toevoegen---insert)
  - [Data wijzigen - UPDATE](#data-wijzigen---update)
  - [Data verwijderen - DELETE](#data-verwijderen---delete)
- [DDL - Data Definition Language](#ddl---data-definition-language)
  - [Databanken manipuleren](#databanken-manipuleren)
  - [Tabellen manipuleren](#tabellen-manipuleren)
  - [Datatypes](#datatypes)
  - [Constraints](#constraints)
    - [AUTO_INCREMENT](#auto_increment)
    - [Primaire sleutel](#primaire-sleutel)
    - [Vreemde sleutels](#vreemde-sleutels)

# Inleiding

SQL = Standard Query Language

Standaard werd vastgelegd in ANSI/ISO-1992

Bestaat uit:

- Data Definition Language (DDL) -> Je kan databases en definities van objecten creëren, aanpassen en verwijderen. (CREATE, ALTER, DROP)
- Data Manipulation Language (DML) -> Opvragen en manipuleren van gegevens in een database. (SELECT, INSERT, UPDATE, DELETE)
- Data Control Language (DCL) -> Stelt de gegevensbeveiliging en autorisatie in. (GRANT, REVOKE, DENY)
- Verschillende operatoren, functies en flow controls

# Queries - SELECT

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

## Subqueries

Je voegt een extra SELECT toe tussen haakjes in de WHERE of HAVING clause van de buitenste query. De subquery wordt altijd eerst uitgevoerd en staat tussen haakjes.

Returnt één of een lijst van waarde(n).

```sql
/*Subquery vs. Order By met een Limit
We zoeken in beide gevallen het duurste product*/

-- Subquery (zal alle producten returnen als er meerdere producten met de hoogste prijs zijn)
SELECT ProductID, ProductName, UnitPrice as MaxPrice
FROM Products
WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM PRODUCTS);

-- LIMIT 1 (returnt maar één product, ook als er meerdere het duurst zijn)
SELECT ProductID, ProductName, UnitPrice as MaxPrice
FROM Products
ORDER BY UnitPrice DESC
LIMIT 1;

/*Subquery die een kolom als lijst returnt, je kan daar dan in zoeken. We zoeken hier alle employees die een order verwerkt hebben.*/
SELECT e.EmployeeID, CONCAT(e.FirstName, '', e.LastName) AS FullName -- Het resultaat is een ID en voor- + familienaam
FROM Employees e
WHERE e.EmployeeID IN (SELECT DISTINCT EmployeeID FROM Orders); -- De subquery returnt alle unieke IDs in de tabel Orders en gebruiken IN om de employees in de main query te filteren.
```

Subqueries kunnen velden uit de tabellen van de buitenste query gebruiken, andersom niet.

Als de subquery afhankelijk is van info uit de buitenste query is dit een **gecorreleerde subquery**.

Een gecorreleerde subquery wordt per rij van de buitenste query uitgevoerd en is daardoor een dure operatie. Probeer te vermijden (beter JOIN, CTE - Common Table Expression = leerstof tweede jaar - of eenvoudige subquery).

```sql
-- Niet-gecorreleerde subquery. We zoeken de producten die meer dan gemiddeld kosten.
SELECT ProductId, ProductName, UnitPrice
FROM Products
WHERE UnitPrice > (SELECT AVG(UnitPrice) FROM Products); -- Subquery wordt eerst één keer berekend, returnt het resultaat. Dan wordt de buitenste query uitgevoerd.

-- Gecorreleerde subquery. We zoeken de producten die meer kosten dan het gemiddelde van hun categorie.
SELECT ProductId, ProductName, UnitPrice, CategoryId
FROM Products p
WHERE UnitPrice > (SELECT AVG(UnitPrice) FROM Products WHERE categoryId = p.categoryId); -- Deze lijn heeft informatie van de buitenste query nodig (p.categoryId - de categorie van het huidige product) en wordt dus per rij die gecheckt wordt door de buitenste query opnieuw berekend.
```

Je kan checken of een berekening in een subquery bestaat met EXISTS/NOT EXISTS.

```sql
-- EXISTS returnt true als er een resultaat in de subquery zit. Hieronder dus elke customer die een Order heeft.
SELECT c.CustomerID, c.CompanyName
FROM Customers c
WHERE EXISTS (SELECT * FROM Orders WHERE CustomerID = c.customerID);

-- NOT EXISTS returnt true als de subquery leeg is. Hieronder dus alle klanten zonder Order.
SELECT c.CustomerID, c.CompanyName
FROM Customers c
WHERE NOT EXISTS (SELECT * FROM Orders WHERE CustomerID = c.customerID);

-- Alternatief voor NOT EXISTS met JOIN
SELECT c.CustomerID, c.CompanyName
FROM Customers c
  LEFT JOIN Orders O on c.CustomerId = o.CustomerID -- voeg de Orders toe aan de customers.
WHERE o.CustomerID IS NULL -- Customers zonder order zullen een NULL in het veld CustomerID bij de orderinfo hebben.
```

# Andere DML - Data Manipulation Language

## Data toevoegen - INSERT

```sql
-- Standaardnotatie

-- Methode 1: Enkel de kolommen met niet-NULL waarden opgeven
INSERT INTO tabelnaam (kolomnaam1, kolomnaam4)
VALUES(value1, value2);
-- = (value1, NULL, NULL, value2)

-- Methode 2: Alle kolommen invullen
INSERT INTO tabelnaam
VALUES (value1, NULL, NULL, value2);

-- Met alle optionele stukken
INSERT LOW_PRIORITY IGNORE INTO tabel(col1, col2)
VALUES (value1, value2)
ON DUPLICATE KEY UPDATE assignment_list;
```

Als je geen kolomnaam opgeeft -> waarden volgens kolomvolgorde.

Verplichte waarden moeten ingevuld zijn. Alle waarden moeten het juiste datatype of NULL zijn.

Niet-ingevulde kolommen worden NULL, tenzij er in de constraints een defaultwaarde toegekend wordt.

Auto-increment kolommen mogen nooit in een INSERT staan.

## Data wijzigen - UPDATE

```sql
-- Standaardnotatie
UPDATE tabel
SET assignment_list;

-- Alle opties
UPDATE LOW_PRIORITY IGNORE tabel
SET assignment_list
WHERE condition
ORDER BY order
LIMIT row_count;
```

Een assignment list ziet er als volgt uit:

```sql
-- Alle rijen in een tabel wijzigen
UPDATE Products
SET unitprice = (unitprice*1.1);

-- Specifieke rijen wijzigen
UPDATE Products
SET unitprice = (unitprice*1.1)
WHERE productname = 'Koffie';

-- Meerdere velden wijzigen
UPDATE Products
SET unitprice = (unitprice*1.1), unitsinstock = 0;

-- Je kan waarden op NULL zetten met een voorwaarde via NULLIF
UPDATE employees
SET reportsTo = NULLIF(reportsTo, 101);
-- Dit is een alternatief voor
UPDATE employees
SET reportsTO =
  CASE WHEN reportsTO = 101 THEN NULL
  END;
```

## Data verwijderen - DELETE

```sql
-- Standaardnotatie
DELETE FROM tabel
WHERE voorwaarde;

-- Alle opties
DELETE LOW_PRIORITY QUICK IGNORE
FROM tabel[PARTITION(partition)]
WHERE voorwaarde
ORDER BY order
LIMIT row_count;

/*SPECIALE DELETES*/
-- Verwijder alle rijen, auto-increment zal verderlopen
DELETE FROM tabelnaam;

-- Verwijder alle rijen, reset auto-increment (= table drop + create)
TRUNCATE TABLE tabelnaam;
```

> **BELANGRIJK!** <br>
> Vergeet nooit de WHERE-clausule anders delete je alles uit de tabel.

# DDL - Data Definition Language

DDL wordt gebruikt om het logisch model om te zetten naar een fysiek model.

Fysiek model bestaat uit:

- definitie van de tabellen
- definities primaire sleutels
- definities vreemde sleutels
- definities van kolommen (vb. geen null-waarden)
- definitie van indexen
- toewijzen tablespace

Noot bij integriteitsregels: Als de minimale cardinaliteit in het conceptuele model 1 was, moet deze vreemde sleutel altijd ingevuld zijn (en dus non-null zijn).

Met DDL kan je databanken, tabellen, constraints en indexen definiëren. Je kan er ook datatypes mee vastleggen.

## Databanken manipuleren

```sql
-- Database maken
CREATE DATABASE naam;

-- Database verwijderen
DROP DATABASE naam;
```

## Tabellen manipuleren

```sql
-- Tabel maken
CREATE TABLE tabelnaam (
  kolomnaam1 [DATATYPE] [CONSTRAINTS],
  kolomnaam2 [DATATYPE] [CONSTRAINTS]
);

-- Tabel wijzigen
ALTER TABLE tabelnaam (
  MODIFY COLUMN bestaandeKolom {wijzigingen} -- kolom wijzigen
  ADD kolomnaam [DATATYPE] [CONSTRAINTS] -- kolom toevoegen
  DROP kolomnaam -- kolom verwijderen
  DROP CONSTRAINT constraintnaam -- constraint verwijderen
);

-- Tabel verwijderen
DROP TABLE tabelnaam;
```

## Datatypes

| Datatype       | Omschrijving                | Opmerking                                |
| -------------- | --------------------------- | ---------------------------------------- |
| int / integer  | Gehele getallen             | -2<sup>31</sup> tot 2<sup>31</sup> - 1   |
| decimal        | Kommagetallen               | -10<sup>38</sup> tot 10<sup>38</sup> - 1 |
| char(n)        | Tekst van vaste lengte n    | n is in [1, 8000]                        |
| varchar[(n)]   | Tekst met variërende lengte | n is optioneel = maximumlengte           |
| bool / boolean |                             | TRUE = 1, FALSE = 0                      |
| date           | datum                       | yyyy-mm-dd                               |

## Constraints

Hieronder worden auto-increment, priimary key en foreign key besproken. Enkele andere constraints zijn:

```sql
-- Valide input checken. In dit geval moet de kolom Kolomnaam ofwel value1 of value2 bevatten:
CONSTRAINT constraintnaam CHECK (Kolomnaam IN('value1','value2'))

```

### AUTO_INCREMENT

Bevat voor elke rij een door het systeem gegenereerde (sequentiële) unieke waarde van datatype INT. (= telt op)

Limieten:

- Slechts 1 per tabel
- Geen NULL-waarden
- Kan je niet zelf aanpassen

Je kan de laatst gecreëerde waarde opvragen met LAST_INSERT_ID().

```sql
-- AUTO_INCREMENT definiëren
CREATE TABLE student(
  studentnr INT NOT NULL AUTO_INCREMENT, -- studentnr start bij 1 en telt op
  lastname CHAR(30) NOT NULL,
  firstname CHAR(30) NOT NULL,
  gender BOOLEAN NOT NULL
)

-- AUTO_INCREMENT op een andere waarde laten starten.
ALTER TABLE student
AUTO_INCREMENT = 100;
```

### Primaire sleutel

=> 1 per tabel (kan wel uit meerdere kolommen bestaan = samengestelde sleutel)

- Waarde moet uniek zijn
- NULL niet toegestaan

```sql
-- Primary key definiëren bij het aanmaken / aanpassen van een kolom
CREATE TABLE student (
studentnr INT AUTO_INCREMENT PRIMARY KEY, -- primaire sleutel
lastname CHAR(30) NOT NULL,
firstname CHAR(30) NOT NULL,
gender BOOLEAN NOT NULL
);

-- Samengestelde sleutel
CREATE TABLE users (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY(user_id, role_id)
);

-- Constraint als aparte lijn toevoegen
ALTER TABLE student
  ADD CONSTRAINT PK_studentnr PRIMARY KEY(studentnr) -- PK_studentnr is de naam van de nieuwe constraint, studentnr - de kolom - wordt als primary key gebruikt.
```

### Vreemde sleutels

Verbanden tussen relaties uitdrukken.

- Meerdere per tabel toegelaten
- NULL-waarden kunnen toegelaten zijn
- Waarborgt integriteit
  - Vreemde sleutels moeten verwijzen naar een primaire sleutel uit een tabel
  - Niet-NULL waarde moet in de gerefereerde kolom aanwezig zijn.
  - Legt cascading acties vast voor ON UPDATE en ON DELETE.

```sql
-- Tijdens tabelcreatie
CREATE TABLE userroles(
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY(user_id, role_id), -- combinatie user_id en role_id wordt als primaire sleutel gebruikt
  FOREIGN KEY(user_id) REFERENCES users(user_id), -- relationeel model: user_id verwijst naar verzameling Users
  FOREIGN KEY(role_id) REFERENCES roles(role_id)
);
```
