import Speler from "./Speler.js";

export default class Spel {
  #spelers = [];
  #spelerAanZet;

  constructor(spelers) {
    for (const speler of spelers) this.#spelers.push(new Speler(speler));
    this.#spelerAanZet = this.#spelers[0];
  }

  get spelerAanZet() {
    return this.#spelerAanZet;
  }

  get aantalSpelers() {
    return this.#spelers.length;
  }

  get heeftWinnaar() {
    for (const speler of this.#spelers) if (speler.score >= 10000) return true;
    return false;
  }

  get scoreOverzicht() {
    let overzicht = "";
    for (const speler of this.#spelers)
      overzicht += `${speler.naam}: ${speler.score}\n`;
    return overzicht;
  }

  speel() {
    if (!this.heeftWinnaar) this.#spelerAanZet.speel();
  }

  bepaalVolgendeSpeler() {
    if (!this.heeftWinnaar) {
      const indexHuidigeSpeler = this.#spelers.indexOf(this.spelerAanZet);
      this.#spelerAanZet =
        this.#spelers[(indexHuidigeSpeler + 1) % this.aantalSpelers];
    }
  }
}
