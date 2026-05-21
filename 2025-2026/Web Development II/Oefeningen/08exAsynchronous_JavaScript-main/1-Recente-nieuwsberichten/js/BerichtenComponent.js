import BerichtenRepository from "./BerichtenRepository.js";

export default class BerichtenComponent {
  #berichtenRepository;
  #url;

  constructor() {
    this.#url = "js/data/example.json";
    this.#berichtenRepository = new BerichtenRepository();
    this.#getData();
  }

  #getData() {
    fetch(this.#url)
      .then((res) => res.json())
      .then((json) => {
        json["results"].forEach((el) => {
          this.#berichtenRepository.addBericht(
            el.publicatiedatum,
            el.titel,
            el.subjectpage,
          );
        });
        this.#berichtenToHTML(this.#berichtenRepository.berichten);
      })
      .catch((err) => alert(err));
  }

  #berichtenToHTML(berichten) {
    const container = document.getElementById("nieuwsberichten");
    berichten.forEach((b) =>
      container.insertAdjacentHTML("beforeend", b.toHTMLString()),
    );
  }
}
