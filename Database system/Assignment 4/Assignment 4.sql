-- Exercise 1
-- Question 1: Create the tables
DROP DATABASE IF EXISTS Assignment_4;
CREATE DATABASE IF NOT EXISTS Assignment_4;
USE Assignment_4;

CREATE TABLE IF NOT EXISTS Department (
    Department_number 	MEDIUMINT UNSIGNED AUTO_INCREMENT,
    Department_name 	VARCHAR(50),
-- CONSTRAINT
PRIMARY KEY (Department_number)
);

CREATE TABLE IF NOT EXISTS Employee (
    Employee_number 	MEDIUMINT UNSIGNED AUTO_INCREMENT,
    Employee_name 		VARCHAR(50),
    Department_number 	MEDIUMINT UNSIGNED,
-- CONSTRAINT
PRIMARY KEY (Employee_number)
);

CREATE TABLE IF NOT EXISTS Employee_skill (
    Employee_number 	MEDIUMINT UNSIGNED,
    Skill_code 			CHAR(15),
    Date_registered 	DATE, UNIQUE (Employeenumer, Skill_code)
);

-- FOREIGN KEY
ALTER TABLE Employee
	ADD CONSTRAINT Department_number FOREIGN KEY (Department_number) REFERENCES Department(Department_number);

ALTER TABLE Employee_skill
	ADD CONSTRAINT Employee_number FOREIGN KEY (Employee_number) REFERENCES Employee(Employee_number);

-- Question 2: Add at least 10 records
INSERT INTO Department 	(Department_name)
VALUES 				   	('Accounting'),		
						('Economics'),
						('Finance'),
						('Management'),	
						('Marketing'),
						('Information Management');

INSERT INTO Employee 		(Employee_name, 	department_number)
VALUES						('Emil Vega', 			1),
							('Karis Marshall',		2),
							('Atif James',			3),
							('Leen Cunningham', 	4),
							('Adrianna Bartlett',	5),
							('Aqib Brennan',		6),
							('Raheem Noble',		4),
							('Diana Bradshaw',		4),
							('Storm Chang',			4),
							('Haseeb Major',		5);

INSERT INTO Employee_skill 	(Employee_number,		Skill_code,			Date_registered)
VALUE						(1,						'Java',				'2001-06-17'),
							(2,						'C++',				'2002-05-16'),
                            (3,						'C#',				'2003-04-15'),
                            (4,						'Java',				'2004-03-01'),
                            (5,						'Python',			'1999-02-03'),
                            (6,						'C++',				'1998-12-02'),
                            (7,						'Python',			'1997-11-29'),
                            (2,						'C#',				'1995-10-17'),
                            (9,						'C++',				'1989-01-14'),
                            (1,						'Pascal',			'2005-09-12');

-- Question 3: Query all Employee who has Java skill
SELECT 
    e.Employee_number, 
    e.Employee_name, 
    es.Skill_code
FROM
    Employee e
        JOIN
    Employee_skill es 
		ON e.Employee_number = es.Employee_number
WHERE
    Skill_code = 'java';

-- Question 4: Query all department which has more than 3 employee
SELECT 
    d.Department_name, 
    COUNT(e.Department_number) AS so_lan
FROM
    Employee e
        JOIN
    Department d 
		ON e.Department_number = d.Department_number
GROUP BY d.Department_number
HAVING COUNT(e.Department_number) > 3;

-- Question 5: Query all employee of each department. 
SELECT 
    d.Department_name,
    GROUP_CONCAT(e.Employee_name
        SEPARATOR ', ') AS Danh_sach
FROM
    Employee e
		JOIN
    Department d 
		ON e.Department_number = d.Department_number
GROUP BY d.Department_name;

-- Question 6: Query all Employee who has more than 1 skills
SELECT 
    e.Employee_name, 
    COUNT(e.Employee_name) AS Number_languages
FROM
    Employee e
        JOIN
    Employee_skill es 
		ON e.Employee_number = es.Employee_number
GROUP BY e.Employee_name
HAVING COUNT(e.Employee_name) > 1;