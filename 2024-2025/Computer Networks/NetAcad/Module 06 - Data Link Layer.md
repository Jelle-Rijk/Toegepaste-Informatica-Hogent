# Data Link Layer
- [Doel van de Data Link Layer](#data-link-layer)
- [Topologieën](#topologieën)
- [Data Link Frame](#data-link-frame)

## Doel van de Data Link Layer

- Geeft toegang voor de upper layers aan het fysieke medium.
- Beheert de manier waarop data op het fysieke medium wordt geplaatst.
- Voert foutdetectie uit.

### IEEE 802 LAN/MAN Data Link Sublayers

Deze standaard is specifiek voor Ethernet LAN, WLAN, WPAN (Wireless Personal Area Networks). Het schrijft twee sublagen voor:
- Logical Link Control (LLC): Communiceert tussen de hogere softwarelagen en de lagere hardwarelaag. Het voegt de Layer 2 data toe aan het packet.
- Media Access Control (MAC): Implementeert deze laag in de hardware. Het bestuurt de NIC.

In de MAC sublaag wordt de data ook verder ingekapseld met:
- Frame delimiters: Bepaalde tekens geven het begin en einde van een veld in het frame aan.
- Addressing: Source en destination address voor devices op hetzelfde medium.
- Error detection: Voegt data toe voor foutdetectie aan het einde van de frame.

Deze video legt de layer goed uit: <br>
[![https://www.youtube.com/watch?v=BOkH_B_8rcs](https://img.youtube.com/vi/BOkH_B_8rcs/0.jpg)](https://www.youtube.com/watch?v=BOkH_B_8rcs)

### Toegang verschaffen tot media

De MAC sublayer voorkomt "botsingen" op het netwerk. Dit is niet nodig bij serial links.

Een packet kan hops maken wanneer het een pad binnen een lokaal netwerk volgt. Bij elke hop doet de MAC het volgende:
- Aanvaardt het frame
- Ontkapselt het frame
- Kapselt het frame opnieuw in
- Stuurt het nieuwe frame opnieuw door

## Topologieën

Twee soorten:
- Fysieke: Geeft aan welke apparaten fysiek met elkaar verbonden zijn en vaak ook waar ze staan.
- Logische: Virtuele connecties, dit is wat de data link layer "ziet". Toont vaak de IP-adressen van devices.

### WAN-topologieën

- Point-to-Point: Permanente link tussen twee endpoints.
- Hub and Spoke: Alle nodes zijn verbonden met een centrale node. Data tussen eindpunten moet altijd door de centrale node.
- Mesh: Elke node is verbonden met elke andere node.

-> Combinatie van topologieën = hybrid topology

In een point-to-point topologie moet in de WAN niet gecheckt worden waar de data heen moet. De data wordt direct naar de volgende node gestuurd. In een LAN moet het end device checken of de data voor dat device is, zo niet moet de data naar de volgende node gestuurd worden.

### Lan-topologieën

- Star: De end devices verbinden met een centraal intermediary device (vb. Ethernet Switch)
- Extended star: Zelfde als star, maar meerdere centrale devices worden met elkaar verbonden.

Voordeel: Heel scalable en makkelijk te installeren.

*Bus- en ring-topologieën zijn verouderd.*

### Duplex Communication

- Half-duplex communicatie: Eén device op het netwerk kan ontvangen of verzenden.
- Full-duplex communicatie: Meerdere devices kunnen tegelijkertijd op het netwerk ontvangen en verzenden.

-> Belangrijk dat NIC's in dezelfde duplex mode werken.

### Access control methods

Multiaccess network = netwerk waarin twee of meer end devices tegelijkertijd toegang kunnen vragen tot het netwerk.

Regels nodig:
- Contention-based acccess: Alle nodes zijn half-duplex. Als meerdere devices tegelijk iets versturen, treden regels in werking.
- Controlled access: Elk apparaat krijgt een bepaald time slot om iets op het netwerk te zetten (was zo bij ring-topologieën). Het moet zijn beurt afwachten (= inefficiënt)

**Moderne Ethernet-netwerken werken full-duplex waardoor er geen access method nodig is.**

### Contention-based access



CSMA (= Carrier Sense Multiple Access): Een end device checkt of het iets ontvangt, als het niets ontvangt, gaat het ervan uit dat het netwerk vrij is. Als devices dat tegelijk doen, kunnen collisions ontstaan.

CSMA/CD = CSMA with Collision Detection -> vooral voor oude bus-topologie

Als er een collision gebeurt, detecteren beide apparaten dit, daarna versturen ze de data opnieuw.

CSMA/CA = CSMA with Collision Avoidance -> WLANs

Het draadloze device wacht eerst tot het niets ontvangt (=CSMA). Het stuurt dan uit hoe lang het over de transmissie zal doen. De andere apparaten vangen dit op waardoor ze weten hoe lang het medium in gebruik is.

In een WLAN stuurt de ontvanger altijd een acknowledgment naar de zender om te laten weten dat hij het frame ontvangen heeft.




## Data Link Frame

Elke frame bestaat uit drie delen:
- Header: Frame start, addressering (source en destination op het medium - MAC), type (welk layer 3 protocol de data is), control (vb. Quality of Service)
- Data: Bevat de data van de hogere lagen.
- Trailer: Foutdetectie en frame stop

Niet alle protocollen voegen alle velden toe, maar elk protocol kapselt wel het packet van de hogere lagen in.

**Foutdetectie**: De verzendende node berekent een CRC (cyclic redundancy check - zie ITFUN) en plaatst de waarde daarvan in het frame check sequence field (FCS).

### Layer 2 addressen

-> Zijn de fysieke addressen, uniek voor elk device.

Worden enkel gebruikt voor lokale aflevering van het packet. Bij elke hop neemt de node het frame, decodeert het, vervangt het source adres door het eigen layer 2 adres en het destination adres door het adres van de volgende node.

Als het frame naar een nieuw netwerk gaat, accepteert de router de frame, ontkapselt het de data en leest het de layer 3 adressen om te weten waar het packet naartoe moet. Als de router een pad gevonden heeft, maakt het opnieuw een frame en stuurt het door naar de volgende router.

### LAN- en WAN-frames

LANs gebruiken Ethernet, WLAN gebruikt IEEE 802.11.

WAN gebruikt traditioneel andere protocollen (vb. Point-to-Point Protocol - PPP of High-Level Data Link Control - HDLC). Deze worden nu ook vervangen door Ethernet.

In TCP/IP hangen de layer 2 protocollen af van de logische topologie en het fysieke medium dat gebruikt wordt.