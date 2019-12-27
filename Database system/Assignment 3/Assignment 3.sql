-- Exercise 1: Continuing with Fresher Training Management Database
USE Fresher_training_management;

-- Question 1: Add at least 10 records into created table
TRUNCATE Trainee;
INSERT Trainee	(Full_name, 		Birth_date, 	Gender, Et_iq, 	Et_gmath, 	Et_english, Training_class, Vti_account)
VALUES			('Austen Traynor', 	'1996-06-22', 	'M', 	8, 		11, 		33, 		1, 				1),
				('Celeste Sanoval',	'2003-04-18', 	'F', 	4, 		19, 		36, 		1, 				2),
				('Siya Forrest', 	'1999-12-03', 	'M', 	2, 		7, 			34, 		1, 				3),
				('Alexandra Price',	'2003-03-18', 	'F', 	1, 		2, 			2, 			1, 				4),
				('Malikah Krueger', '1997-06-14', 	'F', 	8, 		7, 			39, 		1, 				5),
				('Indi Skinner', 	'1997-03-01', 	'M', 	10, 	8, 			8, 			1, 				6),
				('Isobella Scott', 	'1996-02-27', 	'F', 	3, 		3, 			3, 			1, 				7),
				('Nia Britton', 	'1995-11-25', 	'M', 	1, 		7, 			2, 			1, 				8),
				('Holli Sinclair', 	'2003-10-26', 	'M', 	9, 		4, 			34, 		1, 				9),
				('Rubie Peel', 		'2002-12-10', 	'F', 	10, 	1, 			6, 			1, 				10);


-- Question 2: Query all the trainees who is passed the entry test, group them into different birth months
SELECT 
    MONTH(Birth_date) AS Month,
    GROUP_CONCAT(Full_name
        SEPARATOR ', ') AS `Names`
FROM
    Trainee
GROUP BY MONTH(Birth_date)
ORDER BY `Month`;


-- Question 3: Query the trainee who has the longest name
SELECT 
    *, 
    YEAR(NOW()) - YEAR(birth_date) AS Age
FROM
    Trainee
WHERE
    LENGTH(Full_name) = 15; -- Chưa học subqueries


-- Question 4: Query all the ET-passed trainees.
SELECT 
    *
FROM
    Trainee
WHERE
    (ET_IQ + ET_Gmath) >= 20 
		OR ET_IQ >= 8
        OR ET_Gmath >= 8
        OR ET_English >= 18;


-- Question 5: delete information of trainee who has TraineeID = 3
Delete from Trainee where `traineeid` = 3;


-- Question 6: trainee who has TraineeID = 5 move "2" class
UPDATE Trainee 
SET 
    Training_class = 2
WHERE
    Traineeid = 5;

Select * from Trainee;