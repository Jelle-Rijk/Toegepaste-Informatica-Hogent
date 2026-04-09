/**
 * Vraag 2
 * Een string bevat twee getallen die van elkaar gescheiden zijn door een min-teken.
 * Haal het tweede getal uit de string en tel er 10 bij op.
 * Je code moet algemeen bruikbaar zijn. Ze moet bijvoorbeeld ook werken als het min-teken verplaatst wordt.
 * In het onderstaande geval moet er afgeprint worden: Het resultaat is 4869
 */
"use strict";
const orderNumber = "14284-4859";
const splitIndex = orderNumber.indexOf("-");
const secondNumber = +orderNumber.substring(splitIndex + 1) + 10;
console.log(`Het resultaat is ${secondNumber}`);
