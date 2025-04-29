# Application Layer

## Application, Presentation and Session

De applicatie-, presentatie- en sessielagen uit het OSI-model komen overeen met de Applicatielaag in het TCP/IP-model. Hieronder gaan we uit van het OSI-model.

### Applicatielaag

Laag die het dichtst bij de eindgebruiker staat.

Protocollen op deze laag:

| Naam                                    | TCP / UDP  | Poort                    | Gebruik                                                              |
| --------------------------------------- | ---------- | ------------------------ | -------------------------------------------------------------------- |
| DNS                                     | TCP of UDP | 53                       | Domeinnamen naar IPs vertalen                                        |
| BOOTP (Bootstrap Protocol)              | UDP        | 68 (client), 67 (server) | Workstation zijn eigen IP laten ontdekken (vervangen door DHCP)      |
| DHCP                                    | UDP        | 68 (client), 67 (server) | Dynamisch toewijzen van IP adressen                                  |
| SMTP (Simple Mail Transfer Protocol)    | TCP        | 25                       | Mails van clients naar servers en tussen servers onderling verzenden |
| POP3 (Post Office Protocol)             | TCP        | 110                      | Mails in een e-mail client downloaden van een e-mail server          |
| IMAP (Internet Message Access Protocol) | TCP        | 143                      | Mails bekijken op een e-mail server                                  |
| FTP                                     | TCP        | 20 en 21                 | Files verzenden over een netwerk                                     |
| TFTP (Trivial File Transfer Protocol)   | UDP        | 69                       | Zelfde als FTP, minder overhead maar minder reliable                 |
| HTTP                                    | TCP        | 80 en 8080               | Webpagina's / video / tekst / afbeeldingen over het web              |
| HHTPS                                   | TCP of UDP | 443                      | Zelfde als HTTP maar met encryptie                                   |

### Presentatielaag

Drie functies:

- Data bij de source formatteren zodat de data bruikbaar is bij de destination.
- Data compressen en decompressen
- Data encrypten en decrypten

Hier worden ook standaard file formats gezet (vb. .jpeg, .gif, .mov, .png, .mp3)

### Sessielaag

Deze laag is verantwoordelijk voor het creëren en onderhouden van sessies.

## Peer-to-Peer

Bij een client/server-model downloadt een client data van een server (of uploadt de client naar de server). -> Dit proces wordt gezien als deel van de applicatielaag.

In peer-to-peer (P2P) zijn er geen dedicated servers. Devices kunnen tegelijkertijd client en server zijn. P2P-applicaties moetn altijd een user interface en een background service hebben.

Gnutella-protocol: Gebruikers kunnen volledige files met anderen delen.

## Web and E-mail Protocols

### Web

URL = Uniform Resource Locator <br>
URI = Uniform Resource Identiefier

Werking van HTTP:

1. Browser neemt de URL (protocol, servernaam en filename)
2. Browser gebruikt een DNS-server om de servernaam naar een IP-adres te vertalen en stuurt die server een GET-request voor de filename
3. Webserver stuurt de HTML-code terug
4. Browser ontcijferd de HTML-code en formatteert de webpagina

HTTP en HTTPS gebruiker drie message types:

- GET: De client doet een verzoek om data
- POST: De client wil data uploaden
- PUT: De client wil resources (vb. afbeelding, muziek) uploaden

HTTP verzendt de verzoeken in plaintext (onveilig) -> HTTPS encrypteert de verzoeken met TLS (Transport Layer Security) of SSL (Secure Socket Layer)

### E-mail

Voor e-mail worden drie protocollen gebruikt.

- Simple Mail Transfer Protocol (SMTP): E-mails verzenden
- Post Office Protocol (POP) en IMAP: E-mails ophalen

SMTP -> Client verbindt met Server op poort 25. De server ontvangt het bericht en plaatst het in een lokaal mailaccount of stuurt het naar de andere server door. Als de volgende server niet bereikbaar is, houdt de server de e-mail even bij (daarna wordt het teruggestuurd naar de zender als undeliverable als de server niet op tijd terug reageert)

POP -> Service luistert passief op server poort 110. POP client downloadt message, die wordt dan van de server gedeletet. <br>
IMAP -> E-mail wordt gekopieerd van server naar client, maar blijft op de server bestaan.

## IP Addressing Services

### DNS

Namen van websites -> FQDN (Fully-Qualified Domain Name)

Werking DNS:

1. Gebruiker geeft een FQDN in.
2. Client stuurt een DNS query naar de DNS server.
3. De DNS matcht de FQDN met een IP-adres.
4. DNS-server stuurt het IP-adres naar de client.
5. De client gebruikt het IP-adres om met de server te verbinden.

Als de DNS-server geen match vindt, vraagt de DNS-server aan andere DNS-servers of zij het wel weten.

De entries in de DNS-server bevatten de naam, het adres en het type van de entry. De types zijn:

- A - End Device (IPv4)
- NS - Name server
- AAAA - End Device (IPv6)
- MX - Mail exchange

DNS messages zijn als volgt opgebouwd: Question - Anser - Authority - Additional (vb. foutcodes)

DNS gebruikt een hiërarchie. Als de DNS-server een request krijgt voor een entry buiten zijn zone, stuurt die het naar de volgende zone door. Als het wel voor zijn zone bestemd is, stuurt de DNS-server het request door naar het deelgebied. De domeinen komen terug in de link.

vb. chat.openai.com -> .com is het Top-Level Domain (TLD), openai is het Second Level Domain, chat is een subdomein van openai.

Je kan DNS testen door manueel queries te sturen (via het commando `nslookup`). `nslookup` zonder parameters toont de DNS die geconfigureerd is voor het device.

### DHCP

DHCP (= Dynamic Host Configuration Protocol) wijst automatisch IPv4-adressen, subnet masks en gateways toe. Handig als de gebruikers vaak veranderen. DHCP leaset adressen aan gebruikers.

Meestal gebruik je DHCP voor general-purpose hosts en statische addressering voor netwerk devices, routers, switches, servers, printers, etc.

_DHCPv6 wijst geen default gateway toe! (Gebeurt via Router Advertisement van de router)_

Als een apparaat online komt:

1. Client stuurt een DHCPDISCOVER via broadcast.
2. Server stuurt een DHCPOFFER (met IPv4-adres, subnetmask, IPv4 van DNS, IPv4 van default gateway en duur van de lease)
3. Client stuurt een DHCPREQUEST naar één van de servers waarvan het een offer kreeg, waarmee het bevestigt dat het die lease neemt.
4. Server stuurt een DHCPACK om de client te informeren dat de lease in orde is. Als de lease verlopen was / niet meer vrij was, stuurt de server een DHCPNACK en gaat de client terug naar stap 1.

Voordat de lease verloopt, moet de client die vernieuwen met een DHCPREQUEST

## File Sharing Services

### File Transfer Protocol

1. Client opent verbinding met server (TCP port 21). Via deze verbinding lopen de client commands en server replies.
2. Client opent een tweede verbinding voor data transfer (TCP port 20).
3. Data downloaden of uploaden.

### Server Message Block

SMB messages hebben drie functies:

- Sessies starten, stoppen en authenticaten
- File- en printertoegang regeln
- Applicaties toestaan om berichten te verzenden naar / ontvangen van andere devices.

Verschil met FTP is dat de connectie long-term is.
