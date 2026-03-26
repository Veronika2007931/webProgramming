package org.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SchoolTest {
    
    @Test
    void scoolStudents(){
    School school = new School("КПІ ліцей", "Київ");

    Student s1 = new Student("Вероніка", "Мельник", "10-А", 17);
    Student s2 = new Student("Олег", "Петренко", "11-Б", 18);

    school.addStudent(s1);
    school.addStudent(s2);

    assertEquals(2, school.students.size());

    assertDoesNotThrow(() -> school.StudentsList());
    }
}
