import * as helpers from '../modules/helpers.js';

const btn1 = document.getElementById('btn1');
const btn2 = document.getElementById('btn2');
const btn3 = document.getElementById('btn3');

// 1. Creëer een nieuw XMLHttpRequest-object.
const xhr = new XMLHttpRequest();

btn1.onclick = () => {
  // 2. Initializeer het object met de Open-methode
  //      .open(method, URL, [async, user, password])
  xhr.open('GET', '../data/part1.txt');
  // xhr.open(
  //   'GET',
  //   'https://raw.githubusercontent.com/plauwaer/tijdelijk/main/part1.txt'
  // );

  // 3. 'Send' de http-request.
  //    Deze methode opent een connectie en verstuurt
  //    de http-request naar de server.
  helpers.addMessage('- BEFORE request send');
  // xhr.send() is een asynchrone opdracht
  xhr.send();
  // onderstaande tekst wordt onmiddellijk weergegeven ook al is
  // de asynchrone opdracht nog niet afgerond
  helpers.addMessage('- AFTER request send');

  // de callback-functie zal pas uitgevoerd worden als de asynchrone
  // XMLHttpRequest-opdracht afgerond is!!
  xhr.onload = () => {
    helpers.addMessage(`- xhr.status (HTTP-statuscode): ${xhr.status}`);
    helpers.setText(xhr.responseText);
  };
};

btn2.onclick = () => {
  helpers.addMessage(`- xhr.status (HTTP-statuscode): ${xhr.status}`);
  helpers.setText(xhr.responseText);
};

btn3.onclick = () => {
  helpers.clearMessages();
  helpers.clearText();
};
