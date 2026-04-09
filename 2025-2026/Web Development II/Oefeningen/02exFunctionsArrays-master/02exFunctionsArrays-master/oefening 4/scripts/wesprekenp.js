import { vertaal } from "./vertaalpepetaapaal.js";
import { vertaalArrayImpl } from "./vertaalpepetaapaalarray.js";

const zin = prompt("Voer een zin in.");
const vertaling = vertaalArrayImpl(zin);
alert(vertaling);
