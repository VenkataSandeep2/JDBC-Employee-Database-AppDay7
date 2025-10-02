# JDBC-Employee-Database-AppDay7

## 📖 Project Overview
This project is part of my **Java Developer Internship (Task 7)**.  
The goal is to build a **console-based Employee Management Application** using **Java JDBC** and **MySQL**.  
The program allows CRUD operations (Create, Read, Update, Delete) on an `employees` table in the database.  

---

## 🛠️ Features
- ➕ **Add Employee** → Insert new employee records  
- 📜 **View Employees** → Display all employees from the database  
- ✏️ **Update Employee** → Modify existing employee details  
- 🗑️ **Delete Employee** → Remove employee by ID  
- ⚡ Uses **PreparedStatement** to prevent SQL Injection  

---

## 🧑‍💻 Technologies Used
- **Java 17+**  
- **JDBC (Java Database Connectivity)**  
- **MySQL 8.x** (RDBMS)  
- **MySQL Connector/J (JDBC Driver)**  

---

## 📂 Database Setup
Run these commands in MySQL before starting the program:

```sql
CREATE DATABASE company;
USE company;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL,
    department VARCHAR(50) NOT NULL
);
```
output:-
D:\Java Intern>javac -cp ".;mysql-connector-j-8.0.33.jar" Day7.java

D:\Java Intern>java -cp ".;mysql-connector-j-8.0.33.jar" Day7
 Connected to Database!

=== Employee Database Menu ===
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Choose an option: 1
Enter name: san
Enter salary:
20000
Enter department: it
 Employee added successfully!

=== Employee Database Menu ===
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Choose an option: 2

--- Employee Records ---
ID: 1, Name: san, Salary: 20000.0, Dept: it

=== Employee Database Menu ===
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Choose an option: 3
Enter Employee ID to update: 1
Enter new name: san
Enter new salary: 25000
Enter new department: it
 Employee updated successfully!

=== Employee Database Menu ===
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Choose an option: 2

--- Employee Records ---
ID: 1, Name: san, Salary: 25000.0, Dept: it

=== Employee Database Menu ===
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Choose an option:



