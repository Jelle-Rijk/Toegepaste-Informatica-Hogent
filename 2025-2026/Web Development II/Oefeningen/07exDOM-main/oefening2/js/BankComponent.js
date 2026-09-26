import Canvas from "./Canvas.js";
import UitgavenRepository from "./UitgavenRepository.js";

export default class BankComponent {
  #canvasCategorieen;
  #storage;
  #aantalBezoeken;
  #uitgavenRepository;
  constructor() {
    this.#canvasCategorieen = new Canvas(50);
    this.#storage = window.localStorage;
    this.#getAantalBezoekenFromStorage();
    this.#uitgavenRepository = new UitgavenRepository();

    this.#setAantalBezoekenInStorage();
    this.#toHtml();
  }

  #toHtml() {
    this.#tekstToHtml();
    this.#canvasCategorieen.tekenen(this.#uitgavenRepository);
  }

  #tekstToHtml() {
    document.getElementById("aantalBezoeken").innerText = this.#aantalBezoeken;

    const dataContainer = document.getElementById("data");
    for (const uitgave of this.#uitgavenRepository.uitgaven) {
      dataContainer.insertAdjacentHTML(
        "beforeend",
        `<div class="aankoop"><img src="images/${uitgave.categorie}.png"> <h4>${uitgave.omschrijving.toUpperCase()} - €${uitgave.bedrag}</h4><p>${uitgave.datum.datumNotatie()}</p></div>`,
      );
    }
  }

  #getAantalBezoekenFromStorage() {
    const aantalBezoekenStorage = JSON.parse(
      this.#storage.getItem("aantalBezoeken"),
    );
    this.#aantalBezoeken = aantalBezoekenStorage
      ? aantalBezoekenStorage + 1
      : 1;
  }

  #setAantalBezoekenInStorage() {
    this.#storage.setItem("aantalBezoeken", this.#aantalBezoeken);
  }
}

Date.prototype.datumNotatie = function () {
  const dagen = [
    "Zondag",
    "Maandag",
    "Dinsdag",
    "Woensdag",
    "Donderdag",
    "Vrijdag",
    "Zaterdag",
  ];
  return `${dagen[this.getDay()]} ${this.getDate()}/${
    this.getMonth() + 1
  }/${this.getFullYear()}`;
};
