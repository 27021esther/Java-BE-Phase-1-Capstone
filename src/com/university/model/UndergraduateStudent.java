package com.university.model;

public class UndergraduateStudent extends Student {

    public UndergraduateStudent(String id, String name, double gpa, String dept) {
        super(id, name, gpa, dept);
    }

    @Override
    public double calculateTuition() {
        return 5000;
    }
}