# Zoeken en sorteren

## Zoeken in een array

### Sequentieel zoeken (lineair zoeken)
= alle elementen één voor één onderzoeken

Eenvoudig te implementeren, zowel in gesorteerde als niet-gesorteerde lijsten.

Je moet enkel kunnen checken of elementen gelijk zijn aan elkaar of niet.

### Binair zoeken
-> Zoekt eerst het middelste item. Splitst dan op in twee gelijke helften tot er maar één element meer over is.

Array moet al gesorteerd zijn.

Item kleiner dan middelste? -> Zoek in de rechterhelft <br>
Item groter dan middelste? -> Zoek in linkerhelft

Implementatie kan recursief of iteratief.

Je moet kunnen checken of elementen gelijk zijn aan en elkaar en je moet kunnen berekenen welk element groter / kleiner is.

<strong> Variabelen </strong>
- n = lengte array
- l = linkerpositie (init: 0)
- r = rechterpositie (init: n - 1)
