<h1>Ontwikkelstrategieën</h1>

- [Waterfall vs. Agile](#waterfall-vs-agile)
  - [Agile Manifesto](#agile-manifesto)
- [Scrum](#scrum)
  - [Rollen](#rollen)
    - [Producteigenaar](#producteigenaar)
    - [Scrum-master](#scrum-master)
    - [Team](#team)
  - [Sprint](#sprint)
    - [Voorbereiding](#voorbereiding)
    - [Sprintplanning](#sprintplanning)
      - [Schattingen](#schattingen)
    - [Stand-up](#stand-up)
    - [Demo en Sprint review](#demo-en-sprint-review)
    - [Sprint retrospective](#sprint-retrospective)
  - [Documenten](#documenten)
    - [Product backlog](#product-backlog)
    - [Sprint backlog](#sprint-backlog)
    - [Burndown statistieken](#burndown-statistieken)
- [Kanban](#kanban)

# Waterfall vs. Agile

Klassiek: waterfall

Werkte in vijf fasen:

- Behoefte analyse
- Analyse
- Ontwikkeling
- Testen
- Oplevering

Agile is een mentaliteitswijziging (van C&C door managers naar samenwerken) -> reactie op waterfall.

Het is een overkoepelende term voor verschillende werkwijzen (zoals Scrum en Kanban).

## Agile Manifesto

[Hier terug te vinden](https://agilemanifesto.org/).

Principes:

- Hoogste prioriteit = klant tevreden stellen
- Wijzigingen zijn welkom
- Er moet geregeld werkende software opgeleverd worden
- Nadruk op samenwerking (face-to-face en ook tussen business en dev-kant)
- Teams organiseren zichzelf
- Eenvoud is essentieel

# Scrum

= open framework met eenvoudige regels

Gebaseerd op CAS (= Complex Adaptieve Systemen).

- Iteratief: Steeds opnieuw, korte periodes
- Incrementeel: Software wordt verticaal gebouwd i.p.v. horizontaal

Belangrijkste concepten:

- Gesloten iteraties (de scope mag niet wijzigen binnen een sprint)
- Na elke iteratie is er productiewaardige software.
- Alles krijgt een prioriteit
- Teams zijn zelforganiserend en -reflecterend.

## Rollen

### Producteigenaar

Vertegenwoordigt de klant.

Meestal één persoon, bepaalt de prioriteiten en wat er gebouwd moet worden.

Laat het team zo veel mogelijk met rust tijdens de sprint.

### Scrum-master

Past Scrumconcepten toe en doet aan kwaliteitscontrole.

Kwaliteitscontrole:

- softwarekwaliteit: zorgen dat er niet veel bugs zijn.
- efficiëntie: juiste scope, juiste tijd, volgens vraag van producteigenaar

Moet alles in vraag stellen en mensen uitdagen. Niet zelf met oplossingen komen, wel brandjes blussen (gelijkaardig aan lesgeven).

_Niet verantwoordelijk voor verdelen van taken, prioriteiten, maken van inschattingen, oplossen van problemen, nemen van verantwoordelijkheid._

### Team

= Zelforganiserend

Meestal 5 tot 9 mensen (meer devs nodig = meer teams).

Werken full-time aan het project (uitzonderingen voor ondersteunende rollen).

## Sprint

Meestal twee tot drie weken.

Product ontwerpen, schrijven en testen.

Meestal:

- Voor de sprint: Voorbereiding
- Dag 1: Product planning en Sprint planning
- Rest: Stand-up
- Laatste dag: Sprint review en retrospective

### Voorbereiding

Producteigenaar en klant stellen de features op en lijsten dit op in een product backlog. Elke feature krijgt een unieke prioriteit (dus geen enkele feature heeft dezelfde prioriteit).

### Sprintplanning

Ruwe schatting van hoeveel items in de sprint opgenomen kunnen worden => gebeurt door team, maar producteigenaar beantwoordt vragen.

Hier moet een sprintdoel bepaald worden.

Backlog items moeten opgesplitst worden door team = zelforganiserend.

In principe zijn er geen managers tijdens de sprintplanning -> ze mogen geen taken toekennen of beslissingen voor het team maken.

Taken in een Sprint backlog duren 4-16 uur.

#### Schattingen

Planning poker -> Elk teamlid krijgt kaarten met nummers op (= aantal uren, meestal tussen 1 en 16). Iedereen legt gelijktijdig een kaart op tafel (geen invloed op anderen) met inschatting hoeveel uur een taak in beslag neemt.

_Speciale aandacht voor de uiterste inschattingen. Minimale en maximale inschatting moeten hun argumenten geven voor hun aantal ingeschatte uren._

Let op voor anchoring -> = laten beïnvloeden door anderen wanneer je een schatting moet maken.

Bij nieuwe teams en sprint schatting, schat je het aantal uren in die je nodig hebt om een taak te voltooien. Bij backlog schattingen werk je met punten.

De schattingen worden gedaan door wie het werk doet.

### Stand-up

Dagelijks overleg van 15 minuten. Iedereen staat recht, doel is niet om problemen op te lossen.

Iedereen beantwoordt drie vragen:

- Wat deed je gisteren?
- Wat ga je vandaag doen?
- Welke obstakels ervaar je?

Is belangrijk dat dit dagelijks gebeurt omdat het volledige team dan elke dag een volledig beeld van het project krijgt + creëert sociale druk om te doen wat je zegt.

### Demo en Sprint review

Team stelt de software voor (typisch met een demo of onderliggende architectuur)

Deelnemers: klanten, management, producteigenaar.

### Sprint retrospective

Deelnemers: Team, Scrum Master, producteigenaar (optioneel)

Belangrijkste vragen:

- Wat ging goed tijdens de sprint?
- Wat kan beter in de volgende sprint?

Resultaat: Bepaal acties, voeg ze eventueel toe aan de product backlog. De acties moeten altijd business value hebben.

## Documenten

### Product backlog

Een lijst van al het gewenste werk van het project.

- Story-based werk (-> features toevoegen)
- Task-based werk (-> werking van de software verbeteren)

Prioriteit bepaald door producteigenaar.

### Sprint backlog

Werkdocument van het team. Hier kan je individuele taken opvolgen.

Vaak een bord met wat er nog moet gedaan worden -> elke dag corrigeren om doel te behalen.

### Burndown statistieken

Hier kan je visueel zien hoe snel de taken afgewerkt worden t.o.v. wat er gepland stond.

# Kanban

Heeft geen rollen, werkt met een visueel bord.

=> Voordeel: heel laagdrempelig.

Wordt vaak gebruikt binnen een productie-omgeving en systeembeheer.

Gericht op optimalisatie:

- Just-in-Time
- Beperken van bottlenecks
- Limiet op WIP taken.

Bord wordt opgedeeld in:

- Backlog: Taken die moeten gebeuren.
- Next: Volgende op-te-nemen taken.
- Analyse: Doel van de taak moet duidelijk worden en de taak moet eventueel opgesplitst worden.
- Development: Code schrijven, geïntegreerde testen
- Acceptance: De klant aanvaardt het afgewerkte product.
- Production: De taak is afgewerkt en wordt in de productieomgeving toegepast.
