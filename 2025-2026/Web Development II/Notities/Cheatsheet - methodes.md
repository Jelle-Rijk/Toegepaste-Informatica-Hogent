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
