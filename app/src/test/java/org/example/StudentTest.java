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
    void invalidLowAgeTest() {
        Student s = new Student("Veronika", "Niema", "11-A", 16);
        assertThrows(IllegalArgumentException.class, () -> {
            s.setAge(-1);
        });
    }

    @Test
    void invalidHighAgeTest() {
        Student s = new Student("Veronika", "Niema", "11-A", 16);
        assertThrows(IllegalArgumentException.class, () -> {
            s.setAge(25);
        });
    }

    @Test
    void EveregeScore() {
        Student s = new Student("Veronika", "Niema", "11-A", 16);

        s.addGrade(10.0);
        s.addGrade(12.0);
        s.addGrade(8.0);

        assertEquals(10.0, s.averageScore(), 0.001);
    }

    @Test
    void addGradeTest() {
        Student s = new Student("Veronika", "Niema", "11-A", 16);

        s.addGrade(10.0);

        String report = s.getGradesReport();

        assertTrue(report.contains("10.0"), "Звіт має містити додану оцінку 10.0");
    }

}
