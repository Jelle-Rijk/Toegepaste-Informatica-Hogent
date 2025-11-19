<h1> Zoeken en sorteren </h1>

- [Complexiteit](#complexiteit)
- [Zoeken in een array](#zoeken-in-een-array)
  - [Sequentieel zoeken (lineair zoeken)](#sequentieel-zoeken-lineair-zoeken)
  - [Binair zoeken](#binair-zoeken)
    - [In code](#in-code)
- [Sorteren](#sorteren)
  - [Sorteren door selectie](#sorteren-door-selectie)
  - [Sorteren door tussenvoegen](#sorteren-door-tussenvoegen)
  - [Sorteren door samenvoegen](#sorteren-door-samenvoegen)

# Complexiteit

> Tijdscomplexiteit: Hoe lang het duurt om een algoritme uit te voeren.
> Ruimtecomplexiteit: Hoe veel RAM-geheugen een algoritme nodig heeft.
>
> In deze cursus wordt bij de complexiteit / efficiëntie van een algoritme enkel gekeken naar de tijdscomplexiteit (T)

Bij het bepalen van het type algoritme, gaan we altijd uit van het slechtst mogelijke geval. Daarvoor wordt de big O-notatie gebruikt.

| Naam         | Formule              | Beschrijving                                                                  |
| ------------ | -------------------- | ----------------------------------------------------------------------------- |
| Lineair      | T(n) = n             | Als de input verdubbelt, verdubbelt de uitvoeringstijd.                       |
| Kwadratisch  | T(n) = n<sup>2</sup> | Als input verdubbelt, gaat de uitvoeringstijd maal 4.                         |
| Exponentieel | T(n) = 2<sup>n</sup> | Als de input met één element verhoogd wordt, verdubbelt de uitvoeringstijd.   |
| Logaritmisch | T(n) = log(n)        | Als de input verdubbelt, komt er een constante waarde bij de uitvoeringstijd. |
| Constant     | T(n) = c             | Als input wijzigt, verandert de uitvoeringstijd niet.                         |

Complexiteit bepalen wordt meestal gedaan door de vaakst uit te voeren vergelijking te nemen en te kijken hoe vaak deze wordt uitgevoerd met verschillende groottes van arrays.

# Zoeken in een array

We gaan er hier vanuit dat de array random accessable is.

## Sequentieel zoeken (lineair zoeken)

**T(n) = (O)n**

= alle elementen één voor één onderzoeken

Eenvoudig te implementeren, zowel in gesorteerde als niet-gesorteerde lijsten.

Je moet enkel kunnen checken of elementen gelijk zijn aan elkaar of niet.

## Binair zoeken

**T(n) = O(log<sub>2</sub>(n))**

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

Linker- en rechterindices worden gebruikt omdat dit memory efficient is (in tegenstelling tot subarrays kopiëren)

Het midden m bereken je met de formule: (l + r) / 2 <br>
<i>Dit betekent dat het midden bij even lengtes altijd op het laagste element gelegd wordt. (vb. n = 7 -> m = 3)</i>

Het algoritme moet het eerste voorkomen van het element in de lijst weergeven, daarom mag je m niet returnen als m het element al bevat. Dit kan foute resultaten geven als het element meerdere keren voorkomt. Je stopt het algoritme enkel als l = r

### In code

```python
def zoek_binair_iteratief(zoekItem, rij):
    l = 0
    r = len(rij) - 1

    while l != r:
        m = (l + r) // 2
        if rij[m] < zoekItem:
            l = m + 1
        else:
            r = m

    return l if rij[l] == zoekItem else -1

def recursief_binair_zoeken_driver(zoekItem, rij):
    return zoekRecursief(zoekItem, rij, 0, len(rij) - 1)

def zoek_binair_recursief(zoekItem, rij, l, r):
    if l == r: #basisgeval, er is maar 1 element
        return l if rij[l] == zoekItem else -1

    m = l + r // 2
    if rij[m] < zoekItem:
        zoekRecursief(zoekItem, rij, m + 1, r) # zoek rechts
    else:
        zoekRecursief(zoekItem, rij, l, m) # zoek links

```

# Sorteren

Sorteren is een belangrijke voorwaarde voor veel andere algoritmes (waaronder binair zoeken).

## Sorteren door selectie

**T(n) = O(n<sup>2</sup>)**

Je zoekt het grootste element en plaatst het achteraan (wisselen met het laatste element). Je doet dit opnieuw met dezelfde rij maar negeert de al gesorteerde elementen. Dit doe je tot je alle elementen hebt gesorteerd.

<figure>
<img src="./img/selection_sort.png">
<figcaption> Je loopt van n - 1 tot en met 1 (want als er maar 1 element is, dan is het al gesorteerd). Elke keer neem je de laatste positie. Je zet die positie ook als waarde voor de max. Dan zoek je de max van alle elementen voor dat element. Als je een groter element vindt dan de huidige max, wordt dat de nieuwe max en wordt de index van dat element de nieuwe positie. Als je op het einde komt, verwissel je het element op positie met het element op de laatste positie (i)</figcaption>
</figure>

## Sorteren door tussenvoegen

**T(n) = O(n<sup>2</sup>)**

Je overloopt de array en laat al gesorteerde elementen staan. Als je een niet-gesorteerd element tegenkomt, plaats je het op de juiste plaats in het al gesorteerde deel. <br>
Als je het element in het gesorteerde deel invoegt, swap je het element telkens naar voren tot het wel juist is.

<img src="./img/insertion_sort.png">

Insertion sort is te verkiezen boven selection sort, omdat insertion sort in bepaalde gevallen wel sneller is dan selection sort. De worst case time complexity is bij beide hetzelfde.

## Sorteren door samenvoegen

Je splitst de array op in twee helften. Je sorteert die helften en voegt dan terug samen.

- Je sorteert recursief de eerste en tweede helft van de array.
- Je mengt de gesorteerde deelrijen in één nieuwe gesorteerde array.

<figure>
<img src="./img/mergesort-driver.png">
<figcaption>Driverfunctie</figcaption>
</figure>

<figure>
<img src="./img/mergesort-recursive.png">
<figcaption>Deze functie splitst de array recursief op en roept dan merge aan om de twee gesorteerde deelarrays samen te voegen. In de recursieve functies worden de originele array en enkele tellers meegegeven. Zo nemen de deelarrays geen extra geheugen in, het sorteren gebeurt in-place (we duiden de deelrij immers gewoon aan met de tellers).</figcaption>
</figure>

<figure>
<img src="./img/mergesort-merge-vars.png">
<img src="./img/mergesort-merge-function.png">
<figcaption>Beide rijen en een hulprij worden doorlopen. Je vergelijkt beide eerste elementen en plaatst het kleinste in de hulprij. Tellers van de rij waarvan je genomen hebt en de hulprij gaan eentje omhoog. Als een rij leeg is, moet de overgebleven rest van de andere rij in één keer toegevoegd worden. Op het einde wordt de originele array vervangen door de nieuwe gesorteerde hulprij. Het gebruik van hulprijen zorgt ervoor dat er voor deze stap extra geheugen nodig is.</figcaption>
</figure>
