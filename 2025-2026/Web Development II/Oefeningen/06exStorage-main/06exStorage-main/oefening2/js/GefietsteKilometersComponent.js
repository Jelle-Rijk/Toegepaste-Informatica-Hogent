import GefietsteKilometersRepository from "./GefietsteKilometersRepository.js";

export default class GefietsteKilometersComponent {
  #gefietsteKilometersRepository;
  #storage;
  constructor() {
    this.#gefietsteKilometersRepository = new GefietsteKilometersRepository();
    this.#storage = window.localStorage;

    const jaarSelect = document.getElementById("jaar");

    this.#jarenToHtml();

    jaarSelect.value = this.#getJaarFromStorage();
    this.#gefietsteKilometersToHtml(Number(jaarSelect.value));

    document.getElementById("jaar").onchange = () => {
      this.#gefietsteKilometersToHtml(Number(jaarSelect.value));
      this.#setJaarInStorage();
    };

    document.getElementById("opslaan").onclick = () => {
      const aantalKilometers = [];
      for (let i = 0; i < 12; i++) {
        aantalKilometers.push(Number(document.getElementById(`${i}`).value));
      }
      this.#gefietsteKilometersRepository.wijzigGefietsteKilometers(
        Number(jaarSelect.value),
        aantalKilometers,
      );
    };
  }

  /* De keuzelijst met jaren dynamisch genereren */
  #jarenToHtml() {
    this.#gefietsteKilometersRepository.geefJaren().forEach((value) => {
      const optionElement = document.createElement("option");
      optionElement.setAttribute("value", value);
      const optionTekst = document.createTextNode(value);
      optionElement.appendChild(optionTekst);
      document.getElementById("jaar").appendChild(optionElement);
    });
  }

  /* De tekstvakken dynamisch invullen */
  #gefietsteKilometersToHtml(jaar) {
    const kilometers =
      this.#gefietsteKilometersRepository.geefGefietsteKilometersVoorEenJaar(
        jaar,
      );

    kilometers.forEach((km, index) => {
      const textField = document.getElementById(`${index}`);
      textField.value = km;
    });
  }

  #getJaarFromStorage() {
    const gekozenJaar = this.#storage.getItem("jaarGefietsteKilometers");
    return (document.getElementById("jaar").value = JSON.parse(gekozenJaar));
  }

  #setJaarInStorage() {
    this.#storage.setItem(
      "jaarGefietsteKilometers",
      JSON.stringify(Number(document.getElementById("jaar").value)),
    );
  }
}
