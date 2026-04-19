# Wrappers

## Number

| Methode     | Omschrijving                    |
| ----------- | ------------------------------- |
| toFixed(x)  | afronden tot x cijfers na komma |
| toString(x) | x = radix, x is optioneel       |

## String

| Methode             | Omschrijving                           |
| ------------------- | -------------------------------------- |
| str.length()        | aantal tekens                          |
| str.charAt(x)       | teken op index x                       |
| str1.concat(str2)   | returnt een nieuwe concatenated string |
| str.indexOf("s")    | zelfde als Java                        |
| str.substring(3, 5) | zelfde als Java                        |
| str.toUpperCase()   | zelfde als Java                        |
| str.toLowerCase()   | zelfde als Java                        |

# Math

| Methode             | Omschrijving                                  |
| ------------------- | --------------------------------------------- |
| Math.round()        | afronden                                      |
| Math.trunc()        | afkappen                                      |
| Math.max(x, y, ...) | grootste getal                                |
| Math.min(x, y, ...) | kleinste getal                                |
| Math.random()       | pseudo-random kommagetal uit interval \[0,1\[ |

# Date

| Methode       | Omschrijving                          |
| ------------- | ------------------------------------- |
| new Date()    | constructor zonder argumenten = nu    |
| getDate()     | returnt dag van de maand              |
| getMonth()    | returnt 0-based maand (11 = december) |
| getFullYear() | returnt jaartal                       |
| gethours()    | returnt uur                           |
| getMinutes()  | returnt minuten                       |
| getSeconds()  | returnt seconden                      |
| getDay()      | returnt 0-based dag van de week       |

# Arrays

| Methode                                           | Omschrijving                                                                            |
| ------------------------------------------------- | --------------------------------------------------------------------------------------- |
| indexOf(element [, startIndex])                   | zoekt eerste index van element in array vanaf startIndex of index 0                     |
| lastIndexOf(element [, fromIndex])                | zelfde als indexOf, maar laatste index                                                  |
| concat()                                          | voegt 2 arrays samen, returnt nieuwe array                                              |
| reverse()                                         | keert volgorde van array om                                                             |
| slice(start, end)                                 | returnt nieuwe array van start tot end                                                  |
| splice(start, numberOfItems, value1, value2, ...) | verwijdert numberOfItems vanaf start, voegt dan de nieuwe waarden vanaf index start toe |
| sort()                                            | sorteert de elementen                                                                   |
| join()                                            | voegt elementen samen in lange string                                                   |

Van de muterende functies bestaan kopiërende versies die een nieuwe array returnen en de originele met rust laten. Meestal in de vorm van: `reverse()` -> `toReversed()`.

# Object

| Methode              | Omschrijving                           |
| -------------------- | -------------------------------------- |
| Object.keys(obj)     | returnt array van keys in obj          |
| Object.values(obj)   | returnt array van values in obj        |
| Object.entries(obj)  | returnt array van [key, value] pairs   |
| obj.toString()       | returnt string voor obj                |
| obj.toLocaleString() | returnt gelokaliseerde string voor obj |
