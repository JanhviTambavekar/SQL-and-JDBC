CREATE TABLE Department (department_id int primary key,department_name VARCHAR(50)
);
 CREATE TABLE Employees ( employee_id int primary key,first_name  VARCHAR(50) ,
last_name  VARCHAR(50) ,department_id int
);

INSERT INTO Department (department_id ,department_name)
VALUES (1,'Testing');
INSERT INTO Department (department_id ,department_name)
VALUES (2,'devlopment');

INSERT INTO Department (department_id ,department_name)
VALUES (3,'acounting');
INSERT INTO Department (department_id ,department_name)
VALUES (4,'HR');


INSERT INTO Employees (employee_id, first_name, last_name, department_id)
VALUES(101, 'Alice', 'Brown', 1);
INSERT INTO Employees (employee_id, first_name, last_name, department_id)
VALUES(102, 'Bob', 'Smith', 2);
INSERT INTO Employees (employee_id, first_name, last_name, department_id)
VALUES(103, 'Charlie', 'Johnson', NULL);

SELECT  Employees.employee_id,
    Employees.first_name,
    Employees.last_name,
    Employees.department_id,
    Department.department_name
    FROM
     Employees
     LEFT OUTER JOIN  Department
        ON Employees .department_id = Department.department_id;
        
        SELECT 
    Employees.employee_id,
    Employees.first_name,
    Employees.last_name,
    Employees.department_id,
    Department.department_id AS dept_id,
    Department.department_name
FROM 
    Employees
RIGHT OUTER JOIN 
    Department
ON 
    Employees.department_id = Department.department_id;
