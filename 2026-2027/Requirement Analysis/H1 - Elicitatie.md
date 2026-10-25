# Requirement Elicitatietechnieken

- [Requirement Elicitatietechnieken](#requirement-elicitatietechnieken)
- [Requirements](#requirements)
  - [Soorten](#soorten)
  - [Business analist](#business-analist)
  - [Valkuilen](#valkuilen)
  - [Requirementsproces](#requirementsproces)
- [Stakeholders en eindgebruikers](#stakeholders-en-eindgebruikers)
  - [Stakeholders identificeren](#stakeholders-identificeren)
  - [Checklist stakeholderidentificatie](#checklist-stakeholderidentificatie)
  - [Power / Interest grid](#power--interest-grid)
- [Elicitatietechnieken](#elicitatietechnieken)
  - [Technieken](#technieken)
  - [Structuur requirementsinterview](#structuur-requirementsinterview)
  - [Persona's opstellen](#personas-opstellen)
- [User Story Map - Backbone](#user-story-map---backbone)
  - [De backbone](#de-backbone)
    - [Backbone opstellen](#backbone-opstellen)

# Requirements

## Soorten

- Functionele Requirements: Wat het systeem moet doen.
- Niet-functionele Requirements: Hoe het systeem iets moet doen of welke kwaliteit er verwacht wordt.
- Bedrijfsregels: Beperkingen vanuit de organisatie.6
- Randvoorwaarden: Technische of wettelijke beperkingen.

## Business analist

=> vertaalt de behoeften van de business naar requirements.

Taken:

- Requirements verzamelen
- Requirements analyseren: zijn ze volledig en consistent?
- Requirements documenteren
- Requirements valideren: zijn de gemaakte requirements volledig en correct?
- Communicatie faciliteren (tussen business en IT)

## Valkuilen

- Te vaag
- Te technisch
- Tegenstrijdig
- Onvolledig (enkel beschrijving van normaal verloop)
- Onmeetbaar

## Requirementsproces

1. Elicitatie - Behoeften verzamelen (moeilijkste fase)
2. Analyse van de verzamelde behoeften
3. Specificatie (= documenteren)
4. Validatie => samen met stakeholders bekijken of requirements volledig en correct zijn (a.d.h.v. reviews, walkthroughs of prototypes)
5. Requirement management: doordacht rekening houden met veranderende requirements

# Stakeholders en eindgebruikers

Stakeholders zijn belangrijk omdat elke groep andere behoeften / verwachtingen heeft. Je moet alle groepen bevragen. <br>
=> Ook belangrijk om draagvlak bij ze te hebben.

Business analist moet conflicterende belangen bespreken.

## Stakeholders identificeren

Vier technieken:

- Brainstormen met opdrachtgever
- Organogram bestuderen
- Processen in kaart brengen => deelnemers aan de processen zijn stakeholders
- <abbr title="Na elk interview vraag je wie er nog geïnterviewd moet worden. Zo vind je vaak stakeholders waar je zelf niet aan dacht.">Snowball-techniek</abbr>

## Checklist stakeholderidentificatie

- Wie zijn de eindgebruikers van het systeem?
- Wie geeft de opdracht / betaalt het systeem?
- Wie beslist over de vereisten?
- Wie heeft technische kennis van het te bouwen systeem?
- Wie levert data aan of ontvangt data van het systeem?
- Wie heeft wettelijke of regelgevende verantwoordelijkheid?
- Wie kan het project blokkeren of tegenwerken?
- Wie zijn de externe partijen (klanten, leveranciers, partners)?

## Power / Interest grid

=> Kan gebruikt worden om te bepalen hoe je stakeholders het beste behandelt.

|                  | Lage interesse                                                            | Hoge interesse                                                     |
| ---------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------ |
| **Hoge invloed** | <abbr title="vb. senior management, aandeelhouder">Tevreden houden</abbr> | <abbr title="vb. zaakvoerder, product owner">Nauw betrekken</abbr> |
| **Lage invloed** | <abbr>Monitoren</abbr>                                                    | <abbr title="vb. dagelijkse eindgebruiker">Informeren</abbr>       |

# Elicitatietechnieken

> Ijsberg-principe: De informatie van stakeholders is meestal onvolledig.

## Technieken

| Techniek              | Wanneer gebruiken?                                          | Grootste voordeel                                                                                                                                                                                  | Grootste nadeel                                                                                      |
| --------------------- | ----------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| Interview             | Je hebt diepgaande info van individuele stakeholders nodig. | Mogelijkheid om door te vragen, bouwt vertrouwen bij stakeholder.                                                                                                                                  | Tijdrovend, moeilijk als er veel stakeholders moeten worden gehoord.                                 |
| Workshop / Focusgroep | Je wil meerdere stakeholders bevragen en consensus bereiken | Efficiënt, detecteert makkelijk tegenstrijdigheden                                                                                                                                                 | Complexe organisatie, dominante stakeholders kunnen overstemmen, groepsdenken                        |
| Observatie            | Stakeholders hebben moeite om requirements te beschrijven   | Ontdekt <abbr title="Requirements die de stakeholder niet heeft uitgesproken, maar als vanzelfsprekend beschouwt.">impliciete requirements</abbr>, geeft inzicht in gebruik van bestaande systemen | Tijdrovend, aanwezigheid observator heeft invloed op het gedrag, kan niet altijd omwille van privacy |
| Documentanalyse       | Als er veel documentatie is.                                | Objectief                                                                                                                                                                                          | Documenten kunnen outdated zijn, niet alles is gedocumenteerd                                        |
| Vragenlijst           | Je wil veel stakeholders bereiken.                          | Anonimiteit, efficiënt                                                                                                                                                                             | Lage respons, onmogelijk doorvragen                                                                  |

## Structuur requirementsinterview

1. Opening -> Ook toestemming vragen voor opname / aantekeningen
2. Contextschets -> Laat geïnterviewde zijn/haar rol beschrijven
3. Huidig proces bespreken
4. Pijnpunten van huidig proces bespreken
5. Behoeften bevragen
6. Must-haves bespreken
7. Nice-to-haves bevragen
8. Randvoorwaarden bespreken (vooral wetten en bedrijfsregels)
9. Afsluiten -> vragen of de geïnterviewde nog iets wil toevoegen

Daarna zo snel mogelijk aantekeningen uitwerken en doorsturen naar geïnterviewde ter validatie.

## Persona's opstellen

=> Helpen de eindgebruiker centraal te stellen en zorgen ervoor dat iedereen in het team hetzelfde beeld van de eindgebruiker heeft.

Elke persona heeft:

- Naam + foto
- Demografische gegevens
- <abbr title="Wat wil deze persoon met het systeem bereiken?">Doelen</abbr>
- <abbr title="Welke problemen lost het systeem voor deze persoon op?">Pijnpunten</abbr>
- <abbr title="Technologische vaardigheden + gebruiksgedrag">Gedrag en context</abbr>
- Citaat dat de essentie van de persona samenvat

# User Story Map - Backbone

=> Visuele weergave van alle functionaliteiten van een systeem.

Twee assen in de USM:

- Horizontaal = narrative flow: Elke kolom is een activiteit in de volgorde zoals de gebruiker ze ervaart.
- Verticaal = prioriteit: Meest essentiële user stories staan bovenaan.

De bovenste lagen vormen het <abbr title="Minimum Viable Product">MVP</abbr>.

USM maak je in het begin van een project => je kent de grote lijnen, maar details nog niet. USM evolueert doorheen het project.

## De backbone

= bovenste rij in USM.

Bestaat uit <abbr title="Grote blokken functionaliteit">epics</abbr>, ze zijn te groot om in één sprint te implementeren en kunnen in user stories opgesplitst worden. Ze kunnen opgesplitst worden in <abbr title="Minder dan 3 = het is geen epic, maar user story">3</abbr>-<abbr title="Meer dan 15 = opsplitsen in twee epics">15</abbr> user stories.

### Backbone opstellen

1. Beschrijf het verhaal van de gebruiker.
2. Identificeer de epics => Activiteiten gegroepeerd in blokken verwante functionaliteit.
3. Zet de epics in volgorde op de horizontale as
4. Valideer bij de stakeholders
