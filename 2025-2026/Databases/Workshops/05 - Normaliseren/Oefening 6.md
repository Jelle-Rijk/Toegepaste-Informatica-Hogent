<h1>Oefening 6 - Productiehuizen</h1>

# Productiehuizen

A. R0(productiehuis, CEO, type, zetel,(programmanaam, doelgroep,(opnamedag, soort opname, BV’s toegezegd, opmerking)\*)\*)​

-> Een opnamedag behoort tot een programma.

Van 0NV naar 1NV:

- R11(<u>productiehuis</u>, CEOvoornaam, CEOfamilienaam, type, zetel)
- R12(<u>productiehuis, programmanaam</u>, doelgroep)
- R13(<u>productiehuis, programmanaam, opnamedag</u>, soort, bvvoornaam, bvfamilienaam, opmerking)

Kunnen de FA's afgeleid worden uit het document?

| FA                                                              | Ja/Nee | Reden (indien nee)                                            |
| --------------------------------------------------------------- | ------ | ------------------------------------------------------------- |
| Naam productiehuis -> CEO                                       | Ja     |
| Soort opname -> opmerking                                       | Nee    | Dezelfde soort opname kan verschillende opmerkingen hebben.   |
| Naam productiehuis, naam programma, opnamedag -> BV's toegezegd | Nee    | Meedere BV's kunnen voor dezelfde dag toezeggen.              |
| Voornaam BV toegezegd -> familienaam BV toegezegd               | Nee    | Meerdere BV's kunnen dezelfde voornaam of familienaam hebben. |
| Naam productiehuis, naam programma, opnamedag -> soort opname   | Nee    | Twee verschillende soorten opnames per dag.                   |

# Films

## Normaliseer tot en met het relationele model

### Model A

- RX1(<u>filmverdelerNr</u>, filmverdelerNaam, plaats)
- RX2(<u>filmverdelerNr, filmID</u>, filmTitel, categorie,regisseurNr, regisseurVnaam, regisseurFnaam)
- RX3(<u>filmverdelerNr, filmID, oscarNr</u>, oscarNaam,winnaarNr, winnaarVnaam, winnaarFnaam)

-> Eerste normaalvorm: De partiële afhankelijkheden zijn nog niet weggewerkt

Van 1NV naar 2NV:

- R21(<u>filmverdelerNr</u>, filmverdelerNaam, plaats)
- R22(<u>filmverdelerNr, filmID</u>)
- R23(<u>filmID</u>, filmTitel, categorie, regisseurNr, regisseurVnaam, regisseurFnaam)
- R24(<u>filmverdelerNr, filmID, oscarNr</u>)
- R25(<u>filmID, oscarNr</u>, winnaarNr, winnaarVnaam, winnaarFnaam)
- R26(<u>oscarNr</u>, oscarNaam)

Van 2NV naar 3NV:

- R31(<u>filmverdelerNr</u>, filmverdelerNaam, plaats)
- R32(<u>filmverdelerNr, filmID</u>)
- R33(<u>filmID</u>, filmTitel, categorie, regisseurNr, regisseurVnaam, regisseurFnaam)
- R34(<u>regisseurNr</u>, regisseurVnaam, regisseurFnaam)
- R35(<u>filmverdelerNr, filmID, oscarNr</u>)
- R36(<u>filmID, oscarNr</u>, winnaarNr)
- R37(<u>winnaarNr</u>, winnaarVnaam, winnaarFnaam)
- R38(<u>oscarNr</u>, oscarNaam)

Relationeel model:

- Filmverdeler(<u>filmverdelerNr</u>, filmverdelerNaam, plaats)
- Persoon(<u>persoonID</u>, voornaam, familienaam)
- Film(<u>filmID</u>, filmTitel, categorie, regisseurNr)
  - IR: regisseurNr verwijst naar Persoon.persoonID, optioneel
- Filmverdeler_Film(<u>filmverdelerNr, filmID</u>)
  - IR: filmverdelerNr verwijst naar Filmverdeler, verplicht
  - IR: filmID verwijst naar Film, verplicht
- Film_Oscar(<u>filmverdelerNr, filmID, oscarNr</u>)
  - IR: filmVerdelerNr verwijst naar Filmverdeler, verplicht
  - IR: filmID verwijst naar Film, verplicht
  - IR: oscarNr verwijst naar Oscar, verplicht
- GewonnenOscar(<u>filmId, oscarNr</u>, winnaarNr)
  - IR: filmID verwijst naar Film, verplicht
  - IR: oscarNr verwijst naar Oscar, verplicht
  - IR: winnaarNr verwijst naar Persoon.persoonID, verplicht
- Oscar(<u>oscarNr</u>, oscarNaam)

### Model B

RX(<u>regisseurNr</u>, regisseurVNaam, regisseurFNaam, geboorteland, geboorteplaats, geboortedatum)

-> 2NV want er zijn geen partiële afhankelijkheden

2NV naar 3NV:

- R31(<u>regisseurNr</u>, regisseurVNaam, regisseurFNaam, geboorteplaats, geboortedatum)
- R32(<u>plaats</u>, land)

Relationeel model:

- Regisseur(<u>regisseurNr</u>, regisseurVNaam, regisseurFNaam, geboorteplaats, geboortedatum)
  - IR: geboorteplaats verwijst naar Plaats.naam, verplicht
- Plaats(<u>naam</u>, land)

## Integreer tot 1 relationeel model

- Filmverdeler(<u>filmverdelerNr</u>, filmverdelerNaam, plaats)
- Persoon(<u>persoonID</u>, voornaam, familienaam)
- Film(<u>filmID</u>, filmTitel, categorie, regisseurNr)
  - IR: regisseurNr verwijst naar Persoon.persoonID, optioneel
- Filmverdeler_Film(<u>filmverdelerNr, filmID</u>)
  - IR: filmverdelerNr verwijst naar Filmverdeler, verplicht
  - IR: filmID verwijst naar Film, verplicht
- Film_Oscar(<u>filmverdelerNr, filmID, oscarNr</u>)
  - IR: filmVerdelerNr verwijst naar Filmverdeler, verplicht
  - IR: filmID verwijst naar Film, verplicht
  - IR: oscarNr verwijst naar Oscar, verplicht
- GewonnenOscar(<u>filmId, oscarNr</u>, winnaarNr)
  - IR: filmID verwijst naar Film, verplicht
  - IR: oscarNr verwijst naar Oscar, verplicht
  - IR: winnaarNr verwijst naar Persoon.persoonID, verplicht
- Oscar(<u>oscarNr</u>, oscarNaam)
- Regisseur(<u>regisseurNr</u>, geboorteplaats, geboortedatum)
  - IR: regisseurNr verwijst naar Persoon.persoonId, verplicht
  - IR: geboorteplaats verwijst naar Plaats.naam, verplicht
- Plaats(<u>naam</u>, land)
