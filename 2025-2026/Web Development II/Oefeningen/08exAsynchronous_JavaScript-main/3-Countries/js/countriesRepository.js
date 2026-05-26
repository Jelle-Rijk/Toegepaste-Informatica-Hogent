import Country from "./country.js";

export default class CountriesRepository {
  #countries = [];

  get countries() {
    return this.#countries;
  }

  addCountry(name, capital, region, flag) {
    this.#countries.push(new Country(name, capital, region, flag));
  }

  filteredCountries(searchString) {
    return this.#countries.filter((country) =>
      country.countryName.toLowerCase().startsWith(searchString.toLowerCase()),
    );
  }
}
