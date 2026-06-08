package controller;

import model.*;
import data.DataManager;

import java.util.*;

public class Controller {
    private List<Student> students = new ArrayList<>();
    private List<Lecturer> lecturers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Programme> programmes = new ArrayList<>();
    private DataManager dataManager = new DataManager();

    public void addStudent(String id, String name) {
        students.add(new Student(id, name));
    }

    public void addLecturer(String id, String name) {
        lecturers.add(new Lecturer(id, name));
    }

    public void addCourse(String code, String name) {
        courses.add(new Course(code, name));
    }

    public void addProgramme(String code, String name) {
        programmes.add(new Programme(code, name));
    }

    public boolean assignLecturerToCourse(String lecturerId, String courseCode) {
        Lecturer l = findLecturer(lecturerId);
        Course c = findCourse(courseCode);
        if (l != null && c != null) {
            return c.setLecturer(l);
        }
        return false;
    }

    public boolean enrollStudentInProgramme(String studentId, String programmeCode) {
        Student s = findStudent(studentId);
        Programme p = findProgramme(programmeCode);
        if (s != null && p != null) {
            p.addStudent(s);
            return true;
        }
        return false;
    }

    public boolean registerStudentForCourse(String studentId, String courseCode) {
        Student s = findStudent(studentId);
        Course c = findCourse(courseCode);
        if (s != null && c != null) {
            c.addStudent(s);
            return true;
        }
        return false;
    }

    public void setStudentScore(String studentId, String courseCode, int score) {
        Student s = findStudent(studentId);
        Course c = findCourse(courseCode);
        if (s != null && c != null) {
            s.setScore(c, score);
        }
    }

    public Student findStudent(String id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public Lecturer findLecturer(String id) {
        return lecturers.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
    }

    public Course findCourse(String code) {
        return courses.stream().filter(c -> c.getCode().equals(code)).findFirst().orElse(null);
    }

    public Programme findProgramme(String code) {
        return programmes.stream().filter(p -> p.getCode().equals(code)).findFirst().orElse(null);
    }

    public void saveData() {
        dataManager.saveData(students, lecturers, courses, programmes);
    }
}
