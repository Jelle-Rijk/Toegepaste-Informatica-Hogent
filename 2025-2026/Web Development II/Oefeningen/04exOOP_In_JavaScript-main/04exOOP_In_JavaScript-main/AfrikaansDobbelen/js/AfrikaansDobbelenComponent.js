import Speler from "./Speler.js";
import Dobbelsteen from "./Dobbelsteen.js";
import Spel from "./Spel.js";
/***********************************
Deze klasse vormt de lijm tussen ons domein (Dobbelsteen) en de HTML pagina
als de gebruiker iets wijzigt op de html pagina gaat het domein aangesproken worden en de
web pagina aangepast worden. Voorbeeld: de gebruiker rolt de dobbelsteen
De AfrikaansDobbelenComponent gaat de methode rol aanspreken in de domeinklasse Dobbelsteen
*/

export default class AfrikaansDobbelen {
  #spel;

  constructor() {
    this.#spel = new Spel(this.#geefSpelers());
    document.getElementById("play").onclick = () => {
      this.#spel.speel();
      this.#toHtml();
    };
    document.getElementById("scorebord").addEventListener("click", () => {
      alert(this.#spel.scoreOverzicht);
    });
  }

  #geefSpelers() {
    const aantalSpelers = Number(prompt("Met hoeveel spelers gaan we spelen?"));
    const spelers = [];
    for (let i = 0; i < aantalSpelers; i++) {
      spelers.push(prompt(`Geef de naam van speler ${i + 1}`));
    }
    return spelers;
  }

  #toHtml() {
    const spelerAanZet = this.#spel.spelerAanZet;
    document.getElementById("speler").innerText =
      `Speler aan zet: ${spelerAanZet.naam}`;
    const dobbelstenen = this.#spel.spelerAanZet.dobbelstenen;
    for (let i = 0; i < dobbelstenen.length; i++)
      document
        .getElementById(`${i + 1}`)
        .setAttribute("src", `images/Dice${dobbelstenen[i].aantalOgen}.PNG`);
    document.getElementById("score").innerText =
      `Score = ${spelerAanZet.score}`;

    if (!this.#spel.heeftWinnaar) {
      if (document.getElementById("play").value === "Rol dobbelstenen") {
        document.getElementById("play").value = "Volgende speler";
        document.getElementById("play").onclick = () => {
          this.#spel.bepaalVolgendeSpeler();
          this.#toHtml();
        };
      } else {
        document.getElementById("play").value = "Rol dobbelstenen";
        document.getElementById("play").onclick = () => {
          this.#spel.speel();
          this.#toHtml();
        };
      }
    }
  }
}

/***************************************************************************************** */
/* onderstaand stukje code heb je pas in de laatste stap van de oefening nodig (zie opgave) */
/***************************************************************************************** */
