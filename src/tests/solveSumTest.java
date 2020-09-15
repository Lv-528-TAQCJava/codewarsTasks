package tests;

import static org.junit.Assert.*;

import com.ss.ita.kata.Five;
import com.ss.ita.kata.implementation.ProstoLeleka.FiveImpl; //change to test another author
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
/**
 *  Which x for that sum
 */
@RunWith(value = Parameterized.class)
public class solveSumTest {
    private Five Impl5 = new FiveImpl(); //probably this can be parametrized too
    private double m;
    private double expected;

    public solveSumTest(double m, double expected){
        this.m = m;
        this.expected = expected;
    }

    @Parameterized.Parameters(name= "{index}: solveSum({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {5.00, 6.417424305044e-01},
                        {6.00, 6.666666666667e-01},
                        {10.00, 7.298437881284e-01},
                        {13.00, 7.584573119507e-01}
                }
        );
    }
    @Test
    public void solveSumTest() {
        assertEquals("solveSum Test", expected, Impl5.solveSum(m), 1e-12);
    }
}
