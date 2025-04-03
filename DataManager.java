package data;

import model.*;

import java.io.*;
import java.util.*;

public class DataManager {
    private static final String FILE_NAME = "data.txt";

    public void saveData(List<Student> students, List<Lecturer> lecturers, List<Course> courses, List<Programme> programmes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println("STUDENTS");
            for (Student s : students) {
                writer.print(s.getId() + "," + s.getName());
                if (s.getProgramme() != null) {
                    writer.print("," + s.getProgramme().getCode());
                }
                writer.print(",");
                for (Map.Entry<Course, Integer> entry : s.getCourses().entrySet()) {
                    writer.print(entry.getKey().getCode() + ":" + entry.getValue() + ";");
                }
                writer.println();
            }

            writer.println("LECTURERS");
            for (Lecturer l : lecturers) {
                writer.print(l.getId() + "," + l.getName() + ",");
                for (Course c : l.getCourses()) {
                    writer.print(c.getCode() + ";");
                }
                writer.println();
            }

            writer.println("COURSES");
            for (Course c : courses) {
                writer.print(c.getCode() + "," + c.getName());
                if (c.getLecturer() != null) {
                    writer.print("," + c.getLecturer().getId());
                }
                writer.println();
            }

            writer.println("PROGRAMMES");
            for (Programme p : programmes) {
                writer.print(p.getCode() + "," + p.getName() + ",");
                for (Course c : p.getCourses()) {
                    writer.print(c.getCode() + ";");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void loadData(List<Student> students, List<Lecturer> lecturers, List<Course> courses, List<Programme> programmes) {
        // Simplified; add loading logic if needed
    }
}