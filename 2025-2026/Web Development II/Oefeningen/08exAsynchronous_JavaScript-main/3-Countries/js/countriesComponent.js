import CountriesRepository from "./countriesRepository.js";

export default class CountriesComponent {
  #countriesRepository;
  #url;

  constructor() {
    this.#url = "./data/countries.json";
    this.#countriesRepository = new CountriesRepository();
    this.#initialiseHTML();
  }

  async #initialiseHTML() {
    await this.#getData();
    this.#setupSearchBox();
    this.#countriesToHTML(this.#countriesRepository.countries);
  }

  async #getData() {
    const response = await fetch(this.#url);
    const json = await response.json();
    json.forEach((element) => {
      this.#countriesRepository.addCountry(
        `${element.name} - ${element.nativeName}`,
        element.capital,
        element.region,
        element.flag,
      );
    });
  }

  #setupSearchBox() {
    const searchBox = document.getElementById("search");
    searchBox.addEventListener("keyup", () => {
      const filteredCountries = this.#countriesRepository.filteredCountries(
        searchBox.value,
      );
      this.#countriesToHTML(filteredCountries);
    });
    searchBox.focus();
  }

  // Beeld een doorgegeven countries-array af op de webpagina
  // (de countries-array kan alle countries landen bevatten
  // of de gefilterde landen)
  #countriesToHTML(countries) {
    const number = document.getElementById("number");
    number.innerHTML = "";
    number.insertAdjacentHTML(
      "afterbegin",
      `<h2>Number of countries: ${countries.length}</h2>`,
    );

    const container = document.getElementById("countries");
    container.innerHTML = "";
    for (const country of countries) {
      container.insertAdjacentHTML(
        "beforeend",
        `<tr>
          <td>${country.countryName}</td>
          <td>${country.capital}</td>
          <td>${country.region}</td>
          <td><img src=${country.flag} class="flag"></img></td>
        </tr>`,
      );
    }
  }
}
