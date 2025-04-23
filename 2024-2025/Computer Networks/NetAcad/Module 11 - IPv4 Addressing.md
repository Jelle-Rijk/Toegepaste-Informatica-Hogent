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

In een typisch bedrijfsnetwerk heb je binnen het netwerk volgende onderdelen:

- Intranet: Alleen toegankelijk binnen de organisatie (via private IPv4-adressen)
- DMZ: Resources die via het web toegankelijk zijn (via public IPv4-adressen)

Voor deze onderdelen moet subnetting verschillend aangepakt worden.

Voor het intranet kan je het 10.0.0.0 adres gebruiken en dat subnetten volgens de normale werkwijze.

## Variable Subnet Length Masking (VLSM)

Omdat de devices in de DMZ publiek toegankelijk moeten zijn, hebben ze public IPv4 adressen nodig. Deze zijn schaars. Je moet hier gebruik maken van Variable Subnet Length Masking (VLSM) om de publieke IP's zo efficiënt mogelijk te gebruiken. Bij klassiek subnetten zijn alle subnets even groot, dan zouden veel public IPv4-adressen ongebruikt gaan.

Subnets hoeven niet even groot te zijn, maar ze mogen niet overlappen. <br>
-> vb. Je kan je netwerk in vier subnets opsplitsen en dan het laatste subnet verder opsplitsen.

[Deze video legt het VLSM-proces gemakkelijk uit.](https://www.youtube.com/watch?v=OD2vG5st4zI)

> **Tip** <br>
> Als je subnets maakt met VLSM is het gemakkelijker om eerst de grote subnets en daarna de kleinere uit te werken.

## Structured design

Hoe je subnets het beste indeelt is afhankelijk van veel factoren (vb. is het intranet of DMZ? - Verwacht je groei? Welke hosts hebben statische IP's nodig?)

De verschillende soorten devices die adressen nodig hebben en welke adressen je best toewijst:

- End User Clients: Best via DHCP (dan leasen ze een IP en komt het daarna weer vrij)
- Servers en andere apparaten: Voorspelbare statische IP-adressen.
- Web-toegankelijke servers: Publiek toegankelijke servers hebben een public IPv4-adres nodig. Als de servers enkel intern toegankelijk moeten zijn via het web, maak je een VPN aan en verbind je met een private IPv4-adres.
- Intermediary devices: Statische, voorspelbare IP-adressen.
- Gateway: Statisch IP-adres. Router interfaces krijgen meestal het hoogste of laagste host adres

Probeer een logica in je adressen te stoppen -> beter voor de documentatie en maintenance.
