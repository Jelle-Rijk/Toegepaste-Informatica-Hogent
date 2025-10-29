<h1> H2 - Oefening 3 - Inloggen </h1>

# Uitwerking

```
Use Case: Inloggen

Primary actor: Gebruiker
Stakeholders: /

Preconditie: De gebruiker is geregistreerd.
Postconditie: Het systeem heeft de gebruiker ingelogd. Het systeem heeft de loginactiviteit in een log tabel weggeschreven.

Normaal verloop:
    1. De gebruiker wenst in te loggen.
    2. Het systeem vraagt gebruikersnaam en paswoord.
    3. De gebruiker vult gebruikersnaam en paswoord in.
    4. Het systeem valideert de gegevens volgens DR_LOGIN.
    5. Het systeem schrijft de loginactiviteit weg naar de log tabel volgens DR_LOGIN_INFO.
    6. Het systeem logt de gebruiker in.
    7. Het systeem toont overzicht aan de gebruiker.

Uitbreidingen:
    6a. Login en paswoord voldoen niet aan DR_LOGIN.
        6a1. Het systeem toont een gepaste melding.
        6a2. Keer terug naar stap 2 uit het normaal verloop.


Domeinspecifieke regels:
DR_LOGIN:
    - Login en paswoord moeten samen voorkomen in databank.

DR_LOGIN_INFO:
    - Bij correcte login volgens: LoginId | datum/uur | "correcte login"
    - Bij incorrecte login volgens: LoginId | datum/uur | "incorrecte login"

```

# Alternatieve uitwerking

```
Use Case: Inloggen

Primary actor: Gebruiker
Stakeholders: /

Preconditie: De gebruiker is geregistreerd.
Postconditie: Het systeem heeft de gebruiker ingelogd. Het systeem heeft de loginactiviteit in een log tabel weggeschreven.

Normaal verloop:
    1. De gebruiker wenst in te loggen.
    2. Het systeem vraagt gebruikersnaam en paswoord.
    3. De gebruiker vult gebruikersnaam en paswoord in.
    4. Het systeem valideert de gegevens volgens DR_LOGIN.
    5. Het systeem schrijft de loginactiviteit weg naar de log tabel volgens DR_LOGIN_INFO.
    6. Het systeem logt de gebruiker in.
    7. Het systeem toont overzicht aan de gebruiker.

Uitbreidingen:
    4a. Login en paswoord voldoen niet aan DR_LOGIN.
        4a1. Het systeem schrijft de loginactiviteit weg naar de log tabel volgens DR_LOGIN_INFO.
        4a2. Het systeem toont een gepaste melding.
        4a3. Keer terug naar stap 2 uit het normaal verloop.


Domeinspecifieke regels:
DR_LOGIN:
    - Login en paswoord moeten samen voorkomen in databank.

DR_LOGIN_INFO:
    - Bij correcte login volgens: LoginId | datum/uur | "correcte login"
    - Bij incorrecte login volgens: LoginId | datum/uur | "incorrecte login"

```
