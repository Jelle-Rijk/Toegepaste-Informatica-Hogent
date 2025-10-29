<h1> H2 - Oefening 1 - Vrager </h1>

# Uitwerking

```
Use Case: Vrager registreren

Primary actor: Gebruiker
Stakeholders:

Precondities: De gebruiker koos ervoor zich als vrager te registreren.
Postcondities: Het systeem heeft een nieuwe vrager geregistreerd.

Normaal verloop:
    1. Gebruiker wenst zich als vrager te registeren.
    2. Systeem toont overzicht van keuzes.
    3. Gebruiker kiest vrager.
    4. Het systeem vraagt gegevens aan de gebruiker (bedrijfsgegevens, persoonsgegevens, paswoord)
    5. Gebruiker geeft bedrijfsgegevens, naam, e-mail en paswoordkeuze in.
    6. Het systeem valideert de gegevens volgens DR_REGISTRATIE.
    7. Het systeem maakt een nieuwe vrager aan.
    8. Het systeem bevestigt de registratie aan de gebruiker.

Alternatief verloop:
    3a. Gebruiker kiest aanbieder.
        3a1. De gebruiker [registreert zich als aanbieder].

    6a. Ongeldige gegevens
        6a1. Het systeem toont een gepaste melding.
        6a2. Keer terug naar stap 4 van het normaal verloop.

Domeinspecifieke regels:
DR_REGISTRATIE
    - Alle velden werden ingevuld.
    - Email adres is een geldig e-mailadres:
        - Nog niet eerder gebruikt.
        - In de vorm van gebruikersnaam@domeinnaam
    - Paswoord en herhaal paswoord komen overeen.
```
