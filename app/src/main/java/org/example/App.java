package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {

    private static void createAndAddStudent(Scanner scaner, School school) {
        System.out.print("Ім'я: ");
        String fName = scaner.nextLine();
        System.out.print("Прізвище: ");
        String lName = scaner.nextLine();
        System.out.print("Група: ");
        String group = scaner.nextLine();
        System.out.print("Вік: ");
        int age = scaner.nextInt();
        scaner.nextLine();

        try {
            Student newStudent = new Student(fName, lName, group, age);
            school.addStudent(newStudent);
            System.out.println("Операція успішна!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void createAndAddSubject(Scanner scaner, School school) {
        System.out.print("Назва предмету:");
        String subName = scaner.nextLine();
        System.out.print("Кількість годин:");
        int hours = scaner.nextInt();
        scaner.nextLine();

        try {
            Subject newSubject = new Subject(subName, hours);
            school.addSubject(newSubject);
            System.out.println("Операція успішна!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        School school = new School("КПІ ліцей", "бульвар Вацлава Гавела, 41А, Київ, 03124");
        DataService dataService = new DataService();
        boolean running = true;
        String studentsFile = "students.csv";
        String subjectsFile = "subjects.csv";

        // Subject math = new Subject("Математика", 120);
        // Subject english = new Subject("Англійська", 100);
        // Subject history = new Subject("Історія України", 60);
        // Subject biology = new Subject("Біологія", 60);
        // Subject ukrainian = new Subject("Українська мова", 100);

        // school.addSubject(math);
        // school.addSubject(history);
        // school.addSubject(english);
        // school.addSubject(biology);
        // school.addSubject(ukrainian);

        try {
            List<Student> savedData = dataService.importStudents("students.csv");
            school.setStudents(savedData);

            List<Subject> loadedSubjects = dataService.importSubjects(subjectsFile);
            school.setSubjects(loadedSubjects);
            System.out.println("Дані успішно завантажені з минулої сесії.");
        } catch (IOException e) {
            System.out.println("Файл бази даних не знайдено, починаємо з порожнім списком.");
        }

        while (running) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("Переглянути інформацію про школу(1)");
            System.out.println("Особистий кабінет учня(2)");
            System.out.println("Інформація про предмети(3)");
            System.out.println("Акаунт адміністратора(4)");
            System.out.println("Акаунт викладача(5)");
            System.out.println("Вихід(0)");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println(String.format("Назва школи: %s", school.getName()));
                System.out.println(String.format("Адреса школи: %s", school.getLocation()));
                System.out.println("Список учнів (5)");
                int Schoolchoice = scanner.nextInt();
                if (Schoolchoice == 5) {
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
                    System.out.println("Обрахувати середній бал(1)");
                    System.out.println("Написати тест(2)");
                    int studentChoice = scanner.nextInt();
                    if (studentChoice == 1) {
                        try {

                            System.out.println(foundStudent.getGradesReport());
                            double average = foundStudent.averageScore();
                            System.out.printf("Ваш середній бал: %.2f\n", average);
                        } catch (IllegalArgumentException e) {

                            System.out.println("Помилка: " + e.getMessage());
                        }
                    }

                } else {
                    System.out.println("Помилка: Студента з таким ім'ям не знайдено у базі.");
                }
            } else if (choice == 3) {
                System.out.println("Який предмет бажаєте подивитись");
                String subjectChoosen = scanner.next();

                for (Subject s : school.subjects) {
                    if (s.getName().equalsIgnoreCase(subjectChoosen)) {
                        System.out.println("Знайдено: " + s.getName() + ", години: " + s.getHours());
                    }
                }
            } else if (choice == 4) {
                System.out.println("Оберіть дію");
                System.out.println("Додати учня(1)");
                System.out.println("Додати предмет(2)");

                int adminChoice = scanner.nextInt();
                scanner.nextLine();
                if (adminChoice == 1) {
                    createAndAddStudent(scanner, school);
                } else if (adminChoice == 2) {
                    createAndAddSubject(scanner, school);
                }

            } else if (choice == 4) {
                System.out.println("Оберіть дію");
                System.out.println("Поставити оцінку(1)");
                int teacherChoice = scanner.nextInt();
                scanner.nextLine();

                if (teacherChoice == 1) {
                    System.out.print("Введіть ім'я студента: ");
                    String inputName = scanner.next();
                    System.out.print("Введіть прізвище студента: ");
                    String inputLastName = scanner.next();

                    try {
                        Student foundStudent = school.findStudent(inputName, inputLastName);
                        if (foundStudent == null) {
                            throw new IllegalArgumentException("Студента з таким ім'ям не знайдено!");
                        }

                        System.out.print("Введіть оцінку яку ви хочете поставити: ");
                        Double mark = scanner.nextDouble();

                        foundStudent.addGrade(mark);

                        System.out.println("Оцінку " + mark + " для студента " + inputName + " успішно додано!");
                    } catch (Exception e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    ;

                } else if (choice == 0) {
                    try {

                        dataService.exportStudents(school.getStudents(), studentsFile);
                        dataService.exportSubjects(school.getSubjects(), subjectsFile);
                        System.out.println("Дані автоматично збережені!");
                    } catch (IOException e) {
                        System.out.println("Помилка при збереженні: " + e.getMessage());
                    }
                    running = false;

                }
            }

        }
    }
}

// ./gradlew run
// ./gradlew test