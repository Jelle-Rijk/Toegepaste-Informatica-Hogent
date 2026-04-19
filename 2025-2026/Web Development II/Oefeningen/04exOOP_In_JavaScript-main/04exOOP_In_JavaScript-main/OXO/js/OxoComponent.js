import Spel from "./Spel.js";

export default class OxoComponent {
  #spel;

  constructor() {
    this.#spel = new Spel();
    const imgElementen = document.getElementsByTagName("img");
    for (const imgElement of imgElementen) {
      imgElement.onclick = () => {
        this.#spel.plaatsSymbool(
          Number(imgElement.id.charAt(0)) - 1,
          Number(imgElement.id.charAt(1)) - 1,
        );
        this.#toHtml();
      };
    }
    this.#toHtml();
  }

  #toHtml() {
    const spel = this.#spel;

    for (let rij = 0; rij < 3; rij++)
      for (let kol = 0; kol < 3; kol++) {
        const cel = document.getElementById(`${rij + 1}${kol + 1}`);
        const symbool = spel.geefSymbool(rij, kol);
        cel.setAttribute(
          "src",
          `images/${symbool === null ? "wit" : symbool}.png`,
        );
      }
    let message;
    if (spel.winnaarsSymbool === null)
      message = spel.isEindeSpel()
        ? "Gelijkspel"
        : `Speler ${spel.tePlaatsenSymbool} is aan de beurt.`;
    else message = `Proficiat, ${spel.winnaarsSymbool} wint`;
    document.getElementById("message").innerHTML = message;
  }
}
