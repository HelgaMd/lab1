package com.yanaguseva.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    private StringCalculator calculator = new StringCalculator();

    @Test
    public void calcTest() {
        assertEquals(0, calculator.add(""));
        assertEquals(1, calculator.add("1"));
        assertEquals(3, calculator.add("1,2"));
        assertEquals(10, calculator.add("1,2,4,3"));
        assertEquals(6, calculator.add("1\n2;3"));
        assertEquals(3, calculator.add("//[;]\n1;2"));
        assertEquals(2, calculator.add("1000,2"));
        assertEquals(6, calculator.add("//[;][%]\n1;2%3"));
        assertEquals(6, calculator.add("//[;*][%]\n1;*2%3"));
    }

    @Test
    public void negativeNumberTest() {
        try {
            calculator.add("-1");
        } catch (RuntimeException ex) {
            assertEquals("negatives not allowed -1", ex.getMessage());
        }
    }

    @Test
    public void negativeNumbersTest() {
        try {
            calculator.add("-1,2,-6");
        } catch (RuntimeException ex) {
            assertEquals("negatives not allowed -1,-6", ex.getMessage());
        }
    }
}
