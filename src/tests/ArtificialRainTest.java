package tests;

import static org.junit.Assert.*;

import com.ss.ita.kata.Five;
import com.ss.ita.kata.implementation.meownjik.FiveImpl; //change to test another author
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
/**
 * Miles per gallon to kilometers per liter
 */
@RunWith(value = Parameterized.class)
public class ArtificialRainTest {
    private Five Impl5 = new FiveImpl(); //probably this can be parametrized too
    private int[] val;
    private int expected;

    public ArtificialRainTest(int[] val, int expected) {
        this.val = val;
        this.expected = expected;
    }

    @Parameterized.Parameters(name= "{index}: artificialRain({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new int[]{5}, 1},
                        {new int[]{1,2,1,2,1,2,1,3}, 3},
                        {new int[]{4,2,3,3,2,5,1,2}, 4},
                        {new int[]{2, 4, 7, 100, 3, 5, 256, 22, 1, 9, 4}, 5},
                        {new int[]{2, 4, 7, 100, 3, 5, 256, 22, 1, 9, 4, 4, 4, 4, 2}, 7}
                }
        );
    }
    @Test
    public void artificialRainTest() {
        assertEquals("mpgToKpm Test", expected, Impl5.artificialRain(val));
    }

}
