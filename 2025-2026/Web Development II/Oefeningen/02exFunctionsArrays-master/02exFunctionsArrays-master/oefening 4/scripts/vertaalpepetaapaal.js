const klinkers = ["a", "e", "i", "o", "u"];

export function vertaal(zin) {
  let nieuweZin = "";

  let klinkercombinatie = "";

  for (let i = 0; i < zin.length; i++) {
    const letter = zin[i];
    const isKlinker = klinkers.indexOf(letter.toLowerCase()) !== -1;
    if (
      isKlinker ||
      (letter === "j" &&
        klinkercombinatie.charAt(klinkercombinatie.length - 1) === "i")
    ) {
      klinkercombinatie += zin[i];
    } else {
      if (klinkercombinatie !== "") {
        nieuweZin += klinkercombinatie + "p" + klinkercombinatie.toLowerCase();
        klinkercombinatie = "";
      }
      nieuweZin += zin[i];
    }
  }

  return nieuweZin;
}
