<h1>Domain Object Model</h1>

# DOM

Dom bestaat uit nodes -> boomstructuur

# Elementen manipuleren

`element.innerHTML` = de HTML binnen het element.

`element.innerText` of `element.textContent` = de tekst binnen een element

`element.insertAdjacentHTML(position, html)` = nieuwe html binnen het element toevoegen. <br>
Geldige waarden voor position: beforebegin, afterbegin, beforeend, afterend

## Werken met nodes

`createElement(tagName)` -> tagName is een HTML tag

`createTextNode(text)` -> maakt text om aan de DOM toe te voegen.

`node.appenChild(child)` -> voegt een nieuw element aan de DOM toe als child van de node.

Andere methodes:

- removeChild -> verwijdert child node
- replaceChild -> vervangt child node
- cloneNode -> maakt een clone van een node, als je deepcopy op true zet, dan kopieer je de hele subtree onder de node ook.

Nodes bevatten voor bijna alle HTML-attributen een property met dezelfde naam (uitzondering: class -> className, for -> htmlFor). Voor niet-standaard attributen moet je `element.getAttribute(name)` en `element.setAttribute(name, value)` gebruiken.

> LET OP!
>
> Er zijn enkele HTML-attributen die niet worden aangepast op het moment dat de DOM wordt aangepast. Value binnen inputelementen is daar eentje van.
