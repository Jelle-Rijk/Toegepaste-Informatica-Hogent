import * as helpers from '../modules/helpers.js';

const btn1 = document.getElementById('btn1');
const btn2 = document.getElementById('btn2');
const btn3 = document.getElementById('btn3');

const xhr1 = new XMLHttpRequest();
const xhr2 = new XMLHttpRequest();

btn1.onclick = () => {
  xhr1.open('GET', '../data/part1.txt');
  helpers.addMessage('- BEFORE request send 1');
  xhr1.send();
  helpers.addMessage('- AFTER request send 1');
  xhr1.onload = () => {
    helpers.addMessage(`HTTP-statuscode part1:  ${xhr1.status}`);
    xhr2.open('GET', '../data/part2.txt');
    helpers.addMessage('- BEFORE request send 2');
    xhr2.send();
    helpers.addMessage('- AFTER request send 2');
    xhr2.onload = () => {
      helpers.addMessage(`HTTP-statuscode part2:  ${xhr2.status}`);
      helpers.setText(xhr1.responseText + xhr2.responseText);
    };
  };
};

btn2.onclick = () => {
  helpers.clearMessages();
  helpers.clearText();
};
