# Besturingssystemen (Inleiding)

- [Wat is een besturingssysteem?](#wat-is-een-besturingssysteem)
- [Evolutie van besturingssystemen](#evolutie)
- [Soorten besturingssystemen](#soorten-besturingssystemen)
- [Concepten van besturingssystemen](#concepten-van-besturingssystemen)

## Wat is een besturingssysteem?

Besturingssysteem = programma dat het mogelijk maakt de hardware van een computer te gebruiken.

Gebruikers geven opdrachten aan OS, niet aan hardware. OS geeft opdracht aan hardware om gewenste taken uit te voeren.

Voorbeelden van taken:
- Opslaan en ophalen van informatie
- Programma's afschermen
- Tijdsplanning maken
- Reageren op fouten
- ...

## Evolutie
*Dit onderdeel is geen leerstof voor het examen.*

- 1940 - 1959: Nog geen OS, manueel laden van programma's. Eerste "OS" in 1956.
- 1960 - 1969: Multiprogrammering (meerdere programma's tegelijkertijd in geheugen van CPU) en timesharing (meerdere gebruikers op één systeem).
- 1970 - 1979: Unix releaset in 1971, revolutionair door eenvoud, draagbaarheid en multitasking. PC's maken ook hun opkomst.
- 1980 - 1989:
    - GUIs komen op (Apple Macintosh - 1984 en Windows 1985)
    - Netwerkfuncties zoals TCP/IP
- 1990 - 1999: Linux als eerste open-source OS. Windows en macOS verbeteren GUI's (PC's worden populair).
- 2000 - vandaag: Mobiele OS domineert (iOS en Android). Veel technologieën zijn cloudgebaseerd waardoor Linux en Windows Server belangrijk zijn.
- Vandaag - toekomst:
    - Integratie AI
    - Spraakopdrachten
    - Voorspellende tekst
    - Gepersonaliseerde aanbevelingen
    - Verbeterde efficiëntie en rekenkracht 

## Soorten besturingssystemen

- Single-tasking: Kan 1 taak tegelijkertijd (vb. MS-DOS)
- Multi-tasking: Kan meerdere taken tegelijkertijd (vb. Windows 11)
- Multi-user: Meerdere gebruikers kunnen tegelijkertijd het systeem gebruiken. (vb. Systeem van een bank - Verwerkt transacties van vele gebruikers)

Welk type wenselijk is hangt af van de behoeften van de gebruikers.

## Concepten van besturingssystemen

### Lagen

OS bestaat uit meerdere **lagen**:
- Shell / Command Interpreter: Bovenste laag. De gebruiker interageert met deze laag.
- Utilities: Complexe opdrachten uit de shell coördineren, verzorgen grootste deel van controle en voorbereiding.
- Kernel: Bevat de routines die het vaakst worden gebruikt.

### Programma's

De **programma's** die een OS uitvoert kunnen in drie categorieën onderverdeeld worden:
- Interactieve programma's (snelle respons): Gebruiker voert korte opdracht in en verwacht een antwoord (=conversatie-achtig). Deze programma's krijgen van de OS voorrang.
- Batch-programma's (geen directe respons): Gebruiker slaat opdrachten in een file op. Batch-programma komt in een wachtrij terecht. OS geeft minder prioriteit aan Batch-programma's tijdens scheduling.
- Real-time programma's (respons in heel beperkte tijd): Voor deze programma's is een snelle respons essentieel, het programma legt aan de OS een tijdslimiet op om te antwoorden. (vb. Real-time verwerking van controlesysteem luchtverkeer)

### Processen

Programma's bestaan uit één of meerdere **processen** = reeksen van opdrachten, de OS beschouwt dit als één werkeenheid.

De OS bepaalt hoeveel **resources** elk proces toegewezen krijgt. Processen spreken resources (Ned: bronnen) aan. Voorbeelden van resources zijn: bestanden, RAM-geheugen, uitvoeringstijd op de CPU, communicatie met randapparatuur...

Een OS is niet bezig met de gebruiker of programma's. Het focust zich op de uitvoering van de processen. Een OS bepaalt welke processen wanneer uitgevoerd worden en hoeveel resources ze toegewezen krijgen.

De OS zorgt ervoor dat processen voldoende geheugen krijgen, regelt het gebruik van de CPU, regels de gegevensstroom van / naar randapparatuur en lokaliseert bestanden.

### Scheduling, concurrency en synchronisatie
De OS (multi-tasking en multi-user) doet aan **scheduling** het geeft processen een bepaalde prioriteit. 

**Concurrency** betekent dat de OS meerdere processen tegelijk uitvoert. Als er een conflict is (vb. meerdere processen willen dezelfde printer gebruiken), regelt de OS de volgorde waarin de processen verwerkt worden (= **synchronisatie**)

### Ontwerpcriteria
Een moderne OS moet aan drie ontwerpcriteria voldoen:
- Consistentie: Respons moet constant zijn.
- Flexibiliteit: Nieuwe versies horen oude applicaties te ondersteunen. Nieuwe randapparaten moeten makkelijk aangesloten kunnen worden.
- Overdraagbaarheid: OS moet op verschillende soorten computers werken.