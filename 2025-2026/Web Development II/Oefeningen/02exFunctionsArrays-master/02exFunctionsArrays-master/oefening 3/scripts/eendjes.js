import { vindBestePositie } from "./eendjesvisser.js";
const eendjes = [5, 2, 4, 1, 1, 5, 4, 4, 3, 2];

console.log(vindBestePositie(eendjes));

const eendjesVanGebruiker = [];
for (let i = 0; i < 10; i++) {
  const eendje = Number(prompt("Geef een getal"));
  eendjesVanGebruiker.push(eendje);
}
console.log(vindBestePositie(eendjesVanGebruiker));
