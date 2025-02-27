# Ethernet Switching

- [Ethernet Frames](#ethernet-frames)
- [Ethernet MAC Addresses](#ethernet-mac-addressen)
- [MAC Address Table](#mac-address-table)
- [Switch Speeds and Forwarding Methods](#switch-speeds-en-forwarding-methodes)

## Ethernet Frames

Ethernet is deel van de fysieke en data link layers.

<strong>Minimumlengte: 64 bytes <br>Verwachte maximumlengte: 1518 bytes <br></strong>
Als een frame langer / korter is, gooit de ontvanger deze weg.

*Preamble is geen deel van die frame length*

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

## MAC Address Table

## Switch Speeds en Forwarding Methodes