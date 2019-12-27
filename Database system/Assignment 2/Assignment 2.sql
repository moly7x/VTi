-- EXERCISE 1
-- Question 1: Create the tables
DROP DATABASE IF EXISTS Fresher_training_management;
CREATE DATABASE IF NOT EXISTS Fresher_training_management;

USE Fresher_training_management;

DROP TABLE IF EXISTS Trainee;
CREATE TABLE IF NOT EXISTS Trainee (
		Traineeid 			INT AUTO_INCREMENT,
        Full_name 			VARCHAR(25),
        Birth_date 			DATE,
        Gender 				ENUM('M','F','U'),
        Et_iq 				TINYINT UNSIGNED,
        Et_gmath 			TINYINT UNSIGNED,
        Et_english 			TINYINT UNSIGNED,
        Training_class 		CHAR(10),
        Evaluation_notes 	VARCHAR(500),

-- Key and constraint
PRIMARY KEY (Traineeid),
CHECK (0 <= Et_iq      	<= 20),
CHECK (0 <= Et_gmath    <= 20),
CHECK (0 <= Et_english 	<= 50)
);


-- Question 2: Change the table TRAINEE to add one more field named VTI_Account 
ALTER TABLE Trainee
	ADD COLUMN Vti_account VARCHAR(50) NOT NULL UNIQUE;



-- Exercise 2: Data Types
DROP TABLE IF EXISTS Data_types_1;
CREATE TABLE IF NOT EXISTS Data_types_1 (
	ID 				INT AUTO_INCREMENT,
    Full_name		VARCHAR(50),
    Code_id			CHAR(5),
    Modified_date	DATE,

-- KEY and CONSTRAINT
PRIMARY KEY (Id)
);



-- Exercise 3: Data Types (2)
DROP TABLE IF EXISTS Data_types_2;
CREATE TABLE IF NOT EXISTS Data_types_2 (
	ID 				INT AUTO_INCREMENT,
    Full_name		VARCHAR(50),
    Modified_date	DATE,
    Gender			SMALLINT UNSIGNED,
    Isdeleted		SMALLINT,

-- KEY and CONSTRAINT
PRIMARY KEY (Id),
CHECK (Gender IN (NULL, 0, 1)),
CHECK (Isdeleted IN (0, 1))
);