package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
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

}
