<h1>Functioneel programmeren</h1>

# Functioneel programmeren

Pure function:

- Zelfde input = zelfde output
- Geen side-effects (gebruik van externe variabelen / manipulatie van de DOM) = iedere verandering aan de toestand van de applicatie buiten de geroepen functie (exclusief return-waarde).
- Altijd een return

=> In principe moet je de functie kunnen vervangen door zijn resultaat zonder dat dit een effect mag hebben op het programma.

Shared state => object dat doorgegeven wordt tussen verschillende scopes.

Immutable data: Om het object te wijzigen wordt een kopie gemaakt. De originele data kan niet veranderen.

Callback = functie die als parameter wordt doorgegeven.

# Arrays

## Filter, map, reduce

Filter => returnt de elementen die aan de voorwaarde in de callback voldoen. <br> Kan drie argumenten nemen, enkel eerste is verplicht: (element, index, array)

Map => Dit returnt een nieuwe array met elementen getransformeerd volgens de callback. Neemt dezelfde argumenten als filter.

Reduce => Berekent een eindwaarde. Twee argumenten: callback(previousValue, currentValue, currentIndex, array) - eerste twee args verplicht - en de initiële waarde voor previousValue. Als je de initiële waarde weglaat, wordt deze gelijk gezet aan het eerste element.

## Andere functies

array.forEach(callback(element, index, array)) => itereert over een array (continue en break werken niet - daarvoor klassieke lus)

array.find(callback(element, index, array)) => returnt eerste element dat aan de callback voldoet of undefined als er geen zijn.

array.findIndex => zelfde als find, maar returnt de index of -1 als er geen is.

array.sort(compareFunctie(el1, el2)) => sorteert de array in-place (maar returnt de gesorteerde array ook). Zonder callback - alfabetisch sorteren.

Compare functie(a, b):

- resultaat > 0 = b komt voor a
- resultaat < 0 = a komt voor b
- resultaat === 0 = originele volgorde

array.toSorted => zelfde als sort maar maakt een copy.

array.some => test of er een element aan de voorwaarde voldoet

array.every => test of alle eleementen aan de voorwaarde voldoen

array.flat => returnt een eendimensionale array

# Maps

key-value pairs, onthoudt de volgorde van insertions.

```javascript
// constructor
const population = new Map(); // maakt lege map
const honden = new Map([
  ["Izzy", "middelmatig"],
  ["Harry", "klein"],
]); // maakt map met key-value pairs volgens de meegegeven array.

// toevoegen
population.set("Belgium", 11589623);

// lezen
population.get("Belgium"); // 11589623
population.get("DezeKeyBestaatNiet"); // undefined

// anders
population.size(); // aantal entries
population.has(key); // returnt of een key aanwezig is
population.delete(key); // verwijdert entry
population.clear(); // maakt map leeg
population.keys(); // iterable met alle keys in volgorde van insertion
population.values(); // iterable met alle values in volgorde van insertion
population.entries(); //iterable van alle entries als arrays met lengte 2 [0] = key, [1] = value
population.forEach((value, key) => statements);

// itereren over entries is makkelijker met array destructuring
for (const [key, value] of population.entries()) {
  console.log(`Key: ${key}, value: ${value}`);
}
```

# Sets

Houdt unieke values bij, onthoudt insertion order.

Toevoegen aan set met `set.add(value)`, voor de rest gelijk aan maps.

`set.entries()` -> geeft een [value, value] pair, is dus niet echt nuttig.

# Rest en spread

## Spread syntax

Spread syntax -> klapt elementen van een iterable uit (Object is geen iterable!)

```javascript
const numbers = [1, 2, 3, 4];
const lettersAndNumbersWrong = ["a", "b", numbers]; // = ["a", "b", [1,2,3,4]]
const lettersAndNumbersCorrect = ["a", "b", ...numbers]; // = ["a", "b", 1,2,3,4]
```

De spread syntax kan voor verschillende zaken gebruikt worden:

| Originele data | resultaat          |
| -------------- | ------------------ |
| String         | karakters          |
| map            | [key, value] pairs |
| set            | values}            |
| array          | elementen          |

Je kan maps / sets / etc. omvormen naar arrays om de array methodes te gebruiken.

```javascript
let map = new Map(values);
let mapAsArray = [...map];
mapAsArray.sort();
map = new Map(mapAsArray);

// je kan dit ook in de constructor doen - in dit geval sorteren
population = new Map([...population].sort(sorteermethode));
```

## Rest syntax

Eerder gezien bij parameters van functies. Altijd als laatste argument.

Kan ook gebruikt worden bij array destructuring:

```javascript
const [a, ...b] = ["Jan", "Piet", "Korneel"];
console.log(a); // a = "Jan"
console.log(b); // b = ["Piet","Korneel"]
```

Je kan hetzelfde doen met objecten. Als je het volledige object spreadt, maak je een shallow clone.
