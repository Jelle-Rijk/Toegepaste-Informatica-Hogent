"use strict";
const getal = Number(prompt("Geef een getal"));

let message;
if (isNaN(getal)) message = "not a number";
else {
  let som = 0;
  for (let i = 0; i <= getal; i += 3) som += i;
  for (let i = 0; i <= getal; i += 5) som += i;
  message = `the sum of multiples of 3 and 5 is ${som}`;
}
console.log(message);
