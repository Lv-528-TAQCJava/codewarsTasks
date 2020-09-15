package tests;

import com.ss.ita.kata.Eight;
import com.ss.ita.kata.implementation.rsavu98.EightImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class VolCuboidTest {
    private final Eight Impl8 = new EightImpl();
    private double length;
    private double width;
    private double height;
    private double expected;

    public VolCuboidTest(double length, double width, double height, double expected) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.expected = expected;
    }

    @Parameterized.Parameters()
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {1, 2, 2, 4},
                        {6.3, 2, 5, 63}
                }
        );
    }

    @Test
    public void volCuboidTest() {
        assertEquals("VolCuboid test", expected, Impl8.getVolumeOfCuboid(length, width, height), 0.01f);
    }
}
