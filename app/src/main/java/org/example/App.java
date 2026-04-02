package org.example;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {


public static void main(String[] args) {
    
     Scanner scanner = new Scanner(System.in);
        School school = new School("КПІ ліцей", "бульвар Вацлава Гавела, 41А, Київ, 03124");

        boolean running = true;

        school.addStudent(new Student("Вероніка", "Мельник", "10-А", 16));
        school.addStudent(new Student("Олександр", "Шевченко", "10-А", 16));
        school.addStudent(new Student("Дмитро", "Козак", "10-Б", 15));
        school.addStudent(new Student("Марія", "Бондар", "11-А", 17));
        school.addStudent(new Student("Андрій", "Ткаченко", "10-А", 16));
        school.addStudent(new Student("Анна", "Кравченко", "11-Б", 17));
        school.addStudent(new Student("Максим", "Олійник", "10-Б", 15));
        school.addStudent(new Student("Юлія", "Лисенко", "10-А", 16));
        school.addStudent(new Student("Артем", "Мороз", "11-А", 17));
        school.addStudent(new Student("Софія", "Петренко", "11-Б", 17));
        school.addStudent(new Student("Ігор", "Павленко", "10-Б", 15));
        school.addStudent(new Student("Дарина", "Савченко", "10-А", 16));
        school.addStudent(new Student("Микита", "Коваль", "11-А", 17));
        school.addStudent(new Student("Олена", "Клименко", "10-Б", 15));
        school.addStudent(new Student("Богдан", "Зайцев", "11-Б", 17));

         Subject math = new Subject("Математика", 120);
        Subject english = new Subject("Англійська", 100);
        Subject history = new Subject("Історія України", 60);
        Subject biology = new Subject("Біологія", 60);
        Subject ukrainian = new Subject("Українська мова", 100);

        school.addSubject(math);
        school.addSubject(history);
        school.addSubject(english);
        school.addSubject(biology);
        school.addSubject(ukrainian);

        // Додаємо предмети всім студентам циклом for-each
        for (Student s : school.students) {
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

        DataService dataService = new DataService();
        try {
    List<Student> savedData = dataService.importStudents("students.csv");
    school.setStudents(savedData);
    System.out.println("Дані успішно завантажені з минулої сесії.");
} catch (IOException e) {
    System.out.println("Файл бази даних не знайдено, починаємо з порожнім списком.");
}


while (running) {
    System.out.println("\n--- МЕНЮ ---");
    System.out.println("Переглянути інформацію про школу(1)");
    System.out.println("Особистий кабінет учня(2)");
    System.out.println("Інформація про предмети(3)");
    System.out.println("Вихід(0)"); 
    
    int choice = scanner.nextInt();
    scanner.nextLine(); 

    if (choice == 1) {
        System.out.println(String.format("Назва школи: %s", school.getName()));
        System.out.println(String.format("Адреса школи: %s", school.getLocation()));
        System.out.println("Список учнів (4)");
        int Schoolchoice = scanner.nextInt();
        if (Schoolchoice == 4) {
            school.StudentsList();
        }
    } else if (choice == 2) {
        System.out.print("Введіть ваше ім'я: ");
        String inputName = scanner.next();
        System.out.print("Введіть ваше прізвище: ");
        String inputLastName = scanner.next();

        Student foundStudent = school.findStudent(inputName, inputLastName);
        if (foundStudent != null) {
            System.out.println("\n--- ОСОБИСТИЙ КАБІНЕТ ---");
            System.out.println("Вітаємо, " + foundStudent.getFirstName() + "!");
            System.out.println("Ваша група: " + foundStudent.getGroup());
            System.out.println("Ваш вік: " + foundStudent.getAge());
            
            System.out.print("Ваші предмети: ");
            for (Subject sub : foundStudent.subjects) {
                System.out.print(sub.getName() + " ");
            }
            System.out.println();
        } else {
            System.out.println("Помилка: Студента з таким ім'ям не знайдено у базі.");
        }
    } else if (choice == 3) {
        System.out.println("Який предмет бажаєте подивитись");
        String subjectChoosen = scanner.next();

        for (Subject s : school.allSubjects) {
            if (s.getName().equalsIgnoreCase(subjectChoosen)) {
                System.out.println("Знайдено: " + s.getName() + ", години: " + s.getHours());
            }
        }
    } else if (choice == 0) {
        try {
            
            dataService.exportStudents(school.getStudents(), "students.csv");
            System.out.println("Дані автоматично збережені!");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні: " + e.getMessage());
        }
        running = false; 
        System.out.println("Вихід з програми...");
    }
}
      
        
       
       

    

    

    }
}

//./gradlew run
// ./gradlew test