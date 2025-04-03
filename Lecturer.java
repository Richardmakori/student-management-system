package model;

import java.util.ArrayList;
import java.util.List;

public class Lecturer extends Person {
    private List<Course> courses;

    public Lecturer(String id, String name) {
        super(id, name);
        this.courses = new ArrayList<>();
    }

    public List<Course> getCourses() { return courses; }

    public boolean addCourse(Course c) {
        if (courses.size() < 2 && !courses.contains(c)) {
            courses.add(c);
            return true;
        }
        return false;
    }
}