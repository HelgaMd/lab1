package test;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.*;
import static ru.labs.util.ParseUtil.*;
import static ru.labs.util.ParseUtil.parseDelimeters;

/**
 * Created by nkurtushin on 02.11.16.
 */
public class ParseUtilTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testParseDelimeters() {
        assertEquals(parseDelimeters("[$][asd][delim]"), Arrays.asList("$","asd", "delim"));
    }

    @Test
    public void testRegexpForMultipleDelimeters() {
        assertEquals(getRegExpForMultipleDelimeters(Arrays.asList("$","asd", "delim")),"(\\Q$\\E)|(\\Qasd\\E)|(\\Qdelim\\E)|\n");
    }

    @Test
    public void testCheckDelimeterWithEndOfLine() {
        try {
            checkDelimeterWithEndOfLine("1;2\n3,4", Arrays.asList(";", ","));
        }catch (IllegalStateException e) {
            fail();
        }
        thrown.expect(IllegalStateException.class);
        checkDelimeterWithEndOfLine("1;\n2,3,\n4", Arrays.asList(";", ","));
    }

    @Test
    public void testEndsWithOrStartsWith() {
        assertTrue(endsWithOrStartsWith(",234", Arrays.asList(",", ".", "_")));
        assertFalse(endsWithOrStartsWith(",234", Arrays.asList(".", "_")));
    }
}
