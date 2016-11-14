package nshumilov.lab1;

import org.junit.Assert;
import org.junit.Test;

public class TestSillyNumberAdder {

	@Test
	public void shouldHandleEmptyString(){
		testAdd("", 0);
	}

	@Test
	public void shouldHandleCommaSeparatedNumbers() {
		testAdd("4", 4);
		testAdd("5,2", 7);
		testAdd("3,5,7", 15);
	}

	@Test
	public void shouldHandleNewlineOrCommaSeparatedNumbers() {
		testAdd("1\n3", 4);
		testAdd("1\n6,3", 10);
		testAdd("3,5\n8", 16);
	}

	@Test
	public void shouldSupportCustomDelimiters(){
		testAdd("//;\n1;2", 3);
		testAdd("//-\n3-5-3", 11);
		testAdd("// \n2 1 4 6", 13);
	}

	@Test
	public void shouldIgnoreNumbersGreaterThan1000() {
		testAdd("5216,1", 1);
		testAdd("5,12414,3", 8);
		testAdd("2,4,6,2350", 12);
	}

	private void testAdd(String input, int expectedOutput){
		Assert.assertEquals(expectedOutput, SillyNumberAdder.add(input));
	}
}
