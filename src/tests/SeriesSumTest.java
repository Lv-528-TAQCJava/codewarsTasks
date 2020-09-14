package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import com.ss.ita.kata.Seven;
import com.ss.ita.kata.implementation.meownjik.SevenImpl; //change to test another author
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Sum of the first nth term of Series
 */
@RunWith(value = Parameterized.class)
public class SeriesSumTest {
    private Seven Impl7 = new SevenImpl();
    private int val;
    private String expected;

    public SeriesSumTest(int val, String expected) {
        this.val = val;
        this.expected = expected;
    }

    @Parameterized.Parameters(name= "{index}: seriesSum({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {5, "1.57"},
                        {9, "1.77"},
                        {15, "1.94"}
                }
        );
    }
    @Test
    public void seriesSumTest() {
        assertEquals("seriesSum Test", expected, Impl7.seriesSum(val));
    }
}
