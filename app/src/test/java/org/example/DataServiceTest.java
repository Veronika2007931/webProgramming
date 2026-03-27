package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataServiceTest {
    
    @Test
    void Export() throws IOException{
        DataService service = new DataService();
        List<Student> students = new ArrayList<>();

        students.add(new Student("Олег", "Яковенко", "ІП-21", 19));
        students.add(new Student("Анна", "Абрамова", "ІП-21", 18));

        service.exportStudents(students, "test.csv");

        assertEquals("Абрамова", students.get(0).getLastName());
        assertEquals("Яковенко", students.get(1).getLastName());
    }

    @Test
    void Import() throws IOException{
        DataService service = new DataService();

        String testFileName = "test_import.csv";
        try(java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(testFileName))){
            writer.println("Вероніка,Мельник,ІП-21,18");
        }

        List<Student> result = service.importStudents(testFileName);

        assertFalse(result.isEmpty(), "Список не має бути порожнім після імпорту");
    

    Student imported = result.get(0);
    assertEquals("Вероніка", imported.getFirstName());
    assertEquals("Мельник", imported.getLastName());
    assertEquals(18, imported.getAge());
    

    new java.io.File(testFileName).delete();
    }
}
