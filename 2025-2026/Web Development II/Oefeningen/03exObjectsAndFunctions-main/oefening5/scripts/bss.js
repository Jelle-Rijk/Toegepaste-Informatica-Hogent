"use strict";

const wint = {
  steen: "schaar",
  schaar: "blad",
  blad: "steen",
};

const kapitaliseer = (woord) =>
  woord.charAt(0).toUpperCase() + woord.substring(1);

function geefResultaat(keuzeSpeler, keuzeComputer) {
  if (keuzeSpeler === keuzeComputer) {
    return "Het resultaat is een gelijkspel!";
  }
  if (wint[keuzeSpeler] === keuzeComputer) {
    return `${kapitaliseer(keuzeSpeler)} wint - jij wint!`;
  }
  return `${kapitaliseer(keuzeComputer)} wint - computer wint!`;
}

export function initialiseerBladSteenSchaar() {
  for (const id of ["btn1", "btn2", "btn3"]) {
    const element = document.getElementById(id);
    element.addEventListener("click", () => {
      const keuzeSpeler = element.textContent;
      const keuzeComputer = Object.keys(wint)[Math.floor(Math.random() * 3)];
      document.getElementById("keuzeGebruiker").textContent =
        `Jouw keuze: ${keuzeSpeler}`;
      document.getElementById("keuzeComputer").textContent =
        `Computer keuze: ${keuzeComputer}`;
      document.getElementById("resultaat").textContent = geefResultaat(
        keuzeSpeler,
        keuzeComputer,
      );
    });
  }
}
