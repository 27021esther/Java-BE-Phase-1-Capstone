package com.university.model;

import java.util.*;
import com.university.exception.*;

public class Course {

    private String code;
    private String title;
    private int capacity;
    private List<Student> roster = new ArrayList<>();

    public Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
    }

    public String getCode() { return code; }
    public List<Student> getRoster() { return roster; }

    public void addStudent(Student s)
            throws CourseFullException, StudentAlreadyEnrolledException {

        if (roster.size() >= capacity)
            throw new CourseFullException("Course is full");

        if (roster.contains(s))
            throw new StudentAlreadyEnrolledException("Student already enrolled");

        roster.add(s);
        s.enroll(this);
    }

    @Override
    public String toString() {
        return code + " - " + title;
    }
}