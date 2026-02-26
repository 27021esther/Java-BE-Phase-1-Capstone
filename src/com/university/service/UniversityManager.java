package com.university.service;

import java.util.*;
import java.util.stream.*;
import com.university.model.*;

public class UniversityManager {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void registerStudent(Student s) {
        students.add(s);
    }

    public void createCourse(Course c) {
        courses.add(c);
    }

    public void enroll(String studentId, String courseCode) throws Exception {

        Student s = students.stream()
                .filter(st -> st.getId().equals(studentId))
                .findFirst().orElse(null);

        Course c = courses.stream()
                .filter(co -> co.getCode().equals(courseCode))
                .findFirst().orElse(null);

        if (s != null && c != null)
            c.addStudent(s);
    }

    public void generateDeansList() {
        students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .forEach(s -> System.out.println(s.getName()));
    }

    public List<Student> getStudents() { return students; }
}