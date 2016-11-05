package com.etu.etitkov;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author etitkov
 */
public class CalculatorTest {

    private PositiveNumberCalculator calculator;

    @Before
    public void setUp() {
        this.calculator = new PositiveNumberCalculator();
    }

    @Test
    public void testSimpleAdd() throws NegativeValueException {
        //test simple add
        int result = calculator.add("1,2");
        Assert.assertEquals(3,result);
        //test empty add
        result = calculator.add("");
        Assert.assertEquals(0,result);
        //test single value
        result = calculator.add("1");
        Assert.assertEquals(1,result);
        //test default delimiter
        result = calculator.add("1\n2,3");
        Assert.assertEquals(6,result);
        //test wrong string
        result = calculator.add("1,\n");
        Assert.assertEquals(1,result);
        //test default delimiters
        result = calculator.add("123,3912,1\n4");
        Assert.assertEquals(128,result);
        //test provided delimiters
        result = calculator.add("//[:][%][;][\n]\n123;;;;;;4%%%%3912,%%%%%5:1\n4");
        Assert.assertEquals(137,result);
    }



}
