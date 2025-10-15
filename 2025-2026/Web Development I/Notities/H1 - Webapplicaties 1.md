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
- Internal style sheet (in `<style>`-element in `<head>`)
- Via style attribuut van een element (enkel van toepassing op dat specifieke element)

## Termen

- selector: kiezen van de beïnvloede elementen
- declaration: is een stijlregel in de vorm `property:value;`
- declaration block: de verzameling stijlregels tussen {}

- user agent stylesheet: De stylesheet die door de browser gebruikt wordt.
- user stylesheet: Stylesheet die door gebruikers zelf toegepast wordt (komt niet vaak voor)
- author stylesheet: Stylesheet die je zelf schrijft

## Cascade en inheritance

De author stylesheet krijgt voorrang op de user agent stylesheet.

Als beide regels uit dezelfde categorie stylesheet (author of user agent) komen, dan krijgt de specifiekere selector voorrang.

Tekst- en lijstgerelateerde stijlregels worden door descendants overgeërfd. Met de value `inherit` kan je andere stijlregels ook laten erven.

Welke regel er toegepast wordt in de cascade is afhankelijk van de importance, origin en specificity (in die volgorde)

Je kan het keyword `!important` gebruiken na een stijlregel om deze voorrang te geven.

Voorrangsregels (belangrijk naar minder belangrijk):

- Important user agent
- Important user
- Important author
- Normal author
- Normal user
- Normal user agent

Is de importance en origin hetzelfde, dan wint de selector met de hoogste specificity bepaald door een waarde in de vorm (0, 0, 0):

- eerste getal: Aantal ID selectors
- tweede getal: Aantal class, attribute of pseudo-class selectors
- derde getal: Aantal type selectors en pseudo-elements

Bij zelfde specificity wint de regel die het laatste gedeclareerd is.

### Hoe de browser CSS verwerkt

HTML-elementen worden eerst ingeladen en in de DOM tree gezet. Daarna checkt de browser welke waarde elke CSS-property elk element moet hebben. De browser gebruikt volgende info (gerangschikt naar voorrang)

1. Een toegekende waarde (bij meerdere treden de cascading regels in werking)
2. Een overgeërfde waarde
3. Een initial value

## Properties

