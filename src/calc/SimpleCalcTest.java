package calc;
import static org.junit.Assert.*;

import org.junit.Test;


public class SimpleCalcTest {

	@Test
	public void addTest() throws NegativeExc {
		SimpleCalc testObj = new SimpleCalc();
		
		assertEquals(testObj.add(""), 0);
		assertEquals(testObj.add("1"), 1);
		assertEquals(testObj.add("1,2"), 3);
		assertEquals(testObj.add("1,2,3,4,5"), 15);
		assertEquals(testObj.add("1\n2,3"), 6);
		assertEquals(testObj.add("//;\n1;2;4"), 7);
		assertEquals(testObj.add("//.\n5.5"), 10);
		assertEquals(testObj.add("//[.][***][;]\n2.2***3;5"), 12);
		assertEquals(testObj.add("//[.][***][][;]\n2.2***3;51"), 13);
	}

}
