CREATE DATABASE experimentdb;
USE experimentdb;

CREATE TABLE employee (
  EmpID INT PRIMARY KEY,
  FullName VARCHAR(100) NOT NULL,
  Gender VARCHAR(10),
  Department VARCHAR(50),
  Designation VARCHAR(50),
   Salary DECIMAL(10,2),
   Phone VARCHAR(15)
    );



CREATE TABLE Attendance (
    AttendanceID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID VARCHAR(20) NOT NULL,
    StudentName VARCHAR(100),
    Date DATE,
    Status VARCHAR(10)
);
		

