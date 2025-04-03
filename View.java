package view;

import controller.Controller;
import model.Student;

import javax.swing.*;
import java.awt.*;



public class View {
    private Controller controller;
    private JFrame frame;
    private JTextArea outputArea;

    public View(Controller controller) {
        this.controller = controller;
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        JTextField studentIdField = new JTextField();
        panel.add(studentIdField);
        panel.add(new JLabel("Student Name:"));
        JTextField studentNameField = new JTextField();
        panel.add(studentNameField);
        JButton addStudentButton = new JButton("Add Student");
        panel.add(addStudentButton);
        addStudentButton.addActionListener(e -> {
            String id = studentIdField.getText();
            String name = studentNameField.getText();
            controller.addStudent(id, name);
            outputArea.append("Added student: " + name + "\n");
            studentIdField.setText("");
            studentNameField.setText("");
        });

        panel.add(new JLabel("Lecturer ID:"));
        JTextField lecturerIdField = new JTextField();
        panel.add(lecturerIdField);
        panel.add(new JLabel("Course Code:"));
        JTextField courseCodeField = new JTextField();
        panel.add(courseCodeField);
        JButton assignLecturerButton = new JButton("Assign Lecturer to Course");
        panel.add(assignLecturerButton);
        assignLecturerButton.addActionListener(e -> {
            String lecturerId = lecturerIdField.getText();
            String courseCode = courseCodeField.getText();
            if (controller.assignLecturerToCourse(lecturerId, courseCode)) {
                outputArea.append("Assigned lecturer " + lecturerId + " to course " + courseCode + "\n");
            } else {
                outputArea.append("Assignment failed!\n");
            }
            lecturerIdField.setText("");
            courseCodeField.setText("");
        });

        panel.add(new JLabel("Search Student ID:"));
        JTextField searchStudentIdField = new JTextField();
        panel.add(searchStudentIdField);
        JButton searchStudentButton = new JButton("Search Student");
        panel.add(searchStudentButton);
        searchStudentButton.addActionListener(e -> {
            String id = searchStudentIdField.getText();
            Student s = controller.findStudent(id);
            if (s != null) {
                outputArea.append("Student: " + s.getName() + "\n");
                outputArea.append("Programme: " + (s.getProgramme() != null ? s.getProgramme().getName() : "None") + "\n");
                outputArea.append("Courses and Scores:\n");
                for (var entry : s.getCourses().entrySet()) {
                    outputArea.append(entry.getKey().getName() + ": " + entry.getValue() + "\n");
                }
            } else {
                outputArea.append("Student not found!\n");
            }
            searchStudentIdField.setText("");
        });

        JButton saveExitButton = new JButton("Save & Exit");
        panel.add(saveExitButton);
        saveExitButton.addActionListener(e -> {
            controller.saveData();
            outputArea.append("Data saved. Exiting...\n");
            frame.dispose();
        });

        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);
    }

    public void start() {
        // GUI is already initialized and visible
    }
}