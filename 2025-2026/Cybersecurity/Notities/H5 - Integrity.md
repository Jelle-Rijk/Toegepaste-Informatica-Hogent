<h1> Integrity </h1>

- [Digitale handtekening](#digitale-handtekening)
- [Hash als integriteitscontrole](#hash-als-integriteitscontrole)
  - [Hashingalgoritme](#hashingalgoritme)
    - [Botsingen](#botsingen)
    - [Toepassingen](#toepassingen)
  - [Hashing kraken](#hashing-kraken)
  - [HMAC](#hmac)

# Digitale handtekening

verder vanaf les H4 deel 2 tot H5 hashing 45:46

Goed voor controle van twee zaken:

- het bestand is niet gewijzigd na het genereren van de handtekening
- het bestand is afkomstig van de persoon die de handtekening genereerde

Realisatie via assymetrisch algoritme:

- Maak per persoon een publieke en private sleutel.
- Zender voegt een digitale handtekening toe, versleuteld met de private sleutel.
- Via de publieke sleutel van de ontvanger kan het bericht gedecrypteerd worden.

# Hash als integriteitscontrole

Hiermee kan je controleren of het bericht niet aangepast is.

Eerst wordt een hash berekend en toegevoegd aan het bericht. Als het bericht niet gewijzigd wordt, moet een latere hashberekening dezelfde uitkomst geven.

## Hashingalgoritme

Een hashingalgoritme is een wiskundige functie die makkelijk te berekenen is in één richting, maar onmogelijk in de andere.

Het moet aan de volgende eigenschappen voldoen:

- Input kan uit het even hoeveel bits bestaan.
- Output moet steeds hetzelfde aantal bits bevatten.
- De functie werkt maar in één richting
- Twee verschillende inputwaarden geven verschillende outputwaarden.

Voorbeelden van populaire algoritmes zijn Message Digest 5 Algorithm (MD5 - 128 bits output) en Secure Hash Algorithm (SHA - bits afhankelijk van versie)

### Botsingen

Er zijn meer mogelijke inputs dan outputs, dus er ontstaan botsingen/collisions. Hashingalgoritme verliest zijn nut als je deze bewust kan veroorzaken.

Bij MD5 en SHA-1 kan je bewust botsingen veroorzaken, deze zijn dus **zwakke algoritmes** en worden niet meer gebruikt voor cybersecurity.

SHA-2 en SHA-3 zijn **sterke algoritmes**.

### Toepassingen

- Controle op fouten in data: hashcode toevoegen, die kan later opnieuw berekend worden en vergeleken worden. Als de hashcodes verschillen zit er een fout in de data.
- Veilig bewaren en controleren van wachtwoorden: Je slaat de hashwaarde van het wachtwoord op in de databank i.p.v. het plaintext wachtwoord. Bij inloggen vergelijk je de berekende hashwaarde met de bestaande hashwaarde.
- Fingerprint
- Data efficiënt opslaan ([zie CCSA - Hashing](../../Classic%20Computer%20Science%20Algorithms/notities/H3%20-%20Hashing.md))

Salting = random bits per gebruiker toevoegen voor de hashwaarde zodat dezelfde inputs van twee gebruikers toch een verschillende hash hebben. De salt mag in plaintext opgeslagen worden. Zo kan een hacker niet zien dat twee personen hetzelfde wachtwoord hebben.

## Hashing kraken

= voor een gekende hashwaarde de overeenkomstige input vinden.

Omkeren is onmogelijk.

Opties:

- Brute-forcen
- Rainbow table: Je berekent de hashwaarde voor verschillende inputs tot je alle mogelijke hashwaarden hebt. Je kan dan in de tabel de juiste hashwaarde opzoeken met bijbehorende input. Dit moet je maar één keer opstellen en zijn dus gewoon op internet te vinden. Werkt enkel als er geen salt toegevoegd is.

Vaak worden hashing algoritmes expres trager gemaakt -> 1 keer een vertraging van 0.1s is onmerkbaar. Maar bij brute forcen/rainbow tables berekenen kan het enorm veel tijd toevoegen.

## HMAC

= Hash-based message authentication

HMAC is een hashfunctie die ook een symmetrische sleutel gebruikt. (= symmetrische tegenhanger van digitale handtekening)

Werking:

- Zender berekent de hashwaarde van het versleutelde bericht via HMAC, gebruikt hiervoor de gedeelde geheime sleutel.
- Zender voegt de berekende hashwaarde toe aan het bericht en verstuurt het.
- Ontvanger berekent de hashwaarde via HMAC met de gedeelde geheime sleutel.
- Ontvanger vergelijkt de hashwaarde die hij zelf berekende met de ontvangen hashwaarde.
- Als de waarden overeenkomen, is het bericht niet gewijzigd en komt het van de persoon die het bericht versleuteld heeft.

HMAC is heel effectief tegen Man-in-the-Middle attacks.
