<h1> Functionele Requirements </h1>

- [Use cases](#use-cases)
  - [Template](#template)
  - [Use cases opstellen](#use-cases-opstellen)
- [User stories](#user-stories)
  - [Kenmerken van een goede user story](#kenmerken-van-een-goede-user-story)
    - [INVEST](#invest)
- [Epics, tasks \& splitting](#epics-tasks--splitting)
  - [INVEST-splitting](#invest-splitting)
- [User Story Map - Product Backlog](#user-story-map---product-backlog)
  - [Opstellen](#opstellen)
- [Definition of Done (DoD)](#definition-of-done-dod)
- [Prioriteiten en Storypoints](#prioriteiten-en-storypoints)
  - [MoSCoW-methode](#moscow-methode)
  - [Kano-model](#kano-model)
  - [Story points](#story-points)
    - [Planning poker](#planning-poker)
  - [Sprint planning](#sprint-planning)
  - [Acceptatiecriteria](#acceptatiecriteria)
    - [Given / When / Then](#given--when--then)
    - [Stappenplan acceptatiecriteria opstellen](#stappenplan-acceptatiecriteria-opstellen)
    - [Testen](#testen)
      - [V-model](#v-model)
    - [Andere manieren om kwaliteit te borgen](#andere-manieren-om-kwaliteit-te-borgen)

# Use cases

= uitgeschreven verhaal van een actor die het systeem gebruikt om een bepaald doel te bereiken.

Geeft een duidelijke scope voor het systeem => alles in de UC = in-scope alles niet in UC = out-of-scope

Beschrijft nooit hoe iets gebeurt, enkel wat er gebeurt.

Vier soorten actiestappen mogelijk:

- Actor vraagt iets aan het systeem
- Systeem geeft iets terug / vraagt iets
- Interne werking: Systeem valideert iets
- Interne werking: Systeem wijzigt iets

## Template

- Use Case: naam (actief geformuleerd vb. "Bestelling plaatsen")
- Primaire actor
- Stakeholders
- Precondities
- Postcondities
- Normaal verloop
- Alternatieve verlopen
- Domeinspecifieke regels
- Op te klaren punten

## Use cases opstellen

1. Leg actor en doel vast.
2. Stel normaal verloop op.
3. Bedenk wat er fout kan lopen / welke uitzonderingen er bestaan.
4. Werk alternatieve verlopen uit.

# User stories

Nadeel van use cases: uitgebreid, technisch, soms niet geschikt voor agile.

User stories zijn een lichter alternatief => User stories zijn kleiner (één concrete behoefte) en zijn bewust onvolledig. Het voornaamste doel is communicatie en prioritering i.p.v. functioneel ontwerp zoals bij UC.

Een UC kan meerdere user stories bevatten. Een user story kan aanleiding geven tot een UC.

Gebruik user stories om snel te starten en prioriteiten te bepalen. Gebruik use cases als je alle details wil vastleggen en een referentiedocument wil. <br> _In de praktijk start je met user stories en werk je de complexe uit naar een use case._

Een user story neemt het volgende formaat aan: <br>
_Als <abbr title="actor / gebruiker">[wie]</abbr> wil ik <abbr title="functionaliteit">[wat]</abbr>, zodat <abbr title="business waarde">[waarom]</abbr>._

Een user story snijdt door alle lagen van de applicatie (slice the cake) => Technische taken (database implementatie, code schrijven etc.) vloeien voort uit één story

## Kenmerken van een goede user story

- Kort en eenvoudig
- Vanuit het perspectief van een eindgebruiker
- Waardegedreven
- Flexibel
- Makkelijk te plannen

### INVEST

=> Acroniem voor zes kwaliteitscriteria

- **I**ndependent => Niet afhankelijk van andere user stories. (Afhankelijkheden van database en technische infrastructuur zijn onvermijdelijk.)
- **N**egotiable => Ze beschrijven een behoefte, ze leggen niets vast. Het ontwikkelteam bepaalt de technische aanpak. Ze kunnen aangepast worden.
- **V**aluable => Als er geen aantoonbaar voordeel verbonden is aan de user story moet het niet gebouwd worden. (Zit vervat in het "zodat" gedeelte)
- **E**stimatable => Team moet de omvang kunnen inschatten. Als dat niet mogelijk is, is de story te vaag, groot of technisch onbekend.
- **S**mall => Te plannen in één sprint. Als dat niet mogelijk is, is het een waarschijnlijk een epic.
- **T**estable => Er moeten duidelijke acceptatiecriteria zijn. Als je niet kan beschrijven hoe de story getest wordt, is hij te vaag.

# Epics, tasks & splitting

- Epic: <abbr title="vb. Authenticatie">Groot stuk functionaliteit, dat niet in één sprint past.</abbr>
- User story: <abbr title="vb. Als klant wil ik kunnen inloggen met e-mail en wachtwoord, zodat ik mijn account kan beheren.">Behoefte van een eindgebruiker.</abbr>
- Task: <abbr title="Maak de login-pagina aan in React">Technische taken die voortvloeien uit een user story.</abbr>

| User story                          | Task                                      |
| ----------------------------------- | ----------------------------------------- |
| 'Als wie wil ik wat, zodat waarom.' | Geen vast patroon                         |
| Verstaanbaar voor business          | Technische taal toegelaten                |
| Verplichte businesswaarde           | Moet de user story dienen                 |
| Onafhankelijk                       | Mag dependencies hebben                   |
| Slice the cake                      | Behandelt vaak één laag van de applicatie |

## INVEST-splitting

Je splitst stories op tot ze voldoen aan [INVEST](#invest).

Je kan ze splitsen op:

- Workflow: Deel de story op in stappen
- Business rules: Implementeer regel per regel
- Data: Splits op basis van welke data verwerkt wordt
- Gebruikersrollen: Implementeer de functionaliteiten per rol (vb. bestelling door klant ingevoerd vs. door verkoper ingevoerd)
- CRUD: Aparte CRUD-operatie i.p.v. "beheren"

Let wel op: Elke story moet nog steeds aan INVEST voldoen.

# User Story Map - Product Backlog

User stories worden verticaal per prioriteit gerangschikt.

<abbr title="Minimum Viable Product">MVP</abbr> => Lijn die de eerste release afbakent. <br>
<abbr title="Minimum Lovable Product">MLP</abbr> => Lijn die de tweede release afbakent.

Resultaat van de USM = lijst van alle user stories op prioriteit. Dit is de **product backlog**.

Een goede product backlog:

- Is geordend op prioriteit.
- Kan gewijzigd worden (levend document).
- Bovenste user stories zijn gedetailleerd en klaar voor implementatie.
- Onderste user stories zijn nog niet volledig uitgewerkt (<abbr title="Just In Time">JIT</abbr>)
- Wordt na iedere sprint herzien op basis van feedback.

## Opstellen

1. Start met verhaal: Hoe doorloopt de gebruiker het proces?
2. Identificeer de epics: Groepeer grote, coherente blokken functionaliteit
3. Schrijf per epic de concrete user stories uit.
4. Prioriteer de user stories verticaal
5. Baken releases af: Trek de lijn voor MVP en MLP
6. Valideer: Bespreek de map met alle stakeholders.

# Definition of Done (DoD)

Legt vast wanneer een user story als "done" wordt beschouwd.

Rollen binnen de DoD:

- Product owner => checkt of de acceptatiecriteria vervuld zijn
- Dev team => verantwoordelijk voor technische kwaliteit
- Testers (QA) => controleren of alles getest en goedgekeurd is

Verschil met acceptatiecriteria: Acceptatiecriteria gelden maar voor één user story. DoD is generiek.

Een story is "done" als zowel de DoD als acceptatiecriteria vervuld zijn.

# Prioriteiten en Storypoints

## MoSCoW-methode

|             | Effect bij ontbreken   | Richtlijn inspanning   |
| ----------- | ---------------------- | ---------------------- |
| Must have   | Release gaat niet door | 60%                    |
| Should have | Workaround mogelijk    | 20%                    |
| Could have  | Nauwelijks effect      | 20%                    |
| Won't have  | Geen effect            | 0% - bewust geparkeerd |

Alert zijn voor het feit dat de meeste mensen alles als "must have" willen bestempelen.

## Kano-model

=> Vanuit perspectief eindgebruiker

|                         | Omschrijving                                         | Voorbeeld           |
| ----------------------- | ---------------------------------------------------- | ------------------- |
| Basisbehoefte           | Gebruiker is ontevreden als dit onbreekt             | kunnen inloggen     |
| Prestatiebehoefte       | Hoe beter uitgevoerd hoe tevredener de eindgebruiker | snelle laadtijd     |
| Aantrekkelijke behoefte | Onverwachte features die de eingebruiker verrassen   | AI-assistent        |
| Onverschillige behoefte | Maakt niet uit voor eindgebruiker                    | achtergrondkleur    |
| Omgekeerde behoefte     | Features die de gebruiker niet wil                   | pop-up advertenties |

## Story points

=> geen tijdsinschatting in uren of dagen, maar complexiteit. Moeten ook rekening houden met technische onzekerheden, afhankelijkheden en risico's.

Je kan "T-shirt sizing" gebruiken als er nog weinig details zijn.

| T-shirt size | Tijd      | Story Points | Richtlijn                            |
| ------------ | --------- | ------------ | ------------------------------------ |
| XS           | < 1 dag   | 1            | Triviaal, zonder onzekerheden        |
| S            | 1-3 dagen | 2-3          | Kleine story, weinig risico          |
| M            | 3-7 dagen | 5-8          | Gemiddelde story, enige complexiteit |
| L            | 1-2 weken | 13-20        | Grote story, overweeg splitsen       |
| XL           | 2-4 weken | 40+          | Is een epic, moet je splitsen        |

Als je de kanobehoefte combineert met MoSCoW krijg je ongeveer deze waarden:

| Kano-categorie          | Must have | Should have | Could have |
| ----------------------- | --------- | ----------- | ---------- |
| Basisbehoefte           | 2-5 SP    | 3-8 SP      | 5-13 SP    |
| Prestatiebehoefte       | 3-8 SP    | 5-13 SP     | 8-20 SP    |
| Aantrekkelijke behoefte | 5-13 SP   | 8-20 SP     | 13-40 SP   |

### Planning poker

=> manier om story points in te schatten als team.

1. <abbr title="Product owner">PO</abbr> legt story uit en beantwoordt vragen van team.
2. Iedereen schat individueel.
3. Iedereen draait kaarten tegelijk om.
4. Bespreek uitschieters (laat hoogste en laagste schatting beargumenteren)
5. Kom tot consensus => als er consensus is: als waarde in product backlog vastleggen

Meestal tijdens refinement sessies. Doel = top van backlog verfijnen. <br>
_Dit voldoet aan het JIT-principe_.

## Sprint planning

Velocity = gemiddeld aantal story points dat het team per sprint oplevert.
<br>_Geen maat voor productiviteit => hulpmiddel voorspelbaarheid en planning_

Velocity is niet stabiel voor een nieuw team (meestal na 4-5 sprints wel)

Yesterday's weather = kijken naar aantal voltooide story points in vorige sprints om de toekomst te voorspellen. (Uitschieters meenemen in berekening aantal story points per week.)

A.d.h.v. velocity kan je voorspellen wanneer een release klaar zal zijn. Er zijn daarvoor ook hulpmiddelen.

- Burn-up chart: x-as toont sprints, y-as de gerealiseerde story points. Je kan zo zien of het team achter- of voorloopt. (wordt vooral gebruikt bij forecasting)
- Burndown chart: Toont hoeveel werk er nog in een sprint of project is. Y-as drukt de resterende story points uit i.p.v. de afgewerkte. (wordt vooral gebruikt om in te schatten waar we zitten)

## Acceptatiecriteria

=> Vooraf gedefinieerde eisen en voorwaarden waaraan een product of taak moet voldoen. -> vergelijkbaar met definition of done, maar voor één user story.

Worden in de planningsfase opgesteld (dus vóór de implementatie).

Acceptatiecriteria worden in een checklist weergegeven of in het formaat Given/When/Then. Ze worden beschreven vanuit het gedrag/systeem. Ze moeten specifiek en meetbaar zijn.

Voordelen acceptatiecriteria:

- **Afstemming en gedeeld begrip**: Wanneer is iets "klaar"?
- **Minder onduidelijkheid**: Duidelijke eisen
- **Verbeterde testefficiëntie**: Duidelijk verwacht gedrag om te gaan testen.
- **Verbeterd projectmanagement**: Meetbare voortgang
- **Verhoogde tevredenheid**: Systeem sluit beter aan bij de verwachtingen van de klant.

Karakteristieken van goed acceptatiecriterium:

- Duidelijk en beknopt
- Testbaar (duidelijke pass/fail, geen grijze zones)
- Beschrijft het resultaat
- Meetbaar
- Onafhankelijkheid

Eén user story heeft meestal meerdere acceptatiecriteria, afhankelijk van de alternatieve verlopen.

### Given / When / Then

=> Meest gebruikte format om acceptatiecriteria te schrijven. Afkomstig van <abbr title="Behavior Driven Development">BDD</abbr>.

- Scenario: Korte omschrijving van het acceptatiecriterium (vb. "Geen zoekresultaten")
- Given (gegeven) => Precondities / context
- When (als) => De actie die uitgevoerd wordt
- Then (dan) => Verwachte resultaat

(Vergelijkbaar met teststructuur in JUnit)

### Stappenplan acceptatiecriteria opstellen

1. Lees de user story.
2. Bepaal de resultaten => Wat is het verwachte gedrag? (= criteria)
3. Stel testbaarheid van criteria vast => Indien niet testbaar, herformuleren.
4. Maak de criteria meetbaar.
5. Focus op onafhankelijkheid => één specifiek aspect per criterium
6. Bevorder samenwerking door ze samen te schrijven met <abbr title="Product Owner, ontwikkelteam, testers">de 3 amigos</abbr>
7. Herziening en verfijning na feedback.

### Testen

Acceptatiecriteria zijn basis voor het testen.

Testen zijn belangrijk om:

- Risico's van wijzigingen te beperken.
- Vroegtijdig fouten te ontdekken (fout in ontwikkeling kost 5-10x meer dan fout ontdekken in requirementsfase, fout in productie kost 50-100x meer)
- Verificatie: bugs vermijden
- Validatie: voldoet het systeem aan de requirements?

| Soort test                                       | Wat test het?                                                       | Wanneer               | Verantwoordelijk                                 |
| ------------------------------------------------ | ------------------------------------------------------------------- | --------------------- | ------------------------------------------------ |
| Unit testing                                     | Individuele functies/methoden                                       | Tijdens implementatie | Dev                                              |
| Component testing                                | Individuele modules (vb. API)                                       | Na unit testing       | Dev/QA                                           |
| Integration testing                              | Interactie tussen modules                                           | Na component testing  | QA/Dev                                           |
| System testing                                   | Of het systeem de functionele en non-functionele requirements dient | Voor release          | QA                                               |
| <abbr title="User Acceptance Testing">UAT</abbr> | Valideren of het systeem aan de gebruikersbehoeften voldoet         | Voor productie        | Klant / <abbr title="Business Analist">BA</abbr> |
| Regression testing                               | Nieuwe wijzigingen breken bestaande functionaliteit niet            | Na elke wijziging     | QA (maar vaak geautomatiseerd)                   |

#### V-model

Elke soort test wordt aan een fase gekoppeld => Daarin worden de testen opgesteld. Het draaien van de tests / accepteren van de tests gebeurt in omgekeerde volgorde. (vb. Acceptatietests worden opgesteld in de eerste fase, maar zijn de laatste die geaccepteerd worden.)

| Fase                                 | Test                  |
| ------------------------------------ | --------------------- |
| Requirements                         | Acceptatietest        |
| Functioneel ontwerp                  | Systeemtest           |
| Technisch ontwerp                    | Integratietest        |
| Implementatie componenten en modules | Unit en componenttest |

### Andere manieren om kwaliteit te borgen

- Collegiale review
- Expert review: iemand van buitenaf beoordeelt het product a.d.h.v. een checklist.
- Inspectie: 6-fasen proces (planning, kick-off, voorbereiding, groepsmeeting, aanpassing, afsluiting)
- Structured walkthrough: Auteur leidt beoordelaars door document.
