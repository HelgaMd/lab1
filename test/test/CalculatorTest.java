package test; /**
 * Created by Денис on 18.10.2016.
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static ru.labs.Calculator.*;
import static ru.labs.Calculator.add;

public class CalculatorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testReturnZeroEmptyString(){
        assertEquals(0, add(""));
        thrown.expect(IllegalArgumentException.class);
        add(null);
    }
    @Test
    public void testReturnOneString(){
        assertEquals(123, add("123"));
    }

    @Test
    public void testReturnTwoSumString(){
        assertEquals(33, add("21,12"));
    }

    @Test
    public void testReturnThreeSumString(){
        assertEquals(6, add("1,2,3"));
    }

    @Test
    public void testReturnFourSumString(){
        assertEquals(90, add("11,29,6,44"));
    }


    @Test
    public void testReturnNewLinesSumString()  {
        assertEquals(10, add("1,2\n3\n4"));
        thrown.expect(IllegalStateException.class);
        add("1,2,\n3");
    }

    @Test
    public void testReturnSumStringAndDelimiter(){
        assertEquals(46, add("//;_\n12;_22;_12\n"));
    }

    //point 7,9
    @Test
    public void testAnyLengthDelimeter() {
        assertEquals(add("//[delim]\n12delim12delim12"), 36);
    }

    //point 8
    @Test
    public void testMultipleDelimeters() {
        assertEquals(add("//[first][second][third]\n3first4second5\n14third11"),37);
    }
}