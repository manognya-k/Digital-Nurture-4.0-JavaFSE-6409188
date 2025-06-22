import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task head = null;
        boolean exit = false;

        while (!exit) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Task Status: ");
                    String status = sc.nextLine();
                    head = addTask(head, new Task(id, name, status));
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    Task found = searchTask(head, searchId);
                    if (found != null)
                        System.out.println("Task Found: " + found.taskId + " - " + found.taskName + " (" + found.status + ")");
                    else
                        System.out.println("Task not found.");
                    break;

                case 3:
                    System.out.println("\nAll Tasks:");
                    traverseTasks(head);
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();
                    head = deleteTask(head, deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }

    static Task addTask(Task head, Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println("Task added successfully.");
        return head;
    }

    static Task searchTask(Task head, int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    static void traverseTasks(Task head) {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        while (temp != null) {
            System.out.println(temp.taskId + " - " + temp.taskName + " (" + temp.status + ")");
            temp = temp.next;
        }
    }

    static Task deleteTask(Task head, int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return null;
        }
        if (head.taskId == id) {
            System.out.println("Task deleted.");
            return head.next;
        }

        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
        return head;
    }
}
