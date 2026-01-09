<h1>Bijlage - Complexiteitstheorie</h1>

- [Complexiteitsklasse P](#complexiteitsklasse-p)
  - [Turing's stopprobleem](#turings-stopprobleem)
- [Reducties](#reducties)
- [Compleetheid](#compleetheid)
- [Klasse NP](#klasse-np)
- [P versus NP](#p-versus-np)

_Moet niet gedetailleerd gekend zijn._

De bedoeling van de complexiteitstheorie is om makkelijke van moeilijke problemen te onderscheiden. Daarom worden problemen in klassen onderverdeeld.

# Complexiteitsklasse P

=> gemakkelijke problemen, ze kunnen in polynomiale tijd opgelost worden door een deterministisch algoritme

Polynomiale tijd => uitvoeringstijd is O(n<sup>k</sup>) <br> _n = grootte invoer, k = een constante_

De meeste algoritmes uit CCSA zijn van klasse P.

## Turing's stopprobleem

= The Halting Problem

Er bestaat geen algoritme dat bepaalt of een willekeurig programma met een willekeurige input stopt of niet -> Het probleem is **onbeslisbaar**

# Reducties

=> Je herleidt een probleem tot een ander (opgelost)probleem.

vb. Je kan de mediaan bepalen door een rij te sorteren en dan het middelste getal of het gemiddelde van de twee middelste getallen te nemen.

Dit betekent dat het originele probleem nooit moeilijker is dan het gereduceerde probleem.

# Compleetheid

Een probleem is compleet als alle andere problemen van dezelfde klasse naar dit probleem reduceren.

# Klasse NP

NP beschrijft alle problemen die kunnen opgelost worden met een exponentieel algoritme (i.e. brute-forcen) en waarvan de oplossing makkelijk herkend kan worden.

_In de praktijk: Enorm veel problemen behoren tot NP (incl. alle problemen uit klasse P)_

**NP-compleet** => Betekent dat dit probleem minstens zo moeilijk is als alle andere NP problemen.

vb. Traveling Salesman Problem waarbij er gekeken wordt of er een rondreis bestaat die onder een bepaald gewicht blijft.

# P versus NP

P is een deelverzameling van NP

-> Als het makkelijk is om een oplossing te berekenen (P), kan je ook checken of die correct is (NP).

Vraag is: Zijn P en NP hetzelfde? -> Niemand heeft momenteel het antwoord. We denken dat NP strikt groter is dan P, maar er is geen bewijs.

We kunnen het antwoord hierop niet weten, want we weten niet of er in de toekomst een algoritme voor NP-complete problemen wordt gevonden.
