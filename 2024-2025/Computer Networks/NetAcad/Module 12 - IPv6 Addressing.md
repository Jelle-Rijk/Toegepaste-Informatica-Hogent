# IPv6 Addressing

- [IPv4 Issues](#ipv4-issues)
- [IPv6 Address Representation](#ipv6-address-representation)
- [IPv6 Address Types](#ipv6-address-types)
- [GUA and LLA Static Configuration](#gua-and-lla-static-configuration)
- [Dynamic Addressing for IPv6 GUAs](#dynamic-addressing-for-ipv6-guas)
- [Dynamic Addressing for IPv6 LLAs](#dynamic-addressing-for-ipv6-llas)
- [IPv6 Multicast Addresses](#ipv6-multicast-addresses)
- [Subnet an IPv6 Network](#subnet-an-ipv6-network)

## IPv4 Issues

Grootste reden voor transitie: IPv4 adressen zijn op (bij all 5 RIRs).
<br> IETF ontwikkelde IPv6 en loste daarbij een paar problemen voor IPv4 op.

Momenteel overgangsperiode, 3 manieren om transitie mogelijk te maken:

- Dual Stack (uiteindelijke doel): IPv6 runt natively. Devices gebruiken zowel de IPv4 als IPv6 stack.
- Tunneling: IPv6 packet wordt ingekapseld in een IPv4 packet.
- Network Address Translation 64 (NAT64): Vertaalt tussen IPv4 en IPv6

## IPv6 Address Representation

128 bits -> verdeeld in 8 16-bit segmenten (= 4 hex characters / segment)
<br> Hextet = één 16-bit segment

Heel lange adressen, ze kunnen ingekort worden:

- Leading zeroes mag je weglaten.
- Je kan :: gebruiken om meerdere hextets die 0 zijn te vervangen (maximaal 1 keer per adres)

## IPv6 Address Types

Drie categorieën:

- Unicast
- Multicast
- Anycast: Packet met anycast wordt naar het dichtstbijzijnde adres geroutet met dat IP-adres. (buiten scope van cursus)

Broadcast bestaat niet, dit is vervangen door een multicast-adres dat alle nodes aanspreekt.

Prefix length voor IPv6 LANs is meestal /64
<br> = 64 bits network portion en 64 bits Interface ID (= host portion)

Stateless Address Autoconfiguration (SLAAC) gebruikt 64 bits voor interface IDs, dus best 64 bits voor interface ID gebruiken.

IPv6 devices hebben meestal twee unicast-adressen:

- Global Unicast Address (GUA): Globaal routable, zoals IPv4 public. Kan statisch of dynamisch geconfigureerd worden. Een GUA is niet verplicht.
- Link-local Address (LLA): Verplicht op elk IPv6 apparaat. Adres waarmee het apparaat communiceert op de local link (packets worden niet geroutet buiten de link).

Daarnaast bestaan er nog enkele speciale unicast-adressen:

- Loopback: ::1/128
- Unspecified: ::
- Unique local: fc00::/7 - fdff::/7
- Embedded IPv4

> **Verschil LLA en Unique Local**
> LLA's kunnen niet geroutet worden, ze blijven dus op de local link. Unique Locals kunnen wel geroutet worden, maar enkel binnen één domein (dus niet globaal)

### GUA

- Global Routing Prefix: Geeft aan tot welk netwerk het IP behoort -> toegewezen door ISP.
- Subnet ID: Geeft aan tot welk subnet het IP behoort. Hoe langer de Global Routing Prefix, hoe korter het Subnet ID.
- Interface ID: Gelijk aan host portion in IPv4

De global routing prefix is meestal 48 bits lang, maar bedrijven krijgen vaak 32 bit prefixes. Dan is hun subnet ID ook 32 bits, waardoor ze meer subnets kunnen hebben.

### LLA

Een LLA is een adres in de range fe80::/10, het eerste hextet zit in de range fe80 - febf.

De default gateway is meestal de LLA van de router (en dus niet de GUA).

Twee manieren om een LLA te verkrijgen:

- Statisch: manueel toegewezen.
- Dynamisch: via randomly generated values of de Extended Unique Identifier methode (EUI), op basis van het MAC-adres

## GUA and LLA Static Configuration

Een GUA configureren is identiek aan een IPv4 adres configureren.

Een link-local adres kan je configureren door `link-local` als parameter toe te voegen na het adres. Je gebruikt dezelfde commando's als bij GUA.

## Dynamic Addressing for IPv6 GUAs

Meeste devices krijgen hun IPv6 GUAs dynamisch via RA (Router Advertisement) en RS (Router Solicitation).

De RS en RA messages worden verzonden via ICMPv6. De RA messages worden elke 200 seconden door de routers naar alle devices op het netwerk gestuurd. Routers sturen ook een RA als ze een ICMPv6 RS message krijgen van een ander device.

Om RA messages te zenden, moet je IPv6 routing enablen in global config mode met `ipv6 unicast-routing`.

Een ICMPv6 RA-message kan het volgende bevatten:

- Netwerk prefix en prefix length: vertelt host tot welk netwerk het behoort.
- Default Gateway Address - Source LLA IPv6 address van de RA message (= LLA van de interface van de router)
- DNS addresses and domain name

Het host apparaat kan ervoor kiezen om af te wijken van de informatie die het ontvangt in de RA-message.

**Er zijn drie methodes om de GUA te bepalen:**

### Methode 1 - SLAAC

SLAAC (StateLess Address Auto Configuration) -> De host ontvangt alle informatie van de router.
<br> Dit proces is stateless omdat de informatie nergens centraal wordt opgeslagen (vb. DHCPv6 server)

De GUA wordt als volgt samengesteld:

- Prefix -> gekregen van de RA-message
- Interface ID -> bepaald door operating system (ofwel EUI-64 ofwel random 64-bit nummer)

#### EUI-64 vs. Randomly generated

EUI-64 (Extended Unique Identifier 64): Gebruikt het MAC-adres (48 bits) van het device en voegt 16 bits in het midden toe om een 64 bit interface ID te krijgen.

Het MAC-adres bestaat uit:

- 24 bits Organizationally Unique Identifier (OUI) - uniek per vendor
- 24 bits Device Identifier - om uniek device te bepalen

De EUI-64 interface ID wordt als volgt opgebouwd:
<br> OUI van het MAC-adres - fffe (hexadecimaal) - Device Identifier van MAC-adres

Privacy-concerns -> Je kan het MAC-adres zien in het IP.

Daarom is er een alternatief gebaseerd op een random number. -> Om ervoor te zorgen dat het IPv6 adres dan uniek is, zoekt het device zijn eigen adres met een Duplicate Address Detection (DAD). Als het geen respons krijgt, is het adres uniek. <br>
Op Windows is random number de default manier, maar je kan ook EUI-64 instellen

### Methode 2 - SLAAC + Stateless DHCPv6

Devices doen het volgende:

- Ze maken hun eigen IPv6 GUA met SLAAC (en EUI-64 / random number)
- Ze zetten de router LLA als default gateway
- Ze contacteren een DHCPv6 server voor adressen en domeinnamen

**Let op!** Stateless DHCPv6-servers kennen geen GUAs toe.

### Methode 3 - Stateful DHCPv6

Devices doen het volgende:

De RA-message bevestigt enkel dat die de default gateway is en geeft een DHCPv6-serveradres mee

- Ze zetten de router LLA als default gateway
- Ze halen hun GUA, DNS server address, domeinnaam en andere informatie bij een DHCPv6 server.

## Dynamic Addressing for IPv6 LLAs

LLA wordt gegenereerd aan de hand van het prefix fe80::/10 en een interface ID op basis van EUI-64 of Randomly Generated Number.

In Windows wordt dezelfde methode als voor de GUA gehanteerd om de interface ID te bepalen.

Cisco routers maken automatisch een LLA aan als je ze een GUA geeft. Dit doen ze op basis van EUI-64.

Nadeel: Moeilijk te onthouden / lange addressen. Daarom krijgen routers meestal toch een statisch LLA.

## IPv6 Multicast Addresses

Starten altijd met ff00::/8 (dus ffxx)

**Well-known Multicast Addresses**

- ff02::1 -> Multicast groep voor alle IPv6-apparaten
- ff02::2 -> Multicast groep voor alle IPv6-enabled routers

**Solicited-Node Multicast Addresses**
Worden bepaald door de Ethernet NIC.

## Subnet an IPv6 Network

Verhoog het subnet ID met 1. -> veel gemakkelijker dan in IPv4 omdat het ingebouwd zit in het adres.
<br> _Je kan nog steeds subnetten zoals in IPv4, maar dit wordt eigenlijk nooit gedaan._

In IPv6 is er geen schaarste aan IP-addressen, je kan 65563 subnets hebben. Daarom kan je dus gewoon IPs "verspillen".

# Speciale Adressen - Samengevat

| Type                           | Adres                               |
| ------------------------------ | ----------------------------------- |
| GUA (= Global Unicast Address) | beginnen met 2 of 3                 |
| Documentatie (dus ongebruikt)  | begint met 2001:db8 (2001:db8::/32) |
| LLA (Link-local Address)       | begint met fe80 - febf (fe80::/10)  |
| Loopback                       | ::1/128                             |
| Unique Local                   | begint met fc - fd                  |
| Unspecified                    | ::                                  |
| Multicast                      | begint met ff (ff00::/8)            |
| Multicast ALL-NODES            | ff02::1                             |
| Multicast ALL-ROUTERS          | ff02::2                             |
