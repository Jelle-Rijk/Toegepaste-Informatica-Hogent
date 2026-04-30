## Oefeningen Hoofdstuk 05 - Functioneel Programmeren en Collections

## 01_Arrays

Oefeningen op functioneel programmeren met arrays. De opgaves vind je in het `.js` bestand.

## 02_Arrays

Meer oefeningen op functioneel programmeren met arrays. De opgaves vind je in het `.js` bestand.

## 03 Afrikaans Dobbelen revisited

Vertrek van de gegeven modeloplossing van deze oefening uit H04 en maak volgende aanpassingen.

- **`klasse Speler`**

  - `speel`:
    - gebruik `forEach` om de dobbesltenen te rollen
    - gebruik `reduce` om de score aan te passen
      - **hint:** maak gebruik van de huidige score als initiële waarde voor `previousValue`

- **`klasse Spel`**
  - `constructor`: gebruik de `map` methode om de parameter `spelersnamen` (een array van Strings) om te vormen tot een array van Speler-objecten. Ken het resultaat toe aan de `#spelers` property.
  - `heeftWinnaar`: gebruik `some`
  - `scoreOverzicht`: gebruik `reduce`

## 04 OXO revisited

Vertrek van de gegeven modeloplossing van deze oefening uit H04 en maak volgende aanpassingen.

- **`klasse Spelbord`**

  - `bevatDrieOpEenRij`:

    - herschrijf de functie isDrieOpEenRij; deze functie checkt of elke cel in een ééndimensionale array (parameter `drieCellen`) de parameter `symbool` bevat; gebruik `every`
    - herwerk de rest van deze methode

      - gebruik `reduce` om de kolom, en de twee diagonalen te extraheren uit het spelbord, gebruik als initiële waarde voor `previousValue` telkens een lege array en zorg dat de juiste elementen in `previousValue` komen te zitten

      - **enkele hints:**
        - voor de kolom moet je uit elke rij het element op plaats kol halen
        - de eerste digaonaal bevat elementen van het bord waarvoor rij gelijk is aan kolom
        - de tweede digaonaal bevat elementen van het bord waarvoor kolom gelijk is aan 2 - rij
        - vergeet niet de functie isDrieOpEenRij aan te roepen...

  - `isVolzet`:
    - maak gebruik van `some` of `every`...

## 05_MapsEnSetsEasy

Oefeningen op Maps en Sets. De opgaves vind je in de `.js` file.

## 06_MapsEnSets

### a. Gesorteerde Map

We vertrekken van een string die een zin bevat. De woorden in de zin zijn gescheiden door een spatie.
Maak een Map die een frequentietabel bevat. Per woord in de zin hou je bij hoeveel keer dit woord in de zin voorkomt. De frequentietabel moet gesorteerd worden dalend op frequentie.
Je mag case-insensitive werken.
Druk de frequentietabel af in de console.

### b. Coderen en Decoderen

Het Caesarcijfer is een klassieke manier om tekstberichten te coderen (versleutelen) en te decoderen
(ontsleutelen). Het is vernoemd naar Julius Caesar, die het gebruikte om te communiceren met zijn
veldheren.

De versleuteling werkt door elke letter van het alfabet te vervangen door een letter die enkele plaatsen
verder in het alfabet voorkomt. Hierbij wordt een circulair alfabet beschouwd, wat betekent dat na de
letter Z opnieuw de letter A volgt. Vandaar dat ook de term rotatie of verschuiving gebruikt wordt voor
deze operatie. Bijvoorbeeld, bij een rotatie over drie posities wordt de letter B tijdens het versleutelen
vervangen door de letter E. Alle overige karakters (cijfers, leestekens, spaties, …) blijven ongewijzigd in de
gecodeerde tekst.

![caesar1.png](/docs/caesar1.png 'Versleuteling')

Het ontsleutelen van een tekst gebeurt door de omgekeerde bewerking uit te voeren. In dit geval wordt er
dus een rotatie of verschuiving naar links uitgevoerd, in plaats van naar rechts zoals bij de versleuteling.
Bijvoorbeeld, bij een rotatie over drie posities wordt de letter E tijdens het ontsleutelen vervangen door de
letter B.

![caesar2.png](/docs/caesar2.png 'Ontsleuteling')

Implementeer de functies codeer en decodeer.

### c. Camelize

Schrijf een functie camelize die een woord met - tekens, zoals "een-voorbeeld-string", omzet naar een camelcase woord, zoals eenVoorbeeldString.

Bijvoorbeeld

```javascript
console.log(camelize('background-color')); // backgroundColor
console.log(camelize('list-style-image')); // listStyleImage
console.log(camelize('-webkit-transition')); // WebkitTransition
```

### d. Buren

Schrijf een functie zijnBuren(woord1, woord2) die true retourneert wanneer 2 woorden buren zijn. 2 woorden zijn buren wanneer ze op 1 plaats exact 1 karakter van elkaar verschillen, bijvoorbeeld KOLDER en HOLDER.
Maak vervolgens gebruik van deze functie om te controleren of in een array elke 2 opeenvolgende woorden buren zijn van elkaar.

### e. Morse

In morsecode wordt elk karakter van een woord vertaald naar een unieke opeenvolging van punten (.) en streepjes (-), en worden de vertalingen van de individuele karakters telkens van elkaar gescheiden door één enkele spatie. Schrijf een functie die een bericht en de map met morse-code als parameter heeft en het bericht in morse retourneert.

### f. Josephus

Bekijk https://dodona.ugent.be/nl/exercises/798652413/

Er staan n personen in een cirkel te wachten op hun executie.
De personen worden in wijzerzin genummerd van 1 tot en met n.
Het aftellen begint vanaf persoon 1, waarbij elke k-de nog levende persoon wordt ge-executeerd.
De cirkel wordt hierbij in wijzerzin doorlopen en wordt steeds kleiner en kleiner naarmate er meer personen geexecuteerd worden.
De laatste persoon die overblijft, wordt in leven gelaten.
Kan je op voorhand een geschikte plaats in de cirkel kiezen,
zodat je de executie overleeft?

Vervolledig de functie josephus die twee parameters heeft

- het aantal personen in de cirkel, n
- de stapgrootte, k

De functie retourneert de plaats van de laatst overlevende persoon.

Voor 30 personen en stagrootte 9 zou je best plaats 21 innemen...
