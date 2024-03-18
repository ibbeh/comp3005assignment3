# COMP 3005 Assignment 3 Question 1 README

Database Interaction with PostgreSQL and Application Programming for COMP 3005 Assignment 3

Author: Ibraheenm Refai  
Student ID: 101259968  
Last Updated: 2024-03-18  

# Video Demonstration
-tbd

# Directory Structure 
```
COMP_3005_Assignment_3/
│
├── src/
│   └── PostgreSQLStudentDBConnectionA3Q1.java
│
├── libraries/
│   └── postgresql-42.7.3.jar
│
│── sql/
│   └── createAndInitializeStudentDB.sql
│
└── README.md
```

# Compilation & Execution Instructions

Navigate to the root directory of the project (COMP_3005_Assignment_3/) and run the following command in a terminal to compile PostgreSQLStudentDBConnectionA3Q1.java:

```
javac -cp ".;libraries/*" src/PostgreSQLStudentDBConnectionA3Q1.java -d src
```

After successful compilation, from the root directory root directory of the project (COMP_3005_Assignment_3/), run the application by executing the following command in a terminal: 

```
java -cp ".;libraries/*;src" PostgreSQLStudentDBConnectionA3Q1
```

## NOTES:   
- On Unix-based system, replace ';' with ':' in the classpath separator.  
- Ensure your PostgreSQL database is running and accessible with the credentials and URL specified in the PostgreSQLStudentDBConnectionA3Q1.java file.  

