package tests;

import com.ss.ita.kata.Six;
import com.ss.ita.kata.implementation.udzhas.SixImpl;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class NBATest {
    private Six Impl6 = new SixImpl();
    private String resSheet;
    private String toFind;
    private String expected;

    public NBATest(String resSheet, String toFind, String expected) {
        this. resSheet = resSheet;
        this.toFind = toFind;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index} : nbaCup({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {}
        });
    }
}
