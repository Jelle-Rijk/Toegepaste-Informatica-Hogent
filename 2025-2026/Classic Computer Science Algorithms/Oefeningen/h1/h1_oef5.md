Code is [hier](../CCSA-Python-oefeningen-bij-de-leerstof-main/h1_zoeken_en_sorteren/bubble_sort.py) terug te vinden.

| n   | aantal if-statements uitgevoerd |
| --- | ------------------------------- |
| 2   | 1                               |
| 4   | 6                               |
| 8   | 28                              |
| 16  | 120                             |
| 32  | 496                             |
| 64  | 2016                            |

-> Als de input verdubbelt, gaat de tijd x 4

Conclusie: T(n) = O(n<sup>2</sup>)

| Stap | i   | j   | a                 |
| ---- | --- | --- | ----------------- |
| 0    | -   | -   | [13, 7, 8, 1]     |
| 1    | 0   | 3   | [13, 7, 1, 8]     |
| 2    | 0   | 2   | [13, 1, 7, 8]     |
| 3    | 0   | 1   | [**1**, 13, 7, 8] |
| 4    | 1   | 3   | [**1**, 13, 7, 8] |
| 5    | 1   | 2   | [**1, 7**, 13, 8] |
| 6    | 2   | 3   | [**1, 7, 8, 13**] |
