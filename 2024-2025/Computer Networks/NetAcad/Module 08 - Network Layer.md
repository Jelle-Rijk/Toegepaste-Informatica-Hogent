# Network Layer

- [Network layer characteristics](#network-layer-characteristics)
- [IPv4 Packet](#ipv4-packet)
- [IPv6 Packet](#ipv6-packet)
- [Hoe hosts routen](#hoe-hosts-routen)
- [Inleiding tot routing](#inleiding-tot-routing)

## Network layer characteristics

Belangrijkste protocollen:
- IPv4
- IPv6
- OSPF = Open Shortest Path First
- ICMP = Internet Control Message Protocol (pingen)

Vier handelingen van network layer:
- End-devices IP-adressen geven
- Inkapseling: Data van de transport layer inkapselen met een IP-header. Deze blijft onveranderd tot het packet bij de destination host is (uitzondering: NAT bij IPv4)
- Routing: Zorgen dat de packets naar een destination host op een ander netwerk geraken.
- De-encapsulation: Als het packet bij de destination host arriveert, wordt de layer 3 data weggehaald en wordt de rest (segment / datagram) doorgegeven aan layer 4.

### Kenmerken IP
- Connectionless: Er is geen verbinding met de destination host voordat het packet verzonden wordt.
- Best effort: Packet delivery is niet gegarandeerd. Controle op delivery wordt door andere protocollen gedaan (vb. TCP).
- Media independent: Medium (koper, glasvezel, draadloos) maakt niet uit.

IP krijgt van de data link layer de MTU (maximum transmission unit door), data wordt door de network layer opgesplitst (**fragmentation**). Fragmentatie door de router is niet mogelijk bij IPv6.

## IPv4 Packet
Belangrijkste fields:
- Version: 0100 (= geeft aan dat het IPv4 is)
- Differentiated Services (DS): Geeft prioriteit aan
- Time to Live (TTL): Aftellende teller, elke keer het packet een router passeert, gaat 1 van de TTL af. Op 0 wordt het packet gedropt. Elke keer dit gebeurt, moet de header checksum opnieuw berekend worden.
- Protocol: Welk protocol op layer 4 gebruikt wordt (vb. ICMP, TCP UDP)
- Header Checksum: Error detectie voor de IP-header
- Source IPv4 address
- Destination IPv4 adress

Andere fields worden gebruikt om het packet te valideren en om gefragmenteerde packets terug in de juiste volgorde te plaatsen.

IPv4 adressen zijn altijd **32 bits**.

Grootste beperkingen:
- IPv4-adressen zijn gelimiteerd -> behoefte aan meer adressen
- Geen end-to-end connectivity: Private IPs zijn verborgen via NAT.
- Toegevoegde complexiteit: NAT heeft de levensduur van IPv4 verlengd, maar voegt veel complexiteit aan netwerken toe.

## IPv6 Packet
Voordelen:
- Meer adressen (want 128 bits i.p.v. 32)
- Betere packet handling (want er zijn minder fields)
- NAT is niet nodig.

Belangrijkste fields:
- Version: 0110 (= 6, zelfde functie als bij IPv4)
- Traffic Class: Zelfde als Differentiated Services bij IPv4
- Flow label: Soort handling die nodig is
- Payload Length: Lengte van de ingekapselde data (dus zonder IPv6 header)
- Next header: Zelfde als Protocol bij IPv4
- Hop Limit: Zelfde als TTL bij IPv4. IPv6 heeft geen header checksum dus moet niet elke keer herberekend worden als hop limit verandert.
- Source IPv6 Address
- Destination IPv6 Address

Een IPv6 packet kan ook extension headers (EH) hebben. Die bevatten optionele informatie (vb. voor fragmentatie, beveiliging, etc.)

## Hoe hosts routen
Hosts maken hun eigen routing table om packets naar de destination te gidsen.

Hosts kunnen een packet zenden naar:
- zichzelf: met IP-adres 127.0.0.1 (IPv4) of ::1 (IPv6) = loopback interface
- local host: een destination host op hetzelfde netwerk
- remote host: een destination host op een ander netwerk

De source host bepaalt of de destination host op hetzelfde netwerk zit of niet.
- IPv4: Source host gebruikt eigen IP-adres en subnet mask om dit te bepalen.
- IPv6: Lokale router geeft een lokaal netwerk adres (prefix) aan alle apparaten op het lokale netwerk

### Default gateway
Dit is de router of layer 3 switch die het dataverkeer naar andere netwerken kan sturen.

Het heeft
- een lokaal IP-adres
- de mogelijkheid om data te ontvangen voor het lokale netwerk en data uit te sturen
- de mogelijkheid om verkeer naar andere netwerken te routen.

De host krijgt de default gateway van DHCP (IPv4) of van de router (IPv6). Je kan dit ook manueel instellen. De host stuurt verkeer voor andere netwerken naar de default gateway.

### Host routing tables
De host houdt routing tables bij. Je kan die op windows zien met `route print` of `netstat -r`.

De output bestaat uit drie onderdelen:
- Interface list: MAC-adressen van alle NICs op de host.
- IPv4 Route Table: Alle bekende IPv4 routes
- IPv6 Route Table: Alle bekende IPv6 routes

## Inleiding tot routing

Als een host een packet verzendt, raadpleegt hij eerst zijn eigen routing table. Als het packet voor een ander netwerk bestemd is, wordt het eerst naar de router gestuurd.

De router ontvangt het packet en gaat in zijn eigen routing table op zoek naar de best matchende route voor het packet.

### IP Router Routing Table
Drie soorten entries:
- Directly-connected networks
- Remote networks
- Default route: Deze route wordt gebruikt als de router geen match vindt (vergelijkbaar met default gateway in local network)

De router krijgt deze info ofwel door manuele invoer (static routing) of dynamisch via een dynamic routing protocol.

Static routing:
- Moet manueel geconfigureerd worden
- Verandert niet automatisch
- Vooral voor kleine netwerken

Dynamic routing:
- Reageert automatisch op network changes
- Gebruikt een dynamic routing protocol (vb. OSPF of EIGRP = Enhanced Interior Gateway Routing Protocol) om netwerkinformatie te delen met andere routers. Het doet vier zaken automatisch:
    - Remote networks ontdekken
    - Routing information bijhouden en bijwerken
    - Beste pad naar destination network bepalen
    - Nieuw beste pad vinden als het huidige pad niet meer beschikbaar is.

    #### In Cisco IOS
    `show ip route` (privileged EXEC mode) toont de geleerde routes, met de manier waarop de router deze route leerde kennen.

    - L: Directly Connected local interface IP-address (Poort waarmee het directly connected netwerk verbonden is)
    - C: Directly Connected Network
    - S: Static route
    - O: OSPF
    - D: EIGRP