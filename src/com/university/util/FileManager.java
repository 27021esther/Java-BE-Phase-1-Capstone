package com.university.util;

import java.io.*;
import java.util.*;
import com.university.model.*;

public class FileManager {

    public static void save(List<Student> students) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));

        for (Student s : students) {
            bw.write(s.getId() + "," + s.getName() + "," +
                    s.getGpa() + "," + s.getDepartment());
            bw.newLine();
        }
        bw.close();
    }
}