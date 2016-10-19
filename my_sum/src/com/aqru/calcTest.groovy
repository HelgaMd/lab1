package com.aqru
/**
 * Created by Aqru on 04.10.16.
 * Unit tests for add method.
 */
class calcTest extends GroovyTestCase {
    void testAdd() {
        def test_add = new Calc()
        GroovyTestCase.assertEquals(test_add.add(""), 0)

        GroovyTestCase.assertEquals(test_add.add("1"), 1)

        GroovyTestCase.assertEquals(test_add.add("1,2,3"), 6)

        GroovyTestCase.assertEquals(test_add.add("1,2,3,3,3,5,6,17"), 40)

        GroovyTestCase.assertEquals(test_add.add("1\n2,3"), 6)

        GroovyTestCase.assertEquals(test_add.add("//[;]\n1;2;3"), 6)

        GroovyTestCase.assertEquals(test_add.add("1001,2001,3"), 3)

        GroovyTestCase.assertEquals(test_add.add("//[;l;]\n1;l;2;l;3"), 6)

        GroovyTestCase.assertEquals(test_add.add("//[;l;][,]\n1,2;l;3"), 6)

        GroovyTestCase.assertEquals(test_add.add("//[;l;][hhh][,]\n1;l;2hhh3"), 6)

        try {
            test_add.add("//[;l;]\n1;l;2;l;-3");
        }
        catch (SubZero e){
            assertEquals("Negatives not allowed. -3 ", e.message)
        }

    }
}
