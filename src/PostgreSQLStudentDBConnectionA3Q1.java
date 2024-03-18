/* 
COMP 3005 Assignment 3 Question 1
By Ibraheem Refai
101259968
Last Updated March 18, 2024
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

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


//Function retrieves and displays all records fromt he students table
//Accepts a Connection object parameter for the database connection
private static void getAllStudents(Connection connection) {

}


//Function inserts a new student record into the students table
//Accepts a Connection object parameter for the database connection
//Accepts strings first_name, last_name, email, and Date object enrollment_date for the attributes of the student to be inserted
private static void addStudent(String first_name, String last_name, String email, Date enrollment_date) {

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

