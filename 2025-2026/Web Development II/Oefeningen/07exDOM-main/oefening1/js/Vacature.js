export default class Vacature {
  #id;
  #titel;
  #functieomschrijving;
  #profiel;
  #bedrijf;
  #plaats;

  constructor(id, titel, functieomschrijving, profiel, bedrijf, plaats) {
    this.#id = id;
    this.#titel = titel;
    this.#functieomschrijving = functieomschrijving;
    this.#profiel = profiel;
    this.#bedrijf = bedrijf;
    this.#plaats = plaats;
  }

  get id() {
    return this.#id;
  }
  get titel() {
    return this.#titel;
  }
  get functieomschrijving() {
    return this.#functieomschrijving;
  }
  get profiel() {
    return this.#profiel;
  }
  get bedrijf() {
    return this.#bedrijf;
  }
  get plaats() {
    return this.#plaats;
  }

  bevatZoekterm(zoektermen) {
    const titel = this.#titel.toLowerCase();
    return zoektermen.some((term) => titel.includes(term.toLowerCase()));
  }
}
