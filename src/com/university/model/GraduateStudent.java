package com.university.model;

public class GraduateStudent extends Student {

    public GraduateStudent(String id, String name, double gpa, String dept) {
        super(id, name, gpa, dept);
    }

    @Override
    public double calculateTuition() {
        return courses.size() * 800 + 2000;
    }
}