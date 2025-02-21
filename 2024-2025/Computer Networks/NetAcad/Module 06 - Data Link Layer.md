# Data Link Layer
- [Doel van de Data Link Layer](#data-link-layer)
- [Topologieën](#topologieën)
- [Data Link Frame](#data-link-frame)

## Doel van de Data Link Layer

- Geeft toegang voor de upper layers aan het fysieke medium.
- Beheert de manier waarop data op het fysieke medium wordt geplaatst.
- Voert foutdetectie uit.

### IEEE 802 LAN/MAN Data Link Sublayers (WIP)
Deze standaard is specifiek voor Ethernet LAN, WLAN, WPAN (Wireless Personal Area Networks). Het schrijf twee sublagen voor:
- Logical Link Control (LLC): Communiceert tussen de hogere softwarelagen en de lagere hardwarelaag. Het voegt de Layer 2 data toe aan het packet.
- Media Access Control (MAC): Implementeert deze laag in de hardware. Het bestuurt de NIC.

In de MAC sublaag wordt de data ook verder ingekapseld met:
- Frame delimiters: Bepaalde tekens geven het begin en einde van een veld in het frame aan.
- Addressing: Source en destination address voor devices op hetzelfde medium.
- Error detection: Voegt data toe voor foutdetectie aan het einde van de frame.

### Toegang verschaffen tot media (WIP)

Een packet kan hops maken wanneer het een pad volgt. Bij elke hop die niet tussen twee serial links is, doet de MAC het volgende in layer 2:
- Aanvaardt het frame
- Ontkapselt het frame
- Kapselt het frame opnieuw in
- Stuurt het nieuwe frame opnieuw door


## Topologieën

## Data Link Frame