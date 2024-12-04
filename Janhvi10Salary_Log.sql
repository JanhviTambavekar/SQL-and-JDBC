-- Create the Salary_Log table
CREATE TABLE Salary_Log (
    log_id INT PRIMARY KEY,
    employee_id INT,
    new_salary DECIMAL(10, 2),
    change_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO Salary_Log (log_id, employee_id, new_salary) 
VALUES (1, 101, 50000.00);

SELECT * FROM audit_log;
