package org.example;

import java.util.ArrayList;
import java.util.List;

class School {
    private String Name;
    private String Location;

    public School(String Name, String Location) {
        setName(Name);
        setLocation(Location);

    }

    public List<Subject> subjects = new ArrayList<>();
    List<Student> students = new ArrayList<>();

    public String getName() {
        return this.Name;
    }

    public String getLocation() {
        return this.Location;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void addStudent(Student student) {
        if (students.contains(student)) {
            throw new IllegalArgumentException("Студент " + student.getFirstName() + " вже існує в базі!");
        }
        students.add(student);
    }

    public String StudentsList() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.getFirstName()).append(" ").append(student.getLastName()).append("\n");
        }
        return sb.toString();

    }

    public void addSubject(Subject subject) {
        if (subjects.contains(subject)) {
            throw new IllegalArgumentException("Предмет " + subject.getName() + " вже існує в базі!");
        }
        this.subjects.add(subject);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Student findStudent(String fName, String lName) {
        for (Student s : students) {
            if (s.getFirstName().equalsIgnoreCase(fName) &&
                    s.getLastName().equalsIgnoreCase(lName)) {
                return s;
            }
        }
        return null;
    }
}