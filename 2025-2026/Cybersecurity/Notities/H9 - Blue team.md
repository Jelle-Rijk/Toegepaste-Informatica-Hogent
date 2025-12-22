<h1> Blue team </h1>

- [Diepe verdediding](#diepe-verdediding)
- [Systemen en apparaten beschermen](#systemen-en-apparaten-beschermen)
  - [Fysieke toegang](#fysieke-toegang)
  - [Gebruikersbeheer](#gebruikersbeheer)
    - [Authenticatie](#authenticatie)
    - [Autorisatie](#autorisatie)
  - [Host hardening](#host-hardening)
    - [Draadloos / Mobiel](#draadloos--mobiel)
    - [Hostdata beschermen](#hostdata-beschermen)
  - [Server hardening](#server-hardening)
    - [Administratieve maatregelen](#administratieve-maatregelen)
  - [Network hardening](#network-hardening)
- [Assets management](#assets-management)
- [Nood aan experten](#nood-aan-experten)

# Diepe verdediding

Een goede verdediging houdt rekening met de volgende zaken

| Engels     | Nederlands    | Uitleg                                                                                                                                                 |
| ---------- | ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Layering   | Gelaagdheid   | Je zet meerdere barrières op. Door eentje binnenbreken, betekent dat de aanvallers door nog een laag moeten.                                           |
| Limiting   | Beperking     | Toegang tot informatie moet beperkt worden tot wat iemand nodig heeft om zijn job uit te voeren.                                                       |
| Diversity  | Diversiteit   | Wissel af met soorten beveiliging, zo zorgt het inbreken in één laag er niet voor dat de andere laag zwakker wordt. (vb. afwisselen encryptiemethoden) |
| Obscurity  | Verduistering | Steek onnodige info (vb. type OS dat je gebruikt, firewall, etc.) weg                                                                                  |
| Simplicity | Eenvoud       | Als de beveiliging te complex wordt, wordt de kans op fouten groter.                                                                                   |

Streef altijd naar een gevarieerde combinatie van bovenstaande.

# Systemen en apparaten beschermen

## Fysieke toegang

Tegen diefstal, rogue devices en vandalisme.

- Sluit toegang af, dwing identificatie af en beveilig toestellen (sloten en logout timers)
- Diefstal: Hou logboeken bij + GPS tracking
- Monitor hardware tegen vandalisme

## Gebruikersbeheer

Gebruikers zijn onvoorspelbaar (maken fouten, sommige hebben slechte bedoelingen) -> limiteer rechten van gebruikers = **Principle of least privilege**

Gebruik het AAA-framework:

- Authentication: Wie mag iets doen?
- Authorisation: Wat mag iemand wel/niet doen?
- Accounting: Wie heeft wat gedaan? (vaak via logfiles)

### Authenticatie

Multi-Factor Authentication is authenticatie met een combinatie van minstens twee van de volgende:

- **Knowing** - wachtwoorden, pincodes, etc.
- **Having** - Smartcards, telefoon, toegang tot e-mailaccount, etc.
- **Are** - Vingerafdruk, netvlies, stem

### Autorisatie

Rechten kunnen toegekend worden op basis van:

- niveaus
- rechten toegekend door de eigenaar (vb. Linux-bestanden)
- functie: vb. leerkrachten en secretariaatsmedewerkers zien andere info.

## Host hardening

= Devices beveiligen

Beveilig de OS door:

- Standaardconfigs aan te passen
- Onnodige software te verwijderen
- Security updates en patches te installeren -> kan centraal beheerd worden (automatisch updaten en eventueel verplichten)

Je kan de configuratiebestanden en het OS ook nog beschermen door een Disk clone (kopie van volledige harde schijf - ISO) of Deep Freeze (= bevroren partitie van een harde schijf die terug op een bepaalde configuratie wordt gezet bij een reboot) te maken.

Installeer anti-malware (ook op mobiele apparaten). <br>
_Let op met gratis antivirussen etc, ze bevatten vaak zelf malware._

Je kan een host-gebaseerde firewaal opzetten om inkomend en uitgaan verkeer te regelen.

Een Host Intrustion Detection System controleert verdachte activiteit op een toestel.

Content control software kan toegang tot bepaalde (schadelijke) inhouden via webbrowsers blokkeren.

**Kiosk mode** -> Software die verhindert dat gebruikers een bepaalde situatie kunnen verlaten en zo het systeem kunnen aanpassen (vb. Safe Exam Browser / bestelkiosk McDonald's)

Je kan er ook voor kiezen om sommige programma's te **sandboxen** -> ze draaien dan in een virtuele omgeving. Een hacker krijgt zo geen toegang tot het volledige systeem, enkel de virtual environment. (Niet foolproof, je kan er soms uitbreken.)

### Draadloos / Mobiel

- WEP (Wired Equivalent Privacy): basisbescherming wi-fi, is niet meer veilig
- WPA/WPA2 (Wi-Fi Protected Access): Gebaseerd op AES -> WPA2 is huidige standaard

Wederzijdse authenticatie kan MitM-attacks (vb. via rogue access point) voorkomen.

### Hostdata beschermen

Bestandstoegangscontrole -> instellen per gebruiker, machtigingen op bestanden en mappen beperken.

File encryption -> Gevoelige data op het apparaat encrypten (individuele bestanden of volledige schijf)

Back-ups maken van systeem en gegevens.

## Server hardening

Zorg dat toegang op afstand beveiligd is. Gebruik SSH i.p.v. Telnet (= verouderd en gebruikt plaintext)

Bestanden overzetten kan veilig via:

- SCP (Secure Copy Protocol)
- SFTP (SSH File Transfer Protocol)

Beide gebruiken SSH 'under the hood'

VPN's kunnen opgezet worden om vanop een publiek netwerk veilig met een privaat netwerk te verbinden.

### Administratieve maatregelen

Verwijder onnodige services -> onnodige open poorten kunnen een risico zijn.

Beveilig geprivilegieerde account (root, admin, superuser), deze hebben doorgaans bijna onbeperkte toegang.

Group policies -> stelt veiligheidsmaatregelen voor een groep gebruikers in (vb. password policy, toegang, etc.)

Hou logboeken bij met alle gebeurtenissen op het systeem. (vb. Windows Event Viewer)

## Network hardening

**Network Operations Centers (NOC)** -> locatie(s) waarop je toegang hebt tot de gedetailleerde status van netwerk. Focus ligt op availability en netwerkperformance

Netwerkapparaten (switches, routers, ...) zijn kwetsbaar voor diefstal, hacking en remote access. Zijn ook het doelwit voor DDoS.

Enkele beveiligingssystemen voor het netwerk:

- Firewall (hard- of software): Blokkeert ongeautoriseerd / gevaarlijk verkeer. Zorgt ervoor dat enkel de noodzakelijke poorten bereikbaar zijn.
- Intrusion Detection System (IDS): Detecteert inbraak. Moet het verkeer zien passeren om dit te doen.
- Intrusion Prevention System (IPS): Detecteert inbraak en verdacht verkeer en kan het blokkeren.

Een combinatie van Firewall + een IPS op de poorten die wel doorgelaten worden, is sterk.

**Security Operations Centers (SOC)** -> lijkt sterk op NOC, maar is meer gefocust op het beveiligen dan op de functionaliteit.

Een SIEM (Security Information and Event Management) systeem wordt gebruikt in SOCs om:

- Gegevens te filteren en verzamelen
- Bedreigingen te detecteren / classificeren
- Bedreigingen te onderzoeken / analyseren
- Preventieve maatregel uit te voeren
- Toekomstige bedreigingen aan te pakken

# Assets management

=> Belangrijk om te weten wat je moet beveiligen / Beveiligingsgevaren inschatten.

Omvat minstens:

- Beheren van assets
- Inventaris bijhouden van de assets (hardware, software, OS's, network devices, applicaties, firmware, language runtime environments, etc.)

Is een voordeel voor het updatebeleid -> Je weet welke hard- of software (binnenkort) verouderd is.

Ook handig voor de helpdesk -> Weet alle specs van toestel met probleem

# Nood aan experten

Cybersecurity expert worden via:

- levenslang leren
- certificaten behalen -> standaarden die je vaardigheden en kennis bewijzen.
- stages
- conferenties, etc.

Enorm belangrijk om op de hoogte te blijven van laatste threats/defenses.
