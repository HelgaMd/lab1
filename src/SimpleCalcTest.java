import static org.junit.Assert.*;

import org.junit.Test;


public class SimpleCalcTest {

	@Test
	public void AddTest() throws NegativeExc {
		SimpleCalc testObj = new SimpleCalc();
		
		assertEquals(testObj.Add(""), 0);
		assertEquals(testObj.Add("1"), 1);
		assertEquals(testObj.Add("1,2"), 3);
		assertEquals(testObj.Add("1,2,3,4,5"), 15);
		assertEquals(testObj.Add("1\n2,3"), 6);
		assertEquals(testObj.Add("//;\n1;2;4"), 7);
		assertEquals(testObj.Add("//.\n5.5"), 10);
		assertEquals(testObj.Add("//[.][***][;]\n2.2***3;5"), 12);
		assertEquals(testObj.Add("//[.][***][][;]\n2.2***3;51"), 13);
	}

}
