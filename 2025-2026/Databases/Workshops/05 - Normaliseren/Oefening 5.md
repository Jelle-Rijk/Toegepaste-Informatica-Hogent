<h1>Oefening 5 - Biowinkel</h1>

# Opdracht 1

| Functioneel afhankelijk              | Ja / Neen | Reden                                                                                                    |
| ------------------------------------ | --------- | -------------------------------------------------------------------------------------------------------- |
| aflbonnr -> klantnr                  | Ja        | Als je de bon hebt, weet je ook wie de klant is, want er is maar één klant per bon.                      |
| aflbonnr -> bestelbonnr              | Neen      | Per afleverbon zijn er meerdere bestelbonnen.                                                            |
| aflbonnr, bestelbonnr -> besteldatum | Ja        | Als je de juiste bestelbon hebt, kan je de besteldatum zien.                                             |
| bestelbonnr, artnr -> aantal         | Ja        | Een artikel heeft een aantal per bon.                                                                    |
| klantnr, artnr -> besteldatum        | Neen      | Een klant kan op meerdere bestelbonnen of afleverbonnen hetzelfde artikel op verschillende datums kopen. |

# Opdracht 2

R0(aflbonnr, aflbondatum, klantnr, klantnaam, klantadres, (bestelbonnr, bestelbondatum(artikelnr, artikelomschrijving, aantal, prijs)\*)\*)

NV1:

- R11(<u>aflbonnummer</u>, aflbondatum, klantnr, klvoornaam, klachternaam, klstraat, klhuisnummer, klpostcode, klplaats)
- R12(<u>aflbonnr, bestelbonnr</u>, besteldatum)
- R13(<u>aflbonnr, bestelbonnr, artikelnr</u>, omschrijving, aantal, prijs)

# Opdracht 3

## a. Geef aan in welke normaalvorm elke uitdrukking staat en leg uit.

Normaalvorm X staat in de eerste normaalvorm:

- Er is nog een partiële afhankelijkheid (bestelbonnr, artnr -> aantal)

Normaalvorm Y staat in de nulde normaalvorm:

- De herhalende groepen werden geïdentificeerd
- Er werd een primaire sleutel voor het document bepaald
- De herhalende groepen zijn nog niet in een eigen tabel weggewerkt.

## b. Normaliseer elke normaalvorm tot en met de derde normaalvorm

**NORMAALVORM X**

- R11(<u>aflbonnr</u>, afldatum, klantnr, klvn, klfn, klstr, klhuisnr, klpc, klwnplaats)
- R12(<u>aflbonnr, bestelbonnr</u>)
- R13(<u>bestelbonnr</u>, besteldatum)
- R14(<u>aflbonnr, bestelbonnr, artnr</u>, aant)
- R15(<u>artnr</u>, artomschr, verkoopprijs)

1NV naar 2NV

- R21(<u>aflbonnr</u>, afldatum, klantnr, klvn, klfn, klstr, klhuisnr, klpc, klwnplaats)
- R22(<u>aflbonnr, bestelbonnr</u>)
- R23(<u>bestelbonnr</u>, besteldatum)
- R24(<u>aflbonnr, bestelbonnr, artnr</u>)
- R25(<u>artnr</u>, artomschr, verkoopprijs)
- R26(<u>bestelbonnr, artnr</u>, aant)

2NV naar 3NV

- R31(<u>aflbonnr</u>, afldatum, klantnr)
- R32(<u>klantnr</u>, klvn, klfn, klstr, klhuisnr, klpc, klwnplaats)
- R33(<u>aflbonnr, bestelbonnr</u>)
- R34(<u>bestelbonnr</u>, besteldatum)
- R35(<u>aflbonnr, bestelbonnr, artnr</u>)
- R36(<u>artnr</u>, artomschr, verkoopprijs)
- R37(<u>bestelbonnr, artnr</u>, aant)

**NORMAALVORM Y**

R0(<u>winkelnr</u>, winkelnaam, (bestelbonnr, besteldatum, (artnr, bestelAantal, omschrijving, aankoopprijs)\*)\*)

0NV naar 1NV:

- R11(<u>winkelnr</u>, winkelnaam)
- R12(<u>winkelnr, bestelbonnr</u>, besteldatum)
- R13(<u>winkelnr, bestelbonnr, artnr</u>, bestelAantal, omschrijving, aankoopprijs)

1NV naar 2NV:

- R21(<u>winkelnr</u>, winkelnaam)
- R22(<u>winkelnr, bestelbonnr</u>)
- R23(<u>bestelbonnr</u>, besteldatum)
- R24(<u>winkelnr, bestelbonnr, artnr</u>, bestelAantal, aankoopprijs)
- R25(<u>artnr</u>, omschrijving)

2NV naar 3NV:

- R21(<u>winkelnr</u>, winkelnaam)
- R22(<u>winkelnr, bestelbonnr</u>)
- R23(<u>bestelbonnr</u>, besteldatum)
- R24(<u>winkelnr, bestelbonnr, artnr</u>, bestelAantal, aankoopprijs)
- R25(<u>artnr</u>, omschrijving)

## Integreer tot 1 relationeel model

- Afleverbon(<u>aflbonnr</u>, afldatum, klantnr)
  - IR: klantnr verwijst naar Klant, verplicht.
- Klant(<u>klantnr</u>, klvn, klfn, klstr, klhuisnr, klpc, klwnplaats)
- Afleverbon_Bestelbon(<u>aflbonnr, bestelbonnr</u>)
  - IR: aflbonnr verwijst naar Afleverbon, verplicht
  - IR: bestelbonnr verwijst naar Bestelbon, verplicht
- Bestelbon(<u>bestelbonnr</u>, besteldatum)
- Bestelling(<u>aflbonnr, bestelbonnr, artnr</u>, aantal)
  - IR: aflbonnr verwijst naar Afleverbon, verplicht
  - IR: bestelbonnr verwijst naar Bestelbon, verplicht
  - IR: artnr verwijst naar artnr, verplicht
- Artikel(<u>artnr</u>, artomschr, verkoopprijs)
- Winkel(<u>winkelnr</u>, winkelnaam)
- Winkel_Bestelbon(<u>winkelnr, bestelbonnr</u>)
  - IR: winkelnr verwijst naar Winkel, verplicht
  - IR: bestelbonnr verwijst naar Bestelbon, verplicht
- Aankoop(<u>winkelnr, bestelbonnr, artnr</u>, bestelAantal, aankoopprijs)
  - IR: winkelnr verwijst naar Winkel, verplicht
  - IR: bestelbonnr verwijst naar Bestelbon, verplicht
  - IR: artnr verwijst naar Artikel, verplicht
