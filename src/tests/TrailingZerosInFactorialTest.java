package tests;

import com.ss.ita.kata.Five;

import com.ss.ita.kata.implementation.DenysSk.FiveImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;


/**
 * Trailing Zeros In Factorial
 */
@RunWith(value = Parameterized.class)
public class TrailingZerosInFactorialTest {
    private Five Impl5 = new FiveImpl();
    private int n;
    private int expected;

    public TrailingZerosInFactorialTest(int n, int expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: TrailingZerosInFactorialTest({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {0, 0},
                        {6, 1},
                        {14, 2},
                }
        );
    }
    @Test
    public void trailingZerosInFactorialTest() {
        assertEquals("Build a pile of Cubes Test", expected, Impl5.zeros(n));
    }

}
