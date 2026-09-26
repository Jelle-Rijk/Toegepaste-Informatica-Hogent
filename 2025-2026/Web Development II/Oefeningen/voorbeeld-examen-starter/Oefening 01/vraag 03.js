// == Oefening 01 - Vraag 03 ==

const planets = new Map([
  ["Earth", { nrOfMoons: 1, distanceFromSun: 1 }],
  ["Venus", { nrOfMoons: 0, distanceFromSun: 0.75 }],
  ["Jupiter", { nrOfMoons: 95, distanceFromSun: 5.2 }],
  ["Saturn", { nrOfMoons: 274, distanceFromSun: 9.54 }],
  ["Pluto", { nrOfMoons: 5, distanceFromSun: 39.5 }],
]);

// TODO Deel A
planets.set("Neptune", { nrOfMoons: 16, distanceFromSun: 30.06 });

// TODO Deel B
const venusData = planets.get("Venus");
venusData.distanceFromSun = 0.72;
planets.set("Venus", venusData);

// TODO Deel C
planets.delete("Pluto");
console.log(planets);

// TODO Deel D
const planetsFarAway = new Map(
  [...planets].filter((el) => el[1].distanceFromSun > 1),
);

// Voorbeeld
console.log(planets);
console.log(planetsFarAway);
