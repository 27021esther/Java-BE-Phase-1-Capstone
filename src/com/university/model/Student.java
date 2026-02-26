package com.university.model;

import java.util.*;

public abstract class Student extends Person {

    private final double gpa;
    private final String department;
    protected Map<Course, Double> courses = new HashMap<>();

    public Student(String id, String name, double gpa, String dept) {
        super(id, name);
        this.gpa = gpa;
        this.department = dept;
    }

    public double getGpa() { return gpa; }
    public String getDepartment() { return department; }

    public void enroll(Course c) {
        courses.put(c, 0.0);
    }

    public Map<Course, Double> getCourses() {
        return courses;
    }

    public abstract double calculateTuition();
}