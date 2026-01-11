-- Mad Max Fury Road
SET @directorFN = "George";
SET @directorLN = "Miller";
SET @videoTitle = "Mad Max: Fury Road";
SET @cat = "Action";

INSERT INTO CrewMember (firstName, lastName) VALUES ("George", "Miller"),("Charlize", "Theron"),("Tom", "Hardy"),("Nicholas", "Hoult");
INSERT INTO Category (description) VALUE (@cat);
INSERT INTO Video (title, dailyRental, cost, director, category) VALUE (@videoTitle, True, 6.99, (Select id FROM CrewMember WHERE firstName = @directorFN AND lastName = @directorLN), (Select id FROM Category WHERE description = @cat));

INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Charlize" AND lastName = "Theron"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Tom" AND lastName = "Hardy"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Nicholas" AND lastName = "Hoult"));

-- Ready Player One
SET @directorFN = "Steven";
SET @directorLN = "Spielberg";
SET @videoTitle = "Ready Player One";
SET @cat = "Sci-fi";

INSERT INTO CrewMember (firstName, lastName) VALUES ("Steven", "Spielberg"),("Tye", "Sheridan"),("Olivia", "Cooke"),("Ben", "Mendelsohn");
INSERT INTO Category (description) VALUE (@cat);
INSERT INTO Video (title, dailyRental, cost, director, category) VALUE (@videoTitle, True, 6.99, (Select id FROM CrewMember WHERE firstName = @directorFN AND lastName = @directorLN), (Select id FROM Category WHERE description = @cat));

INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Tye" AND lastName = "Sheridan"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Olivia" AND lastName = "Cooke"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Ben" AND lastName = "Mendelsohn"));

-- Inception
SET @directorFN = "Christopher";
SET @directorLN = "Nolan";
SET @videoTitle = "Inception";
SET @cat = "Thriller";

INSERT INTO CrewMember (firstName, lastName) VALUES ("Christopher", "Nolan"),("Joseph", "Gordon-Levitt"),("Elliot", "Page"),("Leonardo", "DiCaprio");
INSERT INTO Category (description) VALUE (@cat);
INSERT INTO Video (title, dailyRental, cost, director, category) VALUE (@videoTitle, True, 6.99, (Select id FROM CrewMember WHERE firstName = @directorFN AND lastName = @directorLN), (Select id FROM Category WHERE description = @cat));

INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Joseph" AND lastName = "Gordon-Levitt"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Elliot" AND lastName = "Page"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Leonardo" AND lastName = "DiCaprio"));

-- Titanic
SET @directorFN = "James";
SET @directorLN = "Cameron";
SET @videoTitle = "Titanic";
SET @cat = "Drama";

INSERT INTO CrewMember (firstName, lastName) VALUES ("James", "Cameron"),("Kate", "Winslet"),("Billy", "Zane"),("Kathy", "Bates"),("Frances", "Fisher");
INSERT INTO Category (description) VALUE (@cat);
INSERT INTO Video (title, dailyRental, cost, director, category) VALUE (@videoTitle, True, 6.99, (Select id FROM CrewMember WHERE firstName = @directorFN AND lastName = @directorLN), (Select id FROM Category WHERE description = @cat));

INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Kate" AND lastName = "Winslet"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Billy" AND lastName = "Zane"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Kathy" AND lastName = "Bates"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Frances" AND lastName = "Fisher"));
INSERT INTO MainActor (video, actor) VALUE ((Select id FROM video WHERE title = @videoTitle), (Select id FROM CrewMember WHERE firstName = "Leonardo" AND lastName = "DiCaprio"));


