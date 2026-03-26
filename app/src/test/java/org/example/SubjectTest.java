package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectTest {
    

@Test
void subjectConstructor(){
    Subject sub = new Subject("Історія", 60);
    assertEquals("Історія", sub.getName());
    assertEquals(60, sub.getHours());
}


}
