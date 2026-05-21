<h1>Asynchroon programmeren in JS</h1>

# Synchronous vs Asynchronous

Synchroon programmeren = alle statements van boven naar onder, wachten tot vorige statement uitgevoerd is om volgende te starten.

Asynchroon programmeren = andere code al uitvoeren terwijl het programma op een reactie wacht

Synchroon is blocking (=> werkt op één thread, waardoor de UI unresponsive wordt bij lange berekeningen)

# AJAX

Is een afkorting => Asynchronous JavaScript And XML

Maakt gebruik van XMLHttpRequest om asynchroon data op te vragen en de DOM te updaten. (vb. suggesties bij zoeken op Google).

Tegenwoordig wordt JSON vaak gebruikt om data terug te sturen naar de browser, vroeger was dit XML.

Typisch probleem: Er is nog geen data om bewerkingen uit te voeren.

```javascript
// Een XMLHttpRequest uitvoeren
const xhr = new XMLHttpRequest();
xhr.open("GET", "../pad/naar/data"); // GET request
xhr.send(); // asynchrone opdracht
```

Je kan alle info over de XHR zien in de developer tools onder "Networks"

# Callbacks

Oudere manier om de problemen binnen asynchroon programmeren op te lossen.

```javascript
const xhr = new XMLHttpRequest();
xhr.open("GET", "../pad/naar/data"); // GET request
xhr.send(); // asynchrone opdracht

xhr.onload = () => {
  console.log("De data is terug!");
}; // Deze callback wordt pas uitgevoerd wanneer de data terug binnen is.

console.log("blablabla"); // -> deze code wordt al uitgevoerd voordat de data binnen is.
```

Probleem met callbacks is de pyramid of doom (= callback hell) -> Callbacks in callbacks in callbacks... + Als je twee asynchrone operaties moet uitvoeren alvorens een derde op te starten, krijg je problemen.

# Promises en de Fetch API

Promises (= futures in Java en C++) => lost enkele problemen met callbacks op.

Je houdt de toestand en het resultaat van async operaties bij in een promise-object.

-> Promise-objecten hebben een methode `promise.then(callback)` waarmee je een callback aan je object kan toevoegen. In de callback kan je het resultaat van de asynchrone operatie gebruiken.

Je kan `.then()` chainen, aangezien de returnwaarde van de callback opnieuw gewrapt wordt in een promise-object

```javascript
promise.then((response) => response.text).then((text) => console.log(text));
// De text van de response wordt gereturnd, deze wordt gewrapt als promise, waar dan weer then op toegepast kan worden.
```

Je kan een error handler toevoegen via de methode `.catch(callback)`. Als je die op het einde van de promise chain plaatst, worden alle errors centraal opgevangen.

Promises kunnen drie toestanden hebben:

- Pending: resultaat is nog niet bepaald
- Fulfilled: operatie is afgerond en er is een waarde
- Rejected: operatie is niet goed afgerond, de promise bevat een reden waarom de operatie faalde

```javascript
const p = new Promise((resolve, reject) => {
  // voer iets asynchroons uit

  // als bewerking succesvol
  resolve(waarde);
  // als bewerking faalt
  reject(waarde);
});
```

## Fetch API

Fetch API gebruikt deze promises om data op te halen net zoals XHR -> `fetch(URL)` (returnt een promise die omgezet wordt in een response)

Een Response-object bevat enkele handige methodes:

- `Response.text()` -> geeft body terug als tekst
- `Response.json()` -> geeft body als geparsete JSON terug

De promise faalt niet als er een HTTP error optreedt. Daarom moet je de status van de response steeds checken.

```javascript
fetch("../pad/naar/data")
    .then(response => {
        if (!response.ok)
            throw new Error(`HTTP error: ${response.status}`);
        // voer rest van code uit
    };
    ).catch(error => alert(error))
```

# Promise.all() en Promise.any()

Eén van de problemen bij callbacks = een functie pas uitvoeren nadat meerdere parallelle callbacks uitgevoerd zijn.

`Promise.all([promise1, promise2, ...])` -> statische methode die voor een array van promises één promise teruggeeft. De resolve is een array van values in dezelfde volgorde als waarin je de promises meegaf. Faalt vanaf de eerste promise faalt.

`Promise.any([promise1, promise2, ...])` -> net het omgekeerde, resolves als één van de promises resolvet. Faalt wanneer alle promises falen.

# async/await

Werken met promises, maar in dezelfde vorm als synchronous code.

=> De code pauzeert bij await tot de promise fulfilled is.

```javascript
const response = await fetch("../pad/naar/data");
const jsonResponse = await reponse.json();
console.log(json);
```

Je voegt `async` toe voor een functie om er een asynchrone functie van te maken. Async functies returnen altijd een promise.

Modules werken als grote async functions.
