package tests;

import static org.junit.Assert.*;

import com.ss.ita.kata.Five;
import com.ss.ita.kata.Six;
import com.ss.ita.kata.implementation.ProstoLeleka.SixImpl; //change to test another author
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
/**
 * Floating-point Approximation
 */
@RunWith(value = Parameterized.class)
public class FloatingPointApproximationTest {
    private Six Impl6 = new SixImpl(); //probably this can be parametrized too
    private double n;
    private double expected;

    public FloatingPointApproximationTest(double n, double expected){
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters(name= "{index}: FloatingPointApproximation({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5.0e-06, 2.499996875007812e-06},
                {2.4e-07, 1.1999999280000085e-07},
                {2.1e-11, 1.0499999999944874e-11},
                {0.00017, 8.499638780702988e-05}
                }
        );
    }
    @Test
    public void FloatingPointApproximationTest() {
        assertEquals("FloatingPointApproximation Test", expected, Impl6.f(n), 1e-12);
    }
}
