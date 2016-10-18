package com.zdorovets;
import org.junit.Assert;
import org.junit.Test; 
  
public class Zdorovets_Lab1_calcTest {

	@Test
	public void testAddWithZeroArgs() throws NumberFormatException, NegativeException {
		Assert.assertEquals(0,Zdorovets_Lab1_calc.add(""));
	}
	@Test
	public void testAddWithOneArgument() throws NumberFormatException, NegativeException {
		Assert.assertEquals(10,Zdorovets_Lab1_calc.add("10"));
	}
		
	@Test
	public void testAddWithTwoArguments() throws NumberFormatException, NegativeException {		
		Assert.assertEquals(34,Zdorovets_Lab1_calc.add("16,18"));
	}
	
	@Test
	public void testAddWithThreeArguments() throws NumberFormatException, NegativeException {		
		Assert.assertEquals(50,Zdorovets_Lab1_calc.add("16,14,20"));
	}
	
	@Test
	public void testAddWithFourArguments() throws NumberFormatException, NegativeException {		
		Assert.assertEquals(60,Zdorovets_Lab1_calc.add("16,14,20,10"));
	}
	
	@Test
	public void testAddWithNewLines() throws NumberFormatException, NegativeException {		
		Assert.assertEquals(60,Zdorovets_Lab1_calc.add("16,14\n20\n10"));
	}
	
    @Test
	public void testOneShortDelimiter() throws NumberFormatException, NegativeException {
	    Assert.assertEquals(33, Zdorovets_Lab1_calc.add("//;\n11;22"));
	}
    
    @Test
	public void testOneLongDelimiter() throws NumberFormatException, NegativeException {
	    Assert.assertEquals(6, Zdorovets_Lab1_calc.add("//[---]\n1---2---3"));
	}
    
    @Test
	public void testTwoShortDelimiters() throws NumberFormatException, NegativeException {
	    Assert.assertEquals(6, Zdorovets_Lab1_calc.add("//[-][=]\n1-2=3"));
	}
    
    @Test
	public void testTwoLongDelimiters() throws NumberFormatException, NegativeException {
	    Assert.assertEquals(6, Zdorovets_Lab1_calc.add("//[---][==]\n1---2==3"));
	}
    
    @Test(expected = NegativeException.class)
    public final void testNegativeException() throws NumberFormatException, NegativeException {
			Zdorovets_Lab1_calc.add("3,-6,15,18,46,33");
    }
    @Test
    public final void testCorrectNegativeList() {
    	NegativeException exception = null;
        try {
        	Zdorovets_Lab1_calc.add("3,-14,5,-9,25,-16");
        } catch (NegativeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Negatives not allowed: [-14, -9, -16]", exception.getMessage());
    }
    
    @Test
    public final void testOver1000() throws NumberFormatException, NegativeException {
    	Assert.assertEquals(1+1000+2, Zdorovets_Lab1_calc.add("1,1000,1001,2000,2"));
    }
	
	@Test(expected = NumberFormatException.class)
	public void testNumberFormatException() throws NumberFormatException, NegativeException {		
			Zdorovets_Lab1_calc.add("1,a");
	}
}
