<h1> NOTITIES </h1>

# Algemeen

## Conventies

### Mappen en bestanden

Naamgeving:

- kleine letters -> Linux-paden zijn case-sensitive
- \- of \_ in plaats van spaties (Google raadt - aan => optimaal voor zoekrobot van Google)
- geen speciale karakters (sommige niet toegestaan, andere krijgen andere betekenis)

Structuur:

Opdelen in folders (liefst namen van één woord). Bij kleinere websites alle HTML-bestanden in de root. Bij grotere websites meestal een folder per menu-itum dat subpagina's bevat.
**De subfolders zijn te zien in de URL-structuur**

index.html altijd in de root

Resources in apparte mappen -> zoals "images", "css", "styles". Kan soms nog samen in een map "assets"

# HTML

## Cheatsheet

Reference voor alle HTML-elementen: https://developer.mozilla.org/en-US/docs/Web/HTML

### Generic

| Elementnaam                   | Tag                                                        | Opmerking    |
| ----------------------------- | ---------------------------------------------------------- | ------------ |
| Hyperlink                     | `<a href="link">`                                          |
| Afbeelding                    | `<img src="path" alt="alternatieve tekst">`                | void element |
| CSS Link                      | `<link rel="stylesheet" href="path">`                      |
| favicon voor pagina instellen | `<link rel="icon" href="favicon.ico" type="image/x-icon">` |

### Block elements

Algemeen element (als er geen specifieker bestaat): `<div>`

| Elementnaam                   | Tag             | Opmerking                            |
| ----------------------------- | --------------- | ------------------------------------ |
| Description / Definition list | `<dl>`          |
| Description Term              | `<dt>`          | Term in dl                           |
| Description Details           | `<dd>`          | Beschrijving in dl                   |
| Ordered list                  | `<ol type="i">` | type = i voor Roman numerals         |
| Lange citaten                 | `<blockquote>`  |
| Figuur met bijschrift         | `<figure>`      |
| Bijschrift bij figuur         | `<figcaption>`  | in `<figure>`                        |
| Contactinformatie             | `<address> `    |
| Pre-formatted                 | `<pre> `        | behoudt tabs, witruimte, etc in code |
| Scheiding                     | `<hr>`          |

### Inline elementen

Algemeen element (als er geen specifieker bestaat): `<span>`

| Elementnaam                  | Tag       | Opmerking                               |
| ---------------------------- | --------- | --------------------------------------- |
| Italic                       | `<em>`    | = emphasize                             |
| Aanvullende informatie       | `<small>` |
| Auteur of naam creatief werk | `<cite>`  |
| Kort citaat                  | `<q>`     | `<cite>` gebruiken om bron te vermelden |
| Afkorting                    | `<abbr>`  |
| Definitie                    | `<dfn>`   |
| Code                         | `<code>`  |
| Tijdstip of datum            | `<time>`  |
| Computeruitvoer              | `<samp>`  |
| Gebruikersinvoer             | `<kbd>`   | = keyboard                              |
| Foute informatie             | `<s>`     |
| Subscript                    | `<sub>`   |
| Superscript                  | `<sup>`   |
| Gemarkeerde tekst            | `<mark>`  |
| Toegevoegde inhoud           | `<ins>`   |
| Verwijderde inhoud           | `<del>`   |

### Tabellen

| Elementnaam      | Tag          | Opmerking                                                                             |
| ---------------- | ------------ | ------------------------------------------------------------------------------------- |
| Tabel            | `<table>`    |
| Tabelrij         | `<tr>`       |
| Cel met hoofding | `<th>`       | binnen een `<tr>`                                                                     |
| Cel met data     | `<td>`       | binnen een `<tr>`                                                                     |
| Tabel header     | `<thead>`    |
| Tabel body       | `<tbody>`    |
| Tabel footer     | `<tfoot>`    |
| Bijschrift       | `<caption>`  | Net na `<table>` invoegen                                                             |
| Kolomgroep       | `<colgroup>` | Hiermee kan je meerdere kolommen groeperen om ze bijvoorbeeld dezelfde stijl te geven |
| Kolom            | `<col>`      | Te gebruiken binnen een colgroup                                                      |

| Gebruik                       | Attribuut     |
| ----------------------------- | ------------- |
| Cel uitspreiden over kolommen | `colspan="2"` |
| Cel uitspreiden over rijen    | `rowspan="2"` |

Bij toevoegen van een border met CSS krijg je een dubbele rand. <br>
Oplossing: {border-collapse: collapse;}

### Formulieren

Na het klikken van de submit-button wordt elk onderdeel van het formulier als een name/value-pair naar de server gestuurd.

| Elementnaam             | Tag                                                          | Opmerking                                                                  |
| ----------------------- | ------------------------------------------------------------ | -------------------------------------------------------------------------- |
| Formulier               | `<form action="\order" method="post">`                       | action geeft de site aan waar de data naartoe gestuurd wordt               |
| Input                   | `<input type="text" name="naam" placeholder="voer hier in">` | zie types hieronder                                                        |
| Dropdown                | `<select>`                                                   | multiple om meerdere keuzes toe te laten, size om meerdere opties te tonen |
| Keuzeoptie              | `<option value="optie1">     `                               | Child van select                                                           |
| Knop                    | `<button>`                                                   |
| Label                   | `<label for="id-van-control">`                               | Je kan de control ook binnen het label zetten i.p.v. for te gebruiken      |
| Verzameling velden      | `<fieldset>`                                                 |
| Titel voor verzameling  | `<legend>`                                                   |
| Uitgebreide tekstinvoer | `<textarea>`                                                 |
| Vooruitgang             | `<process>`                                                  |
| Resultaat               | `<output>`                                                   |
| Schaal                  | `<meter>`                                                    |

