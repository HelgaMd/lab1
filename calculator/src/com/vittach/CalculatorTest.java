package com.vittach;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by VITTACH on 06.10.2016.
 */

public class CalculatorTest {
    // @Test - это аннотация, которая обозначает, что метод должен быть вызван для тестирования

    @Test
    public void addTestNo0result() throws NegativeException {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 0
        assertEquals(c.add(""), 0);
    }

    @Test
    public void addTestThreeResult3() throws NegativeException {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 3
        assertEquals(c.add("3"), 3);
    }

    @Test
    @Ignore
    // Обратим внимание на аннотацию Ignore - она говорит, что данный тест будет проигнорирован
    public void addTestTwoSlashNResult0() throws NegativeException {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 0
        assertEquals(c.add("2\n"), 8);
    }

    @Test
    public void addTestTwoSlashN7Result9() throws NegativeException {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 9
        assertEquals(c.add("2\n7"), 9);
    }

    @Test
    public void addTestOneComaTwoResult3() throws NegativeException {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 3
        assertEquals(c.add("1,2"), 3);
    }

    @Test
    public void addTestSlashslashsemicolondotdotbackslashn8semicolon1000dotdotResult1008() throws NegativeException {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат моего калькулятора будет отличен  1008
        assertEquals(c.add("//;..\n8;1000.."), 1008);
    }

    @Test
    public void addTestSlashslashsemicolonbackslashn8semicolonsemicolon1001dotdotResult8() throws NegativeException {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат моего калькулятора будет отличен  8
        assertEquals(c.add("//;\n8;;1001"),8);
    }

    @Test
    public void addTestNegativeElements() {
        Calculate calc = new Calculate();
        NegativeException exception= null;
        try {
            calc.add("1,-20,-3\n-14,7\n");
        } catch (NegativeException e) {
            exception = e;
        }
        assertEquals("Negatives not allowed: [-20, -3, -14]", exception.getMessage());
    }

    @Before
    public void testStarted() {
        System.out.println("Test Starting right now!");
    }

    @After
    public void testFinished() {
        System.out.println("Test Finished correctly");
    }
}