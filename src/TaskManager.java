import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== TASK PRIORITY MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    completeTask();
                    break;

                case 4:
                    removeTask();
                    break;

                case 5:
                    System.out.println("Exiting Task Priority Manager...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);

        scanner.close();
    }

    public static void addTask() {

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        Task task = new Task(title, priority);
        tasks.add(task);

        System.out.println("Task added successfully.");
    }

    public static void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n===== YOUR TASKS =====");

        for (int i = 0; i < tasks.size(); i++) {

            System.out.print((i + 1) + ". ");
            tasks.get(i).displayTask();
        }
    }

    public static void completeTask() {

        viewTasks();

        if (tasks.isEmpty()) {
            return;
        }

        System.out.print("Enter task number to complete: ");
        int taskNumber = scanner.nextInt();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Task task = tasks.get(taskNumber - 1);

        task.markAsCompleted();

        System.out.println("Task marked as completed.");
    }

    public static void removeTask() {

        viewTasks();

        if (tasks.isEmpty()) {
            return;
        }

        System.out.print("Enter task number to remove: ");
        int taskNumber = scanner.nextInt();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(taskNumber - 1);

        System.out.println("Task removed successfully.");
    }
}