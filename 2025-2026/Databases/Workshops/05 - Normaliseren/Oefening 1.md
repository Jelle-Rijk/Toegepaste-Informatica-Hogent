<h1>Oefening 1 - Medewerkers</h1>

# Gegeven

| MedewerkersNr | MedewerkersNaam | ProjectNr | ProjectNaam | AantalUur |
| ------------- | --------------- | --------- | ----------- | --------- |
| 100           | Kevin           | 1000      | Hadoop      | 50        |
| 200           | Els             | 1200      | CRM         | 100       |
| 300           | Annelies        | 1000      | Hadoop      | 40        |
|               |                 | 1200      | CRM         | 85        |
| 400           | Martijn         | 1500      | Java        | 100       |
| 500           | Els             | 1000      | Hadoop      | 120       |
|               |                 | 1800      | Java        | 100       |

# 0NV + FA

R0(<u>medewerkersNr</u>, medewerkersNaam, (projectNr, projectNaam), aantalUur)

MedewerkersNr -> MedewerkersNaam
ProjectNr -> ProjectNaam
MedewerkersNr, ProjectNr -> Projectnaam, AantalUur, MedewerkersNaam

# 1NV

R1.1(<u>medewerkersNr</u>, medewerkerNaam)

R1.2(<u>medewerkersNr</u> <u>projectNr</u>, projectNaam, aantalUur)

# 2NV

R2.1(<u>medewerkerNr</u>, medewerkerNaam)

R2.2(<u>medewerkerNr, projectNr</u>, aantalUur)

R2.3(<u>projectNr</u>, projectNaam)

# 3NV

Zelfde

# Relationeel model

Medewerker(<u>medewerkersNr</u>, medewerkersNaam)

Project(<u>projectNr</u>, projectNaam)

Medewerker_Project(<u>medewerkersNr, projectNr</u>, aantalUur) <br>
<i>IR: medewerkersNr verwijst naar Medewerker, verplicht <br> IR: projectNr verwijst naar Project, verplicht</i>
