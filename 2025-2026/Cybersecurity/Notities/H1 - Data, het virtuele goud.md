<h1> Data, het virtuele goud </h1>

- [Staten van data](#staten-van-data)
- [De CIA-driehoek](#de-cia-driehoek)
  - [Confidentiality](#confidentiality)
  - [Integrity](#integrity)
  - [Availability](#availability)
- [De cybersecurity kubus](#de-cybersecurity-kubus)
- [Wachtwoorden](#wachtwoorden)
  - [Password policies](#password-policies)

# Staten van data

Data kan in drie staten voorkomen:

- in rust = alle data die ergens opgeslagen is (en op dat moment niet in gebruik is)
- in verwerking = data tijdens invoer, aanpassing, berekenen of uitvoer (vb. keyloggers)
- aan het verzenden (kan digitaal - vb. internet - of digitaal - vb. sneakernet = fysiek verplaatsen van tapes/usb's/hdd's/etc.)

Data tijdens verzending beveiligen is een van de grootste uitdagingen voor cybersecurity

# De CIA-driehoek

Confidentiality <br>
Integrity <br>
Availability

## Confidentiality

_Wie mag de data zien/inkijken?_

Kan o.a. verkregen worden door:

- encryptie
- authenticatie = identiteit bewijzen
- toegangscontrole (authorisatie) = bewezen identiteiten enkel tot nodige info toegang geven

Belangrijk => personeel opleiden om goed om te gaan met gevoelige informatie.

## Integrity

_Klopt de data wel? Komt deze van de juiste persoon?_

Nood aan integriteit is sterk afhankelijk van aard van data <br> (vb. superbelangrijk bij banktransacties)

Belangrijke manier om integriteit te garanderen is het gebruik van een **hash functie** (soort berekening die maar één kant op gaat)

## Availability

_Kan ik de data raadplegen als ik die nodig heb?_

Maatregelen voor availability: redundantie, backups, etc.

Leeromgevingen en nieuwswebsites (om politieke redenen) zijn populaire doelwitten voor bijvoorbeeld DDoS-attacks

Een aanval met ransomware valt ook onder availability (de data wordt namelijk geëncrypteerd, niet aangepast)

# De cybersecurity kubus

De data moet op negen punten beveiligd worden (CIA voor de drie staten) en dat kan met drie beveiligingsmaatregelen - in totaal 27 puntjes die we moeten uitwerken voor een veilige omgeving (dit wordt weergegeven in de vorm van een kubus) = McCumber Cube

De drie zijden staan voor:

- Technologische maatregelen (vb. encryptie)
- Policies (vb. enkel mensen toegang geven die de data nodig hebben) => wordt wel meestal met technologische maatregelen afgedwongen
- Menselijke maatregelen (vb. opleidingen)

# Wachtwoorden

Hoe langer hoe beter.

Gebruik geen truucjes -> hacktools kunnen deze vaak ontcijferen

Wachtwoorden hergebruiken is een van de slechtste dingen om te doen -> password managers gebruiken kan een oplossing zijn (heeft enkele nadelen, maar is vele malen beter dan overal hetzelfde wachtwoord gebruiken)

## Password policies

Best om deze simpel te houden, veel (en ingewikkelde) vereisten zorgen ervoor dat mensen aan de policies voldoen en voor de rest hun paswoord zo eenvoudig mogelijk maken.

Aanbeveling om geen tijdslimiet op paswoorden te zetten. (Mensen verzinnen truucjes, dit maakt hun paswoord minder veilig)

Wat doe je best wel?

- Delay tussen inlogpogingen (wachten na foutief wachtwoord) => bots moeten ook wachten, weinig invloed op 2/3 pogingen, veel bij duizenden (zowel handig bij progammeren als systeembeheer)
