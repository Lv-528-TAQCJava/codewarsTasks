package tests;

import static org.junit.Assert.*;

import com.ss.ita.kata.Eight;
import com.ss.ita.kata.implementation.meownjik.EightImpl; //change to test another author
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
/**
 * Miles per gallon to kilometers per liter
 */
@RunWith(value = Parameterized.class)
public class MpgToKpmTest {
    private Eight Impl8 = new EightImpl(); //probably this can be parametrized too
    private float val;
    private float expected;

    public MpgToKpmTest(float val, float expected) {
        this.val = val;
        this.expected = expected;
    }

    @Parameterized.Parameters(name= "{index}: mpgToKPM({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {10f, 3.54f},
                        {20f, 7.08f},
                        {30f, 10.62f}
                }
        );
    }
    @Test
    public void mpgToKpmTest() {
        assertEquals("mpgToKpm Test", expected, Impl8.mpgToKPM(val), 0.001f);
    }

}
