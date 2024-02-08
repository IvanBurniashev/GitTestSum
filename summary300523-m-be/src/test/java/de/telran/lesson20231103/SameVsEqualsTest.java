package de.telran.lesson20231103;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SameVsEqualsTest {

    @Test
    public void testSameVsEquals(){
        Object o1 = "123";
        Object o2 = new String("123");
        Object o3 = "123";

        assertEquals(o1, o2);
        assertEquals(o1, o3);

        assertNotSame(o1, o2);
        assertSame(o1, o3);
        o2 = o1;
        assertSame(o1, o2);
    }

}
