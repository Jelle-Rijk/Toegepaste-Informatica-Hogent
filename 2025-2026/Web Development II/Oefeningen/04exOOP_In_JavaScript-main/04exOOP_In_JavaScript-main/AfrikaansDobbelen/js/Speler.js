import Dobbelsteen from "./Dobbelsteen.js";

export default class Speler {
  static #aantalDobbelstenen = 5;
  #naam;
  #score;
  #dobbelstenen;

  constructor(naam) {
    this.#naam = naam;
    this.#score = 0;
    this.#dobbelstenen = [];
    for (let i = 0; i < Speler.#aantalDobbelstenen; i++)
      this.#dobbelstenen.push(new Dobbelsteen());
  }

  speel() {
    for (const dobbelsteen of this.#dobbelstenen) {
      dobbelsteen.rol();
      const aantalOgen = dobbelsteen.aantalOgen;
      if (aantalOgen === 1) this.#score += 100;
      else if (aantalOgen === 5) this.#score += 50;
    }
  }

  get aantalDobbelstenen() {
    return this.#aantalDobbelstenen;
  }

  get naam() {
    return this.#naam;
  }

  get score() {
    return this.#score;
  }

  get dobbelstenen() {
    return this.#dobbelstenen;
  }
}
