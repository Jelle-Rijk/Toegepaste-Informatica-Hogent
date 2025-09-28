# Ethernet Switching

- [Ethernet Switching](#ethernet-switching)
  - [Ethernet Frames](#ethernet-frames)
    - [Ethernet in de data link sublagen:](#ethernet-in-de-data-link-sublagen)
  - [Ethernet MAC-addressen](#ethernet-mac-addressen)
    - [Frame processing](#frame-processing)
      - [Unicast](#unicast)
      - [Broadcast](#broadcast)
      - [Multicast](#multicast)
  - [MAC Address Table](#mac-address-table)
    - [Switch learning en forwarding](#switch-learning-en-forwarding)
  - [Switch Speeds en Forwarding Methodes](#switch-speeds-en-forwarding-methodes)
    - [Bandbreedte en duplex](#bandbreedte-en-duplex)
    - [Auto-MDIX](#auto-mdix)
  - [EXTRA INFORMATIE](#extra-informatie)

## Ethernet Frames

Ethernet is deel van de fysieke en data link layers.

<strong>Minimumlengte: 64 bytes <br>Verwachte maximumlengte: 1518 bytes <br></strong>
Als een frame langer / korter is, gooit de ontvanger deze weg.

_Preamble is geen deel van die frame length_

Frames die minder dan 64 bytes bevatten worden gezien als **collision fragments**. Het data field gebruikt dus padding om elke frame minimaal 64 bytes lang te maken.

Aan de start van het frame is er een Preamble field van 7 bytes en een Start Frame Delimitier (SFD) van 1 byte. -> Dit verwittigt de ontvangende node dat er een frame aankomt.

![Ethernet Frame Fields](./img/07/Ethernet%20Frame%20Fiels.png)

Er zijn enkele waarden die vaak voorkomen in het veld type (soms ook lengte / EtherType). De drie meest voorkomende zijn(hexadecimale notaties):

- 0x800 -> IPv4
- 0x86DD -> IPv6
- 0x806 -> ARP

### Ethernet in de data link sublagen:

- LLC: Plaatst informatie in de frame over welk protocol gebruikt wordt voor de network layer (vb. IPv4 of IPv6)
- MAC:
  - Geïmplementeerd in hardware
  - Data-inkapseling met:
    - Ethernet frame: Interne structuur van de frame
    - Ethernet addressing: source en destination MAC-address voor beide NICs
    - Ethernet Error Detection: Frame Check Sequence (FCS) voor foutdetectie
  - Media Access Control:
    - CSMA/CD in oudere Ethernet-setups (half-duplex)
    - CSMA/CA in WLANs

## Ethernet MAC-addressen

12 hexadecimalen -> 48 bits = 6 bytes

Alle Ethernet devices / interfaces moeten een uniek MAC-address hebben.

Eerste 6 hexadecimalen zijn uniek per vendor = Organizationally Unique Identifier (OUI) -> _toegewezen door IEEE_

### Frame processing

-> MAC ook wel bekend als BIA (= burned-in address) <br> Hard-coded in read-only memory (ROM)

Bij boot kopieert de computer het MAC-address van de ROM in de NIC naar de RAM.

Als de NIC een Ethernet frame ontvangt:

- NIC bekijkt het destination MAC-adres van de frame
- Zoekt een match
  - Geen match? Frame weggooien
  - Match of juiste broadcast/multicast? Frame doorgeven aan upper layers

#### Unicast

De source host stuurt naar een bepaald IP-adres (van de destination host).

Source host moet erachter komen welk Mac-adres bij een bepaald IP-adres hoort. Dit gebeurt door twee protocollen:

- [ARP = Address Resolution Protocol](https://www.youtube.com/watch?v=cn8Zxh9bPio) (IPv4)
- ND = Neighbor Discovery (IPv6)

Source MAC-adres is altijd unicast

#### Broadcast

Altijd adres FF-FF-FF-FF-FF-FF

Wordt door elke switch port doorgegeven (behalve de incoming port). <br> Wordt niet doorgegeven door routers

-> Hierdoor ontvangen alle devices op het local network de message

#### Multicast

Mac-adres afhankelijk van welk type IP-packet:

- IPv4 packet: 01-00-5E
- IPv6 packet: 33-33

Elke multicast group heeft een IP-adres (tussen 224.0.0.0 en 239.255.255.255 voor IPv4 - ff00::/8 voor IPv6)

De multicast message wordt net zoals de broadcast op alle poorten opnieuw uitgezonden. Als multicast snooping geïmplementeerd is, wordt de message ook op de incoming port opnieuw uitgezonden.

## MAC Address Table

Layer 2 Ethernet switches gebruiken het MAC-adres om te kijken welke packets ze door moeten sturen of moeten laten vallen. Daarvoor houdt het een tabel van MAC-adressen bij.

MAC Address Table wordt soms ook CAM (content addressable memory) genoemd.

### Switch learning en forwarding

De switch bouwt de MAC address table als volgt op:

- Wanneer de switch een packet ontvangt, slaat het op welk MAC-adres op die poort binnenkwam.
- Als het destination MAC-adres gekend is, stuurt de switch het packet door die poort (= frame filtering).
- Als het destination MAC-adres niet gekend is, stuurt de switch het packet door alle poorten (behalve de incoming poort)

Meestal houdt een switch de data 5 minuten bij, elke keer dat de switch data ontvangt van het MAC-adres door dezelfde poort, wordt de timer gerefresht.

Er kunnen meerdere MAC-address entries voor een poort bijgehouden worden (vb. als een switch verbonden is met die poort).

Als het MAC-adres buiten het lokale netwerk ligt, wordt de frame naar de default gateway (= router) gestuurd. Destination MAC is dan de MAC van de default gateway.

## Switch Speeds en Forwarding Methodes

[_7.4.1 - 7.4.3 moeten niet gekend zijn voor het examen -> zie extra informatie_](#extra-informatie)

### Bandbreedte en duplex

-> Belangrijkste settings: Bandbreedte bepaalt de snelheid en duplex bepaalt of beide kanten tegelijk kunnen verzenden / ontvangen (full-duplex) of niet (half-duplex).

Veel devices kunnen dit vanzelf instellen via "autonegotiation". Ze stemmen dan onderling de beste bandbreedte- en duplexinstellingen af.

> **TIP** > <br> Duplex-mismatch is de meest frequente bron van problemen in 10/100MPBS Ethernet links.

### Auto-MDIX

= Automatic Medium-Dependent Interface Crossover

-> Zorgt ervoor dat je zowel een straight-through als crossover cable kan gebruiken. De switch bepaalt welk soort device er verbonden is.

Het is wel verstandig om nog steeds de juiste kabel te gebruiken, auto-MDIX staat soms niet automatisch aan.

## EXTRA INFORMATIE

Cisco switches gebruiken twee forwarding methodes.

- Store-and-forward switching checkt voor errors voordat het de frame forwardt. Belangrijk voor netwerken waarin QoS moet toegepast worden. Vermindert congestion van corrupte data. Het ontvangt de volledige frame voordat het forwardt.
- Cut-through switching: Vanaf de switch het destination MAC-address heeft ontvangen, forwardt het de frame naar de juiste poort. Er is geen error check. Twee varianten:
  - Fast-forward switching (sneller): forwardt net na het ontvangen van destination MAC.
  - Fragment-free switching (robuster): forwardt na de eerste 64-bits (errors komen meestal in de eerste 64-bits voor) = compromis tussen cut-through en store-and-forward

Memory buffering houdt in dat de Ethernet switch bepaalde informatie bijhoudt als de destination port bezet is. Er bestaan twee vormen: Port-based memory en Shared memory.
