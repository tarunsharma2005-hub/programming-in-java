package com.tarun.scms;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final StudentRepository REPO = new StudentRepository();

    public static void main(String[] args) {
        DatabaseManager.initialize();
        System.out.println("==============================================");
        System.out.println(" STUDENT & COURSE MANAGEMENT SYSTEM");
        System.out.println(" Programming in Java - Evaluated Project");
        System.out.println("==============================================");

        while (true) {
            printMenu();
            String choice = SC.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> addStudent();
                    case "2" -> listStudents();
                    case "3" -> deleteStudent();
                    case "4" -> exportReport();
                    case "5" -> runThreadDemo();
                    case "6" -> runJpaDemo();
                    case "0" -> {
                        System.out.println("Thank you. Program terminated.");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please select again.");
                }
            } catch (AppException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Delete Student");
        System.out.println("4. Export CSV Report");
        System.out.println("5. Run Multithreading Report");
        System.out.println("6. Run JPA Demonstration");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addStudent() {
        System.out.print("Roll number: ");
        String roll = SC.nextLine().trim();
        System.out.print("Name: ");
        String name = SC.nextLine().trim();
        System.out.print("Course: ");
        String course = SC.nextLine().trim();
        System.out.print("Marks (0-100): ");
        double marks = Double.parseDouble(SC.nextLine().trim());

        if (roll.isBlank() || name.isBlank() || course.isBlank())
            throw new AppException("Fields cannot be blank.");
        if (marks < 0 || marks > 100)
            throw new AppException("Marks must be between 0 and 100.");

        REPO.add(new Student(roll, name, course, marks));
        System.out.println("Student added successfully.");
    }

    private static void listStudents() {
        List<Student> students = REPO.findAll();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
    }

    private static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        REPO.deleteByRoll(SC.nextLine().trim());
        System.out.println("Student deleted successfully.");
    }

    private static void exportReport() {
        String file = "student_report.csv";
        REPO.exportCsv(file);
        System.out.println("CSV report created: " + file);
    }

    private static void runThreadDemo() {
        Thread t = new Thread(new ReportTask(REPO.findAll()), "Report-Thread");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AppException("Report thread was interrupted.", e);
        }
    }

    private static void runJpaDemo() {
        JpaDemo.run();
    }
}
