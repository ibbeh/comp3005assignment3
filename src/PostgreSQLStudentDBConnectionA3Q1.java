/* 
COMP 3005 Assignment 3 Question 1
By Ibraheem Refai
101259968
Last Updated March 18, 2024
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class PostgreSQLStudentDBConnectionA3Q1 {
    public static void main(String[] args) {
        //JBDC and Database Credentials for PostgreSQL Connection
        String url = "jdbc:postgresql://localhost:5432/StudentDatabase_A3Q1";
        String user = "postgres";
        String password = "postgres";

        Connection connection = null;
        //Try to establish a connection
        try {
            //Load PostgreSQL JBDC Driver
            Class.forName("org.postgresql.Driver");
            //Establishes a connection to the database using the defined URL, user, and password
            connection = DriverManager.getConnection(url, user, password);
            //If the connection object is not null then the connection to the PostgreSQL database was successful
            if(connection != null) {
                System.out.println("Connected to PostgreSQL successfully!");

                //getAllStudents(connection);
                addStudent(connection, "Mike", "Wazowski", "mikew@cmail.carleton.ca", java.sql.Date.valueOf(LocalDate.of(2020, 9, 1)));


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
        finally {
            if (connection != null) {
                try {
                    //Closing the connection
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    //Function retrieves and displays all records from the students table
    //Accepts a Connection object parameter for the database connection
    private static void getAllStudents(Connection connection) {
        //The SQL query to select all records from the students table
        String SQLQuery = "SELECT * FROM students";
        
        try {
            //Create a statement using the connection
            Statement statement = connection.createStatement();
            //Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(SQLQuery);
            
            while(resultSet.next()) {
                //Retrieve each column value of the current tuple
                int student_id = resultSet.getInt("student_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                Date enrollment_date = resultSet.getDate("enrollment_date");

                //Print the retrieved values in a table format
                System.out.println(String.format("%-10d %-15s %-15s %-30s %-15s", 
                student_id, 
                first_name, 
                last_name, 
                email, 
                enrollment_date));
            }
            //Close resources
            resultSet.close();
            statement.close();
        }
        //Catch exceptions that arise and print error message and stack trace for debugging
        catch (SQLException e) {
            System.out.println("Error retrieving all students! Error message: " + e.getMessage());
            e.printStackTrace();
        }
    }


    //Function inserts a new student record into the students table
    //Accepts a Connection object parameter for the database connection
    //Accepts strings first_name, last_name, email, and Date object enrollment_date for the attributes of the student to be inserted
    private static void addStudent(Connection connection, String first_name, String last_name, String email, Date enrollment_date) {
        //The SQL query to INSERT a new student in the students table using the provided parameters as values
        String SQLQuery = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        
        try {
            //Create a prepared statement using the connection
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery);
             //Set the values of the prepared statement placeholders to the method parameters provided
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, enrollment_date);
            //Execute the insert query and get the number of rows inserted
            int insertedRows = preparedStatement.executeUpdate();
            if (insertedRows > 0) {
                System.out.println("Success: A new student was added successfully!");
            } else {
                System.out.println("Error: No new students were added!");
            }
            //Closing the prepared statement
            preparedStatement.close();
        }
        //Catch exceptions that arise and print error message and stack trace for debugging
        catch (SQLException e) {
            System.out.println("Error adding a new student! Error message: " + e.getMessage());
            e.printStackTrace();
        }
    }


    //Function updates the email address for a student with the specified student_id
    //Accepts a Connection object parameter for the database connection
    //Accepts an int student_id and a String new_email for the new student id and email of the student to be updated
    private static void updateStudentEmail(int student_id, String new_email) {

    }


    //Function deletes the record of the student with the specified student_id
    //Accepts a Connection object parameter for the database connection
    //Accepts an int student_id for the student id of the student to delete
    private static void deleteStudent(int student_id) {

    }

}