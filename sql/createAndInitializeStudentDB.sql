-- COMP 3005 Assignment 3 Question 1
-- By Ibraheem Refai
-- 101259968
-- Last Updated March 18, 2024


-- Creating the students table
CREATE TABLE students (
    student_id SERIAL PRIMARY KEY, -- Using SERIAL for auto-incrementing integer
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    enrollment_date DATE
);


-- Inserting initial data into the students table
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');