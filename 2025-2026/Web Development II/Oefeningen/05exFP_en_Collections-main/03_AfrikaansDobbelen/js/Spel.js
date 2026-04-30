import Speler from "./Speler.js";

export default class Spel {
  #spelers = [];
  #spelerAanZet;
  constructor(spelersNamen) {
    this.#spelers = spelersNamen.map((naam) => new Speler(naam));
    this.#spelerAanZet = this.#spelers[0];
  }

  get spelerAanZet() {
    return this.#spelerAanZet;
  }

  get heeftWinnaar() {
    return this.#spelers.some((speler) => speler.score >= 1000);
  }

  get scoreOverzicht() {
    let overzicht = this.#spelers.reduce(
      (res, speler) => (res += `${speler.naam}: ${speler.score}\n`),
      "",
    );
    return overzicht;
  }

  speel() {
    if (!this.heeftWinnaar) this.spelerAanZet.speel();
  }

  bepaalVolgendeSpeler() {
    if (!this.heeftWinnaar) {
      const indexNext =
        (this.#spelers.indexOf(this.#spelerAanZet) + 1) % this.#spelers.length;
      this.#spelerAanZet = this.#spelers[indexNext];
    }
  }
}
