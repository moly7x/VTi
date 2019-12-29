DROP DATABASE IF EXISTS Assignment_6;
CREATE DATABASE IF NOT EXISTS Assignment_6;
USE Assignment_6;

DROP TABLE IF EXISTS Employee;
CREATE TABLE IF NOT EXISTS Employee (
    EmployeeID 				MEDIUMINT UNSIGNED AUTO_INCREMENT,
    EmployeeLastName 		VARCHAR(20),
    EmployeeFirstName 		VARCHAR(20),
    EmployeeHireDate 		DATE,
    EmployeeStatus 			ENUM('Still Work', 'Quit Work'),
    SupervisorID 			MEDIUMINT UNSIGNED,
    SocialSecurityNumber 	CHAR(9),
-- Constraint
PRIMARY KEY (EmployeeID)
);

DROP TABLE IF EXISTS Projects;
CREATE TABLE IF NOT EXISTS Projects (
    ProjectID			MEDIUMINT UNSIGNED AUTO_INCREMENT,
	EmployeeID			MEDIUMINT UNSIGNED,
	ProjectName			VARCHAR(50),
	ProjectStartDate	DATE,
	ProjectDescription	VARCHAR(50),
	ProjectDetailt		VARCHAR(500),
	ProjectCompletedOn	DATE,
-- Constraint
PRIMARY KEY (ProjectID)
);

DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE IF NOT EXISTS Project_Modules (
    ModuleID					MEDIUMINT UNSIGNED AUTO_INCREMENT,
	ProjectID					MEDIUMINT UNSIGNED,
	EmployeeID					MEDIUMINT UNSIGNED,
	ProjectModulesDate			DATE,
	ProjectModulesCompledOn		DATE,
	ProjectModulesDescription	VARCHAR(500),
-- Constraint
PRIMARY KEY (ModuleID)
);

DROP TABLE IF EXISTS Work_Done;
CREATE TABLE IF NOT EXISTS Work_Done (
    WorkDoneID			MEDIUMINT UNSIGNED AUTO_INCREMENT,
	EmployeeID			MEDIUMINT UNSIGNED,
	ModuleID			MEDIUMINT UNSIGNED,
	WorkDoneDate		DATE,
	WorkDoneDescription	VARCHAR(500),
	WorkDoneStatus		ENUM('Working','Done'),
-- Constraint
PRIMARY KEY (WorkDoneID)
);

-- Constraint
ALTER TABLE Employee
	ADD FOREIGN KEY (SupervisorID) REFERENCES Employee(EmployeeID) ON DELETE SET NULL; 
    -- Vì Xóa giám sát thì ko còn ai giám sát cả, người khác có thể thay

Alter table Projects
	ADD FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) ON DELETE SET NULL; 
    -- Xóa quản lý project ko có nghĩa là xóa project, người khác có thể thay

Alter table Project_Modules
	ADD FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) ON DELETE SET NULL, 
    -- Xóa người làm modules không có nghĩa modules bị xóa, người khác có thể thay
    ADD FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID) ON DELETE  CASCADE; 
    -- Xóa project đồng nghĩa là sẽ xóa modules trong nó 

Alter table Work_Done
	ADD FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) ON DELETE SET NULL, 
    -- Xóa người làm work_done không có nghĩa work_done bị xóa, người khác có thể thay
    ADD FOREIGN KEY (ModuleID) REFERENCES Project_Modules(ModuleID) ON DELETE CASCADE;
    -- Xóa modules đồng nghĩa là sẽ xóa work trong nó 

INSERT INTO Employee 	(EmployeeLastName,	EmployeeFirstName,	EmployeeHireDate,	EmployeeStatus,	SupervisorID,	SocialSecurityNumber)
VALUES					('Keelan', 			'Gregory',			'2012-12-12',		'Quit Work',	NULL,			610508884),
						('Teddy', 			'Richard',			'2015-10-17',		'Still Work',	NULL,			228673784),
						('Inaayah', 		'Elliott',			'2016-06-17',		'Still Work',	NULL,			841955801),
						('Tia', 			'Christie',			'2014-05-06',		'Still Work',	NULL,			986436073),
						('Francis',			'Plummer',			'2013-06-27',		'Still Work',	NULL,			869134159),
						('Shelly', 			'Wilkinson',		'2015-01-20',		'Still Work',	NULL,			902070759);

INSERT INTO Projects 	(EmployeeID,ProjectName,	ProjectStartDate,	ProjectCompletedOn)
VALUES					(4,			'Report_2018',	'2018-11-20',		'2018-11-30'),
						(3,			'Marketing',	'2019-06-17',		'2019-10-17'),
                        (5,			'Report_2019',	'2019-12-24',		NULL);

INSERT INTO Project_Modules (ProjectID, EmployeeID, ProjectModulesDate, ProjectModulesCompledOn)
VALUES						(1,			1,			'2018-11-27',		'2018-11-29'),
							(1,			4,			'2018-11-28',		'2018-11-27'),
							(1,			3,			'2018-11-29',		'2018-11-29'),
							(2,			4,			'2019-10-03',		'2019-09-24'),
							(2,			3,			'2019-10-15',		'2019-10-15'),
                            (3,			5,			'2020-01-03',		NULL),
                            (3,			2,			'2020-01-06',		NULL);

