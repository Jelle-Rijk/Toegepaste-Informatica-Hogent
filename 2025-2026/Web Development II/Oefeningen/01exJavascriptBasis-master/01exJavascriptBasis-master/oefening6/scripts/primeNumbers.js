"use strict";

const getal = Number(prompt("Enter a number"));

if (isNaN(getal)) console.log("not a number");
else {
  for (let i = 2; i <= getal; i++) {
    let isPrime = true;
    for (let checkedNumber = i - 1; checkedNumber > 1; checkedNumber--) {
      if (i % checkedNumber === 0) {
        isPrime = false;
        break;
      }
    }
    if (isPrime) console.log(i);
  }
}
