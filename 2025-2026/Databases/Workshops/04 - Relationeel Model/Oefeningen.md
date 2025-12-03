> VS = vreemde sleutel

# Oefening 1 - 1 op N

Leverancier(<u>leverancierNr</u>, naam, straat, huisnummer, gemeente, land)

Grondstof(<u>code</u>, naam, eenheidsprijs, leverancier) <br>
VS leverancier: Leverancier.neverancierNr, verplicht

# Oefening 2 - N op N

Leverancier(<u>leverancierNr</u>, naam, straat, huisnummer, gemeente, land)

Grondstof(<u>code</u>, naam)

Leverancier_Grondstof(<u>leverancierNr</u>, <u>grondstofcode</u>, eenheidsprijs) <br>
VS leverancierNr, verwijst naar Leverancier.leverancierNr, verplicht <br>
VS grondstofcode, verwijst naar Grondstof.code,

# Oefening 3 - 1 op 1

Persoon(<u>rijksregisterNr</u>, voornaam, familienaam, paspoortNr) <br>
VS paspoortNr, verwijst naar Paspoort.paspoortNr, verplicht, uniek

Paspoort(<u>paspoortNr</u>, geldigTot)

# Oefening 4 - The Office

Office(<u>officeId</u>, phoneNumber, size)

SalesPerson(<u>salesPersonId</u>, firstName, lastName, commisionPercentage, yearOfHire, office) <br>
FK office, refers to Office.officeId, mandatory, unique

Product(<u>productId</u>, name, unitPrice)

SalesPerson_Product(<u>salesPersonId</u>, <u>productId</u>, quantity) <br>
FK salesPersonId, refers to SalesPerson.salesPersonId, mandatory <br>
FK productId, refers to Product.productId, mandatory

Customer(<u>customerId</u>, firstName, lastName, city, representative) <br>
FK representative, refers to SalesPerson.salesPersonId, optional

Gift(<u>giftId</u>, description, price, buyer, type)
FK buyer, refers to Customer.customerId, mandatory
FK type, refers to GiftType.giftTypeId, mandatory

GiftType(<u>giftTypeId</u>, description)

# Oefening 5 - Studentenresultaten

Student(<u>stamNr</u>, voornaam, familienaam, email, volgletter, jaar, richting) <br>
VS: volgletter, jaar, richting verwijzen naar Klas en zijn verplicht

Klas(<u>volgletter</u>, <u>jaar</u>, <u>richting</u>, titularis) <br>
VS richting, verwijst naar Richting.code, verplicht <br>
VS titularis, verwijst naar Leerkracht.stamboekNr, verplicht, uniek

Richting(<u>code</u>, naam)

Vak(<u>vakCode</u>, studiepunten, omschrijving)

Leerkracht(<u>stamboekNr</u>, voornaam, familienaam)

Student_Vak(<u>studentnummer</u>, <u>vakcode</u>, resultaat) <br>
VS: studentnummer verwijst naar Student.stamNr, verplicht <br>
VS: vakcode verwijst naar Vak.vakCode, verplicht

Leerkracht_Vak(<u>stamboekNr</u>, <u>vakCode</u>) <br>
VS: stamboekNr, verwijst naar Leerkracht.stamboekNr, verplicht <br>
VS: vakCode, verwijst naar Vak.vakCode, verplicht

# Oefening 6 - Bedrijf - Firmawagens

Medewerker(<u>persoonNummer</u>, voornaam, familienaam, datumInDienst, loon)

Klant(<u>persoonNummer</u>, voornaam, familienaam, contactPersoonVoornaam, contactPersoonFamilienaam)

Arbeider(<u>persoonNummer</u>, ploeg) <br>
_IR: persoonNummer verwijst naar Medewerker.persoonNummer, verplicht_

Bediende(<u>persoonNummer</u>, maaltijdcheques) <br>
_IR: persoonNummer verwijst naar Medewerker.persoonNummer, verplicht_

Verkoper(<u>persoonNummer</u>, commissiePercentage) <br>
_IR: persoonNummer verwijst naar Medewerker.persoonNummer, verplicht_

Firmawagen(<u>nummerplaat</u>, merk, verkoper) <br>
_IR: verkoper verwijst naar Verkoper.persoonNummer, verplicht_

Verkoper\*Klant(<u>verkoper</u>, <u>klant</u>, omzet) <br>
_IR: verkoper verwijst naar Verkoper.persoonNummer_ <br>
_IR: klant verwijst naar Klant.persoonNummer_

# Oefening 7 - Theoretische benadering

A(<u>a1</u>)

Z(<u>z1</u>, z2, e1) <br> _IR: e1 verwijst naar E.e1, optioneel_

A_Z(<u>a1</u>, <u>z1</u>, p) <br> <i>IR: a1 verwijst naar A.a1, verplicht <br>IR: z1 verwijst naar Z.z1, verplicht</i>

E(<u>e1</u>)

R(<u>r2</u>, <u>e1</u>, t1) <br> _IR: e1 verwijst naar E.e1, verplicht <br>IR: t1 verwijst naar T.t1, verplicht_

T(<u>t1</u>, t2)

U(<u>t1</u>, u1) <br> _IR: t1 verwijst naar T.t1, verplicht_

I(<u>t1</u>, i1) <br> _IR: t1 verwijst naar T.t1, verplicht_

O(<u>o1</u>, o2, i1) <br> _IR: i1 verwijst naar I.i1, verplicht, uniek_
