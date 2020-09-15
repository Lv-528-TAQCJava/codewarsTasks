package tests;

import com.ss.ita.kata.Seven;
import com.ss.ita.kata.implementation.rsavu98.SevenImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class LookBenefactorTest {
        private final Seven Impl7 = new SevenImpl();
        private double[] arr;
        private double navg;
        private double expected;

    public LookBenefactorTest(double[] arr, double navg, double expected) {
        this.arr = arr;
        this.navg = navg;
        this.expected = expected;
    }

    @Parameterized.Parameters()
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new double[]{14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0}, 90, 628},
                        {new double[]{14, 30, 5, 7, 9, 11, 15}, 92, 645},
                }
        );
    }

    @Test
    public void lookBenefactorTest() {
        assertEquals("Looking for a benefactor test", expected, Impl7.newAvg(arr, navg), 0.01f);
    }
}
