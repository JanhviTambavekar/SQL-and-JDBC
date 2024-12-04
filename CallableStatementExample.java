package com.Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class CallableStatementExample {

	public static void main(String[] args) 
	{

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "SYSTEM"; 
        String password = "SYS";

		String callProcedure = "{CALL InsertStudent(?, ?, ?)}";

        try (
            // Establishing the database connection
            Connection connection = DriverManager.getConnection(url, username, password);
            // Creating a CallableStatement object
            CallableStatement callableStatement = connection.prepareCall(callProcedure);
            // Scanner for user input
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();

            System.out.println("Enter student age:");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.println("Enter student course:");
            String course = scanner.nextLine();

            // Setting input parameters for the stored procedure
            callableStatement.setString(1, name);
            callableStatement.setInt(2, age);
            callableStatement.setString(3, course);

            // Execute the stored procedure
            callableStatement.execute();

            System.out.println("Student record inserted successfully!");
        } catch (SQLException e) {
            System.err.println("Database error occurred:");
            e.printStackTrace();
        }

	}

}
