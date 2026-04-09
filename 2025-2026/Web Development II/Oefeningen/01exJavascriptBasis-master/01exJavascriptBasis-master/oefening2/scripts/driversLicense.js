"use strict";
const speedLimit = 70;
const kmPerPoint = 5;

const speed = Number(prompt("Wat is je huidige snelheid?"));

if (isNaN(speed)) console.log("Ongeldige invoer");
else if (speed <= speedLimit) console.log("OK");
else {
  const strafPunten = Math.floor((speed - speedLimit) / kmPerPoint);
  console.log(
    strafPunten >= 12
      ? "drivers license is suspended"
      : `points:${strafPunten}`,
  );
}
