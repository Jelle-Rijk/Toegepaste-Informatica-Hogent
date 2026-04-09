"use strict";
const geldigeKeuzes = ["blad", "steen", "schaar"];

const keuzeGebruiker = berekenKeuzeGebruiker();
const keuzeComputer = berekenKeuzeComputer(Math.random());
console.log(`De computer koos ${keuzeComputer}.ste`);
const resultaat = geefResultaat(keuzeGebruiker, keuzeComputer);
console.log(resultaat);

function berekenKeuzeGebruiker(keuzeGebruiker) {
  while (true) {
    const input = prompt("Kies je blad, steen of schaar?").toLowerCase();
    const keuzeIndex = geldigeKeuzes.indexOf(input);
    if (keuzeIndex !== -1) return geldigeKeuzes[keuzeIndex];
  }
}

function berekenKeuzeComputer(number) {
  if (number < 1 / 3) return geldigeKeuzes[0];
  if (number < 2 / 3) return geldigeKeuzes[1];
  return geldigeKeuzes[2];
}

function geefResultaat(keuze1, keuze2) {
  if (keuze1 === keuze2) return "Het is een gelijkspel.";
  let winnaar = keuze2;
  const keuze1Index = geldigeKeuzes.indexOf(keuze1);
  const keuze2Index = geldigeKeuzes.indexOf(keuze2);
  winnaar =
    keuze1Index + (1 % geldigeKeuzes.length) === keuze2Index ? keuze1 : keuze2;
  return `${winnaar.substring(0, 1).toUpperCase() + winnaar.substring(1)} wint.`;
}
