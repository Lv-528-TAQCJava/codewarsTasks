package tests;


import com.ss.ita.kata.Five;
import com.ss.ita.kata.implementation.bodja.FiveImplementation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class SmallestTest {

    private Five fiveImplementation = new FiveImplementation();
    private long value;
    private String expectedResult;

    public SmallestTest(long value, String expectedResult) {
        this.value = value;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name= "{index}: smallest({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {261235, "[126235, 2, 0]"},
                        {209917, "[29917, 0, 1]"},
                        {285365, "[238565, 3, 1]"},
                        {269045, "[26945, 3, 0]"},
                        {296837, "[239687, 4, 1]"},
                        {100000, "[1, 0, 5]"}
                }
        );
    }

    @Test
    public  void smallestTest(){
        assertEquals("seriesSum Test", expectedResult, Arrays.toString(fiveImplementation.smallest(value)));
    }
}