-- LOCATIONS
INSERT INTO State (code, name) VALUES
('AL', 'Alabama'),
('AK', 'Alaska'),
('AZ', 'Arizona'),
('AR', 'Arkansas'),
('CA', 'California'),
('CO', 'Colorado'),
('CT', 'Connecticut'),
('DE', 'Delaware'),
('FL', 'Florida'),
('GA', 'Georgia'),
('HI', 'Hawaii'),
('ID', 'Idaho'),
('IL', 'Illinois'),
('IN', 'Indiana'),
('IA', 'Iowa'),
('KS', 'Kansas'),
('KY', 'Kentucky'),
('LA', 'Louisiana'),
('ME', 'Maine'),
('MD', 'Maryland'),
('MA', 'Massachusetts'),
('MI', 'Michigan'),
('MN', 'Minnesota'),
('MS', 'Mississippi'),
('MO', 'Missouri'),
('MT', 'Montana'),
('NE', 'Nebraska'),
('NV', 'Nevada'),
('NH', 'New Hampshire'),
('NJ', 'New Jersey'),
('NM', 'New Mexico'),
('NY', 'New York'),
('NC', 'North Carolina'),
('ND', 'North Dakota'),
('OH', 'Ohio'),
('OK', 'Oklahoma'),
('OR', 'Oregon'),
('PA', 'Pennsylvania'),
('RI', 'Rhode Island'),
('SC', 'South Carolina'),
('SD', 'South Dakota'),
('TN', 'Tennessee'),
('TX', 'Texas'),
('UT', 'Utah'),
('VT', 'Vermont'),
('VA', 'Virginia'),
('WA', 'Washington'),
('WV', 'West Virginia'),
('WI', 'Wisconsin'),
('WY', 'Wyoming');

INSERT INTO City (name, state) VALUES
('Birmingham', 'AL'),
('Anchorage', 'AK'),
('Phoenix', 'AZ'),
('Little Rock', 'AR'),
('Los Angeles', 'CA'),
('Denver', 'CO'),
('Hartford', 'CT'),
('Wilmington', 'DE'),
('Miami', 'FL'),
('Atlanta', 'GA'),
('Honolulu', 'HI'),
('Boise', 'ID'),
('Chicago', 'IL'),
('Indianapolis', 'IN'),
('Des Moines', 'IA'),
('Wichita', 'KS'),
('Louisville', 'KY'),
('New Orleans', 'LA'),
('Portland', 'ME'),
('Baltimore', 'MD'),
('Boston', 'MA'),
('Detroit', 'MI'),
('Minneapolis', 'MN'),
('Jackson', 'MS'),
('Kansas City', 'MO'),
('Billings', 'MT'),
('Omaha', 'NE'),
('Las Vegas', 'NV'),
('Manchester', 'NH'),
('Newark', 'NJ'),
('Albuquerque', 'NM'),
('New York City', 'NY'),
('Charlotte', 'NC'),
('Fargo', 'ND'),
('Columbus', 'OH'),
('Oklahoma City', 'OK'),
('Portland', 'OR'),
('Philadelphia', 'PA'),
('Providence', 'RI'),
('Charleston', 'SC'),
('Sioux Falls', 'SD'),
('Nashville', 'TN'),
('Houston', 'TX'),
('Salt Lake City', 'UT'),
('Burlington', 'VT'),
('Richmond', 'VA'),
('Seattle', 'WA'),
('Charleston', 'WV'),
('Milwaukee', 'WI'),
('Cheyenne', 'WY');

INSERT INTO City (name, state) VALUES
('Montgomery', 'AL'),
('Fairbanks', 'AK'),
('Tucson', 'AZ'),
('Fayetteville', 'AR'),
('San Francisco', 'CA'),
('Colorado Springs', 'CO'),
('New Haven', 'CT'),
('Dover', 'DE'),
('Orlando', 'FL'),
('Savannah', 'GA'),
('Hilo', 'HI'),
('Idaho Falls', 'ID'),
('Springfield', 'IL'),
('Fort Wayne', 'IN'),
('Cedar Rapids', 'IA'),
('Topeka', 'KS'),
('Lexington', 'KY'),
('Baton Rouge', 'LA'),
('Bangor', 'ME'),
('Annapolis', 'MD'),
('Worcester', 'MA'),
('Grand Rapids', 'MI'),
('Duluth', 'MN'),
('Gulfport', 'MS'),
('St. Louis', 'MO'),
('Missoula', 'MT'),
('Lincoln', 'NE'),
('Reno', 'NV'),
('Concord', 'NH'),
('Jersey City', 'NJ'),
('Santa Fe', 'NM'),
('Buffalo', 'NY'),
('Raleigh', 'NC'),
('Bismarck', 'ND'),
('Cleveland', 'OH'),
('Tulsa', 'OK'),
('Eugene', 'OR'),
('Pittsburgh', 'PA'),
('Newport', 'RI'),
('Greenville', 'SC'),
('Rapid City', 'SD'),
('Memphis', 'TN'),
('Dallas', 'TX'),
('Provo', 'UT'),
('Montpelier', 'VT'),
('Norfolk', 'VA'),
('Spokane', 'WA'),
('Huntington', 'WV'),
('Green Bay', 'WI'),
('Casper', 'WY');

