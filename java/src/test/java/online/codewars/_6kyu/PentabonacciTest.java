package online.codewars._6kyu;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 18 Jun 2016
 */
@RunWith(Parameterized.class)
public class PentabonacciTest {

    private long fInput;
    private long fExpected;

    @Parameterized.Parameters(name = "{index}: Pentabonacci.countOddPentaFib({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{0, 0},
                new Object[]{1, 1},
                new Object[]{2, 1},
                new Object[]{3, 1},
                new Object[]{4, 1},
                new Object[]{5, 1},
                new Object[]{10, 3},
                new Object[]{15, 5},
                new Object[]{45, 15},
                new Object[]{68, 23},
                new Object[]{76, 25},
                new Object[]{100, 33},
                new Object[]{121, 40}
        );
    }

    public PentabonacciTest(long fInput, long fExpected) {
        this.fInput = fInput;
        this.fExpected = fExpected;
    }

    @Test
    public void shouldCountOddPentaFib() throws Exception {
        testing(Pentabonacci.countOddPentaFib(fInput), fExpected);
    }

    private static void testing(long actual, long expected) {
        assertEquals(expected, actual);
    }

    //    Ignoring given fixed test which is not parameterized
    @Ignore
    @Test
    public void test1() {
        System.out.println("Fixed Tests: countOddPentaFib, low values");
        long[] lstI = new long[]{45, 68, 76, 100, 121};
        long[] resultsI = new long[]{15, 23, 25, 33, 40};
        for (int i = 0; i <= 4; i++) {
            testing(Pentabonacci.countOddPentaFib(lstI[i]), resultsI[i]);
        }
    }
}