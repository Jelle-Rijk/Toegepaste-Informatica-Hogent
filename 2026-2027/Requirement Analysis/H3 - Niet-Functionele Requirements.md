<h1>Niet-functionele Requirements</h1>

- [Functionele vs. niet-functionele requirements](#functionele-vs-niet-functionele-requirements)
- [Pragmatisch kader](#pragmatisch-kader)
  - [1 - Platform en toestel](#1---platform-en-toestel)
  - [2 - Connectiviteit en API](#2---connectiviteit-en-api)
  - [3 - Beveiliging en toegang](#3---beveiliging-en-toegang)
  - [4 - Performantie](#4---performantie)
  - [5 - Beschikbaarheid en offline](#5---beschikbaarheid-en-offline)
- [NFR's als acceptatiecriteria](#nfrs-als-acceptatiecriteria)
  - [Given/When/Then-sjabloon voor NFR's](#givenwhenthen-sjabloon-voor-nfrs)
- [FURPS+](#furps)
  - [Tips voor NFR-analyse - samengevat](#tips-voor-nfr-analyse---samengevat)

# Functionele vs. niet-functionele requirements

| FR                                          | NFR                                          |
| ------------------------------------------- | -------------------------------------------- |
| Wat het systeem doet                        | De randvoorwaarden voor het systeem          |
| Schermen, interacties, formulieren, knoppen | Platformen, toestellen, oriëntatie           |
| Bedrijfsregels, databerekening              | Netwerkconnectiviteit, externe API-koppeling |
| Acties van specifieke gebruikersrollen      | Toegangscontrole, tokens, authenticatie      |
| CRUD-operaties                              | Responstijd, stabiliteit, offline gedrag     |

# Pragmatisch kader

=> bestaat uit 5 vragen die je voor de sprint start voor elke user story moet stellen.

## 1 - Platform en toestel

Je zorgt dat volgende onderdelen duidelijk zijn:

- Besturingssystemen en versies => Waarop moet het systeem kunnen draaien?
- Toestelcategorie en hardware => Belangrijk voor onder andere UI
- Schermoriëntatie en responsiviteit => Landscape / portrait interface? Moet de interface kunnen draaien? Split-screen?
- Specifieke hardware => Moet het systeem verbonden worden aan een camera, sensor, ... ?

Deze zaken bepalen frameworkkeuzes, UI-componenten en testmatrices (=> Op welk systeem moet er getest worden?)

## 2 - Connectiviteit en API

Probeert te beantwoorden waar de data vandaan komt.

- Herkomst van data => Waar zit de data nu?
- Status van de interfaces => Is er al een API of moet die nog gebouwd worden?
- Documentatie en contracten => Is er al een specificatie zodat er mocks kunnen gebruikt worden?
- Third-party afhankelijkheden => Wat moet er gebeuren indien een externe service downtime heeft?

## 3 - Beveiliging en toegang

- Wie mag wat zien? => Rollen, rechten
- Authenticatie infrastructuur => Is er al een identity provider of moet deze nog gemaakt worden?
- Token handling => Hoe worden <abbr title="JSON Web Tokens">JWT</abbr>/sessie-tokens bewaard?
- Foutafhandeling => Hoe reageert de API bij ongeldige requests?

## 4 - Performantie

Je bespreekt hier de responstijd, piekbelasting en datavolumes. Bekijk ook wat het gedrag van het systeem moet zijn bij vertraging (vb. laadindicator)

Valstrikken:

- Willekeurige getallen gebruiken in vereisten (vb. 1.34 seconden zonder onderbouwing)
- Onhaalbare eisen (vb. Het systeem mag nooit vertragen)
- Eisen die het team weken aan micro-optimalisaties kost (= <abbr title="Gebruik van willekeurige getallen zonder onderbouwing">schijnprecisie</abbr>)

## 5 - Beschikbaarheid en offline

- Offline noodzaak => Moet de applicatie deels offline kunnen functioneren?
- Vereiste uptime tijdens piekuren
- Netwerkuitval afhandeling => Wat gebeurt er als de verbinding wegvalt?
- Synchronisatie => Hoe synchroniseert de app wijzigingen wanneer de verbinding zich herstelt?

# NFR's als acceptatiecriteria

=> Documenteer NFR's niet in een apart document (ze worden dan vaak niet meer geraadpleegd).

Zorg dat NFR's:

- Deel zijn van de user story (expliciet acceptatiecriterium)
- Onderdeel zijn van definition of done
- Direct toetsbaar zijn

=> Zorgt voor continue kwaliteitsbewaking

## Given/When/Then-sjabloon voor NFR's

(zie ook [h2 - Given/When/Then](./H2%20-%20Functionele%20Requirements.md#given--when--then))

Speciale betekenis voor NFR/s

- Given: Context en randvoorwaarden
- When: De actie die gebeurt
- Then: Het meetbare resultaat

vb. Gegeven de mobiele applicatie actief is, wanneer die klantgegevens opvraagt, dan gebeurt dit via een gedocumenteerde REST-API (JSON) en nooit via rechtstreekse databasetoegang.

# FURPS+

= Checklist die je kan helpen om het pragmatische kader te controleren (geen startpunt, maar vangnet achteraf)

- Functionality => Zijn de <abbr title="vb. security, rollen, rechten, externe koppeling">randfunctionaliteiten</abbr> volledig gedekt?
- Usability => Is er rekening gehouden met de <abbr title="vb. vaardigheden, taal, toegankelijkheid">gebruikerscontext</abbr>?
- Reliability => Wat gebeurt er bij fouten, netwerkuitval of serverstoringen?
- Performance => Zijn er expliciete responstijden / capaciteitsvereisten die nog nergens vermeld staan?
- Supportability => Is de applicatie eenvoudig te onderhouden / monitoren / uit te breiden?
- (+) Constraints => Zijn er dwingende beperkingen? (vb. GDPR)

Twee-stappenmodel = eerst pragmatisch kader gebruiken en dan als tweede stap FURPS+ gebruiken om te controleren. <br>
_Voordeel = elke NFR is relevant, verdedigbaar en direct gekoppeld aan bedrijfswaarde_

## Tips voor NFR-analyse - samengevat

- Gebruik geen vage formuleringen => Given/When/Then helpt hier
- Zet NFR's in de acceptatiecriteria
- Doorloop eerst het pragmatische kader, nadien FURPS+
- Schrijf de NFR's als deel van de user story, niet achteraf.
- Maak geen expliciete aannames => Altijd aftoetsen bij de klant.
- Geen schijnprecisie => Zorg dat getallen onderbouwd en verdedigbaar zijn
