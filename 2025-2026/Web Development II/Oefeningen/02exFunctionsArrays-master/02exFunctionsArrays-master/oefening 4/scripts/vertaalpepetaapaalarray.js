const klinkers = ["a", "e", "i", "o", "u"];

export function vertaalArrayImpl(zin) {
  const array = zin.split("");
  const nieuweZin = [];

  let klinkercombinatie = new Array();
  for (const letter of array) {
    const klinker = klinkers.indexOf(letter.toLowerCase()) !== -1;
    if (
      klinker ||
      (letter === "j" &&
        klinkercombinatie[klinkercombinatie.length - 1] === "i")
    ) {
      klinkercombinatie.push(letter);
    } else {
      if (klinkercombinatie.length > 0) {
        const klinkerString = klinkercombinatie.join("");
        nieuweZin.push(klinkerString + "p" + klinkerString.toLowerCase());
        klinkercombinatie = new Array();
      }
      nieuweZin.push(letter);
    }
  }
  return nieuweZin.join("");
}
