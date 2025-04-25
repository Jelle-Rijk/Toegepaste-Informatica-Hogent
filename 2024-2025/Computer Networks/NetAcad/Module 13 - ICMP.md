# ICMP

- [ICMP Messages](#icmp-messages)
- [Ping and Traceroute tests](#ping-and-traceroute-tests)

## ICMP Messages

De te kennen soorten ICMP messages (beschikbaar in zowel ICMPv4 als ICMPv6):

- Host reachability: Stuurt een Echo Request naar een host. Als die host beschikbaar is, stuurt deze een Echo Reply terug. (= ping)
- Destination or Service Unreachable: Als een host of gateway een packet ontvangt dat het niet kan afleveren, kan het dit type ICMP terugsturen. Hier hoort dan ook een code bij die aangeeft wat er misgegaan is.
- Time exceeded: Als de Time To Live (IPv4) of Hop Limit (IPv6) op 0 komt te staan, stuurt de router dit type ICMP terug naar de source host. (Traceroute maakt hier ook gebruik van.)

### ICMPv6 Messages

Deze hebben nog vier extra functionaliteiten die gebruikt worden bij Neighbor Discovery:

- RS -> Router Solicitation
- RA -> Router Advertisement
- NS -> Neighbor Soliciation
- NA -> Neighbor Advertisement

## Ping and Traceroute Tests

Je kan ping op een aantal manieren gebruiken:

| Taak                                          | Manier                                      | Notes                                                                                                                                |
| --------------------------------------------- | ------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| Installatie van IPv4 / IPv6 testen            | Loopback interface pingen (127.0.0.1 / ::1) |
| Communicatie op het lokale netwerk testen     | Default Gateway pingen                      | Als een andere host antwoordt, is de default gateway verkeerd ingesteld                                                              |
| Communicatie buiten het lokale netwerk testen | Remote host pingen                          | Veel bedrijven laten geen ICMP-messages toe in het bedrijfsnetwerk. Als je geen antwoord krijgt, kan dat dus aan beveiliging liggen. |

|

Traceroute (`tracert`) geeft een lijst met hops terug. Daarin zie je ook de RTT (Round Trip Time) voor elke hop. Een \* betekent dat het packet verloren ging of niet teruggezonden werd. Hoge response time van een specifieke hop kan betekenen dat die router of verbinding overbevraagd is.

Traceroute verzendt een packet met TTL / Hop Limit 1, en krijgt een Time Exceeded message terug. Voor elke hop verstuurt het opnieuw een packet met een hogere TTL / Hop Limit.
Als Traceroute een Echo Reply of Port Unreachable message ontvangt, is het packet op de laatste destination toegkomen.
