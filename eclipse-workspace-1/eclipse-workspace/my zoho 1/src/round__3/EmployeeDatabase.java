package round__3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Employee {
    private String name;
    private int age;
    private String designation;
    private String department;
    private String manager;

    public Employee(String name, int age, String designation, String department, String manager) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.department = department;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public String getManager() {
        return manager;
    }
}

public class EmployeeDatabase {
    private List<Employee> employees;

    public EmployeeDatabase() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void printAllEmployees() {
        System.out.println("Employee Details:");
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName() +
                               ", Age: " + employee.getAge() +
                               ", Designation: " + employee.getDesignation() +
                               ", Department: " + employee.getDepartment() +
                               ", Manager: " + employee.getManager());
        }
    }

    public void searchEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                System.out.println("Employee Found:");
                System.out.println("Name: " + employee.getName() +
                                   ", Age: " + employee.getAge() +
                                   ", Designation: " + employee.getDesignation() +
                                   ", Department: " + employee.getDepartment() +
                                   ", Manager: " + employee.getManager());
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void employeesUnderManager(String managerName, String department) {
        System.out.println("Employees under " + managerName + " in " + department + " department:");
        for (Employee employee : employees) {
            if (employee.getManager().equalsIgnoreCase(managerName) && employee.getDepartment().equalsIgnoreCase(department)) {
                System.out.println("Name: " + employee.getName() +
                                   ", Age: " + employee.getAge() +
                                   ", Designation: " + employee.getDesignation() +
                                   ", Department: " + employee.getDepartment());
            }
        }
    }

    public void printReportingTree(String name, int depth) {
        Map<String, List<String>> reportingMap = new HashMap<>();
        for (Employee employee : employees) {
            if (!reportingMap.containsKey(employee.getManager())) {
                reportingMap.put(employee.getManager(), new ArrayList<>());
            }
            reportingMap.get(employee.getManager()).add(employee.getName());
        }

        printReportingTreeHelper(name, depth, reportingMap);
    }

    private void printReportingTreeHelper(String name, int depth, Map<String, List<String>> reportingMap) {
        if (depth < 0) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(name);
        if (reportingMap.containsKey(name)) {
            for (String subordinate : reportingMap.get(name)) {
                printReportingTreeHelper(subordinate, depth + 1, reportingMap);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeDatabase database = new EmployeeDatabase();

        // Add employees to the database
        database.addEmployee(new Employee("John", 30, "Manager", "HR", ""));
        database.addEmployee(new Employee("Alice", 25, "Employee", "HR", "John"));
        database.addEmployee(new Employee("Bob", 28, "Employee", "HR", "John"));
        database.addEmployee(new Employee("David", 40, "Manager", "IT", ""));
        database.addEmployee(new Employee("Eve", 35, "Employee", "IT", "David"));
        // Add more employees...

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Print all employee details");
            System.out.println("2. Search employee details");
            System.out.println("3. Employees under manager in department");
            System.out.println("4. Print reporting tree");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    database.printAllEmployees();
                    break;
                case 2:
                    System.out.print("Enter employee name to search: ");
                    String searchName = scanner.nextLine();
                    database.searchEmployee(searchName);
                    break;
                case 3:
                    System.out.print("Enter manager name: ");
                    String managerName = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    database.employeesUnderManager(managerName, department);
                    break;
                case 4:
                    System.out.print("Enter employee name for reporting tree: ");
                    String employeeName = scanner.nextLine();
                    database.printReportingTree(employeeName, 0);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
