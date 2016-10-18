package com.vittach;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by VITTACH on 06.10.2016.
 */

public class CalculatorTest {
    // @Test - это аннотация, которая обозначает, что метод должен быть вызван для тестирования

    @Test
    public void addTest_no_0result() {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 0
        assertEquals(c.Add(""), 0);
    }

    @Test
    public void addTest_3_3result() {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 3
        assertEquals(c.Add("3"), 3);
    }

    @Test
    @Ignore
    // Обратим внимание на аннотацию Ignore - она говорит, что данный тест будет проигнорирован
    public void addTest_2n_0result() {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 0
        assertEquals(c.Add("2\n"), 8);
    }

    @Test
    public void addTest_2n7_9result() {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 9
        assertEquals(c.Add("2\n7"), 9);
    }

    @Test
    public void addTest_1coma2_3result() {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат нашего калькулятора будет отличен от 3
        assertEquals(c.Add("1,2"), 3);
    }

    @Test
    public void addTest_slashslashsemicolondotdotbackslashn_8semicolon1000dotdot_1008result() {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат моего калькулятора будет отличен  1008
        assertEquals(c.Add("//;..\n8;1000.."), 1008);
    }

    @Test
    public void addTest_slashslashsemicolonbackslashn_8semicolonsemicolon1001dotdot_8result() {
        Calculate c = new Calculate();
        // Этот метод вызовет исключение, если результат моего калькулятора будет отличен  8
        assertEquals(c.Add("//;\n8;;1001"),8);
    }

    @Test
    public void addTest_negative_elements() {
        Calculate calc = new Calculate();
        RuntimeException exception = null;
        try {
            calc.Add("1,-20,-3\n-14,7\n");
        } catch (RuntimeException e) {
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