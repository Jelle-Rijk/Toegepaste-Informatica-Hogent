export default class JokeComponent {
  #url;
  constructor() {
    this.#url =
      "https://v2.jokeapi.dev/joke/Programming,Pun,Spooky?type=twopart";
    document.getElementById("joke").onclick = () => {
      this.#getData();
    };
  }

  //fetch the joke
  #getData() {
    fetch(this.#url)
      .then((res) => {
        if (res.ok) return res.json();
        else throw new Error(`HTTP error: ${res.status}`);
      })
      .then((json) => {
        this.#toHtml(json);
      })
      .catch((error) => console.log(error));
  }

  #toHtml({ category, setup, delivery }) {
    document.getElementById("category").innerText = `Category = ${category}`;
    document.getElementById("setup").innerText = `Q: ${setup}`;
    document.getElementById("delivery").innerText = `A: ${delivery}`;
  }
}
