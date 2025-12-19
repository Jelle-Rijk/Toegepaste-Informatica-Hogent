<h1> Availability </h1>

# Disaster Recovery Planning (DRP)

= maatregelen treffen om recovery bij rampen te verbeteren.

Rampen kunnen natuurlijk (geologisch, meteorologisch, gezondheidsramp) of menselijk (gebeurtenissen op werk, soco-politiek, onderbreking van nutsvoorzieningen) zijn.

# High availability

Streven naar Five Nines (99.999%) <br>
_Downtime = 5m 15.36s per jaar_

Nodig in financiële sectoren, gezondheidssector, industrie, openbare veiligheid, nutsvoorzieningen, telecom, retail en transport.

Bekomen door:

- 5x9 (Five Nines) uptime
- Single points of failure wegwerken (= redundantie): minimaal N+1 redundantie (N onderdelen nodig, eentje als backup)
- Systeem robuust maken: crashes en falende toestellen mogen het netwerk niet neerhalen + backups moeten zelf-helend zijn
- Monitoren van systemen: via visualisatie en alerts (doel = snel detecteren)
- Backups maken (volgens 3-2-1-regel)

**3-2-1-regel**: Minstens 3 kopieën op minstens 2 verschillende media, waarvan 1 op een andere locatie.

# Opslagmedia

Hot storage = gebruikte media <br>
Cold storage = media die gedeconnecteerd is en ergens opgeslagen ligt (vb. in een kast)

Andere media dan hieronder besproken:

- Tapes
- USB
- CD/DVD/Blu-ray
- NAS (= Network Attached Storage)

## HDD

Kan niet tegen schokken of magnetisme.

Gemiddelde levensduur: 6-7 jaar (hot storage), 5 jaar (cold storage)

S.M.A.R.T. = HDD kan verschillende statistieken aan het OS rapporteren.

Data is makkelijk te recoveren als de harde schijf faalt.

## SSD

Beperkte writes, gevoelig aan hoge temperaturen.

Er zijn nog geen conclusies over de levensduur van SSD's (technologie is er te nieuw voor). Moet wel jaarlijks aangesloten worden om bit-rot te voorkomen.

Kan ook S.M.A.R.T.-waarden rapporteren, maar zijn andere dan HDD.

Moeilijk data te recoveren als de schijf faalt.

## Cloud

Handig voor off-site back-ups.

Bedenkingen bij free tiers -> soms is je data hate product.

Let op: Synchronisatie is geen backup (ransomware wordt ook gesynct).

# Backups

Beste meerdere over een langere tijd bijhouden.

Best automatiseren om niet te vergeten.

**Full backup** = volledige backup (copy-paste) <br>
**Incrementele backup** = 1 kopie + alle delta's die daarna uitgevoerd zijn (gelijkaardig aan Git)

Incrementele backups gebruiken minder data, maar full backups zijn nog steeds nodig. -> Als de originele backup waarop de delta's gebaseerd zijn corrupt raakt, kunnen de delta's niet meer uitgevoerd worden.

Test bij backups altijd:

- Of de backups gemaakt worden
- Of de data correct hersteld wordt van de backup.

# Interessante links

[https://www.backblaze.com/cloud-storage/resources/hard-drive-test-data](Website gemiddelde levensduur HDD volgens model)
