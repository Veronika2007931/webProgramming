package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataService {

  public void exportStudents(List<Student> students, String fileName) throws IOException {
    students.sort(Comparator.comparing(Student::getLastName));

    try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
      for (Student s : students) {
        writer.println(s.toCsvRow());
      }
    }
  }

  public List<Student> importStudents(String fileName) throws IOException {
    List<Student> importedList = new ArrayList<>();
    File file = new File(fileName);
    if (!file.exists())
      return importedList;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");

        // Міняємо умову: тепер довжина може бути 4 (без предметів) або 5 (з предметами)
        if (data.length >= 4) {
          String firstName = data[0];
          String lastName = data[1];
          String group = data[2];
          int age = Integer.parseInt(data[3]);

          Student s = new Student(firstName, lastName, group, age);

          // Якщо є 5-й елемент — це наші предмети через ";"
          if (data.length == 5) {
            String[] subNames = data[4].split(";");
            for (String name : subNames) {
              s.subjects.add(new Subject(name, 0)); // Години ставимо 0, бо в цьому файлі їх нема
            }
          }
          importedList.add(s);
        }
      }
    }
    return importedList;
  }

  public void exportSubjects(List<Subject> subjects, String fileName) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
      for (Subject s : subjects) {
        writer.println(s.getName() + "," + s.getHours());
      }
    }
  }

  public List<Subject> importSubjects(String fileName) throws IOException {
    List<Subject> subjects = new ArrayList<>();
    File file = new File(fileName);

    if (!file.exists())
      return subjects;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        if (data.length == 2) {
          subjects.add(new Subject(data[0], Integer.parseInt(data[1])));
        }
      }
    }
    return subjects;
  }

}
