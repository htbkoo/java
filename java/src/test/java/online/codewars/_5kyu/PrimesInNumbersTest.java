package online.codewars._5kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hey on 9 Jun 2016
 */
public class PrimesInNumbersTest {
    @Test
    public void testPrimeDecompOne() {
        int lst = 7775460;
        assertEquals(
                "(2**2)(3**3)(5)(7)(11**2)(17)",
                PrimesInNumbers.PrimeDecomp.factors(lst));
    }
}