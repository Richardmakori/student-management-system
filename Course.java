package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String name;
    private Lecturer lecturer;
    private List<Student> students;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public Lecturer getLecturer() { return lecturer; }
    public List<Student> getStudents() { return students; }

    public boolean setLecturer(Lecturer l) {
        if (lecturer == null) {
            lecturer = l;
            return l.addCourse(this);
        }
        return false;
    }

    public void addStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
            s.addCourse(this);
        }
    }
}
