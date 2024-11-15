import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String employeeID;
    private String name;
    private String position;
    private String department;
    private double salary;

    public Employee(String employeeID, String name, String position, String department, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeID + ", Name: " + name + ", Position: " + position + 
               ", Department: " + department + ", Salary: " + salary;
    }
}

class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();
    private final String filePath = "employees.txt";

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void updateEmployee(String employeeID, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID().equals(employeeID)) {
                employees.set(i, updatedEmployee);
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void deleteEmployee(String employeeID) {
        employees.removeIf(emp -> emp.getEmployeeID().equals(employeeID));
        System.out.println("Employee deleted successfully.");
    }

    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
            System.out.println("Employees saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            employees = (ArrayList<Employee>) ois.readObject();
            System.out.println("Employees loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }
}

public class EmployeeSystemApp {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. List Employees");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    Employee newEmployee = new Employee(id, name, position, department, salary);
                    manager.addEmployee(newEmployee);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    String updateID = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Position: ");
                    String newPosition = scanner.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    Employee updatedEmployee = new Employee(updateID, newName, newPosition, newDepartment, newSalary);
                    manager.updateEmployee(updateID, updatedEmployee);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteID = scanner.nextLine();
                    manager.deleteEmployee(deleteID);
                    break;

                case 4:
                    manager.listEmployees();
                    break;

                case 5:
                    manager.saveToFile();
                    break;

                case 6:
                    manager.loadFromFile();
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting Employee Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
