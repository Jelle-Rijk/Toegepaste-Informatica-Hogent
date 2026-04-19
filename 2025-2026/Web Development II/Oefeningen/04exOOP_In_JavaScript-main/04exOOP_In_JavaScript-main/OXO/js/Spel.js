import SpelBord from "./Spelbord.js";

export default class Spel {
  #spelbord;
  #tePlaatsenSymbool = "O";
  #geplaatsteSymbool = "X";
  #winaarsSymbool = null;

  constructor() {
    this.#spelbord = new SpelBord();
  }

  get tePlaatsenSymbool() {
    return this.#tePlaatsenSymbool;
  }

  get geplaatsteSymbool() {
    return this.#geplaatsteSymbool;
  }

  get winnaarsSymbool() {
    return this.#winaarsSymbool;
  }

  plaatsSymbool(rij, kol) {
    if (!this.#spelbord.isVrij(rij, kol) || this.isEindeSpel()) {
      return;
    }

    this.#spelbord.plaatsSymbool(this.#tePlaatsenSymbool, rij, kol);
    [this.#geplaatsteSymbool, this.#tePlaatsenSymbool] = [
      this.#tePlaatsenSymbool,
      this.#geplaatsteSymbool,
    ];
    if (this.#spelbord.bevatDrieOpEenRij(this.#geplaatsteSymbool, rij, kol))
      this.#winaarsSymbool = this.#geplaatsteSymbool;
  }

  geefSymbool(rij, kol) {
    return this.#spelbord.geef(rij, kol);
  }

  isEindeSpel() {
    return this.#spelbord.isVolzet() || this.#winaarsSymbool !== null;
  }
}
