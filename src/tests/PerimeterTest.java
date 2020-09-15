package tests;

import com.ss.ita.kata.Five;
import com.ss.ita.kata.implementation.solomiazh.FiveImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class PerimeterTest {

    private final Five Impl5 = new FiveImpl();
    private final BigInteger val;
    private final BigInteger expected;

    public PerimeterTest(BigInteger val, BigInteger expected) {
        this.val = val;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: SumFctTest({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {BigInteger.valueOf(5), (BigInteger.valueOf(80))},
                {BigInteger.valueOf(7), (BigInteger.valueOf(216))},
                {BigInteger.valueOf(30), (BigInteger.valueOf(14098308))},
        });
    }

    @Test
    public void perimeterTest() {
        assertEquals("solveSum", expected, Impl5.perimeter(val));
    }
}
