"use strict";

const aRedBicycle = {
  speed: 30,
  gear: 1,
  color: "red",
};

const aGreenBicycle = {
  speed: 15,
  gear: 3,
  color: "green",
};

// Schrijf een functie swapColors die de kleur van twee bicycles wisselt
function swapColors(bicycle1, bicycle2) {
  [bicycle1.color, bicycle2.color] = [bicycle2.color, bicycle1.color];
}

//Je kan onderstaande uit commentaar zetten en gebruiken om je functie te testen:
swapColors(aRedBicycle, aGreenBicycle);
console.log(`myRedBicycle is now ${aRedBicycle.color}`);
console.log(`myGreenBicycle is now ${aGreenBicycle.color}`);

// Schrijf een functie sameColor die een boolean retourneert
// die vertelt of twee bicycles dezelfde kleur hebben.
// Gebruik een arrow functie
const sameColor = (bicycle1, bicycle2) => bicycle1.color === bicycle2.color;

//Zet onderstaande uit commentaar om je functie te testen:
console.log(
  `aRedBicycle & aGreenBicycle ${
    sameColor(aRedBicycle, aGreenBicycle) ? "" : "do not "
  }have the same color`,
);

// Schrijf een functie getBikesWithColor met een kleur en een willekeurig aantal bicycles
// als parameters. De functie retourneert alle fietsen met de opgegeven kleur.
// Maak gebruik van een for-of lus.
function getBikesWithColor(color, ...bicycles) {
  return bicycles.filter((bicycle) => bicycle.color === color);
}

//Zet onderstaande uit commentaar om je functie te testen:
const redBikes = getBikesWithColor("red", aRedBicycle, aGreenBicycle);
console.log(redBikes);

// Pas de code aan zodat gebruik gemaakt wordt van de Array-methode filter, bekijk de documentatie op https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter
// Geef een arrow functie door als parameter voor filter
