package com.zdorovets;
import static org.junit.Assert.*;
import org.junit.Test; 

public class Zdorovets_Lab1_calcTest {

	@Test
	public void testAddWithZeroArgs() {
		org.junit.Assert.assertEquals(0,Zdorovets_Lab1_calc.Add(""));
	}
	@Test
	public void testAddWithOneArgument() {
		org.junit.Assert.assertEquals(10,Zdorovets_Lab1_calc.Add("10"));
	}
		
	@Test
	public void testAddWithTwoArguments() {		
		org.junit.Assert.assertEquals(34,Zdorovets_Lab1_calc.Add("16,18"));
	}
	
	@Test
	public void testAddWithThreeArguments() {		
		org.junit.Assert.assertEquals(50,Zdorovets_Lab1_calc.Add("16,14,20"));
	}
	
	@Test
	public void testAddWithFourArguments() {		
		org.junit.Assert.assertEquals(60,Zdorovets_Lab1_calc.Add("16,14,20,10"));
	}
	
	@Test
	public void testAddWithNewLines() {		
		org.junit.Assert.assertEquals(60,Zdorovets_Lab1_calc.Add("16,14\n20\n10"));
	}
	
    @Test
	public void testDelimiter() {
	    org.junit.Assert.assertEquals(33, Zdorovets_Lab1_calc.Add("//;\n11;22"));
	}
    
    @Test(expected = RuntimeException.class)
    public final void testNegativeException() {
    	Zdorovets_Lab1_calc.Add("3,-6,15,18,46,33");
    }
    @Test
    public final void testCorrectNegativeList() {
        RuntimeException exception = null;
        try {
        	Zdorovets_Lab1_calc.Add("3,-14,5,-9,25,-16");
        } catch (RuntimeException e) {
            exception = e;
        }
        org.junit.Assert.assertNotNull(exception);
        org.junit.Assert.assertEquals("Negatives not allowed: [-14, -9, -16]", exception.getMessage());
    }
	
	@Test(expected = NumberFormatException.class)
	public void testNumberFormatException() {		
		Zdorovets_Lab1_calc.Add("1,a");	
	}
}
