package tests;

import com.ss.ita.kata.Six;

import com.ss.ita.kata.implementation.DenysSk.SixImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;


/**
 * Build a pile of Cubes
 */
@RunWith(value = Parameterized.class)
public class BuildapileofCubesTest {
    private Six Impl6 = new SixImpl();
    private long m;
    private long expected;

    public BuildapileofCubesTest(long m, long expected) {
        this.m = m;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: BuildapileofCubes({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {4183059834009L, 2022},
                        {24723578342962L, -1},
                        {135440716410000L, 4824},
                        {40539911473216L, 3568}
                }
        );
    }
    @Test
    public void BuildapileofCubesTest() {
        assertEquals("Build a pile of Cubes Test", expected, Impl6.findNb(m));
    }

}
