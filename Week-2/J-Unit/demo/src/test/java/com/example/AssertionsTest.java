package test.java.com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // assertEquals: Checks if values are equal
        assertEquals(5, 2 + 3);

        // assertTrue: Condition must be true
        assertTrue(5 > 3);

        // assertFalse: Condition must be false
        assertFalse(5 < 3);

        // assertNull: Value must be null
        assertNull(null);

        // assertNotNull: Value must not be null
        assertNotNull(new Object());
    }
}
