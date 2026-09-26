// == Oefening 01 - Vraag 02 ==

class Trekking {
  static aantalGetallen = 6;
  static min = 1;
  static max = 42;
  #getallen = [];

  constructor(getallen) {
    // TODO Deel B
    this.getallen = getallen;
  }

  // TODO Deel A
  set getallen(value) {
    this.#controleerGetallen(value);
    this.#getallen = value;
  }

  get getallen() {
    return this.#getallen;
  }

  #controleerGetallen(getallen) {
    // TODO Deel C
    const errorMessage = `Enkel ${Trekking.aantalGetallen} verschillende gehele getallen in het interval [${Trekking.min}, ${Trekking.max}] zijn toegelaten!`;
    const uniekeGetallen = [...new Set(getallen)];
    if (
      uniekeGetallen.length !== Trekking.aantalGetallen ||
      uniekeGetallen.some((el) => el < Trekking.min || el > Trekking.max)
    ) {
      throw new Error(errorMessage);
    }
  }
}

// Voorbeelduitvoer:
simuleerTrekking([1, 2, 3, 4, 5, 6]);
simuleerTrekking([1, 0, 3, 4, 5, 6]); // bevat 0
simuleerTrekking([100, 2, 3, 4, 5, 6]); // bevat 100
simuleerTrekking([1, 2, 3, 4, 5]); // bevat een getal te weinig
simuleerTrekking([1, 2, 3, 4, 5, 6, 7]); // bevat een getal te veel
simuleerTrekking([10, 2, 10, 4, 5, 6]); // bevat twee keer eenzelfde getal

function simuleerTrekking(getallen) {
  try {
    let t = new Trekking(getallen);
    console.log(`De getallen van de trekking zijn ${t.getallen}`);
  } catch (e) {
    console.log(e.message);
  }
}