INSERT INTO City (name, state) VALUES
('Huntsville', 'AL'),
('Juneau', 'AK'),
('Flagstaff', 'AZ'),
('Hot Springs', 'AR'),
('San Diego', 'CA'),
('Fort Collins', 'CO'),
('Stamford', 'CT'),
('Newark', 'DE'),
('Tampa', 'FL'),
('Macon', 'GA'),
('Kailua', 'HI'),
('Twin Falls', 'ID'),
('Peoria', 'IL'),
('South Bend', 'IN'),
('Iowa City', 'IA'),
('Lawrence', 'KS'),
('Bowling Green', 'KY'),
('Lafayette', 'LA'),
('Augusta', 'ME'),
('Frederick', 'MD'),
('Springfield', 'MA'),
('Ann Arbor', 'MI'),
('Rochester', 'MN'),
('Vicksburg', 'MS'),
('Columbia', 'MO'),
('Helena', 'MT'),
('Kearney', 'NE'),
('Henderson', 'NV'),
('Keene', 'NH'),
('Paterson', 'NJ'),
('Las Cruces', 'NM'),
('Rochester', 'NY'),
('Asheville', 'NC'),
('Minot', 'ND'),
('Dayton', 'OH'),
('Norman', 'OK'),
('Bend', 'OR'),
('Erie', 'PA'),
('Warwick', 'RI'),
('Spartanburg', 'SC'),
('Brookings', 'SD'),
('Knoxville', 'TN'),
('Austin', 'TX'),
('Ogden', 'UT'),
('Rutland', 'VT'),
('Roanoke', 'VA'),
('Tacoma', 'WA'),
('Parkersburg', 'WV'),
('Appleton', 'WI'),
('Laramie', 'WY');

-- Branches
INSERT INTO Branch (street, housenumber, zipcode, city, state, telephone) VALUES
('Main Street', 101, 12345, 'Birmingham', 'AL', 2055550101),
('Oak Avenue', 202, 23456, 'Anchorage', 'AK', 9075550202),
('Pine Road', 303, 34567, 'Phoenix', 'AZ', 6025550303),
('Maple Lane', 404, 45678, 'Little Rock', 'AR', 5015550404);

-- POSITIONS
INSERT INTO JobRole (code, description) VALUES
('MGRS', 'Store Manager'),
('ASTM', 'Assistant Store Manager'),
('CSRS', 'Customer Service Representative'),
('CLRK', 'Rental Clerk'),
('CASH', 'Cashier'),
('STCK', 'Inventory and Stock Associate'),
('TECH', 'Media and Equipment Technician'),
('MKTS', 'Marketing and Promotions Coordinator'),
('ACCT', 'Accounting and Billing Specialist'),
('ITSP', 'IT Support Specialist');

-- Branch 1
INSERT INTO Employee (firstName, lastName, salary, branch, position) VALUES
-- Management
('Karen', 'Mitchell', 4200, 1, 'MGRS'),
('Daniel', 'Reed', 3200, 1, 'ASTM'),

-- Customer-facing staff (most common)
('Emily', 'Carter', 2600, 1, 'CSRS'),
('Jason', 'Miller', 2550, 1, 'CSRS'),
('Sarah', 'Lopez', 2500, 1, 'CSRS'),

('Brian', 'Thompson', 2400, 1, 'CLRK'),
('Amanda', 'Nguyen', 2350, 1, 'CLRK'),
('Kevin', 'Brown', 2300, 1, 'CLRK'),
('Laura', 'Wilson', 2300, 1, 'CLRK'),

('Mark', 'Anderson', 2250, 1, 'CASH'),
('Natalie', 'Perez', 2200, 1, 'CASH'),

-- Inventory / operations
('Steven', 'Harris', 2450, 1, 'STCK'),
('Rachel', 'Kim', 2400, 1, 'STCK'),

-- Technical / specialist roles
('Anthony', 'Roberts', 3000, 1, 'TECH'),
('Olivia', 'Scott', 3100, 1, 'ITSP'),

-- Office / support roles
('Michael', 'Evans', 2800, 1, 'MKTS'),
('Linda', 'Walker', 2900, 1, 'ACCT');

