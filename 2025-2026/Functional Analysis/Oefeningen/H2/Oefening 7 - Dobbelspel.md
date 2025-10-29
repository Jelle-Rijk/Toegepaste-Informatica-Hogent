<h1> H2 - Oefening 7 - Dobbelspel (Use cases) </h1>

```
Use case: Speel spel

Primaire actor: Speler
Stakeholders: Spelleider

Preconditie: De speler is geregistreerd en ingelogd.
Postconditie: Het systeem heeft een spel aangemaakt. Het systeem heeft bepaald of de speler gewonnen of verloren is.

Normaal verloop:
    1. De speler wenst een spel te spelen.
    2. De speler laat het systeem de dobbelstenen rollen.
    3. Het systeem valideert de worp volgens DR_SPELREGELS.
    4. Het systeem verhoogt het aantal gewonnen spellen van de speler.
    5. Het systeem geeft een gepaste melding.

Uitbreidingen:
    3a. Het systeem stelt vast dat het spel nog niet geëindigd is.
        3a1. Keer terug naar stap 2 van het normale verloop.

    4a. De speler heeft verloren.
        4a1. Het systeem verhoogt het aantal verloren spellen van de speler.

Domeinspecifieke regels:
DR_SPELREGELS:
    - Als eerste worp en worp is 7 of 11: GEWONNEN.
    - Als niet eerste worp en worp is 7 of 11:
        - Eerste worp werd herhaald: GEWONNEN
        - Eerste worp werd niet herhaald: VERLOREN
    - Anders: SPEL NOG NIET GEËINDIGD.
```
