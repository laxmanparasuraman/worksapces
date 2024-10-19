package round__3.feb2024;
//
//public class zsf {
//
//}
import java.util.*;

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

public class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        // Initialize with sample data
        employees.add(new Employee(1, "A", 40, "Manager", "Finance", null));
        employees.add(new Employee(2, "B", 35, "Manager", "Sales", "A"));
        employees.add(new Employee(3, "C", 30, "Executive", "Marketing", "B"));
        employees.add(new Employee(4, "D", 28, "Executive", "Finance", "A"));
        employees.add(new Employee(5, "E", 32, "Executive", "Sales", "B"));
        employees.add(new Employee(6, "F", 45, "Manager", "HR", "A"));
        employees.add(new Employee(7, "G", 25, "Executive", "Finance", "D"));
        employees.add(new Employee(8, "H", 38, "Executive", "Sales", "E"));
        employees.add(new Employee(9, "I", 42, "Manager", "Marketing", "B"));
        employees.add(new Employee(10, "J", 27, "Executive", "HR", "F"));
    }

    public void showAllEmployeeData() {
        for (Employee emp : employees) {
            System.out.println(emp.getId() + "\t" + emp.getName() + "\t" + emp.getAge() + "\t" + emp.getDesignation() + "\t" + emp.getDepartment() + "\t" + emp.getReportingTo());
        }
    }

    public List<Employee> processQuery(String query) {
        // Implement query processing logic here
        // For simplicity, return all employees for now
        return employees;
    }

    public void showReportingToHierarchy(String employeeName) {
        // Implement hierarchy display logic here
        // For simplicity, print a dummy hierarchy for now
        System.out.println("J -> I -> F -> D -> C -> B -> A");
    }

    public List<Employee> getEmployeesReportingTo(String managerName) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getReportingTo() != null && emp.getReportingTo().equals(managerName)) {
                result.add(emp);
            }
        }
        return result;
    }

    public void showSummary() {
        // Implement logic to show summary of Department, Designation, ReportingTo
        // For simplicity, print a dummy summary for now
        System.out.println("Department Summary:");
        System.out.println("Finance: 3 employees");
        System.out.println("Sales: 3 employees");
        System.out.println("Marketing: 2 employees");
        System.out.println("HR: 2 employees");
        System.out.println("Designation Summary:");
        System.out.println("Manager: 4 employees");
        System.out.println("Executive: 6 employees");
        System.out.println("ReportingTo Summary:");
        System.out.println("A: 5 employees");
        System.out.println("B: 3 employees");
        System.out.println("D: 1 employee");
        System.out.println("E: 1 employee");
        System.out.println("F: 1 employee");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter option (1-6) or 'exit':");
            String option = scanner.nextLine();
            if (option.equals("exit")) {
                break;
            }
            switch (option) {
                case "1":
                    ems.showAllEmployeeData();
                    break;
                case "2":
                    System.out.println("Enter query:");
                    String query = scanner.nextLine();
                    ems.processQuery(query);
                    break;
                case "3":
                    System.out.println("Enter employee name:");
                    String empName = scanner.nextLine();
                    ems.showReportingToHierarchy(empName);
                    break;
                case "4":
                    System.out.println("Enter manager name:");
                    String managerName = scanner.nextLine();
                    List<Employee> employeesReportingTo = ems.getEmployeesReportingTo(managerName);
                    System.out.println("Employees reporting to " + managerName + ":");
                    for (Employee emp : employeesReportingTo) {
                        System.out.println(emp.getName());
                    }
                    break;
                case "5":
                    ems.showSummary();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
