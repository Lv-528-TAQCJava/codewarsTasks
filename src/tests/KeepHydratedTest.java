package tests;

import static org.junit.Assert.*;
import com.ss.ita.kata.Eight;
import com.ss.ita.kata.implementation.udzhas.EightImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;

@RunWith(value= Parameterized.class)
public class KeepHydratedTest {

    private final Eight Impl8 = new EightImpl();
    private final double liters;
    private final double expected;

    public KeepHydratedTest(double liters, double expected) {
        this.liters=liters;
        this.expected=expected;
    }

    @Parameterized.Parameters(name = "{index}: liters({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {3, 1},
                        {6.7, 3},
                        {11.8, 5}
                }
        );
    }
    @Test
    public void keepHydratedTest() {
        assertEquals("Keep Hydrated Test",expected,Impl8.liters(liters), 0.0001);
    }
}
