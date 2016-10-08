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
    public void slash_slash_semicolon_dot_dot_backslash_n__8semicolon1000dotdot_1008result() {
        calculate c = new calculate();
        // ���� ����� ������� ����������, ���� ��������� ������ ������������ ����� ������� �� 1008
        assertEquals(c.Add("//;..\n8;1000.."), 1008);
    }

    @Before
    public void testStarted() {
        System.out.println("Test Started!");
    }

    @After
    public void testFinished() {
        System.out.println("Test Finished");
    }
}