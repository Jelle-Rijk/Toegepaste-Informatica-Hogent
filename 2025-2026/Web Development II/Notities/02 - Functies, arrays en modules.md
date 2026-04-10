<h1>Functies, arrays en modules</h1>

# Functies

**Functie declaratie**

```javascript
function functionName(parameter = "something") {
  let returnValue = parameter;
  return returnValue;
}

let value = functionName(); // value = "something"
let value2 = functionName("Blabla"); // value2 = "Blabla"
```

Als een parameter geen default waarde heeft en de call geen waarde doorgeeft voor die parameter, krijgt de parameter `undefined` als waarde.

Rest parameters `(...paramName)` stellen een onbeperkt aantal parameters voor in array-vorm. Je kan dit enkel als laatste parameter gebruiken.

Als je `undefined` meegeeft als argument aan een parameter met een default value, wordt deze op de default value ingesteld.

Functies zijn pass by value -> de waarden van argument doorgegeven aan een kopie in de parameter = zelfde als Java.

Functies worden [gehoist](#hoisting).

Je kan functies toewijzen aan een variabele. Dit heet een **functie expressie**.

```javascript
const zegHallo = function () {
  console.log("Hallo!");
};

zegHallo(); // Print "Hallo!" naar de console.

// Dit kan ook met de arrow notatie
const zegVaarwel = (naam) => console.log(`Hallo ${naam}!`);
```

## Globale functions en properties

Al bekend: `isNaN()`, `parseInt()`, `parseFloat()`

globalThis -> globale object (in browser hetzelfde als de window)

Methodes en properties van globalThis, moeten niet voorafgegaan worden door globalThis(). Voorbeelden hiervan zijn: `alert()`, `confirm()`, `prompt()` `console`. Lijken daardoor sterk op built-in functions.

## Functies als objects

In JS zijn functies **first class objects**. Dat betekent dat je ze at run-time kan maken, dat je functies kan returnen uit andere functies en dat je ze ook kan gebruiken als functieargumenten.

Je kan daardoor ook functies (inner functions) definiëren in een andere functie (outer function).

# Hoisting

Hoisting -> mechanisme in JS dat declaraties naar de top van hun scope verplaatst.

Je kan dus variabelen gebruiken die pas later gedeclareerd worden.

Elementen die gehoist worden:

- functies
- let / const

> Let/const hoisten
>
> Als je een globale let/const hebt en een lokale let/const, kan je binnen de lokale code de globale variabele niet gebruiken omdat de lokale variabele al gehoist is binnen de lokale scope. Je kan de waarde van de lokale variabele pas gebruiken na declaratie.
>
> Concreet: Binnen lokale scope kan je een lokale variabele pas gebruiken na declaratie.

# Arrays

= geordende verzameling element

Arrays in JavaScript:

- mogen van datatype verschillen
- kunnen groeien en krimpen

Syntax:

```javascript
// Declaraties
const pizzas = [pizza1, pizza1];
const drankjes = new Array(drankje1, drankje2);

// Toewijzen
pizza[0] = anderePizza;
pizza[2] = nieuwePizza;

// Lengte
let aantalPizzas = pizzas.length;

// Loopen
for (const pizza of pizzas) {
  console.log(pizza);
}

// Functies
const laatstePizza = pizzas.pop(); // verwijdert laatste, returnt verwijderde element
let lengteVanPizzaArray = pizzas.push(laatstePizza); // voegt toe als laatste, returnt lengte
const eerstePizza = pizzas.shift(); // verwijdert eerste, returnt verwijderde element
lengteVanPizzaArray = pizzas.unshift(eerstePizza); // voegt toe als eerste, returnt lengte

// Element 3 verwijderen
delete pizzas[2];

// Index vinden
const gevondenIndex = pizzas.indexOf(anderePizza);

// Destructuring
const desserts = ["Ijs", "Milkshake", "Taart", "Snoep"];
const [eersteDessert, tweedeDessert] = desserts;
const [, , derdeDessert] = desserts;
const gekozenDesserts = ["Taart"];
const [dessert1, dessert2 = "Ijs"] = gekozenDesserts; // dessert1 = Taart, dessert2 = Ijs

// Swappen met destructuring
let a = 1;
let b = 2;
[a, b] = [b, a];
console.log(a); // 2
console.log(b); // 1
```

Sommige functies **muteren** de array (reverse(), splice()), er bestaan kopiërende versies van deze functies (toReversed(), toSpliced()).

# Module

Module = JS-bestand dat ook in andere JS-bestanden gebruikt kan worden.

- export: variabelen, functies, klassen worden toegankelijk buiten de module
- import: haalt functionaliteiten uit een andere module

Exporterende module:

```javascript
export function sayHi(user) {
  console.log(`Hello, ${user}!`);
}
```

Importerende module:

```javascript
import { sayHi } from "./pad/naar/module.js";
sayHi("John"); // Print "Hello, John!" naar de console.
```

Modules zijn altijd in strict mode. Ze hebben een eigen top scope. Een module wordt maar één keer geëvalueerd (bij importeren);

Export kan voor de declaraties gebruikt worden, of later om een lijst van geëxporteerde functionaliteiten samen te stellen.

```javascript
const user1 = "Bob";
const user2 = "Alice";

export { user1, user2 };
```

Je kan bij imports alles importeren met `import * from ...`. Je kan zowel bij import als export een alias opgeven `import {sayHi as hi} from...` / `export {sayHi as hi}`.

Je kan ook een default export definiëren, bij importeren gebruik je dan geen accolades. (export: `export default class User {uitgewerkte klasse}` / import: `import User from ./user.js`)
