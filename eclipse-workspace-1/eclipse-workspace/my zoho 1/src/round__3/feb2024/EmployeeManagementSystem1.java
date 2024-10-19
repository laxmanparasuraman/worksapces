package round__3.feb2024;
//Question:
//1.	Given a table containing a set of 10 employees with respective fields:
//ID	Name	Age	Designation	Department	Reporting To
//2.	Show all employee data
//3.	Process the query:
//1.	Get input from the user until presses exit.
//2.	Get field value to compare, comparison operator as input
//1.	If the field value is age (int data type), supported comparators: >, <, !=, ==
//2.	If the field value is of string data type, supported comparators: ‘startswith’, ‘contains’, ‘endswith’, ‘notcontains’, ‘equals’ and ‘notequals’.
//3.	Use ‘AND’ in default for queries with multiple checks.
//4.	Eg: age > 30 and age < 50 and department contains finance and reporting to A
//4.	Show the reporting to hierarchy for the given employee name: J -> I -> F -> D -> C -> B-> A
//5.	Show the employees reporting to the given manager.
//6.	Show summary of Department, Designation, ReportingTo.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String designation;
    private String department;
    private String reportingTo;

    public Employee(int id, String name, int age, String designation, String department, String reportingTo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.department = department;
        this.reportingTo = reportingTo;
    }

    public int getId() {
        return id;
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

    public String getReportingTo() {
        return reportingTo;
    }
}

public class EmployeeManagementSystem1{
    private List<Employee> employees;

    public EmployeeManagementSystem1() {
        employees = new ArrayList<>();
        // Initialize employees (you can modify this part based on your data)
        employees.add(new Employee(1, "A", 40, "Manager", "Finance", null));
        employees.add(new Employee(2, "B", 35, "Team Lead", "Finance", "A"));
        employees.add(new Employee(3, "C", 30, "Analyst", "Finance", "B"));
        employees.add(new Employee(4, "D", 28, "Analyst", "Marketing", "A"));
        employees.add(new Employee(5, "E", 32, "Manager", "Marketing", null));
        employees.add(new Employee(6, "F", 25, "Team Lead", "Marketing", "E"));
        employees.add(new Employee(7, "G", 27, "Analyst", "Marketing", "F"));
        employees.add(new Employee(8, "H", 33, "Analyst", "HR", "E"));
        employees.add(new Employee(9, "I", 29, "Manager", "HR", null));
        employees.add(new Employee(10, "J", 31, "Team Lead", "HR", "I"));
    }

    public void processQuery() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a query (or type 'exit' to end):");
            String query = scanner.nextLine();

            if (query.equalsIgnoreCase("exit")) {
                break;
            }

            if (query.startsWith("age") || query.startsWith("name")) {
                boolean result = evaluateQuery(query);
                System.out.println("Result: " + result);
            } else if (query.startsWith("reporting to")) {
                String name = query.substring(query.indexOf("reporting to") + 12).trim();
                showReportingHierarchy(name);
            } else if (query.startsWith("employees reporting to")) {
                String manager = query.substring(query.indexOf("to") ,query.length());//+ 3).trim();
                showEmployeesReportingTo(manager);
            } else if (query.equals("summary")) {
                showSummary();
            } else {
                System.out.println("Invalid query.");
            }
        }

        scanner.close();
    }

    private boolean evaluateQuery(String query) {
        String[] parts = query.split(" ");
        String field = parts[0];
        String comparator = parts[1];
        String value = parts[2];

        for (Employee employee : employees) {
            if (field.equals("age")) {
                int age = employee.getAge();
                switch (comparator) {
                    case ">":
                        if (age > Integer.parseInt(value)) {
                            System.out.println(employee.getName() + " meets the condition.");
                            return true;
                        }
                        break;
                    case "<":
                        if (age < Integer.parseInt(value)) {
                            System.out.println(employee.getName() + " meets the condition.");
                            return true;
                        }
                        break;
                    case "==":
                        if (age == Integer.parseInt(value)) {
                            System.out.println(employee.getName() + " meets the condition.");
                            return true;
                        }
                        break;
                    case "!=":
                        if (age != Integer.parseInt(value)) {
                            System.out.println(employee.getName() + " meets the condition.");
                            return true;
                        }
                        break;
                    default:
                        break;
                }
            } else if (field.equals("name")) {
                String name = employee.getName();
                switch (comparator) {
                    case "startswith":
                        if (name.startsWith(value)) {
                            System.out.println(employee.getName() + " meets the condition.");
                            return true;
                        }
                        break;
                    case "contains":
                        if (name.contains(value)) {
                            System.out.println(employee.getName() + " meets the condition.");
                            return true;
                        }
                        break;
                    case "endswith":
                        if (name.endsWith(value)) {
                            System.out.println(employee.getName() + " meets the condition.");
                            return true;
                        }
                        break;
                    case "equals":
                        if (name.equals(value)) {
                            System.out.println(employee.getName() + " meets the condition.");
                            return true;
                        }
                        break;
                    case "notequals":
                        if (!name.equals(value)) {
                            System.out.println(employee.getName() + " meets the condition.");
                            return true;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }

    private void showReportingHierarchy(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                String reportingTo = employee.getReportingTo();
                while (reportingTo != null) {
                    System.out.print(reportingTo + " -> ");
                    for (Employee emp : employees) {
                        if (emp.getName().equals(reportingTo)) {
                            reportingTo = emp.getReportingTo();
                            break;
                        }
                    }
                }
                break;
            }
        }
        System.out.println(name);
    }

    private void showEmployeesReportingTo(String manager) {
        System.out.println("Employees reporting to " + manager + ":");
        for (Employee employee : employees) {
            if (employee.getReportingTo() != null && employee.getReportingTo().equals(manager)) {
                System.out.println(employee.getName());
            }
        }
    }

    private void showSummary() {
        System.out.println("Summary:");
        // Department summary
        System.out.println("Department:");
        for (Employee employee : employees) {
            System.out.println(employee.getDepartment());
        }
        // Designation summary
        System.out.println("Designation:");
        for (Employee employee : employees) {
            System.out.println(employee.getDesignation());
        }
        // ReportingTo summary
        System.out.println("Reporting To:");
        for (Employee employee : employees) {
            System.out.println(employee.getReportingTo());
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem1 ems = new EmployeeManagementSystem1();
        ems.processQuery();
    }
}
