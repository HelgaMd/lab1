package nshumilov.lab1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSillyNumberAdder {
	@Test
	public void shouldHandleEmptyString() {
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
	public void shouldSupportCustomDelimiters() {
		testAdd("//;\n1;2", 3);
		testAdd("//\t\n3\t5\t3", 11);
		testAdd("// \n2 1 4 6", 13);
	}

	@Test
	public void shouldThrowNegativesNotAllowedException() {
		testAdd("1,-2,3", NegativesNotAllowedException.class, "Negatives not allowed. Got: -2");
		testAdd("-2,-3,5", NegativesNotAllowedException.class, "Negatives not allowed. Got: -2, -3");
		testAdd("0,3,-5,-2", NegativesNotAllowedException.class, "Negatives not allowed. Got: -5, -2");
	}

	@Test
	public void shouldIgnoreNumbersGreaterThan1000() {
		testAdd("5216,1", 1);
		testAdd("5,12414,3", 8);
		testAdd("2,4,6,2350", 12);
	}

	@Test
	public void shouldSupportMultiCharDelimiters() {
		testAdd("//[***]\n1***2***3", 6);
		testAdd("//[yomama]\n42yomama2yomama3", 47);
		testAdd("//[@%!]\n10@%!2@%!3", 15);
	}

	@Test
	public void shouldSupportMultipleDelimiters() {
		testAdd("//[*][%]\n1*2%3", 6);
		testAdd("//[\t][_]\n5_1\t3",9);
		testAdd("//[a][b][c]\n3c2a3b1", 9);
	}

	@Test
	public void shouldSupportMultipleMultiCharDelimiters() {
		testAdd("//[stop][hammertime]\n12hammertime3stop1",16);
		testAdd("//[!@][#$][$%]\n100!@42#$1",143);
		testAdd("//[???][!!!]\n1!!!2???3!!!4!!!5", 15);
	}

	private void testAdd(String input, int expectedOutput) {
		assertEquals(expectedOutput, SillyNumberAdder.add(input));
	}

	private void testAdd(String input, Class<? extends Exception> expectedExceptionClass, String expectedMessage) {
		try {
			SillyNumberAdder.add(input);
		} catch (Exception e) {
			assertEquals(expectedExceptionClass, e.getClass());
			assertEquals(expectedMessage, e.getMessage());
		}
	}
}
