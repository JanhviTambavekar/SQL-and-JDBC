package com.Jdbc;
import java.sql.Connection;  // Import the standard JDBC Connection
import java.sql.DriverManager;
import java.sql.SQLException;
public class oracleConnection
{
	public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "SYSTEM"; 
        String password = "SYS";   
        
        // Declare a Connection object of type java.sql.Connection
        Connection connection = null;

        try {
            // Load the Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish the connection to the Oracle database
            connection = DriverManager.getConnection(url, username, password);

            // Print a success message
            System.out.println("Connection established successfully!");

        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException (Driver not found)
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQLException (Connection issues)
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