INSERT INTO Work_Done 	(EmployeeID, 	ModuleID,	WorkDoneDate,	WorkDoneStatus)
VALUES					(1,				1,			'2018-11-29',	'DONE'),
						(4,				2,			'2018-11-25',	'DONE'),
						(4,				2,			'2018-11-26',	'DONE'),
						(3,				3,			'2018-11-28',	'DONE'),
						(4,				4,			'2019-07-21',	'DONE'),
						(4,				4,			'2019-08-13',	'DONE'),
                        (3,				5,			'2019-09-20',	'DONE'),
                        (5,				6,			NULL,			'WORKING'),
                        (2,				7,			'2019-12-29',	'DONE'),
                        (2,				7,			NULL,			'WORKING');

DELIMITER $$
/* Ý tưởng:
+ Đếm: Tạo 3 bảng tạm
Bảng 1 Lấy các ID bị quá của project
Bảng 2 Lấy các ID của module có ID project của bảng 1
Bảng 3 lấy các ID của work có ID của module trong bảng 2
+ Hợp: dùng union ALL hợp 3 bảng thành 1 bảng tạm xong sau đó đếm số lượng trong bảng đó dùng CTE vì bảng này dùng 1 lần
+ Xóa: 
	- Delete các id có trong bảng tạm ID_Project
	- Drop các bảng tạm
*/
DROP PROCEDURE IF EXISTS Delete_date$$
CREATE PROCEDURE Delete_date()
BEGIN
	-- Đếm------------------------------------------------------------------
	DROP TEMPORARY TABLE IF EXISTS ID_project;
	CREATE TEMPORARY TABLE ID_project
	SELECT ProjectID -- tìm các giá trị ID Project có ngày > 3 tháng
	FROM Projects
	WHERE ProjectCompletedOn IN  (SELECT ProjectCompletedOn -- Tìm các ngày > 3 tháng 
								  FROM Projects
								  GROUP BY ProjectCompletedOn
								  HAVING (DATEDIFF(DATE(NOW()), ProjectCompletedON) / 30 >= 3));
	-- ------------------------------------------
	DROP TEMPORARY TABLE IF EXISTS ID_module;
	CREATE TEMPORARY TABLE ID_module
	SELECT ModuleID -- tìm các giá trị ID Module có ID Project bị > 3 tháng
	FROM Project_Modules 
	WHERE ProjectID IN (SELECT * FROM ID_project);
	-- ---------------------------------------------------------------------------------------
	DROP TEMPORARY TABLE IF EXISTS ID_Work;
	CREATE TEMPORARY TABLE ID_Work      
	SELECT WorkDoneID -- tìm các giá trị ID Work_done có ID Module trong danh sách đã tìm
	FROM Work_Done 
	WHERE ModuleID IN (SELECT * FROM ID_module);
	-- Hợp ---------------------------------------------------------------------------------------
	WITH ID_All AS (
	SELECT * FROM ID_project
	UNION ALL
	SELECT * FROM ID_module
	UNION ALL
	SELECT * FROM ID_Work
	)
	SELECT COUNT(*) AS Number_records_deleted FROM ID_ALL;
	-- Xóa---------------------------------------------------------------------------------------
	DELETE FROM Projects WHERE ProjectID IN (SELECT * FROM ID_project); -- Delete từ các id trong bảng tạm
	DROP TEMPORARY TABLE IF EXISTS ID_project;
	DROP TEMPORARY TABLE IF EXISTS ID_module;
	DROP TEMPORARY TABLE IF EXISTS ID_Work;
END$$
DELIMITER ;

DELIMITER $$
/* Ý tưởng:
Tìm các module chưa có ngày hoàn thành thực tế
*/
DROP PROCEDURE IF EXISTS Status_module$$
CREATE PROCEDURE Status_module()
BEGIN
	SELECT 	ModuleID,
			ProjectID,
            EmployeeID
	FROM Project_modules
    WHERE ProjectModulesCompledOn IS NULL;
END$$
DELIMITER ;

DELIMITER $$
/* Ý tưởng:
Tìm các employee không có trạng thái working trong work_done và EmployeeStatus phải là "working"
*/
DROP PROCEDURE IF EXISTS Not_work$$
CREATE PROCEDURE Not_work()
BEGIN
	SELECT 	EmployeeID,
			EmployeeLastName,
            EmployeeFirstName
	FROM Employee
    WHERE EmployeeID NOT IN (SELECT EmployeeID
							 FROM Work_done
							 WHERE WorkDoneStatus = 'Working')
		  AND EmployeeStatus = 'Still Work'
	LIMIT 1;
END$$
DELIMITER ;

-- -------------------------------------------------------------------------------------------------
Call Delete_date;
Call Status_module;
CALL Not_work();