<h1> H2 - Oefening 2 - Aanbieder </h1>

# Uitwerking

```
Use Case: Aanbieder registreren

Primary actor: Gebruiker
Stakeholders: /

Preconditie: /
Postcondities: Het systeem registreerde de gebruiker als aanbieder.

Normaal verloop:
    1. De gebruiker wenst zich te registreren als aanbieder.
    2. Het systeem toont de keuzes aan de gebruiker.
    3. De gebruiker kiest aanbieder.
    4. Het systeem vraagt de gegevens volgens DR_GEGEVENS.
    5. De gebruiker vult de gegevens in.
    6. Het systeem valideert de gegevens volgens DR_REGISTRATIE.
    8. Het systeem stuurt een bevestiging naar de gebruiker.
    9. De gebruiker bevestigt de registratie.
    10. Het systeem registreert een nieuwe aanbieder.
    11. Het systeem bevestigt dat de registratie voltooid is.

Alternatief verloop:
    2a. Geen keuzes in lijst
        2a1. Het systeem toont een gepaste melding.
        Use case eindigt zonder behalen postcondities.

    6a. De opgegeven gegevens zijn ongeldig.
        6a1. Het systeem toont een gepaste melding.
        6a2. Keer terug naar stap 4 van het normale verloop.

    9. De gebruiker bevestigt niet binnen de 24 uur.
        Use case eindigt zonder behalen postcondities.

Domeinspecifieke regels:
DR_GEGEVENS:
    - Bedrijfsnaam, postadres, e-mailadres, website, naam, paswoord, herhaal paswoord

DR_REGISTRATIE:
    - Alle velden werden ingevuld.
    - Het tweede veld in postadres is een positief natuurlijk getal.
    - E-mailadres is in de vorm: gebruikersnaam@domeinnaam
    - E-mailadres is nog niet in gebruik.
    - Paswoord en herhaal paswoord zijn gelijk.
```
