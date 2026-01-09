-- H9 oefeningen - slide 16
USE northwind;

/*Geef een lijst van de gebruikers uit hetzelfde land als Maison Dewey.*/
SELECT * FROM Customers
WHERE Country = (SELECT Country FROM Customers WHERE CompanyName = 'Maison Dewey');

/*Geef alle orders waarvoor het leveradres verschillend is van het adres van de klant.*/
-- Subquery
Select * 
From Orders o
WHERE NOT EXISTS (SELECT * FROM Customers WHERE address = o.shipaddress);

-- JOIN
SELECT *
FROM Orders o
	RIGHT JOIN Customers c on o.customerId = c.customerId
WHERE address <> shipaddress;

-- Modeloplossing
SELECT *
FROM Orders o 
WHERE ShipAddress <> (SELECT Address FROM Customers c WHERE o.customerid = c.customerid);

/*Geef per jobtitel de persoon die laatst aangeworven werd.*/
SELECT Title, EmployeeId, CONCAT(FirstName, ' ', LastName) AS EmployeeName, HireDate
FROM Employees e
WHERE HireDate = (SELECT MAX(HireDate) FROM Employees WHERE Title = e.Title);

/*Geef voor elk order detail met korting hoeveel de hoeveelheid verschilt van 
de gemiddelde hoeveelheid van alle order details van hetzelfde product.*/
SELECT OrderID, ProductID, Quantity, 
Quantity - (SELECT AVG(quantity) FROM Order_Details WHERE ProductID = od.ProductID) AS Difference
FROM Order_Details od
WHERE discount <> 0;