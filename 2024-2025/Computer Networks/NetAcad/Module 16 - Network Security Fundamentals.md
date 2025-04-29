# Network Security Fundamentals

- [Network Security Fundamentals](#network-security-fundamentals)
  - [Security Threats and Vulnerabilities](#security-threats-and-vulnerabilities)
  - [Network Attacks](#network-attacks)
    - [Reconnaisance Attack](#reconnaisance-attack)
    - [Access Attacks](#access-attacks)
    - [Denial of Service Attacks](#denial-of-service-attacks)
  - [Network Attack Mitigations](#network-attack-mitigations)
    - [Firewalls](#firewalls)
  - [Device Security](#device-security)
    - [SSH](#ssh)

## Security Threats and Vulnerabilities

Vier types bedreigingen:

- Information theft
- Data loss en manipulatie
- Identity theft
- Disruption of Service

Drie soorten vulnerabilities:

- Technologisch: TCP/IP-protocollen (HTTP, FTP, ICMP, SNMP en SMTP) zijn inherent onveilig. Operating Systems kunnen bepaalde problemen hebben. Apparaten (switches, routers, firewalls, etc.) kunnen bepaalde security weaknesses hebben.
- Configuratie: Accounts die niet beveiligd zijn, zwakke wachtwoorden, verkeerde instellingen die beveiligingsrisico's bevatten
- Policy: Geen geschreven regels, regels worden niet toegepast, instellingen veranderen vereist geen privileges, geen disaster recovery plan.

Fysiek moet je ervoor zorgen dat de hardware veilig staat en dat het klimaat in orde is (temperatuur + vochtigheid). Je moet rekening houden met elektrische bedreigingen (spikes, brownouts, outages, etc.) en slecht onderhoud.

## Network Attacks

Attacks kunnen gebeuren via malware:

- Virus: Programma dat zichzelf kopieert of slechte gevolgen heeft voor het device. Heeft een ander programma / andere file nodig om door het netwerk te bewegen.
- Worm: Gelijkaardig aan virus, maar kan zichzelf verspreiden.
- Trojan Horse: Malware die zich voordoet als een echte applicatie en zo mensen in de val lokt.

Er zijn ook drie verschillende attacks op het netwerk zelf:

### Reconnaisance Attack

Threat actor probeert het netwerk te mappen (vaak om zwakke punten te vinden)

Dit kan via internet queries om initiële informatie te vinden. <br>
Via een ping sweep kan de actor de actieve devices identificeren. <br>
De actor kan dan een port scan doen op de actieve devices.

### Access Attacks

De actor maakt gebruik van zwakke punten om toegang te krijgen tot netwerken. Vier grote types:

- Password Attack: Actor kraakt een password
- Trust exploitation: De actor neemt een vertrouwd systeem over dat minder goed beveiligd is, om zo toegang te krijgen tot het beveiligde systeem.
- Port Redirection: Poorten op een overgenomen (vertrouwd) systeem, worden verbonden met poorten die de informatie bij de threat actor brengen.
- Man-In-The-Middle: De threat actor bevindt zich tussen twee legitieme, vertrouwde systemen en kan de data lezen / aanpassen die passeert.

### Denial of Service Attacks

DoS attacks proberen zo veel systeem resources te gebruiken dat de service geen echt werk meer kan leveren.

Bij DDoS komt de attack van meerder sources die samenwerken. De actor kan dan infected hosts (= zombies) gebruiken. Een netwerk van zombies is een botnet. De actor gebruikt dan een programma (Command and Control - CnC) om het botnet te besturen.

## Network Attack Mitigations

Er zijn een aantal zaken die je kan doen om attacks te beperken / verzachten.

**Defense-in-depth approach (= layered approach)**: De beveiliging bestaat uit verschillende lagen. Waardoor attacks moeilijker worden.

**Back-ups** maken is belangrijk om data loss tegen te gaan. Best om deze off-site te bewaten.

**Update, upgrade en patch software** regelmatig. In updates worden bepaalde vulnerabilities opgelost.

**Authentication, Authorization, Accounting (AAA)** -> beheer wie er op het netwerk kan, wat ze kunnen doen en hou bij wat ze gedaan hebben.

**Train** personeel om verantwoordelijk om te gaan met de end user devices.

### Firewalls

Gebruik **firewalls** om ongewenst verkeer te blokkeren. Als een device toegang moet hebben tot het internet, moet je gebruik maken van een DMZ.

Er zijn verschillende soorten firewalls:

- Packet Filtering - filteren op IP of MAC-adres
- Application Filtering: Laten enkel verkeer door op basis van port numbers.
- URL Filtering: Blokkeert verkeer naar / van bepaalde websites
- Stateful Packet Inspection (SPI): Packets die binnenkomen moeten echte responses zijn op requests van binnen het netwerk. Kan DoS filteren.

## Device Security

Als je een nieuw apparaat configureert zijn er enkele zaken die je moet doen:

- Pas standaard usernames en passwords aan.
- Limiteer toegang tot resources
- Services en apps die niet essentieel zijn uitschakelen of uninstallen.
- Update software.

Gebruik sterke paswoorden:

- Minimaal 8 karakters (liefst meer)
- Complex (uppercase, lowercase, cijfers, symbolen, etc.)
- Geen makkelijk te raden info
- Bewust spelfouten gebruiken
- Verander regelmatig
- Niet neerschrijven (vb. op bureau)

Op Cisco routers en switches:

| Taak                                             | Commando                                                       |
| ------------------------------------------------ | -------------------------------------------------------------- |
| Encrypt                                          | service password-encryption                                    |
| Minimumlengte instellen                          | security passwords min-length _lengte_                         |
| Block login na failed attempts                   | login block-for _seconden_ attempts _kansen_ within _seconden_ |
| Automatische logout instellen voor EXEC modes    | exec-timeout _minuten seconden_                                |
| Toon alle draaiende services                     | show ip ports all                                              |
| Toon alle draaiende services (op oude apparaten) | show control-plane host open-ports                             |
| Disable http                                     | no ip http server (in global config)                           |
| Disable telnet                                   | transport input ssh (in line config)                           |

### SSH

Telnet is niet veilig omdat het unencrypted is.

Om dit te doen op Cisco routers / switches:

1. Unieke hostname instellen (niet de default)
2. IP domain name configureren met `ip domain name [name]`
3. Key genereren met `crypto key generate rsa general-keys modulus [grootte in bits van 360-2480]` (minimum aangeraden moduluslengte = 1024 - hoger is trager, maar veiliger)
4. Maak een username aan binnen de lokale database met `username [name] (secret [paswoord])` (in global config)
5. Authenticaten aan de hand van lokale database met `login local` (config line)
6. Enable ssh via vty lijnen `transport input ssh` (config line)
