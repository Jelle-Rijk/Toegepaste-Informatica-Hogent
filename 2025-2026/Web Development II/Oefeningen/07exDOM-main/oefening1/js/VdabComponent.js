import VacaturesRepository from "./VacatureRepository.js";

export default class VdabComponent {
  #zoektermen = [];
  #vacaturesRepository;
  #storage;
  constructor() {
    this.#vacaturesRepository = new VacaturesRepository();
    this.#storage = window.localStorage;
    console.log(this.#getZoektermenFromStorage());
    this.#zoektermen = this.#getZoektermenFromStorage();

    document
      .getElementById("zoektermToevoegen")
      .addEventListener("click", (evt) => {
        const zoekterm = document.getElementById("zoekterm").value;
        const messageElement = document.getElementById("message");
        messageElement.innerText = "";
        if (!zoekterm)
          messageElement.innerText = "De zoekterm mag niet leeg zijn.";
        else if (this.#zoektermen.includes(zoekterm))
          messageElement.innerText = "De zoekterm staat al in de lijst.";
        else this.#voegZoektermToe(zoekterm);
        document.getElementById("zoekterm").value = "";
      });

    this.#toHtml();
  }

  #voegZoektermToe(zoekterm) {
    this.#zoektermen.push(zoekterm);
    this.#setZoektermenInStorage();
    this.#toHtml();
  }

  #verwijderZoekterm(zoekterm) {
    const index = this.#zoektermen.indexOf(zoekterm);
    this.#zoektermen.splice(index, 1);
    this.#setZoektermenInStorage();
    this.#toHtml();
  }

  #getZoektermenFromStorage() {
    return JSON.parse(this.#storage.getItem("VDABZoektermen")) ?? [];
  }

  #setZoektermenInStorage() {
    this.#storage.setItem("VDABZoektermen", JSON.stringify(this.#zoektermen));
  }

  #toHtml() {
    this.#zoektermenToHtml();
    this.#vacaturesToHtml();
  }

  #zoektermenToHtml() {
    const container = document.getElementById("zoektermen");
    container.innerHTML = "";
    this.#zoektermen.forEach((term) => {
      const img = document.createElement("img");
      img.src = "images/destroy.png";
      img.id = term;
      img.addEventListener("click", () => this.#verwijderZoekterm(term));
      const span = document.createElement("span");
      span.innerText = term;
      span.appendChild(img);
      container.appendChild(span);
    });
  }

  #vacaturesToHtml() {
    document.getElementById("resultaat").innerHTML = "";
    this.#vacaturesRepository
      .filterOpZoekTermen(this.#zoektermen)
      .forEach((vacature) => {
        const divElement = document.createElement("div");
        const h2Element = document.createElement("h2");
        h2Element.innerText = vacature.titel;
        h2Element.setAttribute("class", "vacatureTitel");
        const h3Element = document.createElement("h3");
        h3Element.innerText = vacature.bedrijf + " - " + vacature.plaats;
        const h4Element1 = document.createElement("h4");
        h4Element1.innerText = "Functieomschrijving";
        const pElement = document.createElement("p");
        pElement.innerText = vacature.functieomschrijving;
        const h4Element2 = document.createElement("h4");
        h4Element2.innerText = "Profiel";
        const ulElement = document.createElement("ul");
        vacature.profiel.forEach((item) => {
          const liElement = document.createElement("li");
          liElement.innerText = item;
          ulElement.appendChild(liElement);
        });
        divElement.appendChild(h2Element);
        divElement.appendChild(h3Element);
        divElement.appendChild(h4Element1);
        divElement.appendChild(pElement);
        divElement.appendChild(h4Element2);
        divElement.appendChild(ulElement);
        document.getElementById("resultaat").appendChild(divElement);
      });
  }
}
