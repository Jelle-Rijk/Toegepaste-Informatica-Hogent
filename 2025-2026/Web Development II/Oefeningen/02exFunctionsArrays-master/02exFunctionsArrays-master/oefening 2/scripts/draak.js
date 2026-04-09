"use strict";

let eindeSpel = false;
let totaleSchade = 0;

function slaDeDraak() {
  const geraakt = Math.random() >= 0.5;
  let schade = 0;
  if (geraakt) schade = Math.floor(Math.random() * 5 + 1);
  return schade;
}

while (!eindeSpel) {
  const schade = slaDeDraak();
  if (schade == 0) {
    eindeSpel = true;
    console.log("Je miste en bent verslaan door de draak.");
  } else {
    totaleSchade += schade;
    console.log(`Je deed ${schade} schade aan de draak.`);
    if (totaleSchade >= 4) {
      eindeSpel = true;
      console.log("Je hebt de draak verslaan. Gefeliciteerd!");
    }
  }
}