-- Branch 2
INSERT INTO Employee (firstName, lastName, salary, branch, position) VALUES
('Robert', 'King', 4100, 2, 'MGRS'),
('Angela', 'Moore', 3150, 2, 'ASTM'),

('Chris', 'Allen', 2600, 2, 'CSRS'),
('Megan', 'Hill', 2550, 2, 'CSRS'),

('Tyler', 'Scott', 2400, 2, 'CLRK'),
('Jessica', 'Adams', 2350, 2, 'CLRK'),
('Ethan', 'Baker', 2300, 2, 'CLRK'),

('Paul', 'Nelson', 2250, 2, 'CASH'),

('Derek', 'Cruz', 2450, 2, 'STCK'),

('Sophia', 'Turner', 3050, 2, 'TECH'),
('Henry', 'Collins', 2900, 2, 'ACCT'),
('Vanessa', 'Brooks', 2800, 2, 'MKTS'),
('Ian', 'Parker', 3000, 2, 'ITSP');

-- Branch 3
INSERT INTO Employee (firstName, lastName, salary, branch, position) VALUES
('Thomas', 'Wright', 4150, 3, 'MGRS'),
('Rebecca', 'Flores', 3250, 3, 'ASTM'),

('Daniel', 'Young', 2600, 3, 'CSRS'),
('Hannah', 'Green', 2550, 3, 'CSRS'),
('Luis', 'Martinez', 2500, 3, 'CSRS'),

('Aaron', 'Lopez', 2400, 3, 'CLRK'),
('Nicole', 'Hall', 2350, 3, 'CLRK'),

('Samantha', 'Rivera', 2250, 3, 'CASH'),
('Jordan', 'Price', 2200, 3, 'CASH'),

('Victor', 'Ramirez', 2450, 3, 'STCK'),

('Kevin', 'Howard', 3000, 3, 'TECH'),
('Emily', 'Ross', 2950, 3, 'ACCT'),
('Brandon', 'Stewart', 2800, 3, 'MKTS'),
('Olga', 'Petrov', 3050, 3, 'ITSP');

-- Branch 4
INSERT INTO Employee (firstName, lastName, salary, branch, position) VALUES
('Susan', 'Bennett', 4200, 4, 'MGRS'),
('Matthew', 'Gray', 3300, 4, 'ASTM'),

('Olivia', 'Ward', 2600, 4, 'CSRS'),
('Noah', 'Coleman', 2550, 4, 'CSRS'),

('Ryan', 'Foster', 2400, 4, 'CLRK'),
('Paige', 'Sullivan', 2350, 4, 'CLRK'),
('Dylan', 'Reynolds', 2300, 4, 'CLRK'),

('Amber', 'Jenkins', 2250, 4, 'CASH'),

('Caleb', 'Ortiz', 2450, 4, 'STCK'),

('Marcus', 'Lee', 3100, 4, 'TECH'),
('Elaine', 'Murphy', 2950, 4, 'ACCT'),
('Trevor', 'Hughes', 2850, 4, 'MKTS'),
('Priya', 'Shah', 3050, 4, 'ITSP');

UPDATE Branch 
SET 
    manager = (SELECT 
            id
        FROM
            Employee
        WHERE
            employee.branch = branch.id
                AND employee.position = 'MGRS')
WHERE
    manager IS NULL;

-- MEMBERS
INSERT INTO Member (firstName, lastName, street, housenumber, zipCode, city, state) VALUES
('James', 'Smith', 'Maple Street', 12, 12345, 'Birmingham', 'AL'),
('Mary', 'Johnson', 'Oak Avenue', 34, 23456, 'Anchorage', 'AK'),
('Robert', 'Williams', 'Pine Road', 56, 34567, 'Phoenix', 'AZ'),
('Patricia', 'Brown', 'Cedar Lane', 78, 45678, 'Little Rock', 'AR'),
('John', 'Jones', 'Elm Street', 90, 56789, 'Los Angeles', 'CA'),
('Linda', 'Garcia', 'Birch Drive', 23, 67890, 'Denver', 'CO'),
('Michael', 'Miller', 'Spruce Street', 45, 78901, 'Hartford', 'CT'),
('Elizabeth', 'Davis', 'Willow Lane', 67, 89012, 'Wilmington', 'DE'),
('William', 'Rodriguez', 'Chestnut Ave', 89, 90123, 'Miami', 'FL'),
('Barbara', 'Martinez', 'Poplar Street', 11, 11234, 'Atlanta', 'GA'),

