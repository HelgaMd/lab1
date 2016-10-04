/**
 * Created by Aqru on 04.10.16.
 * Unit tests for add method.
 */
class calcTest extends GroovyTestCase {
    void testAdd() {
        def test_add = new calc()
        assertEquals(test_add.add(""), 0)

        assertEquals(test_add.add("1"), 1)

        assertEquals(test_add.add("1,2,3"), 6)

        assertEquals(test_add.add("1,2,3,3,3,5,6,17"), 40)

        assertEquals(test_add.add("1\n2,3"), 6)

        assertEquals(test_add.add("//[;]\n1;2;3"), 6)

        assertEquals(test_add.add("1001,2001,3"), 3)

        assertEquals(test_add.add("//[;l;]\n1;l;2;l;3"), 6)

        assertEquals(test_add.add("//[;l;][,]\n1,2;l;3"), 6)

        assertEquals(test_add.add("//[;l;][hhh][,]\n1;l;2hhh3"), 6)

        assertEquals(test_add.add("//[;l;]\n1;l;2;l;-3"), -1)

    }
}
