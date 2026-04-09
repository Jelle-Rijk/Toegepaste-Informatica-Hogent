/**
 * Genereer een willekeurig geheel getal tussen 20 en 50 (grenzen inbegrepen)
 * en schrijf één van de volgende boodschappen naar de Console:
 *  Het willekeurig getal ligt in het interval [20,30[
 *  Het willekeurig getal ligt in het interval [30,40[
 *  Het willekeurig getal ligt in het interval [40,50]
 */

"use strict";
const getal = Math.floor(Math.random() * 31) + 20;
const interval = getal < 30 ? "[20,30[" : getal < 40 ? "[30,40[" : "[40,50]";
console.log(`Het willekeurig getal ligt in het interval ${interval}`);
