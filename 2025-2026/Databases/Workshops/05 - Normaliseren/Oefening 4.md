<h1>Oefening 4 - Verhuurkantoor</h1>

# Functionele Afhankelijkheden:​

- postcode → woonplaats (= stad), opcentiemen
- eigenaarNN, volgnummer → eigenaarnaam, straatPand, stadPand, postcodePand, huurprijsPand, opcentiemen
- NN → naam, straat, woonplaats, postcode, beroep, maandinkomen
- eigenaarNN, huurderNN, volgnummer → begindatumHuurcontract, huurdernaam, postcodeStadOndertekening, naamStadOndertekening, notarisNN, notarisnaam
- eigenaarNN, volgnummer, datum → oorzaak, afhandelingsprocedure
- oorzaak → afhandelingsprocedure

# 1NV

- R11(<u>eigenaarNN</u>, eigenaarnaam, eigenaarstraat, eigenaarwoonplaats,eigenaarpostcode, eigenaarberoep)
- R12(<u>eigenaarNN, volgnummer</u>, straatPand, stadPand, postcodePand, huurprijsPand, opcentiemen)
- R13(<u>huurderNN</u>, huurdernaam, huurderstraat, huurderwoonplaats, huurderpostcode, huurdermaandinkomen)
- R14(<u>eigenaarNN, huurderNN, volgnummer</u>, begindatumHuurcontract, postcodeStadOndertekening, naamStadOndertekening, notarisNN, notarisnaam)
- R15(<u>eigenaarNN, volgnummer, datum</u>, oorzaak, afhandelingsprocedure)

# 2NV

- R21(<u>eigenaarNN</u>, eigenaarnaam, eigenaarstraat, eigenaarwoonplaats,eigenaarpostcode, eigenaarberoep)
- R22(<u>eigenaarNN, volgnummer</u>, straatPand, stadPand, postcodePand, huurprijsPand, opcentiemen)
- R23(<u>huurderNN</u>, huurdernaam, huurderstraat, huurderwoonplaats, huurderpostcode, huurdermaandinkomen)
- R24(<u>eigenaarNN, huurderNN, volgnummer</u>, begindatumHuurcontract, postcodeStadOndertekening, naamStadOndertekening, notarisNN, notarisnaam)
- R25(<u>eigenaarNN, volgnummer, datum</u>, oorzaak, afhandelingsprocedure)

= Zelfde

# 3NV

- R31(<u>eigenaarNN</u>, eigenaarnaam, eigenaarstraat, eigenaarpostcode, eigenaarberoep)
- R32(<u>eigenaarNN, volgnummer</u>, straatPand, postcodePand, huurprijsPand)
- R33(<u>huurderNN</u>, huurdernaam, huurderstraat, huurderpostcode, huurdermaandinkomen)
- R34(<u>eigenaarNN, huurderNN, volgnummer</u>, begindatumHuurcontract, postcodeStadOndertekening, notarisNN)
- R35(<u>eigenaarNN, volgnummer, datum</u>, oorzaak)
- R36(<u>oorzaak</u>, afhandelingsprocedure)
- R37(<u>postcode</u>, stad, opcentiemen)
- R38(<u>notarisNN</u>, notarisnaam)

# Relationeel model

- Persoon(<u>NN</u>, naam, straat, postcode, beroep, maandinkomen)
  - IR: postcode verwijst naar Stad, optioneel
- Stad(<u>postcode</u>, naam, opcentiemen)
- Schadeoorzaak(<u>oorzaak</u>, afhandelingsprocedure)
- Pand(<u>eigenaarNN, volgnummer</u>, straat, postcode, huurprijs)
  - IR: eigenaarNN verwijst naar Eigenaar, verplicht
- Huurcontract(<u>eigenaarNN, huurderNN, volgnummer</u>, begindatum, postcodeStadOndertekening, notarisNN)
  - IR: eigenaarNN, volgnummer verwijst naar Pand, verplicht
  - IR: huurderNN verwijst naar Persoon, verplicht
  - IR: notarisNN verwijst naar Persoon, optioneel
  - IR: postcodeStadOndertekening verwijst naar Stad.postcode, optioneel
- Schadegeval(<u>eigenaarNN, volgnummer, datum</u>, oorzaak)
  - IR: eigenaarNN, volgnummer verwijst naar Pand, verplicht
  - IR: oorzaak verwijst naar Schadeoorzaak, optioneel
