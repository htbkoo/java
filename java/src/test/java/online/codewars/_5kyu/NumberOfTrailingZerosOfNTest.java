package online.codewars._5kyu;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Hey on 15 May 2016
 */
public class NumberOfTrailingZerosOfNTest {
    @Test
    public void testZeros() throws Exception {
        assertThat(NumberOfTrailingZerosOfN.zeros(0), is(0));
        assertThat(NumberOfTrailingZerosOfN.zeros(6), is(1));
        assertThat(NumberOfTrailingZerosOfN.zeros(14), is(2));
    }
}