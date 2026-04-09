<h1> De basics </h1>

# Architectuur

Server stuurt HTML, CSS en JS data door. Het is de client die het uitvoert = host environment.

Non-browser environments = Node.js, Adobe Acrobat, CouchDB

Browsers bevatten een JS engine die de JS runt en een rendering engine die het resultaat visueel toont:

| Browser(s)     | Rendering | JS             |
| -------------- | --------- | -------------- |
| Chrome en Edge | Blink     | V8             |
| Firefox        | Gecko     | SpiderMonkey   |
| Safari         | WebKit    | JavaScriptCore |

# Structuur van code

Statements worden gescheiden met ;

JavaScript heeft een **strict mode** -> extra exceptions, betere optimalisatie in de engine, syntax die nog niet in ECMAScript opgenomen is wordt verboden. <br>
Enablen door `'use strict';` bovenaan het script te zetten.

(Binnen web dev II -> altijd vanuit gaan dat strict mode gebruikt wordt)

JS is hoofdlettergevoelig.

`let` -> variabele verklaren <br>
`const` -> constante verklaren <br>
`var` -> verouderd, maar vergelijkbaar met let (werkt in andere scope)

Const krijgt de voorkeur.

## Conventies

| Element   | Casing      |
| --------- | ----------- |
| variabele | camelCasing |

# Datatypes

Variabelen zijn dynamically typed -> het type kan wijzigen tijdens runtime <br>
JS is loosely typed -> veel impliciete typeconversies

## Basistypes

- number = getallen
- bigint = extreem grote getallen (aangeduid met suffix n)
- string = tekst
- boolean = true/false
- null = ongekende waarde (opmerking: `typeof null` returnt `object`)
- undefined = niet toegekende waarden -> wordt gereturnd door functies die geen waarde returnen
- object
- symbol = unieke identifiers -> buiten scope van webdev II

### number

Precies tot 17 cijfers na de komma.

Integer literals:

- decimaal -> gewoon schrijven
- prefix 0x -> hexadecimaal
- prefix 0o -> octaal
- prefix 0b -> binair

Floating point literals (drie opties):

- 3.14
- .33333
- 6.02e23 (wetenschappelijke notatie)

Speciale waarden:

- NaN = Not a Number -> kan gecheckt worden met `isNan()`
- Infinity / -Infinity = buiten bereik van Number -> kan gecheckt worden met `isFinite()`

Conversie van string:

- `parseInt(string [,radix])` -> radix is optioneel (geen radix = decimaal), negeert leading spaces.
- `parseFloat(string)`

### boolean

true / false -> zonder hoofdletter.

Returnen true -> true, niet-lege string, getal dat niet 0 is, elk object <br>
Returnen false -> false, lege string, 0, NaN, null, undefined

### string

- Escape sequence -> `\`
- Concatenatie -> `+`
- Conversie naar string -> `variabele.toString()` -> geeft een exception als de variabele null is.
- Template literals: tussen <code>``</code>, expressies tussen <code>${}</code>

char bestaat niet.

## Wrappers

-> Objecten die primitieve datatypes omsluiten (zoals in Java)

Ze voegen extra properties en methodes toe.

JS converteert een primitief datatype naar een wrapperobject als je een van de functies aanroept.

Je kan de wrapperobjecten gebruiken om te typecasten (vb. `String(12)` -> `"12"`)

# Math- & Date-objecten

Math: Bevat wiskundige constanten en functies.
Date: Datum in milliseconden sinds 1/1/1970 UTC

Date constructor:

- **new Date(jaar, maand, dag, uur, minuut, seconde, milliseconde)**
- jaar = 4 cijfers
- maand = 0-based -> tussen 0 en 11

# Controlestructuren

Identiek aan Java:

- if / else
- while / do while
- for-loop
- continue / break

Switch:

```javascript
const d = new Date();
const day = d.getDay();
switch (day) {
  case 5:
    console.log("It's Friday");
    break; // altijd gebruiken na de case, anders runt alle code in switch statement
  case 6:
    console.log("It's Saturday");
    break;
  case 0:
    console.log("It's Sunday");
    break;
  default:
    console.log("I long for the weekend...");
}
```

# Speciale operatoren

Berekeningen:

- Unary + -> Converteert een variabele (vb. string) naar een number of NaN (syntax: `+object`)
- Unary - -> Converteert een variabele naar een negatief getal. (syntax: `-object`)

Vergelijkingen:

- == -> inhoud wordt vergeleken, type wordt niet gecontroleerd (= impliciete typeconversie)
- === -> type wordt ook gecontroleerd (meestal deze gebruiken -> best practice)

Logische operator:

- ?? (nullish coalescing operator) -> returnt rechterdeel als linkerdeel null of undefined is, anders rechterdeel (syntax: `a ?? b` -> returnt b als a null of undefined is, anders a) <br> ?? kan gechaind worden -> eerste gedefinieerde waarde wordt gereturnd (syntax: `a ?? b ?? c`)

Verschil ?? en || -> || ziet ook 0, "" en false als ongeldig

# Debugging

Via console in browser.

Open via: Dev Tools -> Sources -> .js-file die je wil debuggen

In script komen foutmeldingen te staan, rechterpaneel bevat call stack, step-through, etc. <br>
Blauwe pijlen in script = breakpoints

- step: Stap voor stap verdergaan in script.

# Nuttige links

- [Compatibility table voor features per browser](https://compat-table.github.io/compat-table/es2016plus/)
