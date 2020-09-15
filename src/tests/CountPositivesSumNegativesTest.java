package tests;

import com.ss.ita.kata.Eight;

import com.ss.ita.kata.implementation.DenysSk.EightImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;


/**
 * Count of positives / sum of negatives
 */
@RunWith(value = Parameterized.class)
public class CountPositivesSumNegativesTest {
    private Eight Impl8 = new EightImpl(); //probably this can be parametrized too
    private int[] input;
    private int[] expected;

    public CountPositivesSumNegativesTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: CountPositivesSumNegatives({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}, new int[] {10, -65}},
                        {new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}, new int[] {8, -50}}
                }
        );
    }
    @Test
    public void CountPositivesSumNegativesTest() {
        assertArrayEquals("Count Positives Sum Negatives Test", expected, Impl8.countPositivesSumNegatives(input));
    }

}
