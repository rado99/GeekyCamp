Create schema Univercity default character set utf8;
Use Univercity;
Create table Students(
CourseNumber INT Primary key Auto_increment,
firstName Varchar(64),
lastName Varchar(64),
facultyId INT);
Create table courses(
ID INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(128),
Description Varchar(256),
credits SMALLINT UNSIGNED);
Create table faculty(
ID INT PRIMARY KEY AUTO_INCREMENT,
Name Varchar(128));
Create table coursesStudents(
courseID INT,
studentId INT);
INSERT INTO faculty(Name) VALUES('ФКСУ'), ('МФ'), ('ЕЕ');
