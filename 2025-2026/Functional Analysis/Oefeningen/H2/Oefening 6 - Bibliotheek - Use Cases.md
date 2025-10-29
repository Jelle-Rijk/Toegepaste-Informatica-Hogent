<h1>Oefening 6 - Bibliotheek - Use Cases</h1>

# USE CASE: Boek ontlenen

```
Use Case: Boek ontlenen

Primaire Actor: Lid
Stakeholders: Baliebediende, bibliotheek

Preconditie: Het lid is geregistreerd en heeft een geldige lidkaart.
Postcondities: Het boek is gemarkeerd als ontleend. Het boek werd toegevoegd aan de ontleende producten van het lid.

Normaal verloop:
    1. Het lid wenst een boek te onlenen.
    2. De baliebediende voert de lidkaart in.
    3. Systeem valideert de lidkaart en haalt gegevens van het lid volgens DR_LIDGEGEVENS op.
    4. De baliebediende voert het boek in.
    5. Systeem valideert volgens DR_BOEK_ONTLENEN.
    6. Systeem registreert boek als ontleend.
    7. Systeem voegt boek toe aan ontleningen van lid.
    8. Systeem geeft informatie over ontlening terug (terugbrengdatum).
    9. Zo lang lid boeken wenst te ontlenen, keer terug naar stap 4.
    10. Baliebediende geeft boeken aan lid.


Alternatief verloop:
    3a. Lid heeft openstaande boetes.
        3a1. Systeem geeft een gepaste melding.
        3a2. Lid [betaalt de openstaande boete].
        3a3. Keer terug naar stap 4 van het normale verloop.

        3a2a. Lid betaalt boete niet.
        Use case eindigt zonder behalen postcondities.

    4a. Lid heeft geen geldige boeken meer.
        Use case eindigt zonder behalen postcondities.

    5a. Boek voldoet niet aan DR_BOEK_ONTLENEN.
        5a1. Systeem geeft een gepaste melding.
        5a2. Keer terug naar stap 4 van het normale verloop.

Uitbreidingen:

Domeinspecifieke regels:
DR_LIDGEGEVENS: lidnummer, voornaam, familienaam, straat, huisnr, postcode, gemeente, geboortedatum, begindatum lidmaatschap, emailadres
DR_BOEK_ONTLENEN
    - De minimumleeftijd van het boek moet kleiner zijn dan de leeftijd van het lid.



```

# USE CASE: Boek terugbrengen

```
Use Case: Boek terugbrengen

Primaire Actor: Lid
Stakeholders: Baliebediende, bibliotheek

Preconditie: Lid heeft één of meerdere boeken ontleend. Lid heeft een geldige lidkaart.
Postcondities: Het systeem heeft de teruggave van het boek geregistreerd. Het systeem heeft het boek van de ontleningen van het lid weggehaald.

Normaal verloop:
    1. Lid wenst boeken terug te brengen.
    2. De bediende voert de lidkaart in het systeem in.
    3. Het systeem haalt de gegevens van het lid volgens DR_LIDGEGEVENS op.
    4. De bediende voert het boek in het systeem in.
    5. Het systeem valideert de teruggave volgens DR_TERUGBRENGEN.
    6. Het systeem verwijdert het boek van de ontleningen van het lid.
    7. Het systeem registreert de teruggave van het boek.
    8. Zo lang lid boeken wenst terug te brengen, keer terug naar stap 4.
    9. Het systeem bevestigt de terugbrengst aan het lid.


Uitbreidingen:
    5a. Boek is te laat teruggebracht
        5a1. Systeem geeft een gepaste melding.
        5a2. Systeem voegt een openstaande boete toe aan het lid.
        5a3. Ga naar stap 6 van het normale verloop.

    5b. Boek is ontleend door een ander lid
        5b1. Systeem geeft een gepaste melding.
        5b2. Keer terug naar stap 4 van het normaal verloop.

        5b2a. Lid heeft geen zelf ontleende boeken
            Use case eindigt zonder behalen van de postcondities.

    7a. Het boek is gereserveerd
        7a1. Het systeem geeft een gepaste melding aan de baliebediende.
        7a2. Het systeem [meldt de terugbrengst van de reservering].


Domeinspecifieke regels:
DR_LIDGEGEVENS:
    lidnummer, voornaam, familienaam, straat, huisnr, postcode, gemeente, geboortedatum, begindatum lidmaatschap, emailadres
DR_TERUGBRENGEN
    - Terugbrengdatum is gelijk aan of later dan huidige datum.
    - Lid is hetzelfde lid als ontlener van het boek.

```

# USE CASE: Boek reserveren

```
Use Case: Boek reserveren

Primaire Actor: Lid
Stakeholders: Baliebediende, bibliotheek, lid dat boek terugbrengt

Preconditie: Lid heeft het boek opgezocht. De bibliotheek beschikt over het boek. Alle exemplaren van het boek zijn ontleend.
Postcondities: Het systeem heeft het lid verwittigt dat het boek beschikbaar is. Het systeem heeft het boek aan het lid ontleend. Het systeem heeft de reservatie opnieuw verwijderd.

Normaal verloop:
    1. Lid wenst een boek te reserveren.
    2. Lid voert de gegevens van het boek in.
    3. Het systeem registreert het boek als gereserveerd.
    4. Een ander lid [brengt het boek terug].
    5. Het systeem geeft een gepaste melding aan het lid.
    6. Het lid [ontleent het boek].
    7. Het systeem verwijdert de reservatie.

Uitbreidingen:
    4a. Het boek wordt niet binnen de drie maanden teruggebracht.
        4a1. Systeem verwijdert de reservatie.
        4a2. Systeem geeft een gepaste melding aan het lid.
        Use case eindigt zonder bereiken van de postcondities.

    6a. Het lid ontleent het boek niet binnen een week na melding.
        6a. Ga naar stap 7 van het normale verloop.

```
