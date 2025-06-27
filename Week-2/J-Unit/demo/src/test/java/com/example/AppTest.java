package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    App calc = new App();
    @Test
    public void testAdd()
    {
        assertEquals(5, calc.add(2, 3));
    }
}