[Overzicht van emmet-afkortingen](https://docs.emmet.io/cheat-sheet/)

| Naam             | Gebruik                                        |
| ---------------- | ---------------------------------------------- |
| background-color | achtergrondkleur                               |
| background-image | achtergrondafbeelding                          |
| list-style-\*    | Zaken die te maken hebben met opsommingstekens |

### Tekst

| Naam            | Gebruik                        |
| --------------- | ------------------------------ |
| font-family     | lettertype                     |
| font-size       | lettergrootte                  |
| text-transform  | Hoofdlettergebruik aanpassen   |
| text-decoration | Onderlijnen, doorstrepen, etc. |
| letter-spacing  | Afstand tussen letters         |
| word-spacing    | Afstand tussen woorden         |
| text-indent     | Inspringing eerste regel       |
| text-align      | Uitlijnen                      |

Je kan fonts via CSS als volgt van een server laden:

```css
@font-face {
  font-family: naam_van_font;
  src: url(pad/naar/font.ttf);
}

h1 {
  font-family: naam_van_font;
}
```

## Selectors

| Notatie        | Gebruik                                                                | Opmerking                                                                    |
| -------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `div`          | Alle elementen van een type                                            |
| `.class-name`  | Alle elementen van een klasse                                          |
| `#id`          | Specifiek element met id                                               |
| `div, .class1` | Meerdere selectors                                                     | komma                                                                        |
| `*`            | Alles                                                                  |
| `div p`        | Alle p-elementen die afstammen van een div                             | = Descendant combinator                                                      |
| `div > p`      | Alle p-elementen die directe children zijn van een div                 |
| `img ~ p`      | Alle p-elementen die na een img komen waarmee ze een parent delen      | = General sibling combinator                                                 |
| `ìmg + p`      | Alle p-elementen die vlak na een img komen waarmee ze een parent delen | = Adjacent sibling combinator                                                |
| `a[href]`      | Alle a-elementen die een attribuut href hebben                         | exacte waarde: [attr=value], bevat: [attr*=value], begint met: [attr^=value] |

Pseudo-classes (altijd beginnen met :)

| Notatie                 | Toestand                                             |
| ----------------------- | ---------------------------------------------------- |
| `a:link`                | niet bezochte link                                   |
| `a:visited`             | bezochte link                                        |
| `a:active`              | actieve link                                         |
| `a:hover`               | gehoverde link                                       |
| `p:first-child`         | p-elementen die een eerste child zijn van hun parent |
| `p:last-child`          | p-elementen die de laatste child zijn van hun parent |
| `p:only-child`          | p-elementen die het enige child zijn van hun parent  |
| `p:first-of-type`       | eerste p-element                                     |
| `p:last-of-type`        | laatste p-element                                    |
| `p:only-of-type`        | enige p-element                                      |
| `:nth-child(n)`         | elk n-de child                                       |
| `:nth-last-child(n)`    | elk n-de child van achter te beginnen                |
| `p:nth-of-type(n)`      | n-de p-element                                       |
| `p:nth-last-of-type(n)` | n-de p-element van achter te beginnen                |
| `:empty`                | leeg element                                         |

![CSS: Hoe n definiëren in selector](./img/opties-css-n.png)

Pseudo-elementen (altijd beginnen met ::)

| Notatie          | Gebruik                    |
| ---------------- | -------------------------- |
| `::first-line`   | eerste regel van element   |
| `::first-letter` | eerste letter van element  |
| `::before`       | voor de inhoud van element |
| `::after`        | na de inhoud van element   |

## Handige info

### Shorthands

Shorthands stellen niet-vermelde properties in op hun standaardwaarden. Als je een shorthand property opgeeft na een longhand property, dan overschrijft de default-waarde dus de eerder gedefinieerde waarde.

```css
. {
  background-color: red;
  background: url(...) no-repeat left top;
  /* Eerste weggelaten waarde in background is de background-color en die zal nu transparant zijn */
}
```

### Achtergronden

Als je een afbeelding als achtergrond instelt, is het handig om toch nog een achtergrondkleur in te stellen, zo blijft het contrast behouden als de afbeelding niet inlaadt.

Shorthand = `background: color image-url repeat position (vb. background: #000 url(images/bg.gif) no-repeat left top)`

### Lettertype

De fallback fonts zijn:

![De fallback fonts](./img/fallback-fonts.png)

Voorbeelden van Websafe fonts: Arial, Times New Roman

Default font size = 16px

Lettergrootte kan je instellen met:

- absolute groottes: xx-small, x-small, small, medium (default), large, x-large, xx-large
- relatieve grootte: larger / smaller (dan parent)
- lengtematen (vb. pixels)
- percentage

Best om met em/rem en percentages te werken.

1 em = grootte van letter M in een font.

em -> relatieve grootte t.o.v. parent element <br>
rem -> relatieve grootte t.o.v. root

Line-height gewoonlijk op 1.5 (= 1.5 \* font-size) voor doorlopende teksten.

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

# Interessante links

## CSS

Algemeen:

- [MDN - Overzicht selectors](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_selectors)

Kleuren:

- [CSS Gradient - gradients testen](https://cssgradient.io/)
- [Kleurenthema's van Adobe](https://color.adobe.com/nl/)
- [MDN - Using color wisely](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_colors/Using_color_wisely)
- [Khan Academy - Pixar Color Science Course](https://www.khanacademy.org/computing/pixar/color)

  Tekst:

- [MDN - Web Safe Fonts](https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Text_styling/Fundamentals#web_safe_fonts)
- [Google Fonts](https://fonts.google.com/)
- [Font Squirrel](https://www.fontsquirrel.com/)
- [Font Pair](https://fontpair.co/)
