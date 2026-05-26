import Bericht from "./Bericht.js";

export default class BerichtenRepository {
  #berichten = [];

  get berichten() {
    return this.#berichten;
  }

  addBericht(publicatiedatum, titel, url) {
    const bericht = new Bericht(publicatiedatum, titel, url);
    this.#berichten.push(bericht);
  }
}
