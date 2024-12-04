

CREATE TABLE Customer_New (
    CustomerID NUMBER(10) PRIMARY KEY,
    FirstName VARCHAR2(50),
    LastName VARCHAR2(50),
    Email VARCHAR2(100),
    PhoneNumber VARCHAR2(15),
    Address VARCHAR2(200)
);

INSERT INTO Customer_New (CustomerID, FirstName, LastName, Email, PhoneNumber, Address)
VALUES (1, 'Janhvi', 'tambavekar', 'Janhvit01@gmail.com', '1234567890', ' Thane');

INSERT INTO Customer_New  (CustomerID, FirstName, LastName, Email, PhoneNumber, Address)
VALUES (2, 'kajal', 'gawand', 'kajalg19@gmail.com', '0987654321', ' Bhandup');

SELECT FirstName, LastName, Email FROM customer_new;

SELECT * FROM customer_new WHERE LastName = 'tambavekar';
