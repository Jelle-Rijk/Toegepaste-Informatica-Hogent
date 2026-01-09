DROP DATABASE mijndatabank;

-- CREËER DE DATABANK
CREATE DATABASE mijndatabank;
USE mijndatabank; 

/*DOELKAART*/
CREATE TABLE DoelKaart
(doelID CHAR(5) NOT  NULL,
naam CHAR(30));