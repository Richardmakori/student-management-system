package model;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private Programme programme;
    private Map<Course, Integer> courses;

    public Student(String id, String name) {
        super(id, name);
        this.courses = new HashMap<>();
    }

    public Programme getProgramme() { return programme; }
    public Map<Course, Integer> getCourses() { return courses; }

    public boolean enrollProgramme(Programme p) {
        if (programme == null) {
            programme = p;
            return true;
        }
        return false;
    }

    public boolean addCourse(Course c) {
        if (courses.size() < 3 && !courses.containsKey(c)) {
            courses.put(c, 0);
            return true;
        }
        return false;
    }

    public void setScore(Course c, int score) {
        if (courses.containsKey(c)) {
            courses.put(c, score);
        }
    }
}