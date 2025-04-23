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

## Dynamic Addressing for IPv6 LLAs

## IPv6 Multicast Addresses

## Subnet an IPv6 Network
