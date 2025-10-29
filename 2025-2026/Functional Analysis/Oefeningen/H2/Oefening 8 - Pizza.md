<h1> H2 - Oefening 8 - Pizza <h2>

# Bestel pizza

```
Use case: Bestel pizza

Primaire actor: Klant
Stakeholders: Telefonist, kok, eigenaar, bezorger, pizzeria

Precondities: De klant belt de telefonist.
Postcondities: Het systeem heeft een nieuwe bestelling aangemaakt. Het systeem heeft de nieuwe bestelling aan de kok en bezorger gemeld.

Normaal verloop:
    1. De klant wenst een pizza te bestellen.
    2. De klant laat de telefonist het gekozen pizzanummer invoeren.
    3. Het systeem valideert het pizzanummer.
    4. Het systeem voegt de pizza aan de bestelling toe.
    5. Zo lang de klant pizza's wil toevoegen, keer terug naar stap 2.
    6. De klant bevestigt de bestelling.
    7. Het systeem berekent de prijs van de bestelling volgens DR_PRIJSBEREKENING.
    8. Het systeem geeft een overzicht van de bestelling.
    9. De klant [betaalt de bestelling].
    10. Het systeem registreert de bestelling.
    11. Het systeem bevestigt de bestelling aan de klant.
    12. Het systeem geeft een melding van de bestelling aan de kok.
    13. Het systeem geeft een melding van de bestelling aan de bezorger.


Uitbreidingen:
    3a. Het pizzanummer bestaat niet.
        3a1. Het systeem geeft een gepaste melding.
        3a2. Keer terug naar stap 2 van het normaal verloop.

        3a2a. De klant heeft geen andere pizzanummers meer.
            Use case eindigt zonder behalen postcondities.

    9a. De klant betaalt niet.
        Use case eindigt zonder behalen van de postcondities.


Domeinspecifieke regels:
DR_PRIJSBEREKENING
    - Totaal van alle producten
    - Plus 1,5 euro als totale prijs minder is dan 20 euro.

```

# Registreer klant

```
Use case: Registreer klant

Primaire actor: Telefonist
Stakeholders: Klant, pizzeria

Precondities: De klant belt de telefonist en is nog niet bekend in het systeem.
Postcondities: Het systeem registreert de gegevens van een nieuwe klant.

Normaal verloop:
    1. De telefonist wenst een nieuwe klant te registreren.
    2. Het systeem vraagt de gegevens (naam, adres, telefoonnummer) van de klant.
    3. De telefonist voert de gegevens van de klant in.
    4. Het systeem valideert de gegevens volgens DR_GEGEVENS.
    5. Het systeem maakt een nieuwe klant aan.
    6. Het systeem toont een gepaste melding.

Uitbreidingen:
    4a. Ongeldige gegevens.
        4a1. Het systeem geeft een gepaste melding.
        4a2. Keer terug naar stap 2 van het normale verloop.

Domeinspecifieke regels:
    DR_GEGEVENS:
    - Het adres moet bestaan.
    - Naam bevat een voornaam en familienaam.
    - Het telefoonnummer is een geldig telefoonnummer.


```

# Voeg pizza toe

```
Use case: Voeg pizza toe

Primaire actor: Kok
Stakeholders: Eigenaar, klant

Precondities: /
Postcondities: Systeem heeft een nieuwe pizza geregistreerd.

Normaal verloop:
    1. De kok wenst een nieuwe pizza toe te voegen.
    2. Het systeem vraagt de gegevens van de nieuwe pizza op (bodem, ingredienten).
    3. Het systeem valideert de nieuwe pizza volgens DR_NIEUWE_PIZZA.
    4. Het systeem registreert de nieuwe pizza en berekent een uniek nummer.
    5. Het systeem geeft een gepaste melding.

Uitbreidingen:
    3a. De pizza bestaat al.
        3a1. Het systeem geeft een gepaste melding.
        Use case eindigt zonder behalen van de postcondities.


Domeinspecifieke regels:
DR_NIEUWE_PIZZA:
    - Er is nog geen pizza met dezelfde bodem en dezelfde ingrediënten


```

# Verwijder pizza

```
Use case: Verwijder pizza

Primaire actor: Kok
Stakeholders: Eigenaar, klant

Precondities: Er bestaan pizza's in het assortiment.
Postcondities: Het systeem heeft een bestaande pizza uit het assortiment verwijderd.

Normaal verloop:
    1. De kok wenst een pizza te verwijderen.
    2. Het systeem geeft een overzicht van de bestaande pizza's. (nummer, ingrediënten, bodem, prijs)
    3. De kok geeft het nummer van de pizza in.
    4. Het systeem valideert het nummer.
    5. Het systeem verwijdert de gekozen pizza uit het assortiment.

Uitbreidingen:
    4a. Het pizzanummer bestaat niet.
        4a1. Het systeem geeft een gepaste melding.
        Use case eindigt zonder behalen van de postcondities.

Domeinspecifieke regels: /


```

# Registreer medewerker

```
Use case: Registreer medewerker

Primaire actor: Eigenaar
Stakeholders: Medewerker

Precondities: De eigenaar heeft de gegevens van de medewerker.
Postcondities: Het systeem heeft een nieuwe medewerker geregistreerd.

Normaal verloop:
    1. De eigenaar wenst een nieuwe medewerker te registreren.
    2. Het systeem vraagt de persoonsgegevens volgens DR_GEGEVENS_MEDEWERKER.
    3. De eigenaar vult de gegevens in.
    4. Het systeem valideert de gegevens volgens DR_VALIDATIE_MEDEWERKER.
    5. Het systeem voegt een nieuwe medewerker toe.
    6. Het systeem geeft een melding aan de eigenaar.


Uitbreidingen:
    4a. Ongeldige gegevens
        4a1. Het systeem geeft een gepaste melding.
        4a2. Keer terug naar stap 2 van het normaal verloop.

Domeinspecifieke regels:
DR_GEGEVENS_MEDEWERKER
    naam, functie, telefoonnummer
DR_VALIDATIE_MEDEWERKER
    - Naam bevat een voor- en familienaam.
    - Functie is een bestaande functie binnen het bedrijf.
    - Telefoonnummer is een geldig nummer.

```

# Vraag overzicht bestellingen op

```
Use case: Vraag overzicht bestellingen op

Primaire actor: Eigenaar
Stakeholders: /

Precondities: /
Postcondities: Het systeem heeft een overzicht van de bestellingen in een vestiging getoond.

Normaal verloop:
    1. De eigenaar wenst een overzicht van alle bestellingen in een vestiging.
    2. Het systeem toont een overzicht van alle vestigingen.
    3. De eigenaar kiest een vestiging.
    4. Het systeem toont een overzicht van alle bestellingen in de gekozen vestiging.

Uitbreidingen:
    2a. Er zijn geen vestigingen
        2a1. Het systeem toont een gepaste melding.
        Use case eindigt zonder bereiken van de postcondities.

    4a. Er zijn geen bestellingen voor de gekozen vestiging.
        4a1. Het systeem toont een gepaste melding.
        4a2. Keer terug naar stap 2 van het normaal verloop.

Domeinspecifieke regels: /

```
