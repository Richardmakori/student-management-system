package model;

import java.util.ArrayList;
import java.util.List;

public class Programme {
    private String code;
    private String name;
    private List<Course> courses;
    private List<Student> students;

    public Programme(String code, String name) {
        this.code = code;
        this.name = name;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public List<Course> getCourses() { return courses; }
    public List<Student> getStudents() { return students; }

    public void addCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
        }
    }

    public void addStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
            s.enrollProgramme(this);
        }
    }
}