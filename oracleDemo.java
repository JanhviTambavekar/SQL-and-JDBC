package com.Jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class oracleDemo {

	public static void main(String[] args) throws Exception
	{
	       
		
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Establish the connection to the Oracle Database
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "SYS");

        // Create a statement object to execute the query
        Statement st = con.createStatement();

        // Take the table name as input from the user
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the table name :");
        String tname = br.readLine();

        // Check if the table already exists
        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM user_tables WHERE table_name = '" + tname.toUpperCase() + "'");
        rs.next();
        int count = rs.getInt(1);

        if (count > 0) {
            System.out.println("Table " + tname + " already exists.");
        } else {
            // Create the query to create the table
            String query = "CREATE TABLE " + tname + " (" +
                           "CUSTOMER_ID INT PRIMARY KEY, " +
                           "FIRST_NAME VARCHAR(10), " +
                           "LAST_NAME VARCHAR(10), " +
                           "ADDRESS VARCHAR(10)" +
                           ")";

            // Execute the query to create the table
            st.executeUpdate(query);
            System.out.println(tname + " table is created successfully");
        }

        
	}

}