('Richard', 'Hernandez', 'Cypress Drive', 22, 22345, 'Honolulu', 'HI'),
('Susan', 'Lopez', 'Aspen Lane', 33, 33456, 'Boise', 'ID'),
('Joseph', 'Gonzalez', 'Magnolia Ave', 44, 44567, 'Chicago', 'IL'),
('Jessica', 'Wilson', 'Fir Street', 55, 55678, 'Indianapolis', 'IN'),
('Charles', 'Anderson', 'Pinecone Rd', 66, 66789, 'Des Moines', 'IA'),
('Sarah', 'Thomas', 'Hickory Lane', 77, 77890, 'Wichita', 'KS'),
('Daniel', 'Taylor', 'Walnut Ave', 88, 88901, 'Louisville', 'KY'),
('Karen', 'Moore', 'Maple Drive', 99, 99012, 'New Orleans', 'LA'),
('Matthew', 'Jackson', 'Oak Street', 13, 10123, 'Portland', 'ME'),
('Nancy', 'Martin', 'Birch Lane', 24, 21234, 'Baltimore', 'MD'),

('Anthony', 'Lee', 'Spruce Ave', 35, 32345, 'Boston', 'MA'),
('Betty', 'Perez', 'Willow Street', 46, 43456, 'Detroit', 'MI'),
('Mark', 'Thompson', 'Chestnut Lane', 57, 54567, 'Minneapolis', 'MN'),
('Dorothy', 'White', 'Poplar Drive', 68, 65678, 'Jackson', 'MS'),
('Steven', 'Harris', 'Cypress Street', 79, 76789, 'Kansas City', 'MO'),
('Helen', 'Sanchez', 'Aspen Ave', 80, 87890, 'Billings', 'MT'),
('Paul', 'Clark', 'Magnolia Lane', 91, 98901, 'Omaha', 'NE'),
('Sandra', 'Ramirez', 'Fir Drive', 14, 10234, 'Las Vegas', 'NV'),
('George', 'Lewis', 'Pine Street', 25, 21345, 'Manchester', 'NH'),
('Carol', 'Robinson', 'Hickory Ave', 36, 32456, 'Newark', 'NJ'),

('Kenneth', 'Walker', 'Walnut Drive', 47, 43567, 'Albuquerque', 'NM'),
('Shirley', 'Young', 'Maple Lane', 58, 54678, 'New York City', 'NY'),
('Joshua', 'Allen', 'Oak Street', 69, 65789, 'Charlotte', 'NC'),
('Cynthia', 'King', 'Birch Ave', 70, 76890, 'Fargo', 'ND'),
('Brian', 'Wright', 'Spruce Lane', 81, 87901, 'Columbus', 'OH'),
('Deborah', 'Scott', 'Willow Drive', 92, 98012, 'Oklahoma City', 'OK'),
('Edward', 'Torres', 'Chestnut Street', 15, 10345, 'Portland', 'OR'),
('Margaret', 'Nguyen', 'Poplar Lane', 26, 21456, 'Philadelphia', 'PA'),
('Ronald', 'Hill', 'Cypress Ave', 37, 32567, 'Providence', 'RI'),
('Laura', 'Flores', 'Aspen Street', 48, 43678, 'Charleston', 'SC'),

('Jason', 'Green', 'Magnolia Drive', 59, 54789, 'Sioux Falls', 'SD'),
('Rebecca', 'Adams', 'Fir Lane', 60, 65890, 'Nashville', 'TN'),
('Jeffrey', 'Baker', 'Pine Drive', 71, 76901, 'Houston', 'TX'),
('Dorothy', 'Gonzales', 'Hickory Street', 82, 87012, 'Salt Lake City', 'UT'),
('Ryan', 'Nelson', 'Walnut Lane', 93, 98123, 'Burlington', 'VT'),
('Stephanie', 'Carter', 'Maple Drive', 16, 10456, 'Richmond', 'VA'),
('Gary', 'Mitchell', 'Oak Lane', 27, 21567, 'Seattle', 'WA'),
('Kimberly', 'Perez', 'Birch Drive', 38, 32678, 'Charleston', 'WV'),
('Nicholas', 'Roberts', 'Spruce Street', 49, 43789, 'Milwaukee', 'WI'),
('Amy', 'Turner', 'Willow Lane', 50, 54890, 'Cheyenne', 'WY');

