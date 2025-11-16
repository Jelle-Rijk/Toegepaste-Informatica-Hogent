<h1> Bedreigingen, aanvallen en kwetsbaarheden </h1>

- [Aanvalsvectoren - inleiding](#aanvalsvectoren---inleiding)
  - [Impact van Big Data](#impact-van-big-data)
  - [Bredere reikwijdte en cascade-effect](#bredere-reikwijdte-en-cascade-effect)
- [Malware en kwaadaardige code](#malware-en-kwaadaardige-code)
- [Misleiding en oplichting](#misleiding-en-oplichting)
  - [Phishing](#phishing)
- [E-mail- en browseraanvallen](#e-mail--en-browseraanvallen)
  - [Browser hijacking](#browser-hijacking)
- [Netwerkaanvallen](#netwerkaanvallen)
- [Applicatie-aanvallen](#applicatie-aanvallen)
- [APT's](#apts)
- [Interessante links](#interessante-links)

# Aanvalsvectoren - inleiding

**Mobiele apparaten** zijn moeilijk centraal te beheren en up te daten = groeiende bedreiging (door BYOD en meer mobiele apparaten)

Door de recente **opkomst van het Internet of Things**, moet er veel meer data beveiligd worden. Ze geven toegang op afstand en veiligheid is niet vaak de prioriteit. Soms verzenden de devices ook data naar de server die je niet direct verwacht.

_Sommige IOT-devices hebben een webportaal, waardoor de aanvallers niet eens langs de firewall moeten gaan. Ze geraken binnen in het IoT device en zitten dan al op je netwerk._

> **TIP** <br>
> Plaats IoT-devices op een subnetwerk.

Langs de positieve kant is er nu veel meer kennis over cybersecurity (zowel de aanvallers en verdedigers) en een verhoogde waakzaamheid t.o.v. vroeger. Mensen die geen expert zijn, geraken bijna nergens meer binnen.

## Impact van Big Data

Big Data is soms moeilijk te definiëren, dus wordt er naar de 3 V's gekeken om te bepalen of het om Big Data gaat.

- Volume = hoeveelheid gegevens
- Variety / Verscheidenheid
- Velocity / Snelheid = Hoe snel er nieuwe gegevens bij komen (vb. een databank met weerberichten updatet maar één keer per dag, maar heeft data van de afgelopen honderd jaar = niet snel)

Big Data is gevaarlijk in de verkeerde handen.

## Bredere reikwijdte en cascade-effect

Je kan vaak inloggen met dezelfde gegevens op verschillende sites / applicaties (vb. Inloggen met Google). Dit is heel gemakkelijk, maar als het gekraakt wordt, zijn heel veel van je accounts gekraakt.

Die samenhang zorgt ervoor dat de gevolgen voor een gebroken systeem soms heel groot kunnen zijn.

# Malware en kwaadaardige code

Malware komt in veel vormen voor:

| Naam             | Verspreiding                   | Kenmerk                                                                                                    |
| ---------------- | ------------------------------ | ---------------------------------------------------------------------------------------------------------- |
| Virus            | Uitvoerbaar bestand vasthangt. | Vereisen een actie van de eindgebruiker (vb. programma starten, bestand openen, etc.)                      |
| Worm             | Via netwerk / USB-sticks       | Draait op zichzelf en heeft geen actie van de eindgebruiker nodig om zijn werk te doen. Kopieert zichzelf. |
| Trojan Horse     | Niet-uitvoerbare bestanden     | Hangen vast aan een gewenst bestand (vb. PDF of foto)                                                      |
| Logic bomb       | N/A                            | Wordt op een bepaald moment (= trigger) geactiveerd                                                        |
| Ransomware       | N/A                            | Blokkeert systeem of encrypteert data. Vraagt een geldsom om het probleem op te lossen.                    |
| Rootkit          | N/A                            | Past OS aan om zo een backdoor te creëren. Moeilijk op te merken (zit op niveau van OS, geen programma)    |
| Keyboard logging | N/A                            | Houdt bij wat je typt. (Vooral gevaarlijk bij paswoorden)                                                  |

# Misleiding en oplichting

Dit zijn sociale aanvallen.

Enkele voorbeelden:

- [Phishing](#phishing)
- Pretexting: Slachtoffer wordt opgebeld en gevraagd gevoelige informatie te geven om zichzelf te identificeren.
- Vishing (= voice phishing): Social engineering via de telefoon om toegang te krijgen tot persoonlijke en financiële informatie. (Tegenwoordig makkelijk met stemnabootsing m.b.v. AI)
- Cat phishing: Fraude door een valse identiteit (= niet-bestaande persoon) aan te nemen.
- Impersonation: Zich als iemand anders voordoen.
- Shoulder surfing: Meekijken naar het ingeven van een wachtwoord / PIN-code.
- Dumpster Diving: Informatie uit afval halen.
- Piggybacking: Samen met een geauthoriseerd persoon ergens binnengaan.
- Tailgating: Achter een geauthoriseerd persoon ergens binnenglippen.

## Phishing

Vorm van fraude. Je krijgt een valse link, waar de aanvaller hoopt dat je je gegevens invult.

Voordeel van phishing: E-mails versturen is heel gemakkelijk, dus er moeten niet veel mensen in de phishing trappen om het waard te maken.

Fouten in e-mails zijn vaak opzettelijk zodat de mensen die erop ingaan de mensen zijn die het meest goedgelovig zijn. <br> Soms worden links paars gezet in e-mails om de indruk te geven dat ze leiden naar een site die je al gebruikt hebt.

Er bestaan enkele varianten van phishing:

| Naam           | Beschrijving                                                                                                                                    |
| -------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| Quishing       | = QR phishing. QR-codes op bijvoorbeeld posters vervangen door QR-codes naar malware. / Opkopen verkorte links van QR-codes die vervallen zijn. |
| Spear phishing | Phishing attempt die op een heel specifieke groep mensen gericht is. _vb. Alle werknemers van Sint-Laurens._                                    |
| Whaling        | Phishing gericht op één specifieke belangrijke persoon. _vb. baas van een bedrijf_                                                              |
| Pharming       | Phishing zonder dat je bijvoorbeeld een e-mail stuurt. Je zet een website op waar mensen toevallig op kunnen komen.                             |
| Typosquatting  | Vorm van pharming waarbij je op spelfouten rekent. (vb. paipal.com i.p.v. paypal.com)                                                           |

# E-mail- en browseraanvallen

Sommige zaken verspreiden zich specifiek door browsers en e-mails:

- SEO poisoning: Cybercriminelen zorgen dat hun malafide websites hoog ranken op zoekmachines door aan Search Engine Optimization te doen.
- [Browser hijacking](#browser-hijacking)
- Spam: Advertenties / kwaadaardige links via mail.
- Hoaxes: Leugens of valse informatie die online verspreid worden. <u>Meestal</u> onschadelijk.
- Spyware: Verzamelt informatie over de gebruiker van een apparaat, meestal om geld te verdienen (vaak een [keylogger](#keyboard-logging)).
- Adware: Software die advertenties genereert, in de hoop dat de gebruiker erop klikt.
- Scareware: Scareware is een specifieke vorm adware die de gebruiker bang probeert te maken (vb. "Uw computer is geïnfecteerd") om mensen te overtuigen iets te doen.

## Browser hijacking

Browserinstellingen worden gewijzigd, waardoor de browser automatisch doorverwijst naar de website van de "klant" van de aanvaller. (vb. Zoekmachine aanpassen, linken naar een website vol ads)

Enkele zaken die kunnen wijzen op browser hijacking:

- Trage laadtijden
- Pop-up ads
- Andere standaardzoekmachine
- Nieuwe icoontjes / toolbars

# Netwerkaanvallen

Veel aanvallen gebeuren via het netwerk:

| Naam                           | Beschrijving                                                                                                                                                 |
| ------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| DoS attack (Denial-of-Service) | Server overloaden met requests                                                                                                                               |
| DDoS attack                    | Een DoS vanuit veel computers (meestal met een botnet)                                                                                                       |
| Sniffing                       | Netwerkverkeer dat via een NIC passeert afluisteren (vb. WireShark)                                                                                          |
| Spoofing                       | Technologie misleiden door bepaalde kenmerken (vb. IP, locatie, telefoonnummer) aan te passen. Is eigenlijk de technologische vorm van [phishing](#phishing) |
| Man-in-the-middle attack       | Verzamelnaam van aanvallen waar de indringer tussen zender en ontvanger zit.                                                                                 |

Een **botnet** bestaat uit:

- C&C / C2 (Command and Control): een server die geïnfecteerde apparaten aanstuurt.
- Zombies: Geïnfecteerde computers die door de aanvaller kunnen bestuurd worden.

Een voorbeeld van een man-in-the-middle attack is een **Rogue Access Point** maken. -> Dit wordt in een (meestal) draadloos netwerk geplaatst en doet zich voor als een vertrouwelijk apparaat. (vb. vals WiFi-punt in een luchthaven)

# Applicatie-aanvallen

Applicatie-aanvallen zijn vaak webgebaseerd.

| Naam                  | Beschrijving                                                                                                                                                                   |
| --------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Zero-day attack       | Gebruiken van een kwetsbaarheid in software die nog niet gekend is.                                                                                                            |
| Cross-site scripting  | Je uploadt een script naar een website met een fout in. Die webserver slaat het op. Het slactoffer dat naar de website surft, zal het script dan via zijn browser uitvoeren.   |
| Code injections       | Code laten uitvoeren door invoervelden te misbruiken.                                                                                                                          |
| Buffer overflow       | Je vult het geheugen van een programma, zodat er een overflow ontstaat. Daardoor gebruik je het geheugen van een andere applicatie, wat kan leiden tot crashes of dataverlies. |
| Remote Code Execution | Kwetsbaarheid gebruiken om code vanop afstand uit te voeren.                                                                                                                   |

Beschermen tegen applicatie-attacks:

- Stabiele code schrijven (exceptions gebruiken om fouten op te vangen)
- Beschouw alle user input als vijandig / kwaadaardig
- Valideer en controleer alle user input
- Regelmatig updates uitvoeren zodat zwaktes gepatcht worden.

# APT's

-> Advanced Persistent Threat

Langdurige, doelgerichte cyberaanval. Deze blijft voor heel lange tijd onzichtbaar. Vaak gericht op landen en organisaties.

Ze krijgen vaak een code die start met APT.

> Voorbeeld: Stuxnet
>
> Worm die zichzelf verspreidde via vier ongekende zwaktes in Microsoft-servers (= advanced). Het bleef jaren ongedetecteerd en activeerde enkel als er centrifuges voor het verrijken van uranium op het netwerk waren (= persistent). Het zorgde ervoor dat de centrifuges iets sneller gingen draaien en zo kapot gingen (= threat).

# Interessante links

- [OWASP top ten](https://owasp.org/www-project-top-ten/) - Overzicht van meest voorkomende kwetsbaarheden
