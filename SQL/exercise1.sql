-- Create a new table named 'employees'
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    hire_date DATE,
    job_title VARCHAR(50)
);

-- Insert sample data into the 'employees' table
INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, job_title) VALUES
(1, 'John', 'Doe', 'john.doe@example.com', '2021-01-15', 'Software Engineer'),
(2, 'Jane', 'Smith', 'jane.smith@example.com', '2020-03-22', 'Project Manager'),
(3, 'Michael', 'Brown', 'michael.brown@example.com', '2019-07-30', 'Data Analyst');

-- Select all data from the 'employees' table
SELECT * FROM employees;