-- Registrations
INSERT INTO MemberRegistration (branch, member, registrationDate) VALUES
(1, 5, '2003-07-12'),
(3, 12, '2011-03-25'),
(2, 20, '2005-09-17'),
(4, 7, '2018-11-02'),
(1, 3, '2001-02-14'),
(2, 14, '2007-06-19'),
(3, 25, '2015-12-30'),
(4, 6, '2002-08-21'),
(1, 9, '2004-04-10'),
(2, 18, '2010-05-05'),

(3, 1, '2006-07-18'),
(4, 22, '2013-09-23'),
(1, 28, '2008-11-11'),
(2, 30, '2017-01-06'),
(3, 33, '2009-03-14'),
(4, 35, '2012-10-20'),
(1, 38, '2014-06-28'),
(2, 40, '2001-12-01'),
(3, 42, '2016-02-22'),
(4, 45, '2003-05-17'),

(1, 48, '2005-08-03'),
(2, 2, '2007-01-29'),
(3, 4, '2011-09-13'),
(4, 8, '2019-07-07'),
(1, 11, '2002-03-30'),
(2, 13, '2004-06-18'),
(3, 16, '2009-10-25'),
(4, 19, '2015-12-12'),
(1, 21, '2008-09-02'),
(2, 23, '2010-11-19'),

(3, 26, '2006-02-08'),
(4, 29, '2014-04-15'),
(1, 31, '2007-07-20'),
(2, 34, '2013-05-05'),
(3, 36, '2018-08-21'),
(4, 37, '2009-01-13'),
(1, 39, '2016-03-09'),
(2, 41, '2002-10-27'),
(3, 43, '2017-09-18'),
(4, 44, '2011-12-31'),

(1, 46, '2003-06-04'),
(2, 47, '2015-08-23'),
(3, 49, '2004-11-14'),
(4, 50, '2012-05-30'),
(1, 15, '2001-07-07'),
(2, 17, '2006-03-20'),
(3, 24, '2008-12-01'),
(4, 32, '2010-09-17'),
(1, 27, '2019-01-11'),
(2, 10, '2014-02-05'),

(3, 5, '2002-04-16'),
(4, 12, '2003-10-09'),
(1, 20, '2005-07-29'),
(2, 7, '2009-12-21'),
(3, 3, '2011-08-03'),
(4, 14, '2006-05-27'),
(1, 25, '2010-01-19'),
(2, 6, '2013-03-12'),
(3, 9, '2007-09-25'),
(4, 18, '2012-11-08'),

(1, 1, '2014-06-22'),
(2, 22, '2015-02-18'),
(3, 28, '2008-10-14'),
(4, 30, '2009-07-03'),
(1, 33, '2016-05-26'),
(2, 35, '2011-09-07'),
(3, 38, '2013-12-19'),
(4, 40, '2010-06-30'),
(1, 42, '2004-03-11'),
(2, 45, '2007-08-05'),

(3, 48, '2018-01-23'),
(4, 2, '2002-10-17'),
(1, 4, '2003-09-14'),
(2, 8, '2014-05-28'),
(3, 11, '2001-12-09'),
(4, 13, '2005-04-21'),
(1, 16, '2006-11-06'),
(2, 19, '2009-03-15'),
(3, 21, '2012-07-30'),
(4, 23, '2015-09-12'),

(1, 26, '2016-02-18'),
(2, 29, '2007-05-04'),
(3, 31, '2010-08-23'),
(4, 34, '2013-01-07'),
(1, 36, '2017-11-14'),
(2, 37, '2008-06-26'),
(3, 39, '2004-10-02'),
(4, 41, '2011-12-19'),
(1, 43, '2014-03-08'),
(2, 44, '2002-07-21'),

(3, 46, '2005-09-30'),
(4, 47, '2018-06-16'),
(1, 49, '2003-01-27'),
(2, 50, '2009-04-12'),
(3, 15, '2015-10-05'),
(4, 17, '2012-08-22'),
(1, 24, '2001-06-19'),
(2, 32, '2006-11-30'),
(3, 27, '2007-03-09'),
(4, 10, '2013-05-14'),

(2, 12, '2008-02-02'),
(3, 20, '2011-07-27');
