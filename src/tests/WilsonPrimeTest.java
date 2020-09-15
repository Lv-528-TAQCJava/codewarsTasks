package tests;

import static org.junit.Assert.*;

import com.ss.ita.kata.Eight;
import com.ss.ita.kata.implementation.ProstoLeleka.EightImpl; //change to test another author
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
/**
 * Wilson primes
 */
@RunWith(value = Parameterized.class)
public class WilsonPrimeTest {
    private Eight Impl8 = new EightImpl(); //probably this can be parametrized too
    private double n;
    private boolean expected;

    public WilsonPrimeTest(double n, boolean expected){
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters(name= "{index}: WilsonPrimes({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {5, true},
                        {13, true},
                        {563, true}
                }
        );
    }
    @Test
    public void WilsonPrimesTest() {
        assertEquals("WilsonPrimes Test", expected, Impl8.amIWilson(n));
    }
}
