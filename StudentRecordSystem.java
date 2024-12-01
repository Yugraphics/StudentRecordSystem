import java.util.Scanner;
import java.util.HashMap;

class StudentRecord {
    String name;
    String course;

    public StudentRecord(String name, String course) {
        this.name = name;
        this.course = course;
    }
}

public class StudentRecordSystem {
    private HashMap<String, StudentRecord> hashTable;
    private Scanner scanner;

    public StudentRecordSystem() {
        hashTable = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addRecord() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student course: ");
        String course = scanner.nextLine();
        hashTable.put(id, new StudentRecord(name, course));
    }

    public void searchRecord() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        StudentRecord record = hashTable.get(id);
        if (record != null) {
            System.out.println("Name: " + record.name);
            System.out.println("Course: " + record.course);
        } else {
            System.out.println("Record not found.");
        }
    }

    public void updateRecord() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        StudentRecord record = hashTable.get(id);
        if (record != null) {
            System.out.print("Enter new name: ");
            record.name = scanner.nextLine();
            System.out.print("Enter new course: ");
            record.course = scanner.nextLine();
        } else {
            System.out.println("Record not found.");
        }
    }

    public void deleteRecord() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        hashTable.remove(id);
    }

    public void displayRecords() {
        for (StudentRecord record : hashTable.values()) {
            System.out.println("Name: " + record.name + ", Course: " + record.course);
        }
    }

    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Student Record System");
            System.out.println("1. Add Record");
            System.out.println("2. Search Record");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Display Records");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (option) {
                case 1:
                    system.addRecord();
                    break;
                case 2:
                    system.searchRecord();
                    break;
                case 3:
                    system.updateRecord();
                    break;
                case 4:
                    system.deleteRecord();
                    break;
                case 5:
                    system.displayRecords();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}