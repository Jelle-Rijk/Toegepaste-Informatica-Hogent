"use strict";

// Creëer een object ‘myBicycle‘ met 3 properties:
// speed met waarde 30,
// gear met waarde 1 en
// frameMaterial met waarde  "carbon fiber".
const myBicycle = {
  speed: 30,
  gear: 1,
  frameMaterial: "carbon fiber",
};

// Overloop alle properties, verzamel de key/value pairs in een string
// en alert de string.
let output = "";
for (const key in myBicycle) {
  output += `${key} ${myBicycle[key]}\n`;
}
alert(output);

// Voeg een property color, met waarde 'red' toe aan myBicycle
myBicycle.color = "red";

// Verwijder de property gear
delete myBicycle.gear;

// Verhoog de speed met 6
myBicycle.speed += 6;

// Creëer een object gearDescription met de volgende eigenschappen
// make: "Sram", nrOfGears = 24
let gearDescription = { make: "Sram", nrOfGears: 24 };

// Voeg een property gears toe aan myBicycle
// zorg dat de waarde van de property wijst naar het object gearDescription
myBicycle.gears = gearDescription;

// Ken de waarde null toe aan gearDescription
gearDescription = null;

// Voeg een property extras toe aan myBicycle en
// stel de waarde in op ["gps", "mud-guard"]
myBicycle.extras = ["gps", "mud-guard"];

// Voeg een extra 'lights' toe aan de extra's van myBicycle
// Zorg dat dit de laatste in de lijst van extra's wordt
myBicycle.extras.push("lights");

// Verander de make van de gears naar 'Shimano'
myBicycle.gears.make = "Shimano";

// Maak gebruik van object destructuring om de variabelen speed,
// frame en color de waarden van de overeenkomstige properties te geven
// merk op: frame moet de waarde van de property frameMaterial krijgen.
// Log de waarden van de variabelen naar de console
const { speed, frameMaterial: frame, color } = myBicycle;
console.log(`Speed: ${speed}\nFrame: ${frame}\nColor: ${color}`);

// Maak gebruik van destructuring om de variabelen
// gearMake (waarde is de waarde van de property make van de property gears van myBicycle,
// en extras (dit moet een array met alle extra's bevatten) te maken.
// Log de verkregen waarden van gearMake en alle extra's (als een opsomming van strings, gescheiden door een ,)
// naar de console
const {
  gears: { make: gearMake },
  extras,
} = myBicycle;
console.log(`Gear make: ${gearMake}\nExtras: ${extras.join(", ")}`);
