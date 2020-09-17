package tests;

import com.ss.ita.kata.Eight;
import com.ss.ita.kata.implementation.ilona.EightImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(value = Parameterized.class)
public class ToSquareOrNotTest {
    private final Eight Impl8 = new EightImpl();
    private int [] expectedArray;
    private int [] input;

    public ToSquareOrNotTest(int[] expectedArray, int[] input) {
        this.expectedArray = expectedArray;
        this.input = input;
    }
    @Parameterized.Parameters(name ="{index}:squareOrSquareRoot({0}) =={1})")
    public static  Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{
                        {new int[]{4, 3, 9, 7, 2, 1}, new int[]{2, 9, 3, 49, 4, 1}}
                }
        );
    }
        @Test
        public void squareOrSquareRoot() {
            assertArrayEquals("Square or not to square test",expectedArray,Impl8.squareOrSquareRoot(input));
        }
}
