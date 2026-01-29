import java.util.Scanner;
import java.util.ArrayList;

class Student_details {
    String id;
    String name;
    Byte age;
    String course;
    int percentage;

    public Student_details(String id, String name, Byte age, String course, int percentage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.percentage = percentage;
    }
}

class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student_details> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print(
                    "\n===== Student Management System =====\n" +
                            "1. Add Student\n" +
                            "2. View All Students\n" +
                            "3. Search Student\n" +
                            "4. Update Student\n" +
                            "5. Delete Student\n" +
                            "6. Exit\n"
            );

            System.out.print("Enter your choice between 1 to 6: ");
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> AddStudent();
                case 2 -> ShowDetails();
                case 3 -> SearchDetails();
                case 4 -> UpdateDetails();
                case 5 -> DeleteDetails();
                case 6 -> {
                    System.out.println("Exiting..................");
                    System.exit(0);
                }
                default -> System.out.println("Error: Invalid Input");
            }
        }
    }

    public static void AddStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.next();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        Byte age = sc.nextByte();

        System.out.print("Enter Course: ");
        String course = sc.next();

        System.out.print("Enter Percentage: ");
        int percentage = sc.nextInt();

        Student_details s = new Student_details(id, name, age, course, percentage);
        students.add(s);

        System.out.println("✅ Student added successfully!");
    }

    public static void ShowDetails() {
        if (students.isEmpty()) {
            System.out.println("❌ No students found.");
            return;
        }

        System.out.println("----- Student List -----");
        for (Student_details s : students) {
            System.out.println(
                    "ID: " + s.id +
                            ", Name: " + s.name +
                            ", Age: " + s.age +
                            ", Course: " + s.course +
                            ", Percentage: " + s.percentage
            );
        }
    }

    public static void SearchDetails() {
        System.out.print("Enter Student ID to search: ");
        String searchId = sc.next();

        for (Student_details s : students) {
            if (s.id.equalsIgnoreCase(searchId)) {
                System.out.println("✅ Student Found:");
                System.out.println(
                        "ID: " + s.id +
                                ", Name: " + s.name +
                                ", Age: " + s.age +
                                ", Course: " + s.course +
                                ", Percentage: " + s.percentage
                );
                return;
            }
        }

        System.out.println("❌ Student not found.");
    }

    public static void UpdateDetails() {
        System.out.print("Enter Student ID to update: ");
        String updateId = sc.next();

        for (Student_details s : students) {
            if (s.id.equalsIgnoreCase(updateId)) {
                System.out.print("Enter New Name: ");
                s.name = sc.next();

                System.out.print("Enter New Age: ");
                s.age = sc.nextByte();

                System.out.print("Enter New Course: ");
                s.course = sc.next();

                System.out.print("Enter New Percentage: ");
                s.percentage = sc.nextInt();

                System.out.println("✅ Student updated successfully!");
                return;
            }
        }

        System.out.println("❌ Student not found.");
    }

    public static void DeleteDetails() {
        System.out.print("Enter Student ID to delete: ");
        String deleteId = sc.next();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equalsIgnoreCase(deleteId)) {
                students.remove(i);
                System.out.println("✅ Student deleted successfully!");
                return;
            }
        }

        System.out.println("❌ Student not found.");
    }

}
