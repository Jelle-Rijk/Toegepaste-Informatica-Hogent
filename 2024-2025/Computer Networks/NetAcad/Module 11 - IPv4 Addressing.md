# IPv4 Addressing

## IPV4-adresstructuur

IPv4-adressen bestaan uit twee delen:

- Network portion geeft het netwerk aan.
- Host portion geeft het apparaat aan.

Het **subnet mask** geeft aan hoe lang de network portion is. Als de bit in het subnet mask op 1 staat, telt de overeenkomende bit in het IPv4-adres als deel van het netwerk. Het netwerkgedeelte heet soms ook prefix of network prefix. Subnet mask kan in "slash notation" beschreven worden: vb. 255.255.255.0 = 24 bits op 1 dus xxx.xxx.xxx.xxx/24. Het aantal bits dat tot het subnet mask behoort, heet soms ook de prefix length.

Je vindt het **netwerkadres** door een AND-operatie uit te voeren op het IPv4-adres en het subnet mask. (= alle bits van host portion op 0)

## Unicast, broadcast en multicast

Het **broadcastadres** van een netwerk is het laatste IP van het netwerk (= alle bits van host portion op 1). Je kan dus naar twee adressen broadcasten (255.255.255.255 = algemeen, 192.168.1.255 = broadcastadres voor netwerk 192.168.1.0/24). Met het broadcastadres kan je dus ook een broadcast naar een ander netwerk sturen. In Cisco routers staat dit als default uit (security).

IPv4-adressen 224.0.0.0 tot 239.255.255.255 zijn gereserveerd voor **multicast-adressen**. Programma's kunnen devices "subscriben" voor een bepaald multicast-adres. Het device accepteert dan alle packets voor dat adres. (vb. OSPF gebruikt adres 224.0.0.5, alle routers met OSPF verwerken de packets met dit adres.)

## Types van IPv4-adressen

Public IP-adressen zijn adressen die gebruikt worden om tussen ISP's te routen (ze worden toegewezen door de ISP).
Private IP-adressen worden binnen het netwerk gebruikt (ze worden toegewezen door de router).

Private adressen starten met: 10, 172.16-172.31 of 192.168.0-192.168.255

De router maakt de vertaling van private naar public en omgekeerd via NAT (= Network Address Translation).

Als een organisatie public IP-adressen op devices heeft (vb. voor een web-server), staan ze in een DMZ (= Demilitarized Zone)

### Speciale IPv4-adressen

127.0.0.0/8 (= 127.0.0.1 - 127.255.255.254) -> **loopback adressen**, computers kunnen deze gebruiken om verkeer naar zichzelf te sturen.

169.254.0.0/16 (= 169.254.0.1 - 169.254.255.254) -> **link-local adressen** (= APIPA - Automatic Private IP Addressing), worden gebruikt door DHCP als er geen DHCP servers beschikbaar zijn.

### Vroeger -> Classful Addressing

Voor de komst van het World Wide Web werden IP's onderverdeeld in klassen.

| Class | IP-range                        | Use                                     |
| ----- | ------------------------------- | --------------------------------------- |
| A     | 0.0.0.0/8 - 127.0.0.0/8         | Netwerken met meer dan 16 miljoen hosts |
| B     | 128.0.0.0/16 - 191.255.0.0/16   | Netwerken tot 65000 hosts               |
| C     | 192.0.0.0/24 - 223.255.255.0/24 | Kleine netwerken tot 254 hosts          |
| D     | 224.0.0.0 - 239.0.0.0           | Multicasts                              |
| E     | 240.0.0.0 - 255.0.0.0           | Experimenteel                           |

## Network segmentation

Probleem met grote lokale netwerken -> te veel traffic door broadcasts.
<br> Oplossing = subnets maken (broadcasts blijven binnen hun eigen subnet)

Extra voordelen:

- Je kan als sysadmin aparte policies maken per subnet
- Beperkt de schade bij abnormaal verkeer

## IPv4-subnets

Kan je maken door enkele host bits te gebruiken als network bits.

-> Hoe meer bits je gebruikt om subnets te definiëren, hoe minder hosts op je netwerk kunnen zitten.
