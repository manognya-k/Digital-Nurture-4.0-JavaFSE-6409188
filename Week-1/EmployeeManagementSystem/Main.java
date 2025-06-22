public class Main {
    static Employee[] employees = new Employee[5]; 
    static int curr = 0; 

    public static void main(String[] args) {
        addEmployee(new Employee(1, "Alice", "Manager", 5000));
        addEmployee(new Employee(2, "Bob", "Developer", 4000));
        addEmployee(new Employee(3, "Charlie", "Designer", 4500));

        System.out.println("\nEmployees List:");
        traverseEmployees();

        Employee found = searchEmployee(2);
        if (found != null) {
            System.out.println("\nFound: " + found + "\n");
        } else {
            System.out.println("\nEmployee not found\n");
        }

        deleteEmployee(2);

        System.out.println("\nUpdated Employees List:");
        traverseEmployees();
    }

    static void addEmployee(Employee e) {
        if (curr < employees.length) {
            employees[curr++] = e;
            System.out.println("Added: " + e);
        } else {
            System.out.println("Cannot add more employees. Array is full.");
        }
    }

    static Employee searchEmployee(int empId) {
        for (int i = 0; i < curr; i++) {
            if (employees[i].employeeId == empId) {
                return employees[i];
            }
        }
        return null;
    }

    static void traverseEmployees() {
        if (curr == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < curr; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    static void deleteEmployee(int empId) {
        for (int i = 0; i < curr; i++) {
            if (employees[i].employeeId == empId) {
                for (int j = i; j < curr - 1; j++) {
                    employees[j] = employees[j + 1];  // Shift left
                }
                employees[--curr] = null;
                System.out.println("Deleted Employee with ID: " + empId);
                return;
            }
        }
        System.out.println("Employee with ID " + empId + " not found.");
    }
}
