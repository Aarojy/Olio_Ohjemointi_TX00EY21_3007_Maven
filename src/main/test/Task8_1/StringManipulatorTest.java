package Task8_1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {
    @Test
    void canConcatenate() {
        StringManipulator sm = new StringManipulator();
        assertEquals("Hello, World!", sm.concatenate("Hello, ", "World!"));
    }

    @Test
    void canFindLength() {
        StringManipulator sm = new StringManipulator();
        assertEquals(13, sm.findLength("Hello, World!"));
    }

    @Test
    void canConvertToUpperCase() {
        StringManipulator sm = new StringManipulator();
        assertEquals("HELLO, WORLD!", sm.convertToUpperCase("Hello, World!"));
    }

    @Test
    void canConvertToLowerCase() {
        StringManipulator sm = new StringManipulator();
        assertEquals("hello, world!", sm.convertToLowerCase("Hello, World!"));
    }

    @Test
    void canCheckIfContainsSubstring() {
        StringManipulator sm = new StringManipulator();
        assertTrue(sm.containsSubstring("Hello, World!", "World"));
        assertFalse(sm.containsSubstring("Hello, World!", "Earth"));
    }

}