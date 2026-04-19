export default class Spelbord {
  static #grootte = 3;
  #bord;

  constructor() {
    this.#bord = [];
    for (let i = 0; i < Spelbord.#grootte; i++) {
      const row = new Array(Spelbord.#grootte).fill(null);
      this.#bord.push(row);
    }
  }

  plaatsSymbool(symbool, rij, kol) {
    this.bord[rij][kol] = symbool;
  }

  geef(rij, kol) {
    return this.bord[rij][kol];
  }

  get bord() {
    return this.#bord;
  }

  isVrij(rij, kol) {
    return this.bord[rij][kol] === null;
  }

  bevatDrieOpEenRij(symbool, rij, kol) {
    if (this.bord.every((el) => el[kol] === symbool)) return true;
    if (this.bord[0].every((el) => el === symbool)) return true;

    const diagonaal1 = [this.bord[0][0], this.bord[1][1], this.bord[2][2]];
    const diagonaal2 = [this.bord[0][2], this.bord[1][1], this.bord[2][0]];
    if (diagonaal1.every((el) => el === symbool)) return true;
    if (diagonaal2.every((el) => el === symbool)) return true;

    return false;
  }

  isVolzet() {
    for (let rij = 0; rij < this.#bord.length; rij++) {
      for (let kolom = 0; kolom < this.#bord[0].length; kolom++) {
        if (this.bord[rij][kolom] === null) return false;
      }
    }
    return true;
  }
}
