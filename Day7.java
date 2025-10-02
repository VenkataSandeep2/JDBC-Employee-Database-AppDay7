import java.sql.*;
import java.util.Scanner;

public class Day7
 {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";     // change if needed
    private static final String PASSWORD = "Sanjay@515"; // change if needed

    private static Connection conn;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // 1. Connect to database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Connected to Database!");

            boolean running = true;
            while (running) {
                System.out.println("\n=== Employee Database Menu ===");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> viewEmployees();
                    case 3 -> updateEmployee();
                    case 4 -> deleteEmployee();
                    case 5 -> {
                        running = false;
                        System.out.println(" Exiting... Goodbye!");
                    }
                    default -> System.out.println("⚠ Invalid choice!");
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(" Database Error: " + e.getMessage());
        }
    }

    // Add employee
    private static void addEmployee() {
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter department: ");
            String dept = sc.nextLine();

            String sql = "INSERT INTO employees (name, salary, department) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, dept);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(" Employee added successfully!");
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    // View employees
    private static void viewEmployees() {
        try {
            String sql = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- Employee Records ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Salary: " + rs.getDouble("salary") +
                        ", Dept: " + rs.getString("department"));
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    private static void updateEmployee() {
        try {
            System.out.print("Enter Employee ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter new department: ");
            String dept = sc.nextLine();

            String sql = "UPDATE employees SET name=?, salary=?, department=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, dept);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(" Employee updated successfully!");
            } else {
                System.out.println("⚠ Employee not found.");
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    // Delete employee
    private static void deleteEmployee() {
        try {
            System.out.print("Enter Employee ID to delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(" Employee deleted successfully!");
            } else {
                System.out.println(" Employee not found.");
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
