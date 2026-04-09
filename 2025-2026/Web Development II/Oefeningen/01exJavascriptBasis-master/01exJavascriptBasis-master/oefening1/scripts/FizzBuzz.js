"use strict";

const input = Number(prompt("Enter a number"));

let output = "";
if (isNaN(input)) output = "not a number";
else {
  if (input % 3 === 0) output += "Fizz";
  if (input % 5 === 0) output += "Buzz";
  if (output === "") output = input;
}
console.log(output);
