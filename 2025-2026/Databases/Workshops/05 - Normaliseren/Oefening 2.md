<h1>Oefening 2 - Theoretisch</h1>

# 0NV + FA

R0(<u>a,b</u>,c,(d,e,f)\*)

- f is samengesteld uit `f1` en `f2`

Functionele Afhankelijkheden:​

- a, b → c​
- a, b, d → e, f​
- d → e, f​
- e → f

# 1NV

R1.1(<u>a, b</u>, c)

R1.2(<u>a, b, d</u>, e, f1, f2)

# 2NV

R2.1(<u>a, b</u>, c)

R2.2(<u>a, b, d</u>)

R2.3(<u>d</u>, e, f1, f2)

# 3NV

R3.1(<u>a, b</u>, c)

R3.2(<u>a, b, d</u>)

R3.3(<u>d</u>, e)

R3.4(<u>e</u>, f1, f2)

# Relationeel model

AB(<u>a, b</u>c)

AB_D(<u>a, b, d</u>)<br>
<i>IR: a en b verwijzen naar AB, verplicht<br>IR: d verwijst naar D, verplicht</i>

D(<u>d</u>, e)
_IR: e verwijst naar E.e, verplicht_

E(<u>e</u>, f1, f2)<br>
