package org.example;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class App {
public String getGreeting() {
    return "Hello World!";
    }

public static void main(String[] args) {
    System.out.println(new App().getGreeting());
     Scanner scanner = new Scanner(System.in);

        Subject math = new Subject("Математика", 120);
        Subject english = new Subject("Англійська", 100);
        Subject history = new Subject("Історія України", 60);
        Subject biology = new Subject("Біологія", 60);
        Subject ukrainian = new Subject("Українська мова", 100);

       
        List<Student> school = new ArrayList<>();

      
        school.add(new Student("Вероніка", "Мельник", "10-А", 16));
        school.add(new Student("Олександр", "Шевченко", "10-А", 16));
        school.add(new Student("Дмитро", "Козак", "10-Б", 15));
        school.add(new Student("Марія", "Бондар", "11-А", 17));
        school.add(new Student("Андрій", "Ткаченко", "10-А", 16));
        school.add(new Student("Анна", "Кравченко", "11-Б", 17));
        school.add(new Student("Максим", "Олійник", "10-Б", 15));
        school.add(new Student("Юлія", "Лисенко", "10-А", 16));
        school.add(new Student("Артем", "Мороз", "11-А", 17));
        school.add(new Student("Софія", "Петренко", "11-Б", 17));
        school.add(new Student("Ігор", "Павленко", "10-Б", 15));
        school.add(new Student("Дарина", "Савченко", "10-А", 16));
        school.add(new Student("Микита", "Коваль", "11-А", 17));
        school.add(new Student("Олена", "Клименко", "10-Б", 15));
        school.add(new Student("Богдан", "Зайцев", "11-Б", 17));

        // Додаємо предмети всім студентам циклом for-each
        for (Student s : school) {
            s.addSubject(math);
            s.addSubject(ukrainian);
            s.addSubject(english);
            
            // Наприклад, додамо історію тільки 11-м класам
            if (s.getGroup().contains("11")) {
                s.addSubject(history);
            } else {
                s.addSubject(biology);
            }
        }

       
        System.out.println("Список студентів школи:");
        for (Student s : school) {
            System.out.println(s.getFirstName() + " " + s.getLastName() + " (" + s.getGroup() + ")");
        }

    

    

    }
}
