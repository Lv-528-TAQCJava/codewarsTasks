package tests;

import com.ss.ita.kata.Eight;
import com.ss.ita.kata.implementation.udzhas.EightImpl;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;


@RunWith(value = Parameterized.class)
public class DivisibleByTest {

    private final Eight Impl8 = new EightImpl();
    private final int[] nums;
    private final int div;
    private final int[] expected;

    public DivisibleByTest(int[] nums, int div, int[] expected) {
        this.nums=nums;
        this.div=div;
        this.expected=expected;
    }

    /**
     *
     *
     *
     * @Parameterized.Parameters(name = "{index} : divisibleBy({0}) == {1}")
     * public static Iterable<Object[]> data(){
     *     return Arrays.asList(new Object[][]{
     *                     {(new int[]{1, 2, 3, 4, 5, 6}),{2, 4, 6}}
     *             }
     *
     *     );
     * }
     */

}
