"use strict";
const input = prompt("Enter a sentence");

const words = input.split(" ");
for (let i = words.length - 1; i >= 0; i--) console.log(words[i]);
