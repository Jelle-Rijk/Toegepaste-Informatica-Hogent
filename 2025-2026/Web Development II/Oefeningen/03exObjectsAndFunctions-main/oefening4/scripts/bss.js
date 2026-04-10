"use strict";

const wint = {
  steen: "schaar",
  schaar: "blad",
  blad: "steen",
};

const keuzeGebruiker = prompt(
  "Kies je blad, steen of schaar?",
  "steen",
).toLowerCase();

let keuzeComputer =
  Object.keys(wint)[Math.floor(Math.random() * Object.keys(wint).length)];

const kapitaliseer = (string) =>
  string.charAt(0).toUpperCase() + string.substring(1);

console.log("keuze computer:", keuzeComputer);
console.log(geefResultaat(keuzeGebruiker, keuzeComputer));

function geefResultaat(keuze1, keuze2) {
  if (keuze1 === keuze2) {
    return "Het resultaat is een gelijkspel!";
  }
  // Maak  gebruik van het object met de winregels om het juiste resultaat terug te geven
  const isGebruikerGewonnen = wint[keuze1] === keuze2;
  const gewonnenKeuze = isGebruikerGewonnen ? keuze1 : keuze2;
  return `${kapitaliseer(gewonnenKeuze)} wint - ${isGebruikerGewonnen ? "jij" : "computer"} wint!`;
}
