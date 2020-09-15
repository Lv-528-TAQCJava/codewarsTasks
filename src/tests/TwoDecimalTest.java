package tests;

import com.ss.ita.kata.Eight;
import com.ss.ita.kata.implementation.bodja.EightImplementation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TwoDecimalTest {

    private final Eight eightImplementation = new EightImplementation();
    private double value;
    private double expected;

    public TwoDecimalTest(double value, double expected) {
        this.value = value;
        this.expected = expected;
    }

    @Parameterized.Parameters(name= "{index}: twoDecimalPlaces({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {4.659725356, 4.66},
                        {12.854266, 12.85},
                        {50.102285, 50.10},
                        {0.00, 0.00}
                }
        );
    }

    @Test
    public void twoDecimalPlacesTest() {
        assertEquals("twoDecimalPlaces Test", expected, eightImplementation.twoDecimalPlaces(value), 0.0001f);
    }
}
