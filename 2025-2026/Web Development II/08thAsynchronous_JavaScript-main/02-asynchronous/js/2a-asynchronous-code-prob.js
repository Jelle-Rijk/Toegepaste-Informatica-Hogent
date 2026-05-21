import * as helpers from '../modules/helpers.js';

const btn1 = document.getElementById('btn1');
const btn2 = document.getElementById('btn2');
const btn3 = document.getElementById('btn3');

// 1. Creëer een nieuw XMLHttpRequest-object.
const xhr = new XMLHttpRequest();

btn1.onclick = () => {
  // 2. Initializeer het object met de open-methode
  //      .open(method, URL, [async, user, password])
  xhr.open('GET', '../data/part1.txt');
  // 3. 'Send' de http-request.
  //    Deze methode opent een connectie en verstuurt
  //    de http-request naar de server.
  helpers.addMessage('- BEFORE request send');
  // xhr.send() is een asynchrone opdracht
  xhr.send();

  // onderstaande tekst wordt onmiddellijk weergegeven ook al is
  // de asynchrone opdracht nog niet afgerond
  helpers.addMessage('- AFTER request send');
  // xhr.status zal hier nul bevattten omdat de asynchrone XMLHttpRequest-opdracht
  // nog niet afgerond is.
  helpers.addMessage(`- xhr.status (HTTP-statuscode): ${xhr.status}`);
  helpers.setText(xhr.responseText);
};

btn2.onclick = () => {
  // Tegen de tijd dat we op deze knop klikken is de asynchrone
  // XMLHttpRequest-opdracht afgerond en wordt de correcte
  // HTTP status-code en responseText afgebeeld.
  helpers.addMessage(`- xhr.status (HTTP-statuscode): ${xhr.status}`);
  helpers.setText(xhr.responseText);
};

btn3.onclick = () => {
  helpers.clearMessages();
  helpers.clearText();
};
