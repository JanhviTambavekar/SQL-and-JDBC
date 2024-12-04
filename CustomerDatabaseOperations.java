package com.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerDatabaseOperations 
{

    // Database connection details
    static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
    static final String USER = "SYSTEM";  
    static final String PASS = "SYS";     
    public static void insertCustomer(Connection conn) throws SQLException {
        String insertQuery = "INSERT INTO customer (CUSTOMER_ID, FIRST_NAME, LAST_NAME, ADDRESS) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Customer ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume the newline

            System.out.println("Enter First Name: ");
            String firstName = sc.nextLine();

            System.out.println("Enter Last Name: ");
            String lastName = sc.nextLine();

            System.out.println("Enter Address: ");
            String address = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, address);

            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        }
    }

    public static void updateCustomer(Connection conn) throws SQLException {
        String updateQuery = "UPDATE customer SET FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ? WHERE CUSTOMER_ID = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(updateQuery)) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Customer ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.println("Enter new First Name: ");
            String firstName = sc.nextLine();

            System.out.println("Enter new Last Name: ");
            String lastName = sc.nextLine();

            System.out.println("Enter new Address: ");
            String address = sc.nextLine();

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, address);
            ps.setInt(4, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer data updated successfully.");
            } else {
                System.out.println("Customer not found with ID: " + id);
            }
        }
    }

    // Method to delete customer data using ID
    public static void deleteCustomer(Connection conn) throws SQLException {
        String deleteQuery = "DELETE FROM customer WHERE CUSTOMER_ID = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(deleteQuery)) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Customer ID to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer not found with ID: " + id);
            }
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Display a menu for user actions
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("1. Insert Customer");
                System.out.println("2. Update Customer");
                System.out.println("3. Delete Customer");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertCustomer(conn);
                        break;
                    case 2:
                        updateCustomer(conn);
                        break;
                    case 3:
                        deleteCustomer(conn);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
