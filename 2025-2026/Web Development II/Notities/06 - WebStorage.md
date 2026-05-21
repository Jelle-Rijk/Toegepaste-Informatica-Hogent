<h1>WebStorage</h1>

# Cookies

Kleine tekstbestanden (max. 4KB), worden heen en weer gestuurd bij elke HTTP request.

-> Kunnen data leakage veroorzaken.

Lokaal stockeren sinds HTML5:

- Web Storage (Local en Session storage)
- Web SQL Storage => enkel nog in Chrome, support in de toekomst niet gegarandeerd
- IndexedDB = JavaScript-based object-oriented database

# WS Standaard

Is een upgrade voor het cookie-systeem.

- Maximumgrootte = 5MB
- Niet met elke HTTP request verstuurd
- Goede browserondersteuning

Twee soorten: <br>
**LocalStorage**: beschikbaar voor alle vensters van hetzelfde domein (website), is persistent <br>
**SessionStorage**: gekoppeld aan specifiek venster, niet persistent

# WS API, attributen en functies

# JSON Object Storage

Web Storage kan enkel strings opslaan, dus objecten moeten gestored worden als <attr title='JavaScript Object Notation'>JSON</attr>

```javascript
// Omzetten naar JSON
JSON.stringify(data);
// Omzetten van JSON naar JS object
JSON.parse(data);

// Opslaan in en ophalen van webstorage
sessionStorage.setItem(key, JSON.stringify(data));
data = JSON.parse(sessionStorage.getItem(key));
```

Objecten moeten een .toJSON() functie krijgen. Deze zet het object om naar een object literal.

# WS API Event
