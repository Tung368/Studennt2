package student2;

import java.util.Scanner;
import java.util.Date;

public class Processor {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add new student");
            System.out.println("2. Update student by ID");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find top student by GPA");
            System.out.println("6. Display students with scholarship");
            System.out.println("7. Display total tuition of all students");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.next();
                    System.out.print("Enter full name: ");
                    String fullName = scanner.next();
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    System.out.print("Enter major: ");
                    String major = scanner.next();
                    studentList.addStudent(new Student(id, fullName, new Date(), gpa, major));
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    String updateId = scanner.next();
                    System.out.print("Enter new full name: ");
                    String newFullName = scanner.next();
                    System.out.print("Enter new GPA: ");
                    float newGpa = scanner.nextFloat();
                    System.out.print("Enter new major: ");
                    String newMajor = scanner.next();
                    studentList.updateStudentById(updateId, new Student(updateId, newFullName, new Date(), newGpa, newMajor));
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.next();
                    studentList.deleteStudentById(deleteId);
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students available.");
                    }
                    break;

                case 6:
                    for (Student student : studentList.findScholarshipStudents()) {
                        student.displayInfo();
                    }
                    break;

                case 7:
                    double totalTuition = studentList.calculateTuitionOfAllStudents();
                    System.out.println("Total tuition of all students: " + totalTuition);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
