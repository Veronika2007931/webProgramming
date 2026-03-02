package main.java.org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    public String firstName; 
    public String lastName;
    public String group;
    public int age;

    public Student(String firstName, String lastName, String group, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.age = age;
    }
    
    Scanner scanner = new Scanner(System.in);
    public List<Double> grades = new ArrayList<>();
    public List<Subject> subjects = new ArrayList<>();

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public void printMySubjects() {
        System.out.println("Предмети студента " + firstName + " " + lastName + ":");
        if (subjects.isEmpty()) {
            System.out.println("Студент ще не обрав жодного предмету.");
        } else {
            for (Subject s : subjects) {
                System.out.println("- " + s.title);
            }
        }
    }

    public void writeTest() {
        System.out.println("Оберіть тест: Тест з математики, Тест з англійської, Тест з історії, Тест з біології");
        String whatTest = scanner.nextLine();

        
        if (whatTest.equals("Тест з математики")) {
            System.out.println("https://www.mathcorporation.com/quizzes/math-nmt");
        } else if (whatTest.equals("Тест з англійської")) {
            System.out.println("https://quiz.justschool.me/engadult_quizlangtest-seo");
        } else if (whatTest.equals("Тест з історії")) {
            System.out.println("https://naurok.com.ua/test/utvorennya-volinsko---galickogo-knyazivstva-derzhavi-romanovichiv-3704444.html");
        } else if (whatTest.equals("Тест з біології")) {
            System.out.println("https://naurok.com.ua/test/budova-i-funkci-m-yaziv-3704421.html");
        }
    }  
            
    public void averageScore() {
        if (grades.isEmpty()) {
            System.out.println("Оцінок немає");
            return;
        }
        double total = 0;
        for (Double grade : grades) {
            total += grade;
        }
        double score = total / grades.size();
        System.out.println("Середній бал: " + score);
    }
}