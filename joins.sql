CREATE TABLE Customer (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    order_date DATE,
    total_amount DECIMAL(10, 2),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

INSERT INTO Customer (customer_id, first_name, last_name)
VALUES(1, 'John', 'Doe');
INSERT INTO Customer (customer_id, first_name, last_name)
VALUES(2, 'Jane', 'Smith');
INSERT INTO Customer (customer_id, first_name, last_name)
VALUES(3, 'Emily', 'Jones');

-- Insert data into Orders table
INSERT INTO Orders (order_id, order_date, total_amount, customer_id)
VALUES (101, TO_DATE('2024-11-25', 'YYYY-MM-DD'), 250.50, 1);

INSERT INTO Orders (order_id, order_date, total_amount, customer_id)
VALUES (102, TO_DATE('2024-11-26', 'YYYY-MM-DD'), 300.00, 2);

INSERT INTO Orders (order_id, order_date, total_amount, customer_id)
VALUES (103, TO_DATE('2024-11-27', 'YYYY-MM-DD'), 150.75, NULL);


SELECT 
    Customer.customer_id,
    Customer.first_name,
    Customer.last_name,
    Orders.order_id,
    Orders.order_date,
    Orders.total_amount
FROM 
    Customer
INNER JOIN 
    Orders
ON 
    Customer.customer_id = Orders.customer_id;
 
 
 SELECT 
    Customer.customer_id,
    Customer.first_name,
    Customer.last_name,
    Orders.order_id,
    Orders.order_date,
    Orders.total_amount
FROM 
    Customer
FULL OUTER JOIN 
    Orders
ON 
    Customer.customer_id = Orders.customer_id;
