package com.university.main;

import java.util.*;
import com.university.model.*;
import com.university.service.*;
import com.university.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        UniversityManager manager = new UniversityManager();

        while (true) {

            System.out.println("\n===== UNIVERSITY SYSTEM =====");
            System.out.println("1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. View Student Summary");
            System.out.println("5. Save & Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    manager.registerStudent(
                            new UndergraduateStudent(id, name, gpa, dept));

                    System.out.println("✅ Student Registered!");
                    break;

                case 2:
                    System.out.print("Course Code: ");
                    String code = sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Capacity: ");
                    int cap = sc.nextInt();
                    sc.nextLine();

                    manager.createCourse(new Course(code, title, cap));

                    System.out.println("✅ Course Created!");
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    String sid = sc.nextLine();

                    System.out.print("Course Code: ");
                    String ccode = sc.nextLine();

                    try {
                        manager.enroll(sid, ccode);
                        System.out.println("✅ Enrollment Successful!");
                    } catch (Exception e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\n📊 STUDENT SUMMARY");

                    for (Student s : manager.getStudents()) {
                        System.out.println("--------------------------------");
                        System.out.println("Name: " + s.getName());
                        System.out.println("Courses Enrolled: " + s.getCourses().size());
                        System.out.println("Tuition: " + s.calculateTuition());
                    }
                    break;

                case 5:
                    FileManager.save(manager.getStudents());
                    System.out.println("💾 Data Saved. Exiting...");
                    return;

                default:
                    System.out.println("❌ Invalid option!");
            }
        }
    }
}