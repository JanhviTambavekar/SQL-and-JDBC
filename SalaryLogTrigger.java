package com.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SalaryLogTrigger 
{
	 public static void main(String[] args)
	 {
		  String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
		    String USER = "SYSTEM";  
		    String PASS = "SYS";   

	        // SQL script to create the table and trigger
	        String sqlScript = "CREATE TABLE Salary_Log (\n" +
	                "    log_id INT PRIMARY KEY,\n" +
	                "    employee_id INT,\n" +
	                "    new_salary DECIMAL(10, 2),\n" +
	                "    change_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n" +
	                ");\n" +
	                "CREATE OR REPLACE TRIGGER after_salary_insert\n" +
	                "AFTER INSERT ON Salary_Log\n" +
	                "FOR EACH ROW\n" +
	                "BEGIN\n" +
	                "    INSERT INTO audit_log (message, created_at)\n" +
	                "    VALUES (CONCAT('New salary log inserted with ID: ', :NEW.log_id), SYSDATE);\n" +
	                "END;\n" +
	                "/";

	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             Statement statement = connection.createStatement()) {

	            // Execute the SQL script
	            statement.execute(sqlScript);

	            System.out.println("Table and trigger created successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	 }

}



