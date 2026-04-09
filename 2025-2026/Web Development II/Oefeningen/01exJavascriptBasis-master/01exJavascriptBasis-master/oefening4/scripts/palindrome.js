"use strict";
const input = prompt("Enter a palindrome").toLowerCase();

let palindrome = true;
for (let i = 0; i < input.length; i++) {
  if (input[i] !== input[input.length - i - 1]) {
    palindrome = false;
    break;
  }
}
console.log(`${input} is${palindrome ? "" : " not"} a palindrome`);
