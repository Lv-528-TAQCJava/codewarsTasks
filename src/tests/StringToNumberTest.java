package tests;

import com.ss.ita.kata.Eight;
import com.ss.ita.kata.implementation.solomiazh.EightImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class StringToNumberTest {
    private final Eight Impl8 = new EightImpl();
    private final String value;
    private final int expected;

    public StringToNumberTest(String value, int expected) {
        this.value = value;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: stringToNumber({0}) == {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"-18", -18},
                        {"2560", 2560},
                        {"0", 0},
                        {"1457", 1457},
                }
        );
    }

    @Test
    public void stringToNumberTest() {
        assertEquals("StringToNumberTest", expected, Impl8.stringToNumber(value));
    }
}

