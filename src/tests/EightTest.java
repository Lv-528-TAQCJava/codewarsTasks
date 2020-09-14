package tests;

import static org.junit.Assert.*;

import com.ss.ita.kata.Eight;
import com.ss.ita.kata.implementation.meownjik.EightImpl; //change to test another author
import org.junit.Test;

public class EightTest {
    private Eight Impl8 = new EightImpl();
    /**
     * Miles per gallon to kilometers per liter
     */
    @Test
    public void mpgToKPMTest() {
        /*
        I'm not sure whether it's better to create many test methods for the task or just call many asserts.
        Probably we should have created separate test class for each task...
         */
        assertEquals("mpgToKPM(10) == 3.54f", 3.54f, Impl8.mpgToKPM(10), 0.001f);
        assertEquals("mpgToKPM(20) == 7.08f", 7.08f, Impl8.mpgToKPM(20), 0.001f);
        assertEquals("mpgToKPM(30) == 10.62f", 10.62f, Impl8.mpgToKPM(30), 0.001f);
    }

}
