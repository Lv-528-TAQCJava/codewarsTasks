package tests;

import static org.junit.Assert.*;

import com.ss.ita.kata.implementation.ilona.SevenImpl;
import org.junit.Test;
import com.ss.ita.kata.Seven;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class WhereIsHeTest {

    private final Seven seven = new SevenImpl();
    private int[] input;
    private int occurrences;

    public WhereIsHeTest(int[] input, int occurrences) {

        this.input = input;
        this.occurrences = occurrences;
    }

    @Parameterized.Parameters(name = "{index}:whereIsVasya({0}) =={1})")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 1, 1}, 2},
                {new int[]{5, 2, 3}, 3}}
        );

    }

    @Test
    public void whereIsHe() {
        assertEquals("Test Where is Vasya",occurrences,seven.whereIsHe(input[0], input[1], input[2]));
    }
}
