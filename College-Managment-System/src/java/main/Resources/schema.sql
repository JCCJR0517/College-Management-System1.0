CREATE DATABASE IF NOT EXISTS college_management_system;
USE college_management_system;

CREATE TABLE IF NOT EXISTS students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    address TEXT
);

INSERT INTO students (first_name, last_name, date_of_birth, email, phone, address) VALUES
('John', 'Doe', '2000-01-15', 'john.doe@example.com', '123-456-7890', '123 Main St, Houston, TX'),
('Jane', 'Smith', '1999-05-22', 'jane.smith@example.com', '234-567-8901', '456 Oak St, Houston, TX'),
('Bob', 'Johnson', '2001-08-30', 'bob.johnson@example.com', '345-678-9012', '789 Pine St, Houston, TX');

CREATE TABLE IF NOT EXISTS faculty (
    faculty_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    department VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20)
);

INSERT INTO faculty (first_name, last_name, department, email, phone) VALUES
('Dr. Sarah', 'Lee', 'Computer Science', 'sarah.lee@college.edu', '456-789-0123'),
('Prof. Michael', 'Brown', 'Mathematics', 'michael.brown@college.edu', '567-890-1234'),
('Dr. Emily', 'Davis', 'Physics', 'emily.davis@college.edu', '678-901-2345');

CREATE TABLE IF NOT EXISTS courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    course_code VARCHAR(10) NOT NULL,
    department VARCHAR(50),
    credits INT
);

INSERT INTO courses (course_name, course_code, department, credits) VALUES
('Introduction to Programming', 'CS101', 'Computer Science', 3),
('Calculus I', 'MATH101', 'Mathematics', 4),
('Physics I', 'PHYS101', 'Physics', 4);

CREATE TABLE IF NOT EXISTS enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO enrollments (student_id, course_id, enrollment_date) VALUES
(1, 1, '2024-01-15'),
(1, 2, '2024-01-15'),
(2, 2, '2024-01-16'),
(3, 3, '2024-01-17');

CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

INSERT INTO users (username, password, role) VALUES
('admin', 'adminpasswordhash', 'admin'),
('john.doe', 'hashedpassword123', 'student'),
('sarah.lee', 'facultyhashpass456', 'faculty');

SELECT * FROM students;
SELECT * FROM faculty;
SELECT * FROM courses;
SELECT * FROM enrollments;
SELECT * FROM users;
