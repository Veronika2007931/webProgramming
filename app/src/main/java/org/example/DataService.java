package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class DataService {
    
    public void exportStudents(List<Student> students, String fileName) throws IOException{
        students.sort(Comparator.comparing(Student::getLastName));

        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
          for(Student s : students){
            writer.println(s.toCsvRow());
          }
        }
    }

    public List<Student> importStudents(String fileName) throws IOException{
      List<Student> importedList = new ArrayList<>();

      try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
        String line;
        while((line = reader.readLine())!= null){
              String[] data = line.split(",");

        if(data.length == 4){
            String firstName = data[0];
            String lastName = data[1];
            String group = data[2];
            int age = Integer.parseInt(data[3]);

            importedList.add(new Student(firstName, lastName, group, age));
        }
      
        }
      }

      return importedList;
    }
}
