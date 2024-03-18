/* 
COMP 3005 Assignment 3 Question 1
By Ibraheem Refai
101259968
Last Updated March 18, 2024
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLStudentDBConnectionA3Q1 {
    public static void main(String[] args) {
        //JBDC and Database Credentials for PostgreSQL Connection
        String url = "jdbc:postgresql://localhost:5432/StudentDatabase_A3Q1";
        String user = "postgres";
        String password = "postgres";

        //Try to establish a connection
        try {
            //Load PostgreSQL JBDC Driver
            Class.forName("org.postgresql.Driver");
            //Establishes a connection to the database using the defined URL, user, and password
            Connection connection = DriverManager.getConnection(url, user, password);
            //If the connection object is not null then the connection to the PostgreSQL database was successful
            if(connection != null) {
                System.out.println("Connected to PostgreSQL successfully!");
            }
            //Otherwise if the connection object is null the connection failed
            else {
                System.out.println("Error: Failed to establish connection!");
            }
            //Closing the connection
            connection.close();
        }
        //Handle exceptions that arise
        catch (ClassNotFoundException | SQLException e) {
            //Print the stack trace for debugging
            e.printStackTrace();
        }

    }
}