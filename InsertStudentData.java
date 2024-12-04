package com.Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertStudentData {

	public static void main(String[] args) throws SQLException 
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "SYSTEM"; 
        String password = "SYS";


        // SQL INSERT query
        String query = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";

        try (
            // Establishing the database connection
            Connection connection = DriverManager.getConnection(url, username, password);
            // Creating the PreparedStatement object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Scanner for user input
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Enter student ID:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.println("Enter student name:");
            String name = scanner.nextLine();

            System.out.println("Enter student age:");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.println("Enter student course:");
            String course = scanner.nextLine();

            // Set the parameters in the prepared statement
            preparedStatement.setInt(1, id);       // ID
            preparedStatement.setString(2, name); // Name
            preparedStatement.setInt(3, age);     // Age
            preparedStatement.setString(4, course); // Course

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new student record was inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Database error occurred:");
            e.printStackTrace();
        }

	}

}
