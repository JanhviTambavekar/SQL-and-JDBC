package com.Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProductTrigger
{

	public static void main(String[] args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "SYSTEM"; 
        String password = "SYS";

        // SQL to create the trigger
        String createTriggerSQL = "CREATE OR REPLACE TRIGGER after_product_insert\n" +
                "AFTER INSERT ON products\n" +
                "FOR EACH ROW\n" +
                "BEGIN\n" +
                "    INSERT INTO Product_Metadata (product_id, last_modified)\n" +
                "    VALUES (:NEW.product_id, CURRENT_TIMESTAMP);\n" +
                "END;";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement())
        {

            // Execute the SQL to create the trigger
            statement.execute(createTriggerSQL);

            System.out.println("Trigger 'after_product_insert' created successfully.");
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}

}
