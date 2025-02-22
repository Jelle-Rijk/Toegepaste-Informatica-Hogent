# Data Link Layer
- [Doel van de Data Link Layer](#data-link-layer)
- [Topologieën](#topologieën)
- [Data Link Frame](#data-link-frame)

## Doel van de Data Link Layer

- Geeft toegang voor de upper layers aan het fysieke medium.
- Beheert de manier waarop data op het fysieke medium wordt geplaatst.
- Voert foutdetectie uit.

### IEEE 802 LAN/MAN Data Link Sublayers

Deze standaard is specifiek voor Ethernet LAN, WLAN, WPAN (Wireless Personal Area Networks). Het schrijft twee sublagen voor:
- Logical Link Control (LLC): Communiceert tussen de hogere softwarelagen en de lagere hardwarelaag. Het voegt de Layer 2 data toe aan het packet.
- Media Access Control (MAC): Implementeert deze laag in de hardware. Het bestuurt de NIC.

In de MAC sublaag wordt de data ook verder ingekapseld met:
- Frame delimiters: Bepaalde tekens geven het begin en einde van een veld in het frame aan.
- Addressing: Source en destination address voor devices op hetzelfde medium.
- Error detection: Voegt data toe voor foutdetectie aan het einde van de frame.

<video controls>
<source src="https://www.youtube.com/watch?v=BOkH_B_8rcs"/>
https://www.youtube.com/watch?v=BOkH_B_8rcs</video>

### Toegang verschaffen tot media

De MAC sublayer voorkomt "botsingen" op het netwerk. Dit is niet nodig bij serial links.

Een packet kan hops maken wanneer het een pad binnen een lokaal netwerk volgt. Bij elke hop doet de MAC het volgende:
- Aanvaardt het frame
- Ontkapselt het frame
- Kapselt het frame opnieuw in
- Stuurt het nieuwe frame opnieuw door


## Topologieën

## Data Link Frame