Mogelijke types voor input:

- text
- password
- date
- email
- number (attributen min en max voor min- en max-waarden)
- search
- radio (de name van de buttons moet hetzelfde zijn, value attribuut is verplicht, checked attribuut kan een button op geselecteerd zetten)
- checkbox
- file (enctype="multipart/form-data" als attribuut bij de form toevoegen)
- list (verwijst naar een datalist met zelfde id als list-attribuut, waarin `<option>` elementen moeten zitten)

```html
<input list="bezorgers" id="bezorger" name="bezorger" />
<datalist id="bezorgers">
  <option value="Bezorger 1"></option>
  <option value="Bezorger 2"></option>
</datalist>
```

- textarea
- submit (value-attribuut is ook de tekst op de knop)
- image
- hidden (vb. voor security tokens)

Voeg attribuut `required` toe om control verplicht te maken.

### Speciale karakters

Named character references starten altijd met & en eindigen met ; <br>
Ze zorgen ervoor dat je speciale karakters in de browser kan weergeven.

| Literal character | Named character reference |
| ----------------- | ------------------------- |
| <                 | `&lt;`                    |
| >                 | `&gt;`                    |
| "                 | `&quot;`                  |
| '                 | `&apos;`                  |
| &                 | `&amp;`                   |

Sommige tekens zijn makkelijker met een named character reference omdat ze niet op een keyboard staan.

| Literal character  | Named character reference |
| ------------------ | ------------------------- |
| &copy;             | `&copy;`                  |
| non-breaking space | `&nbsp;`                  |
| soft hyphen        | `&shy;`                   |
| &plusmn;           | `&plusmn;`                |
| &mdash;            | `&mdash;`                 |

### Paginastructuur

Algemeen element (als er geen specifieker bestaat): `<section>`

| Elementnaam              | Tag         | Opmerking |
| ------------------------ | ----------- | --------- |
| Artikel                  | `<article>` |
| Hoofdnavigatie           | `<nav>`     |
| 'Zijdelingse' informatie | `<aside>`   |
| Koptekst                 | `<header>`  |
| Voettekst                | `<footer>`  |

## Handige info

### Globale attributen

class, id en lang zijn **globale attributen** = je kan ze op elk element gebruiken

lang gebruikt de volgende waarden voor de meest gangbare talen in België:

- en -> Engels (en-GB of en-US)
- fr -> Frans
- nl -> Nederlands

Voeg de standaardtaal toe aan het html-element

### Organisaties

Verantwoordelijk voor HTML5-ontwikkeling: World Wide Web Consortium (= W3C) en WHATWG

### Link elementen

Kunnen absolute en relatieve paden gebruiken

- geen href -> niets bij klikken
- href="" -> huidige pagina wordt opnieuw geladen
- href="#" -> naar boven springen

> UX tip <br>
> Onderstreep tekst niet als het geen hyperlink is.

#### Speciale hyperlinks

| Gebruik                    | Attribuut                                              |
| -------------------------- | ------------------------------------------------------ |
| Nieuw tabblad              | `target="_blank"`                                      |
| E-mail                     | `href="mailto:address@mailbox.com"`                    |
| E-mail met onderwerp       | `href="mailto:user@mailbox.com?subject=Hallo"`         |
| Bellen                     | `href="tel:+32123456789"`                              |
| SMS                        | `href="sms:+32123456789"`                              |
| PDF tonen                  | `href="./pad/naar/bestand.pdf"`                        |
| Bestand downloaden         | `href="./pad/naar/bestand.pdf" download="bestandnaam"` |
| Linken naar element met id | `href="pagina.html#id"`                                |

### Afbeeldingen

Het title-attribuut zorgt voor een tooltip.

> UX tip <br>
> Gebruik thumbnails zodat gebruikers niet alle grote afbeeldingen moeten downloaden

## Termen

- Void element: Element zonder end tag (vb. `<br>`)
- Block element: Start op een nieuwe regel en neemt volledige breedte in
- Inline element: Start niet op een nieuwe regel, neemt enkel de nodige breedte in

## Conventies

# CSS

= Cascading Style Sheets

Kan toegevoegd worden op drie manieren:

- External style sheet (in eigen bestand)

## Termen

- selector: kiezen van de beïnvloede elementen
- declaration: is een stijlregel in de vorm `property:value;`
- declaration block: de verzameling stijlregels tussen {}

## Properties

[Overzicht van emmet-afkortingen](https://docs.emmet.io/cheat-sheet/)

| Naam             | Emmet | Gebruik          | Opmerking |
| ---------------- | ----- | ---------------- | --------- |
| font-family      | ff    | lettertype       |
| background-color | bgc   | achtergrondkleur |
| font-size        | fz    | lettergrootte    |

## Selectors

| Notatie        | Gebruik                       | Opmerking |
| -------------- | ----------------------------- | --------- |
| `div`          | Alle elementen van een type   |
| `.class-name`  | Alle elementen van een klasse |
| `#id`          | Specifiek element met id      |
| `div, .class1` | Meerdere selectors            | komma     |

# Visual Studio Code tips

## Hotkeys

CTRL + : -> Commentaar

## HTML-specifiek

Met emmet expansion kan je de naam van een html-element of css property beginnen invoeren en op tab drukken. Dan wordt basisinformatie aangevuld.

| Combinatie    | Gebruik                          |
| ------------- | -------------------------------- |
| ! + TAB       | Boilerplate `<head>` en `<body>` |
| CTRL + Spatie | Suggesties weergeven             |
| CTRL + :      | Commentaar                       |
