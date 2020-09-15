package tests;

import com.ss.ita.kata.Six;
import com.ss.ita.kata.implementation.solomiazh.SixImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)

public class EasyBalTest {


    private static final Object input = "1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n" +
            "123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00,?;\n129 Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?";
    private static final Object output = "Original Balance: 1233.00\\r\\n125 Hardware 24,80 Balance 1208,20\\r\\n123 Flowers 93,50 Balance 1114,70\\r\\n127 " +
            "Meat 120,90 Balance 993,80\\r\\n120 Picture 34,00 Balance 959,80\\r\\n124 Gasoline 11,00 Balance 948,80\\r\\n123 Photos 71,40 Balance 877,40\\r\\n122 " +
            "Picture 93,50 Balance 783,90\\r\\n132 " +
            "Tyres 19,00 Balance 764,90\\r\\n129 Stamps 13,60 Balance 751,30\\r\\n129 Fruits 17,60 Balance 733,70\\r\\n129 Market 128,00 Balance 605,70\\r\\n121 " +
            "Gasoline 13,60 Balance 592,10\\r\\nTotal expense  640,90\\r\\nAverage expense  53,41";
    private final Six Impl6 = new SixImpl();
    private final String value;
    private final String expected;

    public EasyBalTest(String value, String expected) {
        this.value = value;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: stringToNumber({0}) == {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {input, output},

                }
        );
    }


    @Test
    public void easyBalTest() {
        assertEquals("EasyBalTest", expected, Impl6.balance(value));
    }
}


