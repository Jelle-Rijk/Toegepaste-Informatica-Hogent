export default class Spelbord {
  #bord;
  constructor() {
    this.#bord = [];
    for (let rij = 0; rij < 3; rij++) {
      this.#bord[rij] = [];
      for (let kol = 0; kol < 3; kol++) {
        this.#bord[rij][kol] = "";
      }
    }
  }

  get bord() {
    return this.#bord;
  }

  plaatsSymbool(symbool, rij, kol) {
    this.#bord[rij][kol] = symbool;
  }

  geefSymbool(rij, kol) {
    return this.#bord[rij][kol];
  }

  isVrij(rij, kol) {
    return !this.#bord[rij][kol];
  }

  bevatDrieOpEenRij(symbool, rij, kol) {
    const isDrieOpEenRij = function (drieCellen, symbool) {
      return drieCellen.every((cel) => cel === symbool);
    };
    // horizontaal
    if (isDrieOpEenRij(this.#bord[rij], symbool)) return true;
    // verticaal
    const kolom = this.#bord.reduce((prev, rij) => prev.concat(rij[kol]), []);
    if (isDrieOpEenRij(kolom, symbool)) return true;
    // diagonalen
    const diagonaal1 = this.#bord.reduce(
      (prev, rij, rijIndex) => prev.concat(rij[rijIndex]),
      [],
    );
    const diagonaal2 = this.#bord.reduce(
      (prev, rij, rijIndex) => prev.concat(rij[2 - rijIndex]),
      [],
    );
    return (
      isDrieOpEenRij(diagonaal1, symbool) || isDrieOpEenRij(diagonaal2, symbool)
    );
  }

  get isVolzet() {
    return this.#bord.every((rij) => rij.every((kol) => kol));
  }
}
