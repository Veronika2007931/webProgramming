package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.AfterEach; // Додаємо цей імпорт
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StudentTest {
private final InputStream systemInBackup = System.in;

@AfterEach
    void restoreSystemIn() {
        System.setIn(systemInBackup);
    }

    @Test
    void invalidAgeTest(){
        Student s = new Student("Veronika", "Niema", "11-A", 16);
        s.setAge(-1);
        assertEquals(-1, s.getAge());
    }

    @Test
    void hightAgeTest(){
        Student s = new Student("Veronika", "Niema", "11-A", 16);
        s.setAge(25);
        assertEquals(25, s.getAge());
    }

    @Test
    void SubjectList(){
        Student s = new Student("Veronika", "Niema", "11-A", 16);
        Subject math = new Subject("Math",100);
        Subject ukr = new Subject("Ukrainian",80);
        Subject english = new Subject("English",90);

        s.addSubject(math);
        s.addSubject(english);
        s.addSubject(ukr);

        assertEquals(3, s.subjects.size());
    }

    @Test
    void EveregeScore(){
        Student s = new Student("Veronika", "Niema", "11-A", 16);
        assertDoesNotThrow(()-> s.averageScore());
    }

    @Test
    void SubjectsDuplicate() {
    Student s = new Student("Вероніка", "Мельник", "10-А", 17);
    
    
    Subject math1 = new Subject("Математика", 120);
    Subject physics = new Subject("Фізика", 100);
    Subject history = new Subject("Історія", 80);
    Subject mathDuplicate = new Subject("Математика", 120);


    s.addSubject(math1);
    s.addSubject(physics);
    s.addSubject(history);
    s.addSubject(mathDuplicate);

    assertEquals(3, s.subjects.size(), "Має бути 3 унікальних предмети");
    
}

@ParameterizedTest
@ValueSource(strings = {"Тест з математики", "Тест з історії", "Тест з біології", "Тест з англійської"})
void writeTest(String testName){
    Student s = new Student("Veronika", "Niema", "11-A", 16);
    String input =  testName + "\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    assertDoesNotThrow(()-> s.writeTest());
  
}

@Test
void AverageScore(){
    Student s = new Student("Veronika", "Niema", "11-A", 16);

    s.grades.add(12d);
    s.grades.add(10d);
    s.grades.add(10d);
    s.grades.add(9d);

    assertDoesNotThrow(()-> s.averageScore());

}

}
