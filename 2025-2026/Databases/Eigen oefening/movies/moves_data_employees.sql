-- Branches
INSERT INTO Branch (street, housenumber, zipcode, city, state, telephone) VALUES
('Main Street', 101, 12345, 'Birmingham', 'AL', 2055550101),
('Oak Avenue', 202, 23456, 'Anchorage', 'AK', 9075550202),
('Pine Road', 303, 34567, 'Phoenix', 'AZ', 6025550303),
('Maple Lane', 404, 45678, 'Little Rock', 'AR', 5015550404);

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
