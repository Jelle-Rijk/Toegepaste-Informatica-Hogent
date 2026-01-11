DROP DATABASE movies;
CREATE DATABASE movies;
USE movies;

CREATE TABLE State (
    code CHAR(2) PRIMARY KEY,
    name VARCHAR(64)
);

CREATE TABLE City (
    name VARCHAR(64),
    state CHAR(2),
    PRIMARY KEY (name , state)
);

CREATE TABLE Employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(32) NOT NULL,
    lastName VARCHAR(32) NOT NULL
);

CREATE TABLE Branch (
    id INT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(64),
    houseNumber INT,
    zipCode INT,
    city VARCHAR(64) NOT NULL,
    state CHAR(2) NOT NULL,
    telephone INT,
    manager INT NOT NULL,
    CONSTRAINT FK_branch_city FOREIGN KEY (city , state)
        REFERENCES City (name , state),
    CONSTRAINT FK_manager FOREIGN KEY (manager)
        REFERENCES Employee (id)
);

CREATE TABLE Member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(32) NOT NULL,
    lastName VARCHAR(32) NOT NULL,
    street VARCHAR(64) NOT NULL,
    houseNumber INT NOT NULL,
    zipCode INT NOT NULL,
    city VARCHAR(64) NOT NULL,
    state CHAR(2) NOT NULL,
    CONSTRAINT FK_member_city FOREIGN KEY (city , state)
        REFERENCES City (name , state)
);

CREATE TABLE MemberRegistration (
    branch INT,
    member INT,
    registrationDate DATE,
    CONSTRAINT fk_registration_branch FOREIGN KEY (branch)
        REFERENCES Branch (id),
    CONSTRAINT fk_registration_member FOREIGN KEY (member)
        REFERENCES Member (id),
    CONSTRAINT pk_registration PRIMARY KEY (branch , member)
);

CREATE TABLE CrewMember(
id INT AUTO_INCREMENT PRIMARY KEY,
firstName VARCHAR(32) NOT NULL,
lastName VARCHAR(32) NOT NULL);

CREATE TABLE Category(
id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(32) NOT NULL
);

CREATE TABLE Video (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(64) NOT NULL,
    dailyRental BOOL NOT NULL,
    cost DECIMAL NOT NULL,
    director INT NOT NULL,
    category INT NOT NULL,
    CONSTRAINT fk_director FOREIGN KEY (director)
        REFERENCES CrewMember (id),
    CONSTRAINT fk_category FOREIGN KEY (category)
        REFERENCES Category (id)
);

CREATE TABLE MainActor (
    video INT,
    actor INT,
    CONSTRAINT pk_mainactor PRIMARY KEY (video , actor),
    CONSTRAINT fk_actors_video FOREIGN KEY (video)
        REFERENCES Video (id),
    CONSTRAINT fk_actor FOREIGN KEY (actor)
        REFERENCES CrewMember (id)
);

CREATE TABLE Copy (
    video INT,
    branch INT,
    nr INT NOT NULL CHECK (nr > 0) DEFAULT (1),
    available BOOL NOT NULL,
    CONSTRAINT pk_copy PRIMARY KEY (video , branch , nr),
    CONSTRAINT fk_copy_video FOREIGN KEY (video)
        REFERENCES Video (id),
    CONSTRAINT fk_copy_branch FOREIGN KEY (branch)
        REFERENCES Branch (id)
);

Delimiter $$ 
CREATE Trigger ins_copy BEFORE INSERT ON copy
for each row
BEGIN 
	SET NEW.nr = (Select Max(nr) + 1 FROM Copy WHERE video = NEW.video and branch = NEW.branch);
END$$
Delimiter ;

CREATE TABLE Rental (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rentalDate DATE NOT NULL,
    returnDate DATE,
    video INT,
    branch INT,
    `copy` INT,
    CONSTRAINT fk_copy FOREIGN KEY (video , branch , `copy`)
        REFERENCES Copy (video , branch , nr),
    CONSTRAINT chk_rental_return_date CHECK (returnDate >= rentalDate)
);
