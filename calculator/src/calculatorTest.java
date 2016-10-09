import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by VITTACH on 06.10.2016.
 */

public class calculatorTest {
    // @Test - ��� ���������, ������� ����������, ��� ����� ������ ���� ������ ��� ������������
    @Test
    public void AddTest_1coma2_3result() {
        calculate c = new calculate();
        // ���� ����� ������� ����������, ���� ��������� ������ ������������ ����� ������� �� 3
        assertEquals(c.Add("1,2"), 3);
    }

    @Test
    public void AddTest_2n7_9result() {
        calculate c = new calculate();
        // ���� ����� ������� ����������, ���� ��������� ������ ������������ ����� ������� �� 9
        assertEquals(c.Add("2\n7"), 9);
    }

    @Test
    @Ignore
    // ������� �������� �� ��������� Ignore - ��� �������, ��� ������ ���� ����� ��������������
    public void AddTest_2n_0result() {
        calculate c = new calculate();
        // ���� ����� ������� ����������, ���� ��������� ������ ������������ ����� ������� �� 0
        assertEquals(c.Add("2\n"), 8);
    }

    @Test
    public void AddTest_slashslashsemicolondotdotbackslashn_8semicolon1000dotdot_1008result() {
        calculate c = new calculate();
        // ���� ����� ������� ����������, ���� ��������� ����� ������������ ����� �������  1008
        assertEquals(c.Add("//;..\n8;1000.."), 1008);
    }

    @Test
    public void AddTest_slashslashsemicolonbackslashn_8semicolonsemicolon1001dotdot_8result() {
        calculate c = new calculate();
        // ���� ����� ������� ����������, ���� ��������� ����� ������������ ����� �������  8
        assertEquals(c.Add("//;\n8;;1001"),8);
    }

    @Test
    public void AddTest_negative_elements() {
        calculate calc = new calculate();
        RuntimeException exception = null;
        try {
            calc.Add("1,-20,-3\n-14,7\n");
        } catch (RuntimeException e) {
            exception = e;
        }
        org.junit.Assert.assertNotNull(exception);
        org.junit.Assert.assertEquals("Negatives not allowed: [-20, -3, -14]", exception.getMessage());
    }

    @Before
    public void testStarted() {
        System.out.println("Test Starting right now!");
    }

    @After
    public void testFinished() {
        System.out.println("Test Finished correctly");
    }
}