package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String group;
    private int age;

    public Student(String firstName, String lastName, String group, int age) {
        setFirstName(firstName);
        setlastName(lastName);
        setGroup(group);
        setAge(age);
    }

    Scanner scanner = new Scanner(System.in);
    public List<Double> grades = new ArrayList<>();
    public List<Subject> subjects = new ArrayList<>();

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String Group) {
        this.group = Group;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 20) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Вік має бути від 0 до 20 років!");
        }
    }

    public void addSubject(Subject subject) {
        if (subjects.contains(subject)) {
            throw new IllegalArgumentException("Предмет '" + subject.getName() + "' вже додано!");
        } else {
            subjects.add(subject);
        }
    }

    public String printMySubjects() {
        if (subjects.isEmpty()) {
            System.out.println("Студент ще не обрав жодного предмету.");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Предмети студента").append(firstName).append(" ").append(lastName).append(":\n");

        for (Subject s : subjects) {
            sb.append("-").append(s.getName()).append("\n");
        }

        return sb.toString();
    }

    public void writeTest() {
        System.out.println("Оберіть тест: Тест з математики, Тест з англійської, Тест з історії, Тест з біології");
        String whatTest = scanner.nextLine();

        if (whatTest.equals("Тест з математики")) {
            System.out.println("https://www.mathcorporation.com/quizzes/math-nmt");
        } else if (whatTest.equals("Тест з англійської")) {
            System.out.println("https://quiz.justschool.me/engadult_quizlangtest-seo");
        } else if (whatTest.equals("Тест з історії")) {
            System.out.println(
                    "https://naurok.com.ua/test/utvorennya-volinsko---galickogo-knyazivstva-derzhavi-romanovichiv-3704444.html");
        } else if (whatTest.equals("Тест з біології")) {
            System.out.println("https://naurok.com.ua/test/budova-i-funkci-m-yaziv-3704421.html");
        }
    }

    public double averageScore() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Double grade : grades) {
            total += grade;
        }
        double score = total / grades.size();
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Student student = (Student) o;

        return age == student.age &&
                java.util.Objects.equals(firstName, student.getFirstName()) &&
                java.util.Objects.equals(lastName, student.getLastName()) &&
                java.util.Objects.equals(group, student.getGroup());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName, group, age);
    }

    public String toCsvRow() {
        return firstName + "," + lastName + "," + group + "," + age;
    }

}