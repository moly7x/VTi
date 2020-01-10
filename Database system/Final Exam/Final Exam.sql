DROP DATABASE IF EXISTS Manage_student;
CREATE DATABASE Manage_student;
USE Manage_student;

DROP TABLE IF EXISTS Student;
CREATE TABLE Student(
	RN		MEDIUMINT UNSIGNED AUTO_INCREMENT,
    `Name`	VARCHAR(20),
    Age		TINYINT	UNSIGNED,
    Gender	ENUM('Male','Female', 'Unknow'),
PRIMARY KEY (RN),
CHECK (6 < Age < 100)
);

DROP TABLE IF EXISTS `Subject`;
CREATE TABLE `Subject`(
	SID		MEDIUMINT UNSIGNED AUTO_INCREMENT,
    SName	VARCHAR(20),
PRIMARY KEY (SID)
);

DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE StudentSubject(
	RN		MEDIUMINT UNSIGNED,
	SID		MEDIUMINT UNSIGNED,
    Mark	FLOAT(4,2),
    `Date`	DATE,
PRIMARY KEY (RN, SID),
CHECK (0<= Mark <= 10)
);

ALTER TABLE StudentSubject
	ADD CONSTRAINT fkey_rn FOREIGN KEY (RN) REFERENCES Student(RN) ON DELETE CASCADE,
    ADD CONSTRAINT fkey_sid FOREIGN KEY (SID) REFERENCES `Subject`(SID) ON UPDATE CASCADE;

-- Insert---------------------
INSERT INTO `student` 
VALUES (1,'Jania',18,'Female'),(2,'Kinny',18,'Male'),(3,'Verene',18,'Female'),(4,'Lizette',17,'Female'),(5,'Nickie',18,'Male'),(6,'Raviv',18,'Male'),(7,'Florence',16,'Female'),(8,'Darnell',16,'Male'),(9,'Datha',16,'Female'),(10,'Tulley',16,'Male'),(11,'Annamarie',18,'Female'),(12,'Nari',16,'Female'),(13,'Noby',17,'Male'),(14,'Lon',16,'Male'),(15,'Paulo',16,'Male'),(16,'Zeke',18,'Male'),(17,'Isahella',18,'Female'),(18,'Lucie',18,'Female'),(19,'Lou',17,'Male'),(20,'Tristan',18,'Male'),(21,'Aube',16,'Male'),(22,'Rosaline',17,'Female'),(23,'Bonni',16,'Female'),(24,'Xever',17,'Male'),(25,'Philipa',17,'Female'),(26,'Siana',18,'Female'),(27,'Tory',17,'Female'),(28,'Vina',18,'Female'),(29,'Almire',17,'Female'),(30,'Lowe',16,'Male'),(31,'Bail',16,'Male'),(32,'Vivia',17,'Female'),(33,'Koenraad',17,'Male'),(34,'Allyson',17,'Female'),(35,'Kerr',17,'Male'),(36,'Erin',16,'Female'),(37,'Kerwinn',18,'Male'),(38,'Allyce',17,'Female'),(39,'Jenda',16,'Female'),(40,'Sandro',16,'Male'),(41,'Thacher',16,'Male'),(42,'Lilli',16,'Female'),(43,'Vincenty',18,'Male'),(44,'Galen',18,'Male'),(45,'Gwenny',16,'Female'),(46,'Munmro',17,'Male'),(47,'Clarie',17,'Female'),(48,'Randy',16,'Male'),(49,'Tonie',17,'Female'),(50,'Gan',16,'Male');

INSERT INTO `subject` 
VALUES (1,'Maths'),(2,'Algebra'),(3,'Geometry'),(4,'Science'),(5,'Biology'),(6,'Physics'),(7,'Chemistry'),(8,'Geography'),(9,'History'),(10,'P.E'),(11,'Art'),(12,'Music');

INSERT INTO `studentsubject` 
VALUES (1,1,2.68,'2019-12-08'),(2,2,6.08,'2019-11-23'),(2,3,6.62,'2019-11-17'),(4,1,5.64,'2019-12-09'),(5,5,6.56,'2019-10-30'),(6,2,6.14,'2019-09-25'),(7,7,2.19,'2019-10-11'),(8,8,6.67,'2019-12-13'),(9,1,1.63,'2019-12-20');

-- b.a---------------------
SELECT Sname AS 'Subject Name'
FROM `Subject`
WHERE Sid NOT IN (SELECT DISTINCT SID
					FROM StudentSubject);
-- b.b---------------------
SELECT s.Sname AS 'Subject Name', 
		COUNT(ss.SID) AS 'So_lan'
FROM StudentSubject ss
	JOIN `Subject` s ON s.SID = ss.SID
GROUP BY ss.SID
HAVING So_lan >= 2 ;
-- c---------------------
DROP View IF EXISTS StudentInfo;
CREATE VIEW StudentInfo AS
SELECT  st.RN,
		st.`Name`,
        st.Age,
        st.Gender,
		sb.sid,
        sb.Sname,
        ss.Mark,
        ss.`Date`
FROM StudentSubject ss
    JOIN `Subject` sb ON sb.SID = ss.SID
    RIGHT JOIN Student st ON ss.RN = st.RN;

SELECT *
FROM StudentInfo;
-- da---------------------
DELIMITER $$
DROP TRIGGER IF EXISTS CasUpdate $$
CREATE TRIGGER CasUpdate
AFTER UPDATE ON `Subject`
FOR EACH ROW
BEGIN
	DO SLEEP(0.1);
END$$
DELIMITER ;

UPDATE `Subject`
SET Sid = 17
WHERE Sid = 1;
-- db---------------------
DELIMITER $$
DROP TRIGGER IF EXISTS Casdel $$
CREATE TRIGGER Casdel
AFTER DELETE ON Student
FOR EACH ROW
BEGIN
	DO SLEEP(0.1);
END$$
DELIMITER ;

DELETE FROM Student
WHERE RN = 1; 
-- e---------------------
DELIMITER $$
DROP PROCEDURE IF EXISTS del_stu $$
CREATE PROCEDURE del_stu (IN Sname VARCHAR(20), IN Smark FLOAT(4,2))
BEGIN
    IF (Sname = '*') THEN
		BEGIN
			DELETE FROM StudentSubject
				WHERE (Mark < Smark);
			
            UPDATE Student
			SET `NAME` = NULL, AGE= NULL, GENDER = NULL;
        END;
	ELSE
		BEGIN
			DELETE FROM StudentSubject
				WHERE (RN IN (SELECT RN
							  FROM Student
							  WHERE `NAME` = Sname)
					   AND Mark < smark);
	
			UPDATE Student
			SET `NAME` = NULL, AGE= NULL, GENDER = NULL
			WHERE `NAME` = Sname;
        END;
	END IF;
END $$
DELIMITER ;

CALL del_stu('*', 5.66);
SELECT  * FROM StudentSubject;
SELECT  * FROM Student;