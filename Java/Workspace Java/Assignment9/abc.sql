drop database if exists Assignment9;
create database if not exists Assignment9;

use Assignment9;

create table if not exists Trainee
(
	Id int auto_increment primary key,
	UserName varchar(255),
    PassWord varchar(255),
    FirstName varchar(255),
    LastName varchar(255),
    Email varchar(255)
);

insert into Trainee(UserName,PassWord,FirstName,LastName,Email)
values 
('abc','def','ghi','jkl'),
('mno','pqr','stu','vwx');

