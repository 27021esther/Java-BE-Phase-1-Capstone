package com.university.model;

public class Instructor extends Person {
    private String department;

    public Instructor(String id, String name, String dept) {
        super(id, name);
        this.department = dept;
    }

    public String getDepartment() {
        return department;
    }
}