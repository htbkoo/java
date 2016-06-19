package online.codewars._6kyu;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static online.codewars._6kyu.SurroundingPrimesForAValue.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 18 Jun 2016
 */
@RunWith(Parameterized.class)
public class SurroundingPrimesForAValueTest {

    private int fInput;
    private int fIndex;
    private int fExpected;

    @Parameterized.Parameters(name = "{index}: BeforeAfterPrimes.primeBefAft({0})[{1}]={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{3, 0, 2},
                new Object[]{3, 1, 5},
                new Object[]{4, 0, 3},
                new Object[]{4, 1, 5},
                new Object[]{5, 0, 3},
                new Object[]{5, 1, 7},
                new Object[]{6, 0, 5},
                new Object[]{6, 1, 7},
                new Object[]{7, 0, 5},
                new Object[]{7, 1, 11},
                new Object[]{8, 0, 7},
                new Object[]{8, 1, 11},
                new Object[]{97, 0, 89},
                new Object[]{97, 1, 101},
                new Object[]{100, 0, 97},
                new Object[]{100, 1, 101},
                new Object[]{101, 0, 97},
                new Object[]{101, 1, 103},
                new Object[]{120, 0, 113},
                new Object[]{120, 1, 127},
                new Object[]{130, 0, 127},
                new Object[]{130, 1, 131}
        );
    }

    public SurroundingPrimesForAValueTest(int fInput, int fIndex, int fExpected) {
        this.fInput = fInput;
        this.fIndex = fIndex;
        this.fExpected = fExpected;
    }

    @Test
    public void shouldFindPrimeBefAft() throws Exception {
        assertEquals(fExpected, BeforeAfterPrimes.primeBefAft(fInput)[fIndex]);
    }

    @Ignore
    @Test
    public void test() {
        System.out.println("Fixed Tests");
        assertEquals(89, BeforeAfterPrimes.primeBefAft(97)[0]);
        assertEquals(101, BeforeAfterPrimes.primeBefAft(97)[1]);
        assertEquals(97, BeforeAfterPrimes.primeBefAft(100)[0]);
        assertEquals(101, BeforeAfterPrimes.primeBefAft(100)[1]);
        assertEquals(97, BeforeAfterPrimes.primeBefAft(101)[0]);
        assertEquals(103, BeforeAfterPrimes.primeBefAft(101)[1]);
        assertEquals(113, BeforeAfterPrimes.primeBefAft(120)[0]);
        assertEquals(127, BeforeAfterPrimes.primeBefAft(120)[1]);
        assertEquals(127, BeforeAfterPrimes.primeBefAft(130)[0]);
        assertEquals(131, BeforeAfterPrimes.primeBefAft(130)[1]);
    }
}