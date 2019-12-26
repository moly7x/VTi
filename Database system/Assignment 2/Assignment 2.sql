-- EXERCISE 1
DROP DATABASE IF EXISTS fresher_training_management;
CREATE DATABASE IF NOT EXISTS fresher_training_management;

USE fresher_training_management;

DROP TABLE IF EXISTS trainee;
CREATE TABLE IF NOT EXISTS trainee
(
		traineeid 			INT AUTO_INCREMENT,
        full_name 			VARCHAR(25),
        birth_date 			DATE,
        gender 				ENUM('M','F','U'),
        et_iq 				TINYINT UNSIGNED,
        et_math 			TINYINT UNSIGNED,
        et_english 			TINYINT UNSIGNED,
        training_class 		CHAR(10),
        evaluation_notes 	VARCHAR(500),

-- Key and constraint
PRIMARY KEY (traineeid),
CHECK (0 <= et_iq      <= 20),
CHECK (0 <= et_math    <= 20),
CHECK (0 <= et_english <= 50)
);
ALTER TABLE trainee
	ADD COLUMN vti_account VARCHAR(50) NOT NULL UNIQUE;


DROP TABLE IF EXISTS data_types_1;
CREATE TABLE IF NOT EXISTS data_types_1
(
	ID 				INT AUTO_INCREMENT,
    full_name		VARCHAR(50),
    code_id			CHAR(5),
    modified_date	DATE,

-- KEY and CONSTRAINT
PRIMARY KEY (id)
);


DROP TABLE IF EXISTS data_types_2;
CREATE TABLE IF NOT EXISTS data_types_2
(
	ID 				INT AUTO_INCREMENT,
    full_name		VARCHAR(50),
    modified_date	DATE,
    gender			SMALLINT UNSIGNED,
    isdeleted		SMALLINT,

-- KEY and CONSTRAINT
PRIMARY KEY (id),
CHECK (gender IN (NULL, 0, 1)),
CHECK (isdeleted IN (0 , 1))
);
