import Product from "./Product.js";
import { producten } from "./ProductenArray.js";

export default class ProductenRepository {
  #producten = [];

  constructor() {
    this.#haalProductenOp();
  }

  get producten() {
    return this.#producten;
  }

  // Voegt een product achteraan toe aan de array #producten
  #voegProductToe(
    id,
    eigenaar,
    postcode,
    gemeente,
    titel,
    omschrijving,
    prijs,
    categorie,
    afbeeldingen,
  ) {
    const product = new Product(
      id,
      eigenaar,
      postcode,
      gemeente,
      titel,
      omschrijving,
      prijs,
      categorie,
      afbeeldingen,
    );
    this.#producten.push(product);
  }

  // Retourneert het product met opgegeven id
  geefProduct(id) {
    return this.#producten.find((el) => el.id === id);
  }

  // Retourneert een array met producten behorend tot de opgegeven categorie
  geefProductenUitCategorie(categorie) {
    return categorie === "Alles"
      ? this.#producten
      : this.#producten.filter((product) => product.categorie === categorie);
  }

  // Retourneert een alfabetisch gesorteerde array van strings die de unieke categorieën bevat
  geefAlleCategorieen() {
    return [...new Set(this.#producten.map((p) => p.categorie))].sort();
  }

  // Vult de repository met producten
  #haalProductenOp() {
    producten.forEach(
      ([
        id,
        eigenaar,
        postcode,
        gemeente,
        titel,
        omschrijving,
        prijs,
        categorie,
        afbeeldingen,
      ]) =>
        this.#voegProductToe(
          id,
          eigenaar,
          postcode,
          gemeente,
          titel,
          omschrijving,
          prijs,
          categorie,
          afbeeldingen,
        ),
    );
  }
}
