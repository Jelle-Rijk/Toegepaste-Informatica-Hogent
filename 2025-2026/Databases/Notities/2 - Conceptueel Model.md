<h1> Conceptueel Model </h1>

- [Fases in DB ontwerp](#fases-in-db-ontwerp)
  - [Fase 1 - Verzamelen en analyseren van de functionele / inhoudelijke vereisten](#fase-1---verzamelen-en-analyseren-van-de-functionele--inhoudelijke-vereisten)
  - [Fase 2 - Conceptueel ontwerp](#fase-2---conceptueel-ontwerp)
  - [Fase 3 - Logisch ontwerp](#fase-3---logisch-ontwerp)
  - [Fase 4 - Fysiek ontwerp](#fase-4---fysiek-ontwerp)
- [ERD - Entity Relationship Diagram](#erd---entity-relationship-diagram)
  - [Relatietypes](#relatietypes)
    - [Cardinaliteiten](#cardinaliteiten)
  - [Attribuuttypes](#attribuuttypes)
- [Zwak entiteitstype](#zwak-entiteitstype)
  - [Historiek](#historiek)
  - [Ternaire relaties](#ternaire-relaties)
- [EERD - Extended Entity Relationship Diagram](#eerd---extended-entity-relationship-diagram)
  - [Specialisatie](#specialisatie)
  - [Generalisatie](#generalisatie)
  - [Participatie en Disjoint constraint](#participatie-en-disjoint-constraint)
- [Beperkingen van het ERD](#beperkingen-van-het-erd)
  - [Fan trap](#fan-trap)
  - [Chasm trap](#chasm-trap)

# Fases in DB ontwerp

![Fases voor het ontwerpen van een databank](./img/fases-db-ontwerp.png)

## Fase 1 - Verzamelen en analyseren van de functionele / inhoudelijke vereisten

Je moet in communicatie treden met de opdrachtgever en toekomstige gebruikers.

Je vertrekt altijd vanuit bedrijfsprocessen. <br>Voorbeelden van bedrijfsprocessen: opstellen van facturen, werkroosters managen, voorraadbeheer, etc.

**Doel** = Benodigde data begrijpen en bepalen wat er in de databank moet opgenomen worden.

_Deze stap is databasemodel- en dbms-onafhankelijk._

## Fase 2 - Conceptueel ontwerp

Grafische weergave van je idee over wat in de DB moet komen. Ontstaat uit de gesprekken in fase 1.
<br> Je bent hier nog niet bezig met tabellen maken!

ERD is een voorbeeld van een conceptueel ontwerp.

**Doel** = Een communicatiemiddel om duidelijk te maken wat er in de databank komt. Het moet verstaanbaar zijn voor zowel IT'ers als niet-IT'ers.

_Deze stap is databasemodel- en dbms-onafhankelijk._

## Fase 3 - Logisch ontwerp

Hier wordt nagedacht over welk type databank (vb. relationeel, NoSQL) je gaat gebruiken. Het product zelf ligt meestal nog niet vast.

Het kan zijn dat er informatie verloren gaat bij de vertaling van het conceptueel naar het logisch ontwerp. Deze informatie moet je opnemen in een apart document.

_Deze stap is dbms-onafhankelijk._

## Fase 4 - Fysiek ontwerp

De implementatie van het logisch ontwerp. Hier maak je tabellen en werk je met een specifieke DBMS. Je schrijft hier code om datarestricties op te leggen.

# ERD - Entity Relationship Diagram

Geïntroduceerd door Peter Chen (1976)

Heeft drie bouwstenen:

- Entiteittypes -> Gelijkaardig aan een klasse in programmeren
- [Attribuuttypes](#attribuuttypes)
- [Relatietypes](#relatietypes) -> Definieert de relatie tussen één of meerdere entiteittypes

Een **entiteit** is een instantie van een entiteittype. (vb. Pablo Picasso is een entiteit van entiteittype Schilder)

Een entiteittype moet altijd **identificeerbaar** zijn en een inhoud hebben. Je kan dus geen entiteittype creëren zonder een attribuut.

## Relatietypes

De **graad van een relatietype** wordt bepaald door het aantal verschillende entiteittypes die deelnemen aan het relatietype:

- 1 entiteittype: Unaire relatie
- 2 entiteittypes: Binaire relatie

Een relatietype kan **rollen** definiëren. Dat is bij binaire relaties meestal de naam van elk entiteittype. Bij unaire relaties krijgen ze meestal een aparte naam.

_vb. Een entiteit van entiteittype Persoon kan een unaire relatie hebben met een andere Persoon. Dan kan de relatie bijvoorbeeld zijn "verwant met" en de rollen "kind" en "ouder"_

Relatietypes kunnen ook attributen hebben, die noemen we relatie-attributen. Deze zijn belangrijk als de kenmerken bij de relatie horen (vb. wanneer en voor welke prijs iets gekocht is), maar niet bij een van de entiteittypes (vb. de koper of het gekochte goed)

### Cardinaliteiten

Geven aan hoeveel entiteiten minimaal en maximaal aan de relatie deelnemen.

Ze moeten vaak afgetoetst worden bij de opdrachtgever -> Enkel modelleren wat je weet, geen veronderstellingen.

De minimumcardinaliteit kan 1 of N zijn. <br>
De maximumcardinaliteit kan 0 (= sommige entiteiten nemen niet deel, de relatie is optioneel) of 1 zijn.

Bij twijfel of de minimumcardinaliteit 0 of 1 is, kies je best voor 0. 1 is een zeer strenge restrictie binnen de database.

<figure> 
    <img src="./img/voorbeeld-cardinaliteit.png">
    <figcaption> 
    <p><strong>1..1</strong> - Elke video is geüpload door minimaal één en maximaal één gebruiker. <br> <strong>0..N</strong> - Een gebruiker kan geen of meerdere video's uploaden.</p>
    </figcaption>
</figure>

## Attribuuttypes

**Enkelvoudige vs. samengestelde attribuuttypes**:

- Samengesteld: Kunnen nog verder opgesplitst worden (vb. adres -> straat, nummer, postcode, woonplaats)
- Enkelvoudig: Kan niet verder opgesplitst worden.

In een conceptueel model: Steeds op niveau van enkelvoudige attribuuttypes

**Enkelwaardige vs. meerwaardige attribuuttypes**:

- Enkelwaardig: Attribuut kan maar één waarde hebben (vb. iedereen heeft één geboortedatum)
- Meerwaardig: Attribuut kan meerdere waarden bevatten (vb. iemand kan meerdere hobby's hebben)

Beide kunnen voorkomen in ERD. Meerwaardige attributen worden in dit vak vermeden.

**Afgeleide attribuuttypes** zijn berekende waarden zoals "leeftijd", deze mogen niet in de database voorkomen.

Een **kandidaatsleutelattribuut** is een attribuut dat een identiteit kan identificeren door een uniek(e combinatie van) attribu(u)t(en). Dit moet op een irreducibele manier gebeuren (= we kunnen geen delen weglaten zonder de identificatie onmogelijk te maken).

**IN HET ERD MOET JE ALLE MOGELIJKE KANDIDAATSSLEUTELS AANDUIDEN**

Als de kandidaatsleutel uit meerdere attributen bestaat, duiden we ze in het ERD met een u-constraint aan. <br>
Als ze uit een attribuut bestaan <u>onderlijnen</u> we het.

Let op met ID's. Probeer vooral identificatienummers te gebruiken die ook in de echte wereld bestaan (vb. nummerplaat, ISBN-nummer, studentnummer, etc.). Je loopt namelijk het risico dezelfde records meerdere keren toe te voegen onder andere identificatienummers.

# Zwak entiteitstype

Dit zijn entiteitstypes die **bestaansafhankelijk** zijn van een ander entiteitstype (eg. minimumcardinaliteit = 1) en op zichzelf niet uniek kan geïdentificeerd worden.

De identificatie gebeurt dan a.d.h.v. enkele attributen + de relatie met een specifieke entiteit.

vb. Een episode kan niet als uniek geïdentificeerd worden a.d.h.v. seizoen en nummer (er bestaan meerdere series), maar wel aan seizoen en nummer in combinatie met de serie.

Zwakke entiteitstypes hebben m.a.w. geen eigen kandidaatsleutelattribuut.

## Historiek

Je kan makkelijk historische gegevens bijhouden door een zwak entiteitstype toe te voegen. Je plaatst het tussen de twee entiteitstypes waarvoor een historiek bijgehouden moet worden. De sleutel bestaat dan uit bijvoorbeeld de datum en de twee relaties.

## Ternaire relaties

In dit vak komen geen ternaire relaties aan bod. We kunnen ze wel als binaire relaties voorstellen door: de drie entiteitstypes te verbinden met een zwak entiteitstype. De sleutel voor het zwak identiteitstype zal dan bestaan uit iets unieks (zoals een tijdstip) + de drie relaties.

# EERD - Extended Entity Relationship Diagram

=> Alle aspecten van ERD blijven behouden + 2 extra concepten: specialisatie en generalisatie

## Specialisatie

Entiteittype is een verzameling van entiteiten met gemeenschappelijke karakteristieken.

- Komt overeen met een IS-EEN relatie (zoals een ervende klasse in Java)

De gespecialiseerde entiteiten noemen we ook **sub(entiteit)types** de parent entiteit is van een **superentiteittype**.

Subtype heeft geen kandidaatsleutelattribuuttype (zit al in het superentiteittype)

<figure>
    <img src="./img/voorbeeld-specialisatie.png">
    <figcaption>Voorbeeld en notatie van specialisatie (hier twee niveaus diep). Het kandidaatsleutelattribuuttype bevindt zich hier in CrewMember.</figcaption>
</figure>

## Generalisatie

Omgekeerde proces van specialisatie. Je maakt een supertype van een aantal gegeven entiteittypes.

## Participatie en Disjoint constraint

Participatieconstraint heeft twee mogelijke waarden:

- Mandatory / Totale participatie: Elke entiteit van het supertype moet tot minstens één subtype behoren (gelijkaardig aan abstract class in Java)
- Optional / Partiële participatie: Entiteiten kunnen ook van dit type zijn zonder tot een subtype te behoren.

Disjointconstraint heeft ook twee mogelijke waarden:

- AND / Overlappend: Entiteit kan meer dan één subtype hebben.
- OR / Disjunct: Entiteit kan maar tot één subtype behoren.

Die constraints plaats je in het EERD tussen {}.

# Beperkingen van het ERD

- Tijdelijke/Situationele beperkingen kunnen niet gemodelleerd worden (vb. project moet binnen een maand toegewezen worden / werknemer mag niet opnieuw werken in departement waar hij ooit manager was)
- Je kan op een ERD geen consistentie tussen verschillende relatietypes garanderen (vb. werknemer moet werken voor departement waarvan hij manager is)
- Op het ERD kan je geen mogelijke waarden vastleggen
- Je kan er geen functies in opnemen

-> Al deze zaken moeten wel gedocumenteerd worden. bn

## Fan trap

<figure>
 <img src="./img/voorbeeld-fantrap.png">
 <figcaption>Door de twee 1..N cardinaliteiten, is het hier niet duidelijk welke werknemers aan welke projecten werken.</figcaption>
</figure>

Oplossing = relaties herschikken (vb. 1 departement werkt aan 1..N projecten -> 1 project wordt uitgevoerd door 1..N werknemers)

## Chasm trap

<figure>
 <img src="./img/voorbeeld-chasmtrap.png">
 <figcaption>Doordat er tussen werknemer en project twee cardinaliteiten staan met een 0 in, kan het zijn dat er geen relatie tussen werknemer en project is, terwijl het wel aan een departement werd toegewezen.</figcaption>
</figure>

Oplossing = extra relatie toevoegen tussen project en departement
