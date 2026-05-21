import ProductenRepository from './ProductenRepository.js';

export default class ProductenComponent {
  #productenRepository;
  constructor() {
    this.#productenRepository = new ProductenRepository();
    this.#initialiseerHtml();
  }

  // deze methode intialiseert de pagina
  #initialiseerHtml() {
    this.#productenToHtml(this.#productenRepository.producten);
    this.#categorieenToHtml(this.#productenRepository.geefAlleCategorieen());

    // voeg een event handler toe aan de keuzelijst categorie
    document.getElementById('categorie').onchange = () => {
      const gefilterdeProducten =
        this.#productenRepository.geefProductenUitCategorie(
          document.getElementById('categorie').value
        );
      this.#productenToHtml(gefilterdeProducten);

      // er is geen product geselecteerd dus verbergen we #productDetails
      document.getElementById('productDetails').classList.add('verbergen');
    };
  }

  // voegt de gegeven categorieën toe aan de selectlist #categorie
  #categorieenToHtml(categorieen) {
    categorieen.forEach((categorie) =>
      document
        .getElementById('categorie')
        .insertAdjacentHTML(
          'beforeend',
          `<option value="${categorie}">${categorie}</option>`
        )
    );
  }

  // toont het aantal producten in div#aantalProducten
  // en de producten in div#overzichtProducten
  #productenToHtml(producten) {
    // toon aantal producten in div#aantalProducten
    const divAantalProducten = document.getElementById('aantalProducten');
    divAantalProducten.innerHTML = `<h4>Aantal producten: ${producten.length}</h4>`;

    const divOverzichtProducten = document.getElementById('overzichtProducten');

    // Overzicht leegmaken (anders komen er altijd maar bij...)
    divOverzichtProducten.innerHTML = '';

    // toon de producten in div#overzichtProducten
    producten.forEach((product) => {
      const divElement = document.createElement('div');
      const imgElement = document.createElement('img');
      const pElement = document.createElement('p');

      divElement.id = product.id;
      imgElement.src = `images/${product.id}/thumbs/thumb_${product.afbeeldingen[0]}.jpg`;
      imgElement.alt = product.titel;
      pElement.textContent = product.titel;

      // stel de event handler in
      divElement.onclick = () => {
        this.#zetProductVetjes(divElement);
        this.#productDetailsToHtml(product);
      };

      // voeg img- en p-element toe aan het div-element
      divElement.appendChild(imgElement);
      divElement.appendChild(pElement);
      // voeg het div-element toe aan het overzicht
      divOverzichtProducten.appendChild(divElement);
    });
  }

  // zet in het productoverzicht, het gekozen product vetjes
  #zetProductVetjes(divElement) {
    // verwijder een eventueel reeds ingestelde class .tekstvet
    document
      .querySelector(`#overzichtProducten .tekstVet`)
      ?.classList.remove('tekstVet');

    // voeg de class .tekstvet toe aan het gekozen product
    divElement.classList.add('tekstVet');
  }

  // toont de details van het gegeven product in de div #productDetails
  #productDetailsToHtml(product) {
    // maak het element #productDetails zichtbaar en leeg
    const divProductDetails = document.getElementById('productDetails');
    divProductDetails.classList.remove('verbergen');
    divProductDetails.innerHTML = '';

    // creëer de 'descendants' voor div#productDetails en voeg ze toe

    const h2Element = document.createElement('h2');
    h2Element.textContent = product.titel;

    const pElement = document.createElement('p');
    pElement.textContent = product.omschrijving;

    const h4Element = document.createElement('h4');
    h4Element.textContent = 'Prijs: €' + product.prijs;

    const divElement = document.createElement('div');
    divElement.id = 'afbeeldingen';

    // voeg de grote afbeelding toe aan divElement
    const imgGroteAfbeelding = document.createElement('img');
    imgGroteAfbeelding.id = 'groteAfbeelding';
    imgGroteAfbeelding.src = `images/${product.id}/${product.afbeeldingen[0]}.jpg`;
    imgGroteAfbeelding.alt = product.titel;
    divElement.appendChild(imgGroteAfbeelding);

    // voeg de 'thumbnails' toe aan het divElement
    const asideElement = document.createElement('aside');
    asideElement.id = 'thumbnails';
    product.afbeeldingen.forEach((afbeelding) => {
      const imgElement = document.createElement('img');
      imgElement.src = `images/${product.id}/thumbs/thumb_${afbeelding}.jpg`;
      imgElement.onclick = () => {
        // wijzig de grote afbeelding als er geklikt
        // wordt op één van de 'thumbnails'
        document.getElementById(
          'groteAfbeelding'
        ).src = `images/${product.id}/${afbeelding}.jpg`;
      };
      asideElement.appendChild(imgElement);
    });
    divElement.appendChild(asideElement);

    divProductDetails.appendChild(h2Element);
    divProductDetails.appendChild(pElement);
    divProductDetails.appendChild(h4Element);
    divProductDetails.appendChild(divElement);
  }
}
