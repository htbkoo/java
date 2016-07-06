package online.codewars._4kyu;

import online.codewars._4kyu.DecimalToAnyRationalOrIrrationalBaseConverter.Converter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Hey on 6 Jul 2016
 */
@RunWith(Parameterized.class)
public class DecimalToAnyRationalOrIrrationalBaseConverterTest {
    private final double n;
    private final int decimals;
    private final double base;
    private final String fExpected;

    @Parameterized.Parameters(name = "[{0}]Converter.converter({1},{2},{3})={4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{"example1", 13, 0, Math.PI, "103"},
                new Object[]{"example2", 13, 3, Math.PI, "103.010"},
                new Object[]{"example3", -13, 0, 2, "-1101"},
                new Object[]{"my case 1", Math.PI, 0, Math.PI, "10"},
                new Object[]{"my case 2", Math.PI, 2, Math.PI, "10.00"},
                new Object[]{"my case 3", Math.PI, 2, Math.PI+0.0001, "3.01"},
                new Object[]{"my case 4", 1/Math.PI, 3, Math.PI, "0.100"},
                new Object[]{"my case 5", 1/Math.PI, 1, Math.PI, "0.1"},
                new Object[]{"my case 5", 1/Math.PI, 0, Math.PI, "0"},
                new Object[]{"discourse case 1", 1e-3, 5, 10, "0.00100"}
        );
    }

    public DecimalToAnyRationalOrIrrationalBaseConverterTest(@SuppressWarnings("UnusedParameters") String name, double n, int decimals, double base, String fExpected) {
        this.n = n;
        this.decimals = decimals;
        this.base = base;
        this.fExpected = fExpected;
    }


    @Test
    public void shouldConvert() throws Exception {
        assertThat(Converter.converter(n, decimals, base), is(fExpected));
    }

    @Ignore
    @Test
    public void test1() {
        assertEquals("103", Converter.converter(13, 0, Math.PI));
    }
}