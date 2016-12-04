package com.yanaguseva.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    private StringCalculator calculator = new StringCalculator();

    @Test
    public void calcTest() {
        checkAdd(0, "");
        checkAdd(1, "1");
        checkAdd(3, "1,2");
        checkAdd(10, "1,2,4,3");
        checkAdd(6, "1\n2;3");
        checkAdd(3, "//[;]\n1;2");
        checkAdd(2, "1000,2");
        checkAdd(6, "//[;][%]\n1;2%3");
        checkAdd(6, "//[;*][%]\n1;*2%3");
    }

    private void checkAdd(int res, String val) {
        assertEquals(res, calculator.add(val));
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
