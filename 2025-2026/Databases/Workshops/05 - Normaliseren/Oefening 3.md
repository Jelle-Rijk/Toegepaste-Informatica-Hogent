<h1>Oefening 3 - Leveranciers</h1>

# 0NV + FA

- R0 (lnr, naam, adres, (onderdeelnr, beschrijving, (klantID, klnaam, kladres, hoeveelheid)_)_)
  - naam en klnaam zijn samengesteld uit voornaam en familienaam
  - adres en kladres zijn samengesteld uit straat, huisnr, postcode, woonplaats

Functionele Afhankelijkheden:​

- lnr → naam, adres
- lnr, onderdeelnr → beschrijving
- lnr, onderdeelnr, klantID → klnaam, kladres, hoeveelheid
- klantID → klnaam, kladres

# 1NV

R1.1(<u>lnr</u>, voornaam, familienaam, straat, huisnr, postcode, woonplaats)

R1.2(<u>lnr</u>, <u>onderdeelnr</u>, beschrijving)

R1.3(<u>lnr, onderdeelnr, klantId</u>, klvoornaam, klfamilienaam, klstraat, klhuisnr, klpostcode, klwoonplaats, hoeveelheid)

# 2NV

R2.1(<u>lnr</u>, voornaam, familienaam, straat, huisnr, postcode, woonplaats)

R2.2(<u>lnr</u>, <u>onderdeelnr</u>, beschrijving)

R2.3(<u>lnr, onderdeelnr, klantId</u>, hoeveelheid)

R2.4(<u>klantId</u>, klvoornaam, klfamilienaam, klstraat, klhuisnr, klpostcode, klwoonplaats)

# 3NV

Zelfde

# Relationeel model

Leverancier(<u>lnr</u>, voornaam, familienaam, straat, huisnr, postcode, woonplaats)

Onderdeel(<u>lnr</u>, <u>onderdeelnr</u>, beschrijving) <br>
_IR: lnr verwijst naar Leverancier, verplicht_

Onderdeel_Klant(<u>lnr, onderdeelnr, klantId</u>, hoeveelheid) <br>
<i>IR: lnr verwijst naar Leverancier, verplicht<br>IR: klantId verwijst naar Klant, verplicht</i>

Klant(<u>klantId</u>, klvoornaam, klfamilienaam, klstraat, klhuisnr, klpostcode, klwoonplaats)
