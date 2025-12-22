<h1> Red team </h1>

# Taken

- Proberen inbreken
- Verdediging testen
- Zwakke punten blootleggen

= aanvallende team

Niet beperkt tot cybersecurity, wordt ook gedaan om bijvoorbeeld gebouwen te beveiligen.

# De 5 fasen

- Reconaissance: Informatie verzamelen over het systeem. (brede informatie)
- Scanning and enumeration: Zoeken naar zwakke punten. (gedetailleerde informatie)
- Gaining access: Zwaktes aanvallen.
- Maintaining access: Zorgen dat er later makkelijk opnieuw ingebroken kan worden.
- Covering tracks: Zorgen dat het doelwit geen sporen terugvindt.

In dit vak worden vooral de eerste twee fasen besproken. Voor de andere fasen is veel technische kennis vereist.

## Fase 1 - Reconnaissance

Footprinting = zo veel mogelijk info verzamelen.

Reconnaissance moet zo onopvallend mogelijk gebeuren.

Je wil vooral:

- het doelwit begrijpen
- de aanval accurater maken (= aanvalsdomein - vb. bepaalde IP-range - beperken)

De data wordt meestal in een databank verzameld, zodat daaruit conclusies getrokken kunnen worden.

Twee soorten:

- Passief: Er is geen contact met het doelwit. Anoniem.
- Actief: Er is contact met het doelwit. Doelwit krijgt informatie over de aanvaller, maar weet niet dat dit een toekomstige aanvaller is.

Zoekmachines (meerdere want verschillende resultaten), social media, vacatures (gebruikte technologieën, posities) en openbare databanken (voor adressen, name, financiële data, etc.) worden vaak gebruikt voor passieve reconnaisance.

Om sociale media te scrapen, zijn er speciale tools: Pipl, Maltego, theHarvester, recon-ng, etc.

Eenvoudig e-mailadressen te vinden met hunter.io

Veel info kan van de website van een organisatie gehaald worden zoals contactgegevens, gebruikte technologie, structuur van het bedrijf, foto's. De hele website kan ook gedownload worden om zwaktes te zoeken. <br>
_Een website bezoeken zonder verdacht gedrag te vertonen, wordt gezien als passieve reconnaisance_

Er bestaan nog handige tools:

- [whois.domaintools.com](whois.domaintools.com): geeft informatie over domeinregistratie
- [builtwith](www.builtwith.com): Toont de gebruikte technologie van een opgegeven website.
- [censys](search.censys.io): Zoekmachine voor IP-adres, hostname, etc.
- [Shodan](www.shodan.io): Zoekt publiek toegankelijke devicese - IoT is vaak slecht beveiligd.

Je kan soms ook gevoelige informatie vinden in slechtbeveiligde DNS-servers.

## Fase 2 - Scanning en enumeration

Hier gebeuren verschillende dingen met de informatie uit fase 1.

- Je zoekt zwakke punten (bedrijven doen dit zelf ook om verder te beveiligen)
- Je linkt gebruikte technologieën aan gekende kwetsbaarheden. = belangrijk om publiek toegankelijke software regelmatig up te daten.

### Scanning

Bestaat uit enkele onderdelen:

- Port scanning: open poorten/services detecteren
- Network scanning: Netwerk mappen
- Vulnerability scanning: Zwaktes of kwetsbaarheden onderzoeken

Gebeurt vaak via ping (bereikbaarheid) en tracert (route in het netwerk).

#### Poortscanners

Poortscanners scannen netwerkpoorten. Drie statussen mogelijk:

- OPEN: de poort aanvaardt connecties
- GESLOTEN: connectie geweigerd, geen actief programma -> je krijgt hier dus wel een antwoord terug
- GEFILTERD: geen antwoord teruggekregen (onzeker maar vaak door firewall)

Voorbeelden: nmap, masscan, megaping

Nmap kan ook hosts ontdekken op het netwerk en gokken welk programma (en welke versie) achter een open poort draait.

#### Netwerkscanners

Scant het netwerk voor hosts en verbindingen. Je moet hiervoor wel toegang tot het netwerk hebben.

Voorbeelden: LANState (Pro), PRTG Network Monitor, Solarwinds

#### Vulnerability scanners

Scant het netwerk naar gekende kwetsbaarden. Moet ook toegang hebben tot het netwerk.

Voorbeelden: OpenVAS, Nessus, Metasploit

### Enumeration

= Informatie verzamelen op applicatie-niveau

Je misbruikt netwerkrpotocollen voor informatie over netwerkschijven, loginsystemen en servers.

## Fase 3 t.e.m. 5 - Gaining access, maintaining access, covering tracks

### Gaining access

Toegang verkrijgen gebeurt meestal via onder andere:

- ontfutselen van logingegevens (vb. via social engineering en reconnaissance)
- exploits
- password cracking

### Maintaining access

= persistence

Zonder persistence, moet je opnieuw inbreken als een toestel wordt afgesloten.

Persistence verkrijgen kan onder andere via:

- malware installeren (vb. backdoor maken)
- nieuwe gebruiker aanmaken
- pivoting -> verspringen naar andere toestellen

Vaak nodig om root access te krijgen (=> privilege escalation)

Belangrijk om de persistence zo onzichtbaar mogelijk te houden.

### Covering tracks

= bewijsmateriaal wegmoffelen

Bijvoorbeeld:

- Gebruikte bestanden verwijden / verbergen
- Logs aanpassen (niet verwijderen want valt op)
- Timestamps aanpassen

## Cyber attack cycle

Meestal lopen de vijf fasen niet lineair, maar cyclisch. Interessante informatie in een latere fase kan bijvoorbeeld leiden tot nieuwe reconnaisance.

# Pentests

Passieve reconnaisance is standaard toegelaten -> rest heeft expliciete toestemming van doelwit nodig.

Meestal is de toestemming met een NDA (non-disclosure agreement) en wordt er een scope afgesproken.

Met toestemming = pentest / security audit

Drie vormen van pentests:

- white box: red team kent het volledige systeem
- black box: red team begint zonder informatie van het systeem
- grey box: red team krijgt een beetje informatie over het systeem

## Audit report

Dit rapport wordt geschreven na de pentest en bevat:

- Een conclusie begrijpbaar voor niet-technisch personeel
- Gedetailleerde lijst van vulnerabilities (foutjes in software of configuratie), exploits (manieren om vulnerabilities te misbruiken), threats (gebruik van een exploit door een aanvaller) en risks (maat van ernst van een vulnerability) voor het IT-team.

> Noot voor de verdediging
>
> - Ongekende vulnerabilities, kan je niet in rekening brengen. Focus op gekende vulnerabilities.
> - Niet alle vulnerabilities hebben een exploit.
> - Verdedig niet tegen exploits voor vulnerabilities die je niet hebt.
