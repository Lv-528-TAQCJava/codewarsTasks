package tests;

import com.ss.ita.kata.Six;
import com.ss.ita.kata.implementation.rsavu98.SixImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class HelpBooksellerTest {
    private final Six Impl6 = new SixImpl();
    private final String[] lstOfArt;
    private final String[] lstOf1stLetter;
    private final String expected;

    public HelpBooksellerTest(String[] lstOfArt, String[] lstOf1stLetter, String expected) {
        this.lstOfArt = lstOfArt;
        this.lstOf1stLetter = lstOf1stLetter;
        this.expected = expected;
    }

    @Parameterized.Parameters()
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"},
                        new String[]{"A", "B"},
                        "(A : 200) - (B : 1140)"}});
                }

    @Test
    public void helpBooksellerTest() {
        assertEquals("Help the bookseller test", expected, Impl6.stockSummary(lstOfArt, lstOf1stLetter));
    }
}
