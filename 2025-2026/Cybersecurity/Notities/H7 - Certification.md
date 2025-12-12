<h1> Certification </h1>

- [Nood aan certificatie](#nood-aan-certificatie)
- [Certificate authorities](#certificate-authorities)
  - [Certificaat aanvragen](#certificaat-aanvragen)
  - [Certificaat verifiëren](#certificaat-verifiëren)
- [Toepassingen](#toepassingen)
  - [HTTPS](#https)
  - [VPN](#vpn)

# Nood aan certificatie

Er zijn problemen met:

- symmetrische encryptie: fysiek afspreken om de sleutel uit te wisselen
- assymetrische encryptie: juiste publieke sleutel bemachtigen, zwak teggen man-in-the-middle (je kan niet garanderen dat een publieke sleutel van de juiste persoon komt)

Oplossing: Vertrouwen bij een derde partij leggen

# Certificate authorities

Genereert digitale certificaten.

-> Gebruikers kunnen elkaar controleren op deze certificaten.

Een certificaat koppelt publieke sleutel aan een identiteit.

Het aanmaken en aanvragen van de certificaten gebeurt via een assymetrische encryptie. Zowel de CA als de gebruikers hebben dus een assymetrisch sleutelpaar nodig.

Het certificaat is een document waarin de publieke sleutel van iemand staat. Inhoud en structuur van dit document volgt de X.509-standaard. Ze worden vaak opgeslagen in PEM-formaat.

De publieke sleutel van de CA kan natuurlijk ook vervalst worden. Daarom krijgen deze sleutels ook een (self-signed) certificaat dat geïnstalleerd wordt met de programma's die de certificaten kunnen gebruiken (vb. webbrowser, SSH clients, etc.). Als je een eigen CA gebruikt, moet je die manueel toevoegen.

## Certificaat aanvragen

1. Gebruiker genereert een certificate signing request (CSR) waarin de publieke sleutel en informatie over de gebruiker staat.
2. CA ontvangt de CSR en controleert de identiteit van de gebruiker.
3. CA creëert het certificaat en ondertekent het met de publieke sleutel.

Als het certificaat aangepast wordt, wordt de ondertekening ongeldig.

## Certificaat verifiëren

Je stuurt best je certificaat door i.p.v. een publieke sleutel -> het certificaat bevat de publieke sleutel en de handtekening van de CA.

Je checkt eerst de geldigheid van het certificaat via de publieke sleutel van de CA. Indien geldig, is de publieke sleutel legitiem. Als de handtekening niet geldig is, is er waarschijnlijk sprake van een man-in-the-middle-attack.

# Toepassingen

## HTTPS

Bij HTTP werd al het webverkeer in plaintext verstuurd.

HTTPS combineert eigenlijk HTTP met TLS/SSL. TLS of SSL wordt gebruikt om certificaten te versturen. De payload kan dan geëncrypteerd en gedecrypteerd worden.

HTTPS verzekert niet sowieso de veiligheid. Het verzekert enkel dat:

- er geen man-in-the-middle is.
- de verbinding geëncrypteerd is.

Malware en gevaarlijke downloads worden dus niet tegengehouden.

## VPN

= een geëncrypteerde 'tunnel' die beveiligde communicatie over het netwerk garandeert.

Wordt vooral gebruikt om twee verschillende geografishe locaties te linken. Ook veel voor work@home. Andere belangrijke redenen om voor een VPN te kiezen zijn privacy en geo-restricties.

Net zoals bij HTTPS gebruiken VPN's TLS/SSL-certificaten.

Er bestaan ook consumer VPN services (reclames op YouTube) -> vraag is of ze wel doen wat ze beloven.

**Kritische noten**:

- Geen oneindige privacy: De VPN-server ziet alles (en is eigenlijk vergelijkbaar met een man-in-the-middle)
- Je moet de VPN-provider vertrouwen: Wat is de logging policy? Wat gebeurt er met de data?
- VPN-services moeten meewerken met justitie.

Samengevat:

- Zonder VPN: De ISP ziet alles. De website ziet wie je bent.
- Met VPN: De ISP ziet enkel een geëncrypteerde verbinding met de VPN. De VPN-service ziet alles. De website ziet welke VPN-service er verbinding maakt.
