<h1> Graafalgoritmes </h1>

- [Terminologie](#terminologie)
- [Datastructuren](#datastructuren)
  - [Adjacentiematrix](#adjacentiematrix)
    - [Tijdscomplexiteit](#tijdscomplexiteit)
  - [Adjacentielijst](#adjacentielijst)
    - [Tijdscomplexiteit](#tijdscomplexiteit-1)
- [Zoeken in grafen](#zoeken-in-grafen)
  - [Generiek zoeken](#generiek-zoeken)
  - [Breedte-Eerst Zoeken](#breedte-eerst-zoeken)
  - [Diepte-Eerst Zoeken](#diepte-eerst-zoeken)
  - [Toepassing: Topologisch sorteren](#toepassing-topologisch-sorteren)

# Terminologie

| Term               | Symbool | Uitleg                           |
| ------------------ | ------- | -------------------------------- |
| Verzameling knopen | V       |
| Verzameling bogen  | E       |
| Graaf              | G       | Meestal genoteerd als G = (V, E) |

Een boog e tussen knoop v en knoop w schrijven we als `e = (v,w)`

- Adjacent -> Twee knopen zijn met elkaar verbonden
- Incident -> Een boog hoort bij een (koppel) kno(o)p(en) / Een knoop hoort bij een boog.
- Buren -> Alle adjacente knopen
- Graad -> Aantal buren van een knoop
- Orde -> Aantal knopen in een graaf (= #(V)), vaak genoteerd als _n_
- Grootte -> Aantal bogen in een graaf (= #(E)), vaak genoteerd als _m_
- Pad -> Opsomming van knopen zodat er een boog tussen de twee knopen ontstaat (lengte = aantal bogen). Een pad van een knoop naar zichzelf heeft lengte 0.
- Enkelvoudige cykel -> pad dat begint en eindigt in dezelfde knoop, waarin alle bezochte knopen verschillend zijn en geen enkele boog meer dan een keer wordt overlopen (= lus). In een gerichte graaf worden beide richtingen als aparte bogen beschouwd.

In het Nederlands is top een synoniem voor knoop.

- **Ongerichte** graaf: De boogparen zijn niet geordend (hebben geen specifieke richting)
- **Gerichte** graaf: De boogparen hebben een richting. Elke boog heeft een **kop** en een **staart** (noteer de bogen steeds van staart naar kop).

_Voorbeeld in de cursus: Graaf van vriendschappen op Facebook is ongericht (vriendschap gaat twee kanten op). Graaf van volgers op Twitter is gericht._

Maximale aantal bogen in een gerichte graaf = n<sup>2</sup>

De buren van een knoop in een gerichte graaf, zijn de knopen die je vanuit de originele knoop kan bereiken.

Een graaf is een **gewogen** graaf als er extra informatie met de bogen geassocieerd wordt.

# Datastructuren

## Adjacentiematrix

Twee mogelijke waarden:

- 1 = boog aanwezig
- 0 = geen boog

Een adjacentiematrix is voor een ongerichte graaf steeds symmetrisch (=> boog is aanwezig in beide richtingen).

<figure>
    <img src='./img/adjacencymatrix.png'>
    <figcaption>Een voorbeeld van een adjacentiematrix van een ongerichte graaf. <br> <em>Er is een boog van a naar b, niet van b naar a.</em></figcaption>
</figure>

Bij een gewogen graaf, kan je het gewicht opslaan per boog i.p.v. een 1 of 0. Er moet dan wel een speciale waarde voorzien worden voor wanneer de knopen niet adjacent zijn.

Neemt O(n<sup>2</sup>) geheugen in (n = aantal knopen in graaf). <br>
_Bij ijle grafen (= aantal bogen is klein t.o.v. maximaal aantal bogen) is veel ruimte verspild._

Als de knopen niet genummerd zijn, wordt meestal een woordenboek gebruikt waarin elk label naar een geheel getal omgevormd wordt (vb. in een hashmap).

### Tijdscomplexiteit

Kijken of twee knopen adjacent zijn => O(1) <br>
_=> Element ophalen uit tweedimensionale array_

Alle buren van een knoop vinden => O(n) <br>
_=> Je moet de rij voor de knoop overlopen._

## Adjacentielijst

Je gebruikt een array. Elke knoop komt overeen met een index. Op deze index plaats je een lijst van buren.

Voordeel: Verspilt geen geheugen. Gebruikte geheugen is `O(aantal knopen + aantal bogen)`

Meestal worden grafen in programmeertalen in adjacentielijsten opgeslagen. Dit is meestal in de vorm van een Map-structuur. Hierin staan de knopen als labels en een lijst van buren als waarde.

### Tijdscomplexiteit

Kijken of twee knopen adjacent zijn => (trager dan bij adjacentiematrix) <br>
_Je overloopt de lijst van buren tot je een match hebt._

Alle buren van een knoop vinden => O(n) <br> (zelfde als bij matrix)

# Zoeken in grafen

## Generiek zoeken

-> Zoeken naar knopen die bereikbaar zijn vanaf een bepaalde knoop.

Je volgt bogen waarvan één knoop wel ontdekt en de andere niet ontdekt is. Als er geen bogen meer zijn die aan die criterium voldoen, heb je alle bereikbare knopen.

```
INVOER: Gerichte of ongerichte graaf G = (V,E), startknoop s. Knopen zijn genummerd van 1 tot n.
UITVOER: Een array D met D[v] = true als er een pad van s naar v bestaat.

function ZoekGeneriek(G,s)
  D <- [false, false, ..., false]                   # initialiseer de array met alles op false
  D[s] <- true                                      # er is een pad van en naar de startknoop
  while ∃(u,v): D[u] = true ^ D[v] = false do       # => lees als: terwijl er een boog u, v bestaat waarvoor u in D true (eg. ontdekt) is en v niet ontdekt is
    kies een boog (u,v) met D[u] = true ^ D[v] = false
    D[v] <- true                                    # v is nu ontdekt gebied
  end while
  return D
end function
```

Hier worden de bogen willekeurig gekozen.

Andere zoekalgoritmes zijn op dit basisprincipe gebaseerd.

## Breedte-Eerst Zoeken

= Breadth-First Search

Je bezoekt eerst de startknoop, dan alle knopen die één boog verwijderd zijn, dan alle knopen die twee bogen verwijderd zijn, etc.

Gebruikt een FIFO wachtrij.

Tijdscomplexiteit = O(n+m)

```
INVOER: Gerichte / ongerichte graaf G = (V,E). Startknoop s.
UITVOER: Array D met D[v] = true als er een pad bestaat van s naar v.

function BreedteEerst(G, s)
  D <- [false, false, ..., false]
  D[s] <- true
  Q.init()                          # initialiseer de queue van knopen
  Q.enqueue(s)
  while Q != ∅ do
    v <- Q.dequeue()                # v = huidige knoop
    for all w ∈ buren(v) do         # overloop alle buren
      if D[w] = false then
        D[w] <- true                # ontdek de niet-ontdekte knoop
        Q.enqueue(w)                # voeg de ontdekte knoop toe aan de queue
      end if
    end for
  end while
  return D
end function
```

In Python:

```python
def breedte_eerst(graph, start_node):
  ''nodes are numbered from 0 to n''
  discovered_nodes = [false for x in graph.nodes()]
  queue = Queue()

  discovered_nodes[start_node] = true
  queue.enqueue(start_node)

  while not queue.is_empty():
    curr_node = queue.dequeue()
    for neighbor in curr_node.get_neighbors():
      if discovered_nodes[neighbor] == false: # buur is nog niet ontdekt
        discovered_nodes[neighbor] = true # buur is nu wel ontdekt
        queue.enqueue(neighbor) # voeg buur toe aan de queue, zodat je later zijn buren ontdekt

  return discovered_nodes
```

## Diepte-Eerst Zoeken

= Depth-First Search

We bekijken eerst de buren van de diepste ontdekte knoop.

Dit algoritme gebruikt hiervoor een stack. In onderstaand recursief algoritme wordt de call-stack gebruikt.

Pseudocode (recursief):

```
INVOER: Gerichte/Ongerichte gaaf G = (V, E). Startknoop s.
UITVOER: Array D, met D[v] = true als er een pad is.

function DiepteEerst(G, s)
  D <- [false, false, ... false]
  DiepteEerstRecursief(G, s, D)
  return D
end function

function DiepteEerstRecursief(G, v, D)      # v is de huidige knoop
  D[v] <- true
  for all w ∈ buren(v) do
    if D[w] = false then                    # de buur werd niet eerder ontdekt
      DiepteEerstRecursief(G, w, D)
    end if
  end for
end function
```

Python:

```python
def depth_first(graph, start_node):
  discovered = [false for x in graph.nodes()]
  depth_first_recursive(graph, start_node, discovered)
  return discovered

def depth_first_recursive(graph, current_node, discovered):
  discovered[current_node] = true
  for neighbor in current_node.neighbors():
    if discovered[neighbor] = false:
      depth_first_recursive(graph, neighor, discovered)
```

## Toepassing: Topologisch sorteren

VERDER VANAF PAGINA 144
